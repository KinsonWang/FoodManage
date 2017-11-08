package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.FoodInfo;

/**
 * 
 * @author wk
 *
 */
public class FoodInfoDao {
	GetConnection connection = new GetConnection();
	Connection conn = null;
	
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	int ret;
	
	public ResultSet getResultSet(){
		conn = connection.getCon();
		String sql = "SELECT foodname as foodName,fooddesc as description from foodinfo";
			try {
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return rs;
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

	public int insert(FoodInfo foodInfo) {
		conn = connection.getCon();
		String sql = "insert into foodinfo(foodname,fooddesc) values (?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, foodInfo.getFoodName());
			pstm.setString(2, foodInfo.getFoodDesc());
			ret = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public int deleteByName(String foodName) {
		conn = connection.getCon();
		String sql = "delete from foodinfo where foodname = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, foodName);
			ret = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public int updateByName(FoodInfo foodInfo,String foodName) {
		conn = connection.getCon();
		String sql = "update foodinfo set foodname = ?,fooddesc = ? where foodname = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, foodInfo.getFoodName());
			pstm.setString(2, foodInfo.getFoodDesc());
			pstm.setString(3, foodName);
			ret = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
