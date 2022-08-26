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
			<div class="container">
			
				<div class="item17 td moji80"> <fmt:formatDate pattern="yy/MM/dd hh:mm" value="${sales.salesDate}" /></div>

				<div class="item17 td"><c:out value="${sales.shopInfName}" /></div>
				<div class="item17 td"><c:out value="${sales.customerCategolyName}" /></div>
				<div class="item17 td"><c:out value="${sales.customerName}" /></div>
				<div class="item17 td"><c:out value="${sales.picName}" /></div>
				<div class="item17 td moji80"><c:out value="${sales.courseName}" /></div>
				<div class="item17 td"><c:out value="${sales.salesNomination}" /></div>
				<div class="item17 td"><c:out value="${sales.optionName}" /></div>
				<div class="item17 td"><c:out value="${sales.salesPayment}" /></div>
				<div class="item17 td"><c:out value="${sales.salesAmount}" /></div>
				<div class="item17 td"><c:out value="${sales.salesCarfare}" /></div>
				<div class="item17 td"><c:out value="${sales.salesSalary}" /></div>
				<div class="item17 td"><c:out value="${sales.salesCost}" /></div>
				<div class="item17 td"><c:out
						value="${sales.salesAmount-sales.salesSalary-sales.salesCost}" /></div>

				<div class="item17 td"></div>
				<div class="item17 td"><a href="sales/update?id=<c:out value="${sales.id}" />"><input
						type="button" value="編集" /></a></div>
			<div class="item17 td"><a href="sales/delete?id=<c:out value="${sales.id}" />"><input type="button" value="削除" /></a></div>
			</div>

		</c:forEach>


<p></p>
	

	<p>
		<input type="button" value="画面印刷" /> <input type="button"
			value="画面出力" />



	</p>
</div>
</body>
</html>