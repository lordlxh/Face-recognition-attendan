package com.bjsxt.controller;
import java.io.IOException;      
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;

@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
	   protected void service(HttpServletRequest req,HttpServletResponse resp) 
       throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
     	 
     	  String Uid=req.getParameter("uid");
     	  String pwd=req.getParameter("pwd");
     	  
     	  UserService users=new UserServiceImpl();
     	  User user=users.UserLogin(Uid, pwd);
          String uname=user.getUname();
     	  String checkpermission=new String();
     	  checkpermission=users.Permissioncheck(Uid);
           if(user!=null)
           {  
         	  HttpSession session =req.getSession();
         	  session.setAttribute("uname",uname);
         	  session.setAttribute("userid", Uid);
         	  session.setAttribute("role",checkpermission); 
         	  resp.sendRedirect(req.getContextPath()+"/index.html");
           }else {
         	  
         	  req.setAttribute("msg","密码不匹配");
         	  req.getRequestDispatcher("/login.jsp").forward(req, resp);;
           }
         	  
       }

}
