package database

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import com.machinepublishers.jbrowserdriver.AppThread.Runner
import java.sql.CallableStatement;
import java.sql.Connection
import com.microsoft.sqlserver.jdbc.SQLServerConnection
import java.sql.Statement;
import com.sun.deploy.uitoolkit.impl.fx.Utils

public class DataBaseUtil {

	private static  def dbusername ="autoqa"
	private static  def dbpassword = 'SmartAutoQA@2017$'
	private static  def databaseURLQA ="jdbc:sqlserver://10.200.1.140;databaseName=scm7_0;"
	private	static  def dbClass = 'com.microsoft.sqlserver.jdbc.SQLServerDriver'

	public static def executeSQLQuery(String sqlQuery) throws Exception {

		Connection connection = null
		def resultValue = ""
		ResultSet rs

		// To connect with QA Database
		Class.forName(dbClass).newInstance()

		try {
			connection = DriverManager.getConnection(databaseURLQA, dbusername, dbpassword)
			if (connection != null) {
				println ( "Connected to the database...")
			} else {
				println ( "Failed to Connect to the database...")
			}
			Statement stmt = connection.createStatement()
			Boolean b = stmt.execute(sqlQuery)
			println (b)
			rs = stmt.executeQuery(sqlQuery)

			try {
				while (rs.next()) {
					resultValue = rs.getString(1).toString()
				}
			} catch (SQLException e) {
				e.printStackTrace()
			} catch (NullPointerException err) {
				println( "No Records obtained for this specific query")
				err.printStackTrace()
			}

		} catch (SQLException sqlEx) {
			println("SQL Exception:" + sqlEx.getStackTrace())
		} finally {
			connection.close()

		}
		println( "SQL Results: " + resultValue)
		return resultValue

	}
	

	public static Boolean executeUpdateandDeleteSQLQuery(String sqlQuery) throws Exception {

		String connectionUrl = "";
		Connection connection;
		Boolean resultValue = false;
		ResultSet rs;

		// To connect with QA Database
		Class.forName(dbClass).newInstance()
		try {
			connection = DriverManager.getConnection(databaseURLQA, dbusername, dbpassword);
			if (connection != null) {
				( "Connected to the database...");
			} else {
				println ("Database connection failed");
			}
			Statement stmt = connection.createStatement();

			rs = stmt.executeQuery(sqlQuery);

			try {
				while (rs.next()) {
					resultValue = true;
					return resultValue;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException err) {
				println("No Records obtained for this specific query");
				err.printStackTrace();
			}
			connection.close();

		} catch (SQLException sqlEx) {
			println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return resultValue;

	}

	public static int callStoredProcedure(String testEnv, int iCustomerId) throws Exception {

		String connectionUrl = "";
		Connection connection = null;
		ResultSet rs=null;
		//CallableStatement cs = null;
		int FinalResult = 0;
		// To connect with QA Database

	try {
		println( "Connecting to the database");
		Class.forName(dbClass).newInstance();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	try {
			connection = DriverManager.getConnection(connectionUrl, dbusername, dbpassword);
			if (connection != null) {
				( "Connected to the database...");
			} else {
				println ("Database connection failed");
			}
			String insertCusId = "{call AutoActivation(?)}";
			CallableStatement stmt  = connection.prepareCall(insertCusId);
			stmt.setInt(1, iCustomerId);
			stmt.execute();
			rs = stmt.getResultSet();
			try {
				rs.next();
				FinalResult = rs.getInt(1);
				System.out.println(FinalResult);
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException err) {
				println ("No Records obtained for this specific query");
				err.printStackTrace();
			}
			
			}catch (NullPointerException err) {
				println("No Records obtained for this specific query");
				err.printStackTrace();
			}
			connection.close();
			return FinalResult;
}
}
