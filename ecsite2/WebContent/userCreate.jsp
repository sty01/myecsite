<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar"content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" href="./css/home.css">

<title>UserCreate画面</title>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<div id="main">
		<div id="top">
			<p>UserCreate</p>
		</div>
			<s:if test="errorMessage !=''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
			<s:form action="UserCreateConfirmAction">
				<tr>
					<td>
						<label>ログインID:</label>
					</td>
					<td>
					<input type="text" name="loginUserId" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<label>ログインPASS:</label>
				</td>
				<td>
					<input type="text" name="loginPassword" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<label>ユーザー名:</label>
				</td>
				<td>
					<input type="text" name="userName" value=""/>
				</td>
			</tr>
					<input type="hidden" name="adminFlg" value="0"/>
			<s:submit value="登録"/>
		</s:form>
		</table>
		<div>
			<span>ホームに戻る場合は</span>
			<a href='<s:url action="GoHomeAction"/>'>こちら</a>
		</div>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>