package com.chanti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chantidb","root", "chanti");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("--------------------------------");
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("ENO")+"\t");
				System.out.print(resultSet.getString("ENAME")+"\t");
				System.out.print(resultSet.getFloat("ESAL")+"\t");
				System.out.println(resultSet.getString("Eaddr")+"\t");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
