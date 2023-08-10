<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Phonebook</title>
<%@include file="component/allCss.jsp" %>
<style type="text/css">
.back-img{
background: url("img/phonepage.png");
width: 100%;
height: 100vh;
background-repeat: no-repeat;
background-size: cover;
}
</style>
</head>
<body>
<%@include file="component/navbar.jsp"%>

<div class="container-fluid	 back-img text-center text-success">
<h1>Welcome to the Phone Book</h1>

</div>
 
<%@include file="component/footer.jsp" %>


</body>
</html>