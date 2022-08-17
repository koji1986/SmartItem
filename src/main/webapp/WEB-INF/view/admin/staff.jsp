<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>従業員情報</title>

</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<td>従業員名</td>

				<td>並び替え</td>
				<td>削除</td>
			</tr>
			<c:forEach items="${staffList}" var="staff">


				<tr>

					<td><input type="text" name="staff_name"
						value="<c:out value="${staff.staffName}" />" /></td>

					<td><input type="number" name="staff_row"
						value="<c:out value="${staff.staffRow}" />" /></td>
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