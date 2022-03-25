package com.pettyfox.platform_example.web.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.UnknownTypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;

@Configuration
@MapperScan({
        "com.pettyfox.platform_example.account.domain.repository",
        "com.pettyfox.platform_example.business.domain.repository",
        "com.pettyfox.platform_example.push.domain.repository",
        "com.pettyfox.platform_example.config.domain.repository"
})
@Slf4j
public class MybatisConfiguration implements IdentifierGenerator {

    private static final Snowflake SNOWFLAKE = IdUtil.createSnowflake(1, 1);

    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig conf = new GlobalConfig();
        conf.setIdentifierGenerator(this);
        return conf;
    }

    /**
     * 雪花id
     *
     * @param entity
     * @return
     */
    @Override
    public Long nextId(Object entity) {
        return SNOWFLAKE.nextId();
    }

    /**
     * 分页配置
     *
     * @return
     */
    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

    /**
     * 这是修复mybatis中TypeHandler处理的bug
     *
     * @param event
     */
    public static void initMybatisTypeHandler(ApplicationReadyEvent event) {
        log.info("init mybatis type handler patch bug");
        SqlSessionFactory sqlSessionFactory = event.getApplicationContext().getBean(SqlSessionFactory.class);
        ClassUtil.scanPackageByAnnotation("com.eface.platform", TableName.class).forEach(clazz -> {
            Class tempClazz = clazz;
            // 父类字段也解析
            while (tempClazz != null && !Object.class.getName().equals(tempClazz.getName().toLowerCase())) {
                for (Field filed : tempClazz.getDeclaredFields()) {
                    TableField tableName = filed.getAnnotation(TableField.class);
                    if (null != tableName && !tableName.typeHandler().equals(UnknownTypeHandler.class)) {
                        sqlSessionFactory.getConfiguration().getTypeHandlerRegistry().register(filed.getType(), tableName.typeHandler());
                    }
                }
                tempClazz = tempClazz.getSuperclass();
            }
        });
    }
}
