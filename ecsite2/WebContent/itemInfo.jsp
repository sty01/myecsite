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
<link rel="stylesheet" href="./css/itemInfo.css">

<title>ItemInfo画面</title>

</head>

<body>
	<jsp:include page="/header.jsp" />
	<div id="main">
		<div id="top">
			<p>商品情報</p>
		</div>
		<div>
		<img src='images/<s:property value="buyItemDTO.itemName"/>.jpg' />
			<table border="1">
				<tr>
					<th>商品名</th>
					<td><s:property value="buyItemDTO.itemName" /></td>
				</tr>
				<tr>
					<th>値段</th>
					<td><s:property value="buyItemDTO.itemPrice" /><span>円</span></td>
				</tr>
				<tr>
					<th>在庫</th>
					<td><s:property value="buyItemDTO.itemStock" /><span>個</span></td>
				</tr>
				<tr>
					<th>説明</th>
					<td><s:property value="buyItemDTO.itemInfo" /></td>
				</tr>
			</table>
		</div>
		<div id="buyItem">
			商品一覧へもどる場合は<a href='<s:url action="HomeAction"/>'>こちら</a>
		</div>
	</div>

	<jsp:include page="/footer.jsp" />
</body>
</html>