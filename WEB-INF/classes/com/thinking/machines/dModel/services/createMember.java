package com.thinking.machines.dModel.services;
import com.thinking.machines.dModel.dl.*;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.tmws.*;
import com.thinking.machines.dmframework.*;
import com.thinking.machines.dmframework.exceptions.*;
import com.thinking.machines.dModel.exceptions.*;
import com.thinking.machines.dModel.utilities.*;
import java.util.*;
@Path("/addMember")
public class createMember
{
@Post
@Path("add")
public Object add(Member member)
{
System.out.println("Member chala");
Member dlMember=new Member();
List<Member> dbMember; 
String passwordKey=UUID.randomUUID().toString();
String encryptedPassword=utility.encrypt(member.getPassword(), passwordKey) ;
dlMember.setEmailId(member.getEmailId());
dlMember.setPassword(encryptedPassword);
dlMember.setPasswordKey(passwordKey);
dlMember.setFirstName(member.getFirstName());
dlMember.setLastName(member.getLastName());
dlMember.setMobileNumber(member.getMobileNumber());
dlMember.setStatus("A");
dlMember.setNumberOfProjects(0);
try
{
DataManager dataManager=new DataManager();
dataManager.begin();
dbMember=dataManager.select(Member.class).query();
for(Member m:dbMember)
{
System.out.println("database:"+m.getEmailId());
System.out.println("HTML:"+member.getEmailId());
if(m.getEmailId().equals(member.getEmailId()))
{
dataManager.end();
System.out.println("Should Not be Added");
return false;
}
}
dataManager.insert(dlMember);
System.out.println("Member Added");
dataManager.end();
return dlMember;
//return new TMForward("/tmdModel/memberLogin1.jsp");
}catch(ValidatorException validatorException)
{
return validatorException;
}catch(DMFrameworkException dmFrameworkException)
{
return new Exception(dmFrameworkException.getMessage());
}
}
}