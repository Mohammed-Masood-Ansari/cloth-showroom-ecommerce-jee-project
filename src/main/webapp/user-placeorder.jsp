<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Base64"%>
<%@page import="com.jsp.cloth_show_room.dto.ClothDetails"%>
<%@page import="com.jsp.cloth_show_room.dao.ClothDetailsDao"%>
<%@page import="com.jsp.cloth_show_room.dao.UserDao"%>
<%@page import="com.jsp.cloth_show_room.dto.User"%>
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
		int barcode=Integer.parseInt(request.getParameter("barcode"));
	
		double finalprice=Double.parseDouble(request.getParameter("finalPrice"));
		
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
	%>
	
	<jsp:include page="user-navbar.jsp"></jsp:include>
	<section>

		<article>

			<section class="vh-100 bg-image"
				style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
				<div class="mask d-flex align-items-center h-100 gradient-custom-3">
					<div class="container h-100">
						<div
							class="row d-flex justify-content-center align-items-center h-100">
							<div class="col-12 col-md-9 col-lg-7 col-xl-6">
								<div class="card" style="border-radius: 15px;">
									<div class="card-body p-5">
										<h2 class="text-uppercase text-center mb-5">Place-Your-Order</h2>
										<form action="placeOrder" method="post">
											
											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example1cg">barCode</label>
												<input type="number" id="form3Example1cg"
													class="form-control form-control-lg" name="barcode" value="<%=barcode%>"/>
											</div>

											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example1cg">pinCode</label>
												<input type="number" id="form3Example1cg"
													class="form-control form-control-lg" name="pinCode"/>
											</div>
											

											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example3cg">address</label>
												<textarea type="text" id="form3Example3cg"
													class="form-control form-control-lg" name="address"></textarea> 
											</div>
											
											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example4cg">cloth-price</label>
												<input type="number" id="form3Example4cg"
													class="form-control form-control-lg" name="price" value="<%=finalprice%>"/>
											</div>
											
											<input type="number" name="quantity" value="<%=quantity%>" hidden="true">
											
											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example4cg">Estimated-delivery</label>
												<input type="date" id="form3Example4cg"
													class="form-control form-control-lg" name="delivery" value="<%=LocalDate.now().plusDays(3)%>"/>
											</div>
											
											<div class="d-flex justify-content-center">
												<input type="submit" value="Place-Order" class="btn btn-primary"/>
											</div>

										</form>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

		</article>

	</section>
		
</body>
</html>