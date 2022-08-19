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
<title>顧客情報</title>

</head>
<body>
	<c:import url="nav.jsp" />
	<div>
		<a href="customer/input"> <input type="button" value="顧客情報入力" />
		</a>
	</div>

	<div>
		<input type="text" />
	</div>

	<div>

		<div class="row">

			<div class="col-1">会員NO</div>
			<div class="col-1">名前</div>
			<div class="col-1">ふりがな</div>
			<div class="col-1">電話番号</div>
			<div class="col-1">利用日時</div>
			<div class="col-1">詳細</div>
			<div class="col-1">削除</div>

		</div>
		<c:forEach items="${customerList}" var="customer">
			<form action="" method="post">
				<input type="hidden" name="id"
					value="<c:out value="${customer.id}" />" />
				<div class="row">
					<div class="col-1">

						<c:out value="${customer.customerNo}" />
					</div>
					<div class="col-1">

						<c:out value="${customer.customerName}" />
					</div>
					<div class="col-1">

						<c:out value="${customer.customerKana}" />
					</div>
					<div class="col-1">

						<c:out value="${customer.customerPhoneNumber1}" />
					</div>
					<div class="col-1">利用日時設定はまだ</div>
					<div class="col-1">

						<a href="customer/update?id=<c:out value="${customer.id}" />"><input
							type="button" value="編集" /></a>
					</div>
					<div class="col-1">

						<input type="submit" value="削除" />
					</div>
				</div>
			</form>
		</c:forEach>



	</div>
</body>
</html>