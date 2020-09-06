package com.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FindByCategoryServlet
 */
@WebServlet("/findbyCatg")
public class FindByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String category=request.getParameter("category");
		
		ProductDAO dao=new ProductDAOImpl();
		 
		List<Product> prod=dao.findAllByCategory(category);
		
		 
		request.setAttribute("prod", prod);
		RequestDispatcher disp=request.getRequestDispatcher("display.jsp");
		disp.forward(request, response);
	}

}
