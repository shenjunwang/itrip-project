package com.cskt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 申钧旺
 * @create 2021-01-06 15:03
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket authApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("authApi")
                .apiInfo(authApiInfo())
                .select()
//通过包路径来将controller部分纳入Swagger
                .apis(RequestHandlerSelectors.basePackage("com.cskt.itripauth.controller"))
                .build();
    }
    private ApiInfo authApiInfo() {
        return new ApiInfoBuilder()
                .title("爱旅行-用户认证模块API")
                .description("提供用户认证相关接口")
                .version("V1.0")
                .build();
    }
}
