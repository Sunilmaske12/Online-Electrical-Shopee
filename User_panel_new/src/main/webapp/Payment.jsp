<!DOCTYPE html>
<html lang="zxx">

<%@page import="com.codeo.shop.Dao.CustomerDao" %>
<%@page import="java.util.List" %>
<%@page import="com.codeo.shop.entity.Customer" %>



<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Checkout</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<jsp:include page="header.jsp" />
	<jsp:include page="CommonModal.jsp" />

	

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg" data-setbg="img/Name-bg.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Checkout</h2>
						<div class="breadcrumb__option">
							<a href="./index.jsp">HOME</a> <span>PAYMENT</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Checkout Section Begin -->
	<section class="checkout spad">
		<div class="container">
			
			<div class="checkout__form">
				<h4>BILLING DETAILS</h4>
				<form action="#">
					
						
						<!-- Address Show Ended -->
						<div style="margin-left: 150px;" class="col-lg-4 col-md-6">
							<div class="checkout__order">
								<h4>Make Payment</h4>
								<div class="checkout__order__products">
									Products <span>Total</span>
								</div>
								<ul>
									<li>Vegetable’s Package <span>$75.99</span></li>
									<li>Fresh Vegetable <span>$151.99</span></li>
									<li>Organic Bananas <span>$53.99</span></li>
								</ul>
								<div class="checkout__order__subtotal">
								               
									TOTAL <span>Rs. 750.99</span>
								</div> 
								<div  class="checkout__order__total">
								<div class="radio radio-success">
                                                    <input type="radio" name="address_id"  id="selectAddress0" aria-invalid="false" >
                                                    <label for="selectAddress0"></label>
                                
									  <span style="color:black;">CASH ON DELIVERY</span>
								</div></div>
								<div class="checkout__order__total">
								<div class="radio radio-success">
                                                    <input type="radio" name="address_id"  id="selectAddress0" aria-invalid="false" >
                                                    <label for="selectAddress0"></label>
                                
									 <span>NET BANKING</span>
								</div></div>
								<a ><button type="submit" onclick="window.location.href='Payment.jsp';" class="site-btn">PLACE ORDER</button></a>
								</div>
								
							</div>
						
					
				</form>
			</div>
		</div>
	</section>
	<!-- Checkout Section End -->

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



</body>

</html>