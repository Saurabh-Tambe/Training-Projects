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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updatebyId")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int pid=Integer.parseInt(request.getParameter("pid"));
String update=request.getParameter("update");
//System.out.println(update);
//double up_price=Double.parseDouble(request.getParameter("updatedPrice"));
//int up_quantity=Integer.parseInt(request.getParameter("updatedQuantity"));
		ProductDAO dao=new ProductDAOImpl();
		if(update.equalsIgnoreCase("price"))
		{
			double up_price=Double.parseDouble(request.getParameter("updatedPrice"));
			//System.out.println(up_price);
			 boolean result=dao.updateProductPrice(pid, up_price);
		}	
		else if(update.equalsIgnoreCase("quantity"))
		{
			int up_quantity=Integer.parseInt(request.getParameter("updatedQuantity"));
             boolean result=dao.updateProductQuantity(pid, up_quantity);
		}
	 
		
		List<Product> prod=dao.findAll();
		
		 
		request.setAttribute("prod", prod);
		RequestDispatcher disp=request.getRequestDispatcher("display.jsp");
		disp.forward(request, response); 
	}

	 
}
