package servlet;

import java.io.IOException;

import com.dao.*;
import com.conn.*;
import com.entity.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.conn.DbConnect;
import com.dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		
		System.out.println(email+ " " + pass );
		UserDAO dao = new UserDAO(DbConnect.getConn());
		User u = dao.loginUser(email, pass);
		
		HttpSession session = req.getSession();
		
		if(u!=null) {
			System.out.println("USER is available "+ u);
			session.setAttribute("user", u);
			resp.sendRedirect("index.jsp");
		}
		else {
			System.out.println("User is not available "+ u);
			session.setAttribute("invalidMsg", "Invalid Email or Password");
			resp.sendRedirect("login.jsp");
		}
	}
	
	
}
