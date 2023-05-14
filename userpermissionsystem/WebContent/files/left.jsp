<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<style type="text/css">
			<!-- body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				background-image: url(images/left.gif);
			}
			-->
		</style>
		<link href="css/css.css" rel="stylesheet" type="text/css" />
	</head>
	<SCRIPT language=JavaScript>
		function tupian(idt) {
			var nametu = "xiaotu" + idt;
			var tp = document.getElementById(nametu);
			tp.src = "images/ico05.gif"; //图片ico04为白色的正方形
			for (var i = 1; i < 30; i++) {
				var nametu2 = "xiaotu" + i;
				if (i != idt * 1) {
					var tp2 = document.getElementById('xiaotu' + i);
					if (tp2 != undefined) {
						tp2.src = "images/ico06.gif";
					} //图片ico06为蓝色的正方形
				}
			}
		}

		function list(idstr) {
			var name1 = "subtree" + idstr;
			var name2 = "img" + idstr;
			var objectobj = document.all(name1);
			var imgobj = document.all(name2);
			//alert(imgobj);
			if (objectobj.style.display == "none") {
				for (i = 1; i < 10; i++) {
					var name3 = "img" + i;
					var name = "subtree" + i;
					var o = document.all(name);
					if (o != undefined) {
						o.style.display = "none";
						var image = document.all(name3);
						//alert(image);
						image.src = "images/ico04.gif";
					}
				}
				objectobj.style.display = "";
				imgobj.src = "images/ico03.gif";
			} else {
				objectobj.style.display = "none";
				imgobj.src = "images/ico04.gif";
			}
		}
	</SCRIPT>

	<body>
		<!-- 个人信息 -->
		<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
			<tr>
				<TD>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="207" height="55" background="images/nav01a.jpg">
								<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="25%" rowspan="2"><img src="images/ico02.gif" width="35" height="35" /></td>
										<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">${uname }
										
										
										
										</span></td>
									</tr>
									<tr>
										<td height="22" class="left-font01">
											[&nbsp;<a href="servlet/UserServlet?method=loginOut" target="_top" class="left-font01">退出</a>&nbsp;]</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
<c:if test="${role.substring(0,1)=='1'}">
			

					<!--  0.1user功能开始    -->
					<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
						<tr>
							<td height="29">
								<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="8%"><img name="img7" id="img7" src="images/ico04.gif" width="8" height="11" /></td>
										<td width="92%">
											<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('01');">用户相关</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</TABLE>
					<table id="subtree01" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
						<tr>
							<td width="9%" height="20"><img id="xiaotu17" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="files/UserRegister.jsp" target="mainFrame" class="left-font03" >添加用户</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu18" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="servlet/AUserServlet?method=FindAll" target="mainFrame" class="left-font03" >获取所有用户</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu18" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="servlet/AUserServlet?method=FindStudent" target="mainFrame" class="left-font03" >获取所有学生</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu18" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="servlet/AUserServlet?method=FindTeacher" target="mainFrame" class="left-font03" >获取所有教师</a></td>
						</tr>
					</table>
					<!--  0.1.0    -->
					
					<!--  0.2.0用户角色功能开始    -->
					<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
						<tr>
							<td height="29">
								<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="8%"><img name="img7" id="img7" src="images/ico04.gif" width="8" height="11" /></td>
										<td width="92%">
											<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('67');">用户角色相关</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</TABLE>
					<table id="subtree67" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
						<tr>
							<td width="9%" height="20"><img id="xiaotu17" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="files/UserRoleRegister.jsp" target="mainFrame" class="left-font03" >添加用户角色</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu18" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="servlet/AUserRoleServlet?method=FindAll" target="mainFrame" class="left-font03" >获取所有用户角色</a></td>
						</tr>
					</table>
					<!--  0.2.0 角色功能结束    -->
					
					<!--  0.3.0角色功能开始    -->
					<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
						<tr>
							<td height="29">
								<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="8%"><img name="img7" id="img7" src="images/ico04.gif" width="8" height="11" /></td>
										<td width="92%">
											<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('68');">角色相关</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</TABLE>
					<table id="subtree68" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
						<tr>
							<td width="9%" height="20"><img id="xiaotu17" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="files/RoleRegister.jsp" target="mainFrame" class="left-font03" >添加角色</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu18" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="servlet/ARoleServlet?method=FindAll" target="mainFrame" class="left-font03" >获取所有角色</a></td>
						</tr>
					</table>
					<!--  0.3.0 角色功能结束    -->
					
					<!--  0.4.0角色功能功能开始    -->
					<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
						<tr>
							<td height="29">
								<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="8%"><img name="img7" id="img7" src="images/ico04.gif" width="8" height="11" /></td>
										<td width="92%">
											<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('69');">角色功能相关</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</TABLE>
					<table id="subtree69" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
						<tr>
							<td width="9%" height="20"><img id="xiaotu17" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="files/RoleFuncRegister.jsp" target="mainFrame" class="left-font03" >添加角色功能</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu18" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="servlet/ARoleFuncServlet?method=FindAll" target="mainFrame" class="left-font03" >获取所有角色功能</a></td>
						</tr>
					</table>
					<!--  0.4.0 角色功能功能结束    -->
				
					<!--  0.5.0功能功能开始    -->
					<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
						<tr>
							<td height="29">
								<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="8%"><img name="img7" id="img7" src="images/ico04.gif" width="8" height="11" /></td>
										<td width="92%">
											<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('70');">功能相关</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</TABLE>
					<table id="subtree70" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
						<tr>
							<td width="9%" height="20"><img id="xiaotu17" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="files/FunctionRegister.jsp" target="mainFrame" class="left-font03" >添加功能号码</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu18" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="servlet/AFunctionServlet?method=FindAll" target="mainFrame" class="left-font03">获取所有功能</a></td>
						</tr>
					</table>
					<!--  0.5.0 功能功能结束    -->
</c:if>
		
				
					
<c:if test="${role.substring(1,2)=='1'}">
					<!--  1.2 课程功能开始    -->
					<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
						<tr>
							<td height="29">
								<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="8%"><img name="img1" id="img1" src="images/ico04.gif" width="8" height="11" /></td>
										<td width="92%">
											<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');">课程功能</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</TABLE>
					<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
						<tr>
							<td width="9%" height="20"><img id="xiaotu1" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%"><a href="files/CourseRegister.jsp" target="mainFrame" class="left-font03" >添加课程</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu2" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%"><a href="servlet/ACourseServlet?method=FindAll" target="mainFrame" class="left-font03" >查询课程</a></td>
						</tr>
					</table>
					<!--  1.2 课程功能结束    -->
</c:if>
<c:if test="${role.substring(2,3)=='1'}">		
					<!--  2.学生显示的功能开始    -->
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
						<tr>
							<td height="29">
								<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="8%" height="12"><img name="img3" id="img3" src="images/ico04.gif" width="8" height="11" /></td>
										<td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('3');">学生功能</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

					<table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
						<tr>
							<td width="9%" height="20"><img id="xiaotu9" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%"><a href="http://127.0.0.1:8000/Facerecognize/rec?Uid=${userid }" target="parent" class="left-font03" onClick="tupian('9');">考勤</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu10" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%"><a href="http://127.0.0.1:8000/Facerecognize/upload?Uid=${userid }" target="parent" class="left-font03" onClick="tupian('10');">上传照片</a></td>
						</tr>
				
					</table>

					<!--  学生显示的功能结束    -->
</c:if>
<c:if test="${role.substring(3,4)=='1'}">	
					<!--  教师显示的功能开始    -->
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
						<tr>
							<td height="29">
								<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="8%" height="12"><img name="img4" id="img4" src="images/ico04.gif" width="8" height="11" /></td>
										<td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('4');">教师功能</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

					<table id="subtree4" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
						<tr>
							<td width="9%" height="20"><img id="xiaotu12" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%"><a href="files/AttendanceRegister.jsp" target="mainFrame" class="left-font03" onClick="tupian('12');">新建与清空考勤</a></td>
						</tr>
						<tr>
							<td width="9%" height="20"><img id="xiaotu13" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%"><a href="servlet/AttendanceServlet?method=FindAll" target="mainFrame" class="left-font03" onClick="tupian('13');">考勤表</a></td>
						</tr>
				
					</table>
</c:if>		
					<!--  教师显示的功能结束    -->
	</TD>
			</tr>

		</table>
	</body>

</html>