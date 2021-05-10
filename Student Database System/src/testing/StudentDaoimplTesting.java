package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import course.Course;
import courseService.CourseServiceimpl;
import student.Student;
import studentService.StudentServiceimpl;



public class StudentDaoimplTesting {
	
	@Test
	public void insertStudentSuccessfully() throws Exception 
	{
		Student student=new Student();
		Course course = new Course();
		student.setStudentid(3);
		student.setName("Aman");
		student.setDob("27/08/1998");
		student.setFees(true);
		student.getCourse().setCourseid(104);
		student.setContact("9140012916");
		
		StudentServiceimpl studentServiceimpl=new StudentServiceimpl();
		int flag = studentServiceimpl.insert(student);
		assertEquals(1,flag);
	}
	
	@Test
	public void insertStudentFailed() throws Exception 
	{
		Student student=new Student();
		Course course = new Course();
		student.setStudentid(3);	
		student.setName("Aman");
		student.setDob("27/08/1998");
		student.setFees(true);
		student.getCourse().setCourseid(104);
		student.setContact("9140012916");
		
		StudentServiceimpl studentServiceimpl=new StudentServiceimpl();
		int flag = studentServiceimpl.insert(student);
		assertEquals(0,flag);
    }
	
	@Test
	public void updateStudentSuccessfully() throws Exception 
	{
		Student student = new Student();
		Course course=new Course();
		student.setStudentid(2);
		student.setName("Akash");
		student.setDob("14/10/2000");
		student.setFees(false);
		student.getCourse().setCourseid(103);
		student.setContact("8005144255");
		StudentServiceimpl studentserviceimpl=new StudentServiceimpl();
		int flag=studentserviceimpl.update(student);
		assertEquals(1,flag);
	}
	
	@Test
	public void updateStudentFailed() throws Exception 
	{
		Student student = new Student();
		Course course=new Course();
		student.setStudentid(2);
		student.setName("Akash");
		student.setDob("14/10/2000");
		student.setFees(false);
		student.getCourse().setCourseid(103);
		student.setContact("8005144255");
		StudentServiceimpl studentserviceimpl=new StudentServiceimpl();
		int flag=studentserviceimpl.update(student);
		assertEquals(0,flag);
	}
	
	@Test
	public void deleteStudentSuccessfully() throws Exception 
	{
		Student student=new Student();
		student.setStudentid(2);
		StudentServiceimpl studentServiceimpl = new StudentServiceimpl();
		int flag=studentServiceimpl.delete(student);
		assertEquals(1,flag);
	}
	
	@Test
	public void deleteStudentFailed() throws Exception 
	{
		Student student=new Student();
		student.setStudentid(2);
		StudentServiceimpl studentServiceimpl = new StudentServiceimpl();
		int flag=studentServiceimpl.delete(student);
		assertEquals(0,flag);	
	}
}
