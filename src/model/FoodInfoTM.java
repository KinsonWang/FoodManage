package model;

import java.sql.ResultSet;

import dao.FoodInfoDao;

@SuppressWarnings("serial")
public class FoodInfoTM extends TableModel {

	public FoodInfoTM(ResultSet rs) {
		super(rs);
		
	}
	
	public static TableModel getTableModel(){
		FoodInfoDao fd = new FoodInfoDao();
		ResultSet foodInfoRS = fd.getResultSet();
		FoodInfoTM foodInfoTM = new FoodInfoTM(foodInfoRS);
		fd.closeAll();
		return foodInfoTM;
	}
}