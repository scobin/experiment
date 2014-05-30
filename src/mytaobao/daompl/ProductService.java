/**
 * 
 */
package mytaobao.daompl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mytaobao.dao.IProductService;
import mytaobao.model.Product;

/**
 * @author kawachi
 *
 */
public class ProductService implements IProductService {

	//data for demo
	private Product[] products = {
		new Product(1, "product1", 0, 0, 10, null),
		new Product(2, "product2", 0, 0, 20, null),
		new Product(3, "product3", 0, 0, 30, null),
		new Product(4, "product4", 0, 0, 40, null),
		new Product(5, "product5", 0, 0, 50, null),
		new Product(6, "product6", 0, 0, 60, null),
		new Product(7, "product7", 0, 0, 70, null),
		new Product(8, "product8", 0, 0, 80, null),
		new Product(9, "product9", 0, 0, 90, null),
		new Product(10, "product10", 0, 0, 100, null),
		new Product(11, "product11", 0, 0, 110, null),
		new Product(12, "product12", 0, 0, 120, null)
	};
	
	private List<Product> ps = null;
	
	public ProductService() {
		ps = Arrays.asList(products);
	}
	
	@Override
	public List<Product> getAll() {
		//List<Product> ps = Arrays.asList(products);
		return this.ps;
	}

    /**
     * get the products by pager
     * @param pageIndex index of the page.
     * @param pageSize the size of every page.
     */
	@Override
	public List<Product> getByPage(int pageIndex, int pageSize) {
		int totalCount = this.ps.size(); // total number of products.
		int pageCount = 1; // total number of pages.
		//Calculate the pageCount.
		if ((totalCount % pageSize) == 0)
			pageCount = totalCount / pageSize;
		else
			pageCount = totalCount / pageSize + 1;
		// Check the pageIndex
		if (pageIndex < 0) 
			pageIndex = 0;
		if (pageIndex > pageCount - 1)
			pageIndex = pageCount - 1;
 
		List<Product> result = new ArrayList<Product>();
		for(int i = pageIndex + pageSize; i < (pageIndex + 1)*pageSize; i++ ) {
			result.add(this.ps.get(i));
		}
		return result;
	}
	
	@Override
	public Product getById(int productId) {
		for (Product p : this.ps) {
			if (p.getId() == productId) {
				return p;
			}
		}
		return null;
	}

	
	@Override
	public List<Product> getByName(String name) {
		List<Product> result = new ArrayList<Product>();
		for (Product p : this.ps) {
			if (p.getName().indexOf(name) != -1) {
				result.add(p);
			}
		}
		return result;
	}

	
	@Override
	public void insert(Product product) {
		this.ps.add(product);

	}

	
	@Override
	public void modify(Product product) {
		for (int i = 0; i < this.ps.size(); i++) {
			if (product.getId() == this.ps.get(i).getId()) {
				this.ps.set(i, product);
				break;
			}
		}

	}

	
	@Override
	public void del(int productId) {
		Product p = this.getById(productId);
		if (p != null) {
			this.ps.remove(p);
		}

	}


}
