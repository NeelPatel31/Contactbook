package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.ContactDAO;
import com.entity.Contact;

@WebServlet("/update")
public class EditContact extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid = Integer.parseInt(req.getParameter("cid"));

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String about = req.getParameter("about");
		System.out.println("EditContact.java: before cid");
//		String cid = req.getParameter("cid");
//		int cid2 = Integer.parseInt(cid);
		System.out.println("EditContact.java: after cid");
		System.out.println("EditContact.java: the value of cid is "+cid);
//		System.out.println("EditContact.java: typeof cid: "+cid.getClass());	
		System.out.println("EditContact.java : start...");
		
		Contact c = new Contact();
		c.setName(name);
		c.setEmail(email);
		c.setPhno(phno);
		c.setAbout(about);
//		c.setId(2);
		c.setId(cid);
		
		ContactDAO dao = new ContactDAO(DbConnect.getConn());

		System.out.println("editcontact.java : before session");

		HttpSession session = req.getSession();
		boolean f = dao.updateContact(c);
		if(f) {
			System.out.println("value of f is true ");
		}
		else {
			System.out.println("value of f is false");
		}
		System.out.println("return to editcontact.java: after update contact function");
		
		if(f) {
			System.out.println("Contact updated successfully");
			session.setAttribute("successMsg","Contact updated successfully");
			resp.sendRedirect("viewContact.jsp");
		}
		else {
			session.setAttribute("failedMsg","Contact can't be updated");
			resp.sendRedirect("editcontact.jsp?cid="+cid);
		}
	}
}
