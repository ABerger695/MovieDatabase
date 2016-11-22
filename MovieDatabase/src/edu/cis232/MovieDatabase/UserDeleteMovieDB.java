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
			//page 1104
		}

	}

}
