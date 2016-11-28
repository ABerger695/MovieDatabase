package edu.cis232.MovieDatabase;

import java.sql.*;
import java.util.Scanner;

public class UserDeleteMovieDB {

	public static void main(String[] args) {
		final String DB_URL = "jdbc:hsqldb:file:MovieDB/movie";
		
		Scanner keyboard = new Scanner(System.in);
		
		try{
			Connection conn = DriverManager.getConnection(DB_URL);
			
			Statement stmt = conn.createStatement();
			
			System.out.println("Enter the movie ID you'd like to delete:");
			int ID = keyboard.nextInt();
			
			if (findAndDisplayMovie(stmt, ID)){
				System.out.println("Are you sure you want to delete " + "this movie? (y/n): ");
				String confirm = keyboard.nextLine();
				
				if (Character.toUpperCase(confirm.charAt(0)) == 'Y'){
					deleteMovie(stmt, ID);
				}
				else{
					System.out.println("The movie was not deleted.");
				}
			}
			else{
				System.out.println("That movie cannot be found.");
			}
			
			conn.close();
		}
		catch(Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}

	}

	public static void deleteMovie(Statement stmt, int iD) throws SQLException{
		String sqlStatement = "DELETE FROM Movie WHERE ID = '" + ID + "'";
		
		int rows = stmt.executeUpdate(sqlStatement);
		
		System.out.println(rows + " row(s) deleted.");
		
	}

	public static boolean findAndDisplayMovie(Statement stmt, int iD) throws SQLException {
		boolean movieFound;
		
		String sqlStatement = "SELECT * FROM Movie WHERE ID = '" + ID + "'";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		
		if(result.next()){
			System.out.println("ID Number: " + result.getInt("ID: "));
			System.out.println("Title: " + result.getString("Title: "));
			System.out.println("Runtime in minutes: " + result.getInt("RuntimeMinutes: "));
		}
		else{
			movieFound = false;
		}
		
		return movieFound;
	}
}
