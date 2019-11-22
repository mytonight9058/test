<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
	}
	table,td,th{
		padding:5px;
		border:1px solid black;

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		$("#del").click(function() {
			if(confirm("삭제") == true) {
				location.href = "delete.do?no=${project.no}";	
			} else{
				return false;
			}
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<td>${list.title }</td>
		</tr>
		<tr>
			<th>프로젝트 내용</th>
			<td>${list.content }</td>
		</tr>
		<tr>
			<th>시작날짜</th>
			<td>${list.start_date }</td>
		</tr>
		<tr>
			<th>종료날짜</th>
			<td>${list.end_date }</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>${list.state }</td>
		</tr>
	</table>
	<a href="update.do?no=${list.no}">수정</a>
	<a href="delete.do?no=${list.no}" id="del">삭제</a> <!-- jqeury로 확인, 취소 구현 -->
	<a href="list.do">돌아가기</a>
</body>
</html>