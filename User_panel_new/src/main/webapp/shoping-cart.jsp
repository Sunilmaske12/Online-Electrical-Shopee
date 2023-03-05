
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.codeo.shop.entity.Product"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.codeo.shop.dbutil.ConnectionProvider"%>
<%@page import=" com.codeo.shop.Dao.ProductDao"%>
<%@page import=" com.codeo.shop.Dao.ProductDaoImp"%>



<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Shoping cart</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>



</head>


<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<jsp:include page="header.jsp" />

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg" data-setbg="img/Name-bg.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Shopping Cart</h2>
						<div class="breadcrumb__option">
							<a href="./index.jsp">Home</a> <span>Shopping Cart</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">

		

		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table ">
						<div class="shoping_cart_body"></div>
					</div>
				</div>
			</div>
			<div class="row">
			
				<div class="col-lg-12">
					<div class="shoping__cart__btns">
						<a href="shop-grid.jsp" class="primary-btn cart-btn">CONTINUE SHOPPING</a> <button onclick="clearCart()"
							 class="primary-btn cart-btn cart-btn-right"> <span
							class="icon_loading"></span> Clear Cart
						</button>
					</div>
				</div>


				<div class="col-lg-6">
					<div class="shoping__continue">
						<div class="shoping__discount">
							<h5>Discount Codes</h5>
							
								<input style="height: 45px; "  type="text" placeholder="Enter your coupon code">
								<button type="submit" class="site-btn">APPLY COUPON</button>
								
							
						</div>
					</div>
				</div>
				
				<div class="col-lg-6">
					<div class="shoping__checkout" id="checkoutbutton">
					
						<h5>PRICE DETAILS</h5>
						<ul>
							<li>TOTAL ORDER <span class="totalOrder"></span></li>
							<li>DELIVERY CHARGE <span class="charges"></span></li>
							<li><h3 >Total Price: <span class="totalPrice"></span></h3></li>

						</ul><form action="cartlength"><input type="hidden" id="cartlegth" name="cartlegth">
						<button style="width:100%;" type="submit"  class="primary-btn">PROCEED TO
							CHECKOUT</button></form>
					</div>
				</div>
				
			</div>
		</div>
	</section>
	<!-- Shoping Cart Section End -->

	<jsp:include page="footer.html" />

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
    <script type="text/javascript" src="js/CommonScript.js"></script>
</body>

</html>