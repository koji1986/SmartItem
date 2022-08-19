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
<title>施術者情報</title>

</head>
<body>
	<c:import url="nav.jsp" />
	<div>
		<a href="pic/input"> <input type="button" value="新規施術者情報入力" /></a>
	</div>

	<div>
		<label><input type="radio" name="pic_existence" value="1" />在籍者</label>
		<label><input type="radio" name="pic_existence" value="2" />退店者</label>

	</div>
	<div>
		<input type="button" value="絞り込み" />
	</div>
	<div>
		<input type="text" />
	</div>



	<div class="row">
		<div class="col-1">入店日</div>
		<div class="col-1">ランク</div>
		<div class="col-1">名前1</div>
		<div class="col-1">名前2</div>
		<div class="col-1">ふりがな</div>
		<div class="col-1">退店日</div>
		<div class="col-1">詳細</div>
		<div class="col-1">削除</div>
	</div>

	<c:forEach items="${picList}" var="pic">

		<form action="" method="post">
<input type="hidden" name="id" value="<c:out value="${pic.id}" />" />
			<div class="row">
				<div class="col-1">

					<c:out value="${pic.picEntryDay}" />
				</div>
				<div class="col-1">

					<c:out value="${pic.picRankName}" />
				</div>
				<div class="col-1">

					<c:out value="${pic.picNameA}" />
				</div>
				<div class="col-1">

					<c:out value="${pic.picNameB}" />
				</div>
				<div class="col-1">

					<c:out value="${pic.picKanaA}" />
				</div>
				<div class="col-1">

					<c:out value="${pic.picOutDay}" />
				</div>
				<div class="col-1">

					<a href="pic/update?id=<c:out value="${pic.id}" />"><input
						type="button" value="詳細" /></a>
				</div>
				<div class="col-1">
					<input type="submit" value="削除" />
				</div>
			</div>
		</form>
	</c:forEach>




</body>
</html>