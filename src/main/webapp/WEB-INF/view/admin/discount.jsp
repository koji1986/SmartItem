<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>割引情報</title>

</head>
<body>

	<form action="" method="post">
		<table border="1">
			<tr>
				<td>店舗名</td>
				<td>割引名</td>
				<td>割引金額</td>

				<td>並び替え</td>
				<td>削除</td>
			</tr>
			<c:forEach items="${discountList}" var="discount" varStatus="vs">


				<tr>
					<td><select name="shopInf_name">
							<option value="1">A店舗</option>
							<option value="2">B店舗</option>
					</select></td>
					<td><input type="text" name="discount_name"
						value="<c:out value="${discount.discountName}" />" /></td>
					<td><input type="number" name="discount_fee"
						value="<c:out value="${discount.discountFee}" />" /></td>

					<td><input type="number" name="discount_row"
						value="<c:out value="${discount.discountRow}" />" /></td>
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