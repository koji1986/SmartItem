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
<title>施術者更新</title>

</head>
<body class="picUpdate">
	<c:import url="../nav.jsp" />
	<div class="design04">
		<form action="" method="post">
			<div class="container">
				<div class="item th">店舗A</div>
				<div class="item th">
					施術者ランク <select name="picRank_idA">

						<c:forEach items="${picRankList}" var="rank">

							<option value="<c:out value="${rank.id}" />"
								<c:out value="${rank.id == picRankIdA ? 'selected' : ''}" />>
								<c:out value="${rank.picRankName}" /></option>
						</c:forEach>



					</select>
				</div>
				<div class="item th">
					施術者名1 <input type="text" name="pic_nameA"
						value=<c:out value="${picNameA}" /> />
						<c:if test="${not empty picNameAError}">
					<p>
						※
						<c:out value="${picNameAError}" />
					</p>
				</c:if>
				</div>
				<div class="item th">
					ふりがな <input type="text" name="pic_kanaA"
						value="<c:out value="${picKanaA}" />" />
				</div>
				<div class="item th">店舗B</div>
				<div class="item th">
					施術者ランク <select name="picRank_idB">
						<c:forEach items="${picRankList}" var="rank">
							<option value="<c:out value="${rank.id}" />"
								<c:out value="${rank.id == picRankIdB ? 'selected' : ''}" />>
								<c:out value="${rank.picRankName}" />


							</option>
						</c:forEach>



					</select>
				</div>
				<div class="item th">
					施術者名2 <input type="text" name="pic_nameB"
						value="<c:out value="${picNameB}" />" />
				</div>
				<div class="item th">
					ふりがな <input type="text" name="pic_kanaB"
						value="<c:out value="${picKanaB}" />" />
				</div>

				<div class="item th">
					電話番号 <input type="tel" name="pic_phone_number"
						value="<c:out value="${picPhoneNumber}" />" />
				</div>
				<div class="item th">
					メールアドレス <input type="email" name="pic_email"
						value="<c:out value="${picEmail}" />" />
				</div>
				<div class="item th">
					住所 <input type="text" name="pic_address"
						value="<c:out value="${picAddress}" />" />
				</div>
				<div class="item th">
					入店日 <input type="date" name="pic_entry_day"
						value="<fmt:formatDate value="${picEntryDay}" pattern="yyyy-MM-dd" />" />
				<c:if test="${not empty entryDayError}">
					<p>
						※
						<c:out value="${entryDayError}" />
					</p>
				</c:if>
				</div>
				<div class="item th">
					退店日 <input type="date" name="pic_out_day"
						value="<fmt:formatDate value="${picOutDay}" pattern="yyyy-MM-dd" />" />
				</div>
				<div class="item th">
					注意事項
					<textarea name="pic_memo" cols="30" rows="10"><c:out
							value="${picMemo}" /></textarea>
				</div>
				<div class="item th">
					<input type="submit" value="更新" />
				</div>
			</div>
		</form>
	</div>

</body>
</html>