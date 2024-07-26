package com.veracity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class UpdateAccount extends HttpServlet{

	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		int salary = Integer.parseInt(req.getParameter("salary"));
		
		
		//Database Connection
				Connection con = null;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root@1234");
				
					PreparedStatement stmt=con.prepareStatement("Update Employee set salary=? where id = ?");  
					stmt.setInt(1,salary); 
					stmt.setInt(2, id);
					
					stmt.executeUpdate();  

					con.close();
				
				} catch (Exception e) {
					e.printStackTrace();
				}

				
				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
				pw.write("Hi! The salary for ID: "+id+ " has been updated successsfully");
				pw.close();			
				
			}
	}
	


