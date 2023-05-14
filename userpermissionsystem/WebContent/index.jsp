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
	</head>

	<frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src="files/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
		<frameset cols="213,*" frameborder="no" border="0" framespacing="0">
			<frame src="files/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
			<frame src="files/right.html" name="mainFrame" id="mainFrame" title="mainFrame" />
		</frameset>
	</frameset>
	<noframes>

		<body>
		</body>
	</noframes>

</html>