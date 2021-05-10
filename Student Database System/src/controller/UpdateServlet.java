package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import course.Course;
import student.Student;
import studentService.StudentServiceimpl;


public class UpdateServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(UpdateServlet.class);

//		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			PrintWriter out = response.getWriter();
//			int studentid = Integer.parseInt(request.getParameter("studentid"));
//			
//			
//			Student student = new Student(	);
//			StudentServiceimpl serviceimpl = new StudentServiceimpl();
//			List<Student> students = null;
//			student.setStudentid(studentid);
//			try {
//				students = serviceimpl.view();
//				int count = 0;
//				for(Student s: students){
//					if (s.getStudentid()==studentid) {
//					count++;
//					RequestDispatcher dispatcher = request.getRequestDispatcher("Update1.html");
//					dispatcher.include(request, response);
//					}
//				}
//				if(count==0){
//					RequestDispatcher dispatcher = request.getRequestDispatcher("Update.html");
//					dispatcher.include(request, response);
//					out.write("Id not Found");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			LOGGER.info("Getting Values from student for updating his data");
			PrintWriter out = response.getWriter();
			StudentServiceimpl serviceimpl = new StudentServiceimpl();
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String dob = request.getParameter("dob");
			Boolean fees = Boolean.valueOf(request.getParameter("fees"));
			System.out.println("fees is" + fees);
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			String contact = request.getParameter("contact");
			
			LOGGER.info("Setting Values and updating his data");
			Student student = new Student();
			Course course = new Course();
			student.setStudentid(id);
			student.setName(name);
			student.setDob(dob);
			student.setFees(fees);
			course.setCourseid(courseid);
			student.setCourse(course);
			student.setContact(contact);
			
			try {
				LOGGER.info("Inside Student Update");
				serviceimpl.update(student);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Update2.html");
				dispatcher.include(request, response);
			} catch (Exception e) {
				LOGGER.info("Error while updating Student information");
				e.printStackTrace();
			
		}
		
		}
}