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
<title>施術者入力</title>

</head>
<body>
	<c:import url="../nav.jsp" />
	<form action="" method="post">

		<div>店舗A</div>
		<div>
			施術者ランク <select name="picRank_idA">
				<c:forEach items="${picRankList}" var="rank">
					<option value="<c:out value="${rank.id}" />">
						<c:out value="${rank.picRankName}" /></option>
				</c:forEach>


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
			施術者ランク <select name="picRank_idB">
				<c:forEach items="${picRankList}" var="rank">
					<option value="<c:out value="${rank.id}" />">
						<c:out value="${rank.picRankName}" />
					</option>
				</c:forEach>

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