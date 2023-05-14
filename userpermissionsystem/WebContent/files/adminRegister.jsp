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
		<title></title>
		<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
		
		<script language="JavaScript" type="text/javascript">
			function tishi() {
				var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
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
	</head>
	
	<%
	
	   //获得session中的数据
	   Object   obj= session.getAttribute("admin");
	    
	   if(obj==null){
	      
	      response.sendRedirect("/userpermissionsystem/login.jsp");
	      
	      return;
	   
	   } 
	
	
	 %>
	
	
	<body>
	<form name="fom" id="fom" method="post" action="servlet/AdminRegister">

	<form name="fom" id="fom" method="post">
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
						<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
						<table width="100%" border="0" cellpadding="4" cellspacing="1" class="CContent">
										<tr>
											<th class="tablestyle_title">管理员信息录入</th>
										</tr>

										<tr>
											<td class="font42">
											<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
												<TR>
													<TD width="100%">
														<fieldset style="height:100%;">
															<legend>管理员信息</legend>
															<table border="0" cellpadding="2" cellspacing="1" style="width:100%">

																<tr>
																	<td>管理员名称 :</td>
																	<td>
																		<input name="uname" type="text" class="text" style="width:154px" value="" />${requestScope.msg }
																	</td>
																</tr>
																
																	<tr>
																	<td>管理员账号 :</td>
																	<td>
																		<input name="uid" type="text" class="text" style="width:154px" value="" />
																	</td>
																</tr>

																<tr>
																	<td>管理员密码:</td>
																	<td>
																		<input class="text" type="password" name="pwd" style="width:154px" value="" />
																	</td>
																</tr>

																<tr>
																	<td>管理员年龄:</td>
																	<td>
																		<input class="text" type="number" name="age" style="width:154px" value="" />
																	</td>
																</tr>
																<tr>
																	<td>管理员分数:</td>
																	<td>
																		<input class="text" type="number" name="score" style="width:154px" value="" />
																	</td>
																</tr>
																
																<tr>
																	<td>入职日期:</td>
																	<td>
																		<input class="text" type="date" name="enterdate" style="width:154px" value="" />
																	</td>
																</tr>
																
																<tr>
																	<td>爱好:</td>
																	<td>
																		
																		气功：<input type="checkbox" value="气功"  name="hobby"/>
																		
																		柔道：<input type="checkbox" value="柔道" name="hobby"/>
																		
																		散打：<input type="checkbox" value="散打" name="hobby"/>
																		
																	</td>
																</tr>
																
																
																<tr>
																	<td >描述:</td>
																	<td colspan="3">
																		<textarea name="remark" cols="100" rows="8"></textarea>
																	</td>
																</tr>
															</table>
															<br />
														</fieldset>
													</TD>

												</TR>

											</table>
									</td>
							<TR>
								<TD colspan="2" align="center" height="50px">
									<input type="submit" name="Submit" value="保存" class="button"  />
								</TD>
							</TR>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>				
		</form>
	</body>
	</body>

</html>