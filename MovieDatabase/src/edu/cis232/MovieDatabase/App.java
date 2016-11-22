package edu.cis232.MovieDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	final String DB_URL = "jdbc:hsqldb:file:MovieDB/movie";
    	
    	String sqlStatement = "SELECT * FROM MOVIE ORDER BY ID";
    	
    	Connection conn = DriverManager.getConnection(DB_URL);
    	
    	Statement stmt = conn.createStatement();
    	
    	ResultSet result = stmt.executeQuery(sqlStatement);
    	
    	while(result.next()){
    		System.out.println(result.getString("ID") + " " + result.getString("Title") + " " + result.getInt("YearReleased"));
    	}
    	
    	conn.close();
    }
}