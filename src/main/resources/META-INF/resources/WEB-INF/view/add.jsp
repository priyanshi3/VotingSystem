<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>Add Candidate</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  user-select: none;
}
.bg-img {
  background: linear-gradient(90deg, #C7C5F4, #776BCC);
  height: 100vh;
  background-size: cover;
  background-position: center;
}
/* .bg-img:after {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  background: rgba(0, 0, 0, 0.7);
} */
.content {
  position: absolute;
  top: 50%;
  left: 50%;
  z-index: 999;
  text-align: center;
  padding: 60px 32px;
  width: 370px;
  transform: translate(-50%, -50%);
  background: rgba(255, 255, 255, 0.04);
  box-shadow: -1px 4px 28px 0px rgba(0, 0, 0, 0.75);
}
.content header {
  color: white;
  font-size: 33px;
  font-weight: 600;
  margin: 0 0 35px 0;
  font-family: "Montserrat", sans-serif;
}
.field {
  position: relative;
  height: 45px;
  width: 100%;
  display: flex;
  background: rgba(255, 255, 255, 0.94);
}
.field span {
  color: #222;
  width: 40px;
  line-height: 45px;
}
.field input {
  height: 100%;
  width: 100%;
  background: transparent;
  border: none;
  outline: none;
  color: #222;
  font-size: 16px;
  font-family: "Poppins", sans-serif;
}
.space {
  margin-top: 16px;
}
.field input[type="submit"] {
  background: #6c5fcf;
  border: 1px solid #6c5fcf;
  color: white;
  font-size: 18px;
  letter-spacing: 1px;
  font-weight: 600;
  cursor: pointer;
  font-family: "Montserrat", sans-serif;
}
.field input[type="submit"]:hover {
  background: #5f51cc;
}


</style>
</head>

<body>
	
	

<div class="bg-img">
  <div class="content">
    <header>Add Candidate</header>
    <form method="POST" name="add_candidate"
		action="<%=request.getContextPath()%>/add/candidate">
      <div class="field">
        <span class="fa fa-user"></span>
        <input type="text" required placeholder="Candidate Name" name="cand_name" value="${cand_name}">
      </div>
      <div class="field space">
        <span class="fa fa-lock"></span>
        
        <input type="text" required placeholder="Party Name" name="party_name" value="${party_name}">
      </div>
      <div class="field space">
        <input type="submit" value="ADD CANDIDATE">
      </div>
    </form>
  </div>
</div>


</body>
</html>