<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Homepage</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  * {
  box-sizing: border-box;
  }
  .header {
  border-radius: 10px;
  height:20%;
  background-color:white;
  font-size:15px;
  margin:0;
  padding:1px 5px;
  width:100%;
  background-image:url("image/bgHeader.jpg");
  background-size:540px 110px;
  }
  #sidebar-left{
float:left;
width:50%;
height:70%;

}
#sidebar-right{
float:left;
height:70%;
width:50%;

}
  #footer1 {
  background-color:#3377ff ;
  text-align: "center";
  border-radius: 10px;
  height: 10%;
  clear:both;
  color:white;
  }
  #sidebar-left, #sidebar-right{
	min-height: 500px;
}
  .modal-header, h4, .close {
      background-color: #20B2AA;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-header1, h5, .close {
      background-color:#20B2AA ;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  #myBtn{
  	background-color:#f9f9f9 ;
	font-size:20px;
	text-size:20;
	padding:4px 4px;
	margin: 8px 5px;
  }
   #myBtn2{
  	background-color:#f9f9f9 ;
  	font-size:20px;
  	text-size:20;
  	padding:4px 4px;
	margin: 8px 5px;
  }

  #search{
  	 padding:6px 10px;
  	 height:30px;
  }
  #mybtn{
  	text-align:center;
  	margin :0 auto;
  }
  #InVisBtn{
  	visibility : hidden;
  	border : none;
  }
  #myCarousel{
  	height:400px;
  	
  }
  .column {
  float: left;
  width: 25%;
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

  <h2 style="color:white; font-family:Verdana, Geneva, sans-serif;"> Versla
   <!-- Trigger the modal with a button -->
	  <button type="button" class="btn btn-default  btn-lg pull-right"  id="myBtn" value="Login">Login</button>
	 <button type="button" class="btn btn-default btn-lg pull-right"  id="myBtn2" value ="Registration">Registration</button>
	 <center>
	   <form class="navbar-form " action="">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
    </center>
	 </h2>
	 	   <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog"> 
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:2px 8px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
           <div class="item active"><center>
        <img src="image/user.jpg" class="img-circle"  alt="Cinque Terre"style="width:92px; height:92px;" ></center>
      </div>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" action="./VerslaController" method="post">
            <div class="form-group">
            
              <label for="username"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="username" name="email" placeholder="Enter Username or Email Id" required auto-focus>
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" id="psw" name="password" placeholder="Enter password" required>
            </div>
            <input type="radio" name="action" value="Moderator"> Moderator
            <input type="radio" name="action" value="User" checked> User<br>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div><center>
             <button type="submit" id="mybtn" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-off"></span> Login</button>
            
             </center>
            </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-right" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
       <!--   <button type="submit" onClick="SignUp" href="#myModal1"class="btn btn-danger btn-default pull-left"><span class="glyphicon glyphicon-off"></span> SignUp</button>
              -->
        <!--  <p>Not a member? <a href="#myModal1">Sign Up</a></p> -->
         <p align ="left">&nbsp;Not a member? <a class="btn btn-primary btn-default pull-left" data-toggle="modal" href="#myModal1">Sign Up</a></p>
      
              
        </div>
      </div> 
      
    </div>
  </div> 
</div>
 

  <!-- Modal -->
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header1" style="padding:25px 40px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h5><span class="glyphicon glyphicon-lock"></span> Registration</h5>
                     <div class="item active"><center>
        <img src="image/admin.png" class="img-circle"  alt="Cinque Terre"style="width:92px; height:92px;" ></center>
      </div>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" action="./VerslaController" method="post">
            <div class="form-group">
              <label for="username"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
            </div>
             <div class="form-group">
              <label for="email"><span class="glyphicon glyphicon-envelope"></span> Email Id</label>
              <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email Id">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" id="psw" name="password" placeholder="Enter password">
            </div>
           <!--   <div class="form-group">
              <label for="dob"><span class="glyphicon glyphicon-calendar"></span> Date Of Birth</label>
              <input type="date" class="form-control" id="dob" name="dob" placeholder="DD/MM/YYYY">
            </div>-->
            <input type="hidden" name="action" value="RegisterUser">
             <div class="form-group">
              <label for="phone"><span class="glyphicon glyphicon-earphone"></span> Phone Number</label>
              <input type="number" class="form-control" id="phone" name="phone" placeholder="Enter Phone Number">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Register</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-right" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
      
    </div>
  </div> 
  </div>
  
  
 <form action="./item.jsp">
	<div id="sidebar-left">
	<div class="row">
  <div class="column">
   <div class="thumbnail" id="home" >
        <a  target="_blank">
   <button type="submit">
   <img src="image/greyh.jpg" alt="Properties" style="width:150px; height:90px;">
   <figcaption align="center">Properties</figcaption>
   </button>
    </a>
    </div>
  </div>
  
  
  <div class="column">
   <div class="thumbnail" id="lapi">
        <a  target="_blank">
        <input type="hidden" name="action" value="item">
            <img src="image/lapi.png" alt="Forest" style="width:100px; height:90px;">
            <figcaption align="center">Electronics</figcaption>
            </a>
   </div>
  </div>
  <div class="column">
 <div class="thumbnail" id="furni">
        <a  target="_blank">
        <input type="hidden" name="action" value="item">
    <img src="image/furni.jpg" alt="Furniture" style="width:100px; height:90px;">
            <figcaption align="center">Furniture</figcaption>
    </a>
    </div>
  </div>
  <div class="column">
  <div class="thumbnail" id="car">
        <a  target="_blank">
    	<input type="hidden" name="action" value="item">
    <img src="image/car1.png" alt="Cars" style="width:100px; height:90px;">
    <figcaption align="center">Cars</figcaption></a>
    </div>
  </div>
</div>
<div class="row">
  <div class="column">
  <div class="thumbnail" id="fashion">
        <a  target="_blank">
        <input type="hidden" name="action" value="item">
    <img src="image/fashion.png" alt="Fashion" style="width:100px ;height:90px;">
    <figcaption align="center">Fashion</figcaption></a>
    </div>
  </div>
  <div class="column">
  <div class="thumbnail" id="mobile">
        <a  target="_blank">
        <input type="hidden" name="action" value="item">
    <img src="image/phone.jpg" alt="Mobiles" style="width:100px; height:90px;">
    <figcaption align="center">Moblie</figcaption></a>
    </div>
  </div>
  <div class="column">
  <div class="thumbnail" id="cycle">
        <a  target="_blank">
        <input type="hidden" name="action" value="item">
    <img src="image/cycle.jpg" alt="Bikes" style="width:100px; height:90px;">
    <figcaption align="center">Bikes</figcaption></a>
    </div>
  </div>
  <div class="column">
  <div class="thumbnail" id="book">
        <a  target="_blank">
        <input type="hidden" name="action" value="item">
    <img src="image/book.jpg" alt="Books" style="width:100px; height:90px;">
    <figcaption align="center">Books</figcaption></a>
    </div>
  </div>
</div>
<div class="row">
  <div class="column">
  <div class="thumbnail" id="pet">
        <a  target="_blank">
        <input type="hidden" name="action" value="item">
    <img src="image/pet.jpg" alt="Pets" style="width:100px; height:90px;">
    <figcaption align="center">Pets</figcaption></a>
    </div>
  </div>
  <div class="column">
  <div class="thumbnail" id="setting">
        <a  target="_blank">
        <input type="hidden" name="action" value="item">
    <img src="image/setting.jpg" alt="Services" style="width:100px; height:90px;">
    <figcaption align="center">Services</figcaption></a>
    </div>
  </div>
</div>
</div>
</form>
<div id="sidebar-right">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
       <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
         <li data-target="#myCarousel" data-slide-to="5"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="image/picmm.jpg" alt="pic1" style="width:100%; height:400px;" >
      </div>

      <div class="item">
        <img src="image/icon1.jpg" alt="pic2" style="width:100%; height:400px;">
      </div>
    	 <div class="item">
        <img src="image/olx.png" alt="pic3" style="width:100%; height:400px;">
      </div>
       <div class="item">
        <img src="image/shop.jpg" alt="pic4" style="width:100%; height:400px;">
      </div>
      <div class="item">
        <img src="image/icon.jpg" alt="pic5" style="width:100%; height:400px;">
      </div>
      
       <div class="item">
        <img src="image/olx1.jpg" alt="pic6" style="width:100%; height:400px;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<!-- 
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#myBtn2").click(function(){
        $("#myModal1").modal();
    });
});
$(document).ready(function(){
    $("#fashion").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#home").click(function(){
        $("").modal();
    });
});
$(document).ready(function(){
    $("#lapi").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#furni").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#car").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#mobile").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#cycle").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#book").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#pet").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#setting").click(function(){
        $("#myModal").modal();
    });
});
window.onscroll = function() {myFunction()};
var header = document.getElementById("myHeader");
var sticky = header.offsetTop;
function myFunction() {
  if (window.pageYOffset >= sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
}
-->
</script>
<div class="footer" id="footer1" align="center">@copyrights Preethi Vineela Manasa Hema </div>
</body>
</html>
    