package com.hariprasad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;

/**
 * Servlet implementation class Createdb
 */
public class Createdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project24?"+"user=root&password=HariData2K");
			PreparedStatement stmt=conn.prepareStatement("insert into admins values(?,?,?,?)");
			stmt.setString(1, request.getParameter("employeeid"));
			stmt.setString(2, request.getParameter("username"));
			stmt.setString(3, request.getParameter("emailid"));
			stmt.setString(4, request.getParameter("password"));
			stmt.executeUpdate();
			request.getRequestDispatcher("/signin.html").forward(request, response);
			
		}
		catch(SQLException | ClassNotFoundException e){
			System.out.println("SQL eroor: "+e);
			e.printStackTrace();
		}
		
	}

}
