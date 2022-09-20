package com.hariprasad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class SeeResult
 */
public class SeeResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		PreparedStatement stmt;
		response.setContentType("text/html");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project24?"+"user=root&password=HariData2K");
			stmt=conn.prepareStatement("select * from students where regno=? and password=?");
			stmt.setInt(1, Integer.parseInt(request.getParameter("rno")));
			stmt.setString(2, request.getParameter("psw"));
			ResultSet rs=stmt.executeQuery();
			if (rs.next()) {
				out.println("<!DOCTYPE html>"
						+ "<html>"
						+ "  <head>"
						+ "    <title>Result page</title>"
						+ "    <link rel=\"stylesheet\" href=\"loginbox.css\" />"
						+ "  </head>"
						+ "  <body>"
						+ "    <h1 style=\"color: green; text-align: center\">Anna University</h1>"
						+ "    <div class=\"logout\">"
						+ "      <a href=\"universityresults.html\">"
						+ "        <button type=\"button\">Log out</button>"
						+ "      </a>"
						+ "    </div>"
						+ "    <table"
						+ "      style=\"margin-left: auto; margin-right: auto\""
						+ "      cellspacing=\"20px\""
						+ "      cellpadding=\"20px\""
						+ "    >"
						+ "      <tr>"
						+ "        <th>Register no:</th>"
						+ "        <th>"+rs.getInt(1)+"</th>"
						+ "        <th>Name:</th>"
						+ "        <th>"+rs.getString(2)+"</th>"
						+ "      </tr>"
						+ "      <tr>"
						+ "        <th>Dob:</th>"
						+ "        <th>"+rs.getString(3)+"</th>"
						+ "        <th>email-id:</th>"
						+ "        <th>"+rs.getString(4)+"</th>"
						+ "      </tr>"
						+ "      <tr>"
						+ "        <th>Mark 1:</th>"
						+ "        <th>"+rs.getInt(6)+"</th>"
						+ "        <th>Total:</th>"
						+ "        <th>"+rs.getInt(9)+"</th>"
						+ "      </tr>"
						+ "      <tr>"
						+ "        <th>Mark 2:</th>"
						+ "        <th>"+rs.getInt(7)+"</th>"
						+ "        <th>Average:</th>"
						+ "        <th>"+rs.getFloat(10)+"</th>"
						+ "      </tr>"
						+ "      <tr>"
						+ "        <th>Mark 3:</th>"
						+ "        <th>"+rs.getInt(8)+"</th>"
						+ "        <th>Result:</th>"
						+ "        <th>"+rs.getString(11)+"</th>"
						+ "      </tr>"
						+ "    </table>"
						+ "  </body>"
						+ "</html>"
						+ "");
			}
			else {
				request.getRequestDispatcher("/univloginvalid.html").forward(request, response);
			}
			
		}
		catch(SQLException | ClassNotFoundException e){
			System.out.println("sql error: "+e);
			e.printStackTrace();
		}
	}

}
