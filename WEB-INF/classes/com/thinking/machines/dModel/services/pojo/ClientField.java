package com.thinking.machines.dModel.services.pojo;
import java.util.*;
public class ClientField implements java.io.Serializable
{
private String name;
private Integer width;
private Boolean isPrimaryKey;
private Integer dataType;
private Boolean isAutoIncrement;
private Boolean isUnique;
private Boolean isNotNull;
private String defaultValue;
private String note;
private String checkConstraint;
private Integer numberOfDecimalPlaces;
public ClientField()
{
this.name=null;
this.dataType=0;
this.width=null;
this.numberOfDecimalPlaces=null;
this.isPrimaryKey=null;
this.isAutoIncrement=null;
this.isUnique=null;
this.isNotNull=null;
this.defaultValue=null;
this.note=null;
this.checkConstraint=null;
}

public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setDataType(Integer dataType)
{
this.dataType=dataType;
}
public Integer getDataType()
{
return this.dataType;
}
public void setWidth(Integer width)
{
this.width=width;
}
public Integer getWidth()
{
return this.width;
}
public void setNumberOfDecimalPlaces(Integer numberOfDecimalPlaces)
{
this.numberOfDecimalPlaces=numberOfDecimalPlaces;
}
public Integer getNumberOfDecimalPlaces()
{
return this.numberOfDecimalPlaces;
}
public void setIsPrimaryKey(Boolean isPrimaryKey)
{
this.isPrimaryKey=isPrimaryKey;
}
public Boolean getIsPrimaryKey()
{
return this.isPrimaryKey;
}
public void setIsAutoIncrement(Boolean isAutoIncrement)
{
this.isAutoIncrement=isAutoIncrement;
}
public Boolean getIsAutoIncrement()
{
return this.isAutoIncrement;
}
public void setIsUnique(Boolean isUnique)
{
this.isUnique=isUnique;
}
public Boolean getIsUnique()
{
return this.isUnique;
}
public void setIsNotNull(Boolean isNotNull)
{
this.isNotNull=isNotNull;
}
public Boolean getIsNotNull()
{
return this.isNotNull;
}
public void setDefaultValue(String defaultValue)
{
this.defaultValue=defaultValue;
}
public String getDefaultValue()
{
return this.defaultValue;
}
public void setNote(String note)
{
this.note=note;
}
public String getNote()
{
return this.note;
}
public void setCheckConstraint(String checkConstraint)
{
this.checkConstraint=checkConstraint;
}
public String getCheckConstraint()
{
return this.checkConstraint;
}
}