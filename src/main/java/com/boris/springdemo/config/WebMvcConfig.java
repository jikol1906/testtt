package com.boris.springdemo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.boris.springdemo.interceptors.HeaderInterceptor;

@Configuration
@ComponentScan("com.boris")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Bean
	public DataSource dataSource(){
		final JndiDataSourceLookup dsLookUp = new JndiDataSourceLookup();
		dsLookUp.setResourceRef(true);
		DataSource dataSource = dsLookUp.getDataSource("jdbc/spring_db");
		return dataSource;
	}

//	@Bean
//	public RequestMappingHandlerMapping requestMappingHandlerMapping(){
//			
//		RequestMappingHandlerMapping rm = new RequestMappingHandlerMapping();
//		rm.setUseSuffixPatternMatch(true);
//		rm.setUseTrailingSlashMatch(true);
//		return rm;
//		
//	}
	
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver(){
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("testMvcHome");
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HeaderInterceptor());
	}
	
	
	
	
	
}
