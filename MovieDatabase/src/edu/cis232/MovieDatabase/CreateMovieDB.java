package edu.cis232.MovieDatabase;

import java.sql.*;


public class CreateMovieDB {
	public static void main(String[] args) throws Exception{

		final String DB_URL = "jdbc:hsqldb:file:MovieDB/movie";

		try {
			Connection conn = DriverManager.getConnection(DB_URL);

			dropTables(conn);

			buildMovieTable(conn);

			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	public static void dropTables(Connection conn) {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			Statement stmt = conn.createStatement();
			;

			try {
				// Drop the Coffee table.
				stmt.execute("DROP TABLE Movie");
				System.out.println("Movie table dropped.");
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static void buildMovieTable(Connection conn) {
		try {
			Statement stmt = conn.createStatement();

			stmt.execute("CREATE TABLE Movie (" + "ID INT IDENTITY PRIMARY KEY, " + "Title CHAR(30), " + "Director CHAR(30), " + "Genre CHAR(20),"
					+ " " + "YearReleased INT, " + "RuntimeMinutes INT " + ")");

			stmt.execute("INSERT INTO Movie(Title,Director, Genre, YearReleased, RuntimeMinutes) VALUES ( " 
					+ "'Transporter', " 
					+ "'Louis Leterrier', " 
					+ "'Action', " 
					+ "2002, " 
					+ "92 )");

			stmt.execute("INSERT INTO Movie(Title,Director, Genre, YearReleased, RuntimeMinutes) VALUES ( " 
					+ "'Crank', " 
					+ "'Taylor Neveldine', " 
					+ "'Action', " 
					+ "2006, " 
					+ "88 )");

			stmt.execute("INSERT INTO Movie(Title,Director, Genre, YearReleased, RuntimeMinutes) VALUES ( " 
					+ "'Death Race', " 
					+ "'Paul W.S. Anderson', " 
					+ "'Action', " 
					+ "2008, " 
					+ "110 )");

			stmt.execute("INSERT INTO Movie(Title,Director, Genre, YearReleased, RuntimeMinutes) VALUES ( " 
					+ "'The Expendables', " 
					+ "'Sylvester Stallone', " 
					+ "'Action', " 
					+ "2010, " 
					+ "103 )");

			stmt.execute("INSERT INTO Movie(Title,Director, Genre, YearReleased, RuntimeMinutes) VALUES ( " 
					+ "'War', " 
					+ "'Philip G. Atwell', " 
					+ "'Action', " 
					+ "2007, " 
					+ "103 )");

			System.out.println("Movie table created.");
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
}