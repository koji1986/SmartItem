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
	href="<%=request.getContextPath()%>/css/Input.css" />
<title>経費入力</title>

</head>
<body class="costInput">
	<c:import url="../nav.jsp" />
	<div class="design04">
		<form action="" method="post">
			<div class="container">
				<div class="item th">
					<input type="date" name="cost_date" />
				</div>
				<div class="item th">
					担当者 <select name="staff_id">
						<c:forEach items="${staffList}" var="staff">

							<option value="<c:out value="${staff.id}" />">
								<c:out value="${staff.staffName}" />
							</option>
						</c:forEach>



					</select>
				</div>
				<div class="item th">
					店舗 <label> <input type="radio" name="shop_id" value="1" />A店
					</label> <label> <input type="radio" value="2" name="shop_id" />B店
					</label>
				</div>

				<div class="item th">
					支払先 <input type="text" name="cost_destination" />
				</div>

				<div class="item th">
					科目 <select name="cost_subject_id">
						<c:forEach items="${costSubjectList}" var="subject">

							<option value="<c:out value="${subject.id}" />">
								<c:out value="${subject.costSubjectName}" />
							</option>
						</c:forEach>

					</select>
				</div>

				<div class="item th">
					金額 <input type="number" name="cost_fee" />
				</div>
				<div class="item th">
					内容 <input type="text" name="cost_detail" />
				</div>
				<div class="item th">
					<input type="submit" value="登録" />
				</div>
			</div>
		</form>
	</div>

</body>
</html>