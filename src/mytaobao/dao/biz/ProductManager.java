/**
 * 
 */
package mytaobao.dao.biz;

import java.util.List;

import mytaobao.dao.IProductService;
import mytaobao.daompl.ProductService;
import mytaobao.model.Product;

/**
 * @author kawachi
 *
 */
public class ProductManager {
	private IProductService dao = null;
	
	public ProductManager() {
		dao = new ProductService();
	}

	public List<Product> getProductByPage(int pageIndex, int pageSize) {
		return dao.getByPage(pageIndex, pageSize);
	}
	
	public List<Product> getProductByName(String name) {
		return dao.getByName(name);
	}
	
	public boolean addProduct(Product p) throws Exception{
		try {
			this.dao.insert(p);
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public boolean addProduct(int id, String name, int category, int photo,
			double unitPrice, String note) throws Exception {
		Product p = new Product(id, name, category, photo, unitPrice, note);
		return this.addProduct(p);
	}
	
	public boolean modifyProduct(Product p) throws Exception {
		try {
			this.dao.modify(p);
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public boolean modifyProduct(int id, String name, int categoryId, int photo,
			double unitPrice, String note) throws Exception {
		Product p = this.dao.getById(id);
		p.setName(name);
		p.setCategoryId(categoryId);
		p.setPhoto(photo);
		p.setUnitPrice(unitPrice);
		p.setNote(note);
		return this.modifyProduct(p);
	}
	
	public boolean delProduct(int id) throws Exception{
		try {
			this.dao.del(id);
			return true;
		} catch (Exception ex) {
			throw ex;
		}
		
	}
}
