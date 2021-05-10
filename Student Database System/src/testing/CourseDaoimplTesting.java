package testing;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import course.Course;
import courseService.CourseServiceimpl;

public class CourseDaoimplTesting {
	@Test
	public void insertCourseSuccessfully() throws Exception 
	{
		Course course=new Course();
		course.setCourseid(109);
		course.setCoursename("MA");
		course.setCoursefees("250000");
		course.setCourseduration(3);
		
		CourseServiceimpl courseServiceimpl =new CourseServiceimpl();
		int flag = courseServiceimpl.insert(course);
		assertEquals(1,flag);
	}
	
	@Test
	public void insertCourseFailed() throws Exception 
	{
		Course course=new Course();
		course.setCourseid(109);
		course.setCoursename("MA");
		course.setCoursefees("250000");
		course.setCourseduration(3);
		
		CourseServiceimpl courseServiceimpl =new CourseServiceimpl();
		int flag = courseServiceimpl.insert(course);
		assertEquals(0,flag);
	}
	
	@Test
	public void updateCourseSuccessfully() throws Exception 
	{
		Course course=new Course();
		course.setCourseid(102);
		course.setCoursename("BCA");
		course.setCoursefees("50000");
		course.setCourseduration(3);
		CourseServiceimpl courseServiceimpl=new CourseServiceimpl();
		int flag=courseServiceimpl.update(course);
		assertEquals(1,flag);
	}
	
	@Test
	public void updateCourseFailed() throws Exception 
	{
		Course course=new Course();
		course.setCourseid(102);
		course.setCoursename("BCA");
		course.setCoursefees("50000");
		course.setCourseduration(3);
		CourseServiceimpl courseServiceimpl=new CourseServiceimpl();
		int flag=courseServiceimpl.update(course);
		assertEquals(0,flag);
	}
	
	
	@Test
	public void deleteCourseSuccessfully() throws Exception 
	{
		Course course=new Course();
		course.setCourseid(101);
		CourseServiceimpl courseServiceimpl=new CourseServiceimpl();
		int flag=courseServiceimpl.delete(course);
		assertEquals(1,flag);
	}
	
	@Test
	public void deleteCourseFailed() throws Exception 
	{
		Course course=new Course();
		course.setCourseid(101);
		CourseServiceimpl courseServiceimpl=new CourseServiceimpl();
		int flag=courseServiceimpl.delete(course);
		assertEquals(0,flag);	
		}
}
