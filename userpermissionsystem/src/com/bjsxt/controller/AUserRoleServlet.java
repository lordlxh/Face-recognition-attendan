package com.bjsxt.controller;
import java.io.IOException;         
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.UserRole;
import com.bjsxt.service.UserRoleService;
import com.bjsxt.service.impl.UserRoleServiceImpl;

@WebServlet("/servlet/AUserRoleServlet")

public class AUserRoleServlet extends HttpServlet{
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		   String method = req.getParameter("method");
		   
           if("Insert".equals(method))
           {UserRoleInsert(req,resp);}
           if("FindAll".equals(method))
           {UserRoleFindAll(req,resp);}
           if("Remove".equals(method))
           {UserRoleRemove(req,resp);}
           if("FindOne".equals(method))
           {UserRoleFindOne(req,resp);}
           if("Change".equals(method))
           {UserRoleChange(req,resp);}
           if("FindLike".equals(method))
           {UserRoleFindLike(req,resp);}
		   
		   
	}
	 //用户角色
		protected void UserRoleInsert(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			String URid=req.getParameter("URid");
			String Uid=req.getParameter("Uid");
			String Rid=req.getParameter("Rid");
		    
		   UserRole  userrole=new UserRole(URid,Uid,Rid);
		    
		    UserRoleService  admins=new  UserRoleServiceImpl();
		    
		    int update = admins.UserRoleRegister(userrole);
		    
		    if(update>0){
		    	req.setAttribute("msg", "添加成功！");
		    	 req.getRequestDispatcher("/files/UserRoleRegister.jsp").forward(req, resp);
		    	  /* resp.getWriter().print("<");*/
		    	}else {
		    	  req.setAttribute("msg", "创建失败");
		    	  req.getRequestDispatcher("/files/UserRoleRegister.jsp").forward(req, resp);
		      }

		 
	}
		 protected void UserRoleFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			 req.setCharacterEncoding("utf-8");
			 UserRoleService  admins=new  UserRoleServiceImpl();
			 List<UserRole> list= admins.UserRoleFindAll();
			 req.setAttribute("list", list);
			 req.getRequestDispatcher("/files/UserRoleList.jsp").forward(req, resp);
			 
			 
		 }
	
	 protected void UserRoleRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			      String  URid=req.getParameter("URid");
	
			      UserRoleService  admins=new  UserRoleServiceImpl();
			      
			      int update = admins.UserRoleRemove(URid);

			      resp.sendRedirect(req.getContextPath()+"/servlet/AUserRoleServlet?method=FindAll");
			}
	 protected void UserRoleFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			    String  URid=req.getParameter("URid");
			    
			    UserRoleService  admins=new  UserRoleServiceImpl();
			    UserRole userrole = admins.UserRoleFindOne(URid);

			    if(userrole!=null){
			    	
			    	req.setAttribute("userrole", userrole);
			    	req.getRequestDispatcher("/files/UserRoleUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	 protected void UserRoleChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			     String URid=req.getParameter("URid");
			     String Uid=req.getParameter("Uid");
			     String Rid=req.getParameter("Rid");

			     UserRole  userrole=new UserRole(URid,Uid,Rid);

			     UserRoleService  admins=new  UserRoleServiceImpl();
			     
			     int update = admins.UserRoleChange(userrole);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/AUserRoleServlet?method=FindAll");
			     }
			}
	 protected void UserRoleFindLike(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			 String  URid =req.getParameter("URid");
 
			 UserRoleService  users=new  UserRoleServiceImpl();
 
			 List<UserRole> list = users.UserRoleFindLike(URid);

			 req.setAttribute("URid", URid);
			 req.setAttribute("list", list); 
			 req.getRequestDispatcher("/files/UserRoleList.jsp").forward(req, resp);
			
			
			
		}
}
