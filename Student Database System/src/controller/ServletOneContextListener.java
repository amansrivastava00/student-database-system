package controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

public class ServletOneContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String log4jConfigFile = context.getInitParameter("log4j-config-location");
		String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
		
		PropertyConfigurator.configure(fullPath);
			
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	

}
