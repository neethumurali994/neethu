package com.assignment.web.model;

public class employeee {

	private int employeeId;
	private String fname;
	private String lname;
	private int age;
	private float salary;
	private int departmentId;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "employeee [employeeId=" + employeeId + ", fname=" + fname + ", lname=" + lname + ", age=" + age
				+ ", salary=" + salary + ", departmentId=" + departmentId + ", getEmployeeId()=" + getEmployeeId()
				+ ", getFname()=" + getFname() + ", getLname()=" + getLname() + ", getAge()=" + getAge()
				+ ", getSalary()=" + getSalary() + ", getDepartmentId()=" + getDepartmentId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
