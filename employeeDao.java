package com.assignment.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.assignment.web.model.employeeDisplay;
import com.assignment.web.model.employeee;

public class employeeDao {
	String connectionURL = "jdbc:mysql://localhost:3306/employeedetails";
	Connection con = null;
//method to add employees in employee table
	public int addemploee(employeee e) {
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(connectionURL, "root", "123");
			PreparedStatement psmnt = con
					.prepareStatement("insert into employee(fname, lname, age, salary, department_id) values ('"
							+ e.getFname() + "','" + e.getLname() + "','" + e.getAge() + "','" + e.getSalary() + "','"
							+ e.getDepartmentId() + "')");
			result = psmnt.executeUpdate();

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
		return result;
	}
	
//method to get employees from employee table
	public ArrayList<employeeDisplay> getEmployee() {
		ArrayList<employeeDisplay> employeelist = new ArrayList<employeeDisplay>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(connectionURL, "root", "123");
			PreparedStatement ps = con.prepareStatement(
					"select employee.eid, employee.fname, employee.lname, employee.age, employee.salary,department.department_name from employee, department where employee.department_id=department.department_id");
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				employeeDisplay empl = new employeeDisplay();
				int id = results.getInt("eid");
				String fname = results.getString("fname");
				String lname = results.getString("lname");
				int age = results.getInt("age");
				float salary = results.getFloat("salary");
				String departName = results.getString("department_name");
				empl.setFname(fname);
				empl.setLname(lname);
				empl.setAge(age);
				empl.setSalary(salary);
				empl.setDepartmentName(departName);
				employeelist.add(empl);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeelist;

	}

}
