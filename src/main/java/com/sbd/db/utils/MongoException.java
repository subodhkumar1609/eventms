package com.sbd.db.utils;

public class MongoException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	private String errorMessage;
	
	public MongoException(int errorCode, String errorMessage)
	{
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public MongoException(int errorCode)
	{
		this.errorCode = errorCode;
	}
	
	public int getErrorCode()
	{
		return errorCode;
	}
	public void setErrorCode(int errorCode)
	{
		this.errorCode = errorCode;
	}
	public String getErrorMessage()
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString()
	{
		return "MongoException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
}
