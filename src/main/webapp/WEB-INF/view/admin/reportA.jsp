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
	href="<%=request.getContextPath()%>/css/report.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/tabelOffInput.css" />
<title>A店日報</title>
<style>
@media print {
	.top,button {
		display: none;
	}
}
</style>

</head>
<body>
	<div class="top">
		<c:import url="nav.jsp" />
	</div>
	<div class="container">
		<form action="" method="post">
			<div class="top">
				<input type="date" name="sales_day"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${date}" />" />
				<input type="submit" value="絞り込み" />
			</div>
		</form>
		<div>
			<button class="btn btn-primary" onclick="print()">印刷</button>

		</div>
		A店

		<div class="flex-item">

			<div class="flex-containerTate ko">
				<div>
					<div class="flex-c">
						<div class="f-a">総売上</div>
						<div>
							<fmt:formatNumber value="${totalSales}" />
							円

						</div>
					</div>
				</div>

				<div class="flex-c">
					<div class="f-a">カード売上</div>
					<div>
						<fmt:formatNumber value="${totalCredit}" />
						円

					</div>


				</div>
				<div class="flex-c">
					<div>その他</div>
					<div></div>

				</div>

				<div class="flex-c">
					<div>外注費</div>
					<div>
						<fmt:formatNumber value="${totalSalary}" />
						円

					</div>
				</div>
				<div class="flex-c">
					<div>雑収入</div>
					<div>
						<fmt:formatNumber value="${totalCashCost}" />
						円

					</div>

				</div>
				<div class="flex-c">
					<div>諸経費</div>
					<div>
						<fmt:formatNumber value="${totalCost}" />
						円

					</div>

				</div>

				<div class="flex-c f-b">
					<div class="flex-b">差引合計</div>
					<div class="flex-b">
						<fmt:formatNumber
							value="${totalSales+totalCashCost-totalCredit-totalSalary-totalCost}" />
						円

					</div>
				</div>




			</div>






			<div class="flex-containerTate ko">
				<div class="flex-c">

					<div>新規</div>
					<div>会員</div>
					<div>合計</div>
				</div>
				<div class="flex-c flex-d f-b">

					<div>
						<c:out value="${totalNewMember}" />
					</div>
					<div>
						<c:out value="${totalMember}" />
					</div>
					<div>
						<c:out value="${totalNewMember+totalMember}" />
					</div>


				</div>





				<p></p>



				<div class="flex-c">
					<div>フリー</div>
					<div>NET指名</div>
					<div>本指名</div>
					<div>合計</div>
				</div>
				<div class="flex-c flex-d f-b">
					<div>
						<c:out value="${totalFree}" />
					</div>
					<div>
						<c:out value="${totalNetNomination}" />
					</div>
					<div>
						<c:out value="${totalNomination}" />
					</div>
					<div>
						<c:out value="${totalFree+totalNetNomination+totalNomination}" />

					</div>


				</div>
				<p></p>

				<div class="flex-c">



					<div class="flex-e">合計</div>
					<div class="flex-e"></div>



				</div>


			</div>

			<div class="flex-containerTate ko">
				<div class="flex-a">各種割引</div>

				<div class="f-d">
					<div class="f-e f-b">割引名</div>
					<div class="f-b">割引金額</div>
				</div>

				<c:forEach items="${salesOderAdList}" var="sales">

					<div class="f-d">
						<div class="f-e f-b">
							<c:out value="${sales.discountName}" />
						</div>
						<div class="f-b">
							<fmt:formatNumber value="${sales.salesDiscountFee}" />
							円

						</div>
					</div>
				</c:forEach>





				<p></p>






				<div class="flex-a f-g">
					<div>広告媒体</div>
				</div>
				<c:forEach items="${adList}" var="ad">

					<div class="f-d">
						<div class="f-e f-b">
							<c:out value="${ad.adName}" />
						</div>
						<div class="f-b">
							<c:out value="${ad.adCount}" />
						</div>
					</div>
				</c:forEach>






			</div>

		</div>
	</div>


</body>
</html>