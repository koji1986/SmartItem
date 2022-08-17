<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>オプション情報</title>

</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<td>店舗名</td>
				<td>オプション名</td>
				<td>料金</td>
				<td>並び替え</td>
				<td>更新</td>
				<td>削除</td>
			</tr>

			<c:forEach items="${optionList}" var="option">

				<tr>
					<td><select name="shopInf_id">
							<option value="1">A店舗</option>
							<option value="2">B店舗</option>
					</select></td>
					<td><input type="text" name="option_name"
						value="<c:out value="${option.optionName}" />" /></td>
					<td><input type="number" name="option_fee"
						value="<c:out value="${option.optionFee}" />" /></td>

					<td><input type="number" name="option_row"
						value="<c:out value="${option.optionRow}" />" /></td>
					<td><input type="button" value="更新" /></td>
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