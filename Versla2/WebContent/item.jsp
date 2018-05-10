<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  * {
  box-sizing: border-box;
  }
  .header {
  border-radius: 10px;
  height:12%;
  background-color:white;
  font-size:15px;
  margin:0;
  padding:1px 5px;
  width:100%;
  background-image:url("image/bgHeader.jpg");
  background-size:540px 110px;
  }
  #category{
  background-color:skyblue;
  }
  #sidebar-left{
float:left;
width:20%;
height:70%;
background-color:grey;
}
#sidebar-right{
float:left;
height:70%;
width:80%;

}
.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

#main {
    transition: margin-left .5s;
    padding: 16px;
}

  #sidebar-left, #sidebar-right{
	min-height: 500px;
}
  #myBtn{
  	background-color:#f9f9f9 ;
	font-size:20px;
	text-size:20;
	padding:4px 4px;
	margin: 8px 5px;
  }
   .column {
  float: right;
  width: 18%;
  padding: 5px;
  }
  .row::after {
  content: "";
  clear: both;
  display: table;
  }
</style>
  </head>
   <body>
   <div  class="header" id="header" >
<div class="container">

  <h2 style="color:white; font-family:Verdana, Geneva, sans-serif;"><a href="Login.jsp" target="_black" rel="noopener" style="color:white; font-family:Verdana, Geneva, sans-serif;" > Versla</a>
   <!-- Trigger the modal with a button -->
   <a href="home.jsp">
	  <button type="button" class="btn btn-default  btn-lg pull-right"  id="myBtn" value="Logout">Logout</button></a>
</h2> 
</div>
</div>
<div id="#sidebar-left">
		<div id="mySidenav" class="sidenav" >
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#" id="computer"  onClick="fun_hide_cat('block','Computer')" >Computers,HardDisk&Printers</a>
  <a href="#" id="fridge"  onClick="fun_hide_cat('block','Fridge')">fridges,tv,ac&washingMachine</a>
  <a href="#" id="camera"  onClick="fun_hide_cat('block','Camera')">cameras</a>
  </div>
<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()" id="category">&#9776;SUBCATEGORY</span>	
</div>
<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "200px";
    document.getElementById("main").style.marginUp = "350px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginUp = "0";
}
</script>
</div>
<div id="#sidebar-right">
<div  id="Computer" style="display : none">
<div class="row">
<div class="column">
</div>
  <div class="column">
   <div class="thumbnail" id="laptops" >
        <a href="#" target="_blank">
    <img src="image/subcategory/items/delllap.jfif" alt="Laptops" style="width:100px; height:90px;">
   <figcaption align="center">DELL Laptops</figcaption>
    </a>
    </div>
  </div>
</div>
</div>
 <div  id="Fridge" style="display : none">
<div class="row">
<div class="column">
</div>
  <div class="column">
   <div class="thumbnail" id="fridg" >
        <a href="#" target="_blank">
    <img src="image/subcategory/items/fridgesa.jfif" alt="fridge" style="width:100px; height:90px;">
   <figcaption align="center">SamsungFridge</figcaption>
    </a>
    </div>
  </div>
 </div>
 	 </div>
 <div  id="Camera" style="display : none">
<div class="row">
<div class="column">
</div>
<div class="column">
 <div class="thumbnail" id="cam">
        <a href="#" target="_blank">
    <img src="image/subcategory/items/camer.jpg" alt="cam" style="width:100px; height:90px;">
            <figcaption align="center">Cameras</figcaption>
    </a>
    </div>
  </div>
</div>
 </div>
 </div>
<script type="text/javascript">
	function fun_hide_cat(message,divName){
		if(divName == 'Computer'){
			document.getElementById("Computer").style.display=message;
			document.getElementById("Fridge").style.display= "none";
			document.getElementById("Camera").style.display= "none";
			}
		else if(divName == 'Fridge'){
			document.getElementById("Computer").style.display="none";
			document.getElementById("Fridge").style.display= message;
			document.getElementById("Camera").style.display= "none";
			}
		else{
			document.getElementById("Computer").style.display="none";
			document.getElementById("Fridge").style.display= "none";
			document.getElementById("Camera").style.display= message;
		}
		
	}
</script>
</body>
</html>