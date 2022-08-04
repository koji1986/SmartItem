<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>A店経費</title>

</head>
<body>

	<div>A店舗</div>
	<div>
		<input type="date" />
	</div>
	<div>
		<a href="cost/input"><input type="button" value="経費情報入力" /></a>

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
			<c:forEach items="${costList}" var="cost" >
			
			<tr>
				<td><c:out value="${cost.costDestination}" /></td>
				<td><c:out value="${cost.costSubjectName}" /></td>
				<td><c:out value="${cost.costFee}" /></td>
				<td><c:out value="${cost.staffName}" /></td>
				<td><c:out value="${cost.costDetail}" /></td>
				<td><a href="cost/update?id=<c:out value="${cost.id}" />"><input type="button" value="詳細" /></a></td>
				<td><input type="button" value="削除" /></td>
			</tr>
			</c:forEach>
			


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