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



@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(DeleteCourseServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("courseid"));	
		
		Course course = new Course();
		CourseServiceimpl courseserviceimpl = new CourseServiceimpl();
		course.setCourseid(id);
		try {
			LOGGER.info("Course Deleted Successfully");
			courseserviceimpl.delete(course);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CourseDeleted.html");
			dispatcher.include(request, response);
		} catch (Exception e) {
			LOGGER.info("Error while Deleting Course");
			e.printStackTrace();
		}
	}

}