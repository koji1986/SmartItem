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
<title>割引情報</title>

</head>
<body>
<c:import url="nav.jsp" />
<div class="design04">
<div>
			<span style="font-weight:bold">絞り込み</span>
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
		</div>
<p></p>
	<div class="container">
		<div class="item6 th">店舗名</div>
		<div class="item6 th">割引名</div>
		<div class="item6 th">割引金額</div>

		<div class="item6 th">並び替え</div>
		<div class="item6 th">更新</div>
		<div class="item6 th">削除</div>
	</div>
	<c:forEach items="${discountList}" var="discount" varStatus="vs">
		<form action="" method="post" class="disp s<c:out value="${discount.shopInfId}" />">
			<input type="hidden" name="id"
				value="<c:out value="${discount.id}" />" />
			<div class="container">

				<div class="item6 td">

					<select name="shopInf_id">
						<c:forEach items="${shopInfList}" var="shop">

							<option value="<c:out value="${shop.id}" />"
								<c:out value="${shop.id == discount.shopInfId ? 'selected' : ''}" />>

								<c:out value="${shop.shopInfName}" /></option>
						</c:forEach>

					</select>
				</div>
				<div class="item6 td">
					<input type="text" name="discount_name"
						value="<c:out value="${discount.discountName}" />" />
				</div>
				<div class="item6 td">
					<input type="number" name="discount_fee"
						value="<c:out value="${discount.discountFee}" />" />
				</div>
				<div class="item6 td">
					<input type="number" name="discount_row"
						value="<c:out value="${discount.discountRow}" />" />
				</div>
				<div class="item6 td">
					<input type="submit" value="更新" name="update" />
				</div>
				<div class="item6 td">

					<input type="submit" value="削除" onclick="return confirm('本当に削除しますか?')" />
				</div>
			</div>
		</form>
	</c:forEach>
	<form action="" method="post">
			<input type="submit" name="new" value="新規入力"
				style="width: 8%; margin: 20px auto;" class="btn btn-danger" /> <input
				type="hidden" name="id" value="<c:out value="${course.id}" />" />

			<div class="container">

				<div class="item4 th">店舗名</div>
				<div class="item4 th">割引名</div>
				<div class="item4 th">割引金額</div>

				<div class="item4 th">並び替え</div>

			</div>
			<div class="container">


				<div class="item4 td">

					<select name="shopInf_id">
						<c:forEach items="${shopInfList}" var="shop">

							<option value="<c:out value="${shop.id}" />"
								<c:out value="${shop.id == discount.shopInfId ? 'selected' : ''}" />>
								<c:out value="${shop.shopInfName}" />
							</option>
						</c:forEach>

					</select>
				</div>
				<div class="item4 td">
					<div class="form">
						<input type="text" name="discount_name" required/>
					</div>
				</div>
				<div class="item4 td">
					<input type="number" name="discount_fee" required/>
				</div>
				
				<div class="item4 td">
					<input type="number" name="discount_row" value="100" />
				</div>




			</div>

		</form>
</div>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
	$(document)	.ready(function(){
		$("[name=search]").change(function(){
			$(".disp").hide();
			if($(this).val() == "") {
				$(".disp").show();
			}
			else {
				const selector = "." + $(this).val();
				$(selector).show();		
			}
		});
	});
	
	
	</script>

</body>
</html>