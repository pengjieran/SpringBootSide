package com.examplecn.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createAccepterRestApi() {

        List<Parameter> pars = new ArrayList<>();


        ParameterBuilder contentType = new ParameterBuilder();
        contentType.name("Content-Type").defaultValue("application/json")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();

        ParameterBuilder product = new ParameterBuilder();
        product.name("product").defaultValue("product").description("终端类型")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();

        ParameterBuilder token = new ParameterBuilder();
        token.name("token").defaultValue("token").description("认证token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();

        ParameterBuilder appKey = new ParameterBuilder();
        appKey.name("appKey").defaultValue("appKey").description("appKey")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();


        pars.add(contentType.build());    //根据每个方法名也知道当前方法在设置什么参数
        pars.add(product.build());
        pars.add(token.build());
        pars.add(appKey.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("单体应用相关API")//分组名,不指定默认为default
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))// 扫描的包路径
                .paths(PathSelectors.any())// 定义要生成文档的Api的url路径规则
                .build()
                .globalOperationParameters(pars)
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
