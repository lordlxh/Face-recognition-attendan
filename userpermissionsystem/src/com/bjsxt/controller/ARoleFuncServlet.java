package com.bjsxt.controller;
import java.io.IOException;          
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.RoleFunc;
import com.bjsxt.service.RoleFuncService;
import com.bjsxt.service.impl.RoleFuncServiceImpl;

@WebServlet("/servlet/ARoleFuncServlet")

public class ARoleFuncServlet extends HttpServlet{
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		   String method = req.getParameter("method");
		   
           if("Insert".equals(method))
           {RoleFuncInsert(req,resp);}
           if("FindAll".equals(method))
           {RoleFuncFindAll(req,resp);}
           if("Remove".equals(method))
           {RoleFuncRemove(req,resp);}
           if("FindOne".equals(method))
           {RoleFuncFindOne(req,resp);}
           if("Change".equals(method))
           {RoleFuncChange(req,resp);}
           if("FindLike".equals(method))
           {RoleFuncFindLike(req,resp);}
		   
		   
	}
	 // 
		protected void RoleFuncInsert(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			String RFid=req.getParameter("RFid");
			String Rid=req.getParameter("Rid");
			String Fid=req.getParameter("Fid");
		    
			RoleFunc  userrole=new RoleFunc(RFid,Rid,Fid);
		    
			RoleFuncService  admins=new  RoleFuncServiceImpl();
		    
		    int update = admins.RoleFuncRegister(userrole);
		    
		    if(update>0){
		    	req.setAttribute("msg", "添加成功！");
		    	req.getRequestDispatcher("/files/RoleFuncRegister.jsp").forward(req, resp);
		    	  /* resp.getWriter().print("<");*/
		    	}else {
		    	  req.setAttribute("msg", "创建失败");
		    	  req.getRequestDispatcher("/files/RoleFuncRegister.jsp").forward(req, resp);
		      }

		 
	}
		 protected void RoleFuncFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			 req.setCharacterEncoding("utf-8");
			 RoleFuncService  RoleFunc=new  RoleFuncServiceImpl();
			 List<RoleFunc> list= RoleFunc.RoleFuncFindAll();
			 req.setAttribute("list", list);
			 req.getRequestDispatcher("/files/RoleFuncList.jsp").forward(req, resp);
			 
			 
		 }
	
	 protected void RoleFuncRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			      String  RFid=req.getParameter("RFid");
	
			      RoleFuncService  admins=new  RoleFuncServiceImpl();
			      
			      int update = admins.RoleFuncRemove(RFid);

			      resp.sendRedirect(req.getContextPath()+"/servlet/ARoleFuncServlet?method=FindAll");
			}
	 protected void RoleFuncFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			    String  RFid=req.getParameter("RFid");
			    
			    RoleFuncService  admins=new  RoleFuncServiceImpl();
			    RoleFunc userrole = admins.RoleFuncFindOne(RFid);

			    if(userrole!=null){
			    	
			    	req.setAttribute("rolefunc", userrole);
			    	req.getRequestDispatcher("/files/RoleFuncUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	 protected void RoleFuncChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			     String RFid=req.getParameter("RFid");
			     String Rid=req.getParameter("Rid");
			     String Fid=req.getParameter("Fid");

			     RoleFunc  userrole=new RoleFunc(RFid,Rid,Fid);

			     RoleFuncService  admins=new  RoleFuncServiceImpl();
			     
			     int update = admins.RoleFuncChange(userrole);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/ARoleFuncServlet?method=FindAll");
			     }
			}
	 protected void RoleFuncFindLike(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			 String  RFid =req.getParameter("RFid");
 
			 RoleFuncService  users=new  RoleFuncServiceImpl();
 
			 List<RoleFunc> list = users.RoleFuncFindLike(RFid);

			 req.setAttribute("RFid", RFid);
			 req.setAttribute("list", list); 
			 req.getRequestDispatcher("/files/RoleFuncList.jsp").forward(req, resp);
			
			
			
		}
}
