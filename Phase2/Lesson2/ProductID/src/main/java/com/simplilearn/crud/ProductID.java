package com.simplilearn.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductID
 */
@WebServlet("/list")
public class ProductID extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductID() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean found = false;
		boolean invalid = false;
		int ID = 0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		try {
			 ID = Integer.parseInt(request.getParameter("ID"));
		}catch(NumberFormatException e){
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			invalid = true;
			out.print("Invalid product ID" + "<br/>");
		}
		String name = "";
		String sql = "select * from eproduct where ID=?";
	
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","prateek");
			pst = conn.prepareStatement(sql);
			pst.setString(1, request.getParameter("ID"));
			ResultSet rs = pst.executeQuery();
			
			rs.last();
			if (rs.getRow() > 0) {
				name = rs.getString(2);
				found = true;
			}
			if(found) {
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.print("Retrieving the Product Details Using the ProductID" + "<br/>");
				out.print("ID:" + ID + "<br/>" + "Product Name: " + name + "<br/>");
			}else if(invalid == false){
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.print("ID:" + ID + " is not found" + "<br/>");
			}
			conn.close();
		}catch(ClassNotFoundException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch(SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

