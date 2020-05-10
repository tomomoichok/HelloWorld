<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,com.web.Bean.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户变更</title>
	</head>
	<body>
		<form id="form1" action="./UserUpdate" method="post">
		    <input type="hidden" name="userId" value="<%=request.getParameter("userId")%>">
			名称: <input type="text" name="userName" value="<%=request.getParameter("userName")%>"><br>
			密码: <input type="password" name="password" value=""><br>
			<% if(request.getParameter("sex").equals("0")) {%>
			<input type="radio" name="sex_in" value="0" checked>男<br>
			<input type="radio" name="sex_in" value="1">女<br>
			<%
			    } else {
			%>
			<input type="radio" name="sex_in" value="0" >男<br>
			<input type="radio" name="sex_in" value="1" checked>女<br>
			<% } %>
			<input type="hidden" name="sex" id="sex" value="">
			年龄: <input type="text" name="age" value="<%=request.getParameter("age")%>"><br>
			地址: <input type="text" name="address" value="<%=request.getParameter("address")%>"><br>
			<input type="button" value="更新" onclick="userUpdate()">
		</from>
		<script>
		    function userUpdate() {
		    	let selectvalue = document.getElementById('sex');
		    	let radio=document.getElementsByName("sex_in");
		    	for(i=0;i<radio.length;i++){
                    if(radio[i].checked==true) {
                             selectvalue.value=radio[i].value;
                             break;
                   }
		    	}
		    	document.getElementById("form1").submit();
		    }
		</script>
	</body>
</html>