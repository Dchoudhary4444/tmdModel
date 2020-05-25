package com.thinking.machines.dModel.services.pojo;
public class DataType implements java.io.Serializable,Comparable<DataType>
{
private Integer code;
private  String dataType;
private Integer maxWidth;
private Integer defaultSize;
private Integer maxWidthOfPrecision;
private Boolean allowAutoIncrement;
public DataType()
{
this.code=null;
this.dataType=null;
this.maxWidth=null;
this.defaultSize=null;
this.maxWidthOfPrecision=null;
this.allowAutoIncrement=null;
}
public void setCode(Integer code)
{
this.code=code;
}
public Integer getCode()
{
return this.code;
}
public void setDataType(String dataType)
{
this.dataType=dataType;
}
public String getDataType()
{
return this.dataType;
}
public void setMaxWidth(Integer maxWidth)
{
this.maxWidth=maxWidth;
}
public Integer getMaxWidth()
{
return this.maxWidth;
}
public void setDefaultSize(Integer defaultSize)
{
this.defaultSize=defaultSize;
}
public Integer getDefaultSize()
{
return this.defaultSize;
}
public void setMaxWidthOfPrecision(Integer maxWidthOfPrecision)
{
this.maxWidthOfPrecision=maxWidthOfPrecision;
}
public Integer getMaxWidthOfPrecision()
{
return this.maxWidthOfPrecision;
}
public void setAllowAutoIncrement(Boolean allowAutoIncrement)
{
this.allowAutoIncrement=allowAutoIncrement;
}
public Boolean getAllowAutoIncrement()
{
return this.allowAutoIncrement;
}


public boolean equals(Object object)
{
if(object==null) return false;
if(!(object instanceof DataType)) return false;
DataType anotherDataType=(DataType)object;
if(this.code==null && anotherDataType.code==null) return true;
if(this.code==null || anotherDataType.code==null) return false;
return this.code.equals(anotherDataType.code);
}
public int compareTo(DataType anotherDataType)
{
if(anotherDataType==null) return 1;
if(this.code==null && anotherDataType.code==null) return 0;
int difference;
if(this.code==null && anotherDataType.code!=null) return 1;
if(this.code!=null && anotherDataType.code==null) return -1;
difference=this.code.compareTo(anotherDataType.code);
return difference;
}
public int hashCode()
{
if(this.code==null) return 0;
return this.code.hashCode();
}


}
