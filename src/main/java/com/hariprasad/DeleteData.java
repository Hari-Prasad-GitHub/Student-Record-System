package com.hariprasad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class DeleteData
 */
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		PreparedStatement stmt;
		
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project24?"+"user=root&password=HariData2K");
			stmt=conn.prepareStatement("select * from students where regno=?");
			stmt.setInt(1, Integer.parseInt(request.getParameter("regno")));
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				stmt=conn.prepareStatement("Delete from students where regno=?");
				stmt.setInt(1,Integer.parseInt(request.getParameter("regno")));
				stmt.executeUpdate();
				request.getRequestDispatcher("/deletesuccess.html").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/deleteinvalid.html").forward(request, response);
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("sql error: "+e);
			e.printStackTrace();
		}
	}

}
