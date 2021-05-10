package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import student.Student;
import studentService.StudentServiceimpl;

public class ViewServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(ViewServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentServiceimpl studentserviceimpl = new StudentServiceimpl();
		PrintWriter out = response.getWriter();
		LOGGER.info("Fetching and Displaying Students from database");
		try {
			List<Student> students =studentserviceimpl.view();
			out.println("<html>"
					+ "<head>"
					+"</head>"
					+"<link rel='stylesheet' type='text/css' href='./Resources/css/View.css'>"
					+ "<body>"
					+ "<center><table border='solid' class = 'content-table'>"
					+ "<thead>"
					+ "<tr>"
					+ "<td>Id</td>"
					+ "<td>Name</td>"
					+ "<td>D.O.B</td>"
					+ "<td>Fees</td>"
					+ "<td>CourseId</td>"
					+"<td>Contact</td>"
					+ "</tr>"
					+ "</thead>"
					+ "<tbody>"
					);
			for(Student stu : students)
			{
				
				out.println(
						"<tr>"
								+ "<td>"+stu.getStudentid()+"</td>"
								+ "<td>"+stu.getName()+"</td>"
								+ "<td>"+stu.getDob()+"</td>"
								+ "<td>"+stu.isFees()+"</td>"
								+ "<td>"+stu.getCourse().getCourseid()+"</td>"
								+ "<td>"+stu.getContact()+"</td>"
								+"</tr>");

			}
		out.println(
			"</tbody>"
			+ "</table></center>"
			+"<br><br>");
			
		out.println(
				"<center>"
				+"<a href='AdminDashboard.html'>Back to Dashboard</a>"
				+"</center>"
				+"</body>"
				+"</html>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
