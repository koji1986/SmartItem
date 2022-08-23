<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>TITLE</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>釣銭</th>
				<td><input type="number" name="cash_change"
					value="<c:out value="${cashChange}" />" /></td>
			</tr>
			<tr>
				<th>雑費</th>
				<td><input type="number" name="cash_cost"
					value="<c:out value="${cashCost}" />" /></td>
			</tr>

		</table>
		<input type="submit" value="更新" />
	</form>
</body>
</html>