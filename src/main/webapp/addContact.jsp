<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Phonebook</title>
<%@include file="component/allCss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<% if(user==null){
		session.setAttribute("invalidMsg","Please login first");
		response.sendRedirect("login.jsp");
	}
	%>

	<div class="container-fluid">

		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Add new contact</h4>
						
						<% 
						String successMsg = (String)session.getAttribute("successMsg");
						String failedMsg = (String)session.getAttribute("failedMsg");
						if(successMsg!=null){
						%>
							<p class="text-success text-center"><%=successMsg %></p>	
						<%
						session.removeAttribute("successMsg");
						}
						
						if(failedMsg!=null){
						%>
							<p class="text-danger text-center"><%=failedMsg %></p>	
						<%
						session.removeAttribute("failedMsg");
						}
						%>
						
						<form action="addContact" method="post">
							<%
							if(user != null){
							%>
								<input type="hidden" value="<%=user.getId() %>" name="userid">
							<%	
							}
							%>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text" name="name"
									class="form-control" id="exampleInputEmail1" required
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input name="email"
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Mobile number</label> <input name="phno"
									type="number" class="form-control" id="exampleInputEmail1" required
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">About</label><br/>
								<textarea name="about" id="aboutText" rows="3" cols="" class="form-control"></textarea>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>

	</div>

	<div style="margin-top: 30px;">
		<%@include file="component/footer.jsp"%>
	</div>

</body>
</html>