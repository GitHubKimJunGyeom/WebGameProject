<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 페이지</h1>
	<form action="<c:url value="j_spring_security_check" />" method="post">
		<div>
			아이디 <input type="text" name="j_username">
		</div>
		<div>
			비밀번호 <input type="text" name="j_password">
		</div>
		<div>
			<input type="submit" value="확인">
		</div>
	</form>
</body>
</html>