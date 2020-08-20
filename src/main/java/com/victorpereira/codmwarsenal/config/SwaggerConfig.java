package com.victorpereira.codmwarsenal.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket arsenalApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
                .apis(RequestHandlerSelectors.basePackage("com.victorpereira.codmwarsenal"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
	}	
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"COD MW Arsenal REST API",
				"REST API that contains the entire COD MW arsenal",
				"1.0",
				"Terms of Service",
				new Contact("Victor Pereira", "https://github.com/victorpereira01",
						"victor.cordeiro2@gmail.com"),
				null, null, new ArrayList<VendorExtension>()			
				);
		
		return apiInfo;
				
	}
}
