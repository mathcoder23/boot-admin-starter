package com.pettyfox.platform_example.cache.config;

import com.pettyfox.platform_example.cache.service.impl.RealStatusServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/10/12</p>
 * <p></p>
 *
 * @author Petty Fox
 */
@ComponentScan(basePackageClasses = RealStatusServiceImpl.class)
public class RedisConfig {

    @Resource
    private RedisConnectionFactory factory;


    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> fastJsonRedisTemplate() {
        FastJson2JsonRedisSerializer<?> serializer = new FastJson2JsonRedisSerializer<>(Object.class);
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        //redis开启事务
        template.setEnableTransactionSupport(true);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(valueSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(valueSerializer());
        template.setDefaultSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    private RedisSerializer<?> valueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
        // return new JdkSerializationRedisSerializer();
    }
}
