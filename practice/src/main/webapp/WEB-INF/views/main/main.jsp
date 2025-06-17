<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Baseball Data View</title>
</head>
<body>
	안녕하세요. 데이터를 확인하고 싶은 팀을 선택해주세요.
	<form action="teamSelect" id="teamSelect" method="get">
		<div>
			<label for="lotte">롯데</label>
			<input type="radio" id="lotte" name="teamName" value="lotte">
		</div>
		<div>
			<label for="doosan">두산</label>
			<input type="radio" id="doosan" name="teamName" value="두doosan산">
		</div>
		<div>
			<label for="kt">KT</label>
			<input type="radio" id="kt" name="teamName" value="kt">
		</div>
		<div>
			<label for="kia">기아</label>
			<input type="radio" id="kia" name="teamName" value="kia">
		</div>
		<div>
			<label for="samsung">삼성</label>
			<input type="radio" id="samsung" name="teamName" value="samsung">
		</div>
		<div>
			<label for="kiwoom">키움</label>
			<input type="radio" id="kiwoom" name="teamName" value="samsung">
		</div>
		<div>
			<label for="lg">LG</label>
			<input type="radio" id="lg" name="teamName" value="lg">
		</div>
		<div>
			<label for="nc">NC</label>
			<input type="radio" id="nc" name="teamName" value="nc">
		</div>
		<div>
			<label for="hanhwa">한화</label>
			<input type="radio" id="hanhwa" name="teamName" value="hanhwa">
		</div>
		<div>
			<label for="ssg">SSG</label>
			<input type="radio" id="ssg" name="teamName" value="ssg">
		</div>
		<div>
			<input type="submit" id="nextbtn" value="팀 선택">
		</div>
	</form>
</body>
</html>