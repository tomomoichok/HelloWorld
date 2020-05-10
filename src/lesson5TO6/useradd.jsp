<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8"><title>用户追加</title>
	</head>
	<body>
		<form id="form1" action="./UserAdd" method="post">
			名称: <input type="text" name="userName" id="userName"><br>
			密码: <input type="password" name="password" id="password"><br>
			<input type="radio" name="sex_in" id="sex_in" value="0">男<br>
			<input type="radio" name="sex_in" id="sex_in" value="1">女<br>
			<input type="hidden" name="sex" id="sex" value="">
			年龄: <input type="text" name="age" id="age"><br>
			地址: <input type="text" name="address"><br>
			<input type="button" value="提交" onclick="addUser()">
		</from>
		<script>

		    function addUser() {
		    	//用户名
		    	let username = document.getElementById('userName');
		    	let message = "";
		        try {
		            if(username.value == "")  throw "值为空";
		            if(username.value.length > 10)    throw "字符超长";
		        }
		        catch(err) {
		        	alert("用户名:"+err);
		            return false;
		        }
                //密码
		    	let password = document.getElementById('password');
		        try {
		            if(password.value == "")  throw "值为空";
		            if(password.value.length > 100)    throw "字符超长";
		        }
		        catch(err) {
		        	alert("密码:"+err);
		            return false;
		        }
                //年龄
                let age = document.getElementById('age');
			    try {
			        if(age.value == "")  throw "值为空";
			        if(isNaN(age.value)) throw "不是数字";
			        let x = Number(age.value);
			        if(x < 0)    throw "太小";
			        if(x > 150)   throw "太大";
			    }
			    catch(err) {
		        	alert("年龄:"+err);
		            return false;
			    }

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
