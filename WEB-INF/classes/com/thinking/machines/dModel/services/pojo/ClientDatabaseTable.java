package com.thinking.machines.dModel.services.pojo;
import java.util.*;
public class ClientDatabaseTable implements java.io.Serializable
{
List<ClientField> fields;
String name;
String note;
int numberOfFields;
int xLocation;
int yLocation;
String engine;
public ClientDatabaseTable()
{
this.name=null;
this.note=null;
this.numberOfFields=0;
this.xLocation=0;
this.yLocation=0;
this.engine=null;
this.fields=null;
}
public void setName(String name)
{
this.name=name;
}
public void setNote(String note)
{
this.note=note;
}
public void setEngine(String engine)
{
this.engine=engine;
}
public void setFields(List<ClientField> fields)
{
this.fields=fields;
}
public void setXLocation(int x)
{
this.xLocation=x;
}
public void setYLocation(int y)
{
this.yLocation=y;
}
public void setNumberOfFields(int nof)
{
this.numberOfFields=nof;
}
public String getName()
{
return this.name;
}
public String getNote()
{
return this.note;
}
public String getEngine()
{
return this.engine;
}
public List<ClientField> getFields()
{
return this.fields;
}
public int getXLocation()
{
return this.xLocation;
}
public int getYLocation()
{
return this.yLocation;
}
public int getNumberOfFields()
{
return this.numberOfFields;
}
}
