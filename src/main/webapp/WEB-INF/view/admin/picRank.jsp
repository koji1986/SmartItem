<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>施術者ランク</title>

</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<td>店舗名</td>
				<td>ランク名</td>
				<td>指名料</td>

				<td>並び替え</td>
				<td>削除</td>
			</tr>
			<c:forEach items="${picRankList}" var="picRank">


				<tr>
					<td><select name="shopInf_name">
							<option value="1">A店舗</option>
							<option value="2">B店舗</option>
					</select></td>
					<td><input type="text" name="picRank_name"
						value="<c:out value="${picRank.picRankName}" />" /></td>
					<td><input type="number" name="picRank_fee"
						value="<c:out value="${picRank.picRankFee}" />" /></td>

					<td><input type="number" name="picRank_row"
						value="<c:out value="${picRank.picRankRow}" />" /></td>
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