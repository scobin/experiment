/**
 * 
 */
package mytaobao.dao;

import java.util.List;
import mytaobao.model.Category;

/**
 * Category interface
 * @author kawachi
 *
 */
public interface ICategoryService {

	/**
	 * get all category.
	 * @return
	 */
	public List<Category> getAll();
	
	/**
	 * get a category by id.
	 * @param categoryId
	 * @return
	 */
	public Category getById(int categoryId);
}
