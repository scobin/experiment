/**
 * 
 */
package mytaobao.dao;

import java.util.List;

import mytaobao.model.Product;

/**
 * Product Interface
 * @author kawachi
 *
 */
public interface IProductService {

	/**
	 * get all product.
	 * @return
	 */
	public List<Product> getAll();
	
	public List<Product> getByPage(int pageIndex, int pageSize);
	
	/**
	 * get a product by id.
	 * @param productId
	 * @return
	 */
	public Product getById(int productId);
	
	/**
	 * get a product by name.
	 * @param name
	 * @return
	 */
	public List<Product> getByName(String name);
	
	/**
	 * insert a product.
	 * @param product
	 */
	public void insert(Product product);
	
	/**
	 * modify a product.
	 * @param product
	 */
	public void modify(Product product);
	
	/**
	 * delete a product.
	 * @param productId
	 */
	public void del(int productId);
}
