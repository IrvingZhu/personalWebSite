/**
 * 
 */
package com.zrz.personalWeb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zrz
 *
 */

@Configuration
public class LoginMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		UserLoginInterceptor ulit = new UserLoginInterceptor();
		registry.addInterceptor(ulit).addPathPatterns("/**")
				.excludePathPatterns("/css/**", "/js/**", "/image/**", "/static/**").excludePathPatterns("/index.html")
				.excludePathPatterns("/login.html").excludePathPatterns("/register.html")
				.excludePathPatterns("/connManner.html").excludePathPatterns("/personalResume.html")
				.excludePathPatterns("/").excludePathPatterns("/loginIn").excludePathPatterns("/registerIn")
				.excludePathPatterns("/info");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedHeaders("*").allowedOrigins("http://localhost:8080")
				.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE").maxAge(3600).allowCredentials(true);
	}
}
