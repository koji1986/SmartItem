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

</head>
<body>
	<c:import url="nav.jsp" />
	<div class="container">
		<form action="" method="post">
			<div>
				<input type="date" name="sales_day" /> <input type="submit"
					value="絞り込み" />
			</div>
		</form>
		<div>
			<input type="button" value="印刷" />

		</div>
		A店
		<div class="flex-container">
			<div class="flex-item">
				<div class="design04">
					<div class="flex-containerTate">
						<div>
							<div class="flex-a">
								<div>総売上</div>
								<div>
									<c:out value="${totalSales}" />
								</div>
							</div>
						</div>

						<div class="flex-a">
							<div>カード売上</div>
							<div>
								<c:out value="${totalCredit}" />
							</div>


						</div>
						<div class="flex-a">
							<div>その他</div>
							<div></div>

						</div>

						<div class="flex-a">
							<div>外注費</div>
							<div>
								<c:out value="${totalSalary}" />
							</div>
						</div>
						<div class="flex-a">
							<div>雑収入</div>
							<div>
								<c:out value="${totalCashCost}" />
							</div>

						</div>
						<div class="flex-a">
							<div>諸経費</div>
							<div>
								<c:out value="${totalCost}" />
							</div>

						</div>

						<div class="flex-a">
							<div class="flex-b">差引合計</div>
							<div class="flex-b">
								<c:out
									value="${totalSales+totalCashCost-totalCredit-totalSalary-totalCost}" />
							</div>
						</div>




					</div>
				</div>
			</div>


			<div class="flex-item">
				<div class="flex-containerTate">
					<div class="flex-c">
						<div>客数</div>
						<div>新規</div>
						<div>会員</div>
						<div>合計</div>
					</div>
					<div class="flex-c">
						<div></div>
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


				</div>





				<div class="flex-containerTate">
					<div class="flex-c">
						<div>フリー</div>
						<div>NET指名</div>
						<div>本指名</div>
						<div>合計</div>
					</div>
					<div class="flex-c">
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
				</div>

				<div class="flex-c">



					<div>合計</div>
					<div></div>



				</div>

			</div>

			<div class="flex-item">
				<table border="1">
					<tr>
						<td>各種割引</td>
					</tr>
					<tr>
						<td>割引名</td>
						<td>割引金額</td>
					</tr>
					<c:forEach items="${salesList}" var="sales">

						<tr>
							<td><c:out value="${sales.discountName}" /></td>
							<td><c:out value="${sales.salesDiscountFee}" /></td>
						</tr>
					</c:forEach>



				</table>



			</div>

			<div class="flex-item">

				<table border="1">
					<tr>
						<td>広告媒体</td>
					</tr>
					<c:forEach items="${salesList}" var="sales">

						<tr>
							<td><c:out value="${sales.adName}" /></td>
							<td></td>
						</tr>
					</c:forEach>



				</table>


			</div>
		</div>
	</div>


</body>
</html>