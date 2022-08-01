<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>顧客情報更新</title>

</head>
<body>
	<form action="" method="post">

		<div>
			会員NO <input type="text" name="customer_no" />
		</div>
		<div>
			会員名 <input type="text" name="customer_name" />
		</div>
		<div>
			ふりがな <input type="text" name="customer_kana" />
		</div>
		<div>
			電話番号1 <input type="tel" name="customer_phone_number1" />
		</div>
		<div>
			電話番号2 <input type="tel" name="customer_phone_number2" />
		</div>
		<div>
			電話番号3 <input type="tel" name="customer_phone_number3" />
		</div>
		<div>
			メールアドレス <input type="email" name="customer_email" />
		</div>
		<div>
			住所1 <input type="text" name="customer_address1" />
		</div>
		<div>
			住所2 <input type="text" name="customer_address2" />
		</div>

		<div>
			クレジットカード番号 <input type="text" name="credit_number" />
		</div>
		<div>
			有効期限 <input type="text" name="customer_date" />
		</div>
		<div>
			cvv <input type="number" name="customer_credit_cvv" />
		</div>
		<div>
			注意事項
			<textarea name="customer_memo" cols="30" rows="10"></textarea>
		</div>
		<div>
			<input type="submit" value="更新" />
		</div>


	</form>
</body>
</html>