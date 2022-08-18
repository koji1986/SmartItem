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
<c:import url="nav.jsp" />
	<input type="date" name="salse_date" />
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





	<table border="1">
		<tr>
			<th>利用日時</th>
			<th>店舗名</th>
			<th>種別</th>
			<th>顧客名</th>
			<th>施術者名</th>
			<th>コース</th>
			
			<th>指名</th>
			
			<th>オプション</th>
		
			<th>支払</th>
			<th>売上</th>
			<th>交通費</th>
			<th>給与</th>
			<th>経費</th>
			<th>利益</th>
			<th>顧客情報</th>
			<th>売上編集</th>
		</tr>
		<c:forEach items="${salesList}" var="sales">
			<tr>
				<td><c:out value="${sales.salesDate}" /></td>
				
				<td><c:out value="${sales.shopInfName}" /></td>
				<td><c:out value="${sales.customerCategolyName}" /></td>
				<td><c:out value="${sales.customerName}" /></td>
				<td><c:out value="${sales.picName}" /></td>
				<td><c:out value="${sales.courseName}" /></td>
				<td><c:out value="${sales.salesNomination}" /></td>
				<td><c:out value="${sales.optionName}" /></td>
				<td><c:out value="${sales.salesPayment}" /></td>
				<td></td>
				<td><c:out value="${sales.salesCarfare}" /></td>
				<td><c:out value="${sales.salesSalary}" /></td>
				<td><c:out value="${sales.salesCost}" /></td>
				<td></td>
				
				<td></td>
				<td><a href="sales/update?id=<c:out value="${sales.id}" />"><input type="button" value="編集"  /></a></td>
			</tr>

		</c:forEach>



	</table>

	<p>
		<input type="button" value="画面印刷" /> <input type="button"
			value="画面出力" />



	</p>

</body>
</html>