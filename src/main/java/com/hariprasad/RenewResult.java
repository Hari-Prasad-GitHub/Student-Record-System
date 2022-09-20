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
 * Servlet implementation class RenewResult
 */
public class RenewResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		PreparedStatement stmt;
		//int reg=Integer.parseInt(request.getParameter("regno"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project24?"+"user=root&password=HariData2K");
			stmt=conn.prepareStatement("update students set name=?, dob=?, emailid=?, password=? where regno=?");

			stmt.setString(1, request.getParameter("name"));
			stmt.setString(2, request.getParameter("dob"));
			stmt.setString(3, request.getParameter("mail"));
			stmt.setString(4, request.getParameter("psw"));
			stmt.setString(5, request.getParameter("regno"));
			
			if (request.getParameter("m1")!="" && request.getParameter("m2")!=""&& request.getParameter("m3")!="") {
				int M1=Integer.parseInt(request.getParameter("m1"));
				int M2=Integer.parseInt(request.getParameter("m2"));
				int M3=Integer.parseInt(request.getParameter("m3"));
				int total=M1+M2+M3;
				float avg=(float) total/3;
				String result;
				if (M1>34 && M2>34 && M3>34 )
					result="pass";
				else
					result="fail";
				stmt=conn.prepareStatement("update students set m1=?,m2=?,m3=?,total=?,avg=?,result=? where regno=?");
		
				stmt.setInt(1, M1);
				stmt.setInt(2, M2);
				stmt.setInt(3, M3);
				stmt.setInt(4, total);
				stmt.setFloat(5, avg);
				stmt.setString(6, result);
				stmt.setString(7, request.getParameter("regno"));
				
				}
			
			stmt.executeUpdate();
			request.getRequestDispatcher("/updatesuccess.html").forward(request, response);
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("sql error: "+e);
			e.printStackTrace();
		}
	}

}
