package com.demo.utest.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("myname","llj");
        String age = registration.getInitParameter("myage");

        super.customizeRegistration(registration);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
       /* FilterRegistration registration =  servletContext.addFilter("loginFilter",LoginFilter.class);
        registration.addMappingForUrlPatterns(null,true, "/home/*");*/

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        servletContext.addFilter("characterEncodingFilter",characterEncodingFilter);

        servletContext.setInitParameter("myage","100");

        super.onStartup(servletContext);
    }




    /*@Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        //DelegatingFilterProxy securityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");



        return new Filter[]{characterEncodingFilter};
    }*/
}
