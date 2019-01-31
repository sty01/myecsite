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


<title>Home画面</title>

</head>
<body>
	<jsp:include page="/header.jsp" />

	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>

		<s:if test="errorMessage !=''">
			<s:property value="errorMessage" escape="false" />
		</s:if>

	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>