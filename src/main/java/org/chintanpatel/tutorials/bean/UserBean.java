/**
 * Created by IntelliJ IDEA.
 * User: chintanpatel
 * Date: 28/07/22
 * Time: 3:01 pm
 * To change this template use File | Settings | File Templates.
 */
package org.chintanpatel.tutorials.bean;

public class UserBean {

	private int userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private long mobile;
	private String userName;
	private String password;

	public UserBean() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
