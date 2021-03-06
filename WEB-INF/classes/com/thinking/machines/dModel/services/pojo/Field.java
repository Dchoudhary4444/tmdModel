package com.thinking.machines.dModel.services.pojo;
import java.util.*;
public class Field implements java.io.Serializable
{
private Integer code;
private String name;
private DataType dataTypes;
private Integer width;
private Integer numberOfDecimalPlaces;
private Boolean isPrimaryKey;
private Boolean isAutoIncrement;
private Boolean isUnique;
private Boolean isNotNull;
private String defaultValue;
private String checkConstraint;
private String note;
public Field()
{
this.code=null;
this.name=null;
this.dataTypes=null;
this.width=null;
this.numberOfDecimalPlaces=null;
this.isPrimaryKey=null;
this.isAutoIncrement=null;
this.isUnique=null;
this.isNotNull=null;
this.defaultValue=null;
this.checkConstraint=null;
this.note=null;
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
public void setDataTypes(DataType dataTypes)
{
this.dataTypes=dataTypes;
}
public DataType getDataTypes()
{
return this.dataTypes;
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
public void setCheckConstraint(String checkConstraint)
{
this.checkConstraint=checkConstraint;
}
public String getCheckConstraint()
{
return this.checkConstraint;
}
public void setNote(String note)
{
this.note=note;
}
public String getNote()
{
return this.note;
}
}