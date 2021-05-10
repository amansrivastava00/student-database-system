package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import customException.UserNotFoundException;
import student.Student;
import studentDAO.StudentDAOimp;
import studentService.StudentService;
import studentService.StudentServiceimpl;

@WebServlet("/StudentInformationServlet")
public class StudentInformationServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(StudentInformationServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Verifying Student id and DOB from Database");
		PrintWriter out=response.getWriter();
	 	int studentid = Integer.parseInt(request.getParameter("id"));
	 	System.out.println(studentid);
		String studentdob = request.getParameter("dob");
		System.out.println(studentdob);
		
		// list=new ArrayList<>();
		
		StudentService  studentService = new StudentServiceimpl();
		Student student = studentService.getStudentById(studentid);
		try{
			if(student == null){	
			LOGGER.info("Student entered wrong id and DOB");	
//			System.out.println("student not found");
//			response.setContentType("text");
//			out.println("Student Not Found");
			throw new UserNotFoundException("Student Not Found");
			
		}
		}catch(UserNotFoundException e){
			out.println(e.getMessage());
		}
		if(student.getDob().equals(studentdob)){
			LOGGER.info("Student id and dob verified");
			RequestDispatcher dispatcher=request.getRequestDispatcher("Update1.html");
			dispatcher.include(request, response);
		}
		
		
//		try{
//			int count =0;
//			ArrayList<Student> list = studentDAOimp.showStudent();
//			System.out.println("in dao update");
//			for(Student stu : list)
//			{
//				System.out.println(stu.getName());
//				if(studentname.equals(stu.getName()) && studentdob.equals(stu.getDob()))
//			{
//				System.out.println(stu);
//				System.out.println("In update block");
//				RequestDispatcher dispatcher=request.getRequestDispatcher("Update1.html");
//				dispatcher.include(request, response);
//				count++;
//			}
//			}
//			
//			if(count ==0)
//			{
//					out.println("Student name and D.O.B are incorrect try again....");
//					//RequestDispatcher dispatcher=request.getRequestDispatcher("ErrorPage.html");
//					//dispatcher.include(request, response);
//			}
//		}
//		catch(ClassNotFoundException | SQLException e)
//		{
//			e.printStackTrace();
//			
//		}
		
		}

	}