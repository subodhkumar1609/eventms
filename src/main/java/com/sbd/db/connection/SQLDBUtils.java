package com.sbd.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDBUtils {

	public static void check() 
	{
		String connectionUrl =
                "jdbc:sqlserver://den1.mssql7.gear.host:1433;"
                        + "database=eventms1;"
                        + "user=eventms1;"
                        + "password=Sq60_i~hgeuB;"
                        + "loginTimeout=30;";
		
		 ResultSet rs = null;

		 try (Connection conn = DriverManager.getConnection(connectionUrl);
	                Statement statement = conn.createStatement();) {

			 	String selectSql = "";
			    // Create and execute a SELECT SQL statement.
	           /// String selectSql = "create table GROUPS (	ID INT NOT NULL PRIMARY KEY,	REFERENCE [NVARCHAR](20) NOT NULL,	NAME [NVARCHAR](30) NOT NULL)";
	           // statement.execute(selectSql);

	            //selectSql = "create table USERS (GROUPID INT NOT NULL,	USERID [NVARCHAR](20) NOT NULL, NAME [NVARCHAR](50) NOT NULL, EMAILID [NVARCHAR](70), STATUS [NVARCHAR](1)  NOT NULL, PASSWORD [NVARCHAR](100) NOT NULL, USERTYPE[NVARCHAR](1) NOT NULL, PRIMARY KEY(GROUPID,USERID  ))";
	            //statement.execute(selectSql);
	            
	         /*   selectSql = "create table EVENTS (GROUPID INT NOT NULL,	EVENTID INT NOT NULL, NAME [NVARCHAR](20) NOT NULL, REFERENCE [NVARCHAR](20) NOT NULL, EVENTDATE [DATETIME]  NOT NULL,  status[NVARCHAR](1) NOT NULL, PRIMARY KEY(GROUPID,EVENTID))";
	            statement.execute(selectSql);
	            
	            selectSql = "create table PARTICIPANTGROUP (	EVENTID INT NOT NULL, PARTICIPANTGROUPGROUPID INT NOT NULL, PARTICIPANTGROUPNAME [NVARCHAR](20) NOT NULL, REMARKS [NVARCHAR](30) NOT NULL, amount [INT](1)  NOT NULL,  status[NVARCHAR](1) NOT NULL, PRIMARY KEY(EVENTID,PARTICIPANTGROUPGROUPID))";
	            statement.execute(selectSql);
	            
	            selectSql = "create table PARTICIPANTS (EVENTID INT NOT NULL,	PARTICIPANTID [INT] NOT NULL, PARTICIPANTGROUPGROUPID INT NOT NULL, NAME [NVARCHAR](50) NOT NULL, EMAILID [NVARCHAR](70), PAIDFLAG [NVARCHAR](1)  NOT NULL, attendflag [NVARCHAR](1) NOT NULL, PRIMARY KEY(PARTICIPANTID  ))";
	            statement.execute(selectSql);
	            

	            selectSql = "create table PARAMETERS (EVENTID INT NOT NULL,	PARAMID [INT] NOT NULL, NAME [NVARCHAR](50) NOT NULL, PARAMVALUE [NVARCHAR](100), PRIMARY KEY(EVENTID, PARAMID  ))";
	            statement.execute(selectSql);
	            
	            
	            selectSql = "create table EXPENSEGROUP (EVENTID INT NOT NULL,	EXPENSEGROUPID [INT] NOT NULL, NAME [NVARCHAR](50) NOT NULL, PRIMARY KEY(EVENTID, EXPENSEGROUPID  ))";
	            statement.execute(selectSql);
	            
	            
	            selectSql = "CREATE TABLE EXPENCES (EXPENSEID INT NOT NULL, EVENTID INT NOT NULL,USERID [NVARCHAR](20) NOT NULL, EXPENSEGROUPID [INT] NOT NULL, DETAILS [NVARCHAR](50), amount [INT]  NOT NULL, EXPENCETYPE [NVARCHAR](20), SETTLEMENTFLAG [NVARCHAR](1), REMARKS [NVARCHAR](30) NOT NULL , PRIMARY KEY(EXPENSEID))";
	            statement.execute(selectSql);
	            */
			 	
			 	columCount(conn, "GROUPS");
			 	
			 	columCount(conn, "USERS");
			 	
			 	columCount(conn, "EVENTS");
			 	
			 	columCount(conn, "PARTICIPANTGROUP");
			 	
			 	columCount(conn, "PARTICIPANTS");
			 	
			 	columCount(conn, "PARAMETERS");
			 	
			 	columCount(conn, "EXPENSEGROUP");
			 	
			 	columCount(conn, "EXPENCES");
			 	
	            
	            // Print results from select statement
	            	                System.out.println("tableS check");
	            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        }
	
		public static int columCount(Connection conn, String tableName) throws SQLException
		{
			ResultSet rs = null;
			try(Statement statement = conn.createStatement();)
			{
				int count = 0;
				String selectSql = "SELECT * FROM " + tableName;
				rs = statement.executeQuery(selectSql);
				
				count = rs.getMetaData().getColumnCount();
				System.out.println("TABLE NAME : " + tableName + " : " + count);
				return count;
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println("TABLE NAME : " + tableName + " : ERROR");
				return -1;
			}
			finally 
			{
				if (rs != null)
					rs.close();
			}
		}
	}

