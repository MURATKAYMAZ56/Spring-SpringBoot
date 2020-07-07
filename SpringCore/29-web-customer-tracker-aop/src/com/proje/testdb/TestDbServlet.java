package com.proje.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDbServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//setup connection variables(username password)
		
		String user= "springstudent";
		String pass= "springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_cracker?useSSL=false";
		
		String driver= "com.mysql.jdbc.Driver";
		
		
		//get connection to database
		
		try {
			PrintWriter out= response.getWriter();
					out.println("Connectung to database: "+jdbcUrl);
					Class.forName(driver);
					Connection myCOnn= DriverManager.getConnection(jdbcUrl,user,pass);
					out.println("SUCCESS!!");
					myCOnn.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

}
