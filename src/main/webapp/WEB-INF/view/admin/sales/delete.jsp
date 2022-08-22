<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>売上削除</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th><c:out value="${sales.salesDate}" /></th>
			<tr>

				<th><c:out value="${sales.shopInfName}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.customerCategolyName}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.customerName}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.picName}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.courseName}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.salesNomination}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.optionName}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.salesPayment}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.salesAmount}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.salesCarfare}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.salesSalary}" /></th>
			</tr>
			<tr>
				<th><c:out value="${sales.salesCost}" /></th>
			</tr>
			<tr>
				<th><c:out
						value="${sales.salesAmount-sales.salesSalary-sales.salesCost}" /></th>
			</tr>

			<tr>
				<th></th>
			</tr>


		





		</table>

		<input type="submit" value="削除" />
	</form>

</body>
</html>