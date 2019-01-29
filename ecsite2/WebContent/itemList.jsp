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
<link rel="stylesheet" href="./css/home.css" />
<title>商品一覧画面</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="main">
		<div id="top">
			<p>在庫一覧</p>
		</div>
		<div>
			<s:if test="itemInfoDTOList == null">
				<h3>商品情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>商品情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>id</th>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫</th>
						<th>情報</th>
						<th>登録日</th>
						<th>更新日</th>
						<th>詳細</th>
						<th>編集</th>
					</tr>
					<s:iterator value="itemInfoDTOList">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="itemName" /></td>
							<td><s:property value="itemPrice" /><span>円</span></td>
							<td><s:property value="itemStock" /><span>個</span></td>
							<td><s:property value="itemInfo" /></td>
							<td><s:property value="insert_date" /></td>
							<td><s:property value="update_date" /></td>
							<td><a
								href='<s:url action="ItemInfoAction"><s:param name="id" value="%{id}" /></s:url>'>詳細</a></td>
							<td><a
								href='<s:url action="ItemUpdateAction"><s:param name="id" value="%{id}" /></s:url>'>編集</a></td>

						</tr>
					</s:iterator>
				</table>
				<s:form action="ItemListDeleteConfirmAction">
					<s:submit value="削除" />
				</s:form>
			</s:elseif>

			<div id="text-right">
				<p>
					管理者TOP画面へ戻る場合は<a href='<s:url action="AdminAction" />'>こちら</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
