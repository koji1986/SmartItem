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
<title>A店日報</title>

</head>
<body>
<c:import url="nav.jsp" />
	<form action="" method="post">
		<div>
			<input type="date" name="sales_day" /> <input type="submit"
				value="絞り込み" />
		</div>
	</form>
	<div>
		<input type="button" value="印刷" />

	</div>

	<div>
		A店
		<table border="1">
			<tr>
				<td>総売上</td>
				<td><c:out value="${totalSales}" /></td>
			</tr>

			<tr>
				<td>カード売上</td>
				<td><c:out value="${totalCredit}" /></td>


			</tr>
			<tr>
				<td>その他</td>
				<td></td>

			</tr>

			<tr>
				<td>外注費</td>
				<td><c:out value="${totalSalary}" /></td>
			</tr>
			<tr>
				<td>雑収入</td>
				<td><c:out value="${totalCashCost}" /></td>

			</tr>
			<tr>
				<td>諸経費</td>
				<td><c:out value="${totalCost}" /></td>

			</tr>

			<tr>
				<td>差引合計</td>
				<td><c:out
						value="${totalSales+totalCashCost-totalCredit-totalSalary-totalCost}" /></td>
			</tr>



		</table>


	</div>

	<div>
		<table border="1">
			<tr>
				<td>客数</td>
				<td>新規</td>
				<td>会員</td>
				<td>合計</td>
			</tr>
			<tr>
				<td></td>
				<td><c:out value="${totalNewMember}" /></td>
				<td><c:out value="${totalMember}" /></td>
				<td><c:out value="${totalNewMember+totalMember}" /></td>


			</tr>


		</table>


	</div>

	<div>
		<table border="1">
			<tr>
				<td>フリー</td>
				<td>NET指名</td>
				<td>本指名</td>
				<td>合計</td>
			</tr>
			<tr>
				<td><c:out value="${totalFree}" /></td>
				<td><c:out value="${totalNetNomination}" /></td>
				<td><c:out value="${totalNomination}" /></td>
				<td><c:out
						value="${totalFree+totalNetNomination+totalNomination}" /></td>
			</tr>



		</table>
	</div>

	<div>
		<table border="1">

			<tr>
				<td>合計</td>
				<td></td>
			</tr>

		</table>

	</div>

	<div>
		<table border="1">
			<tr>
				<td>各種割引</td>
			</tr>
			<tr>
				<td>割引名</td>
				<td>割引金額</td>
			</tr>
			<c:forEach items="${salesList}" var="sales" >
			
			<tr>
				<td><c:out value="${sales.discountName}" /></td>
				<td><c:out value="${sales.salesDiscountFee}" /></td>
			</tr>
			</c:forEach>
			


		</table>



	</div>

	<div>

		<table border="1">
			<tr>
				<td>広告媒体</td>
			</tr>
			<c:forEach items="${salesList}" var="sales" >
			
			<tr>
				<td><c:out value="${sales.adName}" /></td>
				<td></td>
			</tr>
			</c:forEach>
			


		</table>


	</div>




</body>
</html>