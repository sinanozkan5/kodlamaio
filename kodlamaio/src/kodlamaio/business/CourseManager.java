package kodlamaio.business;

import java.util.List;
import kodlamaio.core.logging.Logger;
import kodlamaio.dataAccess.CourseDao;
import kodlamaio.entities.Course;

public class CourseManager {
	private CourseDao courseDao;
	private Logger[] loggers;
	private List<Course> courses;
	
	public CourseManager(CourseDao courseDao,Logger[] loggers,List<Course> courses) {
		this.courseDao = courseDao;
		this.loggers = loggers;
		this.courses = courses;
	}
	
public void add(Course course) throws Exception {
		
		for (Course cour : courses) {
			if(cour.getCourseName().equals(course.getCourseName())) {
				throw new Exception("Kurs ismi tekrar edemez.");
			}
		}
		courses.add(course);
		
		if (course.getPrice() < 0) {
			throw new Exception("Bir kursun fiyatı 0 dan küçük olamaz.");
		}
		
		courseDao.add(course);
		for (Logger logger : loggers) {
			logger.log(course.getCourseName());
		}
	}
}
