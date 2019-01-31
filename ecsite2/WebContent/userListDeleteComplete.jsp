<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="./css/home.css">
<title>ユーザー削除完了画面</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="main">
		<div id="top">
			<p>ユーザー削除完了</p>
		</div>
		<div>
			<p>
				<s:property value="message" />
			</p>
			<div>
				<p>
					<a href='<s:url action="AdminAction" />'>管理者TOP画面へ戻る</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>