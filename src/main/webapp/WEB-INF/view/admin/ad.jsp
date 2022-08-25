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
<title>広告媒体情報</title>

</head>

<body>
<c:import url="nav.jsp" />
	<div class="row">
		<div class="col-2">広告名</div>


		<div class="col-2">並び替え</div>
		<div class="col-2">非表示</div>
		
		<div class="col-2">更新</div>
		<div class="col-2">削除</div>

	</div>

	<c:forEach items="${adList}" var="ad">

		<form action="" method="post">

			<input type="hidden" name="id" value="<c:out value="${ad.id}" />" />

			<div class="row">

				<div class="col-2">
					<input type="text" name="ad_name"
						value="<c:out value="${ad.adName}" />" />
				</div>

				<div class="col-2">
					<input type="number" name="ad_row"
						value="<c:out value="${ad.adRow}" />" />
				</div>
				<div class="col-2">
					<input type="text" placeholder="トグルでON・OFFしたい" />
				</div>
				<div class="col-2">
					<input type="submit" name="update" value="更新" />
				</div>
				<div class="col-2">
					<input type="submit" name="delete" value="削除" />
					
				</div>
			</div>
		</form>
	</c:forEach>






	

	<script src="js/bootstrap.bundle.min.js"></script>
</body>

</html>