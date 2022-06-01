package WebBuild;

import java.io.Serializable;
public class HistoryBean implements Serializable{
	
	public static final long serialVersionUID = 1L;
	
	private String itemId;
	private String itemName;
	private int quanlity;
	
	public HistoryBean() {
		
		itemId ="";
		itemName ="";
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

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

}
