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

public class CreateAccount extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int salary = Integer.parseInt(req.getParameter("salary"));
		
		//Database Connection
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root@1234");
		
			PreparedStatement stmt=con.prepareStatement("insert into Employee values(?,?,?)");  
			stmt.setInt(1,id);
			stmt.setString(2,name);  
			stmt.setInt(3, salary);  
			
			stmt.executeUpdate();  

			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.write("Hi! "+name+", Your account has been created successsfully");
		pw.close();			
		
	}

}
