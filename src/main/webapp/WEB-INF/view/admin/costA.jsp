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
	href="<%=request.getContextPath()%>/css/tableOffInput.css" />
<title>A店経費</title>

</head>
<body>
	<c:import url="nav.jsp" />
	<div class="design04">
	<div>A店舗</div>
	<p></p>
	<form action="" method="get">
		<div>
			<input type="date" name="cost_day" /> <input type="submit"
				value="絞り込み" />
		</div>
	</form>
	<p></p>
	<div>
		<a href="cost/input"><input type="button" value="経費情報入力" /></a>

	</div>
<p></p>

		<div class="container">

			<div class="item8 th">日時</div>
			<div class="item8 th">支払先</div>
			<div class="item8 th">科目</div>
			<div class="item8 th">金額</div>
			<div class="item8 th">担当</div>
			<div class="item8 th">内容</div>
			<div class="item8 th">詳細</div>
			<div class="item8 th">削除</div>
		</div>

		<c:forEach items="${costList}" var="cost">
			<form action="" method="post">
				<input type="hidden" name="id" value="<c:out value="${cost.id}" />" />
				<div class="container">
					<div class="item8 td">

						<fmt:formatDate pattern="MM-dd" value="${cost.costDate}" />
					</div>
					<div class="item8 td">

						<c:out value="${cost.costDestination}" />
					</div>
					<div class="item8 td">

						<c:out value="${cost.costSubjectName}" />
					</div>
					<div class="item8 td">

						<c:out value="${cost.costFee}" />
					</div>
					<div class="item8 td">

						<c:out value="${cost.staffName}" />
					</div>
					<div class="item8 td">

						<c:out value="${cost.costDetail}" />
					</div>
					<div class="item8 td">

						<a href="cost/update?id=<c:out value="${cost.id}" />"><input
							type="button" value="詳細" /></a>
					</div>
					<div class="item8 td">

						<input type="submit" value="削除" />

					</div>
				</div>
			</form>
		</c:forEach>

<p></p>



		<div class="container">
			<table border="1">
				<tr>
					<th>経費合計</th>
				</tr>
				<tr>
					<td></td>
				</tr>


			</table>

		</div>
<p></p>
		<div>
			<input type="button" value="印刷" />
		</div>
	</div>

</body>
</html>