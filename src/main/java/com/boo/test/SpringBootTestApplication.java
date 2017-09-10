package com.boo.test;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}

	/**
	 * 该过滤器负责用户的认证工作，必须启用它
	 * @return
	 */
	@Bean
	public FilterRegistrationBean authenticationFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new AuthenticationFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("casServerLoginUrl", "http://localhost:8080/login");
		registration.addInitParameter("serverName", "http://localhost:8082");
		registration.addInitParameter("ignorePattern", "^.*[.](js|css|gif|png|jpg|jpeg|zip)$");
		registration.setName("authenticationFilter");
		registration.setOrder(1);
		return registration;
	}

	/**
	 * 该过滤器负责用户的认证工作，必须启用它
	 * @return
	 */
	@Bean
	public FilterRegistrationBean cas20ProxyReceivingTicketValidationFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new Cas20ProxyReceivingTicketValidationFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("casServerUrlPrefix", "http://localhost:8080");
		registration.addInitParameter("serverName", "http://localhost:8082");
		registration.setName("cas20ProxyReceivingTicketValidationFilter");
		registration.setOrder(1);
		return registration;
	}

//	/**
//	 * 该过滤器负责用户的认证工作，必须启用它
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean httpServletRequestWrapperFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new HttpServletRequestWrapperFilter());
//		registration.addUrlPatterns("/*");
//		registration.setName("httpServletRequestWrapperFilter");
//		registration.setOrder(5);
//		return registration;
//	}

	/**
	 * 该过滤器负责用户的认证工作，必须启用它
	 * @return
	 */
	@Bean
	public FilterRegistrationBean assertionThreadLocalFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new AssertionThreadLocalFilter());
		registration.addUrlPatterns("/*");
		registration.setName("assertionThreadLocalFilter");
		registration.setOrder(10);
		return registration;
	}

}
