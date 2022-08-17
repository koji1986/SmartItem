<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>売上更新</title>

</head>
<body>



	<form action="" method="post">

		<div>
			<input type="date" name="sales_date" value="<fmt:formatDate value="${salesDate}" pattern="yyyy-MM-dd" />"/>
		</div>
		<div>
			<input type="time" name="sales_time" value="<fmt:formatDate value="${salesTime}" pattern="HH:mm" />" />
		</div>
		<div>
			店舗 <label><input type="radio" name="shopInf_id" value="1"  />A店</label>
				<label><input type="radio" name="shopInf_id" value="2" />B店</label>
			
		</div>

		<div>
			顧客種別 <label> <input type="radio" name="customerCategoly_id"
				value="1" />新規 <input type="radio" name="customerCategoly_id"
				value="2" />会員

			</label>
		</div>


		<div>
			顧客名 <input type="number" name="customer_id" placeholder="顧客名" />
		</div>
		<div>施術者
			<select name="pic_id">
				<c:forEach items="${picList}" var="p" >
				<option value="1" <c:out value="${p.id == pic.picId ? 'selected' : ''}" />>太郎</option>		

				</c:forEach>

			</select>
		</div>

		<div>
			指名
			 <label> <input type="radio" name="sales_nomination"value="フリー" />フリー</label>
			 <label><input type="radio" name="sales_nomination"value="NET指名" />NET指名</label>
			<label> <input type="radio" name="sales_nomination"value="本指名" />本指名</label>


			
		</div>

		<div>
			支払方法 
			<label> <input type="radio" name="sales_payment"value="現金" />現金</label> 
			<label><input type="radio" name="sales_payment" value="クレジットカード" />クレジットカード</label>
			<label><input type="radio" name="sales_payment" value="その他" />その他</label>
		</div>


		<div>
			コース <select name="course_id">
				<option value="1">60分</option>
				<option value="2">70分</option>
				<option value="3">80分</option>


			</select>
		</div>

		<div>
			オプション <select name="option_id">
				<option value="1">肩</option>
				<option value="2">腰</option>
				<option value="3">首</option>


			</select>
		</div>

		<div>
			担当者 <select name="staff_id">
				<option value="1">店長</option>
				<option value="2">主任</option>
				<option value="3">課長</option>


			</select>

		</div>


		<div>
			交通費 <input type="number" name="sales_carfare" value="<c:out value="${salesCarfare}" />" />
		</div>

		<div>
			給与 <input type="number" name="sales_salary" value="<c:out value="${salesSalary}" />" />
		</div>
		<div>
			経費 <input type="number" name="sales_cost" value="<c:out value="${salesCost}" />" />
		</div>

		<div>
			広告媒体 <select name="ad_id">
				<option value="1">なし</option>
				<option value="2">HP</option>
				<option value="3">新聞</option>


			</select>
		</div>


		<div>
			割引名 <select name="discount_id">
				<option value="1">500円割引</option>
				<option value="2">600円割引</option>
				<option value="3">700円割引</option>


			</select>
		</div>

		<div>
			割引額 <input type="number" name="sales_discount_fee" value="<c:out value="${salesDiscountFee}" />"/>
		</div>
		<input type="submit" value="更新" />



	</form>

  



</body>
</html>