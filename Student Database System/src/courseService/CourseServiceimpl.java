package courseService;

import java.util.ArrayList;
import java.util.List;

import course.Course;
import courseDAO.CourseDAOimpl;
import student.Student;

public class CourseServiceimpl implements CourseService{
	CourseDAOimpl courseDAO = new CourseDAOimpl();
	
	
	public List<Course> view() throws Exception {
		List<Course> course = new ArrayList<>();
		try{
			course = courseDAO.view();
		}catch (Exception e) {
			throw e;
		}
		return course;
	}

	public int update(Course c) throws Exception {
		try{
			return courseDAO.update(c);
		}catch (Exception e) {
			throw e;
		}
	}

	public int insert(Course c) throws Exception {
		try{
			return courseDAO.insert(c);
		}catch (Exception e) {
			throw e;
		}
	}

	public int delete(Course c) throws Exception {
		try{
			return courseDAO.delete(c);
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Course getCoursebyStudentId(int studentId) {
		Course course = null;
		course = courseDAO.getCoursebyStudentId(studentId);
		return course;
	}

	
}

