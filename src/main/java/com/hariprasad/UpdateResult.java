package com.hariprasad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.*;

/**
 * Servlet implementation class UpdateResult
 */
public class UpdateResult extends HttpServlet {
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
			stmt=conn.prepareStatement("select * from students where regno=?");
			stmt.setString(1,request.getParameter("regno"));
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
			out.print("<!DOCTYPE html>"
					+ "<html>"
					+ "  <head>"
					+ "    <title>Update database</title>"
					+ "    <link rel=\"stylesheet\" href=\"loginbox.css\" />"
					+ "  </head>"
					+ "  <body>"
					+ "		<script src=\"createaccscript.js\"></script>"
					+ "    <h1 style=\"text-align: center; color: green\">Update student database</h1>"
					+ "    <a href=\"menu.html\">"
					+ "      <button type=\"button\" style=\"width: 8%\">Home</button>"
					+ "    </a>"
					+ "    <form action=\"http://localhost:8080/Project24/RenewResult\" action=\"get\">"
					+ "      <table"
					+ "        style=\"margin-left: auto; margin-right: auto\""
					+ "        cellspacing=\"10px\""
					+ "        cellpadding=\"10px\""
					+ "      >"
					+ "        <tr>"
					+ "          <th>Register no:</th>"
					+ "          <th><input type=\"text\" name=\"regno\" required"
					+ "              onchange=\"checknumber(this)\" value=\""+rs.getString(1)+"\" />"
							+ "<span class=\"error\" id=\"rno\"></span></th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>Name:</th>"
					+ "          <th><input type=\"text\" name=\"name\" required onchange=\"checkname(this)\" value=\""+rs.getString(2)+" \" /><span"
							+ "              class=\"error\""
							+ "              id=\"name\""
							+ "            ></span"
							+ "            ><br /></th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>Dob:</th>"
					+ "          <th><input type=\"text\" name=\"dob\" placeholder=\"dd-mm-yyyy\" required onchange=\"checkdob(this)\" value=\""+rs.getString(3)+" \" />"
							+ "<span"
							+ "              class=\"error\""
							+ "              id=\"birth\""
							+ "            ></span></th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>email-id:</th>"
					+ "          <th><input type=\"email\" name=\"mail\" required onchange=\"checkemail(this)\" value=\""+rs.getString(4)+" \" />"
							+ "<span"
							+ "              class=\"error\""
							+ "              id=\"email\""
							+ "            ></span></th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>password:</th>"
					+ "          <th><input type=\"password\" name=\"psw\" required onchange=\"checkpass(this)\" value=\""+rs.getString(5)+" \" />"
							+ "<span"
							+ "              class=\"error\""
							+ "              id=\"code\""
							+ "            ></span></th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>mark 1:</th>"
					+ "          <th><input type=\"text\" id=\"1\" name=\"m1\" required onchange=\"checkmark(this)\" value=\""+rs.getString(6)+" \" />"
							+ "<span class=\"error\" id=\"mark1\"></span></th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>mark 2:</th>"
					+ "          <th><input type=\"text\" id=\"2\" name=\"m2\" required onchange=\"checkmark(this)\" value=\""+rs.getString(7)+" \" />"
							+ "<span class=\"error\" id=\"mark2\"></span></th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>mark 3:</th>"
					+ "          <th><input type=\"text\" id=\"3\" name=\"m3\" required onchange=\"checkmark(this)\" value=\""+rs.getString(8)+" \" />"
							+ "<span class=\"error\" id=\"mark3\"></span></th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>total:</th>"
					+ "          <th>"+rs.getString(9)+"</th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>average:</th>"
					+ "          <th>"+rs.getString(10)+"</th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th>result:</th>"
					+ "          <th>"+rs.getString(11)+"</th>"
					+ "        </tr>"
					+ "        <tr>"
					+ "          <th><button type=\"submit\">Update</button></th>"
					+ "          <th><button type=\"reset\">Clear</button></th>"
					+ "        </tr>"
					+ "      </table>"
					+ "    </form>"
					+ "  </body>"
					+ "</html>"
					+ "");
			
			}
			else {
				request.getRequestDispatcher("/updateinvalid.html").forward(request, response);
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("sql error: "+e);
			e.printStackTrace();
		}
		
	}
	
}
