package model;

import java.sql.ResultSet;

import bean.Tem;
import dao.TemDao;

public class TemModel extends TableModel{
	public TemModel(ResultSet rs) {
		super(rs);
		
	}
	
	public static TableModel getTableModel(){
		TemDao td = new TemDao();
		ResultSet temRS = td.getResultSet();
		TemModel temModel = new TemModel(temRS);
		td.closeAll();
		return temModel;
	}
	
	public static TableModel searchModel(Tem tem){
		TemDao td = new TemDao();
		ResultSet temRS = td.getSearchRS(tem);
		TemModel temModel = new TemModel(temRS);
		td.closeAll();
		return temModel;
	}
	
	
}
