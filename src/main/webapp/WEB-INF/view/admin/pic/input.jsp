<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>施術者入力</title>

</head>
<body>

	<form action="" method="post">

		<div>店舗A</div>
		<div>
			施術者ランク <select name="picRank_nameA">
				<option value="1">達人</option>
				<option value="2">名人</option>


			</select>
		</div>
		<div>
			施術者名1 <input type="text" name="pic_nameA" />
		</div>
		<div>
			ふりがな <input type="text" name="pic_kanaA" />
		</div>
		<div>店舗B</div>
		<div>
			施術者ランク <select name="picRank_nameB">
				<option value="1">新人</option>
				<option value="2">ベテラン</option>


			</select>
		</div>
		<div>
			施術者名2 <input type="text" name="pic_nameB" />
		</div>
		<div>
			ふりがな <input type="text" name="pic_kanaB" />
		</div>

		<div>
			電話番号 <input type="tel" name="pic_phone_number" />
		</div>
		<div>
			メールアドレス <input type="email" name="pic_email" />
		</div>
		<div>
			住所 <input type="text" name="pic_address" />
		</div>
		<div>
			入店日 <input type="date" name="pic_entry_day" />
		</div>
		<div>
			退店日 <input type="date" name="pic_out_day" />
		</div>
		<div>
			注意事項
			<textarea name="pic_memo" cols="30" rows="10"></textarea>
		</div>
		<div>
			<input type="submit" value="登録" />
		</div>

	</form>

</body>
</html>