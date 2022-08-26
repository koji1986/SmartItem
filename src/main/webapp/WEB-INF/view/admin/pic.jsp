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
	href="<%=request.getContextPath()%>/css/table.css" />
<title>施術者情報</title>

</head>
<body>
	<c:import url="nav.jsp" />
	<div class="design04">
        <p></p>
        <div>
            <a href="pic/input"> <input type="button" value="新規施術者情報入力" /></a>
        </div>
        <p></p>
        <div>
            <label><input type="radio" name="pic_existence" value="1" />在籍者</label>
            <label><input type="radio" name="pic_existence" value="2" />退店者</label>

        </div>
        <p> </p>
        <div>
            <input type="button" value="絞り込み" />
        </div>
        <p></p>
        <div>
            <input type="text" />
        </div>
        <p></p>


        <div class="container">
            <div class="item8 th">入店日</div>
            <div class="item8 th">ランク</div>
            <div class="item8 th">名前1</div>
            <div class="item8 th">名前2</div>
            <div class="item8 th">ふりがな</div>
            <div class="item8 th">退店日</div>
            <div class="item8 th">詳細</div>
            <div class="item8 th">削除</div>
        </div>

        <c:forEach items="${picList}" var="pic">

            <form action="" method="post">
                <input type="hidden" name="id" value="<c:out value=" ${pic.id}" />" />
                <div class="container">
                    <div class="item8 td">

                        <c:out value="${pic.picEntryDay}" />
                    </div>
                    <div class="item8 td">

                        <c:out value="${pic.picRankName}" />
                    </div>
                    <div class="item8 td">

                        <c:out value="${pic.picNameA}" />
                    </div>
                    <div class="item8 td">

                        <c:out value="${pic.picNameB}" />
                    </div>
                    <div class="item8 td">

                        <c:out value="${pic.picKanaA}" />
                    </div>
                    <div class="item8 td">

                        <c:out value="${pic.picOutDay}" />
                    </div>
                    <div class="item8 td">

                        <a href="pic/update?id=<c:out value=" ${pic.id}" />"><input type="button" value="詳細" /></a>
                    </div>
                    <div class="item8 td">
                        <input type="submit" value="削除" />
                    </div>
                </div>
            </form>
        </c:forEach>


    </div>



</body>
</html>