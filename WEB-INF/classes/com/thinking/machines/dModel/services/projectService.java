package com.thinking.machines.dModel.services;
import com.thinking.machines.dModel.utilities.*;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.tmws.*;
import com.thinking.machines.dmframework.exceptions.*;
import com.thinking.machines.dModel.dl.*;
import com.thinking.machines.dmframework.*;
import com.thinking.machines.dModel.services.pojo.ClientField;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
@Path("/projectService")
public class projectService
{
private HttpSession session;
private HttpServletRequest request;
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
@Path("create")
public TMForward create(String title,String architecture)
{
System.out.println("Create Chala Project Service ka");
try
{
int architectureCode=Integer.parseInt(architecture);
if(architectureCode==-1 || title==null)
{
return new TMForward("/tmdModel/homepage.jsp");
}
System.out.println("create Project Service"+"  Title"+title+" , "+architecture );
Member loggedInMember=(Member)this.session.getAttribute("member");
System.out.println("Member Name :"+loggedInMember.getFirstName());
System.out.println("Number of : "+loggedInMember.getNumberOfProjects());
int nop=loggedInMember.getNumberOfProjects();
Project project=new Project();
com.thinking.machines.dModel.services.pojo.Project pojoProject=new com.thinking.machines.dModel.services.pojo.Project();
System.out.println("NOP"+nop);
long millis=System.currentTimeMillis();  
java.sql.Date date=new java.sql.Date(millis);
project.setDateOfCreation(date);
java.time.LocalTime time = java.time.LocalTime.now();  
project.setTimeOfCreation(java.sql.Time.valueOf(time));
System.out.println(project.getTimeOfCreation());
System.out.println(project.getDateOfCreation());
if(nop==0)
{
project.setTitle(title);
project.setMemberCode(loggedInMember.getCode());
List<com.thinking.machines.dModel.services.pojo.DatabaseArchitecture> dbArchitecture;
DataManager dataManager=new DataManager();
dataManager.begin();

//dbArchitecture=dataManager.select(DatabaseArchitecture.class).query();//this will be taken from Application scope
dbArchitecture=(List<com.thinking.machines.dModel.services.pojo.DatabaseArchitecture>)this.servletContext.getAttribute("databaseArchitectures");
com.thinking.machines.dModel.services.pojo.DatabaseArchitecture databaseArchi=null;
for(com.thinking.machines.dModel.services.pojo.DatabaseArchitecture da:dbArchitecture)
{
System.out.println(da.getCode());
if(da.getCode()==architectureCode)
{
databaseArchi=da;
project.setDatabaseArchitectureCode(da.getCode());
pojoProject.setDatabaseArchitecture(da);
System.out.println(da.getCode());
break;
}//if
}//for
this.request.setAttribute("dataType",databaseArchi.getDataType());

project.setNumberOfTable(0);
this.session.setAttribute("title",project.getTitle());
System.out.println(project.getTitle());
System.out.println(project.getMemberCode());
System.out.println(project.getDatabaseArchitectureCode());
System.out.println(project.getNumberOfTable());
System.out.println("pROJECT wILL BE ADDED");
dataManager.insert(project);
loggedInMember.setNumberOfProjects(nop+1);
System.out.println("Project Added");
dataManager.update(loggedInMember);
List<com.thinking.machines.dModel.services.pojo.Project> projects=(List<com.thinking.machines.dModel.services.pojo.Project>)this.session.getAttribute("projects");
pojoProject.setCode(project.getCode());
pojoProject.setTitle(project.getTitle());
System.out.println("projectTitle:"+pojoProject.getTitle());
pojoProject.setDateOfCreation(project.getDateOfCreation());
pojoProject.setTimeOfCreation(project.getTimeOfCreation());
projects.add(pojoProject);
this.session.setAttribute("projects",projects);
System.out.println("Member Table Updated1");
dataManager.end();
System.out.println("Member Table Updated");
}
else
{
List<com.thinking.machines.dModel.services.pojo.Project> projects=(List<com.thinking.machines.dModel.services.pojo.Project>)this.session.getAttribute("projects");
for(com.thinking.machines.dModel.services.pojo.Project p:projects)
{
if(p.getTitle().equalsIgnoreCase(title))
{
return new TMForward("/homepage.jsp");
}
}

project.setTitle(title);
System.out.println("Elese me gaya:"+project.getTitle());

project.setMemberCode(loggedInMember.getCode());
List<com.thinking.machines.dModel.services.pojo.DatabaseArchitecture> dbArchitecture;
DataManager dataManager=new DataManager();
dataManager.begin();

//dbArchitecture=dataManager.select(DatabaseArchitecture.class).query();//this will be taken from Application scope
dbArchitecture=(List<com.thinking.machines.dModel.services.pojo.DatabaseArchitecture>)this.servletContext.getAttribute("databaseArchitectures");
com.thinking.machines.dModel.services.pojo.DatabaseArchitecture databaseArchi=null;
for(com.thinking.machines.dModel.services.pojo.DatabaseArchitecture da:dbArchitecture)
{
System.out.println(da.getCode());
if(da.getCode()==architectureCode)
{
databaseArchi=da;
project.setDatabaseArchitectureCode(da.getCode());
pojoProject.setDatabaseArchitecture(da);
System.out.println(da.getCode());
break;
}//if
}//for
this.request.setAttribute("dataType",databaseArchi.getDataType());

project.setNumberOfTable(0);
this.session.setAttribute("title",project.getTitle());
System.out.println(project.getTitle());
System.out.println(project.getMemberCode());
System.out.println(project.getDatabaseArchitectureCode());
System.out.println(project.getNumberOfTable());
System.out.println("pROJECT wILL BE ADDED");
dataManager.insert(project);
loggedInMember.setNumberOfProjects(nop+1);
System.out.println("Project Added");
dataManager.update(loggedInMember);
pojoProject.setCode(project.getCode());
pojoProject.setTitle(project.getTitle());
System.out.println("projectTitle:"+pojoProject.getTitle());
pojoProject.setDateOfCreation(project.getDateOfCreation());
pojoProject.setTimeOfCreation(project.getTimeOfCreation());
projects.add(pojoProject);
this.session.setAttribute("projects",projects);
System.out.println("Member Table Updated1");
dataManager.end();
System.out.println("Member Table Updated");


}//else ends
return new TMForward("/testing.jsp");
}catch(ValidatorException ve)
{
System.out.println("Val:"+ve.getMessage());
return new TMForward("/homepage.jsp");
}catch(DMFrameworkException dmFramework)
{
System.out.println(dmFramework);
return new TMForward("/homepage.jsp");
} 
}// create khatam


@InjectRequest
@InjectSession
@Post
@Path("openProject")
 public TMForward openProject()
{
try
{
System.out.println("Open Project chala"+this.request.getParameter("projectName"));
int projectCode=Integer.parseInt(this.request.getParameter("projectName"));
List<com.thinking.machines.dModel.services.pojo.Project> projects=(List<com.thinking.machines.dModel.services.pojo.Project>)this.session.getAttribute("projects");
for(com.thinking.machines.dModel.services.pojo.Project p:projects)
{
if(p.getCode()==projectCode)
{
System.out.println("Same"+p.getCode()+","+projectCode);
this.session.setAttribute("openProjectList",p);
this.session.setAttribute("title",p.getTitle());
}
}
}catch(Exception e)
{
System.out.println(e.getMessage());
}
return new TMForward("/openProject.jsp");
}//open khatam

@InjectSession
@InjectRequest
@Post
@Path("populateDS")
public com.thinking.machines.dModel.services.pojo.Project populateDataStructure()
{
System.out.println("Ajax req is arrived");
com.thinking.machines.dModel.services.pojo.Project p= (com.thinking.machines.dModel.services.pojo.Project)this.session.getAttribute("openProjectList");
System.out.println("Title"+p.getTitle()+","+"Code"+p.getCode());
return p;
}


@InjectSession
@Post
@Path("saveProject")
public TMForward saveProject(com.thinking.machines.dModel.services.pojo.ClientProject clientProject)
{
System.out.println("SaveChala");
System.out.println(clientProject);
List<com.thinking.machines.dModel.services.pojo.ClientDatabaseTable> cc=clientProject.getTables();
List<com.thinking.machines.dModel.services.pojo.DatabaseTable> pojoDatabaseTables=new LinkedList<>();
List<com.thinking.machines.dModel.services.pojo.ClientField> pojoDatabaseTableFields=new LinkedList<>();

System.out.println("***********************************************************");
String projectTitle="";
int architectureCode=0;
int projectCode=0;
try
{
projectTitle=(String)this.session.getAttribute("title");
System.out.println(projectTitle);
}catch(Exception e)
{
System.out.println(e.getMessage());
}
List<com.thinking.machines.dModel.services.pojo.Project> projects=(List<com.thinking.machines.dModel.services.pojo.Project>)this.session.getAttribute("projects");
List<com.thinking.machines.dModel.services.pojo.DataType> pojoDAList=null;
System.out.println("Length of Projects:"+projects.size());
com.thinking.machines.dModel.services.pojo.Project pojoProject=null;
for(com.thinking.machines.dModel.services.pojo.Project project:projects)
{
System.out.println("Project ke for me gaya"+","+project.getTitle()+","+projectTitle);
if(project.getTitle().equals(projectTitle))
{
System.out.println("Project Code MAtched");
projectCode=project.getCode();
architectureCode=project.getDatabaseArchitecture().getCode();
pojoDAList=project.getDatabaseArchitecture().getDataType();
System.out.println("DA:"+project.getDatabaseArchitecture().getCode()+","+"PC:"+project.getCode());
pojoProject=project;
System.out.println("prjoject ki list ki size"+projects.size());
projects.remove(project);
System.out.println(" delete ke bad prjoject ki list ki size"+projects.size());

}//if ends 
}//for projects ends

int tableCode=0;
int databaseArchitectureDataTypeCode=0;
System.out.println(" project code : "+projectCode);
List<com.thinking.machines.dModel.dl.DatabaseTable> dlDatabaseTableList= new LinkedList<com.thinking.machines.dModel.dl.DatabaseTable>();
List<com.thinking.machines.dModel.dl.DatabaseArchitectureDataType> dlDatabaseArchitectureDataTypeList= new LinkedList<com.thinking.machines.dModel.dl.DatabaseArchitectureDataType>();
com.thinking.machines.dModel.dl.DatabaseTable dlDatabaseTable=null;
com.thinking.machines.dModel.dl.DatabaseTableField dlDatabaseTableField=null;

com.thinking.machines.dModel.services.pojo.DatabaseTable pojoDatabaseTable=null;
com.thinking.machines.dModel.services.pojo.ClientField pojoDatabaseTableField=null;

try
{
DataManager dataManager=new DataManager();
dataManager.begin();
for(com.thinking.machines.dModel.services.pojo.ClientDatabaseTable c:cc)
{
dlDatabaseTable=new com.thinking.machines.dModel.dl.DatabaseTable();
pojoDatabaseTable=new com.thinking.machines.dModel.services.pojo.DatabaseTable();
String name=c.getName(); // table ka name
String note=c.getNote(); //table ka note
int numberOfFields=c.getNumberOfFields();
int xLocation=c.getXLocation();
int yLocation=c.getYLocation();
System.out.println("Name :"+name+", "+"Note : "+note+ ", "+"Number of Fields : "+numberOfFields+", "+xLocation+" , "+yLocation);
dlDatabaseTable.setProjectCode(projectCode);
dlDatabaseTable.setName(name);
dlDatabaseTable.setDatabaseEngineCode(1);
dlDatabaseTable.setNote(note);
dlDatabaseTable.setNumberOfFields(numberOfFields);
dlDatabaseTable.setXLocation(xLocation);
dlDatabaseTable.setYLocation(yLocation);

//Intializing Method of Database Table in pojo 
pojoDatabaseTable.setName(name);
//pojoDatabaseTable.setDatabaseEngineCode(1);
pojoDatabaseTable.setNote(note);
//pojoDatabaseTable.setNumberOfFields(numberOfFields);
pojoDatabaseTable.setxLocation(xLocation);
pojoDatabaseTable.setyLocation(yLocation);







System.out.println("DatabaseTable Insert hone wala hai");
dataManager.insert(dlDatabaseTable);

System.out.println("DatabaseTable Insert Ho gya");
List<ClientField> fields=c.getFields();
//dlDatabaseTableList=dataManager.select(com.thinking.machines.dModel.dl.DatabaseTable.class).query();
dlDatabaseTableList=dataManager.select(com.thinking.machines.dModel.dl.DatabaseTable.class).where("name").eq(name).query();

for(com.thinking.machines.dModel.dl.DatabaseTable d:dlDatabaseTableList)
{
tableCode=d.getCode();
}
for(ClientField cf:fields)
{
//dlDatabaseArchitectureDataTypeList=dataManager.select(com.thinking.machines.dModel.dl.DatabaseArchitectureDataType.class).where("databaseArchitectureCode").eq(architectureCode).query();
System.out.println("length of cf:"+fields.size());
System.out.println("length of cf:"+cf.getName()+","+cf.getDataType());
int dataType=0;
for(com.thinking.machines.dModel.services.pojo.DataType d:pojoDAList)
{
System.out.println("For me gaya"+"Name:"+cf.getDataType()+","+"DataType:"+d.getCode());
if(cf.getDataType().equals(d.getCode())) 
{
System.out.println("If me gaya");
databaseArchitectureDataTypeCode=d.getCode();
dataType=d.getCode();
}
}
dlDatabaseTableField=new com.thinking.machines.dModel.dl.DatabaseTableField();
pojoDatabaseTableField=new com.thinking.machines.dModel.services.pojo.ClientField();

dlDatabaseTableField.setTableCode(tableCode);
dlDatabaseTableField.setName(cf.getName());
dlDatabaseTableField.setDatabaseArchitectureDataTypeCode(databaseArchitectureDataTypeCode);
dlDatabaseTableField.setWidth(11);
dlDatabaseTableField.setNumberOfDecimalPlaces(10);
dlDatabaseTableField.setIsPrimaryKey(cf.getIsPrimaryKey());
dlDatabaseTableField.setIsAutoIncrement(cf.getIsAutoIncrement());
dlDatabaseTableField.setIsUnique(cf.getIsUnique());
dlDatabaseTableField.setIsNotNull(cf.getIsNotNull());
dlDatabaseTableField.setDefaultValue("Not Null");
dlDatabaseTableField.setNote(cf.getNote());
dlDatabaseTableField.setCheckConstraint("First Letter Must Be A ");
System.out.println("DatabaseTableField Insert hone wala hai");
System.out.println(tableCode+","+cf.getName()+","+databaseArchitectureDataTypeCode+","+","+cf.getIsPrimaryKey()+","+cf.getIsUnique()+","+cf.getIsNotNull()+","+cf.getIsAutoIncrement()+","+","+cf.getNote());
dataManager.insert(dlDatabaseTableField);
System.out.println("DatabaseTableField Added");

//Initializing pojoDatabaseField in pojo
pojoDatabaseTableField.setName(cf.getName());
//pojoDatabaseTableField.setDatabaseArchitectureDataTypeCode(databaseArchitectureDataTypeCode);
pojoDatabaseTableField.setWidth(11);
pojoDatabaseTableField.setDataType(dataType);
pojoDatabaseTableField.setNumberOfDecimalPlaces(10);
pojoDatabaseTableField.setIsPrimaryKey(cf.getIsPrimaryKey());
pojoDatabaseTableField.setIsAutoIncrement(cf.getIsAutoIncrement());
pojoDatabaseTableField.setIsUnique(cf.getIsUnique());
pojoDatabaseTableField.setIsNotNull(cf.getIsNotNull());
pojoDatabaseTableField.setDefaultValue("Not Null");
pojoDatabaseTableField.setNote(cf.getNote());
pojoDatabaseTableField.setCheckConstraint("First Letter Must Be A ");

pojoDatabaseTableFields.add(pojoDatabaseTableField);
}//fields wala for
pojoDatabaseTable.setFields(pojoDatabaseTableFields);
pojoDatabaseTables.add(pojoDatabaseTable);
}//for bada wala
pojoProject.setTables(pojoDatabaseTables);
projects.add(pojoProject);
this.session.setAttribute("projects",projects);
dataManager.end();
System.out.println("************Chal Gya *****************");
}catch(Exception validatorException)
{
System.out.println(validatorException.getMessage());
}
return new TMForward("/homepage.jsp");
}//save khatam

}//class khatam 