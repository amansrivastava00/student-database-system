package studentDAO;

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

public class StudentDAOimp implements StudentDAO {
	private static Statement statement = null;
	private static Connection connection = null;

	@Override
	public List<Student> view() throws Exception {
		List<Student> StudentList = new ArrayList<>();
		try {
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			String cs = "Select * from student";
			ResultSet rs = statement.executeQuery(cs);	
			if (null != rs) 
			{
				while (rs.next())
				{
					Course course = new Course();
					Student s = new Student();
					s.setStudentid(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setDob(rs.getString(3));
					s.setFees(rs.getBoolean(4));
					course.setCourseid(rs.getInt(5));
					s.setCourse(course);
					s.setContact(rs.getString(6));
					StudentList.add(s);
				}
			} else {
				System.out.println("No entry in DB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtilities.getDbConnectionClose();
		}
		return StudentList;
	}
	@Override
	public int update(Student s) throws Exception {

		int flag = 0;
		try {
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			int id = s.getStudentid();
			String cs = "Select * from student where studentid = " + id;
			ResultSet rs = statement.executeQuery(cs);
			System.out.println(s.getName());
			System.out.println(s.getDob());
			System.out.println(s.isFees());
			System.out.println(id);
			System.out.println(s.getCourse().getCourseid());
			System.out.println(s.getContact());

			if (rs != null) {
				System.out.println("Inside rs");
				//				String update = "UPDATE student" + " SET name ='" + s.getName() + "', dob='" + s.getDob()
				//				+ "',fees = " + s.isFees() + " , courseid='" + s.getCourse().getCourseid() + "', contact = '"
				//				+ s.getContact() + "' WHERE id = " + id;
				String query = "update student set name = '"+s.getName()+"', dob ='"+s.getDob()+"',fees = "+s.isFees()+" , "
						+ "courseid = "+s.getCourse().getCourseid()+", contact = '"
						+ s.getContact()+ "' WHERE studentid = " + id;
				statement.executeUpdate(query);
			} else {
				System.out.println("No Student is Registered in Database with this ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtilities.getDbConnectionClose();
			return flag;
		}
	}

	@Override
	public int insert(Student s) throws Exception {
		int flag = 0;
		String sql = "INSERT INTO student(name,dob,fees,courseid,contact) values(?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			connection = DbUtilities.getDbConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, s.getName());
			statement.setString(2, s.getDob());
			statement.setBoolean(3,s.isFees());
			statement.setInt(4, s.getCourse().getCourseid());
			statement.setString(5, s.getContact());
			int count = statement.executeUpdate();

			if (0 != count) {
			} else {
				System.out.println("No entry in DB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtilities.getDbConnectionClose();
			return flag;
		}
	}

	@Override
	public int delete(Student s) throws Exception {
		int flag = 0;
		try{
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			int id = s.getStudentid();
			System.out.println(id);
			String cs = "Delete from student where studentid = " + id;
			int count = statement.executeUpdate(cs);
			if (count != 0) {
			} else {
				System.out.println("No entry in DB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtilities.getDbConnectionClose();
			return flag;
		}
	}
	@Override
	public ArrayList<Student> showStudent() throws ClassNotFoundException, SQLException {
		ArrayList<Student> list = new ArrayList<Student>();
		try
		{
			Connection connection = DbUtilities.getDbConnection();
			Statement statement = connection.createStatement();

			String updateData="select * from student";
			ResultSet rs = statement.executeQuery(updateData);
			while(rs.next())
			{
				Student student =new Student();
				Course course = new Course();
				student.setStudentid(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setDob(rs.getString(3));
				student.setFees(rs.getBoolean(4));
				course.setCourseid(rs.getInt(5));
				student.setContact(rs.getString(6));

				list.add(student);

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbUtilities.getDbConnectionClose();
		}
		return list;
	}
	@Override
	public Student getStudentById(int studentId) {
		
		Student student = null;
		Connection connection = null;
		Statement statement = null;
		String sql = "Select * from student where studentid = " + studentId;
		try {
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()){
				student = new Student();
				student.setStudentid(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setDob(rs.getString(3));
				student.setFees(rs.getBoolean(4));
				student.setContact(rs.getString(6));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(statement!=null){
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				
		return student;
	}
	
	public String showStudentsLike(String str)
	{
		String name = null;
		String sql ="select * from student where name like '"+str+"'";
		try {
			connection = DbUtilities.getDbConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				 name = rs.getString("name");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
}

