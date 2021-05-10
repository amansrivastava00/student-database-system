package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import course.Course;
import student.Student;
import studentService.StudentServiceimpl;

public class AddServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(AddServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		System.out.println(name);
		String dob = request.getParameter("dob");
		System.out.println(dob);
		String pr = request.getParameter("fees");
		Boolean fees = !pr.isEmpty();
		System.out.println(fees);
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		System.out.println(courseid);
		String contact = request.getParameter("contact");
		System.out.println(contact);

		StudentServiceimpl serviceimpl = new StudentServiceimpl();
		Student student = new Student();
		Course course = new Course();
		course.setCourseid(courseid);
		student.setName(name);
		student.setDob(dob);
		student.setFees(fees);
		student.setCourse(course);
		student.setContact(contact);

		try {
			LOGGER.info("Insert Student successfully");
			serviceimpl.insert(student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterServlet.html");
			dispatcher.include(request, response);
		} catch (Exception e) {
			LOGGER.info("Something Went wrong while inserting student");
			e.printStackTrace();
		}

	}

}
