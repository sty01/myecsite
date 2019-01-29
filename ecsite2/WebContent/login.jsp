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
<meta name="description" content="no" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="./css/home.css" />
<title>Login画面</title>

</head>
<body>

	<jsp:include page="header.jsp" />
	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>
		<div>
			<h3>ログインしてください</h3>
			<s:form action="LoginAction">
				<table>

					<tr>
						<td><label>ログインID:</label></td>
						<td><s:textfield name="loginUserId" /></td>
					<tr>
						<td><label>PASSWORD:</label></td>
						<td><s:password name="loginPassword" /></td>
				</table>

				<s:submit value="ログイン" />
			</s:form>

			<div id="text-link">
				<p>
					新規ユーザー登録は <a href='<s:url action="UserCreateAction"/>'>こちら</a>
				</p>
				<p>
					Homeへ戻る場合は <a href='<s:url action="GoHomeAction"/>'>こちら</a>
				</p>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>