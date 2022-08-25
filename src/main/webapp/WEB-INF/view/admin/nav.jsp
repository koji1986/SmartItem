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
<title>ナビゲーション</title>

</head>
<body>
<!--  NAVの階層「/SmartItem/admin/nav.jsp」 -->
	
   <nav class="navbar navbar-expand-sm navbar-dark bg-success mt-3 mb-3">
	<div class="container">
            <a class="navbar-brand bg-white text-success">ナビゲーション</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link active" href="/SmartItem/admin/cash">
                            <span class="fw-bold ">
                                レジ</span></a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdownMenuLink" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            売上
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="/SmartItem/admin/sales">売上一覧</a>
                            <a class="dropdown-item" href="/SmartItem/admin/sales/input">売上入力</a>
                        </div>
                    </li>


                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdownMenuLink" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            日報
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">A店</a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="/SmartItem/admin/reportA">売上日報</a>
                                <a class="dropdown-item" href="/SmartItem/admin/useReportA">施術者日報</a>
                                <a class="dropdown-item" href="/SmartItem/admin/costA">経費日報</a>
                            </div>


                            <a class="dropdown-item dropdown-toggle active" href="#" id="navbarDropdownMenuLink"
                                role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">B店</a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">売上日報</a>
                                <a class="dropdown-item" href="#">施術者日報</a>
                                <a class="dropdown-item" href="#">経費日報</a>
                            </div>

                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdownMenuLink" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            情報
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="/SmartItem/admin/customer">顧客情報</a>
                            <a class="dropdown-item" href="/SmartItem/admin/pic">施術者情報</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdownMenuLink" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            マスタ
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="/SmartItem/admin/course">コース情報</a>
                            <a class="dropdown-item" href="/SmartItem/admin/option">オプション情報</a>
                            <a class="dropdown-item" href="/SmartItem/admin/ad">広告媒体情報</a>
                            <a class="dropdown-item" href="/SmartItem/admin/discount">割引情報</a>
                            <a class="dropdown-item" href="/SmartItem/admin/discount">従業員情報</a>
                        </div>
                    </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdownMenuLink" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ユーザー名
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="/SmartItem/admin/sales">ログアウト</a>
                            <a class="dropdown-item" href="/SmartItem/admin/sales/input">登録情報変更</a>
                        </div>
                    </li>
                    
                </ul>
            </div>
        </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
           ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
           ></script>
	


</body>
</html>