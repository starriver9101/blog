package com.starriver.blog.config;

import com.starriver.blog.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chen
 * @describe SwaggerConfig
 * @date 2020/12/18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig{
    @Override
    public SwaggerProperties swaggerProperties() {
        SwaggerProperties swaggerProperties = new SwaggerProperties();
        swaggerProperties.setApiBasePackage("com.macro.mall.demo.controller");
        swaggerProperties.setTitle("blog-demo系统");
        swaggerProperties.setDescription("SpringCloud版本中的一些示例");
        swaggerProperties.setContactName("chen");
        swaggerProperties.setVersion("1.0");
        swaggerProperties.setEnableSecurity(true);
        return swaggerProperties;
    }
}

