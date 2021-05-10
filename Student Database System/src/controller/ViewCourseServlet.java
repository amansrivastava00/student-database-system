package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import course.Course;
import courseService.CourseServiceimpl;



@WebServlet("/ViewCourseServlet")
public class ViewCourseServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(ViewCourseServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseServiceimpl courseserviceimpl = new CourseServiceimpl();
		PrintWriter out = response.getWriter();
		LOGGER.info("Fetching and Displaying Courses from database");
		try {
			List<Course> course =courseserviceimpl.view();
			out.println("<html>"
					+ "<head>"
					+"</head>"
					+"<link rel='stylesheet' type='text/css' href='./Resources/css/View.css'>"
					+ "<body>"
					+ "<center><table border='solid' class = 'content-table'>"
					+ "<thead>"
					+ "<tr>"
					+ "<td>Course Id</td>"
					+ "<td>Course Name</td>"
					+ "<td>Course Fees</td>"
					+ "<td>Course Duration</td>"
					+ "</tr>"
					+ "</thead>"
					+ "<tbody>"
					);
			for(Course c : course)
			{

				out.println(
						"<tr>"
								+ "<td>"+c.getCourseid()+"</td>"
								+ "<td>"+c.getCoursename()+"</td>"
								+ "<td>"+c.getCoursefees()+"</td>"
								+ "<td>"+c.getCourseduration()+"</td>"
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
