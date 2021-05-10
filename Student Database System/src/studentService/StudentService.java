package studentService;

import java.sql.SQLException;
import java.util.List;

import student.Student;

public interface StudentService {
	public List<Student> view() throws Exception;
	public int update(Student s) throws Exception;
	public int insert(Student s) throws Exception;
	public int delete(Student s) throws Exception;
	public Student getStudentById(int studentId);
	String showStudentsLike(String str) throws ClassNotFoundException, SQLException;
}
