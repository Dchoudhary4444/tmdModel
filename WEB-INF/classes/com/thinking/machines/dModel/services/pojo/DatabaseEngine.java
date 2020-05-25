package com.thinking.machines.dModel.services.pojo;
public class DatabaseEngine implements java.io.Serializable
{
private Integer code;
private String name;
public DatabaseEngine()
{
this.code=null;
this.name=null;
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
}
