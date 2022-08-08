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
				<td>更新</td>
				<td>削除</td>
			</tr>

			<c:forEach items="${courseList}" var="course">
				<tr>
					<td><select name="shopInf_id">
							<option value="1">A店舗</option>
							<option value="2">B店舗</option>
					</select></td>
					<td><input type="text" name="course_name"
						value="<c:out value="${course.courseName}" />" /></td>
					<td><input type="number" name="course_fee"
						value="<c:out value="${course.courseFee}" />" /></td>
					<td><input type="number" name="course_time"
						value="<c:out value="${course.courseTime}" />" /></td>
					<td><input type="number" name="course_row"
						value="<c:out value="${course.courseRow}" />" /></td>
					<td><input type="submit" name="update" value="更新"> <input
						type="hidden" name="id" value="<c:out value="${course.id}" />"></td>
					<td><input type="submit" name="delete" value="削除"></td>



				</tr>
			</c:forEach>



		</table>
	</form>
	<div>
		<input type="submit" value="更新" />
	</div>
</body>
</html>