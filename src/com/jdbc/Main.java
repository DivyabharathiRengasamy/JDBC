package com.jdbc;

import java.sql.*;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DeleteDetails();
		
	}
	public static void getDetails() throws ClassNotFoundException, SQLException {
		
		String query="select * from studentlist;";
		Connection connection =DbConnection.getConnection();
		Statement statement= connection.createStatement();
		ResultSet set= statement.executeQuery(query);
		while(set.next()) {
		String data=set.getInt(1)+" "+set.getString(2);	
		System.out.println(data);
		}
		System.out.println("1 rows affected");
	}
	
	
	public static void addDetails() throws ClassNotFoundException, SQLException {
		Connection connection = DbConnection.getConnection();
		String query="insert into studentList values (?,?)";
		 PreparedStatement statement = connection.prepareStatement(query);
         statement.setInt(1, 1);
         statement.setString(2, "divyabharathi");

         // Execute the update after setting the parameters
         int rowsAffected = statement.executeUpdate();

         System.out.println(rowsAffected + " rows affected");
         connection.close();
	}
	public static void updateDetails() throws ClassNotFoundException, SQLException {
		Connection connection = DbConnection.getConnection();
		 // Assuming the studentList table has columns 'id' and 'name'
        int studentIdToUpdate = 1;
        String newName = "Divyabharathi";

        // Use a PreparedStatement for better parameterized queries
        String updateQuery = "UPDATE studentList SET name = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, newName);
        statement.setInt(2, studentIdToUpdate);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println(rowsAffected + " rows updated successfully.");
        } else {
            System.out.println("No rows updated.");
        }

        connection.close();
	}
	public static void DeleteDetails() throws ClassNotFoundException, SQLException {
		Connection connection = DbConnection.getConnection();
		 // Assuming the studentList table has columns 'id' and 'name'
        int studentIdToDelete = 1;

        // Use a PreparedStatement for better parameterized queries
        String deleteQuery = "DELETE FROM studentList WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, studentIdToDelete);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println(rowsAffected + " row(s) deleted successfully.");
        } else {
            System.out.println("No rows deleted. Check if the specified ID exists.");
        }

        connection.close();
	
	
	
}
}
	

