package com.thinking.machines.dModel.tags;
import javax.servlet.jsp.*;
import java.util.*;
import javax.servlet.jsp.tagext.*;
import com.thinking.machines.dModel.beans.*;
public class ErrorTagHandlerTEI extends TagExtraInfo
{
public VariableInfo[] getVariableInfo(TagData data)
{
VariableInfo v[]=new VariableInfo[1];
v[0]=new VariableInfo("error","java.lang.String",true,VariableInfo.NESTED);
return v;
}
}