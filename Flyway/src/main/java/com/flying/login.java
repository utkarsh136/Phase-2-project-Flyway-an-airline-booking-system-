package com.flying;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.businesslogic.DatabaseConnection;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	RequestDispatcher rd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		 out=response.getWriter();
		int result = 0;
		if (username != null && password != null && username.trim().length() > 0 && password.trim().length() > 0) {
		try {
			//Call Connection Method
				Connection con=DatabaseConnection.getMyConnection();
			//Write sql command
				String str="Insert into userdetails (username,password) values(?,?)";
				//string str= "update student set marks=? where rollno=?"
				//String str="delete from student where rollno=?"
				//to execute query create object of preparedSatement
				PreparedStatement  ps=con.prepareStatement(str);
				ps.setString(1, username);
				ps.setString(2, password);
				result = ps.executeUpdate();
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				rd = request.getRequestDispatcher("Traveldetails.html");
				rd.forward(request, response);
				
				
			
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

		else {
			rd = request.getRequestDispatcher("UserLogin.html");
			response.setContentType("text/html");
			rd.include(request, response);
			out.println("<h3 style=\"text-align: center;\">Sorry Enter Valid Credentials...</h3>");

		}

	}
}		


				
		
