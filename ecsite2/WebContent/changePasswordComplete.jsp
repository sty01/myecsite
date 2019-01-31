<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/jacascript"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" href="./css/home.css">

<title>ChangePasswordComplete画面</title>

	</head>
	<body>
	<jsp:include page="header.jsp"/>
		<div id="main">
			<div id="top">
				<p>ChangePasswordComplete</p>
			</div>
			<div>
				<h3>パスワードの変更が完了致しました</h3>
				<div>
					<a href='<s:url action="MyPageAction"/>'>マイページへ</a></div>
				</div>
			</div>
			<jsp:include page="footer.jsp"/>
		</body>
	</html>
