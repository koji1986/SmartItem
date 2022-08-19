<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<title>経費更新</title>

</head>
<body>
	<c:import url="../nav.jsp" />
	
	<span><c:out value="${id}" /></span>
	<form action="" method="post">
		<div>
			<input type="date" name="cost_date"
				value="<fmt:formatDate value="${costDate}" pattern="yyyy-MM-dd" />" />
		</div>
		<div>
			担当者 <select name="staff_id">
				<c:forEach items="${staffList}" var="staff">

					<option value="<c:out value="${staff.id}" />"
						<c:out value="${staff.id == staffId ? 'selected' : ''}" />>
						<c:out value="${staff.staffName}" /></option>
				</c:forEach>



			</select>
		</div>
		<div>
			店舗
			<c:forEach items="${shopInfList}" var="shop">

				<label> <input type="radio" name="shop_id"
					value="<c:out value="${shop.id}" />"
					<c:out value="${shop.id == shopNameId ? 'checked' : ''}" /> /> <c:out
						value="${shop.shopInfName}" />
				</label>
			</c:forEach>

		</div>

		<div>
			支払先 <input type="text" name="cost_destination"
				value="<c:out value="${costDestination}" />" />
		</div>

		<div>
			科目 <select name="cost_subject_id">
				<c:forEach items="${costSubjectList}" var="cost">

					<option value="<c:out value="${cost.id}" />"
						<c:out value="${cost.id == costSubjectId ? 'selected' : ''}" />>

						<c:out value="${cost.costSubjectName}" />
					</option>
				</c:forEach>

			</select>
		</div>

		<div>
			金額 <input type="number" name="cost_fee"
				value="<c:out value="${costFee}" />" />
		</div>
		<div>
			内容 <input type="text" name="cost_detail"
				value="<c:out value="${costDetail}" />" />
		</div>
		<input type="submit" value="更新" />
	</form>



</body>
</html>