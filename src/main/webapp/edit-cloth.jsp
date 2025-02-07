<%@page import="com.jsp.cloth_show_room.dto.ClothDetails"%>
<%@page import="com.jsp.cloth_show_room.service.ClothDetailsService"%>
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
			Integer clothBarCode=Integer.parseInt(request.getParameter("id"));
		
			ClothDetailsService clothDetailsService = new ClothDetailsService();
			
			ClothDetails clothDetails = clothDetailsService.getClothDetails(clothBarCode);
		%>
		
		<jsp:include page="admin-navbar.jsp"></jsp:include>
		
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
										<h2 class="text-uppercase text-center mb-5">Update-Cloth-Details</h2>
										<form action="adminUpdateController" method="post" enctype="multipart/form-data">

											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example1cg">cloth-bar-code</label>
												<input type="number" id="form3Example1cg"
													class="form-control form-control-lg" name="updatebar" value="<%=clothDetails.getClothBarCode()%>"/>
											</div>

											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example3cg">cloth-type</label>
												<!-- <input type="text" id="form3Example3cg"
													class="form-control form-control-lg" />  -->
												<select name="updateclothtype" id="ctype" class="form-control form-control-lg" >
													<option value="Pant">Pant</option>
													<option value="Shirt">Shirt</option>
													<option value="TShirt">TShirt</option>
												</select>
											</div>
											
											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example3cg">wear-type</label>
												<!-- <input type="text" id="form3Example3cg"
													class="form-control form-control-lg" />  -->
												<select name="updatewearType" id="wtype" class="form-control form-control-lg" >
													<option value="Men">Men</option>
													<option value="Women">Women</option>
												</select>
											</div>
											
											
											
											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example3cg">Cloth-Image</label>
												<input type="file" name="updateimageFile">
											</div>
											
											<div class="form-outline mb-4">
												<label class="form-label" for="form3Example4cg">cloth-price</label>
												<input type="number" id="form3Example4cg"
													class="form-control form-control-lg" name="updateprice" value="<%=clothDetails.getClothPrice()%>" />
											</div>
											
											
											<div class="d-flex justify-content-center">
												<button type="button"
													class="btn btn-success btn-block btn-lg gradient-custom-4 text-body"><input type="submit" value="UPDATE"/></button>
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