package com.flying;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Cookie;

/**
 * Servlet implementation class Displaycookie
 */
@WebServlet("/Displaycookie")
public class Displaycookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Displaycookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.http.Cookie[] cookie=request.getCookies();
		PrintWriter out=response.getWriter();
		if(cookie!=null){
			for(javax.servlet.http.Cookie c:cookie){
			String uname=c.getValue();
			if(uname!=null ||uname.equals("") ){
				out.println("Welcome "+uname);
			}
			}
		}
	}

}
