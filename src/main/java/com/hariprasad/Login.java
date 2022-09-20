package com.hariprasad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		PreparedStatement stmt;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project24?"+"user=root&password=HariData2K");
			stmt=conn.prepareStatement("select * from admins where name=? and password=?");
			stmt.setString(1,request.getParameter("uname"));
			stmt.setString(2,request.getParameter("psw"));
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				request.getRequestDispatcher("/menu.html").forward(request, response);
				System.out.println("if loop");
			}
			else {
				request.getRequestDispatcher("/indexinvalid.html").forward(request, response);
				System.out.print("else block");
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("sql error: "+e);
			e.printStackTrace();
		}
	}

}
