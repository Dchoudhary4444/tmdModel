package com.thinking.machines.dModel.services.pojo;
import java.util.*;
public class ClientProject implements java.io.Serializable
{
List<ClientDatabaseTable> tables;
public ClientProject()
{
this.tables=null;
}
public void setTables(List<ClientDatabaseTable> tables)
{
this.tables=tables;
}
public List<ClientDatabaseTable> getTables()
{
return this.tables;
}
}