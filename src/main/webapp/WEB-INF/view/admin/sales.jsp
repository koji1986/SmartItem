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
			<th>名前1</th>
			<th>名前2</th>
			<th>ふりがな</th>
			<th>店名</th>
			<th>オプション</th>
			<th>指名</th>
			<th>支払</th>
			<th>売上</th>
			<th>交通費</th>
			<th>給与</th>
			<th>経費</th>
			<th>利益</th>
			<th>顧客情報</th>
			<th>売上編集</th>
		</tr>
		<c:forEach items="${salesList}" var="sales" >
		<tr>
			<td><c:out value="${sales.id}" /></td>
			<td><c:out value="${sales.salesDate}" /></td>
			<td><c:out value="${sales.salesTime}" /></td>
			<td><c:out value="${sales.shopInfId}" /></td>
			<td><c:out value="${sales.customerCategolyId}" /></td>
			<td><c:out value="${sales.customerId}" /></td>
			<td><c:out value="${sales.picId}" /></td>
			<td><c:out value="${sales.salesNomination}" /></td>
			<td><c:out value="${sales.salesPayment}" /></td>
			<td><c:out value="${sales.courseId}" /></td>
			<td><c:out value="${sales.optionId}" /></td>
			<td><c:out value="${sales.salesCarfare}" /></td>
			<td><c:out value="${sales.salesSalary}" /></td>
			<td><c:out value="${sales.salesCost}" /></td>
			<td><c:out value="${sales.adId}" /></td>
			<td><c:out value="${sales.adId}" /></td>
			<td><c:out value="${sales.discountId}" /></td>
			<td><c:out value="${sales.salesDiscountFee}" /></td>
			<td></td>
			<td></td>
		</tr>
		
		</c:forEach>



	</table>

	<p>
		<input type="button" value="画面印刷" /> <input type="button"
			value="画面出力" />



	</p>

</body>
</html>