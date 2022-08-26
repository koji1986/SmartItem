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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/tableOp.css" />
<title>オプション情報</title>

</head>
<body>
	<c:import url="nav.jsp" />

	<div class="design04">

		<div class="container">


			<div class="th item6">店舗名</div>
			<div class="th item6">オプション名</div>
			<div class="th item6">料金</div>
			<div class="th item6">並び替え</div>
			<div class="th item6">更新</div>
			<div class="th item6">削除</div>
		</div>
		<c:forEach items="${optionList}" var="option">

			<form action="" method="post">
				<input type="hidden" name="id"
					value="<c:out value="${option.id}" />" />

				<div class="container">
					<div class="td item6">
						<select name="shopInf_id">
							<c:forEach items="${shopInfList}" var="shop">

								<option value="<c:out value="${shop.id}" />"
									<c:out value="${shop.id == option.shopInfId ? 'selected' : '' }" />>
									<c:out value="${shop.shopInfName}" />
								</option>
							</c:forEach>

						</select>
					</div>
					<div class="td item6">
						<input type="text" name="option_name"
							value="<c:out value="${option.optionName}" />" />
					</div>
					<div class="td item6">
						<input type="number" name="option_fee"
							value="<c:out value="${option.optionFee}" />" />
					</div>
					<div class="td item6">
						<input type="number" name="option_row"
							value="<c:out value="${option.optionRow}" />" />
					</div>
					<div class="td item6">

						<input type="submit" value="更新" name="update" />
					</div>
					<div class="td item6">

						<input type="submit" value="削除" />
					</div>
				</div>
			</form>
		</c:forEach>



	</div>

	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>