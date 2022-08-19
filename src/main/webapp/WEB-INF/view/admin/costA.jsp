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
<title>A店経費</title>

</head>
<body>
	<c:import url="nav.jsp" />
	<div>A店舗</div>
	<div>
		<input type="date" />
	</div>
	<div>
		<a href="cost/input"><input type="button" value="経費情報入力" /></a>

	</div>

	<div>

		<div class="row">
			<div class="col-1">支払先</div>
			<div class="col-1">科目</div>
			<div class="col-1">金額</div>
			<div class="col-1">担当</div>
			<div class="col-1">内容</div>
			<div class="col-1">詳細</div>
			<div class="col-1">削除</div>
		</div>

		<c:forEach items="${costList}" var="cost">
			<form action="" method="post">
				<input type="hidden" name="id" value="<c:out value="${cost.id}" />" />
				<div class="row">
					<div class="col-1">

						<c:out value="${cost.costDestination}" />
					</div>
					<div class="col-1">

						<c:out value="${cost.costSubjectName}" />
					</div>
					<div class="col-1">

						<c:out value="${cost.costFee}" />
					</div>
					<div class="col-1">

						<c:out value="${cost.staffName}" />
					</div>
					<div class="col-1">

						<c:out value="${cost.costDetail}" />
					</div>
					<div class="col-1">

						<a href="cost/update?id=<c:out value="${cost.id}" />"><input
							type="button" value="詳細" /></a>
					</div>
					<div class="col-1">

						<input type="submit" value="削除" />

					</div>
				</div>
			</form>
		</c:forEach>




	</div>

	<div>
		<table border="1">
			<tr>
				<th>経費合計  
				</th>
			</tr>
			<tr>
				<td></td>
			</tr>


		</table>

	</div>

	<div>
		<input type="button" value="印刷" />
	</div>

</body>
</html>