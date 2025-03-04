<%@page import="com.jsp.cloth_show_room.dto.User"%>
<%@page import="com.jsp.cloth_show_room.dao.UserDao"%>
<%@page import="java.util.Base64"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.jsp.cloth_show_room.dao.ClothDetailsDao"%>
<%@page import="com.jsp.cloth_show_room.dto.ClothDetails"%>
<%@page import="com.jsp.cloth_show_room.dto.UserCart"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.cloth_show_room.dao.CartDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER-CART</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
section {
	border: solid 2px red;
	width: 860px;
	height: 100vh;
	margin-right: auto;
	margin-left: auto;
}
.custom-input {
  height: 30px;
  width: 80px;
}
</style>
</head>
<body>
	<jsp:include page="user-navbar.jsp"></jsp:include>
	<%
	String string = (String) request.getAttribute("cartAdd");

	String email = (String) session.getAttribute("email");

	User user = new UserDao().getUserByEmailDao(email);

	List<UserCart> userCarts = new CartDao().getCartsDetailsByUserIdDao(user.getUserId());

	int count = 0;
	int finalPrice = 0;
	UserCart cart = null;
	%>

	<%
	if (string != null) {
	%>

	<h3 style="margin: 10px;">Success-Order</h3>
	<%
	}
	%>
	<section style="margin-top: 80px;">
		<%
		for (UserCart userCart : userCarts) {

			if (userCart != null && userCarts != null) {

				ClothDetails clothDetail = userCart.getClothDetails();

				cart = new UserCart();
		%>
		<%
		cart.setUserCartId(userCart.getUserCartId());
		%>
		<!-- total cart price calculation -->
		<%
		finalPrice += userCart.getClothPrice();
		%>
		<%
		byte[] image = clothDetail.getImage();

		String base64Image = Base64.getEncoder().encodeToString(image);
		%>

		<%
		count++;
		%>
		<article>
			<div class="card"
				style="width: 17rem; height: 32rem; float: left; margin-left: 10px; border: solid 2px green; margin-top: 20px;">
				<div>
					<img src="data:image/png;base64,<%=base64Image%>"
						class="card-img-top" alt="myImage" width="60px;" height="310px;">
				</div>

				<div class="card-body" style="float: left;">
					<h6 class="card-title">
						price =
						<del><%=clothDetail.getClothPrice()%></del>
						discount=<%=clothDetail.getOffer()%>%
					</h6>
					<%double price=clothDetail.getClothPrice() - ((clothDetail.getClothPrice()) * (clothDetail.getOffer())) / 100;%>
					<h6 class="card-text">
						finalPrice=<%=userCart.getClothPrice()%>&nbsp;
					</h6>
					<div style="display: flex;">
						<a
							href="user-placeorder.jsp?barcode=<%=clothDetail.getClothBarCode()%>&finalPrice=<%=userCart.getClothPrice()%>&quantity=<%=userCart.getQuantity()%>"
							class="btn btn-primary">BuyNow</a> <a
							href="delete?cartId=<%=cart.getUserCartId()%>"
							class="btn btn-primary" style="margin-left: 20px;">DELETE</a><br>
					</div>
					<h6>quantity</h6>
					<div style="display: flex;">
					<a href="deleteCartProductQuantity?id=<%=cart.getUserCartId()%>&price=<%=price%>"
						class="btn btn-primary"><button class="plus-button">-</button></a><input type="number" name="quantity" value="<%=userCart.getQuantity()%>" class="custom-input"> <a href="updateCartProductQuantity?id=<%=cart.getUserCartId()%>&price=<%=price%>"
						class="btn btn-primary"><button class="plus-button">+</button></a>
				</div>
				</div>
			</div>

		</article>
		<%
		}
		%>
		<%
		}
		if (cart != null) {
		%>

		<div style="margin-top: 480px; margin-left: 30px;">
			<a href="order-all-added-cart.jsp?id=<%=user.getUserId()%>"
				class="btn btn-primary" style="width: 300px; margin-left: -20px;">Place-Order</a>
			<a href="#" class="btn btn-primary" style=""><%=finalPrice%></a>

		</div>

		<%
		}
		%>
	</section>
</body>
</html>