package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.FoodInfoDao;



@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {
	private static ResultSetMetaData rsmd = null;
	private static String[] columnName;
	private static int columnCount;
	private static int rowCount;
	private static List<Object[]> als =null;
	public TableModel() {
		
	}
	
	public TableModel(ResultSet rs) {
		try {
			rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();
			als = new ArrayList<Object[]>();
			columnName = new String[columnCount];
			for(int i = 0;i<columnCount;i++){
				columnName[i]=rsmd.getColumnName(i+1);
			}
			
			while(rs.next()){
				Object[] row = new Object[columnCount];
				for(int i = 0;i<columnCount;i++){
					row[i] = rs.getObject(i+1);
				}
				als.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		rowCount = als.size();
		return rowCount;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnCount;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return als.get(rowIndex)[columnIndex];
	}
	
	public String getColumnName(int column) {
        return columnName[column];
    }
	
////测试用的
//	public static void main(String[] args) {
//		FoodInfoDao fd = new FoodInfoDao();
//		ResultSet rs = fd.getResultSet();
//		TableModel tm = new TableModel(rs);
//		System.out.println(tm.getColumnCount());
//		System.out.println(als.size());
//		System.out.println(tm.getValueAt(0, 1));
//		System.out.println(tm.getColumnName(1));
//		
//	}
}
