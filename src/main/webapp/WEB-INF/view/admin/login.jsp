<!DOCTYPE html>
<html lang="ja">
<head>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/signin.css">
  <link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<title>ログイン画面</title>

</head>
<body class="login">
	 <div class="form-signin">
	 <form  method="post">

    <h1 class="h3 mb-3 font-weight-normal">ログイン</h1>
      <c:if test="${not empty error}">
					<p>
						※
						<c:out value="${error}" />
					</p>
				</c:if>
    
    <label for="inputEmail" class="sr-only">ログインID</label>
    <input type="text"  name="login_id" class="form-control" placeholder="ID" >
    <c:if test="${not empty loginIdError}">
					<p>
						※
						<c:out value="${loginIdError}" />
					</p>
				</c:if>
    <label for="inputPassword" class="sr-only">パスワード</label>
    <input type="password"  name="login_pass" class="form-control" placeholder="パスワード" >
    <c:if test="${not empty loginPassError}">
					<p>
						※
						<c:out value="${loginPassError}" />
					</p>
				</c:if>
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> パスワードを記憶しますか？
      </label>
    </div>
    <input class="btn btn-lg btn-primary btn-block" type="submit" value="ログイン" />
     </form>
     <p></p>
    <a href="accountCreate"><button class="btn btn-lg btn-danger btn-block">新規アカウント登録</button></a>
</div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

	
	
	 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>