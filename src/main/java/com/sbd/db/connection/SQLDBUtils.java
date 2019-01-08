package com.sbd.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLDBUtils {

	public static void check() 
	{
		String connectionUrl =
                "jdbc:sqlserver://den1.mssql7.gear.host:1433;"
                        + "database=eventms1;"
                        + "user=eventms1@den1.mssql7.gear.host;"
                        + "password=Sq60_i~hgeuB;"
                        + "loginTimeout=30;";
		
		 ResultSet resultSet = null;

		 try (Connection connection = DriverManager.getConnection(connectionUrl);
	                Statement statement = connection.createStatement();) {

			    // Create and execute a SELECT SQL statement.
	            String selectSql = "create table GROUPS (	ID INT NOT NULL PRIMARY KEY,	REFERENCE [NVARCHAR](20) NOT NULL,	NAME [NVARCHAR](30) NOT NULL)";
	            statement.execute(selectSql);

	            // Print results from select statement
	            	                System.out.println("table created");
	            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        }
	}

