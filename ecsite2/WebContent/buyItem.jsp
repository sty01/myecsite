<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/jacascript" />
<meta http-equiv="imagetoolbar" content="text/javascript">
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="./css/buyItem.css">

<title>BuyItem画面</title>
<script type="text/javascript">
	function checkSelectedRow() {
		var checkList = document.getElementsByClassName('checkList');
		var selectedRow = '';
		var flag = false;

		for (var i = 0; i < checkList.length; i++) {
			if (checkList[i].checked) {
				if (flag == false) {
					selectedRow = i;
					flag = true;
				} else {
					selectedRow = selectedRow + ', ' + i;
				}
			}
		}
		document.getElementById('selectedRow').value = selectedRow;
	}
</script>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:if test="errorMessage !=''">
				<s:property value="errorMessage" escape="false" />
			</s:if>

			<s:form action="CartAction">
				<table border="1">
					<tr>
						<td>選択</td>
						<td>商品画像</td>
						<td>商品ID</td>
						<td>商品名</td>
						<td>値段</td>
						<td>在庫</td>
						<td>購入個数</td>
						<td>商品情報</td>
					</tr>

					<s:if test="#session.buyItemDTOList == null">
						<h3>商品はありません</h3>
					</s:if>

					<s:iterator value="#session.buyItemDTOList">
						<tr>
							<td><s:checkbox name="checkList" class="checkList"
									value="checked" fieldValue="%{id}" /></td>
							<td><img src='images/<s:property value="itemName"/>.jpg' /></td>
							<td><s:property value="id" /></td>
							<s:hidden name="id" value="%{id}" />
							<td><s:property value="itemName" /></td>
							<s:hidden name="itemName" value="%{itemName}" />
							<td><s:property value="itemPrice" /><span>円</span></td>
							<s:hidden name="itemPrice" value="%{itemPrice}" />
							<td><s:property value="itemStock" /><span>個</span></td>
							<s:hidden name="itemStock" value="%{itemStock}" />
							<td><select name="count">
									<option value="選択してください" selected="selected">
										<script>
											if(<s:property value="itemStock" />==0){
									document.write("在庫切れです");
									}else{document.write("選択してください");
								}
										</script>
									</option>
									<script>

								for(var i = 1; i <= <s:property value="itemStock" />; i++){
									document.write("<option value="+i+">");
									document.write(i);
									document.write("</option>");
								}

									</script>
							</select></td>

							<td><a
								href='<s:url action="ItemInfoAction"><s:param name="id" value="%{id}" /></s:url>'>こちら
							</a></td>
						</tr>

					</s:iterator>
				</table>
				<span>支払い方法</span>
				<input type="radio" name="pay" value="現金払い" checked="checked">現金払い
						<input type="radio" name="pay" value="クレジットカード">クレジットカード
						<s:hidden name="selectedRow" id="selectedRow" value="" />
				<s:submit align="center" onclick="checkSelectedRow()" value="カートに追加" />
			</s:form>
			<p>
				<a href='<s:url action="GoCartAction"/>'>カートを確認</a>
			</p>
			<div>
				<p>
					マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a>
				</p>
				<p>
					ログインは<a href='<s:url action="LoginAction"/>'>こちら</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
