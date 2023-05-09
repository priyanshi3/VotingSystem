<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>Candidates</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<style>

body {
	background: linear-gradient(90deg, #C7C5F4, #776BCC);
}

.table {
	width: 70%;
	margin-left: auto;
	margin-right: auto;
	font-family: "Montserrat", sans-serif;
	font-size: 20px;
	border: 2px solid white;
}

th, td {
	text-align: center;
	border-spacing: 15px;
}

th {
	font-weight: 600px;
}

a {
	color: black;
}

a:hover {
	color: white;
	text-decoration: none;
}

.right {
	position:absolute;
	right: 0px;
	margin: 2px; 
	margin-right: 25px;
	font-size: 20px;
}

.btn {
	background: #4f0af0;
}

.btn:hover {
background: #4f0af0;
}

</style>

</head>

<body>

	<% if(!session.isNew()) { %>
	<div align="right" style="font-size: 22px; font-weight: bold; margin: 18px; margin-right: 25px;">
		Welcome, <%= session.getAttribute("admin") %>
	</div>
	<% }
		else {
			
	} %>
	<div class="right">
		<button onclick="location.href='<%=request.getContextPath()%>/logout'" class="btn btn-primary" name="logout" value="admin"> Logout </button>
	</div>
	<br /> <br/> <br/> <br/>
	<center> <a href="<%=request.getContextPath()%>/addCandidate" style="font-size: 18px;">Add New Candidate</a> </center>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${candidates != null}">
			<h2> <center> <b> List of Candidates </b> <center> </h2> <br> <br>
			<table cellpadding="5" cellspacing="5" class="table table-bordered">
				<thead>
					<tr>
						<th> ID </th>
						<th> Candidate Name </th>
						<th> Party Name </th>
						<th> Actions </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${candidates}">
					<div class="card">
						<tr>
							<td>${t.id}</td>
							<td>${t.cand_name}</td>
							<td>${t.party_name}</td>
							<td><a
								href="<%=request.getContextPath()%>/candidate/${t.id}">Details</a>
								&nbsp; | &nbsp;
								<a href="<%=request.getContextPath()%>/update/candidate/${t.id}">Update</a>
								&nbsp; | &nbsp;
								<a href="<%=request.getContextPath()%>/delete/candidate/${t.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</div>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
	
</body>
</html>