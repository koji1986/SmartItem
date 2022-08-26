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
	href="<%=request.getContextPath()%>/css/table.css" />
<title>施術者ランク</title>

</head>
<body>
<c:import url="nav.jsp" />
<div class="design04">

	<div class="container">
		<div class="item6 th">店舗名</div>
		<div class="item6 th">ランク名</div>
		<div class="item6 th">指名料</div>

		<div class="item6 th">並び替え</div>
		<div class="item6 th">更新</div>
		<div class="item6 th">削除</div>

	</div>
	<c:forEach items="${picRankList}" var="picRank">

		<form action="" method="post">
			<input type="hidden" name="id"
				value="<c:out value="${picRank.id}" />" />
			<div class="container">

				<div class="item6 td">
					<select name="shopInf_id">
						<c:forEach items="${shopInfList}" var="shop">

							<option value="<c:out value="${shop.id}" />"
								<c:out value="${shop.id == picRank.shopInfId ? 'selected' : ''}" />>
								<c:out
									value="${shop.shopInfName}" />

							</option>
						</c:forEach>

					</select>
				</div>
				<div class="item6 td">
					<input type="text" name="picRank_name"
						value="<c:out value="${picRank.picRankName}" />" />
				</div>
				<div class="item6 td">
					<input type="number" name="picRank_fee"
						value="<c:out value="${picRank.picRankFee}" />" />
				</div>
				<div class="item6 td">
					<input type="number" name="picRank_row"
						value="<c:out value="${picRank.picRankRow}" />" />
				</div>
				<div class="item6 td">
					<input type="submit" value="更新" name="update" />
				</div>
				<div class="item6 td">
					<input type="submit" value="削除" />
				</div>
			</div>
		</form>
	</c:forEach>





</div>

</body>
</html>