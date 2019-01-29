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
<title>Cart画面</title>

</head>

<body>
	<jsp:include page="header.jsp" />
	<div id="main">
		<div id="top">
			<p>Cart</p>
		</div>
		<s:if test="message != null">
			<h3>
				<s:property value="message" />
			</h3>
		</s:if>
		<div>
			<h3>
				ID:
				<s:property value="#session.login_user_id" />
				さんのカート
			</h3>

			<s:if test="cartList == null">
				<h3>ご購入情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>購入情報</h3>

				<s:form action="BuyItemAction">
					<table border="1">
						<tr>
							<th>カートID</th>
							<th>商品ID</th>
							<th>商品名</th>
							<th>値段</th>
							<th>購入個数</th>
							<th>小計</th>
							<th>支払い方法</th>
							<th>追加日</th>
						</tr>

						<s:iterator value="cartList">
							<tr>
								<td><s:property value="cartId" /> <s:hidden value="cartId" /></td>

								<td><s:property value="id" /> <s:hidden value="id" /></td>

								<td><s:property value="itemName" /> <s:hidden
										value="itemName" /></td>

								<td><s:property value="itemPrice" /><span>円</span> <s:hidden
										value="itemPrice" /></td>

								<td><s:property value="itemCount" /><span>個</span> <s:hidden
										value="itemCount" /></td>

								<td><s:property value="subtotal" /><span>円</span> <s:hidden
										value="itemTotal" /></td>

								<td><s:property value="pay" /> <s:hidden value="pay" /></td>

								<td><s:property value="insert_date" /></td>
							</tr>
						</s:iterator>

					</table>

							<h3>合計：<s:property value="totalPrice" />円</h3>
							<s:hidden value="totalPrice" />
					<s:submit value="購入" />
				</s:form>

				<s:form action="CartDeleteAction">
					<s:submit value="削除" />
				</s:form>

			</s:elseif>

			<div id="text-right">
				<p>
					商品一覧へ<a href='<s:url action="Home"/>'>こちら</a>
				</p>
				<p>
					ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a>
				</p>

			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>

