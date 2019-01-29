<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />

<meta name="description" content="" />
<meta name="keywords" content="" />

<meta charset="utf-8">
<link rel="stylesheet" href="./css/home.css">

<title>BuyItemComplete画面</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="main">
	<div id="top">
		<p>BuyItemComplete</p>
	</div>
	<div>
		<p>購入手続きが完了致しました。</p>
		<div>
			<a
				href='<s:url action="MyPageAction"><s:param
				 name="userMasterid" value="%{userMasterId}"/><s:param name="loginUserid" value="%{userMasterId}"/><s:param
				 name="loginUserId" value="loginUserId"/></s:url>'>
				マイページ </a> <span>から購入履歴の確認が可能です。</span>
			<p>
				Homeへもどる場合は<a
					href='<s:url action="GoHomeAction"><s:param name="userMastereId" value="%{userMasterId}"/><s:param
				 name="loginUserId" value="%{loginUserId}"/></s:url>'>
					こちら </a>
			</p>
		</div>
	</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>