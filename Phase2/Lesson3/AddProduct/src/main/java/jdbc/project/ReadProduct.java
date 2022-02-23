package jdbc.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/readproduct")
public class ReadProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		
		Session session = sf.openSession();
		
		List<EProduct> products = session.createQuery(" from EProduct").list();
		
		
		
		out.print("<h1> Product List :- </h1>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Product Id </th>");
		out.print("<th> Product Name </th>");
		out.print("<th> Product Price </th>");
		out.print("</tr>");
		
		for(EProduct p : products) {
			
			out.print("<tr>");
			out.print("<td>"+p.getId()+"</td>");
			out.print("<td>"+p.getName()+"</td>");
			out.print("<td>"+p.getPrice()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
		session.close();
	}
	
}
