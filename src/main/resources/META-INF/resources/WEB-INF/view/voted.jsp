<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

<style>

@import url('https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap');
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

body {
  background-color:  #151719;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}
.waviy {
  position: relative;
  -webkit-box-reflect: below -20px linear-gradient(transparent, rgba(0,0,0,.2));
  font-size: 60px;
}
.waviy span {
  font-family: 'Alfa Slab One', cursive;
  position: relative;
  display: inline-block;
  color: #fff;
  text-transform: uppercase;
  animation: waviy 1s infinite;
  animation-delay: calc(.1s * var(--i));
  
}
@keyframes waviy {
  0%,40%,100% {
    transform: translateY(0)
  }
  20% {
    transform: translateY(-20px)
  }
}

</style>
</head>
<body>

	<div class="waviy">
   <span style="--i:1">Y</span>
   <span style="--i:2">O</span>
   <span style="--i:3">U</span>
   <span style="--i:4">&nbsp;</span>
   <span style="--i:5">H</span>
   <span style="--i:6">A</span>
   <span style="--i:7">V</span>
   <span style="--i:8">E</span>
   <span style="--i:9">&nbsp;</span>
   <span style="--i:10">V</span>
   <span style="--i:11">O</span>
   <span style="--i:12">T</span>
   <span style="--i:13">E</span>
   <span style="--i:14">D</span>
   <span style="--i:15">!</span>
   <span style="--i:16">!</span>
   

  </div>
</body>
</html>