<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.ArrayList"%>
 <%@page import="Bean.student"%>
 <%@page import="Servlet.change" %>

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
<%
ArrayList<student> list = (ArrayList<student>)request.getAttribute("list");
student usr = null;
for(int i = 0 ; i < list.size(); i++){
	usr = list.get(i);
}
;%>

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
		<h2>【アカウント情報】</h2>
		<form id="post" action="/sotuken/Change_Student" method="post">
				<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">学籍番号</label>
				<div class="col-15">
				<%// 学籍番号%>
					<select id="id" name="id" style="width:205px; height:35px;">
						<option value=<%=usr.getId()%>><%=usr.getId()%></option>
						</select>
				</div>
				</div>
				<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">学年</label>
				<div class="col-sm-15">
				<%// 学年%>
					<select id="grade" name="grade" style="width:205px; height:35px;">
						<option value= <%=usr.getGrade()%>><%=usr.getGrade()%></option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">学科</label>
				<div class="col-100">
				<%// 学科%>
					<select id="subject" name="subject"style="width:205px; height:35px;">
						<option value= <%=usr.getSubject()%>><%=usr.getSubject()%></option>
						<option value="情報システム科">情報システム科</option>
						<option value="ネットワークセキュリティ科">ネットワークセキュリティ科</option>
						<option value="総合システム工学科">総合システム工学科</option>
						<option value="高度情報工学科">高度情報工学科</option>
					</select>
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-0.9 col-form-label">　　クラス　</label>
				<div class="col-15">
				<%// 授業クラス%>
					　<select id="group" name="group" style="width:208px;height:35px;">
						<option value= <%=usr.getGroup()%>><%=usr.getGroup() %></option>
						<option value="基本情報 Aクラス">基本情報Aクラス</option>
						<option value="基本情報 Bクラス">基本情報Bクラス</option>
						<option value="基本情報 Cクラス">基本情報Cクラス</option>
						<option value="応用情報 Aクラス">応用情報Aクラス</option>
						<option value="応用情報 Bクラス">応用情報Bクラス</option>
					</select>
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">氏名</label>
				<div class="col-sm-15">
				<%// 名前%>
					<input type="text"class="form-control" id="name" name="name" value=<%=usr.getName()%>  placeholder=<%=usr.getName()%>>
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-1 col-form-label">PW</label>
				<div class="col-sm-15">
					<input type="password" class="form-control" id="pw" name="pw" placeholder="変更">
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<label class="col-0.9 col-form-label">　　確認PW</label>
			　	<div class="col-sm-15">
					<input type="password" class="form-control" id="pw1" name="pw1" placeholder="再確認"><br>
				</div>
			</div>
			<div class="form-group row justify-content-center">
				<input type="button" value="戻る" onclick="OnButtonClick();" class="btn btn-primary">
				　　
				<input type="submit" value="変更" class="btn btn-primary">
			</div>
		</form>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script>
function OnButtonClick(){
	var result = window.confirm("このサイトを離れますか？\n※変更する内容が保存されません");
	if( result ){
		window.history.back();
		return true;
	}else{
		return false;
	}
}
  //id・pw長さチェック
    $('#post').submit(function(){
    	//ここで　入力項目の不備をチェックする。
	    //不備があれば return false

	    var id = document.getElementById("id").value;
	    var pw = document.getElementById("pw").value;
	    var pw1 = document.getElementById("pw1").value;
	    var grade = document.getElementById("grade").value;
	    var subject = document.getElementById("subject").value;
	    var group = document.getElementById("group").value;
	    var name = document.getElementById("name").value;

	    if(id == "" || pw == "" || pw1 == "" || grade == "" || subject == "" || group == "" || name == ""){
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
	    	var result = window.confirm("【変更内容】\n学籍番号:"+id+"\n　学年　:"+grade+"\n　学科　:"+subject+"\n　クラス　:"+group+"\n　氏名　:"+name+"\n以上の内容でお間違いないですか？");
	    	if( result ){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
      });
  //URLのパラメータを取得
    var urlParam = location.search.substring(1); //id= ...

    // URLにパラメータが存在する場合
    if(urlParam) {
        if(urlParam.match(/0/)){
    		  alert("ユーザ変更に失敗しました。\n再度入力してください");
    		  $('html').hide();
    	        $('html').show();
        }
    }
</script>
</body>
</html>