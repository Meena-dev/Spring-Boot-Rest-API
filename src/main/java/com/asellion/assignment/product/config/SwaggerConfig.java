package com.asellion.assignment.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.asellion.assignment.product.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {

		return new ApiInfoBuilder().title("products Information")
				.description("Products REST API")
				.contact(new Contact("Asellion", "https://www.asellion.com/", "asellion@test.com"))
				.license("Asellion")
				.licenseUrl("https://www.asellion.com/contact")
				.version("0.0.1-SNAPSHOT")
				.build();
	}
}
