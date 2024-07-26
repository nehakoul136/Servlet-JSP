package com.veracity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veracity.entity.Employee;



public class ReadAll extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Employee> empList = new ArrayList<Employee>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root@1234");
			PreparedStatement stmt = con.prepareStatement("Select * from Employee");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int salary = rs.getInt("salary");
				System.out.println(id+ " " +name+ " " +salary);
				Employee e = new Employee(id, name, salary);
				empList.add(e);
			}
			req.setAttribute("empList", empList);
			RequestDispatcher rdp = req.getRequestDispatcher("readAll.jsp");
			rdp.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
