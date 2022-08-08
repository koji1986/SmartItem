<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>施術者情報</title>

</head>
<body>
	<div>
		<a href="pic/input"> <input type="button" value="新規施術者情報入力" /></a>
	</div>

	<div>
		<label><input type="radio" name="pic_existence" value="1" />在籍者</label>
		<label><input type="radio" name="pic_existence" value="2" />退店者</label>

	</div>
	<div>
		<input type="button" value="絞り込み" />
	</div>
	<div>
		<input type="text" />
	</div>

	<table border="1">
		<tr>
			<td>入店日</td>
			<td>ランク</td>
			<td>名前1</td>
			<td>名前2</td>
			<td>ふりがな</td>
			<td>退店日</td>
			<td>詳細</td>
			<td>削除</td>
		</tr>
		<c:forEach items="${picList}" var="pic">



			<tr>
				<td><c:out value="${pic.picEntryDay}" /></td>
				<td><c:out value="${pic.picRankName}" /></td>
				<td><c:out value="${pic.picNameA}" /></td>
				<td><c:out value="${pic.picNameB}" /></td>
				<td><c:out value="${pic.picKanaA}" /></td>
				<td><c:out value="${pic.picOutDay}" /></td>
				<td><a href="pic/update?id=<c:out value="${pic.id}" />"><input
						type="button" value="詳細" /></a></td>
				<td><input type="button" value="削除" /></td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>