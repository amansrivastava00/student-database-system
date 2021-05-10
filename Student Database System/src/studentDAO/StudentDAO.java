package studentDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.Student;

public interface StudentDAO {
	public List<Student> view() throws Exception;
	public int update(Student s) throws Exception;
	public int insert(Student s) throws Exception;
	public int delete(Student s) throws Exception;
	public Student getStudentById(int studentId);
	ArrayList<Student> showStudent() throws ClassNotFoundException,SQLException;
	String showStudentsLike(String str);
	
}
