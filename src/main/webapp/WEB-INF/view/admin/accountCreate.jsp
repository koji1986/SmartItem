<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
	  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/signin.css">
<title>アカウント作成</title>

</head>
<body>
<div class="form-signin">
<h1>アカウント作成</h1>
	<form action="" method="post">
		 <div class="form-group">
                    名前
                    <input type="text" class="form-control" name="login_name" placeholder="ユーザー名">
                </div>
                <div class="form-group">
                    TEL
                    <input type="tel" class="form-control" name="login_phone_number" placeholder="電話番号">
                </div>
                <div class="form-group">
                    e-mail
                    <input type="email" class="form-control" name="login_email" placeholder="メールアドレス">
                </div>
                <div class="form-group">
                    ログインID
                    <input type="text" class="form-control" name="login_id" placeholder="ログインID">
                </div>
                <div class="form-group">
                    パスワード
                    <input type="text" class="form-control" name="login_pass" placeholder="ログインパスワード">
                </div>
                <div class="form-group">
                    パスワード（確認用）
                    <input type="text" class="form-control" name="login_pass2" placeholder="確認用">
                </div>

                <div>
                    <p></p>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="登録" />
                </div>


	</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	

</body>
</html>