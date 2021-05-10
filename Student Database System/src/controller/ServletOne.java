package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ServletOne extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(ServletOne.class);
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			LOGGER.info("Checking Login Credentials of Admin");
			
			
			PrintWriter out = response.getWriter();
			String username = request.getParameter("uname");
			String password = request.getParameter("pwd");
			
			if(username.equals("Admin") && (password.equals("system123")))
			{
				LOGGER.info("Admin Credentials Verified");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.html");
				dispatcher.include(request, response);
			}else
			{
				LOGGER.info("Admin Credentials did not match");
				out.write("Login Failed");
			}
	}

}
