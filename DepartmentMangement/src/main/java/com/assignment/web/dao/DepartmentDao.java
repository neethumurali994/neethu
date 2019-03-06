package com.assignment.web.dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao {

	String id = "";
	int deptId;

	// method to get department name from department table
	public int getDepartmentId(String department) {

		String connectionURL = "jdbc:mysql://localhost:3306/employeedetails";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(connectionURL, "root", "123");
			PreparedStatement psmnt = con.prepareStatement("select * from department");
			ResultSet results = psmnt.executeQuery();
			while (results.next()) {
				if (results.getString("department_name").equals(department)) {
					id = results.getString("department_id");
				}

			}
			deptId = Integer.parseInt(id);
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return deptId;

	}
}
