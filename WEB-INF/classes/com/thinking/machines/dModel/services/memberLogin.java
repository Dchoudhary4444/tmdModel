package com.thinking.machines.dModel.services;
import com.thinking.machines.dModel.utilities.*;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.tmws.*;
import com.thinking.machines.dmframework.exceptions.*;
import com.thinking.machines.dModel.dl.*;
import com.thinking.machines.dmframework.*;
import com.thinking.machines.dModel.beans.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
@Path("/memberLogin")
public class memberLogin
{
private HttpServletRequest request;
private HttpSession session;
private ServletContext servletContext;
public void setServletContext(ServletContext servletContext)
{
System.out.println("Context is being set");
this.servletContext=servletContext;
}
public void setHttpRequest(HttpServletRequest request)
{
System.out.println("Request is being set");
this.request=request;
}
public void setHttpSession(HttpSession session)
{
System.out.println("Session is being Injected");
this.session=session;
}
@InjectApplication
@InjectSession
@InjectRequest
@Post
@Path("login")
public TMForward login(String emailId,String password)
{
try
{
ErrorBean errorBean=new ErrorBean();
if(emailId==null || emailId.length()==0) errorBean.addError("emailId","Email Required");
if(password==null || password.length()==0) errorBean.addError("password","Password Required");
//errorBean.addError("isValid","is-invalid");
if(errorBean.hasErrors())
{
this.request.setAttribute("errorBean",errorBean);
return new TMForward("/memberLogin1.jsp");
}

//extracting data from application scope
List<com.thinking.machines.dModel.services.pojo.DatabaseArchitecture> databaseArchitectures=null;
List<com.thinking.machines.dModel.services.pojo.DatabaseEngine> databaseEngines=null;
List<com.thinking.machines.dModel.services.pojo.DatabaseTable> databaseTables=null;
List<com.thinking.machines.dModel.services.pojo.Project> projects=new LinkedList<com.thinking.machines.dModel.services.pojo.Project>(); 
List<com.thinking.machines.dModel.services.pojo.Field> fields=null;
//dl ki lists
List<Project> dlProjects=null;
List<DatabaseTable> dlDatabaseTables=null;
List<Member> dbMembers=null;
List<DatabaseTableField> dlFields=null; 

	
Member dlmember =new Member();
dlmember.setEmailId(emailId);
dlmember.setPassword(password);
DataManager dataManager=new DataManager();
dataManager.begin();
dbMembers=dataManager.select(Member.class).query();
//dataManager.end();
String decryptedPassword=" " ;
com.thinking.machines.dModel.services.pojo.Project project;
for(Member a:dbMembers)
{
System.out.println("Member me gya");
decryptedPassword=utility.decrypt(a.getPassword(), a.getPasswordKey());
System.out.println(decryptedPassword);
System.out.println(emailId);

if((a.getEmailId().equals(emailId) && decryptedPassword.equals(password)))
{
System.out.println("user name password match kar gya");
databaseArchitectures=(List<com.thinking.machines.dModel.services.pojo.DatabaseArchitecture>)this.servletContext.getAttribute("databaseArchitectures");
System.out.println("datbaseARchitectures ki size "+databaseArchitectures.size());
databaseEngines=(List<com.thinking.machines.dModel.services.pojo.DatabaseEngine>)this.servletContext.getAttribute("databaseEngines");
System.out.println("Database Engines ki size "+databaseEngines.size());
dlProjects=dataManager.select(Project.class).where("memberCode").eq(a.getCode()).query();
if(dlProjects.size()!=0)
{
for(Project proj:dlProjects)
{
System.out.println("Project me gya");
project=new com.thinking.machines.dModel.services.pojo.Project();
project.setCode(proj.getCode());
project.setTitle(proj.getTitle());
System.out.println("Title :"+project.getTitle());
for(com.thinking.machines.dModel.services.pojo.DatabaseArchitecture dba: databaseArchitectures)
{
if(dba.getCode().equals(proj.getDatabaseArchitectureCode()))
{
dba.setDatabaseEngine(databaseEngines);
project.setDatabaseArchitecture(dba);
System.out.println("Database Architecture code"+dba.getCode());
break;
}
}
project.setDateOfCreation(proj.getDateOfCreation());
project.setTimeOfCreation(proj.getTimeOfCreation());
System.out.println("dba ka for khatam");
System.out.println(project.getDateOfCreation());
System.out.println(project.getTimeOfCreation());



dlDatabaseTables=dataManager.select(DatabaseTable.class).where("projectCode").eq(proj.getCode()).query();
databaseTables=new LinkedList<com.thinking.machines.dModel.services.pojo.DatabaseTable>();
if(dlDatabaseTables.size()!=0)
{
System.out.println("Table ki info nikal li");
System.out.println(dlDatabaseTables);
for(DatabaseTable dt:dlDatabaseTables)
{
fields=new LinkedList<com.thinking.machines.dModel.services.pojo.Field>();
System.out.println("database table ke for loop me gya");
System.out.println("dl ke for me gya");
com.thinking.machines.dModel.services.pojo.DatabaseTable dataTable =new com.thinking.machines.dModel.services.pojo.DatabaseTable(); 
dataTable.setCode(dt.getCode());
dataTable.setName(dt.getName());
dataTable.setNote(dt.getNote());
dataTable.setxLocation(dt.getXLocation());
dataTable.setyLocation(dt.getYLocation());
for(com.thinking.machines.dModel.services.pojo.DatabaseEngine des:databaseEngines)
{
if(des.getCode()==dt.getCode())
{
dataTable.setDatabaseEngine(des);
System.out.println("Database Engine :"+des.getCode()+" , "+des.getName());
break;
}
}//database engines ka loop khtam

dlFields=dataManager.select(DatabaseTableField.class).where("tableCode").eq(dt.getCode()).query();
System.out.println("Database Ki fields:"+dlFields);
for(DatabaseTableField daf:dlFields)
{
System.out.println("DatabaseTableFields ka for loop in memberLogin");
com.thinking.machines.dModel.services.pojo.Field field=new com.thinking.machines.dModel.services.pojo.Field();
System.out.println("Fields:"+field);
System.out.println("Code:"+daf.getCode());
System.out.println("Name:"+daf.getName());
System.out.println("DP:"+daf.getNumberOfDecimalPlaces());
System.out.println("PK:"+daf.getIsPrimaryKey());
System.out.println("NN:"+daf.getIsNotNull());
System.out.println("A+:"+daf.getIsAutoIncrement());
System.out.println("UNQ:"+daf.getIsUnique());
System.out.println("UNQ:"+daf.getDefaultValue());
System.out.println("UNQ:"+daf.getCheckConstraint());
System.out.println("UNQ:"+daf.getNote());
System.out.println("UNQ:"+project.getDatabaseArchitecture().getDataType());
field.setCode(daf.getCode());
field.setName(daf.getName());
field.setWidth(daf.getWidth());
field.setNumberOfDecimalPlaces(daf.getNumberOfDecimalPlaces());
field.setIsPrimaryKey(daf.getIsPrimaryKey());
field.setIsAutoIncrement(daf.getIsAutoIncrement());
field.setIsUnique(daf.getIsUnique());
field.setIsNotNull(daf.getIsNotNull());
field.setDefaultValue(daf.getDefaultValue());
field.setCheckConstraint(daf.getCheckConstraint());
field.setNote(daf.getNote());
System.out.println("niche tk aaya");
System.out.println("-------------------------------------------------------------------------");


int architectureDataTypeCode=daf.getDatabaseArchitectureDataTypeCode();
com.thinking.machines.dModel.services.pojo.DataType pojoDataType=null;
for(com.thinking.machines.dModel.services.pojo.DataType dat:project.getDatabaseArchitecture().getDataType())
{
System.out.println(dat.getCode()+","+architectureDataTypeCode);
if(dat.getCode()==architectureDataTypeCode)
{
System.out.println("if me gyaaaaaaaaaaaaa======="+dat.getCode()+","+architectureDataTypeCode);
pojoDataType=dat;
break;
}
if(dat.getCode()==architectureDataTypeCode)
{
System.out.println("if me gyaaaaaaaaaaaaa equals"+dat.getCode()+","+architectureDataTypeCode);
pojoDataType=dat;
break;
}
}

field.setDataTypes(pojoDataType);

System.out.println("-------------------------------------------------------------------------");
//System.out.println("Fields:"+fields);
fields.add(field);
System.out.println("DatabaseTableFields ka for loop in memberLogin Fields Added");
}//Fields ka loop khtam

dataTable.setFields(fields);
System.out.println("Fields:"+fields);

databaseTables.add(dataTable);
System.out.println("DatabaseTables"+databaseTables);
}//database tables ka for loop khatam
project.setTables(databaseTables);
}//if khatam
System.out.println("if khatam hua:"+projects+" , "+project);
projects.add(project);
System.out.println("project add  hua");
}//projects ka loop khatam
}//project ki if condition
dataManager.end();
System.out.println("Last ke sOP");
this.session.setAttribute("projects",projects);
this.session.setAttribute("username",a.getFirstName());
this.session.setAttribute("member",a);
//this.session.setAttribute("fields",fields);
request.setAttribute("emailId",emailId);
return new TMForward("/homepage.jsp");
}
}
errorBean.addError("Username or Password incorrect!");
return new TMForward("/memberLogin1.jsp");
}catch(Exception e)
{
System.out.println("Exception :"+e.getMessage());
return new TMForward("/memberLogin1.jsp");
}
}
}