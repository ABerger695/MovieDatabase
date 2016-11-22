package edu.cis232.MovieDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInsertMovieDB {

	public static void main(String[] args) throws SQLException{
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Give me a title:");
		String title = keyboard.nextLine();
		System.out.println("Who was the Director:");
		String director = keyboard.nextLine();
		System.out.println("What Genre is it:");
		String genre = keyboard.nextLine();
		System.out.println("When was it released:");
		int year = keyboard.nextInt();
		System.out.println("What's the run-time in minutes:");
		int run = keyboard.nextInt();
		
		final String DB_URL = "jdbc:hsqldb:file:MovieDB/movie";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
	
		String sql = "INSERT INTO MOVIE"
					 + " (Title, Director, Genre, YearReleased, RuntimeMinutes)"
					 + " VALUES "
					 + " (?, ?, ?, ?, ?);";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, title);
		stmt.setString(2, director);
		stmt.setString(3, genre);
		stmt.setInt(4, year);
		stmt.setInt(5, run);
		
		stmt.executeUpdate();
		
		conn.close();
		
		System.out.println("Inserted Movie! It better have Jason Statham.");
	}

}