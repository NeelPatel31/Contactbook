package servlet;

import com.dao.UserDAO;
import com.entity.*;
import com.conn.DbConnect;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User u = new User(name,email,password);
		
		UserDAO dao = new UserDAO(DbConnect.getConn());
		
		boolean f = dao.userRegister(u);
		
		
		HttpSession session = req.getSession();
		if(f) {
			String s = "User registration successful";
			session.setAttribute("sucssMsg", s);
			res.sendRedirect("register.jsp");
			System.out.println(s);
		}
		else {
			String e = "Something went wrong.";
			session.setAttribute("errorMsg", e);
			res.sendRedirect("register.jsp");
			System.out.println(e);
		}
	}
}
