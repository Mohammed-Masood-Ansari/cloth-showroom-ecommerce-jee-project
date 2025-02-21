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
</head>
<body>

	<%
	CartDao cartDao = new CartDao();

	List<UserCart> userCarts = cartDao.getCartsDetailsByUserIdDao(1);

	for (UserCart userCart : userCarts) {

		ClothDetails clothDetails = userCart.getClothDetails();

		System.out.println(clothDetails);
		System.out.println(userCart);
	}
	%>
</body>
</html>