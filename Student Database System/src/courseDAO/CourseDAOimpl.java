package courseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import course.Course;
import student.Student;
import utility.DbUtilities;

public class CourseDAOimpl implements CourseDAO{
	private static Statement statement = null;
	private static Connection connection = null;

	public List<Course> view() throws Exception {
		List<Course> CourseList = new ArrayList<>();
		try {
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			String cs = "Select * from course";
			ResultSet rs = statement.executeQuery(cs);	
			if (null != rs) {
				while (rs.next()) {
					Course c = new Course();
					c.setCourseid(rs.getInt(1));
					c.setCoursename(rs.getString(2));
					c.setCoursefees(rs.getString(3));
					c.setCourseduration(rs.getInt(4));

					CourseList.add(c);
				}
			} else {
				System.out.println("No entry in DB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtilities.getDbConnectionClose();
		}
		return CourseList;
	}

	public int update(Course c) throws Exception{

		int flag= 0;
		try {
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			int Courseid = c.getCourseid();
			String updateData="update course set coursename='"+c.getCoursename()+"',coursefees='"+c.getCoursefees()+"',courseduration="+c.getCourseduration()+" where courseid="+c.getCourseid();
			statement.executeUpdate(updateData);
		} catch (Exception e) {
		} finally {
			DbUtilities.getDbConnectionClose();
			return flag;
		}
	}

	public int insert(Course c) throws Exception {
		int flag = 0;
		String sql = "INSERT INTO course(coursename,coursefees,courseduration) values(?,?,?)";
		PreparedStatement statement = null;
		try {
			connection = DbUtilities.getDbConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, c.getCoursename());
			statement.setString(2, c.getCoursefees());
			statement.setInt(3, c.getCourseduration());
			flag = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtilities.getDbConnectionClose();
			return flag;
		}
	}

	public int delete(Course c) throws Exception {
		int flag = 0;
		try{
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			int id = c.getCourseid();
			String query = "Delete from course where courseid = " + id;
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtilities.getDbConnectionClose();
			return flag;
		}

	}

	@Override
	public Course getCoursebyStudentId(int studentId) {
		Course course = null;
		try{
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			String query = "Select * from course where courseid in (Select courseid from student where studentid = "+studentId+")";
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()){
				course  = new Course();
				course.setCourseid(rs.getInt(1));
				course.setCoursename(rs.getString(2));
				course.setCoursefees(rs.getString(3));
				course.setCourseduration(rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtilities.getDbConnectionClose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		return course;
	}

}