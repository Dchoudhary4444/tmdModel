package com.thinking.machines.dModel.services.pojo;
import java.util.*;
public class DatabaseArchitecture implements java.io.Serializable
{
private Integer code;
private String name;
private Integer maxWidthOfColumnName;
private Integer maxWidthOfTableName;
private Integer maxWidthOfRelationshipName;
private List<DataType> dataTypes;
private List<DatabaseEngine> engines;
public DatabaseArchitecture()
{
this.code=null;
this.name=null;
this.maxWidthOfColumnName=null;
this.maxWidthOfTableName=null;
this.maxWidthOfRelationshipName=null;
this.dataTypes=null;
this.engines=null;
}

public void setDatabaseEngine(List<DatabaseEngine> engines)
{
this.engines=engines;
}
public List<DatabaseEngine> getDatabaseEngine()
{
return this.engines;
}

public void setDataType(List<DataType> dataTypes)
{
this.dataTypes=dataTypes;
}
public List<DataType> getDataType()
{
return this.dataTypes;
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
public void setMaxWidthOfColumnName(Integer maxWidthOfColumnName)
{
this.maxWidthOfColumnName=maxWidthOfColumnName;
}
public Integer getMaxWidthOfColumnName()
{
return this.maxWidthOfColumnName;
}
public void setMaxWidthOfTableName(Integer maxWidthOfTableName)
{
this.maxWidthOfTableName=maxWidthOfTableName;
}
public Integer getMaxWidthOfTableName()
{
return this.maxWidthOfTableName;
}
public void setMaxWidthOfRelationshipName(Integer maxWidthOfRelationshipName)
{
this.maxWidthOfRelationshipName=maxWidthOfRelationshipName;
}
public Integer getMaxWidthOfRelationshipName()
{
return this.maxWidthOfRelationshipName;
}
}