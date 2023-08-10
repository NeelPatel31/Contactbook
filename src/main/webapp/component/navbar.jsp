<%@page import="com.entity.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="index.jsp"><i
		class="fa-solid fa-phone"></i> Phonebook</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link active"
				href="index.jsp"><i class="fa-solid fa-house"></i> Home <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link active"
				href="addContact.jsp"><i class="fa-solid fa-plus"></i> Add Phone
					no.</a></li>
			<li class="nav-item"><a class="nav-link active"
				href="viewContact.jsp"><i class="fa-regular fa-address-book"></i>
					View Contact</a></li>
		</ul>


		<%
		User user = (User) session.getAttribute("user");
		if (user == null) {
		%>
		<form class="form-inline my-2 my-lg-0">
			<a href="login.jsp" class="btn btn-success"><i
				class="fa-solid fa-user"></i> Login</a> <a href="register.jsp"
				class="btn btn-danger ml-2"><i class="fa-solid fa-user-plus"></i>
				Register</a>
		</form>

		<%
		} else {
		%>
		<form class="form-inline my-2 my-lg-0">
			<button class="btn btn-success"><%=user.getName() %></button>
			<a class="btn btn-danger ml-2 text-white" data-toggle="modal"
				data-target="#exampleModalCenter">Logout</a>
		</form>

		<%
		}
		%>

	</div>

	<!-- Logout popup -->


	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Alert!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
				<h6>Do you want to logout? </h6>
				<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="logout" class="btn btn-primary">Logout</a>
				</div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	<!-- Logout popup -->


</nav>