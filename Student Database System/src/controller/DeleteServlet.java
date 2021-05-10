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

import student.Student;
import studentService.StudentServiceimpl;

public class DeleteServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(DeleteServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));	
		
		Student student = new Student();
		StudentServiceimpl serviceimpl = new StudentServiceimpl();
		student.setStudentid(id);
		try {
			LOGGER.info("Student Deleted Successfully");
			serviceimpl.delete(student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Delete2.html");
			dispatcher.include(request, response);
		} catch (Exception e) {
			LOGGER.info("Error while Deleting Student");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
