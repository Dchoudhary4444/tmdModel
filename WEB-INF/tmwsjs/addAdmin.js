function AddAdminManager()
{
this.add=function(argument1,argument2,successHandler,exceptionHandler)
{
service.postJSON('addAdmin/add',{
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
var addAdminManager=new AddAdminManager();
