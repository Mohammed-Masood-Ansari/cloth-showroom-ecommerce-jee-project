<%@page import="java.util.Base64"%>
<%@page import="com.jsp.cloth_show_room.dao.ClothDetailsDao"%>
<%@page import="com.jsp.cloth_show_room.dto.ClothDetails"%>
<%@page import="com.jsp.cloth_show_room.dto.BuyNow"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.cloth_show_room.dao.BuyNowDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="user-navbar.jsp"></jsp:include>
	
	<section style="margin-top: 60px;">
		<%
			ClothDetailsDao clothDetailsDao = new ClothDetailsDao();
			List<ClothDetails> clothDetails = clothDetailsDao.getAllClothDetails();
			
			BuyNowDao buyNowDao = new BuyNowDao();
			
			List<BuyNow> buyNows = buyNowDao.getAllBuyNows();
			
		%>
		<article>
			<div class="container">
			<div class="row">
				<div class="col-5">
					<table class="table table-image">
						<h3>My-Booking-Details</h3>
						<thead>
							<tr>
								<th scope="col">OrderId</th>
								<th scope="col">ClothBarCode</th>
								<th scope="col">ClothImage</th>
								<th scope="col">ClothType</th>
								<th scope="col">WearType</th>
								<th scope="col">ClothQuantity</th>
								<th scope="col">ClothPrice</th>
								<th scope="col">ClothOffer</th>
								<th scope="col">BookingDate</th>
								<th scope="col">DeliveryDate</th>
								<th scope="col">Address</th>
								<th scope="col">Cancel</th>
								<th scope="col">Edit</th>
							</tr>
						</thead>
						<tbody>
						<%for(BuyNow buyNow:buyNows){%>
						
						<%for(ClothDetails clothDetails2:clothDetails){%>
						
							<%if(buyNow.getClothDetails().getClothBarCode()==clothDetails2.getClothBarCode()){ %>
							<%
								byte[] image = clothDetails2.getImage();
							
								String base64Image = Base64.getEncoder().encodeToString(image);
							%>
							
							<tr>
								<td><%=buyNow.getOrderId()%></td>
								<td><%=clothDetails2.getClothBarCode()%></td>
								<td class="w-25"><img
									src="data:image/png;base64,<%=base64Image%>"
									class="img-fluid img-thumbnail" alt="cloth-image">
								</td>
								<td><%=clothDetails2.getClothType()%></td>
								<td><%=clothDetails2.getWearType()%></td>
								<td><%=buyNow.getQuantity()%></td>
								<td><%=buyNow.getPrice()%></td>
								<td><%=clothDetails2.getOffer()%></td>
								<td><%=buyNow.getBookingdate()%></td>
								<td><%=buyNow.getDelivarDate()%></td>
								<td><%=buyNow.getAddress()%></td>
								<td><a href="cancelOrder?orderId=<%=buyNow.getOrderId()%>" class="btn btn-danger">Cancel</a></td>
								<td><a href="editOrder?orderId=<%=buyNow.getOrderId()%>" class="btn btn-warning">Edit</a></td>
							</tr>
							<%}%>
							<%} %>
						<%}%>
						</tbody>
					</table>
				</div>
			</div>
			</div>
		</article>
	</section>
	
	
</body>
</html>