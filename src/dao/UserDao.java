package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserDao {
	GetConnection connection = new GetConnection();
	Connection conn = null;
	
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	int ret;
	//按用户名与密码查询用户方法
	public User getUser(String userName,String userPswd){
		User user = new User();
		conn = connection.getCon();
		String sql = "select * from user where username = ? and userpswd = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, userPswd);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPswd(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public ResultSet getResultSet(){
		conn = connection.getCon();
		String sql = "select userName,userpswd as password from user";
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

	public int insert(User user) {
		conn = connection.getCon();
		String sql = "insert into user(username,userpswd) values (?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getUserPswd());
			ret = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public int deleteByName(String userName) {
		conn = connection.getCon();
		String sql = "delete from user where username = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			ret = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public int updateByName(User user, String name) {
		conn = connection.getCon();
		String sql = "update user set username = ?,userpswd = ? where username = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getUserPswd());
			pstm.setString(3, name);
			ret = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	
	
	
}
