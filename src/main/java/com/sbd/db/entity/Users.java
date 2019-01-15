package com.sbd.db.entity;

public class Users extends CommonBean
{
	private Groups group;
	private String email, name, statusId, password, userType, authKey, newPassword;
	
	public String getAuthKey()
	{
		return authKey;
	}
	public void setAuthKey(String authKey)
	{
		this.authKey = authKey;
	}
	public Groups getGroup()
	{
		return group;
	}
	public void setGroup(Groups group)
	{
		this.group = group;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getStatusId()
	{
		return statusId;
	}
	public void setStatusId(String statusId)
	{
		this.statusId = statusId;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getUserType()
	{
		return userType;
	}
	public void setUserType(String userType)
	{
		this.userType = userType;
	}
	
	public String getNewPassword()
	{
		return newPassword;
	}
	public void setNewPassword(String newPassword)
	{
		this.newPassword = newPassword;
	}
	@Override
	public String toString()
	{
		return "Users [group=" + group + ", email=" + email + ", name=" + name + ", statusId=" + statusId
				+ ", password=MASKED, userType=" + userType + ", getId()=" + getId() + "]";
	}
}
