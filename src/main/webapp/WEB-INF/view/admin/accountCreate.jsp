<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>アカウント作成</title>

</head>
<body>
	<form action="" method="post">
		<h2>名前</h2>
		<p>
			<input type="text" name="login_name" />
		</p>
		<h2>電話番号</h2>
		<p>
			<input type="tel" name="login_phone_number" />
		</p>
		<h2>e-mail</h2>
		<p>
			<input type="email" name="login_email" />
		</p>
		<h2>ログインID</h2>
		<p>
			<input type="text" name="login_id" />
		</p>
		<h2>パスワード</h2>
		<p>
			<input type="password" name="login_pass" />
		</p>
		<h2>パスワード（確認用）</h2>
		<p>
			<input type="password" name="login_pass2" placeholder="確認用" />
		</p>
		<h2>
			<input type="submit" value="登録" />
		</h2>


	</form>

</body>
</html>