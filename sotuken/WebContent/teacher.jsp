<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			 <h3><font size = 6%>国家試験対策支援システム</font></h3>
		</div>
	</div>
</nav>
<div class="p-3 mb-2 bg-light text-dark">
	<div class="text-center">
		<h2>ユーザ登録権限</h2><br>
		<form id="post" action="/sotuken/pw_check" method="post">
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">確認PW</label>
				<div class="col-15">
				<%// パスワード%>
					<input type="password" class="form-control" id="pw" name="pw" placeholder="PWを入力">
				</div>
			</div>
		</form>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script>
$('#post').submit(function(){
	var pw = document.getElementById("pw").value;
	 if(pw == ""){
	      	//ERROR検知(記入してない場合、フォームを止めて警告する)
	    	alert("パスワードを入力してください");
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
	    		  alert("パスワードが違います。\n再度入力してください");
	    		  $('html').hide();
	    	        $('html').show();
	        }
	    }
	    
</script>
</body>
</html>