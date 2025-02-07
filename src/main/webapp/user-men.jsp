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
</head>
<body>

	<%
		UserDao dao = new UserDao();
	
		List<ClothDetails> clothDetails = dao.getAllMen();
	%>
	<jsp:include page="user-navbar.jsp"></jsp:include>

	<%
	for (ClothDetails clothDetails2 : clothDetails) {
	%>
	<%
		byte[] image = clothDetails2.getImage();
	
		String base64Image = Base64.getEncoder().encodeToString(image);
	%>
	<section style="margin-top: 40px;">
		<article>
			<div class="card"
				style="width: 17rem; height:27rem; float: left; margin-left: 10px;">
				<div>
					<img
					src="data:image/png;base64,<%=base64Image%>"
					class="card-img-top" alt="myImage" width="60px;" height="310px;">
				</div>
				
				<div class="card-body" style="float: left;">
					<h6 class="card-title">
						price =
						<del><%=clothDetails2.getClothPrice()%></del>
						discount=<%=clothDetails2.getOffer()%>%
					</h6>
					<h6 class="card-text">
						final price=
						<%=clothDetails2.getClothPrice()-((clothDetails2.getClothPrice())*(clothDetails2.getOffer()))/100%>&nbsp;
					</h6>
					<div style="display: flex;">
						<a href="userCartInsert?barcode=<%=clothDetails2.getClothBarCode()%>" class="btn btn-primary" >Add To Cart</a>
						<a href="openPlaceOrder?barcode=<%=clothDetails2.getClothBarCode()%>" class="btn btn-primary" style="margin-left: 20px;">By Now</a>
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