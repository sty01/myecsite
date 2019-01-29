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
<title>ItemUpdateConfirm画面</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="main">
		<div id="top">
			<p>ItemUpdateConfirm</p>
		</div>
		<div>
			<h3>変更する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="ItemUpdateCompleteAction">

					<tr id="box">
						<td><label>商品ID:</label></td>
						<s:hidden name="id" value="%{id}" />
						<td><s:property value="id" escape="false" /></td>
					</tr>

					<tr id="box">
						<td><label>商品名</label></td>
						<s:if test="itemName ==''">
							<td>変更なし</td>
						</s:if>
						<s:else>
							<td><s:property value="itemName" escape="false" /></td>
						</s:else>
					</tr>

					<tr id="box">
						<td><label>値段</label></td>
						<s:if test="itemPrice ==''">
							<td>変更なし</td>
						</s:if>
						<s:else>
							<td><s:property value="itemPrice" escape="false" /></td>
						</s:else>
					</tr>

					<tr id="box">
						<td><label>在庫</label></td>
						<s:if test="itemStock ==''">
							<td>変更なし</td>
						</s:if>
						<s:else>
							<td><s:property value="itemStock" escape="false" /></td>
						</s:else>
					</tr>

					<tr id="box">
						<td><label>詳細</label></td>
						<s:if test="itemInfo ==''">
							<td>変更なし</td>
						</s:if>
						<s:else>
							<td><s:property value="itemInfo" escape="false" /></td>
						</s:else>
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