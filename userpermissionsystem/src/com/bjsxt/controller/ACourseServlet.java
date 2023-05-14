package com.bjsxt.controller;
import java.io.IOException;        
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.Course;
 
import com.bjsxt.service.CourseService;
import com.bjsxt.service.impl.CourseServiceImpl;

@WebServlet("/servlet/ACourseServlet")

public class ACourseServlet extends HttpServlet{
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		   String method = req.getParameter("method");
		   
           if("Insert".equals(method))
           {CourseInsert(req,resp);}
           if("FindAll".equals(method))
           {CourseFindAll(req,resp);}
           if("Remove".equals(method))
           {CourseRemove(req,resp);}
           if("FindOne".equals(method))
           {CourseFindOne(req,resp);}
           if("Change".equals(method))
           {CourseChange(req,resp);}
           if("FindLike".equals(method))
           {CourseFindLike(req,resp);}
		   
		   
	}
	protected void CourseInsert(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		
		String Uid=req.getParameter("Uid");
	    String CourseNo=req.getParameter("CourseNo");
	    String CourseName=req.getParameter("CourseName");
	    String Credit=req.getParameter("Credit");
	    Course user=new  Course(CourseNo,CourseName,Credit,Uid);
        CourseService userservice=new CourseServiceImpl();

	    int update = userservice.CourseRegister(user);
	    
	    if(update>0){
	    	req.setAttribute("msg", "添加成功！");
	    	  resp.sendRedirect(req.getContextPath()+"/files/CourseRegister.jsp");
	    	  /* resp.getWriter().print("<");*/
	    	}else {
	    	  req.setAttribute("msg", "添加失败");
	    	  req.getRequestDispatcher("/files/CourseRegister.jsp").forward(req, resp);
	      }

	 
}
	
	 protected void CourseFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		 req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		 CourseService userservice=new  CourseServiceImpl();
		 List<Course> list= userservice.CourseFindAll();
		 req.setAttribute("list", list);
		 req.getRequestDispatcher("/files/CourseList.jsp").forward(req, resp);
		 
		 
	 }
	 protected void CourseRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

	     req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");

			      String  CourseNo=req.getParameter("CourseNo");
	
			      CourseService  admins=new  CourseServiceImpl();
			      
			      int update = admins.CourseRemove(CourseNo);

			      resp.sendRedirect(req.getContextPath()+"/servlet/ACourseServlet?method=FindAll");
			}
	 protected void CourseFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
			    String  CourseNo=req.getParameter("CourseNo");
			    
			    CourseService  admins=new  CourseServiceImpl();
			    Course user = admins.CourseFindOne(CourseNo);

			    if(user!=null){
			    	
			    	req.setAttribute("course", user);
			    	req.getRequestDispatcher("/files/CourseUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	 protected void CourseChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		    String Uid=req.getParameter("Uid");
		    String CourseNo=req.getParameter("CourseNo");
		    String CourseName=req.getParameter("CourseName");
		    String Credit=req.getParameter("Credit");
		    Course user=new  Course(CourseNo,CourseName,Credit,Uid);
	        CourseService userservice=new CourseServiceImpl();

			    
			     
			     int update = userservice.CourseChange(user);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/ACourseServlet?method=FindAll");
			     }
			}
	 protected void CourseFindLike(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
			 String  CourseName =req.getParameter("CourseName");
 
			 CourseService  users=new  CourseServiceImpl();
 
			 List<Course> list = users.CourseFindLike(CourseName);

			 req.setAttribute("CourseName", CourseName);
			 req.setAttribute("list", list); 
			 req.getRequestDispatcher("/files/CourseList.jsp").forward(req, resp);
			
			
			
		}
}
