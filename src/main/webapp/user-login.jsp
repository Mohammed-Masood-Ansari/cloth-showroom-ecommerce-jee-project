<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}
</style>
</head>
<body>
	<%
		String email = (String)request.getAttribute("messageemail");
		String password = (String)request.getAttribute("messagepassword");
	%>
	<jsp:include page="home-navbar.jsp"></jsp:include>
	<section class="vh-100">
		<div class="container py-5 h-100">
			<div
				class="row d-flex align-items-center justify-content-center h-100">
				<div class="col-md-8 col-lg-7 col-xl-6">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
						class="img-fluid" alt="Phone image">
				</div>
				<div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
					<h6>USER-LOGIN-FORM</h6>
					<form action="userLogin" method="post">
						<!-- Email input -->
						<div class="form-outline mb-4">
						<label class="form-label" for="form1Example13">Email address</label>
							<input type="email" id="form1Example13"
								class="form-control form-control-lg" name="email"/> 
								<%if(email!=null){ %>
									<h6 style="color: red"><%=email%></h6>
								<%}%>
						</div>

						<!-- Password input -->
						<div class="form-outline mb-4">
						<label class="form-label" for="form1Example23">Password</label>
							<input type="password" id="form1Example23"
								class="form-control form-control-lg" name="password"/> 
								<%if(password!=null){%>
									<h6 style="color: red"><%=password%></h6>
								<%}%>
						</div>

						<div class="d-flex justify-content-around align-items-center mb-4">
							<!-- Checkbox -->
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="form1Example3" checked /> <label class="form-check-label"
									for="form1Example3"> Remember me </label>
							</div>
							<a href="#!">Forgot password?</a>
						</div>

						<!-- Submit button -->
						<input type="submit" value="LOGIN" class="btn btn-primary"/>

						<div class="divider d-flex align-items-center my-4">
							<p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
						</div>

						<a class="btn btn-primary btn-lg btn-block"
							style="background-color: #3b5998" href="#!" role="button"> <i
							class="fab fa-facebook-f me-2"></i>Continue with Facebook
						</a> <a class="btn btn-primary btn-lg btn-block"
							style="background-color: #55acee" href="#!" role="button"> <i
							class="fab fa-twitter me-2"></i>Continue with Twitter
						</a>

					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>