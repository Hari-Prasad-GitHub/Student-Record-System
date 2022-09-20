package com.hariprasad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.*;

/**
 * Servlet implementation class Stucreadb
 */
public class Stucreadb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("m1"));
		response.setContentType("text/html");
		try {
			if ((request.getParameter("m1")=="") | request.getParameter("m2")=="" | request.getParameter("m3")=="") {
				System.out.println("m1 is empty");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project24?"+"user=root&password=HariData2K");
				PreparedStatement stmt=conn.prepareStatement("insert into students(regno,name,dob,emailid,password) values(?,?,?,?,?)");
				stmt.setString(1, request.getParameter("regno"));
				stmt.setString(2, request.getParameter("uname"));
				stmt.setString(3, request.getParameter("dob"));
				stmt.setString(4, request.getParameter("emailid"));
				stmt.setString(5, request.getParameter("dob"));
				
				stmt.executeUpdate();
			}
			else {
				int M1=Integer.parseInt(request.getParameter("m1"));
				int M2=Integer.parseInt(request.getParameter("m2"));
				int M3=Integer.parseInt(request.getParameter("m3"));
				int total=M1+M2+M3;
				float average=(float) total/3;
				String result;
				if (M1>34 && M2>34 && M3>34) {
					result="pass";
				}
				else result="fail";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project24?"+"user=root&password=HariData2K");
			PreparedStatement stmt=conn.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, request.getParameter("regno"));
			stmt.setString(2, request.getParameter("uname"));
			stmt.setString(3, request.getParameter("dob"));
			stmt.setString(4, request.getParameter("emailid"));
			stmt.setString(5, request.getParameter("dob"));
			stmt.setString(6, request.getParameter("m1"));
			stmt.setString(7, request.getParameter("m2"));
			stmt.setString(8, request.getParameter("m3"));
			stmt.setInt(9, total);
			stmt.setFloat(10, average);
			stmt.setString(11, result);
			stmt.executeUpdate();
			}
			request.getRequestDispatcher("/studsuccess.html").forward(request, response);
			
		}
		catch(SQLException | ClassNotFoundException e){
			System.out.println("Sql error"+e);
			e.printStackTrace();
		}
	}

}
