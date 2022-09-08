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
	href="<%=request.getContextPath()%>/css/tableCourse.css" />
<title>レジ</title>

</head>
<body>
	<c:import url="nav.jsp" />

	<div class="design04">
		<h1>レジ</h1>

		<div class="flex-containerTate">
			<form action="" method="get">
				<div class="wide30">

					<div>
						<input type="date" name="cash_day" 
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${date}" />"/>
					</div>
					<div>
						<input type="submit" value="絞り込み" />
					</div>
				</div>
			</form>

			<div class="container">


				<div class="th item13">日付</div>
				<div class="th item13">時間</div>
				<div class="th item13">店舗名</div>
				<div class="th item13">施術者名1</div>
				<div class="th item13">施術者名2</div>
				<div class="th item13">釣銭</div>
				<div class="th item13">売上</div>
				<div class="th item13">担当者</div>
				<div class="th item13">給与</div>
				<div class="th item13">支払済</div>
				<div class="th item13">雑費</div>
				<div class="th item13">更新</div>
				<div class="th item13">削除</div>

			</div>
			<c:forEach items="${cashList}" var="cash">
				<form action="" method="post">
					<input type="hidden" name="id" value="<c:out value="${cash.id}" />" />
<input type="hidden" name="cash_day" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${date}" />"/>

					<div class="container">

						<div class="td item13">
							<fmt:formatDate pattern="yy-MM-dd" value="${cash.cashDate}" />
						</div>
						<div class="td item13">
							<fmt:formatDate pattern="HH:mm" value="${cash.salesTime}" />
						</div>
						<div class="td item13">
							<c:out value="${cash.shopInfName}" />
						</div>
						<div class="td item13">
							<c:out value="${cash.picNameA}" />
						</div>
						<div class="td item13"></div>
						<div class="td item13">
							<input type="number" name="cash_change"
								value="<c:out value="${cash.cashChange}" />" />
						</div>
						<div class="td item13">
							<fmt:formatNumber value="${cash.salesAmount}" />
						</div>
						<div class="td item13">
							<c:out value="${cash.staffName}" />
						</div>
						<div class="td item13">
							<fmt:formatNumber value="${cash.salesSalary}" />
						</div>
						<div class="td item13">
							<label><input type="radio" name="salary_done" value="1"
								<c:out value="${cash.salaryDone == 1 ? 'checked' : '' }" /> />未</label>
							<label> <input type="radio" name="salary_done" value="2"
								<c:out value="${cash.salaryDone == 2 ? 'checked' : ''}" /> />済
							</label>
						</div>
						<div class="td item13">
							<input type="number" name="cash_cost"
								value="<c:out value="${cash.cashCost}" />" />
						</div>
						<div class="td item13">
							<input type="submit" name="update" value="更新" />

						</div>
						<div class="td item13">
							<input type="submit" value="削除" />
						</div>


					</div>
				</form>
			</c:forEach>









			<div class="container">
				<div class="regi">
					<div class="item1 th">現在レジ金</div>


					<div class="item1 td"><fmt:formatNumber value="${totalCash}" />円</div>
				</div>


			</div>
		</div>
	</div>

</body>
</html>