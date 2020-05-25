package com.thinking.machines.dModel;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.dmframework.annotations.*;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.dmframework.*;
import com.thinking.machines.dmframework.exceptions.*;
import java.util.*;
import com.thinking.machines.dModel.services.pojo.*;
public class startup
{
private ServletContext servletContext;
public void setServletContext(ServletContext servletContext)
{
this.servletContext=servletContext;
System.out.println("Application Object is being Injected "+this.servletContext);
}
@OnStart(1)
@InjectApplication
public void initializer()
{
try
{
System.out.println("*****************initializer invoked Loop Starts****************");
System.out.println("*****************initializer invoked ****************");
System.out.println("*****************initializer invoked ****************");
System.out.println("*****************initializer invoked ****************");
System.out.println("*****************initializer invoked ****************");
//Pojo class lists
LinkedList<DatabaseArchitecture> databaseArchitectures=new LinkedList<>();
LinkedList<DataType> dataTypes=null;
LinkedList<DatabaseEngine> engines=new LinkedList<>();
DatabaseArchitecture databaseArchitecture=null;
DataType dataType=null; 
DatabaseEngine databaseEngine=null;


//dl classes lists
List<com.thinking.machines.dModel.dl.DatabaseArchitecture> dlDatabaseArchitectures=new LinkedList<>();
List<com.thinking.machines.dModel.dl.DatabaseArchitectureDataType> dlDatabaseArchitectureDataTypes=new LinkedList<>();
List<com.thinking.machines.dModel.dl.DatabaseEngine> dlDatabaseEngines=new LinkedList<>();
DataManager dataManager=new DataManager();
dataManager.begin();
dlDatabaseArchitectures=dataManager.select(com.thinking.machines.dModel.dl.DatabaseArchitecture.class).query();
dlDatabaseArchitectureDataTypes=dataManager.select(com.thinking.machines.dModel.dl.DatabaseArchitectureDataType.class).query();
dlDatabaseEngines=dataManager.select(com.thinking.machines.dModel.dl.DatabaseEngine.class).query();
dataManager.end();
//Data base se sab kuchh nikal liya!

for(com.thinking.machines.dModel.dl.DatabaseEngine dlDE:dlDatabaseEngines)
{
databaseEngine=new DatabaseEngine();
databaseEngine.setCode(dlDE.getCode());
databaseEngine.setName(dlDE.getName());
engines.add(databaseEngine);
System.out.println("Datbase Engine Code:"+databaseEngine.getCode());
System.out.println("Name:"+databaseEngine.getName());
} 



for(com.thinking.machines.dModel.dl.DatabaseArchitecture dlDA :dlDatabaseArchitectures)
{
dataTypes=new LinkedList<DataType>();
databaseArchitecture=new DatabaseArchitecture();
databaseArchitecture.setCode(dlDA.getCode());
databaseArchitecture.setName(dlDA.getName());
databaseArchitecture.setMaxWidthOfColumnName(dlDA.getMaxWidthOfColumnName());
databaseArchitecture.setMaxWidthOfTableName(dlDA.getMaxWidthOfTableName());
databaseArchitecture.setMaxWidthOfRelationshipName(dlDA.getMaxWidthOfRelationshipName());


//database Engine is Being Set
//Engines list needs to be change


//databaseArchitecture methods is being set
for(com.thinking.machines.dModel.dl.DatabaseArchitectureDataType dlDT:dlDatabaseArchitectureDataTypes)
{

System.out.println("datatype set hue");
dataType=new DataType();
dataType.setCode(dlDT.getCode());
dataType.setDataType(dlDT.getDataType());
dataType.setMaxWidth(dlDT.getMaxWidth());
dataType.setDefaultSize(dlDT.getDefaultSize());
dataType.setMaxWidthOfPrecision(dlDT.getMaxWidthOfPrecision());
dataType.setAllowAutoIncrement(dlDT.getAllowAutoIncrement());
dataTypes.add(dataType);
System.out.println("Code:"+dataType.getCode());
System.out.println("DataType:"+dataType.getDataType());
System.out.println("Max:"+dataType.getMaxWidth());
System.out.println("Size:"+dataType.getDefaultSize());
System.out.println("Precision:"+dataType.getMaxWidthOfPrecision());
System.out.println("Auto:"+dataType.getAllowAutoIncrement());
}
System.out.println("DAta Type ki  size:"+dataTypes.size());
databaseArchitecture.setDataType(dataTypes);
databaseArchitecture.setDatabaseEngine(engines);
System.out.println("DA:"+databaseArchitecture.getDatabaseEngine());
databaseArchitectures.add(databaseArchitecture);
}
this.servletContext.setAttribute("databaseEngines",engines);
this.servletContext.setAttribute("databaseArchitectures",databaseArchitectures);
System.out.println("*****************initializer invoked ****************");
System.out.println("*****************Loop Ends initializer invoked ****************");
}catch(Exception exception)
{
System.out.println("*****************Exception in startup****************");
System.out.println("*****************Exception in startup ****************");
System.out.println(exception.getMessage());
}
}
}