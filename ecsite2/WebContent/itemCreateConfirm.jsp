<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="./css/home.css" />
<title>ItemCreateConfirm画面</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="main">
		<div id="top">
			<p>ItemCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="ItemCreateCompleteAction">
					<tr id="box">
						<td><label>商品名</label></td>
						<td><s:property value="itemName" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>値段</label></td>
						<td><s:property value="ItemPrice" escape="false" /> 円</td>
					</tr>
					<tr id="box">
						<td><label>在庫</label></td>
						<td><s:property value="ItemStock" escape="false" /> 個</td>
					</tr>
					<tr id="box">
						<td><label>詳細</label></td>
						<td><s:property value="ItemInfo" escape="false" /></td>
					</tr>
					<tr>
						<td><s:submit value="完了" /></td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>