<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>顧客情報</title>

</head>
<body>
	<div>
		<a href="customer/input"> <input type="button" value="顧客情報入力" />
		</a>
	</div>

	<div>
		<input type="text" />
	</div>

	<div>
		<table border="1">
			<tr>
				<td>会員NO</td>
				<td>名前</td>
				<td>ふりがな</td>
				<td>電話番号</td>
				<td>経費利用日時</td>
				<td>詳細</td>
				<td>削除</td>
			</tr>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href=""><input type="button" value="編集" /></a></td>
				<td><a href=""><input type="button" value="削除" /></a></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href=""><input type="button" value="編集" /></a></td>
				<td><a href=""><input type="button" value="削除" /></a></td>
			</tr>
		</table>

	</div>
</body>
</html>