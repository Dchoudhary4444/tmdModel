function dummyPOJO()
{
this.name="";
}
function AdminLoginManager()
{
this.login=function(argument1,successHandler,exceptionHandler)
{
service.postJSON('adminLogin/login',{
'argument-1': argument1
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
}
var adminLoginManager=new AdminLoginManager();
