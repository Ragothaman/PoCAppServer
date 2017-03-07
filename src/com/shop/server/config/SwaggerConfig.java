package com.shop.server.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
     * @return -
     */
    @Bean
    public Docket documentation()
    {
        return new Docket(DocumentationType.SWAGGER_2)
        			.select()
        			.apis(RequestHandlerSelectors.any())
        			.paths(paths())//.paths(paths())
        			.build().pathMapping("/") //$NON-NLS-1$
        			.apiInfo(metadata());
    }

    /**
     * 
     * @return -
     */
	@SuppressWarnings("unchecked")
	private Predicate<String> paths() {
        return or(regex("/users"), //$NON-NLS-1$
        		regex("/user/*"),
        		regex("/user/add"),
        		regex("/user/del"),
                regex("/signin/user"),
                regex("/products"),
                regex("/products/*"),
                regex("/products/getallproducts"),
                regex("/products/getproductbyid"),
                regex("/products/getproductbyname"),
                regex("/products/getperishableproducts"),
                regex("/products/getnonperishableproducts"),
                regex("/contacts/insertContacts"),
                regex("/contacts/getcontactbyid"),
                regex("/contacts/getcontactbyname"),
                regex("/order/insertOrder"),
                regex("/order/getOrderDetail")
        		); //$NON-NLS-1$
    }

    /**
     * 
     * @return -
     */
    private ApiInfo metadata() {
        return new ApiInfoBuilder().title("Shop REST Service") //$NON-NLS-1$
                .description("Template for Shop REST Service") //$NON-NLS-1$
                .version("0.1.0") //$NON-NLS-1$
                .build();
    }

    /**
     * @return -
     */
    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration("validatorUrl", // url //$NON-NLS-1$
                "none", // docExpansion => none | list //$NON-NLS-1$
                "alpha", // apiSorter => alpha //$NON-NLS-1$
                "schema", // defaultModelRendering => schema //$NON-NLS-1$
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, 
                true, // enableJsonEditor => true | false
                true); // showRequestHeaders => true | false
    }

}
