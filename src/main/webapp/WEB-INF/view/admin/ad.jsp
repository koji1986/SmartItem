<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>広告媒体情報</title>

</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<td>広告名</td>


				<td>並び替え</td>
				<td>非表示</td>
				<td>削除</td>
			</tr>

			
			<c:forEach items="${adList}" var="ad">


				<tr>

					<td><input type="text" name="ad_name"
						value="<c:out value="${ad.adName}" />" /></td>

					<td><input type="number" name="ad_row"
						value="<c:out value="${ad.adRow}" />" /></td>
					<td><input type="text" placeholder="トグルでON・OFFしたい" /></td>
					<td><input type="button" value="削除" /></td>
				</tr>
			</c:forEach>




		</table>

		<div>
			<input type="submit" value="更新" />
		</div>
	</form>
</body>
</html>