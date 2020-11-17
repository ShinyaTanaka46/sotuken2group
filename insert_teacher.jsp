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
	<%//入力フォーム %>
		<h2>ユーザ登録(教員)</h2>
		<form id="post" action="/sotuken/Insert_Teacher" method="post">
			【登録内容】<br><br>
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">ID</label>
				<div class="col-15">
				<%// ID%>
					<input type="text" class="form-control" id="id" name="id" placeholder="IDを入力">
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">氏名</label>
				<div class="col-sm-15">
				<%// 名前%>
					<input type="text"class="form-control" id="name" name="name" placeholder="氏名を入力">
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">PW</label>
				<div class="col-sm-15">
					<input type="password" class="form-control" id="pw" name="pw" placeholder="PWを入力">
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-0.9 col-form-label">確認PW　</label>
				<div class="col-sm-15">
					<input type="password" class="form-control" id="pw1" name="pw1" placeholder="再確認"><br>
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<input type="submit" value="登録" class="btn btn-primary">
			</div>
		</form>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script>
  //id・pw長さチェック
    $('#post').submit(function(){
    	//ここで　入力項目の不備をチェックする。
	    //不備があれば return false

	    var id = document.getElementById("id").value;
	    var name = document.getElementById("name").value;
	    var pw = document.getElementById("pw").value;
	    var pw1 = document.getElementById("pw1").value;

	    if(id == "" || pw == "" || name == "" || pw1 == ""){
	      	//ERROR検知(記入してない場合、フォームを止めて警告する)
	    	alert("空欄箇所があります。\nフォームに入力してください");
	        $('html').hide();
	        $('html').show();
	        return false;
	    }else if(pw != pw1){
	    	alert("パスワードが一致していません");
	    	 $('html').hide();
		     $('html').show();
		     return false;
	    }else{
			var match =id.indexOf(id.match(/[a-z]/))
	    		if(match != -1){
	    			var result = window.confirm("【登録内容】\n　ID　:"+id+"\n　氏名　:"+name+"\n以上の内容でお間違いないですか？");
			    	if( result ){
			    		return true;
			    	}else{
			    		return false;
			    	}
		    	}else{
		    		alert("登録するIDは半角英数字でお願いします");
			    	return false;
				 }
	    	}
	    }
	 );
  //URLのパラメータを取得
    var urlParam = location.search.substring(1); //id= ...

    // URLにパラメータが存在する場合
    if(urlParam) {
        if(urlParam.match(/0/)){
          	  alert("ユーザ登録に失敗しました。\n再度入力してください.");
	   		  $('html').hide();
	   	      $('html').show();
	    }
	 }
</script>
</body>
</html>