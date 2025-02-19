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
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<style type="text/css">
section {
	border: solid 2px red;
	width: 860px;
	height: 100vh;
	margin-right: auto;
	margin-left: auto;
}
</style>
</head>
<body>
	<jsp:include page="user-cart-navbar.jsp"></jsp:include>
	<%
			String string=(String)request.getAttribute("cartAdd");
	
			String email=(String)session.getAttribute("email");
			
			User user=new UserDao().getUserById(email);
	
			int count = 0;
	%>
	
	<%if(string!=null){%>
	
		<h3 style="margin: 10px;">Success-Order</h3>
	<%}%>
	<section style="margin-top: 80px;">
		<%
		CartDao cartDao = new CartDao();
		List<UserCart> userCarts = cartDao.getAllCarts();

		ClothDetailsDao clothDetailsDao = new ClothDetailsDao();

		List<ClothDetails> clothDetails = clothDetailsDao.getAllClothDetails();

		//ClothDetails clothDetails = clothDetailsDao.getClothDetails(clothBarCode);
		int finalPrice = 0;
		
		UserCart cart =new UserCart();
		%>

		<%
		for (UserCart userCart : userCarts) {
		%>
		<%cart.setUserCartId(userCart.getUserCartId());%>
		<%
		for (ClothDetails clothDetail : clothDetails) {
		%>

		<%
		if ((userCart.getUserCartId()==user.getUserId())) {
		%>
		<!-- total cart price calculation -->
		<%
		finalPrice += userCart.getClothPrice();
		%>
		<%
		byte[] image = clothDetail.getImage();

		String base64Image = Base64.getEncoder().encodeToString(image);
		%>

		<%count++;%>
		<article>
			<div class="card"
				style="width: 17rem; height: 27rem; float: left; margin-left: 10px; border: solid 2px green; margin-top: 20px;">
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
					<h6 class="card-text">
						final price=
						<%=clothDetail.getClothPrice() - ((clothDetail.getClothPrice()) * (clothDetail.getOffer())) / 100%>&nbsp;
					</h6>
					<div style="display: flex;">
						<a
							href="openPlaceOrder?barcode=<%=clothDetail.getClothBarCode()%>"
							class="btn btn-primary">BuyNow</a> <a
							href="delete?barcode=<%=clothDetail.getClothBarCode()%>"
							class="btn btn-primary" style="margin-left: 20px;">DELETE</a>
					</div>
				</div>
			</div>
		</article>
		<%
		}
		%>
		
		<%
		}
		%>
		<%
		}
		%>
	
		<div style="margin-top: 480px; margin-left: 30px;">
		<a href="order-all-added-cart.jsp?id=<%=cart.getUserCartId()%>" class="btn btn-primary" style="width: 300px; margin-left: -20px;">Place-Order</a>
		<a href="#" class="btn btn-primary" style=""><%=finalPrice%></a>
			
		</div>
	
	</section>
</body>
</html>