package com.bjsxt.controller;
import java.io.IOException;        
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.Role;
import com.bjsxt.service.AdminService;
import com.bjsxt.service.RoleService;
import com.bjsxt.service.impl.AdminServiceImpl;
import com.bjsxt.service.impl.RoleServiceImpl;

@WebServlet("/servlet/ARoleServlet")

public class ARoleServlet extends HttpServlet{
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		   String method = req.getParameter("method");
		   
           if("Insert".equals(method))
           {RoleInsert(req,resp);}
           if("FindAll".equals(method))
           {RoleFindAll(req,resp);}
           if("Remove".equals(method))
           {RoleRemove(req,resp);}
           if("FindOne".equals(method))
           {RoleFindOne(req,resp);}
           if("Change".equals(method))
           {RoleChange(req,resp);}
           if("FindLike".equals(method))
           {RoleFindLike(req,resp);}
		   
		   
	}
	 //角色
		protected void RoleInsert(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			String Rid=req.getParameter("Rid");
		    
		    String Rname=req.getParameter("Rname");
		    
		   Role  role=new Role(Rid,Rname);
		    
		    RoleService  admins=new  RoleServiceImpl();
		    
		    int update = admins.RoleRegister(role);
		    
		    if(update>0){
		    	req.setAttribute("msg", "添加成功！");
		    	req.getRequestDispatcher("/files/RoleRegister.jsp").forward(req, resp);
		    	  /* resp.getWriter().print("<");*/
		    	}else {
		    	  req.setAttribute("msg", "创建失败");
		    	  req.getRequestDispatcher("/files/RoleRegister.jsp").forward(req, resp);
		      }

		 
	}
		 protected void RoleFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			 req.setCharacterEncoding("utf-8");
			 RoleService  admins=new  RoleServiceImpl();
			 List<Role> list= admins.RoleFindAll();
			 req.setAttribute("list", list);
			 req.getRequestDispatcher("/files/RoleList.jsp").forward(req, resp);
			 
			 
		 }
	
	 protected void RoleRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			      String  Rid=req.getParameter("Rid");
	
			      RoleService  admins=new  RoleServiceImpl();
			      
			      int update = admins.RoleRemove(Rid);

			      resp.sendRedirect(req.getContextPath()+"/servlet/ARoleServlet?method=FindAll");
			}
	 protected void RoleFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			    String  Rid=req.getParameter("Rid");
			    
			    RoleService  admins=new  RoleServiceImpl();
			    Role role = admins.RoleFindOne(Rid);

			    if(role!=null){
			    	
			    	req.setAttribute("role", role);
			    	req.getRequestDispatcher("/files/RoleUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	 protected void RoleChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			     String Rid=req.getParameter("Rid");
			     String Rname=req.getParameter("Rname");


			     Role  role=new Role(Rid,Rname);

			     RoleService  admins=new  RoleServiceImpl();
			     
			     int update = admins.RoleChange(role);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/ARoleServlet?method=FindAll");
			     }
			}
	 protected void RoleFindLike(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			 String  Rname =req.getParameter("Rname");
 
			 RoleService  users=new  RoleServiceImpl();
 
			 List<Role> list = users.RoleFindLike(Rname);

			 req.setAttribute("Rname", Rname);
			 req.setAttribute("list", list); 
			 req.getRequestDispatcher("/files/RoleList.jsp").forward(req, resp);
			
			
			
		}
}
