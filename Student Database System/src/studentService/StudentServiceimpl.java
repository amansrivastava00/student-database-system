package studentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import course.Course;
import courseDAO.CourseDAO;
import courseDAO.CourseDAOimpl;
import courseService.CourseService;
import courseService.CourseServiceimpl;
import student.Student;
import studentDAO.StudentDAO;
import studentDAO.StudentDAOimp;

public class StudentServiceimpl implements StudentService{
	StudentDAOimp studentDAO = new StudentDAOimp();
	
	
	public List<Student> view() throws Exception {
		List<Student> students = new ArrayList<>();
		try{
			students = studentDAO.view();
		}catch (Exception e) {
			throw e;
		}
		return students;
	}

	public int update(Student s) throws Exception {
		try{
			return studentDAO.update(s);
		}catch (Exception e) {
			throw e;
		}
			
	}

	public int insert(Student s) throws Exception {
		try{
			return studentDAO.insert(s);
		}catch (Exception e) {
			throw e;
		}
	}

	public int delete(Student s) throws Exception {
		try{
			return studentDAO.delete(s);
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Student getStudentById(int studentId) {
		Student student = null;
		student = studentDAO.getStudentById(studentId);
		if(student != null){
			//retrieveing course object from database
			CourseService courseService = new CourseServiceimpl();
			Course course = courseService.getCoursebyStudentId(studentId);
			student.setCourse(course);
		}
		return student;
	}
	
	public String showStudentsLike(String str) throws ClassNotFoundException, SQLException {
		String name = null;
		try{
			name = studentDAO.showStudentsLike(str);
		}catch(Exception e)
		{
			throw e;
		}
		return name;
	}
}
