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
	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="position: fixed; z-index: 3;top: 0px; width: 100vw">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Cloth-Show-Room</a>
			<button class="navbar-toggler" type="button"
				data-mdb-toggle="collapse" data-mdb-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="admin-home.jsp" >Home</a></li>
						<li class="nav-item"><a class="nav-link" href="admin-cloth-details.jsp" >DisplayClothDetails</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>