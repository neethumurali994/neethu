package com.assignment.web.model;
//object of department
public class Department {
private int deparId;
private String depart;
public int getDeparId() {
	return deparId;
}
public void setDeparId(int deparId) {
	this.deparId = deparId;
}
public String getDepart() {
	return depart;
}
public void setDepart(String depart) {
	this.depart = depart;
}
@Override
public String toString() {
	return "Department [deparId=" + deparId + ", depart=" + depart + "]";
}


}
