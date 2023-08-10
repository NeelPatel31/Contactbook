<%@page import="com.conn.DbConnect"%>
<%@page import="com.dao.ContactDAO"%>
<%@page import="com.entity.Contact" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Phonebook</title>
<%@include file="component/allCss.jsp" %>
<style type="text/css">

.crd-hover:hover{
	background-color: #f7f7f7;
	
}

</style>




</head>
<body>
<%@include file="component/navbar.jsp"%>
<% if(user==null){
	session.setAttribute("invalidMsg","Please login first");
		response.sendRedirect("login.jsp");
	}
%>
	<% 
		String successMsg = (String)session.getAttribute("successMsg");
		String errorMsg = (String)session.getAttribute("failedMsg");
	
		if(successMsg!=null){
		%>
			<div class="alert alert-success text-center" role="alert"><%=successMsg %></div>	
		<%
		session.removeAttribute("successMsg");
		}
		if(errorMsg!=null){
			%>
			<div class="alert alert-success text-center" role="alert"><%=errorMsg %></div>	
		<%
			session.removeAttribute("failedMsg");
		
		}
		
	%>
	
	
	
	<div class="container">
		<div class="row p-4">				
				<%
				if(user!=null){
					
					ContactDAO dao = new ContactDAO(DbConnect.getConn());
					List<Contact> contact = dao.getAllContacts(user.getId());
					
					for(Contact c:contact){
					%>
						<div class="col-md-3">
						<div class="card crd-hover">
							<div class="card-body">
								<h5>Name: <%= c.getName() %></h5>
								<p>Ph no: <%= c.getPhno() %></p>
								<p>Email: <%= c.getEmail() %></p>
								<p>About: <%= c.getAbout() %></p>
								
								<div class="text-center text-white">
									<a href="editcontact.jsp?cid=<%=c.getId()%>" class="btn btn-success">Edit</a>
									<a href="delete?cid=<%=c.getId()%>" class="btn btn-danger">Delete</a>
								</div>
							</div>
						</div>
						</div>		
					<%
					}
				}
				%>
			
		</div>
	</div>


</body>
</html>