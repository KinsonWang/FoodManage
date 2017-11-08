package model;

import java.sql.ResultSet;

import dao.UserDao;

@SuppressWarnings("serial")
public class UserModelTM extends TableModel {

	public UserModelTM(ResultSet rs) {
		super(rs);
	}
	
	public static TableModel getUserModelTM(){
		UserDao ud = new UserDao();
		ResultSet userRS = ud.getResultSet();
		UserModelTM userInfoTM = new UserModelTM(userRS);
		ud.closeAll();
		return userInfoTM;
		
	}
}
