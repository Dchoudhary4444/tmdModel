<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin -Home Page</title>
<!-- Bootstrap core CSS-->
<link href="/tmdModel/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="/tmdModel/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="/tmdModel/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/tmdModel/css/sb-admin.css" rel="stylesheet">

<!--link href="/tmdModel/JQuery/bootstrap.min.css" rel="stylesheet" -->

    
<script src='/tmdModel/JQuery/jquery-3.3.1.min.js'></script>
<script src="/tmdModel/JQuery//bootstrap.min.js"></script>

</head>

<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
<h1 class="navbar-brand mr-0">Menu</h1>
<button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
<i class="fas fa-bars"></i>
</button>


<!-- Navbar -->
<ul class="navbar-nav ml-auto mr-md-3">
<h1 class="navbar-brand mr-0 text-white" aria-haspopup="true" aria-expanded="false">    
<i class="fas fa-user-circle fa-fw">
</i>
${sessionScope.username}
</h1>
</ul>
</nav>
<div id="wrapper">
<!-- Sidebar -->
<ul class="sidebar navbar-nav">
<li class="nav-item active">
<a class="nav-link" href="index.html">
<!-- i class="fas fa-fw fa-tachometer-alt"></i-->
<span>My Subscription</span>
</a>
</li>


<li class="nav-item active">
<a class="nav-link"  data-toggle="modal" data-target="#openProjectModal">
<!-- i class="fas fa-fw fa-tachometer-alt" ></i-->
<span>Open Project</span>
</a>
</li>

<li class="nav-item active">
<a class="nav-link"  data-toggle="modal" data-target="#createProjectModal">
<!-- i class="fas fa-fw fa-tachometer-alt" ></i-->
<!--button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#createProjectModal">crea</button-->
<span>Create Project</span>
</a>
</li>

<li class="nav-item active">
<a class="nav-link" href="index.html">
<!-- i class="fas fa-fw fa-tachometer-alt"></i-->
<span>Edit Profile</span>
</a>
</li>

<li class="nav-item active">
<a class="nav-link" href="#" data-toggle="modal" data-target="#logoutModal">
<!-- i class="fas fa-fw fa-tachometer-alt"></i-->
<span>Logout</span>
</a>
</li>
</ul>

<div id="content-wrapper">
<div class="container-fluid">

<!-- /.container-fluid -->

<!-- Sticky Footer -->
<footer class="sticky-footer">
<div class="container my-auto">
<div class="copyright text-center my-auto">
<span>Copyright �Thinking Machines 2019</span>
</div>
</div>
</footer>

</div>
<!-- /.content-wrapper -->
</div>
<!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modals-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop='static'>
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">�</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="/tmdModel/webservice/memberService/logout">Logout</a>
          </div>
        </div>
      </div>
    </div>


   

<!--create project  Modal -->
<div class="modal fade" id="createProjectModal" role="dialog" data-backdrop='static'>
<div class="modal-dialog modal-lg">
<div class="modal-content">
<div class="modal-header">
<h4 class="modal-title">Create Project</h4>          
<button type="button" class="close" data-dismiss="modal">&times;</button>
</div>
<div class="modal-body">
<form method='Post' id='modalCreateProject' action='/tmdModel/webservice/projectService/create' novalidate>

<div class="form-group">
<label class="sr-only" for="projectTitle">Project Title</label>
<input type="text" id="projectTitle" name="argument-1" class="form-control" placeholder="Project Title "   required="required"   autofocus>
</div>

<h6>
<b>Select Database Architecture</b>
<select class="btn btn-secondary dropdown-toggle" name='argument-2' id='projectArchitecture'>
<c:forEach var="message" items="${applicationScope.databaseArchitectures}">
<option  value="${message.code}">${message.name}</option>
</c:forEach>
</select>
</h6>

</div>
<div class="modal-footer">
<input type="submit" class="btn btn-default btn-lg" value='Create'  >
<button type="button" class="btn btn-default btn-lg"  data-dismiss="modal" >Close</button>
</div>
</div>
</form>
</div>
</div>


<!--Open Project Modal-->

<!-- Modal -->
<div class="modal fade" id="openProjectModal" role="dialog" data-backdrop='static'>
<div class="modal-dialog modal-lg">
<div class="modal-content">
<div class="modal-header">
<h4 class="modal-title">Select Project</h4>          
<button type="button" class="close" data-dismiss="modal">&times;</button>
</div>
<div class="modal-body">
<form method='Post' action='/tmdModel/webservice/projectService/openProject' novalidate>


<h6>
<b>Select Project</b>
<select class="btn btn-secondary dropdown-toggle"  id='projectName' name='projectName'>
<c:forEach var="message" items="${sessionScope.projects}">
<option value="${message.code}">${message.title}</option>
</c:forEach>

</select>
</h6>
</div>
<div class="modal-footer">
<input type="submit" class="btn btn-default btn-lg" value='Open' >
</div>
</div>
</form>
</div>
</div>
<!--OpenProjectModal Ends-->



<!-- Bootstrap core JavaScript-->
    <script src="/tmdModel/vendor/jquery/jquery.min.js"></script>
    <script src="/tmdModel/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/tmdModel/vendor/jquery-easing/jquery.easing.min.js"></script>

    
    <!-- Custom scripts for all pages-->
    <script src="/tmdModel/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
  
  </body>

</html>
