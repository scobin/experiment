package mytaobao.model;

/**
 * Product class
 * @author kawachi
 *
 */
public class Product {

	private int id;
	private String name;
	private int categoryId;
	private int photo;
	private double unitPrice;
	private String note;
	/**
	 * 
	 * @param id
	 * @param name
	 * @param categoryId
	 * @param photo
	 * @param unitPrice
	 * @param note
	 */
	public Product(int id, String name, int categoryId, int photo,
			double unitPrice, String note) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.photo = photo;
		this.unitPrice = unitPrice;
		this.note = note;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the photo
	 */
	public int getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(int photo) {
		this.photo = photo;
	}
	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
