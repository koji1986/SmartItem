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
<title>売上入力</title>

</head>
<body class="salesInput">
	<c:import url="../nav.jsp" />
	<div class="design04">
		<form action="" method="post">
			<div class="container">
				<div class="item th">
					<input type="date" name="sales_date" />
				</div>
				<div class="item th">
					<input type="time" name="sales_time" />
				</div>
				<div class="item th">
					店舗
					<c:forEach items="${shopInfList}" var="shop">
						<label> <input type="radio" name="shopInf_id"
							value="<c:out value="${shop.id}" />" /> <c:out
								value="${shop.shopInfName}" />
						</label>
					</c:forEach>

				</div>

				<div class="item th">
					顧客種別

					<c:forEach items="${customerCategolyList}" var="categoly">
						<label> <input type="radio" name="customerCategoly_id"
							value="<c:out value="${categoly.id}" />" /> <c:out
								value="${categoly.customerCategolyName}" />
						</label>

					</c:forEach>

				</div>


				<div class="item th">
					顧客名 <input type="number" name="customer_id" placeholder="顧客名" />
				</div>
				<div class="item th">
					施術者 <select name="pic_id">
						<c:forEach items="${picList}" var="pic">

							<option value="<c:out value="${pic.id}" />">
								<c:out value="${pic.picNameA}" /></option>
						</c:forEach>



					</select>
				</div>

				<div class="item th">
					指名 <label> <input type="radio" name="sales_nomination"
						value="フリー" />フリー
					</label> <label><input type="radio" name="sales_nomination"
						value="NET指名" />NET指名</label> <label><input type="radio"
						name="sales_nomination" value="本指名" />本指名 </label>
				</div>

				<div class="item th">
					支払方法 <label> <input type="radio" name="sales_payment"
						value="現金" />現金
					</label> <label><input type="radio" name="sales_payment"
						value="クレジットカード" />クレジットカード</label> <label><input type="radio"
						name="sales_payment" value="その他" />その他 </label>
				</div>


				<div class="item th">
					コース <select name="course_id">
						<c:forEach items="${courseList}" var="course">

							<option value="<c:out value="${course.id}" />">
								<c:out value="${course.courseName}" />
							</option>
						</c:forEach>


					</select>
				</div>

				<div class="item th">
					オプション <select name="option_id">
						<c:forEach items="${optionList}" var="option">

							<option value="<c:out value="${option.id}" />">
								<c:out value="${option.optionName}" />
							</option>
						</c:forEach>




					</select>
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
					売上合計 <input type="number" name="sales_amount" />
				</div>



				<div class="item th">
					交通費 <input type="number" name="sales_carfare" />
				</div>

				<div class="item th">
					給与 <input type="number" name="sales_salary" />
				</div>
				<div class="item th">
					経費 <input type="number" name="sales_cost" />
				</div>

				<div class="item th">
					広告媒体 <select name="ad_id">
						<c:forEach items="${adList}" var="ad">

							<option value="<c:out value="${ad.id}" />">
								<c:out value="${ad.adName}" />
							</option>
						</c:forEach>



					</select>
				</div>


				<div class="item th">
					割引名 <select name="discount_id">
						<c:forEach items="${discountList}" var="discount">

							<option value="<c:out value="${discount.id}" />">

								<c:out value="${discount.discountName}" />
							</option>
						</c:forEach>



					</select>
				</div>

				<div class="item th">
					割引額 <input type="number" name="sales_discount_fee" />
				</div>
				<div class="item th"> 
				<input type="submit" value="登録" />
</div>

			</div>
		</form>

	</div>
</body>
</html>