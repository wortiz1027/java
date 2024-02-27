package co.com.microservice.config.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import co.com.microservice.config.application.ApplicationContextConfig;

public class WebInicializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationContextConfig.class, RestViewConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}