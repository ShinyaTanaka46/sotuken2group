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

<% if( (int)session.getAttribute("sessionAccess") >= 5 ){ %>
	<center>
	<br><br><br><font size = 6% color = red>【警告」</font><br>
	<font size = 6%>ログイン試行回数が上限に達しました。<br></font>
	</center>
<%}else{ %>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
​
	<nav class="navbar navbar-default p-3 mb-2 bg-dark text-light">
	<div class="container-fluid">
      	<div class="navbar-header">
			 <h3><font size = 6%>国家試験対策支援システム</font></h3>
		</div>
	</div>
</nav>
<div class="p-3 mb-2 bg-light text-dark">
	<div class="text-center">
		<h2>ログイン画面</h2>
		<form id="post" action="/sotuken/login" method="post">
			【IDとPWを入力してログイン】<br><br>
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">ID</label>
				<div class="col-15">
					<input type="text" class="form-control" id="id" name="id" placeholder="IDを入力">
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">PW</label>
				<div class="col-sm-15">
					<input type="password" class="form-control" id="pw" name="pw" placeholder="PWを入力"><br>
				</div>
			</div>
			<div class="form-group">
				<input type="submit" value="ログイン" class="btn btn-primary">
			</div>
		</form>
		<p>
			ユーザ登録<br>
			<a href="/sotuken/NewStudent"><button class="btn btn-primary">生徒用</button></a>　　
			<a href="/sotuken/NewTeacher"><button class="btn btn-primary">教員用</button></a><br>
		</p>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script>
	$('#nullcheck').hide();
	$('#idpwcheck').hide();
	//入力項目のチェック
	//nullチェック
    $('#post').submit(function(){
        if($('#id').val() === "" || $('#pw').val() === "") {
        	$('#nullcheck').show();
        	return false;
        }
        else {
        	$('#nullcheck').hide();
        }
    });
  //id・pw長さチェック
    $('#post').submit(function(){
    	//ここで　入力項目の不備をチェックする。
	    //不備があれば return false

	    var user = document.getElementById("id").value;
	    var pw = document.getElementById("pw").value;

	    if(user == "" || pw == ""){
	      	//ERROR検知(記入してない場合、フォームを止めて警告する)
	    	alert("ID・パスワードを入力してください。");
	        $('html').hide();
	        $('html').show();
	        return false;
	    }
      });
    //URLのパラメータを取得
    var urlParam = location.search.substring(1); //id= ...

    // URLにパラメータが存在する場合
    if(urlParam) {
        if(urlParam.match(/0/)){
    		  alert("ログインに失敗しました。\n再度入力してください");
    		  $('html').hide();
    	        $('html').show();
        }
    }
</script>
<%} %>
</body>
</html>