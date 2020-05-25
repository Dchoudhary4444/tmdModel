<%@taglib uri="/WEB-INF/tlds/mytags.tld" prefix="tm" %>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.dModel.beans.ErrorBean'/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
<meta name="description" content="">
    
<meta name="author" content="">

    
<title>Member - Login</title>

    
<!-- Bootstrap core CSS-->
    
<link href="/tmdModel/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    
<!-- Custom fonts for this template-->
    
<link href="/tmdModel/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    
<!-- Custom styles for this template-->
    
<link href="/tmdModel/css/sb-admin.css" rel="stylesheet">


<script src='/tmdModel/JQuery/jquery-3.3.1.min.js></script>
<script src='/tmdModel/webservice/js/TMService.js'></script>
<script>
function attachEvents()
{
var loginForm=$("#loginForm");
var databaseServer=loginForm.find("#databaseServer");
databaseServer.on("input",function(){
if(databaseServer.val().trim()) databaseServer.removeClass("is-invalid");
else databaseServer.addClass("is-invalid");
});
}
function processLoginForm()
{
var loginForm=$("#loginForm");
var errors=0;
var isFocus=false;
//var doForward=false;
var mailId=loginForm.find("#emailId");
if(!mailId.val().trim())
{
mailId.addClass("is-invalid");
errors++;
if(!isFocus) mailId.focus();
isFocus=true;
}
else mailId.removeClass("is-invalid");

var password=loginForm.find("#password");
if(!password.val().trim())
{
password.addClass("is-invalid");
errors++;
if(!isFocus) password.focus();
isFocus=true;
}
else password.removeClass("is-invalid");
var captchaCode=loginForm.find("#captchaCode");
if(!captchaCode.val().trim())
{
captchaCode.addClass("is-invalid");
errors++;
if(!isFocus) captchaCode.focus();
isFocus=true;
}
else captchaCode.removeClass("is-invalid");
// see to it that this should happen only once:-->  attachEvents();
/*waitingDialog.show("Processing");
w1=waitingDialog.animate("Processing");
setTimeout(function(){
waitingDialog.stopAnimate(w1);
waitingDialog.message("ruk na");
}
,2000);*/

var cap={
"argument-1":$("#loginForm").find("input[name=captchaCode]").val()
};
alert(JSON.stringify(cap));
var captchaResult=false;
$.ajax('/tmdModel/webservice/captchaService/validateCaptcha',{
type:"POST",
contentType:"application/json",
data:JSON.stringify(cap),
success:function(res)
{
if(res.success)
{
if(res.isReturningSomething)
{
if(res.result)
{

alert(JSON.stringify(res.result));
document.getElementById('loginForm').action='/tmdModel/webservice/memberLogin/login';
document.getElementById('loginForm').submit();
}
else alert("Invalid captcha");
}//returning something
}//res.success
}//success function
}); //captcha ajax
}//processForm
</script>
</head>

 
<body class="bg-dark">

    
<div class="container">
      
<div class="card card-login mx-auto mt-5">
        
<div class="card-header">Login</div>
        
<div class="card-body">
          
<span><tm:Error name='errorBean' scope='request' >${error}</tm:Error></span>
<form method='Post' id='loginForm' action='/tmdModel/memberLogin1.jsp'  novalidate>

<div class="form-group">
              
<div class="form-label-group">
                
<input type="email" id="emailId" name="argument-1" class="form-control ${isValid}"  placeholder="Email address"   required="required"   autofocus="autofocus" value=${emailId}>
                
<span><tm:Error name='errorBean' scope='request' property='emailId'>${error}</tm:Error></span>
<label for="emailId">Email address</label>
              
</div>
            
</div>
            
<div class="form-group">
              
<div class="form-label-group">
                
<input type="password" id="password" name="argument-2"  class="form-control" placeholder="Password"  autofocus="autofocus" required="required">
                
<tm:Error name='errorBean' scope='request' property='password'>${error}</tm:Error>
<label for="password">Password</label>
              
</div>
            
</div>
            
<div class="form-group">
              
<div class="checkbox">
                
<label>
                  
<input type="checkbox" value="remember-me">
                  
Remember Password
                
</label>
              
</div>
            
</div>
            
<!-- Security Card Starts here -->
<div class='card card-register mx-auto mt-1'>
<div class='card-header'>Input security</div>
<div class='card-body'>
<div class='form-group'>
<!--div class='form-row'-->
<div class='col-md-2'> <!--uncommented-->
<img src='/tmdModel/webservice/captcha' />
</div>
<div class='col-md-8'>
<div class='form-label-group'>
<input type='text' id='captchaCode' name='captchaCode' placeholder='CAPTCHA' required='required' class='form-control'>
<label for='captchaCode'>CAPTCHA</label>
</div>
</div> <!--Uncommented-->
<!--/div-->
</div>
</div> <!-- card body -->
</div> <!-- card -->
<!-- Security Card Ends here -->
<button type='button' onclick='processLoginForm()'   class="btn btn-primary btn-block" >Login</button>
</form>
          
<div class="text-center">
            
<a class="d-block small mt-3" href="signup.html">Register an Account</a>
            
<a class="d-block small" href="forgot-password.html">Forgot Password?</a>
          
</div>
        
</div>
      
</div>
    
</div>


<!-- Bootstrap core JavaScript-->
    
<script src="/tmdModel/vendor/jquery/jquery.min.js"></script>
    
<script src="/tmdModel/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


<!-- Core plugin JavaScript-->
    
<script src="/tmdModel/vendor/jquery-easing/jquery.easing.min.js"></script>

  
</body>


</html>