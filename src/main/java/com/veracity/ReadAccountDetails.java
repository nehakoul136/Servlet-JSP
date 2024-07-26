package com.veracity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class ReadAccountDetails extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	int id = Integer.parseInt(req.getParameter("id"));
	
	
	//Database Connection
			Connection con = null;
			ResultSet rs = null;
			
			String name = null;
			int salary = 0;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root@1234");
			
				PreparedStatement stmt=con.prepareStatement("Select * from Employee where id = ?");  
				stmt.setInt(1, id);
				
				rs = stmt.executeQuery(); 
				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
				
				if(rs.next()) {
					name = rs.getString("name");
					salary = rs.getInt("salary");
					pw.write("Record Details");
					pw.write("Name: " +name+
							" ID: " +id+
							" Salary: " +salary);
					
				}else {
					pw.write("No Such Record");
				}
				pw.close();
				con.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}
}



