package com.azd.sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ClassLoadingMXBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Cotactpath")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection myconn;
   
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw= response.getWriter();
	
	
		
		try{
			response.setContentType("text/html");
			String name=request.getParameter("Name");
			String email=request.getParameter("Email");
			String subject=request.getParameter("Subject");
			String message=request.getParameter("Message");
			pw.write("name");
			Class.forName("com.mysql.jdbc.Driver");
			if(myconn==null){
			 myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/azd_engine","root","");
			}
		String sql="INSERT INTO feed_back(Name,Email,Subject,Message) VALUE(?,?,?,?);";
			PreparedStatement pre= (PreparedStatement)myconn.prepareStatement(sql);
		
		pre.setString(1,name);
		pre.setString(2,email);
		pre.setString(3,subject);
		pre.setString(4,message);
		pre.execute();
	
		
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		
	}

}
