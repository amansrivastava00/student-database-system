package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import course.Course;
import courseService.CourseServiceimpl;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(AddCourseServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String coursename = request.getParameter("coursename");
		String coursefees = request.getParameter("coursefees");
		int courseduration = Integer.parseInt(request.getParameter("courseduration"));
		CourseServiceimpl courseServiceimpl = new CourseServiceimpl();
		Course course = new Course();
		course.setCoursename(coursename);
		course.setCoursefees(coursefees);
		course.setCourseduration(courseduration);
		
		try {
			LOGGER.info("Insert Course successfully");
			courseServiceimpl.insert(course);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CourseAdded.html");
			dispatcher.include(request, response);
		} catch (Exception e) {
			LOGGER.info("Something went wrong while inserting course");
			e.printStackTrace();
		}
	}

}

