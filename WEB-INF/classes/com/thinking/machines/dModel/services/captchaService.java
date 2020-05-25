package com.thinking.machines.dModel.services;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.dmframework.*;
import com.thinking.machines.dmframework.exceptions.*;
import com.thinking.machines.tmws.captcha.*;
import com.thinking.machines.tmws.*;
import javax.servlet.*;
import javax.servlet.http.*;
@Path("/captchaService")
public class captchaService 
{
private HttpSession session;
public void setHttpSession(HttpSession session)
{
System.out.println("Session is being Injected");
this.session=session;
}
@InjectSession
@Post
@Path("validateCaptcha")
public Object captchaValidation(String captchaCode)
{
Captcha captcha=(Captcha)this.session.getAttribute(Captcha.CAPTCHA_NAME);
this.session.removeAttribute(Captcha.CAPTCHA_NAME);
if(captcha.isValid(captchaCode)) return true;
else return false;
}
}