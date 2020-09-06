package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.MyConnection;
import com.exception.ProductNotFoundException;
import com.pojo.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
				int added = 0;
				String insertData = "insert into product values(?,?,?,?,?)";

				try {
					PreparedStatement ps = MyConnection.getConnection().prepareStatement(insertData);
					ps.setInt(1, product.getpId());
					ps.setString(2, product.getpName());
					ps.setDouble(3, product.getPrice());
					ps.setInt(4, product.getQuantity());
					ps.setString(5, product.getCategory());

					added = ps.executeUpdate();
					
					if(added>0)
					{
						System.out.println("Product inserted Successfully");

					}
					else
					{
						throw new ProductNotFoundException("Unable to insert product!!");

					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				 catch (ProductNotFoundException e) {
						 e.printStackTrace();
					}
				return added;
	}

	@Override
	public boolean updateProductPrice(int productId, double price) {
		boolean updated = false;
		String updateData = "update product set price=? where pId=?";

		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(updateData);
			ps.setDouble(1, price);
			ps.setInt(2, productId);
			int res=ps.executeUpdate();
			if(res>0)
			{
				updated=true;
		    }	
			else
			{
				throw new ProductNotFoundException("Unable to update the product!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ProductNotFoundException e) {
			 e.printStackTrace();
		}
		return updated;
	}

	
	@Override
	public boolean updateProductQuantity(int productId, int quantity) {
		boolean updated = false;
		String updateData = "update product set quantity=? where pId=?";

		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(updateData);
			ps.setInt(1, quantity);
			ps.setInt(2, productId);
			int res=ps.executeUpdate();
			
			if(res>0)
			{
				updated=true;
		    }	
			else
			{
				throw new ProductNotFoundException("Unable to update the product!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ProductNotFoundException e) {
			 e.printStackTrace();
		}
		return updated;
	}
	
	@Override
	public Product findById(int productId) {
		Product prod = null;
		String findData = "select * from product where pId=?";

		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(findData);
			ps.setInt(1, productId);

			ResultSet set = ps.executeQuery();

			while (set.next()) {
				int pid = set.getInt(1);
				String pname = set.getString(2);
				double price = set.getDouble(3);
				int quantity=set.getInt(4);
				String category = set.getString("category");
				prod = new Product(pid, pname, price, quantity,category);

			}
			if (prod.getpId() == 0) {
				try {
					throw new ProductNotFoundException(
							"Unable to find the product with given id!!");
				} catch (ProductNotFoundException e) {
 					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
				List<Product> prod = new ArrayList<Product>();
				String findData = "select * from product";

				try {
					Statement s = MyConnection.getConnection().createStatement();

					ResultSet set = s.executeQuery(findData);

					while (set.next()) {
						
						int pid = set.getInt("pId");
						String pname = set.getString(2);
						double price = set.getDouble(3);
						int quantity=set.getInt(4);
						String category = set.getString("category");
						Product p = new Product(pid, pname, price, quantity,category);
						prod.add(p);

					}
					if (prod.size() == 0) {
						throw new ProductNotFoundException("There are no products available!!");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ProductNotFoundException e) {
				 e.printStackTrace();
				}
				return prod;

			
	}

	@Override
	public List<Product> findAllByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> prod = new ArrayList<Product>();
		String findData = "select * from product where category=?";

		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(findData);
			ps.setString(1, category);

			ResultSet set = ps.executeQuery();

			while (set.next()) {
				int pid = set.getInt(1);
				String pname = set.getString(2);
				double price = set.getDouble(3);
				int quantity=set.getInt(4);
				String categ = set.getString("category");
				Product p= new Product(pid, pname, price, quantity,categ);
				prod.add(p);

			}
			if (prod.size() == 0) {
				throw new ProductNotFoundException("There are no products available for given category");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ProductNotFoundException e) {
 			e.printStackTrace();
		}
		return prod;
		
		 
	}

	@Override
	public boolean deleteById(int productId) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		String deleteData = "delete from product where pId=?";

		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(deleteData);
			ps.setInt(1, productId);
			int del=ps.executeUpdate();
			if(del>0)
			{
				deleted=true;
		    }	
			else
			{
				throw new ProductNotFoundException("Unable to delete the product!!");
			}
				

		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ProductNotFoundException e) {
			 e.printStackTrace();
		}
		return deleted;
	}

	

}
