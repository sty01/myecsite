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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>削除確認画面</title>
<link rel="stylesheet" href="./css/home.css"/>

<script type="text/javascript">
			function submitAction(url) {
				$('form').attr('action', url);
				$('form').submit();
			}
		</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="main">
		<div id="top">
			<p>削除確認</p>
		</div>
		<div>
			<h3>本当にすべてのユーザーを削除しますか</h3>
			<s:form>
				<input id="button" type="button" value="はい"
					onclick="submitAction('UserListDeleteCompleteAction')" />
				<input id="button" type="button" value="いいえ"
					onclick="submitAction('UserListAction')" />
			</s:form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>