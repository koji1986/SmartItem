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
	href="<%=request.getContextPath()%>/css/tableTate.css" />
<title>売上更新</title>

</head>
<body>
	<c:import url="../nav.jsp" />

	<div class="design04">
		<div class="container">
			<form action="" method="post">

				<div class="th">
					<input type="date" name="sales_date"
						value="<fmt:formatDate value="${salesDate}" pattern="yyyy-MM-dd" />" />
				</div>
				<div class="th">
					<input type="time" name="sales_time"
						value="<fmt:formatDate value="${salesTime}" pattern="HH:mm" />" />
				</div>
				<div class="th">
					店舗
					<c:forEach items="${shopInfList}" var="shop">

						<label> <input type="radio" name="shopInf_id"
							value="<c:out value="${shop.id}" />"
							<c:out value="${shop.id == shopInfId ? 'checked' : ''}" />>
							<c:out value="${shop.shopInfName}" />
						</label>

					</c:forEach>


				</div>

				<div class="th">
					顧客種別
					<c:forEach items="${customerCategolyList}" var="categoly">

						<label> <input type="radio" name="customerCategoly_id"
							value="<c:out value="${categoly.id}" />"
							<c:out value="${categoly.id == customerCategolyId ? 'checked' : ''}" /> />
							<c:out value="${categoly.customerCategolyName}" />

						</label>
					</c:forEach>
				</div>


				<div class="th">
					<input type="hidden" value="<c:out value="${customerId}" />"
						name="customer_id" /> 顧客名 <input type="text" name="customer_id"
						value="<c:out value="${customerName}" />" />
				</div>
				<div class="th">
					施術者 <select name="pic_id">
						<c:forEach items="${picList}" var="p">
							<option value="<c:out value="${p.id}" />"
								<c:out value="${p.id == picId ? 'selected' : ''}" />><c:out
									value="${p.picNameA}" /></option>

						</c:forEach>

					</select>
				</div>

				<div class="th">
					指名 <label> <input type="radio" name="sales_nomination"
						value="フリー"
						<c:out value="${salesNomination == 'フリー' ? 'checked' : ''}" /> />フリー
					</label> <label><input type="radio" name="sales_nomination"
						value="NET指名"
						<c:out value="${salesNomination == 'NET指名' ? 'checked' : ''}" /> />NET指名</label>
					<label> <input type="radio" name="sales_nomination"
						value="本指名"
						<c:out value="${salesNomination == '本指名' ? 'checked' : ''}" /> />本指名
					</label>



				</div>

				<div class="th">
					支払方法 <label> <input type="radio" name="sales_payment"
						value="現金"
						<c:out value="${salesPayment == '現金' ? 'checked' : ''}" /> />現金
					</label> <label><input type="radio" name="sales_payment"
						value="クレジットカード"
						<c:out value="${salesPayment == 'クレジットカード' ? 'checked' : ''}" /> />クレジットカード</label>
					<label><input type="radio" name="sales_payment" value="その他"
						<c:out value="${salesPayment == 'その他' ? 'checked' : ''}" /> />その他</label>
				</div>


				<div class="th">
					コース <select name="course_id">
						<c:forEach items="${courseList}" var="course">


							<option value="<c:out value="${course.id}"/>"
								<c:out value="${course.id == courseId ? 'selected' : ''}" />><c:out
									value="${course.courseName}" /></option>

						</c:forEach>


					</select>
				</div>

				<div class="th">
					オプション <select name="option_id">

						<c:forEach items="${optionList}" var="option">

							<option value="<c:out value="${option.id}"/>"
								<c:out value="${option.id == optionId ? 'selected' : '' }"  />>
								<c:out value="${option.optionName}" /></option>
						</c:forEach>



					</select>
				</div>

				<div class="th">
					担当者 <select name="staff_id">
						<c:forEach items="${staffList}" var="staff">


							<option value="<c:out value="${staff.id}"/>"
								<c:out value="${staff.id == staffId ? 'selected' : ''}" />>
								<c:out value="${staff.staffName}" />
							</option>
						</c:forEach>



					</select>

				</div>


				<div class="th">
					交通費 <input type="number" name="sales_carfare"
						value="<c:out value="${salesCarfare}" />" />
				</div>

				<div class="th">
					給与 <input type="number" name="sales_salary"
						value="<c:out value="${salesSalary}" />" />
				</div>
				<div class="th">
					経費 <input type="number" name="sales_cost"
						value="<c:out value="${salesCost}" />" />
				</div>

				<div class="th">
					広告媒体 <select name="ad_id">
						<c:forEach items="${adList}" var="ad">

							<option value="<c:out value="${ad.id}"/>"
								<c:out value="${ad.id == adId}" />>
								<c:out value="${ad.adName}" /></option>
						</c:forEach>


					</select>
				</div>


				<div class="th">
					割引名 <select name="discount_id">
						<c:forEach items="${discountList}" var="discount">

							<option value="<c:out value="${discount.id}" />"
								<c:out value="${discount.id == discountId ? 'selected' : ''}" />>
								<c:out value="${discount.discountName}" />
							</option>
						</c:forEach>



					</select>
				</div>

				<div class="th">
					割引額 <input type="number" name="sales_discount_fee"
						value="<c:out value="${salesDiscountFee}" />" />
				</div>
				<div class="th">
					<input type="submit" value="更新" />
				</div>


			</form>
		</div>
	</div>



</body>
</html>