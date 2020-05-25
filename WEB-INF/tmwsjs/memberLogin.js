function TMForward()
{
}
function MemberLoginManager()
{
this.login=function(argument1,argument2,successHandler,exceptionHandler)
{
service.postJSON('memberLogin/login',{
'argument-1': argument1,
'argument-2': argument2
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
}
var memberLoginManager=new MemberLoginManager();
