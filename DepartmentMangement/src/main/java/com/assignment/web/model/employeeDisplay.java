package com.assignment.web.model;
//object of employee to be display
public class employeeDisplay {
	private int employeeId;
	private String fname;
	private String lname;
	private int age;
	private float salary;
	private String departmentName;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "employeeDisplay [employeeId=" + employeeId + ", fname=" + fname + ", lname=" + lname + ", age=" + age
				+ ", salary=" + salary + ", departmentName=" + departmentName + ", getEmployeeId()=" + getEmployeeId()
				+ ", getFname()=" + getFname() + ", getLname()=" + getLname() + ", getAge()=" + getAge()
				+ ", getSalary()=" + getSalary() + ", getDepartmentName()=" + getDepartmentName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
