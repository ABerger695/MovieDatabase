package edu.cis232.MovieDatabase;

import java.sql.*;
import java.util.Scanner;

public class UserFilterMovieDB {

	public static void main(String[] args) {
		int directorCount = 0;
		String director;
		
		final String DB_URL = "jdbc:hsqldb:file:MovieDB/movie";
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the Director you'd like to filter by: ");
		director = keyboard.nextLine();
		
		try{
			Connection conn = DriverManager.getConnection(DB_URL);
			
			Statement stmt = conn.createStatement();
			
			String sqlStatement = "SELECT * FROM Movie WHERE Director = '" + director + "'";
			
			ResultSet result = stmt.executeQuery(sqlStatement);
			
			while (result.next()){
				System.out.printf("%s %s %d\n", result.getString("Director"),
						result.getString("Title"),
						result.getInt("RuntimeMinutes"));
				directorCount++;
			}
			
			conn.close();
		}
		catch(Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}

	}

}
