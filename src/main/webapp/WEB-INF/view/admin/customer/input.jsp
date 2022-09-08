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
	href="<%=request.getContextPath()%>/css/Input.css" />
<title>顧客情報入力</title>

</head>
<body class="cutomerInput">
<c:import url="../nav.jsp" />
<div class="design04">
	<form action="" method="post">
<div class="container">
		<div class="item th">
			会員NO <input type="text" name="customer_no" />
		</div>
		<div class="item th">
			会員名 <input type="text" name="customer_name" required/>
			
		</div>
		<div class="item th">
			ふりがな <input type="text" name="customer_kana" />
		</div>
		<div class="item th">
			電話番号1 <input type="tel" name="customer_phone_number1" />
		</div>
		<div class="item th">
			電話番号2 <input type="tel" name="customer_phone_number2" />
		</div>
		<div class="item th">
			電話番号3 <input type="tel" name="customer_phone_number3" />
		</div>
		<div class="item th">
			メールアドレス <input type="email" name="customer_email" />
		</div>
		<div class="item th">
			住所1 <input type="text" name="customer_address1" />
		</div>
		<div class="item th">
			住所2 <input type="text" name="customer_address2" />
		</div>

		<div class="item th">
			クレジットカード番号 <input type="text" name="customer_credit_number" />
		</div>
		<div class="item th">
			有効期限 <input type="text" name="customer_credit_date" />
		</div>
		<div class="item th">
			cvv <input type="number" name="customer_credit_cvv" />
		</div>
		<div class="item th">
			注意事項
			<textarea name="customer_memo" cols="30" rows="10"></textarea>
		</div>
		<div class="item th">
			<input type="submit" value="登録" />
		</div>

</div>
	</form>
</div>
</body>
</html>