package com.lojastory.lojastory.config;

import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;*/

@Configuration
public class SwaggerConfig {
	/*
	 * // @Bean public Docket webServiceApi() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.basePackage("com.lojastory.lojastory"))
	 * .paths(regex("/api/v1.*")) .build() // .ignoredParameterTypes(Marca.class)
	 * .apiInfo(metaInfo()) .globalOperationParameters(Arrays.asList( new
	 * ParameterBuilder() .name("Authorization")
	 * .description("Header para token JWT") .modelRef(new ModelRef("string"))
	 * .parameterType("header") .required(false) .build())); }
	 * 
	 * private ApiInfo metaInfo() {
	 * 
	 * ApiInfo apiInfo = new ApiInfo( "Controle Estoque API REST",
	 * "API REST de Controle de Estoque.", "1.0", "Terms of Service", new
	 * Contact("Pedro Lima", "https://linkedin.com/in/pedrolyma",
	 * "pelyma33@gmail.com"), "Apache License Version 2.0",
	 * "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>() );
	 * 
	 * return apiInfo; }
	 */
}
