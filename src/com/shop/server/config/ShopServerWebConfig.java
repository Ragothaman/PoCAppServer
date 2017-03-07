package com.shop.server.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.shop.server")
@Controller
public class ShopServerWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

    /**
     * @param request -
     * @param name -
     * @param model -
     * @return -
     */
    //@RequestMapping("/")
    public String greetings(ModelMap model) {   //, Model model
    	System.out.println("Entered into default context");
    	//StringBuffer requesturi = request.getRequestURL();
        //String applicationURl = requesturi.toString().replaceAll("http", "https");//$NON-NLS-1$ //$NON-NLS-2$ 
        //model.addAttribute("api", requesturi.toString()+"api");//$NON-NLS-1$ //$NON-NLS-2$ 
        return "index"; //$NON-NLS-1$
    }
    
    /**
     * @param request -
     * @param response -
     * @throws IOException -
     */
    @RequestMapping("/api")
    public @ResponseBody void api(HttpServletRequest request, HttpServletResponse response ) throws IOException {   
    	String applicationURl = request.getRequestURL().toString();
    	//String applicationURl = request.getRequestURL().toString().replaceAll("http", "https");//$NON-NLS-1$ //$NON-NLS-2$
        response.sendRedirect(applicationURl.replace("/api", "/swagger-ui.html")); //$NON-NLS-1$//$NON-NLS-2$
    }
    
    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jackson2Converter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter jackson2Converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }*/
}
