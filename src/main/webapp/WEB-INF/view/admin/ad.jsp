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

<title>広告媒体情報</title>

</head>

<body>
	<c:import url="nav.jsp" />
	<div class="design04">
		<div class="container">

			<div class="th item5">広告名</div>


			<div class="th item5">並び替え</div>
			<div class="th item5">非表示</div>

			<div class="th item5">更新</div>
			<div class="th item5">削除</div>

		</div>

		<c:forEach items="${adList}" var="ad">

			<form action="" method="post">

				<input type="hidden" name="id" value="<c:out value="${ad.id}" />" />

				<div class="container">

					<div class="td item5">
						<input type="text" name="ad_name"
							value="<c:out value="${ad.adName}" />" />
					</div>

					<div class="td item5">
						<input type="number" name="ad_row"
							value="<c:out value="${ad.adRow}" />" />
					</div>
					<div class="td item5">
						<input type="text" placeholder="トグルでON・OFFしたい" />
					</div>
					<div class="td item5">
						<input type="submit" name="update" value="更新" />
					</div>
					<div class="td item5">
						<input type="submit" name="delete" value="削除" onclick="return confirm('本当に削除しますか?')" />

					</div>
				</div>
			</form>
		</c:forEach>

		<form action="" method="post">
			<input type="submit" name="new" value="新規入力"
				style="width: 8%; margin: 20px auto;" class="btn btn-danger" /> <input
				type="hidden" name="id" value="<c:out value="${ad.id}" />" />

			<div class="container">

				<div class="item2 th">広告名</div>

				<div class="item2 th">並び替え</div>

			</div>
			<div class="container">


				<div class="item2 td">
					<div class="form">
						<input type="text" name="ad_name" required />
					</div>
				</div>

				<div class="item2 td">
					<input type="number" name="ad_row" value="100" />
				</div>




			</div>

		</form>
	</div>







	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
		$(document).ready(function() {
			$("[name=search]").change(function() {
				$(".disp").hide();
				if ($(this).val() == "") {
					$(".disp").show();
				} else {
					const selector = "." + $(this).val();
					$(selector).show();
				}
			});
		});
	</script>
</body>

</html>