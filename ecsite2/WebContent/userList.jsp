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
	<title>登録者一覧画面</title>
	<link rel="stylesheet" href="./css/home.css"/>


	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div id="main">
			<div id="top">
				<p>登録者一覧</p>
			</div>
			<div>
				<s:if test="userInfoDTOList == null">
					<h3>ユーザー情報はありません。</h3>
				</s:if>
				<s:elseif test="message == null">
					<h3>ユーザー情報は以下になります。</h3>
					<table border="1">
						<tr>
							<th>id</th>
							<th>ユーザーID</th>
							<th>ユーザー名</th>
							<th>パスワード</th>
							<th>登録日</th>
							<th>更新日</th>
						</tr>
						<s:iterator value="userInfoDTOList">
							<tr>
								<td><s:property value="Id" /></td>
								<td><s:property value="LoginId" /></td>
								<td><s:property value="LoginPassword" /></td>
								<td><s:property value="UserName" /></td>
								<td><s:property value="Insert_date" /></td>
								<td><s:property value="Update_date" /></td>
							</tr>
						</s:iterator>
					</table>
					<s:form action="UserListDeleteConfirmAction">
						<s:submit value="削除" />
					</s:form>
				</s:elseif>

				<div id="text-right">
					<p>管理者TOP画面へ戻る場合は<a href='<s:url action="AdminAction" />'>こちら</a></p>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
