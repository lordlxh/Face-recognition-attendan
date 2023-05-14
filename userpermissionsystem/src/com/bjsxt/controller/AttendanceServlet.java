package com.bjsxt.controller;
import java.io.IOException;        
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.Attendance;
import com.bjsxt.entity.User;
import com.bjsxt.service.AdminService;
import com.bjsxt.service.AttendanceService;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.AdminServiceImpl;
import com.bjsxt.service.impl.AttendanceServiceImpl;
import com.bjsxt.service.impl.UserServiceImpl;

@WebServlet("/servlet/AttendanceServlet")

public class AttendanceServlet extends HttpServlet{
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		   String method = req.getParameter("method");
		   
           if("Insert".equals(method))
           {AllStudentInsert(req,resp);}
           if("FindAll".equals(method))
           {AttendanceFindAll(req,resp);}
           if("RemoveAll".equals(method))
           {AllStudentRemove(req,resp);}
           if("Remove".equals(method))
           {AttendanceRemove(req,resp);}
           if("FindOne".equals(method))
           {AttendanceFindOne(req,resp);}
           if("Change".equals(method))
           {AttendanceChange(req,resp);}
           if("FindLike".equals(method))
           {AttendanceFindLike(req,resp);}
		   
		   
	}
	protected void AllStudentInsert(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        AttendanceService userservice=new AttendanceServiceImpl();

	    int update = userservice.insertAllStudent();
	    
	    if(update>0){
	    	resp.sendRedirect(req.getContextPath()+"/servlet/AttendanceServlet?method=FindAll");

	    	  /* resp.getWriter().print("<");*/
	    	}else {
	    	  req.setAttribute("msg", "插入失败了");
	    	  req.getRequestDispatcher("/files/AttendanceRegister.jsp").forward(req, resp);
	      }

	 
}
	 protected void AttendanceFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		 AttendanceService userservice=new AttendanceServiceImpl();
		 List<Attendance> list= userservice.AttendanceFindAll();
		 req.setAttribute("list", list);
		 req.getRequestDispatcher("/files/AttendanceList.jsp").forward(req, resp);
		 
		 
	 }
		protected void AllStudentRemove(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
	        AttendanceService userservice=new AttendanceServiceImpl();

		    int update = userservice.deleteAllStudent();
		    
		    if(update>0){
		    	resp.sendRedirect(req.getContextPath()+"/servlet/AttendanceServlet?method=FindAll");

		    	  /* resp.getWriter().print("<");*/
		    	}else {
		    	  req.setAttribute("msg", "插入失败了");
		    	  req.getRequestDispatcher("/files/UserRegister.jsp").forward(req, resp);
		      }

		 
	}
	
	 protected void AttendanceRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

	     req.setCharacterEncoding("utf-8");

			      String  Uid=req.getParameter("Uid");
	
			      AttendanceService  admins=new  AttendanceServiceImpl();
			      
			      int update = admins.AttendanceRemove(Uid);

			      resp.sendRedirect(req.getContextPath()+"/servlet/AttendanceServlet?method=FindAll");
			}
	
	 protected void AttendanceFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			    String  Uid=req.getParameter("Uid");
			    
			    AttendanceService  admins=new  AttendanceServiceImpl();
			    Attendance user = admins.AttendanceFindOne(Uid);

			    if(user!=null){
			    	
			    	req.setAttribute("user", user);
			    	req.getRequestDispatcher("/files/AttendanceUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	
	 protected void AttendanceChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			     String Uid=req.getParameter("Uid");
			     String attendance=req.getParameter("attendance");
			     String aDate=req.getParameter("aDate");
				 Attendance user=new  Attendance(Uid,attendance,aDate);

			     AttendanceService  admins=new  AttendanceServiceImpl();
			     
			     int update = admins.AttendanceChange(user);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/AttendanceServlet?method=FindAll");
			     }
			}
	 protected void AttendanceFindLike(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			 String  attendance =req.getParameter("attendance1");

			 AttendanceService  users=new  AttendanceServiceImpl();

			 List<Attendance> list = users.AttendanceFindLike(attendance);

			 req.setAttribute("attendance1", attendance);
			 req.setAttribute("list", list); 
			 req.getRequestDispatcher("/files/AttendanceList.jsp").forward(req, resp);
			
			
			
		}
}
	

