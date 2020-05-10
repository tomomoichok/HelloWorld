<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,com.web.Bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户一览</title>
</head>
<body>
    <form id="form1" method="post">
    <table border=1>
        <tr>
            <td>选择</td>
            <td>名称</td>
            <td>性别</td>
            <td>年龄</td>
            <td>地址</td>
        </tr>
          <input type="hidden" name="userId" id="userId" value="">
          <input type="hidden" name="userName" id="userName" value="">
          <input type="hidden" name="sex" id="sex" value="">
          <input type="hidden" name="age" id="age" value="">
          <input type="hidden" name="address" id="address" value="">
          <%
              if(session.getAttribute("dataList") != null) {
                  for(UserBean row : (List<UserBean>) session.getAttribute("dataList")) {
          %>
			        <tr>
			            <td><input type="radio" name="userId_sel" id="userId_sel" value="<%= row.getUserId() %>"></td>
			            <td><%= row.getUserName() %><input type="hidden" name="userName_sel" id="userName_sel" value="<%= row.getUserName() %>"></td>
			            <td><% if(row.getSex().equals("0")) { %>男
			                <% } else { %>女
			                <% } %>
			                <input type="hidden" name="sex_sel" id="sex_sel" value="<%= row.getSex() %>"></td>
			            <td><%= row.getAge() %><input type="hidden" name="age_sel" id="age_sel" value="<%= row.getAge() %>"></td>
			            <td><%= row.getAddress() %><input type="hidden" name="address_sel" id="address_sel" value="<%= row.getAddress() %>"></td>
			        </tr>
        <%        }
              } %>
    </table>

    <input type="button" value="更新" onclick="userUpdate()">
    <input type="button" value="删除" onclick="userDel()">
    </form>
    <script>
        function userUpdate(){
        	let selectvalue = document.getElementById('userId');
        	let address = document.getElementById('address');
        	let age = document.getElementById('age');
        	let userName = document.getElementById('userName');
        	let userSex = document.getElementById('sex');
	    	let radio=document.getElementsByName("userId_sel");
	    	for(i=0;i<radio.length;i++){
                if(radio[i].checked==true) {
                         selectvalue.value=radio[i].value;
                         address.value=document.getElementsByName("address_sel")[i].value;
                         age.value=document.getElementsByName("age_sel")[i].value;
                         userName.value=document.getElementsByName("userName_sel")[i].value;
                         userSex.value=document.getElementsByName("sex_sel")[i].value;

                         break;
               }
	    	}
	    	document.getElementById("form1").action="./userUpdate.jsp";
	    	document.getElementById("form1").submit();
        }
        function userDel() {
        	let selectvalue = document.getElementById('userId');
	    	let radio=document.getElementsByName("userId_sel");
	    	for(i=0;i<radio.length;i++){
                if(radio[i].checked==true) {
                         selectvalue.value=radio[i].value;
                         break;
               }
	    	}
	    	document.getElementById("form1").action="./UserDel";
	    	document.getElementById("form1").submit();
        }
    </script>
</body>
</html>