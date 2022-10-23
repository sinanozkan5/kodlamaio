package kodlamaio.business;

import java.util.List;
import kodlamaio.core.logging.Logger;
import kodlamaio.dataAccess.CategoryDao;
import kodlamaio.entities.Category;

public class CategoryManager {
	private CategoryDao categoryDao;
	private Logger[] loggers;
	private List<Category> categories;
	
	public CategoryManager(CategoryDao categoryDao,Logger[] loggers,List<Category> categories) {
		this.categoryDao = categoryDao;
		this.loggers = loggers;
		this.categories = categories;
	}
	public void add(Category category) throws Exception {
		
		for (Category cat : categories) {
			if(cat.getCategoryName().equals(category.getCategoryName())) {
				throw new Exception("Kategori ismi tekrar edemez.");
			}
		}
		categories.add(category);
	    categoryDao.add(category);
		for (Logger logger : loggers) {
			logger.log(category.getCategoryName());
		}
		
	}
}