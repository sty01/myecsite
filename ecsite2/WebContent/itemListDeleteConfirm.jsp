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
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<link rel="stylesheet" href="./css/home.css">
		<title>削除確認画面</title>

		<script type="text/javascript">
			function submitAction(url) {
				$('form').attr('action', url);
				$('form').submit();
			}
		</script>
	</head>
	<body>
		<div id="header">
			<div id="pr">ta
			</div>
		</div>
		<div id="main">
			<div id="top">
				<p>削除確認</p>
			</div>
			<div>
				<h3>本当にすべての商品を削除しますか</h3>
				<s:form>
					<input id="button" type="button" value="はい" onclick="submitAction('ItemListDeleteCompleteAction')" />
					<input id="button" type="button" value="いいえ" onclick="submitAction('ItemListAction')" />
				</s:form>
			</div>
		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>
</html>