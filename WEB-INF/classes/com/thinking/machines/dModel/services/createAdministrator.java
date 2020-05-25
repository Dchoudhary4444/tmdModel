package com.thinking.machines.dModel.services;
import com.thinking.machines.dModel.dl.*;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.dmframework.*;
import com.thinking.machines.dmframework.exceptions.*;
import com.thinking.machines.dModel.exceptions.*;
import java.util.*;
import com.thinking.machines.dModel.utilities.*;
@Path("/addAdmin")
public class createAdministrator
{
@Post
@Path("add")
public Object add(Administrator administrator)
{
System.out.println("Abhishek");
Administrator dlAdmin=new Administrator();
String passwordKey=UUID.randomUUID().toString();
String encryptedPassword=utility.encrypt(administrator.getPassword(), passwordKey) ;

if(administrator.getUsername().length()==0 || administrator.getUsername()==null)
{
return false;
}


dlAdmin.setUsername(administrator.getUsername());
dlAdmin.setPassword(encryptedPassword);
dlAdmin.setPasswordKey(passwordKey);
dlAdmin.setEmailId(administrator.getEmailId());
dlAdmin.setFirstName(administrator.getFirstName());
dlAdmin.setLastName(administrator.getLastName());
dlAdmin.setMobileNumber(administrator.getMobileNumber());
System.out.println("dl me data enter");
try
{
System.out.println("data will be added");

DataManager datamanager=new DataManager();
datamanager.begin();
datamanager.insert(dlAdmin);
datamanager.end();
System.out.println("data added");

return dlAdmin;
}
catch(ValidatorException validatorException)
{
System.out.println("VE Exception");

return validatorException;
}
catch(DMFrameworkException dmFrameworkException)
{
System.out.println("DM exception");

return new Exception(dmFrameworkException.getMessage());
}
}
}//class ends











/*
System.out.println("hello");
System.out.println(administrator.getUsername());
System.out.println(administrator.getPassword());
System.out.println(administrator.getFirstName());
System.out.println(administrator.getLastName());
System.out.println(administrator.getEmailId());
System.out.println(administrator.getMobileNumber());
*/
