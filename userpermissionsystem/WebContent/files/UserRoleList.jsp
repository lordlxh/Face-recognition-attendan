<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			}
			.tabfont01 {
				font-family: "宋体";
				font-size: 9px;
				color: #555555;
				text-decoration: none;
				text-align: center;
			}
			.font051 {
				font-family: "宋体";
				font-size: 12px;
				color: #333333;
				text-decoration: none;
				line-height: 20px;
			}
			.font201 {
				font-family: "宋体";
				font-size: 12px;
				color: #FF0000;
				text-decoration: none;
			}
			.button {
				font-family: "宋体";
				font-size: 14px;
				height: 37px;
			}
			html {
				overflow-x: auto;
				overflow-y: auto;
				border: 0;
			}
			-->
		</style>

		<link href="css/css.css" rel="stylesheet" type="text/css" />
		<script type="text/JavaScript">

		</script>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<SCRIPT language=JavaScript>
		function sousuo() {
			window.open("gaojisousuo.htm", "", "depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
		}

		function selectAll() {
			var obj = document.fom.elements;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].name == "delid") {
					obj[i].checked = true;
				}
			}
		}

		function unselectAll() {
			var obj = document.fom.elements;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].name == "delid") {
					if (obj[i].checked == true) obj[i].checked = false;
					else obj[i].checked = true;
				}
			}
		}

		function link() {
			document.getElementById("fom").action = "yuangong.htm";
			document.getElementById("fom").submit();
		}
	</SCRIPT>
	
	<script type="text/javascript">
	

	
	</script>

	<body>
   	<form name="fom" id="fom" method="post" action="servlet/AUserRoleServlet?method=FindLike">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="images/nav04.gif">

									<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td width="24"><img src="images/ico07.gif" width="20" height="18" /></td>
											<td>
												
												<span class="newfont06">用户角色联系号: </span><input name="URid" type="text" size="12" value="${URid }"  />
												<input name="Submit" type="submit" class="right-button02" value="查 询" />
											</td>
										</tr>
									</table>
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
												<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#DEB887" class="newfont03">

													<tr>
														<td height="20" colspan="15" align="center" bgcolor="#EEEEEE" class="tablestyle_title" style="text-align: center;"> 角色列表 </td>
													</tr>
													<tr>
														<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
									                    <td width="9%" align="center" bgcolor="#EEEEEE">用户角色联系号</td>
														<td width="9%" align="center" bgcolor="#EEEEEE">用户编号</td>
														<td width="9%" align="center" bgcolor="#EEEEEE">角色号</td>

														<td width="19%" align="center" bgcolor="#EEEEEE">操作</td>
														
													</tr>
													
													
													<!--定义总的人数   int  count=0  -->
								         			<c:set var="count" value="0"></c:set>
								         			
								         			<!--统计男生人数  -->
								         			<c:set var="man"  value="0"></c:set>
													<c:forEach items="${list }" var="userrole"  varStatus="vs">
													
													   <c:if test="${vs.count%2==0 }">
													     <tr bgcolor="#EEEEEE">
													   </c:if>
													   
													   <c:if test="${vs.count%2!=0 }">
													      <tr bgcolor="#FAEBD7">
													   </c:if>
													
														 
															<td ><input type="checkbox" name="delid"/></td>
						
															<td height="20" >${userrole.URid }</a></td>
															<td >${userrole.uid }</td>
															<td >${userrole.rid }</td>
                                                          <td ><a href="servlet/AUserRoleServlet?URid=${userrole.URid}&method=Remove" onclick="rem(${userrole.URid})">删除</a>&nbsp;|&nbsp;
                                                            <a href="servlet/AUserRoleServlet?URid=${userrole.URid}&method=FindOne">修改</a></td> 
												
															
														     <%-- <td bgcolor="#FFFFFF">${vs.count }----${vs.index }</td> --%>
														</tr>
														
														<!-- count=count+1 -->
													   <c:set var="count" value="${count+1 }"></c:set>
													   
													   <c:if test="${stu.gender=='男' }">
													       <c:set var="man" value="${man+1 }"></c:set>
													   </c:if>
													   
													</c:forEach>
													<tr>
														<td height="20" colspan="15" align="center" bgcolor="#EEEEEE" class="tablestyle_title" style="text-align: center;">
														
														 
														
														
														 </td>
													</tr>
													
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
							</tr>
							<tr>
								<td height="33">
									<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
										<tr>
											<td width="50%">共 <span class="right-text09">5</span> 页 | 第 <span class="right-text09">1</span> 页</td>
											<td width="49%" align="right">[<a href="#" class="right-font08">首页</a> | <a href="#" class="right-font08">上一页</a> | <a href="#" class="right-font08">下一页</a> | <a href="#" class="right-font08">末页</a>] 转至：</td>
											<td width="1%">
												<table width="20" border="0" cellspacing="0" cellpadding="0">
													<tr>
														<td width="1%">
															<input name="textfield3" type="text" class="right-textfield03" size="1" />
														</td>
														<td width="87%">
															<input name="Submit23222" type="submit" class="right-button06" value=" " />
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>