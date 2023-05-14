package com.bjsxt.controller;
import java.io.IOException;         
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.Function;
 
import com.bjsxt.service.FunctionService;
import com.bjsxt.service.impl.FunctionServiceImpl;

@WebServlet("/servlet/AFunctionServlet")

public class AFunctionServlet extends HttpServlet{
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		   String method = req.getParameter("method");
		   
           if("Insert".equals(method))
           {FunctionInsert(req,resp);}
           if("FindAll".equals(method))
           {FunctionFindAll(req,resp);}
           if("Remove".equals(method))
           {FunctionRemove(req,resp);}
           if("FindOne".equals(method))
           {FunctionFindOne(req,resp);}
           if("Change".equals(method))
           {FunctionChange(req,resp);}
           if("FindLike".equals(method))
           {FunctionFindLike(req,resp);}
		   
		   
	}
	 //角色
		protected void FunctionInsert(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			String Fid=req.getParameter("Fid");
		    
		    String Fname=req.getParameter("Fname");
		    
		    Function  function=new Function(Fid,Fname);
		    
		    FunctionService  admins=new  FunctionServiceImpl();
		    
		    int update = admins.FunctionRegister(function);
		    
		    if(update>0){
		    	req.setAttribute("msg", "添加成功！");
		    	req.getRequestDispatcher("/files/FunctionRegister.jsp").forward(req, resp);
		    	  /* resp.getWriter().print("<");*/
		    	}else {
		    	  req.setAttribute("msg", "添加失败");
		    	  req.getRequestDispatcher("/files/FunctionRegister.jsp").forward(req, resp);
		      }

		 
	}
		 protected void FunctionFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			 req.setCharacterEncoding("utf-8");
			 FunctionService  admins=new  FunctionServiceImpl();
			 List<Function> list= admins.FunctionFindAll();
			 req.setAttribute("list", list);
			 req.getRequestDispatcher("/files/FunctionList.jsp").forward(req, resp);
			 
			 
		 }
	
	 protected void FunctionRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			      String  Fid=req.getParameter("Fid");
	
			      FunctionService  admins=new  FunctionServiceImpl();
			      
			      int update = admins.FunctionRemove(Fid);

			      resp.sendRedirect(req.getContextPath()+"/servlet/AFunctionServlet?method=FindAll");
			}
	 protected void FunctionFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			    String  Fid=req.getParameter("Fid");
			    
			    FunctionService  admins=new  FunctionServiceImpl();
			    Function role = admins.FunctionFindOne(Fid);

			    if(role!=null){
			    	
			    	req.setAttribute("function", role);
			    	req.getRequestDispatcher("/files/FunctionUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	 protected void FunctionChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			     String Fid=req.getParameter("Fid");
			     String Fname=req.getParameter("Fname");


			     Function  role=new Function(Fid,Fname);

			     FunctionService  admins=new  FunctionServiceImpl();
			     
			     int update = admins.FunctionChange(role);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/AFunctionServlet?method=FindAll");
			     }
			}
	 protected void FunctionFindLike(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			 String  Fname =req.getParameter("Fname");
 
			 FunctionService  users=new  FunctionServiceImpl();
 
			 List<Function> list = users.FunctionFindLike(Fname);

			 req.setAttribute("Fname", Fname);
			 req.setAttribute("list", list); 
			 req.getRequestDispatcher("/files/FunctionList.jsp").forward(req, resp);
			
			
			
		}
}
