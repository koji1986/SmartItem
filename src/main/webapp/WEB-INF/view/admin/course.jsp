<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>コース情報</title>

</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<td>店舗名</td>
				<td>コース名</td>
				<td>金額</td>
				<td>時間（分）</td>
				<td>並び替え</td>
				<td>削除</td>
			</tr>

			<tr>
				<td><select name="shopInf_name">
						<option value="1">A店舗</option>
						<option value="2">B店舗</option>
				</select></td>
				<td><input type="text" name="course_name" /></td>
				<td><input type="number" name="course_fee" /></td>
				<td><input type="number" name="course_time" /></td>
				<td><input type="number" name="course_row" /></td>
				<td><input type="button" value="削除" /></td>
			</tr>
			<tr>
				<td><select name="shopInf_name">
						<option value="1">A店舗</option>
						<option value="2">B店舗</option>
				</select></td>
				<td><input type="text" name="course_name" /></td>
				<td><input type="number" name="course_fee" /></td>
				<td><input type="number" name="course_time" /></td>
				<td><input type="number" name="course_row" /></td>
				<td><input type="button" value="削除" /></td>
			</tr>
			<tr>
				<td><select name="shopInf_name">
						<option value="1">A店舗</option>
						<option value="2">B店舗</option>
				</select></td>
				<td><input type="text" name="course_name" /></td>
				<td><input type="number" name="course_fee" /></td>
				<td><input type="number" name="course_time" /></td>
				<td><input type="number" name="course_row" /></td>
				<td><input type="button" value="削除" /></td>
			</tr>



		</table>

		<div>
			<input type="submit" value="更新" />
		</div>
	</form>
</body>
</html>