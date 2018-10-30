package com.krunoslav.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup method called...");

        // create the Spring application context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        // create the Dispatcher Servlet and add it to ServletContext provided
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // register and configure the dispatcher servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME,dispatcherServlet);

        registration.setLoadOnStartup(1);               // container diže i instancira servlet kod startupa
        registration.addMapping("/");           // mapira servlet na '/' i overridea homepage od Tomcata


    }
}
