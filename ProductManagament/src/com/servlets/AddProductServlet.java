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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		double price=Double.parseDouble(request.getParameter("price"));
       
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        String category=request.getParameter("category");
		
		Product prod=new Product(pid, pname, price, quantity, category);
		//response.getWriter().println(emp);
		
		//req,seesion,context
		
		ProductDAO dao=new ProductDAOImpl();
		int added=dao.addProduct(prod);
		
		List<Product> products=dao.findAll();
		if(added>0)
		{
		request.setAttribute("prod", products);
		RequestDispatcher disp=request.getRequestDispatcher("display.jsp");
		disp.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "Cant add record try again!!");
			RequestDispatcher disp=request.getRequestDispatcher("addProduct.jsp");
			disp.forward(request, response);
			
		}
		
	}
	}


