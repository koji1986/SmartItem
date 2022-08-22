<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>レジ</title>

</head>
<body>
<c:import url="nav.jsp" />

		<div>
			<h1>レジ</h1>
		</div>
		<form action="" method="get"><div>
			<input type="date" name="cash_date" />
		</div>
		</form>

	<form action="" method="post">
		<div>
			<table border="1">
				<tr>
					<td>店舗名</td>
					<td>施術者名1</td>
					<td>施術者名2</td>
					<td>釣銭</td>
					<td>売上</td>
					<td>担当者</td>
					<td>給与</td>
					<td>支払済</td>
					<td>雑費</td>
					<td>更新</td>
					<td>削除</td>
				</tr>
				
				<c:forEach items="${cashList}" var="cash" >
				
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="number" name="cash_change" value="<c:out value="${cash.cashChange}" />"/></td>
					<td></td>
					<td><select name="staff_name">
							<option value="1">主任</option>
							<option value="2">店長</option>
							<option value="3">課長</option>

					</select></td>
					<td></td>
					<td>トグルでON・OFF</td>
					<td><input type="number" name="cash_cost" value="<c:out value="${cash.cashCost}" />" /></td>
					<td><input type="submit" value="更新" /></td>
					<td><input type="button" value="削除" /></td>
				</tr>
				
				</c:forEach>


			</table>


		</div>



	</form>
<div>
	<table border="1">
		<tr>
			<th>現在レジ金</th>
		</tr>
		<tr>
			<th></th>
		</tr>

	</table>
</div>

</body>
</html>