package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Tem;

/**
 * 
 * @author wk
 *
 */
public class TemDao {
	GetConnection connection = new GetConnection();
	Connection conn = null;
	
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	int ret;
	
	public ResultSet getResultSet(){
		conn = connection.getCon();
		String sql = "SELECT foodname as foodName,tem as temperature,hum as humidity,date from tem";
			try {
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return rs;
	}
	
	public ResultSet getSearchRS(Tem tem){
		conn = connection.getCon();
		String sql = "SELECT foodname as foodName,tem as temperature,hum as humidity,date from tem where foodName = ? and date =?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tem.getFoodName());
			pstm.setDate(2, java.sql.Date.valueOf(tem.getDate()));
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	public int insert(Tem tem) {
		conn = connection.getCon();
		String sql = "insert into tem(foodname,tem,hum,date) values (?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tem.getFoodName());
			pstm.setString(2, tem.getTem());
			pstm.setString(3, tem.getHum());
			pstm.setDate(4, java.sql.Date.valueOf(tem.getDate()));
			ret = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
