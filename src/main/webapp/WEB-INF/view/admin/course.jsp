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
<title>コース情報</title>

</head>
<body>
	<c:import url="nav.jsp" />
	<div class="design04">

	<div class="container">
		<div class="item7 th">店舗名</div>
		<div class="item7 th">コース名</div>
		<div class="item7 th">金額</div>
		<div class="item7 th">時間（分）</div>
		<div class="item7 th">並び替え</div>
		<div class="item7 th">更新</div>
		<div class="item7 th">削除</div>
	</div>


	<c:forEach items="${courseList}" var="course">
		<form action="" method="post">
			<input type="hidden" name="id" value="<c:out value="${course.id}" />" />
			<div class="container">

				<div class="item7 td">

					<select name="shopInf_id">
						<c:forEach items="${shopInfList}" var="shop">

							<option value="<c:out value="${shop.id}" />"
								<c:out value="${shop.id == course.shopInfId ? 'selected' : ''}" />>
								<c:out value="${shop.shopInfName}" />
							</option>
						</c:forEach>

					</select>
				</div>
				<div class="item7 td">
					<input type="text" name="course_name"
						value="<c:out value="${course.courseName}" />" />
				</div>
				<div class="item7 td">
					<input type="number" name="course_fee"
						value="<c:out value="${course.courseFee}" />" />
				</div>
				<div class="item7 td">
					<input type="number" name="course_time"
						value="<c:out value="${course.courseTime}" />" />
				</div>
				<div class="item7 td">
					<input type="number" name="course_row"
						value="<c:out value="${course.courseRow}" />" />
				</div>

				<div class="item7 td">

					<input type="submit" name="update" value="更新">
				</div>
				<div class="item7 td">

					<input type="submit" value="削除">
				</div>


			</div>

		</form>
	</c:forEach>

</div>



</body>
</html>