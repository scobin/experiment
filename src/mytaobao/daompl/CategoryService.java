/**
 * 
 */
package mytaobao.daompl;

import java.util.ArrayList;
import java.util.List;

import mytaobao.dao.ICategoryService;
import mytaobao.model.Category;

/**
 * @author kawachi
 *
 */
public class CategoryService implements ICategoryService{

	List<Category> categories = new ArrayList<Category>();
	@Override
	public List<Category> getAll() {
		categories.add(new Category(1,"phone"));
		categories.add(new Category(2,"pc"));
		categories.add(new Category(3,"clothes"));
		categories.add(new Category(4,"book"));
		return categories;
	}

	@Override
	public Category getById(int categoryId) {
		if (categories !=null) {
			return this.categories.get(categoryId - 1);
		} else {
			return null;
		}
	}

}
