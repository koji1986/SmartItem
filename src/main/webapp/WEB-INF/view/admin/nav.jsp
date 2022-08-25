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
<title>ナビゲーション</title>

</head>
<body>
<!--  NAVの階層「/SmartItem/admin/nav.jsp」 -->
	<p>ユーザー名:</p>
	<p>
		<a href="/SmartItem/admin/logout">ログアウト</a>
	</p>
	<h1>
		<a href="/SmartItem/admin/cash">レジ</a>
	</h1>
	

	<table border="1">

		<tr>
			<th>売上</th>
			<td><a href="/SmartItem/admin/sales">売上一覧</a></td>
			<td><a href="/SmartItem/admin/sales/input">売上入力</a></td>
		</tr>
	</table>
	<table border="1">

		<tr>
			<th>日報</th>
			<td><a href="/SmartItem/admin/reportA">A店日報</a></td>
			<td><a href="/SmartItem/admin/useReportA">A店施術者日報</a></td>
			<td><a href="/SmartItem/admin/costA">A店経費</a></td>
			<td><a href="/SmartItem/admin/reportB">B店日報</a></td>
			<td><a href="/SmartItem/admin/useReportB">B店施術者日報</a></td>
			<td><a href="/SmartItem/admin/costB">B店経費</a></td>

		</tr>
	</table>
	<table border="1">

		<tr>
			<th>情報</th>
			<td><a href="/SmartItem/admin/customer">顧客情報</a></td>
			<td><a href="/SmartItem/admin/pic">施術者情報</a></td>
		</tr>
	</table>
	<table border="1">

		<tr>
			<th>マスタ</th>
			<td><a href="/SmartItem/admin/course">コース情報</a></td>
			<td><a href="/SmartItem/admin/option">オプション情報</a></td>
			<td><a href="/SmartItem/admin/ad">広告媒体情報</a></td>
			<td><a href="/SmartItem/admin/discount">割引情報</a></td>
			<td><a href="/SmartItem/admin/staff">従業員情報</a></td>
		</tr>
	</table>


</body>
</html>