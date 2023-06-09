package com.study.springboot;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.log4j.Log4j2;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
@WebListener
@Log4j2
public class TestListener implements ServletContextListener {

    /**
      생성자 
     */
    public TestListener() {
    	log.info("**TestListener");
    }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("***contextInitialized");
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("appName", "test");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("***contextDestroyed");
	}
	
}
