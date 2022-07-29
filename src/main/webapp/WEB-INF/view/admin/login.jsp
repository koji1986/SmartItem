<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>

</head>
<body>
	<form action="" method="post">
		<h2>ID</h2>
		<h2>
			<input type="text" name="login_id" placeholder="ID" />
		</h2>
		<h2>Password</h2>
		<h2>
			<input type="password" name="login_pass" placeholder="Password" />
		</h2>
		<h2>
			<input type="submit" value="ログイン" />
		</h2>
		
	



	</form>
	<h2><a href="/admin/accountCreate">新規アカウント登録</a></h2>
</body>
</html>