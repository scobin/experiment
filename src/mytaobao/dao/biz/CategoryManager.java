/**
 * 
 */
package mytaobao.dao.biz;

import java.util.List;

import mytaobao.dao.ICategoryService;
import mytaobao.daompl.CategoryService;
import mytaobao.model.Category;

/**
 * @author kawachi
 *
 */
public class CategoryManager {
	private ICategoryService dao = null;
	
	public CategoryManager() {
		dao = new CategoryService();
	}

	public List<Category> getAll() {
		return dao.getAll();
	}

	public Category getById(int categoryId) {
		return dao.getById(categoryId);
	}
}
