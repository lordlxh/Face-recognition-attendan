<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />

		<script language="JavaScript" type="text/javascript">
			function tishi() {
				var a = confirm('数据库中保存有该学生基本信息，您可以修改或保留该信息。');
				if (a != true) return false;
				window.open("冲突页.htm", "", "depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
			}

			function check() {
				document.getElementById("aa").style.display = "";
			}
		</script>
		<style type="text/css">
			<!-- .atten {
				font-size: 12px;
				font-weight: normal;
				color: #F00;
			}
			-->
		</style>
		
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	
	    <script type="text/javascript" src="kindeditor/kindeditor.js"></script>
	     
	     <script type="text/javascript">
	     
	      KE.show({id:"re"});
	     </script> 
	      
	</head>

	<body>
		<form name="fom" id="fom" method="post" action="servlet/AUserServlet?method=StudentChange">
		<input type="text" name="Uid" value="${user.uid }"/>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
            
				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="images/nav04.gif" class="style10">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="subtree1" style="DISPLAY: ;" width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr><td height="40" class="font42">
							
				<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
					<tr>
						<th class="tablestyle_title">用户信息录入</th>
					</tr>
					<tr>
						<td class="CPanel">
							<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
								<TR>
									<TD width="100%">
										<fieldset style="height:100%;">
											<legend>用户信息</legend>
											<table border="0" cellpadding="2" cellspacing="1" style="width:100%">

												<tr>
													<td>用户名称:</td>
													<td>
														<input name="Uname" type="text" class="text" style="width:154px" value="${user.uname }" />${msg }
													</td>
												</tr>

										        <tr>
													<td>用户密码:</td>
													<td>
														<input name="pwd" type="text" class="text" style="width:154px" value="${user.pwd }" /> 
												</tr>
												<tr>
													<td>身份证号:</td>
													<td>
														<input name="sfz" type="text" class="text" style="width:154px" value="${user.sfz }" /> 
												</tr>
												<tr>
													<td>联系电话:</td>
													<td>
														<input name="phone" type="text" class="text" style="width:154px" value="${user.phone }" /> 
												</tr>
												<tr>
													<td>照片文件:</td>
													<td>
														<input name="photoname" type="text" class="text" style="width:154px" value="${user.phone }" /> 
												</tr>
											</table>
											<br />
										</fieldset>
									</TD>

								</TR>

							</TABLE>

						</td>
					</tr>

					<TR>
						<TD colspan="2" align="center" height="50px">
							<input type="submit" name="Submit" value="确认修改" class="button"  />
						</TD>
					</TR>
				</TABLE>
									</td>
									</tr>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>