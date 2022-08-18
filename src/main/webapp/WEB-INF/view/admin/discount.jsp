<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<title>割引情報</title>

</head>
<body>
<c:import url="nav.jsp" />
	<div class="row">
		<div class="col-1">店舗名</div>
		<div class="col-1">割引名</div>
		<div class="col-1">割引金額</div>

		<div class="col-1">並び替え</div>
		<div class="col-1">更新</div>
		<div class="col-1">削除</div>
	</div>
	<c:forEach items="${discountList}" var="discount" varStatus="vs">
		<form action="" method="post">
			<input type="hidden" name="id"
				value="<c:out value="${discount.id}" />" />
			<div class="row">

				<div class="col-1">

					<select name="shopInf_id">
						<c:forEach items="${shopInfList}" var="shop">

							<option value="<c:out value="${shop.id}" />"
								<c:out value="${shop.id == discount.shopInfId ? 'selected' : ''}" />>

								<c:out value="${shop.shopInfName}" /></option>
						</c:forEach>

					</select>
				</div>
				<div class="col-1">
					<input type="text" name="discount_name"
						value="<c:out value="${discount.discountName}" />" />
				</div>
				<div class="col-1">
					<input type="number" name="discount_fee"
						value="<c:out value="${discount.discountFee}" />" />
				</div>
				<div class="col-1">
					<input type="number" name="discount_row"
						value="<c:out value="${discount.discountRow}" />" />
				</div>
				<div class="col-1">
					<input type="submit" value="更新" name="update" />
				</div>
				<div class="col-1">

					<input type="submit" value="削除" />
				</div>
			</div>
		</form>
	</c:forEach>


</body>
</html>