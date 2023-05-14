<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>权限系统</title>
		<style type="text/css">
			<!--
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
			}
			-->
		</style>
		<link href="css/css.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript">
		   function change() {
			
			
			 document.getElementById("img").src="rand.jpg?a="+Math.random();
			 
			
		}
		
		
		</script>
	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			
		</table>
		<form action="servlet/LoginServlet" method="post">
			<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
				<tr>
					<td width="221">
						<table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
		
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
										<tr>
											<td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
										</tr>
										<tr>
											<td height="40" align="center">&nbsp;</td>
										</tr>
		
									</table>
								</td>
								<td><img src="images/line01.gif" width="5" height="292" /></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="31%" height="35" class="login-text02">用户名称：
									<br />
								</td>
								<td width="69%">
									<input name="uid" type="text" size="30" />${msg }
								</td>
							</tr>
							<tr>
								<td height="35" class="login-text02">密　码：
									<br />
								</td>
								<td>
									<input name="pwd" type="password" size="30" />
								</td>
							</tr>
		
							
							
							
		
							<tr>
								<td height="35">&nbsp;</td>
								<td>
									<input name="Submit2" type="submit" class="right-button01" value="确认登陆" />
									<input name="Submit232" type="submit" class="right-button02" value="重 置" />
								</td>
							</tr>
								<table>
						<tr>
							<td width="9%" height="20"><img id="xiaotu17" src="images/ico06.gif" width="8" height="12" /></td>
							<td width="91%">
								<a href="files/StudentRegister.jsp" target="parent" class="left-font03" >注册</a></td>
						</tr>
						<table>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>