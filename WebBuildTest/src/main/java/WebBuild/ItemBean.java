package WebBuild;

import java.io.Serializable;
public class ItemBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String itemId;
	private String itemName;
	private int price;
	private int quanlity;
	
	public ItemBean() {
		
		itemId ="";
		itemName ="";
		price = 0;
		quanlity = 0;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

}
