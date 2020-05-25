<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Member - Register</title>
<!-- Bootstrap core CSS-->
<link href="/tmdModel/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="/tmdModel/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="/tmdModel/css/sb-admin.css" rel="stylesheet">
<!--link href="site/css/styles.css" rel="stylesheet"-->

<script src='/tmdModel/JQuery/jquery-3.3.1.min.js'></script>
<script src='/tmdModel/webservice/js/TMService.js'></script>
<script>
function attachEvents()
{
var memberSignupForm=$("#memberSignupForm");
}
function processMemberSignupForm()
{
var memberSignupForm=$("#memberSignupForm");
var errors=0;
var isFocus;
var doForward=false;
var password=memberSignupForm.find("#password");
if(!password.val().trim())
{
password.addClass("is-invalid");
errors++;
if(!isFocus) password.focus();
isFocus=true;
}
else password.removeClass("is-invalid");

var firstName=memberSignupForm.find("#firstName");
if(!firstName.val().trim())
{
firstName.addClass("is-invalid");
errors++;
if(!isFocus) firstName.focus();
isFocus=true;
}
else firstName.removeClass("is-invalid");

var lastName=memberSignupForm.find("#lastName");
if(!lastName.val().trim())
{
lastName.addClass("is-invalid");
errors++;
if(!isFocus) lastName.focus();
isFocus=true;
}
else lastName.removeClass("is-invalid");


var mailId=memberSignupForm.find("#mailID");
if(!mailId.val().trim())
{
mailId.addClass("is-invalid");
errors++;
if(!isFocus) mailId.focus();
isFocus=true;
}
else mailId.removeClass("is-invalid");


var phoneNumber=memberSignupForm.find("#phoneNumber");
if(!phoneNumber.val().trim())
{
phoneNumber.addClass("is-invalid");
errors++;
if(!isFocus) phoneNumber.focus();
isFocus=true;
}
else phoneNumber.removeClass("is-invalid");

var captchaCode=memberSignupForm.find("#captchaCode");
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
"argument-1":$("#memberSignupForm").find("input[name=captchaCode]").val()
};
//alert(JSON.stringify(cap));

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
//alert(JSON.stringify(res.result));
var memberDetails={
"argument-1":{
"emailId":$("#memberSignupForm").find("input[name=mailID]").val(),
"password":$("#memberSignupForm").find("input[name=password]").val(),
"firstName":$("#memberSignupForm").find("input[name=firstName]").val(),
"lastName":$("#memberSignupForm").find("input[name=lastName]").val(),
"mobileNumber":$("#memberSignupForm").find("input[name=phoneNumber]").val()
}
};
//alert("Data may be added");
$.ajax('/tmdModel/webservice/addMember/add',{
type:"POST",
contentType:"application/json",
data:JSON.stringify(memberDetails),
success:function(res)
{
if(res.success)
{
if(res.isReturningSomething)
{
doForward=res.result;
if(res.result)
{
alert("Signup successfull");
//alert(JSON.stringify(res.result));
mailId.removeClass("is-invalid");
// valid ka code
//alert(JSON.stringify(res.result));
location.replace("/tmdModel/memberLogin1.jsp");
}//resresult
else
{
mailId.addClass("is-invalid");
mailId.focus();
$(password).val(""); 
$(mailID).val(""); 
$(captchaCode).val(""); 
//$("input:text").val("");
//khali
//invalid
}
}//returning something
}//res.success
}//success function
});
}
}
else alert("Not Valid")
}
} //success
}); //captcha ajax
if(isFocus==false || doForward==false)
{
return false;
}
return true;
}//processForm

</script>
</head>
                       
<body class="bg-dark">

<div id="logo-container" class="col-md-4 col-md-offset-1">
<img src="images/logo.png" class="img-responsive" alt="LOGO">
</div>

<div class="container" id="container">
<div class="card card-register mx-auto mt-5">
<div class="card-header">Signup</div>
<div class="card-body">
<form id='memberSignupForm' novalidate>

<!-- Member Card Starts here -->
<div class="card card-register mx-auto mt-1">
<div class="card-header">Member</div>
<div class="card-body">
<div class='form-group'>

<div class='form-row'>
<div class='col-md-6'>
<div class='form-label-group'>
<input type='text' id='mailID' name='mailID' placeholder='Email Id' required='required' class='form-control'>
<label for='mailID'>Email Id</label>
</div>
</div>


<div class='col-md-6'>
<div class='form-label-group'>
<input type='text' id='password' name='password' placeholder='Password' required='required' class='form-control'>
<label for='password'>Password</label>
</div>
</div>
</div>
</div>
</div> <!-- card-body -->
</div> <!-- card -->
<!-- Member Card Ends here -->

<!-- Mail Server Card Starts here -->
<div class='card card-register mx-auto mt-1'>
<div class='card-header'>Personal Details</div>
<div class='card-body'>
<div class='form-group'>
<div class='form-row'>
<div class='col-md-6'>
<div class='form-label-group'>
<input type='text' id='firstName' name='firstName' placeholder='First Name' required='required' class='form-control'>
<label for='firstName'>First Name</label>
</div>
</div>

<div class='col-md-6'>
<div class='form-label-group'>
<input type='text' id='lastName' name='lastName' placeholder='Last Name' required='required' class='form-control'>
<label for='lastName'>Last Name</label>
</div>
</div>
</div>
</div>

<div class='form-group'>
<div class='form-label-group'>
<input type='text' id='phoneNumber' name='phoneNumber' placeholder='Phone Number' required='required' class='form-control'>
<label for='phoneNumber'>Phone Number</label>
</div>
</div>

</div>
</div>
<!-- Mail Server Card Ends here -->
<!-- Security Card Starts here -->
<div class='card card-register mx-auto mt-1'>
<div class='card-header'>Input security</div>
<div class='card-body'>
<div class='form-group'>
<div class='form-row'>
<div class='col-md-6'>
<img src='webservice/captcha' />
</div>


<div class='col-md-6'>
<div class='form-label-group'>
<input type='text' id='captchaCode' name='captchaCode' placeholder='CAPTCHA' required='required' class='form-control'>
<label for='captchaCode'>CAPTCHA</label>
</div>
</div>






</div>
</div>
</div> <!-- card body -->
</div> <!-- card -->
<!-- Security Card Ends here -->
<button type='button' onclick='processMemberSignupForm()' class="btn btn-primary btn-block">Signup</button>
</form>
</div>
</div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="/tmdModel/vendor/jquery/jquery.min.js"></script>
<script src="/tmdModel/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="/tmdModel/vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- waiting for plugin -->
<!--script src="/tmdModel/vendor/waiting/bootstrap-waitingfor.js"></script -->
</body>
</html>