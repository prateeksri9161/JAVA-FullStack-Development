package filter;

import to.Login;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter(
        filterName="LoginFilter",
        urlPatterns={"/ValidationLoginServlet"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config)  {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("***** doFilter *****");

        Login login = (Login) request.getAttribute("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(">>>>LoginFilter.login=" + login);

        if( !validate(email, password) ) {
            System.out.println("Login/Password not okay");
            PrintWriter out = response.getWriter();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            
            out.println("<br/><span style='color:red; display: flex; flex-direction: column; align-items: center'>Invalid login / password. Try again");
        } else {
            System.out.println("Login/Password okay");

            request.setAttribute("login", login);
            request.setAttribute("email", email);
            request.setAttribute("password", password);

            chain.doFilter(request, response);
        }

    }

    private boolean validate(String email, String password) {
        System.out.println("Login=" + email);
        System.out.println("Password=" + password);

        if (email ==  null || password == null)
            return false;
        return email.equals("prateek@gmail.com") && password.equals("prateek");
    }
}
