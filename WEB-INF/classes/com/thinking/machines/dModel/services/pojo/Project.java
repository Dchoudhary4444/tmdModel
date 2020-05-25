package com.thinking.machines.dModel.services.pojo;
import java.util.List;
import java.sql.*;
public class Project implements java.io.Serializable
{
private Integer code;
private String title;
private DatabaseArchitecture databaseArchitecture;
private Date dateOfCreation;
private Time timeOfCreation;
private List<DatabaseTable> tables;
public Project()
{
this.code=null;
this.title=null;
this.databaseArchitecture=null;
this.dateOfCreation=null;
this.timeOfCreation=null;
this.tables=null;
}
public void setCode(Integer code)
{
this.code=code;
}
public Integer getCode()
{
return this.code;
}
public void setTitle(String title)
{
this.title=title;
}
public String getTitle()
{
return this.title;
}
public void setDatabaseArchitecture(DatabaseArchitecture databaseArchitecture)
{
this.databaseArchitecture=databaseArchitecture;
}
public DatabaseArchitecture getDatabaseArchitecture()
{
return this.databaseArchitecture;
}
public void setDateOfCreation(Date dateOfCreation)
{
this.dateOfCreation=dateOfCreation;
}
public Date getDateOfCreation()
{
return this.dateOfCreation;
}
public void setTimeOfCreation(Time timeOfCreation)
{
this.timeOfCreation=timeOfCreation;
}
public Time getTimeOfCreation()
{
return this.timeOfCreation;
}
public void setTables(List<DatabaseTable> tables)
{
this.tables=tables;
}
public List<DatabaseTable> getTables()
{
return this.tables;
}
}
