/**
 * Created by IntelliJ IDEA.
 * User: chintanpatel
 * Date: 28/07/22
 * Time: 3:10 pm
 * To change this template use File | Settings | File Templates.
 */
package org.chintanpatel.tutorials.dao;

import org.chintanpatel.tutorials.bean.UserBean;
import org.chintanpatel.tutorials.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	// Create method to insert user details

	public boolean insertUser(UserBean userBean) {
		boolean flag = false;
		try (Connection connection = DBConnection.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("insert into tbl_user(firstName,lastName,emailId,mobile,userName,password)values(?,?,?,?,?,?)")){
					preparedStatement.setString(1, userBean.getFirstName());
					preparedStatement.setString(2, userBean.getLastName());
					preparedStatement.setString(3, userBean.getEmailId());
					preparedStatement.setLong(4,userBean.getMobile());
					preparedStatement.setString(5, userBean.getUserName());
					preparedStatement.setString(6, userBean.getPassword());
					int noOfRecordsAffected = preparedStatement.executeUpdate();
					if (noOfRecordsAffected > 0) {
						flag = true;
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// Create method to update user details

	public boolean updateUser(UserBean userBean) {
		boolean flag = false;
		try (Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update tbl_user set firstName=?,lastName=?,emailId=?,mobile=?,userName=?,password=? where userId=?")){
					preparedStatement.setString(1, userBean.getFirstName());
					preparedStatement.setString(2, userBean.getLastName());
					preparedStatement.setString(3, userBean.getEmailId());
					preparedStatement.setLong(4,userBean.getMobile());
					preparedStatement.setString(5, userBean.getUserName());
					preparedStatement.setString(6, userBean.getPassword());
					preparedStatement.setInt(7,userBean.getUserId());
					int noOfRecordsAffected = preparedStatement.executeUpdate();
					if (noOfRecordsAffected > 0) {
						flag = true;
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// Create method to delete user details

	public boolean deleteUserById(int userId) {
		boolean flag = false;
		try (Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from tbl_user where userId=?")){
					preparedStatement.setInt(1,userId);
					int noOfRecordsAffected = preparedStatement.executeUpdate();
					if (noOfRecordsAffected > 0) {
						flag = true;
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// Create method to fetch all user records

	public List<UserBean>getAllUserList() {
		List<UserBean>userList = new ArrayList<>();
		UserBean userBean;
		try (Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_user");
			 ResultSet resultSet = preparedStatement.executeQuery()){
					if (resultSet != null) {
						while (resultSet.next()) {
							userBean = new UserBean();
							userBean.setUserId(resultSet.getInt("userId"));
							userBean.setFirstName(resultSet.getString("firstName"));
							userBean.setLastName(resultSet.getString("lastName"));
							userBean.setEmailId(resultSet.getString("emailId"));
							userBean.setMobile(resultSet.getLong("mobile"));
							userBean.setUserName(resultSet.getString("userName"));
							userBean.setPassword(resultSet.getString("password"));
							userList.add(userBean);
						}
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	// Create method to get single user record

	public UserBean getUserById(int userId) {
		UserBean userBean = null;
		ResultSet resultSet = null;
		try (Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_user where userId=?")){
				preparedStatement.setInt(1,userId);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					if (resultSet.next()) {
						userBean = new UserBean();
						userBean.setUserId(resultSet.getInt("userId"));
						userBean.setFirstName(resultSet.getString("firstName"));
						userBean.setLastName(resultSet.getString("lastName"));
						userBean.setEmailId(resultSet.getString("emailId"));
						userBean.setMobile(resultSet.getLong("mobile"));
						userBean.setUserName(resultSet.getString("userName"));
						userBean.setPassword(resultSet.getString("password"));
					}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userBean;
	}
}
