<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>main page</title>
</head>
<body>
<ul>
<li><p><b>name:</b>
   <%= request.getParameter("name")%>
</p></li>
<li><p><b>url:</b>
   <%= request.getParameter("url")%>
</p></li>
</ul>
</body>
</html>