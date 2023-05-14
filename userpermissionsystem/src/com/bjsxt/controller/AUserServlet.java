package com.bjsxt.controller;
import java.io.IOException;       
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.CargoRecorder;
import com.bjsxt.entity.User;
import com.bjsxt.service.AdminService;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.AdminServiceImpl;
import com.bjsxt.service.impl.UserServiceImpl;

@WebServlet("/servlet/AUserServlet")

public class AUserServlet extends HttpServlet{
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   req.setCharacterEncoding("utf-8");resp.setCharacterEncoding("utf-8");
		   String method = req.getParameter("method");
		   if("StuInsert".equals(method))
           {StuInsert(req,resp);}
           if("Insert".equals(method))
           {UserInsert(req,resp);}
           if("FindAll".equals(method))
           {UserFindAll(req,resp);}
           if("FindStudent".equals(method))
           {StudentFindAll(req,resp);}
           if("FindTeacher".equals(method))
           {TeacherFindAll(req,resp);}
           if("Remove".equals(method))
           {UserRemove(req,resp);}
           if("FindOne".equals(method))
           {UserFindOne(req,resp);}
           if("StudentFindOne".equals(method))
           {StudentFindOne(req,resp);}
           if("TeacherFindOne".equals(method))
           {TeacherFindOne(req,resp);}
           if("Change".equals(method))
           {UserChange(req,resp);}
           if("StudentChange".equals(method))
           {StudentChange(req,resp);}
           if("TeacherChange".equals(method))
           {TeacherChange(req,resp);}
           if("FindLike".equals(method))
           {UserFindLike(req,resp);}
		   
		   
	}
	   protected void StuInsert(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

			
			String Uid=req.getParameter("Uid");
		    String Uname=req.getParameter("Uname");
		    String pwd=req.getParameter("pwd");
		    String sfz=req.getParameter("sfz");
		    String phone=req.getParameter("phone");
		    String photoname=req.getParameter("photoname");
			 User user=new  User(Uid,Uname,pwd,sfz,phone,photoname);

	        UserService userservice=new UserServiceImpl();

		    int update = userservice.StudentRegister(user);
		    
		    if(update>0){
		    	 req.setAttribute("msg", "注册成功");
		    	  req.getRequestDispatcher("/files/StudentRegister.jsp").forward(req, resp);
		    	  /* resp.getWriter().print("<");*/
		    	}else {
		    	  req.setAttribute("msg", "注册失败了，应该是编号重复了");
		    	  req.getRequestDispatcher("/files/StudentRegister.jsp").forward(req, resp);
		      }

		 
	}
	protected void UserInsert(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		
		String Uid=req.getParameter("Uid");
	    String Uname=req.getParameter("Uname");
	    String pwd=req.getParameter("pwd");
	    String sfz=req.getParameter("sfz");
	    String phone=req.getParameter("phone");
	    String photoname=req.getParameter("photoname");
		 User user=new  User(Uid,Uname,pwd,sfz,phone,photoname);

        UserService userservice=new UserServiceImpl();

	    int update = userservice.UserRegister(user);
	    
	    if(update>0){
	    	resp.sendRedirect(req.getContextPath()+"/servlet/AUserServlet?method=FindAll");

	    	  /* resp.getWriter().print("<");*/
	    	}else {
	    	  req.setAttribute("msg", "插入失败了");
	    	  req.getRequestDispatcher("/files/UserRegister.jsp").forward(req, resp);
	      }

	 
}
	
	 protected void UserFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		 UserService userservice=new  UserServiceImpl();
		 List<User> list= userservice.UserFindAll();
		 req.setAttribute("list", list);
		 req.getRequestDispatcher("/files/UserList.jsp").forward(req, resp);
		 
		 
	 }
	 protected void StudentFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		 UserService userservice=new  UserServiceImpl();
		 List<User> list= userservice.StudentFindAll();
		 req.setAttribute("list", list);
		 req.getRequestDispatcher("/files/StudentList.jsp").forward(req, resp);
		 
		 
	 }
	 protected void TeacherFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		 UserService userservice=new  UserServiceImpl();
		 List<User> list= userservice.TeacherFindAll();
		 req.setAttribute("list", list);
		 req.getRequestDispatcher("/files/TeacherList.jsp").forward(req, resp);
		 
		 
	 }
	 protected void UserRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

	     req.setCharacterEncoding("utf-8");

			      String  Uid=req.getParameter("Uid");
	
			      UserService  admins=new  UserServiceImpl();
			      
			      int update = admins.UserRemove(Uid);

			      resp.sendRedirect(req.getContextPath()+"/servlet/AUserServlet?method=FindAll");
			}
	 protected void StudentRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

	              req.setCharacterEncoding("utf-8");

			      String  Uid=req.getParameter("Uid");
	
			      UserService  admins=new  UserServiceImpl();
			      
			      int update = admins.UserRemove(Uid);

			      resp.sendRedirect(req.getContextPath()+"/servlet/AUserServlet?method=StudentFindAll");
			}
	 protected void TeacherRemove(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

	              req.setCharacterEncoding("utf-8");

			      String  Uid=req.getParameter("Uid");
	
			      UserService  admins=new  UserServiceImpl();
			      
			      int update = admins.UserRemove(Uid);

			      resp.sendRedirect(req.getContextPath()+"/servlet/AUserServlet?method=TeacherFindAll");
			}
	 protected void UserFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			    String  Uid=req.getParameter("Uid");
			    
			    UserService  admins=new  UserServiceImpl();
			    User user = admins.UserFindOne(Uid);

			    if(user!=null){
			    	
			    	req.setAttribute("user", user);
			    	req.getRequestDispatcher("/files/UserUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	 protected void StudentFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			    String  Uid=req.getParameter("Uid");
			    
			    UserService  admins=new  UserServiceImpl();
			    User user = admins.UserFindOne(Uid);

			    if(user!=null){
			    	
			    	req.setAttribute("user", user);
			    	req.getRequestDispatcher("/files/StudentUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	 protected void TeacherFindOne(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			    String  Uid=req.getParameter("Uid");
			    
			    UserService  admins=new  UserServiceImpl();
			    User user = admins.UserFindOne(Uid);

			    if(user!=null){
			    	
			    	req.setAttribute("user", user);
			    	req.getRequestDispatcher("/files/TeacherUpdate.jsp").forward(req, resp);
			    	
			    }
		}
	 protected void UserChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			     String Uid=req.getParameter("Uid");
			     String Uname=req.getParameter("Uname");
			     String pwd=req.getParameter("pwd");
			     String sfz=req.getParameter("sfz");
			     String phone=req.getParameter("phone");
			     String photoname=req.getParameter("photoname");
				 User user=new  User(Uid,Uname,pwd,sfz,phone,photoname);

			     UserService  admins=new  UserServiceImpl();
			     
			     int update = admins.UserChange(user);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/AUserServlet?method=FindAll");
			     }
			}
	 protected void StudentChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			     String Uid=req.getParameter("Uid");
			     String Uname=req.getParameter("Uname");
			     String pwd=req.getParameter("pwd");
			     String sfz=req.getParameter("sfz");
			     String phone=req.getParameter("phone");
			     String photoname=req.getParameter("photoname");
				 User user=new  User(Uid,Uname,pwd,sfz,phone,photoname);

			     UserService  admins=new  UserServiceImpl();
			     
			     int update = admins.UserChange(user);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/AUserServlet?method=FindStudent");
			     }
			}
	 protected void TeacherChange(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			     String Uid=req.getParameter("Uid");
			     String Uname=req.getParameter("Uname");
			     String pwd=req.getParameter("pwd");
			     String sfz=req.getParameter("sfz");
			     String phone=req.getParameter("phone");
			     String photoname=req.getParameter("photoname");
				 User user=new  User(Uid,Uname,pwd,sfz,phone,photoname);

			     UserService  admins=new  UserServiceImpl();
			     
			     int update = admins.UserChange(user);
			     if(update>0){
			    	 
			    	 resp.sendRedirect(req.getContextPath()+"/servlet/AUserServlet?method=FindTeacher");
			     }
			}
	 protected void UserFindLike(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			 String  Uname =req.getParameter("Uname");
 
			 UserService  users=new  UserServiceImpl();
 
			 List<User> list = users.UserFindLike(Uname);

			 req.setAttribute("Uname", Uname);
			 req.setAttribute("list", list); 
			 req.getRequestDispatcher("/files/UserList.jsp").forward(req, resp);
			
			
			
		}
}
