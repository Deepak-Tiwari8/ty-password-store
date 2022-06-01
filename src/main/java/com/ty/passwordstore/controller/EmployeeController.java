package com.ty.passwordstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.passwordstore.dto.Employee;
import com.ty.passwordstore.service.EmployeeService;

public class EmployeeController extends HttpServlet {

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = req.getParameter("empName");
//		String phone = req.getParameter("empPhone");
//		String address = req.getParameter("address");
//		String gender = req.getParameter("gender");
//		String role = req.getParameter("Role");
//		Employee employee = new Employee();
//		employee.setName(name);
//		employee.setPhone(Long.parseLong(phone));
//		employee.setAddress(address);
//		employee.setGender(gender);
//		employee.setRole(role);
//
//		EmployeeService employeeService = new EmployeeService();
//		Employee emp = employeeService.saveEmployee(employee);
//		PrintWriter printWriter = resp.getWriter();
//		if (emp != null) {
//
//			printWriter.write("<html><body>");
//			printWriter.write("<h1> " + emp.getName() + ": your id is"+ emp.getId()+" </h1>");
//
//			printWriter.write("<h1>Employee saved into a database</h1>");
//		} else {
//			printWriter.write("<html><body>");
//			printWriter.write("<h1>Employee data  is not saved </h1>");
//			printWriter.write("</html></body>");
//		}
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String name = req.getParameter("name");
		String phone = req.getParameter("phone");

		Employee employee = new Employee();
		employee.setName(name);
		employee.setPhone(Long.parseLong(phone));

		EmployeeService employeeService = new EmployeeService();
		PrintWriter printWriter = resp.getWriter();

		Employee Emp1 = employeeService.validateEmployee(name, phone);
		if (Emp1 != null) {

			printWriter.write("<html><body>");
			printWriter.write("<h1> "+Emp1.getName()+"   " + Emp1.getPhone()+ "</h1>");
			printWriter.write("<h1> Login Successfull done");
		} else {
			printWriter.write("<h1>sorry employee email or phone is wrong  </h1>");
			printWriter.write("</html></body>");
		}
    }
}
