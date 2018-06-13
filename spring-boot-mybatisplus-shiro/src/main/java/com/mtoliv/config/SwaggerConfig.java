package com.mtoliv.config;

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
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
      
		return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .paths(PathSelectors.any())
            .build();
	}
   
	@Bean
	public UiConfiguration uiConfiguration() {
		
		return UiConfigurationBuilder.builder()
							.deepLinking(true)
							.defaultModelExpandDepth(1)
							.validatorUrl("")
							.displayOperationId(true)
							.displayRequestDuration(true)
							.tagsSorter(TagsSorter.of("release"))
							.showExtensions(true)
							.build();
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title("英语学习相关api")
				.description("RESTful API")
				.termsOfServiceUrl("http://localhost:80")
				.contact(new Contact("Aaron", "https://pengjieran.github.io", "pengjieran@gmail.com"))
				.version("1.0")
				.build();
	}
}
