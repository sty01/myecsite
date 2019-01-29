<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="./css/home.css">
<title>Home画面</title>

</head>
<body>
	<div id="header">

		<div id="pr">
			<a href='<s:url action="GoHomeAction"/>'>ECSITE</a>
		</div>
		<ul>
			<li><s:form action ="SearchAction"><input type="text" name="searchWord" value=""/><s:submit value="検索"/></s:form></li>
			<li><a href='<s:url action="HomeAction"/>'>商品一覧</a></li>
			<li><a href='<s:url action="LoginAction"/>'>ログイン</a></li>
			<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			<li><a href='<s:url action="MyPageAction"/>'>マイページ</a></li>
			<li><a href='<s:url action="GoCartAction"/>'>カート</a></li>
			<li><a href='<s:url action="UserCreateAction"/>'>新規登録</a></li>
			<li><a href='<s:url action="AdminAction"/>'>管理者</a></li>
		</ul>
	</div>

	<div id="login">
		<s:if test="#session.loginUser.loginId != null">
			ID:<s:property value="#session.loginUser.loginId" />でログイン中
		</s:if>
	</div>

	<s:debug />