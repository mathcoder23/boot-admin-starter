package com.pettyfox.platform_example.web.oauth2;

import com.pettyfox.platform_example.web.oauth2.auth.AuthServiceImpl;
import com.pettyfox.platform_example.web.oauth2.auth.username.UsernameAuthServiceImpl;
import com.pettyfox.platform_example.web.oauth2.auth.username.UsernameTokenGranter;
import com.pettyfox.platform_example.web.oauth2.handler.AuthExceptionEntryPoint;
import com.pettyfox.platform_example.web.oauth2.handler.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class OAuth2ServerConfig {

    private static final String DEMO_RESOURCE_ID = "order";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Resource
        private AuthExceptionEntryPoint authExceptionEntryPoint;
        @Resource
        private CustomAccessDeniedHandler customAccessDeniedHandler;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
            resources.authenticationEntryPoint(authExceptionEntryPoint)
                    .accessDeniedHandler(customAccessDeniedHandler);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    // Since we want the protected resources to be accessible in the UI as well we need
                    // session creation to be allowed (it's disabled by default in 2.0.6)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests().antMatchers(
                    "/webjars/**",
                    "/resources/**",
                    "/api/config/systemConfig/getConfigByKey",// TODO ?????????????????????????????????
                    "/api/push/webhook/**",//??????????????????
                    "/api/ai/ai-handler/process",//api????????????
                    "/doc.html",//swagger knife4j??????????????????
                    "/dubbo",//swagger knife4j??????????????????
                    "/swagger-resources/**",
                    "/resource/**",
                    "/v2/api-docs",
                    "/openApi/**",
                    "/api/commApi/**")
                    .permitAll()
                    .antMatchers("/**").authenticated();//??????order????????????????????????????????????????????????
            // @formatter:on
        }
    }


    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Resource
        AuthenticationManager authenticationManager;
        @Resource
        AuthServiceImpl authService;
        @Resource
        private UsernameAuthServiceImpl usernameAuthService;
        @Resource
        private PasswordEncoder passwordEncoder;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            String key = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456");
            String key2 = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456");
            //?????????????????????,????????????password??????????????????client??????
            clients.inMemory().withClient("client_1")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456")
                    .and().withClient("client_2")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .accessTokenValiditySeconds(60 * 60 * 24 * 7)
                    .refreshTokenValiditySeconds(60 * 60 * 24 * 7)
                    .scopes("admin")
                    .authorities("admin")
                    .secret(key)
                    .and()
                    .withClient("username")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("refresh_token", UsernameTokenGranter.GRANT_TYPE)
                    .accessTokenValiditySeconds(60 * 60 * 24 * 7)
                    .refreshTokenValiditySeconds(60 * 60 * 24 * 7)
                    .scopes("select")
                    .authorities("uploader")
                    .secret(key2);
        }

        @Resource
        WebResponseExceptionTranslator webResponseExceptionTranslator;
        @Resource
        private RedisConnectionFactory factory;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .userDetailsService(authService)
                    .tokenStore(new RedisTokenStore(factory)) // token save redis
//                    .tokenStore(new InMemoryTokenStore()) // token save memory
                    .tokenGranter(tokenGranter(endpoints))
                    .tokenEnhancer(new CustomTokenEnhancer())
                    .authenticationManager(authenticationManager).exceptionTranslator(webResponseExceptionTranslator);
        }

        /**
         * ??????
         * ?????????????????????????????????????????????????????????????????????
         *
         * @param endpoints AuthorizationServerEndpointsConfigurer
         * @return TokenGranter
         */
        private TokenGranter tokenGranter(final AuthorizationServerEndpointsConfigurer endpoints) {
            List<TokenGranter> granters = new ArrayList<>(Collections.singletonList(endpoints.getTokenGranter()));
            granters.add(new UsernameTokenGranter(endpoints.getTokenServices(), endpoints.getClientDetailsService(),
                    endpoints.getOAuth2RequestFactory(), usernameAuthService, passwordEncoder));

            return new CompositeTokenGranter(granters);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            //??????????????????
            oauthServer.allowFormAuthenticationForClients();
        }

    }

}