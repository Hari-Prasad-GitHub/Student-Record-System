package com.hariprasad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class ShowResult
 */
public class ShowResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String view=request.getParameter("view");
		PreparedStatement stmt;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project24?"+"user=root&password=HariData2K");
			if (view.equals("rno"))
			{
			stmt=conn.prepareStatement("select * from students where regno=?");
			stmt.setString(1,request.getParameter("regno"));
			}
			else if(view.equals("all"))
				stmt=conn.prepareStatement("select * from students");
			else if(view.equals("pass"))
				stmt=conn.prepareStatement("select * from students where result='pass'");
			else if(view.equals("80"))
				stmt=conn.prepareStatement("select * from students where avg>80");
			else
				stmt=conn.prepareStatement("select * from students where result='fail'");
			
			ResultSet rs=stmt.executeQuery();
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>"
					+ "  <head>"
					+ "    <title>view result</title>"
					+ "    <link rel=\"stylesheet\" href=\"loginbox.css\" />"
					+ "  </head>"
					+ "  <body>"
					+ "    <h1 style=\"text-align: center; color: green\">Student Details Database</h1>"
					+ "    <div class=\"logout\">"
					+ "      <a href=\"viewresult.html\">"
					+ "        <button type=\"button\">Back</button>"
					+ "      </a>"
					+ "    </div>"
					+ "    <table align=\"center\" cellspacing=\"10px\" cellpadding=\"10px\" style=\"border:1px solid blue;\">"
					+ "      <tr class=a>"
					+ "        <th class=\"a\">Reg. No.:</th>"
					+ "        <th class=\"a\">Name</th>"
					+ "        <th class=\"a\">DOB</th>"
					+ "        <th class=\"a\">email id</th>"
					+ "        <th class=a>password</th>"
					+ "        <th class=a>Mark 1</th>"
					+ "        <th class=a>Mark 2</th>"
					+ "        <th class=a>Mark 3</th>"
					+ "        <th class=a>Total</th>"
					+ "        <th class=a>Percentage(%)</th>"
					+ "        <th class=a>Result</th>"
					+ "      </tr>"
					+ "");
			
			while(rs.next()) {
				out.println("<tr class=a><th>"+rs.getString("regno")+"</th>"
						+ "<th>"+rs.getString("name")+"</th>"
						+ "<th>"+rs.getString("dob")+"</th>"
						+ "<th>"+rs.getString("emailid")+"</th>"
						+ "<th>"+rs.getString("password")+"</th>"
						+ "<th>"+rs.getString("m1")+"</th>"
						+ "<th>"+rs.getString("m2")+"</th>"
						+ "<th>"+rs.getString("m3")+"</th>"
						+ "<th>"+rs.getString("total")+"</th>"
						+ "<th>"+rs.getString("avg")+"</th>"
						+ "<th>"+rs.getString("result")+"</th>"
						+ "</tr>");
			}
			out.println("</table>");
			
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("sql error: "+e);
			e.printStackTrace();
		}
		out.print("</body></html>");
	}

}
