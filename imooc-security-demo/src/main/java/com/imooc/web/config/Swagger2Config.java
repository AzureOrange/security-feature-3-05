package com.imooc.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.and;

/**
 * @author Administrator
 */
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true")
@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(and(RequestHandlerSelectors.basePackage("com.imooc.web.controller")))
                .paths(PathSelectors.any())
                .build();
    }

    public static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot RESTful APIs")
                .description("Powered By orange")
                .termsOfServiceUrl("v2/api-docs")
                .version("20180504")
                .build();
    }
}
