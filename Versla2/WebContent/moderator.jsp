<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Moderator</title>
</head>
<body>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  #body{
  background:url(image/bgmod.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  }
  #header {
  border-radius: 10px;
  height:80px;
  background-color:#1E90FF;
  font-size:18px;
  margin:0;
  padding:1px 5px;
  font-style:normal;
  width:100%;
  background-image:url("image/bgHeader.jpg");
  background-size:540px 90px;
  }
  #footer {
  background-color: pink;
  text-align: "center";
  border-radius: 10px;
  height: 15%;
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
  .modal-header2, h6, .close {
      background-color:#20B2AA ;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-header3, h6, .close {
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
	font-size:14px;
	text-size:20;
	padding:15px 32px;
	margin: 8px 5px;
  }
  #myBtn1{
  	background-color:#f9f9f9 ;
	font-size:14px;
	text-size:20;
	padding:15px 32px;
	margin: 8px 5px;
  }
   #myBtn2{
  	background-color:#f9f9f9 ;
  	font-size:14px;
  	text-size:20;
  	padding:15px 32px;
	margin: 8px 5px;
  }
  #myBtn3{
  	background-color:#f9f9f9 ;
	font-size:14px;
	text-size:50;
	padding:15px 15px;
	margin: 4px 4px;
  }
  #myBtn4{
  	background-color:#f9f9f9 ;
	font-size:14px;
	text-size:50;
	padding:15px 15px;
	margin: 4px 4px;
  }
    #myBtn8{
  	background-color:#f9f9f9 ;
	font-size:14px;
	text-size:20;
	padding:15px 32px;
	margin: 8px 4px;
  }
  #search{
  	 padding:0px 0px;
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
  .container img {vertical-align: middle;}
  .container .content {
    position: absolute;
    bottom: 0;
    background: rgba(0, 0, 0, 0.5); /* Black background with transparency */
    color: #f1f1f1;
    width: 100%;
    padding: 20px;
}
* {
    box-sizing: border-box;
}
  </style>
  </head>
  <body>
  <div id="header">
<div class="container">
  <h2 >  <a href="VerslaController" target="_black" rel="noopener" style="color:white; font-family:Verdana, Geneva, sans-serif;">Versla</a>
   <!-- Trigger the modal with a button -->
   <a href="VerslaController">
	  	 <button type="button" class="btn btn-default  btn-lg pull-right"  id="myBtn" value="Logout">Logout</button></a>
	  	 <button type="button" class="btn btn-default  btn-lg pull-right"  id="myBtn8" value="Approve Items">Approve Items</button>
	  	 <button type="button" class="btn btn-default btn-lg pull-right" onClick="fun_hide_cat('block','subcat')"id="myBtn1" value ="Subcategory">Sub category</button>&nbsp;
<form action="./VerslaController" method = "post">	  
	  <button type="button" class="btn btn-default btn-lg pull-right"  onClick="fun_hide_cat('block','cat')"  id="myBtn2" value ="Category">Category</button>&nbsp;
	  <c:forEach items="${categoryList}" var="categoryList">
	<div class = "column">
			<div id= "img">
			<img src ="./category/${categoryList.logo}">
        	CategoryName : ${categoryList.categoryName}<br>
        </div>
     </div>
</c:forEach>
<input type = "hidden" name = "action" value = "button1">
</form>
<h2>
 <!-- Modal -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header2" style="padding:25px 40px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h6><span class="glyphicon glyphicon-plus"></span> AddCategory
            </h6>
           
        </div>
        <div class="modal-body" style="padding:20px 30px;">
        
          <form role="form" action="./VerslaController" method="POST" enctype="multipart/form-data">
               <label for="name"><span class="glyphicon glyphicon-th-list"></span> Category Name</label>
              <input type="text" class="form-control" id="catname" name="name" placeholder="Enter Category Name"><br>
              <label for="name"><span class="glyphicon glyphicon-picture"></span> Select Image</label>
              <input type="file" name="image" id="img">
              <input type="hidden" name="action" value="Category">
              <center>
                <button type="submit" class="btn btn-primary btn-lg ">Add</button>
              </center>
            </form>
         </div>
         
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-right" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
      </div>
    </div>
  </div> 
<!-- Modal -->
  <div class="modal fade" id="myModal3" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header3" style="padding:25px 40px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h6><span class="glyphicon glyphicon-plus"></span> AddSubCategory
            </h6>
           
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        
          <form role="form" action="VerslaController" method="POST" enctype="multipart/form-data">
          <label for="name"><span class="glyphicon glyphicon-th-list"></span> Subcategory Name</label>
              <input type="text" class="form-control" id="subcatname" name="subcategory" placeholder="Enter Subcategory Name"><br>
             <label for="name"><span class="glyphicon glyphicon-th-list"></span> Select Category Name</label> <br>
               <input type="text" class="form-control" id="subcatname" name="categoryInSubCategory" placeholder="Enter Subcategory Name"><br>
<br>
         <label for="name"><span class="glyphicon glyphicon-picture"></span> Select Image</label> <br>
            <input type="file" name="image" id="img"><br>
        	<input type="hidden" name="action" value="subCategory">
            <center>
          <button type="submit" class="btn btn-primary btn-lg ">Add</button>
          </center>
        
            </form>
       </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-right" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
       </div>
    </div>
  </div> 
  <div class="body">
  
  </div>
 <div  id="cat" style="display : none">
 	
 	 <button type="button" class="btn btn-default btn-s pull-down" id="myBtn3" value="AddCategory">+AddCategory</button>
 	 
	
      </div>
      <div id="subcat" style="display : none">
      	<button type="button" class="btn btn-default btn-s pull-down" id="myBtn4" value="AddSubCategory">+AddSubCategory</button>
 	</div>

<script>
$(document).ready(function(){
    $("#myBtn1").click(function(){
        $("#myModal").modal();
    });
});
$(document).ready(function(){
    $("#myBtn2").click(function(){
        $("#myModal1").modal();
        
    });
});
$(document).ready(function(){
    $("#myBtn3").click(function(){
        $("#myModal2").modal();
    });
});
$(document).ready(function(){
    $("#myBtn4").click(function(){
        $("#myModal3").modal();
    });
});
</script>
<script type="text/javascript">
	function fun_hide_cat(message,divName){
		if(divName == 'cat'){
			document.getElementById("cat").style.display=message;
			document.getElementById("subcat").style.display= "none";
		}
		else{
			document.getElementById("cat").style.display="none";
			document.getElementById("subcat").style.display= message;
		}
		
	}
</script>
</body>
</html>