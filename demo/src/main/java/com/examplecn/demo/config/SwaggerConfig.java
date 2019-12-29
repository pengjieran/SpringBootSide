package com.examplecn.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createAccepterRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("单体应用相关API")//分组名,不指定默认为default
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))// 扫描的包路径
                .paths(PathSelectors.any())// 定义要生成文档的Api的url路径规则
                .build()
                .apiInfo(apiInfo())// 设置swagger-ui.html页面上的一些元素信息
                .enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("单体应用RESTful API")
                .description("提供业务数据接收模块/业务数据处理模块的文档")
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                .version("1.0")
                .contact(new Contact("Aaron", "http://github.com/pengjieran", "pengjieran.gmail.com"))
                .build();
    }
}
