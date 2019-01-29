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

<title>ChangePassword画面</title>

</head>
<body>
<jsp:include page="header.jsp"/>
	<div id="main">
		<div id="top">
			<p>パスワード変更</p>
		</div>

			<s:if test="errorMessage !=''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
			<s:form action="ChangePasswordConfirmAction">
				<tr>
					<td>
						<label>現在のPASSWORD</label>
					</td>
					<td>
					<input type="password" name="pass" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<label>新しいPASSWORD:</label>
				</td>
				<td>
					<input type="password" name="newPass1" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<label>新しいPASSWORD(確認)</label>
				</td>
				<td>
					<input type="password" name="newPass2" value=""/>
				</td>
			</tr>
			<s:submit value="登録"/>
		</s:form>
		</table>
		<div>
			<span>前画面に戻る場合は</span>
			<a href='<s:url action="MyPageAction"/>'>こちら</a>
		</div>
	</div>
<jsp:include page="footer.jsp"/>
	</body>
</html>