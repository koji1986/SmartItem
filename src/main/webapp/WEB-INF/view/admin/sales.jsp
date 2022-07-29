<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>売上一覧</title>

</head>
<body>

	<input type="date" name="salse_date"  />
	<label> <input type="radio" name="shop_name" value="1" />A店 <input
		type="radio" name="shop_name" value="2" />B店

	</label>

	<label> <input type="radio" name="shop_nomination" value="1" />フリー
		<input type="radio" name="shop_nomination" value="2" />NET指名 <input
		type="radio" name="shop_nomination" value="3" />NET指名

	</label>
	<select name="pic_name">
		<option value="1">田中</option>
		<option value="2">鈴木</option>
		<option value="3">佐藤</option>


	</select>

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




	<input type="text" />

</body>
</html>