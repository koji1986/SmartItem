<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>施術者更新</title>

</head>
<body>
	<form action="" method="post">

		<div>店舗A</div>
		<div>
			施術者ランク <select name="picRank_idA">
				<option value="1">達人</option>
				<option value="2">名人</option>


			</select>
		</div>
		<div>
			施術者名1 <input type="text" name="pic_nameA"
				value=<c:out value="${picNameA}" /> />
		</div>
		<div>
			ふりがな <input type="text" name="pic_kanaA"
				value=<c:out value="${picKanaA}" /> />
		</div>
		<div>店舗B</div>
		<div>
			施術者ランク <select name="picRank_idB">
				<option value="1">新人</option>
				<option value="2">ベテラン</option>


			</select>
		</div>
		<div>
			施術者名2 <input type="text" name="pic_nameB"
				value="<c:out value="${picNameB}" />" />
		</div>
		<div>
			ふりがな <input type="text" name="pic_kanaB"
				value="<c:out value="${picKanaB}" />" />
		</div>

		<div>
			電話番号 <input type="tel" name="pic_phone_number"
				value="<c:out value="${picPhoneNumber}" />" />
		</div>
		<div>
			メールアドレス <input type="email" name="pic_email"
				value="<c:out value="${picEmail}" />" />
		</div>
		<div>
			住所 <input type="text" name="pic_address"
				value="<c:out value="${picAddress}" />" />
		</div>
		<div>
			入店日 <input type="date" name="pic_entry_day"
				value="<fmt:formatDate value="${picEntryDay}" pattern="yyyy-MM-dd" />" />
		</div>
		<div>
			退店日 <input type="date" name="pic_out_day"
				value="<fmt:formatDate value="${picOutDay}" pattern="yyyy-MM-dd" />" />
		</div>
		<div>
			注意事項
			<textarea name="pic_memo" cols="30" rows="10"><c:out
					value="${picMemo}" /></textarea>
		</div>
		<div>
			<input type="submit" value="更新" />
		</div>

	</form>


</body>
</html>