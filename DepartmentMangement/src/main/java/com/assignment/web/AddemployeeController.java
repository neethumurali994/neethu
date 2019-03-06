package com.assignment.web;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.web.dao.DepartmentDao;
import com.assignment.web.dao.employeeDao;
import com.assignment.web.model.employeeDisplay;
import com.assignment.web.model.employeee;

/**
 * Servlet implementation class AddemployeeController
 */
public class AddemployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    
    public AddemployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	ArrayList<employeeDisplay> employeeList = new ArrayList<employeeDisplay>();
	employeeDao showemp = new employeeDao();
	employeeList = showemp.getEmployee();
	
	request.setAttribute("list", employeeList);
	RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
	rs.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message="";
		employeee emp=new employeee();
		employeeDao addEmp = new employeeDao();
		DepartmentDao dept = new DepartmentDao();
		
	emp.setFname(request.getParameter("fname"));
	emp.setLname(request.getParameter("lname"));
	emp.setAge(Integer.parseInt((request.getParameter("age"))));
	emp.setSalary(Float.parseFloat(request.getParameter("salary")));
	int id = dept.getDepartmentId(request.getParameter("Depart"));
	emp.setDepartmentId(id);
	int result = addEmp.addemploee(emp);
	if(result>0)
	{
		message ="Employee Details Entered Successfully! ";
		request.setAttribute("msg",message );
		
	}
	RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
	rs.forward(request, response);
		
	}

}
