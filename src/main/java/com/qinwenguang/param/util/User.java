package com.qinwenguang.param.util;

/**
 * @author zhukuo 2019年4月28日
 */
public class User {
	
	private Integer userId;
	private String userName;
	private String password;
	
	/**
	 * 
	 */
	public User() {
		super();
	}
	/**
	 * @param userId
	 * @param userName
	 */
	public User(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public User setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
}
