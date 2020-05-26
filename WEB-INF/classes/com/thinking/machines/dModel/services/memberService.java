package com.thinking.machines.dModel.services;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.tmws.*;
import com.thinking.machines.dmframework.exceptions.*;
import javax.servlet.*;
import javax.servlet.http.*;
@Path("/memberService")
public class memberService
{
private HttpSession session;
public void setHttpSession(HttpSession session)
{
System.out.println("Session is being Injected");
this.session=session;
}
@InjectSession
@InjectRequest
@Get
@Path("logout")
public TMForward logout()
{
try
{
System.out.println("Logout chala");
this.session.removeAttribute("member");
this.session.removeAttribute("username");
return new TMForward("/memberLogin.jsp");
}catch(Exception e)
{
System.out.println("Exception :"+e.getMessage());
return new TMForward("/memberLogin.jsp");
}
}
}