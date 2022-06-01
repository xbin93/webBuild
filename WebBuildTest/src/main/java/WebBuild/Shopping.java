package WebBuild;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Shopping {
		
	
	public ArrayList<ItemBean> getItem(){
		
		ArrayList<ItemBean> beanList = new ArrayList<ItemBean>();
		ShoppingDao dao = null;
		ResultSet rs = null;
		
		try {
			
			dao = new ShoppingDao();
			
			rs = dao.selectItem();
			
			while(rs.next()) {
				
				ItemBean bean = new ItemBean();
				
				bean.setItemId(rs.getString("item_id"));
				
				bean.setItemName(rs.getString("item_name"));
				
				bean.setPrice(rs.getInt("price"));
				
				bean.setQuanlity(rs.getInt("quanlity"));
				
				beanList.add(bean);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			dao.close();
		}
		
		return beanList;
	}
	
	
	public ItemBean getItem(String itemId) {

		ItemBean bean = new ItemBean();
		ShoppingDao dao = null;
		ResultSet rs = null;
		
		try {
			
			dao = new ShoppingDao();
			rs = dao.selectItem(itemId);
			
			while(rs.next()) {
				
				bean.setItemId(itemId);
				
				bean.setItemName(rs.getString("item_name"));
				
				bean.setPrice(rs.getInt("price"));
				
				bean.setQuanlity(rs.getInt("quanlity"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			dao.close();
		}
		
		return bean;
	}

	
	public ArrayList<HistoryBean> getHistory(String id){
		
		ArrayList<HistoryBean> beanList = new ArrayList<HistoryBean>();
		ShoppingDao dao = null;
		ResultSet rs = null;
		
		try {
			
			dao = new ShoppingDao();
			
			rs = dao.selectHistory(id);
			
			while(rs.next()) {
				
				HistoryBean bean = new HistoryBean();
				
				bean.setItemId(rs.getString("item_id"));
				
				bean.setItemName(rs.getString("item_name"));
				
				bean.setQuanlity(rs.getInt("quanlity"));
				
				beanList.add(bean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dao.close();
		}
		return beanList;
	}
}

