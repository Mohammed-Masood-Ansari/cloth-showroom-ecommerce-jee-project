<%@page import="com.jsp.cloth_show_room.dao.CartDao"%>
<%@page import="com.jsp.cloth_show_room.dto.UserCart"%>
<%@page import="java.util.Base64"%>
<%@page import="com.jsp.cloth_show_room.dto.ClothDetails"%>
<%@page import="com.jsp.cloth_show_room.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.cloth_show_room.dao.UserDao"%>
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

<style>
.sort-container {
	display: flex; /* This makes the elements sit beside each other */
	align-items: center; /* This vertically centers the text */
	margin-top: 30px;
}

.sort-container h5 {
	margin-left: 10px; /* Adds space between the header and the link */
}
</style>
</head>
<body>

	<%
	String email = (String) session.getAttribute("email");

	UserDao dao = new UserDao();

	User user = dao.getUserByEmailDao(email);

	List<UserCart> userCarts = new CartDao().getMensCartsDetailsByUserIdDao(user.getUserId());

	int size = userCarts.size();

	List<ClothDetails> clothDetails = dao.getAllMen();
	%>
	<jsp:include page="user-navbar.jsp"></jsp:include><br>
	<div class="sort-container">
		<h5>SortByPrice</h5>
		<a href="user-men-display-by-price-low-to-high.jsp">lowtohigh</a>&nbsp;&nbsp;
		<a href="user-men-display-by-price-high-to-low.jsp">hightolow</a>
	</div>
	<%
	for (ClothDetails clothDetails2 : clothDetails) {
		boolean product = false;
		byte[] image = clothDetails2.getImage();

		String base64Image = Base64.getEncoder().encodeToString(image);

		for (UserCart userCart : userCarts) {

			if (userCart.getClothDetails().getClothBarCode() == clothDetails2.getClothBarCode()
			&& user.getUserId() == userCart.getUser().getUserId()) {
		product = true;
		break;
			}

		}
	%>
	<section style="margin-top: 40px;">
		<article>
			<div class="card"
				style="width: 17rem; height: 27rem; float: left; margin-left: 10px;">
				<div>
					<img src="data:image/png;base64,<%=base64Image%>"
						class="card-img-top" alt="myImage" width="60px;" height="310px;">
				</div>

				<div class="card-body" style="float: left;">
					<h6 class="card-title">
						price =
						<del><%=clothDetails2.getClothPrice()%></del>
						discount=<%=clothDetails2.getOffer()%>%
					</h6>
					<h6 class="card-text">
						<%
						 double finalprice=clothDetails2.getClothPrice() - ((clothDetails2.getClothPrice()) * (clothDetails2.getOffer())) / 100;
						%>
						final price=
						<%=finalprice%>&nbsp;
					</h6>
					<div style="display: flex;">

						<%
						if (product) {
						%>
						<a href="user-cart.jsp" class="btn btn-primary">GoToCart</a>
						<%
						} else {
						%>
						<a
							href="userCartInsert?barcode=<%=clothDetails2.getClothBarCode()%>"
							class="btn btn-primary">AddToCart</a>
						<%
						}
						%>
						<a
							href="user-placeorder.jsp?barcode=<%=clothDetails2.getClothBarCode()%>&finalPrice=<%=finalprice%>&quantity=<%=1%>"
							class="btn btn-primary" style="margin-left: 20px;">ByNow</a>
					</div>
				</div>
			</div>
		</article>
	</section>

	<%
	}
	%>
</body>
</html>