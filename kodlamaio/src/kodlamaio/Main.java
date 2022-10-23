package kodlamaio;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.business.CategoryManager;
import kodlamaio.business.CourseManager;
import kodlamaio.core.logging.DatabaseLogger;
import kodlamaio.core.logging.FileLogger;
import kodlamaio.core.logging.Logger;
import kodlamaio.core.logging.MailLogger;
import kodlamaio.dataAccess.HibernateCategoryDao;
import kodlamaio.dataAccess.JdbcCategoryDao;
import kodlamaio.dataAccess.HibernateCourseDao;
import kodlamaio.dataAccess.JdbcCourseDao;
import kodlamaio.entities.Course;
import kodlamaio.entities.Category;

public class Main {

	public static void main(String[] args) throws Exception{
		Course course1 = new Course(1,"Java + React",500);
		Course course2 = new Course(2,"C# + Angular",1000);
		Course course3 = new Course(3,"Java2022",1500);
		List<Course> courses = new ArrayList<>();
		
		Logger[] loggers = { new DatabaseLogger(),new FileLogger(),new MailLogger()};
		
		CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers,courses);
		courseManager.add(course3);
		
		System.out.println("");
		
		Category category1 = new Category(1,"Frontend");
		Category category2 = new Category(2,"Backend");
		List<Category> categories = new ArrayList<>();
		
		CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers, categories);
		categoryManager.add(category2);
		
	}
}