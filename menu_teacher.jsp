<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "Servlet.Main" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body class="bg-light text-dark">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
​
	<nav class="navbar navbar-default p-3 mb-2 bg-dark text-light">
	<div class="container-fluid">
      	<div class="navbar-header">
			 <h3><font size = 6%>国家試験対策支援システム</font>
			 </h3>
		</div>
	</div>
</nav>
<div class="p-3 mb-2 bg-light text-dark">
	<div style="position:absolute;right:0;">
		<form id="post" action="/sotuken/change_teacher" method="post">
				<input type="submit" value="アカウント" class="btn btn-primary">
		</form>
	</div>
	<div class="text-center">
		<h2>生徒一覧</h2>
	</div>
</div>
</body>
</html>