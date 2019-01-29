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
<title>Admin画面</title>


</head>
<body>
<jsp:include page="header.jsp"/>
	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div>
			<table>
				<tr>
					<th>商品</th>
					<th>ユーザー</th>
				</tr>

				<tr>
					<td><s:form action="ItemCreateAction">
							<s:submit value="新規作成" />
						</s:form></td>
					<td><s:form action="UserCreateAction">
							<s:submit value="新規作成" />
						</s:form></td>
				</tr>

				<tr>
					<td><s:form action="ItemListAction">
							<s:submit value="一覧" />
						</s:form></td>

					<td><s:form action="UserListAction">
							<s:submit value="一覧" />
						</s:form></td>
				</tr>
			</table>

		</div>
		<p>
			Homeへもどる場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a>
		</p>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>