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
	href="<%=request.getContextPath()%>/css/tableOffInput.css" />
<title>売上一覧</title>

</head>
<body>
	<c:import url="nav.jsp" />
	<div class="design04">
		<form action="" method="post">
			<input type="date" name="sales_date"
				value="<fmt:formatDate pattern="yyyy-MM-dd" value="${date}" />" />
			<div class="radio">
				<div>
					<input type="radio" name="search" value="s1" />A店
				</div>
				<div>
					<input type="radio" name="search" value="s2" />B店
				</div>
				<div>
					<input type="radio" name="search" value="" />全店舗
				</div>
			</div>
			<div class="radio">

				<label> <input type="radio" name="shop_nomination"
					value="フリー" />フリー <input type="radio" name="shop_nomination"
					value="NET指名" />NET指名 <input type="radio" name="shop_nomination"
					value="本指名" />本指名

				</label>
			</div>
			
			<select name="pic_name">
				<c:forEach items="${picList}" var="p">

					<option value="<c:out value="${p.id}" />"><c:out
							value="${p.picNameA}" /></option>
				</c:forEach>



			</select>
			<p></p>

			<p>
				<input type="text" placeholder="会員NO" />
			</p>
			<p>
				<input type="text" placeholder="顧客名" />
			</p>
			<p>
				<input type="text" placeholder="電話番号" />
			</p>

			<input type="submit" value="絞り込み" />
		</form>
		<p></p>



		<div class="container moji80">

			<div class="item17 th">利用日時</div>
			<div class="item17 th">店舗名</div>
			<div class="item17 th">種別</div>
			<div class="item17 th">顧客名</div>
			<div class="item17 th">施術者名</div>
			<div class="item17 th">コース</div>

			<div class="item17 th">指名</div>

			<div class="item17 th">オプション</div>

			<div class="item17 th">支払</div>
			<div class="item17 th">売上</div>
			<div class="item17 th">交通費</div>
			<div class="item17 th">給与</div>
			<div class="item17 th">経費</div>
			<div class="item17 th">利益</div>
			<div class="item17 th">顧客情報</div>
			<div class="item17 th">売上編集</div>
			<div class="item17 th">削除</div>
		</div>
		<c:forEach items="${salesList}" var="sales">
			<form action="" method="post"
				class="disp s<c:out value="${sales.shopInfId}" /> "
				data-id="<c:out value="${sales.salesNomination}" />">
				<input type="hidden" name="id" value="<c:out value="${sales.id}" />" />
				<div class="container">

					<div class="item17 td moji80">
						<fmt:formatDate pattern="yy/MM/dd" value="${sales.salesDate}" />
						<fmt:formatDate pattern="HH:mm" value="${sales.salesTime}" />
					</div>

					<div class="item17 td">
						<c:out value="${sales.shopInfName}" />
					</div>
					<div class="item17 td">
						<c:out value="${sales.customerCategolyName}" />
					</div>
					<div class="item17 td">
						<c:out value="${sales.customerName}" />
					</div>
					<div class="item17 td">
						<c:out value="${sales.picName}" />
					</div>
					<div class="item17 td moji80">
						<c:out value="${sales.courseName}" />
					</div>
					<div class="item17 td">
						<c:out value="${sales.salesNomination}" />
					</div>
					<div class="item17 td">
						<c:out value="${sales.optionName}" />
					</div>
					<div class="item17 td">
						<c:out value="${sales.salesPayment}" />
					</div>
					<div class="item17 td">
						<fmt:formatNumber value="${sales.salesAmount}" />
					</div>
					<div class="item17 td">
						<fmt:formatNumber value="${sales.salesCarfare}" />
					</div>
					<div class="item17 td">
						<fmt:formatNumber value="${sales.salesSalary}" />
					</div>
					<div class="item17 td">
						<fmt:formatNumber value="${sales.salesCost}" />
					</div>
					<div class="item17 td">
						<fmt:formatNumber
							value="${sales.salesAmount-sales.salesSalary-sales.salesCost}" />
					</div>

					<div class="item17 td"></div>
					<div class="item17 td">
						<a href="sales/update?id=<c:out value="${sales.id}" />"><input
							type="button" value="編集" /></a>
					</div>
					<div class="item17 td">
						<a href="sales/delete?id=<c:out value="${sales.id}" />"><input
							type="button" value="削除" /></a>
					</div>
				</div>
			</form>
		</c:forEach>


		<p></p>


		<p>
			<input type="button" value="画面印刷" /> <input type="button"
				value="画面出力" />



		</p>
		<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
		<script>
			$(document).ready(function() {
				$("[name=search]").change(function() {
					$(".disp").hide();
					if ($(this).val() == "") {
						$(".disp").show();
					} else {
						const selector = "." + $(this).val();
						$(selector).show();
					}
				});
			});

			$(document).ready(function() {
				$("[name=shop_nomination]").change(function() {
					$(".disp").hide();

					if ($(this).val() == "") {
						$(".disp").show();
					} else if ($(this).val() == "フリー") {

						$('[data-id="フリー"]').show();
					} else if ($(this).val() == "NET指名") {

						$('[data-id="NET指名"]').show();
					} else {
						$('[data-id="本指名"]').show();
					}

				});

			});
		</script>
	</div>
</body>
</html>