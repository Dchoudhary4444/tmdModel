package com.thinking.machines.dModel.services;
import com.thinking.machines.dModel.services.pojo.dummyPOJO;
import com.thinking.machines.dModel.utilities.*;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.dmframework.exceptions.*;
import com.thinking.machines.dModel.dl.*;
import com.thinking.machines.dmframework.*;
import java.util.*;
@Path("/adminLogin")
public class adminLogin
{
@Post
@Path("login")
public Object login(dummyPOJO dp)
{
try
{
System.out.println("Chalalalalalaa");
System.out.println(dp.getName());
/*
Administrator dlAdmin =new Administrator();
dlAdmin.setEmailId(administrator.getEmailId());
dlAdmin.setPassword(administrator.getPassword());
List<Administrator> dbAdmin; //dlDepartments
List<Administrator> admin; //departments
Administrator dAdmin=null;
DataManager dataManager=new DataManager();
dataManager.begin();
dbAdmin=dataManager.select(Administrator.class).query();
dataManager.end();
admin=new LinkedList<Administrator>();

for(Administrator a:dbAdmin)
{
dAdmin=new Administrator();
dAdmin.setEmailId(a.getEmailId());
dAdmin.setPasswordKey(a.getPasswordKey());
dAdmin.setPassword(a.getPassword());
admin.add(dAdmin);
}
String decryptedPassword=utility.decrypt(dAdmin.getPassword(), dAdmin.getPasswordKey());



System.out.println("Sahi Password, "+decryptedPassword);




if(dlAdmin.getEmailId().equals(dAdmin.getEmailId()))
{
if(decryptedPassword.equals(dlAdmin.getPassword()))
{
return true;
}
else
{
return false;
// galat password ki condition
}
}
else
{
return false;
//galat username ki condition
}











*/
return true;
}//try
/*
catch(DMFrameworkException dmFrameWorkException)
{
return new Exception (dmFrameWorkException) ;
}
*/
catch(Exception dmFrameWorkException)
{
return new Exception (dmFrameWorkException) ;
}

}//method
}//class