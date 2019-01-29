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

<title>ItemUpdate画面</title>

</head>
<body>

	<jsp:include page="header.jsp" />

	<div id="main">
		<div id="top">
			<p>ItemUpdate</p>
		</div>
		<s:if test="errorMessage !=''">
			<s:property value="errorMessage" escape="false" />
		</s:if>

		<table border="1">
			<s:form action="ItemUpdateConfirmAction">

				<h3>
					商品ID：
					<s:property value="id" />

					の情報を変更します。
				</h3>

				<tr>
					<td><label>商品ID</label></td>
					<td><s:property value="id" /> <s:hidden name="id"
							value="%{id}" /></td>

				</tr>

				<tr>
					<td><label>商品名</label></td>
					<td><input type="text" name="itemName"
						value="<s:property value="itemName"/>" /></td>

				</tr>
				<tr>
					<td><label>値段</label></td>
					<td><input type="text" name="itemPrice"
						value="<s:property value="itemPrice"/>" /> 円</td>

				</tr>
				<tr>
					<td><label>在庫</label></td>
					<td><input type="text" name="itemStock"
						value="<s:property value="itemStock"/>" /> 個</td>
				</tr>
				<tr>
					<td><label>詳細</label></td>
					<td><textarea name="itemInfo" cols="20" rows="8"><s:property value="itemInfo" /></textarea></td>
				</tr>
				<s:submit value="登録" />
			</s:form>
		</table>
		<div>
			<span>ホームに戻る場合は</span> <a href='<s:url action="GoHomeAction"/>'>こちら</a>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>