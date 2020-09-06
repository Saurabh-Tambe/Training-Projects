package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name=request.getParameter("uname");  
	        String password=request.getParameter("psw");  
	          
	        if(password.equals("1234") && name.equals("admin")){  
	        //out.print("Welcome, "+name);  
	        HttpSession session=request.getSession();  
	        session.setAttribute("name",name);  
         request.getRequestDispatcher("validLogin.jsp").include(request, response);  

	        }  
	        else{  
	            //out.print("Sorry, username or password error!");  
	        	
	            request.getRequestDispatcher("login.jsp").include(request, response);  
	        }  
	}

}
