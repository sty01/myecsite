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
<link rel="stylesheet" href="./css/home.css">
<title>MyPage画面</title>

</head>

<body>
	<jsp:include page="header.jsp"/>
	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>
		<div>


			<h3>
				<s:property value="#session.loginUser.userName" />
				さんの登録情報
			</h3>


			<table border="1">
				<tr>
					<th>ログインID</th>
					<th>パスワード</th>
					<th>ユーザー名</th>
					<th>管理者情報</th>
					<th>登録日</th>
					<th>更新日</th>
				</tr>
				<tr>
					<td><s:property value="#session.loginUser.loginId" /></td>
					<td><s:property value="#session.loginUser.loginPassword" /></td>
					<td><s:property value="#session.loginUser.userName" /></td>
					<td><s:property value="#session.loginUser.adminFlg" /></td>
					<td><s:property value="#session.loginUser.insertDate" /></td>
					<td><s:property value="myUserInfoList[6]" /></td>
				</tr>

			</table>

			<p>
				パスワードを変更する場合は<a href='<s:url action="ChangePasswordAction"/>'>こちら</a>
			</p>

			<s:if test="myPageList == null">
				<h3>ご購入情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>購入情報</h3>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>購入個数</th>
						<th>支払い方法</th>
						<th>購入日</th>
					</tr>
					<s:iterator value="myPageList">
						<tr>
							<td><s:property value="itemName" /></td>
							<td><s:property value="totalPrice" /><span>円</span></td>
							<td><s:property value="totalCount" /><span>個</span></td>
							<td><s:property value="payment" /></td>
							<td><s:property value="insert_date" /></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="MyPageAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="削除" method="delete" />
				</s:form>
			</s:elseif>
			<s:if test="message != null">
				<h3>
					<s:property value="message" />
				</h3>
			</s:if>

			<div id="text-right">
				<p>
					Homeへもどる場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a>
				</p>
				<p>
					ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a>
				</p>

			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>

