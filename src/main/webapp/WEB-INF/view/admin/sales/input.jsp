<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>売上入力</title>

</head>
<body>

	<form action="" method="post">

		<div>
			<input type="date" name="salse_date" />
		</div>
		<div>
			<input type="time" name="salse_time" />
		</div>
		<div>
			<label>店舗 <input type="radio" name="shopInf_name" value="1" />A店
				<input type="radio" name="shopInf_name" value="2" />B店
			</label>
		</div>

		<div>
			顧客種別 <label> <input type="radio"
				name="customerCategoly_name" value="1" />新規 <input type="radio"
				name="customerCategoly_name" value="2" />会員

			</label>
		</div>


		<div>
			顧客名 <input type="text" name="customer_name" placeholder="顧客名" />
		</div>
		<div>
			<select name="pic_name">
				<option value="1">太郎</option>
				<option value="2">次郎</option>
				<option value="3">三郎</option>


			</select>
		</div>

		<div>
			指名 <label> <input type="radio" name="sales_nomination"
				value="1" />フリー <input type="radio" name="sales_nomination"
				value="2" />NET指名 <input type="radio" name="sales_nomination"
				value="3" />本指名


			</label>
		</div>

		<div>
			支払方法 <label> <input type="radio" name="sales_payment"
				value="1" />現金 <input type="radio" name="sales_payment" value="2" />クレジットカード
				<input type="radio" name="sales_payment" value="3" />その他
			</label>
		</div>


		<div>
			コース <select name="course_name">
				<option value="1">60分</option>
				<option value="2">70分</option>
				<option value="3">80分</option>


			</select>
		</div>

		<div>
			オプション <select name="option_name">
				<option value="1">肩</option>
				<option value="2">腰</option>
				<option value="3">首</option>


			</select>
		</div>

		<div>
			担当者 <select name="staff_name">
				<option value="1">店長</option>
				<option value="2">主任</option>
				<option value="3">課長</option>


			</select>

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
			広告媒体 <select name="ad_name">
				<option value="1">なし</option>
				<option value="2">HP</option>
				<option value="3">新聞</option>


			</select>
		</div>


		<div>
			割引名 <select name="discount_name">
				<option value="1">500円割引</option>
				<option value="2">600円割引</option>
				<option value="3">700円割引</option>


			</select>
		</div>

		<div>
			割引額 <input type="number" name="sales_discount_fee" />
		</div>
		<input type="submit" value="登録" />



	</form>


</body>
</html>