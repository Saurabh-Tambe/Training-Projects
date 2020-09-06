package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.dao.ProductDAOImpl;
import com.pojo.Product;

/**
 * Servlet implementation class FindByIdServlet
 */
@WebServlet("/findbyId")
public class FindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pid=Integer.parseInt(request.getParameter("pid"));
		
		ProductDAO dao=new ProductDAOImpl();
		Product prod=dao.findById(pid);
		
		 
		request.setAttribute("prod", prod);
		RequestDispatcher disp=request.getRequestDispatcher("displayProd.jsp");
		disp.forward(request, response);
	}

}
