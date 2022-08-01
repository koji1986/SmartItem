<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>経費更新</title>

</head>
<body>
	<form action="" method="post">
		<div>
			<input type="date" name="cost_name" />
		</div>
		<div>
			担当者 <select name="staff_name">
				<option value="1">店長</option>
				<option value="2">主任</option>
				<option value="3">課長</option>


			</select>
		</div>
		<div>
			店舗 <label> <input type="radio" name="shop_name" value="1" />A店
				<input type="radio" value="2" name="shop_name" />B店
			</label>
		</div>

		<div>
			支払先 <input type="text" name="cost_destination" />
		</div>

		<div>
			科目 <select name="cost_subject">
				<option value="1">交通費</option>
				<option value="2">消耗品費</option>
				<option value="3">備品日</option>
			</select>
		</div>

		<div>
			金額 <input type="number" name="cost_fee" />
		</div>
		<div>
			内容 <input type="text" name="cost_detail" />
		</div>
		<input type="submit" value="更新" />
	</form>



</body>
</html>