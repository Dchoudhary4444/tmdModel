package com.thinking.machines.dModel.services.pojo;
import java.util.*;
public class DatabaseTable implements java.io.Serializable
{
private Integer code;
private String name;
private DatabaseEngine databaseEngine;
private String note;
private List<Field> fields;
private int xLocation;
private int yLocation;
public DatabaseTable()
{
this.code=null;
this.name=null;
this.databaseEngine=null;
this.note=null;
this.fields=null;
this.xLocation=0;
this.yLocation=0;
}
public void setCode(Integer code)
{
this.code=code;
}
public Integer getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setDatabaseEngine(DatabaseEngine databaseEngine)
{
this.databaseEngine=databaseEngine;
}
public DatabaseEngine getDatabaseEngine()
{
return this.databaseEngine;
}
public void setNote(String note)
{
this.note=note;
}
public String getNote()
{
return this.note;
}
public void setFields(List<Field> fields)
{
this.fields=fields;
}
public List<Field> getFields()
{
return this.fields;
}
public void setxLocation(Integer xLocation)
{
this.xLocation=xLocation;
}
public Integer getxLocation()
{
return this.xLocation;
}
public void setyLocation(Integer yLocation)
{
this.yLocation=yLocation;
}
public Integer getyLocation()
{
return this.yLocation;
}





}
