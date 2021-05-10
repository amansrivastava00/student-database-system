package courseService;

import java.util.List;

import course.Course;

public interface CourseService {
	public List<Course> view() throws Exception;
	public int update(Course c) throws Exception;
	public int insert(Course c) throws Exception;
	public int delete(Course c) throws Exception;
	public Course getCoursebyStudentId(int studentId);
}
