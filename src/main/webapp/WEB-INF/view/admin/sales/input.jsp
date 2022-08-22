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
<title>売上入力</title>

</head>
<body>
	<c:import url="../nav.jsp" />

	<form action="" method="post">

		<div>
			<input type="date" name="sales_date" />
		</div>
		<div>
			<input type="time" name="sales_time" />
		</div>
		<div>
			店舗
			<c:forEach items="${shopInfList}" var="shop">
				<label> <input type="radio" name="shopInf_id"
					value="<c:out value="${shop.id}" />" /> <c:out
						value="${shop.shopInfName}" />
				</label>
			</c:forEach>

		</div>

		<div>
			顧客種別

			<c:forEach items="${customerCategolyList}" var="categoly">
				<label> <input type="radio" name="customerCategoly_id"
					value="<c:out value="${categoly.id}" />" /> <c:out
						value="${categoly.customerCategolyName}" />
				</label>

			</c:forEach>

		</div>


		<div>
			顧客名 <input type="number" name="customer_id" placeholder="顧客名" />
		</div>
		<div>
			施術者 <select name="pic_id">
				<c:forEach items="${picList}" var="pic">

					<option value="<c:out value="${pic.id}" />">
						<c:out value="${pic.picNameA}" /></option>
				</c:forEach>



			</select>
		</div>

		<div>
			指名 <label> <input type="radio" name="sales_nomination"
				value="フリー" />フリー
			</label> <label><input type="radio" name="sales_nomination"
				value="NET指名" />NET指名</label> <label><input type="radio"
				name="sales_nomination" value="本指名" />本指名 </label>
		</div>

		<div>
			支払方法 <label> <input type="radio" name="sales_payment"
				value="現金" />現金
			</label> <label><input type="radio" name="sales_payment"
				value="クレジットカード" />クレジットカード</label> <label><input type="radio"
				name="sales_payment" value="その他" />その他 </label>
		</div>


		<div>
			コース <select name="course_id">
				<c:forEach items="${courseList}" var="course">

					<option value="<c:out value="${course.id}" />">
						<c:out value="${course.courseName}" />
					</option>
				</c:forEach>


			</select>
		</div>

		<div>
			オプション <select name="option_id">
				<c:forEach items="${optionList}" var="option">

					<option value="<c:out value="${option.id}" />">
						<c:out value="${option.optionName}" />
					</option>
				</c:forEach>




			</select>
		</div>

		<div>
			担当者 <select name="staff_id">
				<c:forEach items="${staffList}" var="staff">

					<option value="<c:out value="${staff.id}" />">
						<c:out value="${staff.staffName}" />
					</option>
				</c:forEach>



			</select>

		</div>
		<div>
			売上合計 <input type="number" name="sales_amount" />
		</div>



		<div>
			交通費 <input type="number" name="sales_carfare" />
		</div>

		<div>
			給与 <input type="number" name="sales_salary" />
		</div>
		<div>
			経費 <input type="number" name="sales_cost" />
		</div>

		<div>
			広告媒体 <select name="ad_id">
				<c:forEach items="${adList}" var="ad">

					<option value="<c:out value="${ad.id}" />">
						<c:out value="${ad.adName}" />
					</option>
				</c:forEach>



			</select>
		</div>


		<div>
			割引名 <select name="discount_id">
				<c:forEach items="${discountList}" var="discount">

					<option value="<c:out value="${discount.id}" />">

						<c:out value="${discount.discountName}" />
					</option>
				</c:forEach>



			</select>
		</div>

		<div>
			割引額 <input type="number" name="sales_discount_fee" />
		</div>
		<input type="submit" value="登録" />



	</form>


</body>
</html>