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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/tableTate.css" />
</head>
<body>
<c:import url="../nav.jsp" />
		<div class="design04">
		<div class="container">
	<form action="" method="post">

			<div class="item th">
				<c:out value="${sales.salesDate}" />
			</div>


			<div class="item th">
				<c:out value="${sales.shopInfName}" />
			</div>


			<div class="item th">
				<c:out value="${sales.customerCategolyName}" />
			</div>


			<div class="item th">
				<c:out value="${sales.customerName}" />
			</div>


			<div class="item th">
				<c:out value="${sales.picName}" />
			</div>


			<div class="item th">
				<c:out value="${sales.courseName}" />
			</div>


			<div class="item th">
				<c:out value="${sales.salesNomination}" />
			</div>


			<div class="item th">
				<c:out value="${sales.optionName}" />
			</div>


			<div class="item th">
				<c:out value="${sales.salesPayment}" />
			</div>


			<div class="item th">
				<c:out value="${sales.salesAmount}" />
			</div>


			<div class="item th">
				<c:out value="${sales.salesCarfare}" />
			</div>


			<div class="item th">
				<c:out value="${sales.salesSalary}" />
			</div>


			<div class="item th">
				<c:out value="${sales.salesCost}" />
			</div>


			<div class="item th">
				<c:out
					value="${sales.salesAmount-sales.salesSalary-sales.salesCost}" />
			</div>



			<div class="item th">












			<input type="submit" value="削除" />
			</div>
	</form>
	</div>
		</div>

</body>
</html>