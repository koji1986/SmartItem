<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>B店経費</title>

</head>
<body>
	<div>B店舗</div>
	<div>
		<input type="date" />
	</div>
	<div>
		<input type="button" value="経費情報入力" />

	</div>

	<div>
		<table border="1">
			<tr>
				<td>支払先</td>
				<td>科目</td>
				<td>金額</td>
				<td>担当</td>
				<td>内容</td>
				<td>詳細</td>
				<td>削除</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="button" value="詳細" /></td>
				<td><input type="button" value="削除" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="button" value="詳細" /></td>
				<td><input type="button" value="削除" /></td>
			</tr>


		</table>
	</div>

	<div>
		<table border="1">
			<tr>
				<th>経費合計</th>
			</tr>
			<tr>
				<td></td>
			</tr>


		</table>

	</div>

	<div>
		<input type="button" value="印刷" />
	</div>
</body>
</html>