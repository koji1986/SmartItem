<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>TITLE</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/tableCourse.css">
</head>
<body>
<c:import url="../nav.jsp" />
	<form action="" method="post">
		<div class="design04">
		<div class="wide30">
			<div class="container">

				<div class="item2 th">釣銭</div>
				<div class="item2 td last">
					<input type="number" name="cash_change"
						value="<c:out value="${cashChange}" />" />
				</div>
			</div>
			<div class="container">
				<div class="item2 th">雑費</div>
				<div class="item2 td">
					<input type="number" name="cash_cost"
						value="<c:out value="${cashCost}" />" />
				</div>
			</div>



<p></p>

			<input type="submit" value="更新" />

		</div></div>
	</form>
</body>
</html>