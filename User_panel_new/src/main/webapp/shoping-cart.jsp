 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	<%@ page isELIgnored="false" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <%@page import="com.codeo.shop.entity.Product" %>
    <%@page import="java.sql.*"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.codeo.shop.entity.Cart" %>
    <%@page import="com.codeo.shop.dbutil.ConnectionProvider" %>
    <%@page import=" com.codeo.shop.Dao.ProductDao" %>
    <%@page import=" com.codeo.shop.Dao.ProductDaoImp" %>

<%
ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list"); 
List<Cart> cartProduct = null;
if(cart_list !=null)
   {
	ProductDao pDao= new ProductDaoImp(ConnectionProvider.getconnection());
	
	cartProduct= pDao.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
	
	int total=pDao.getTotalCartPrice(cart_list);
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
	
    }
         %>


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

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

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
	
<!-- <h3>Total Price:${(total>0)?total:0}</h3> -->
	
		<div class="container">
		<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<table>
							<thead>
								<tr>
									<th class="shoping__product">Products</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
									<th>Remove</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							
							<% 
							if(cart_list!=null)
							{
								for(Cart c: cartProduct)
								{    %>
									
									<tr>
			                           <td class="shoping__cart__item">
										<img src="img/latest-product/<%=c.getProd_imageName() %>" alt="product_image" style="height:80px">
											<h5><%=c.getProd_name() %></h5></td>
										<!--  <td class="shoping__cart__price" id="price"><%=c.getCalculated_price() %></td> -->
							 <td class="shoping__cart__price" id="price-<%=c.getId()%>"><%=c.getCalculated_price() %></td>
					
 
 <td>
  <input type="button" onclick="decrementValue(<%=c.getId()%>)" value="-" />
  <input type="text" name="quantity" value="1" maxlength="2" max="10" size="1" id="number-<%=c.getId()%>" />
  <input type="button" onclick="incrementValue(<%=c.getId()%>)" value="+" />
</td>
	        <td id="totalPriceCell-<%=c.getId()%>" class="shoping__cart__total"> </td>
	       
	         <td><button class="remove-btn">Remove</button></td>
	         
			<!-- <td class="shoping__cart__total"></td>
					<td class="shoping__cart__item__close"><span class="icon_close"></span></td>  -->
			</tr>
			
		
						<% 		}
							}
							%>
							
							</tbody>
							
							
						</table>
						<h3 id="total" style="text-align:center">Total Price:&#8377; </h3>
						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__btns">
						<a href="#" class="primary-btn cart-btn">CONTINUE SHOPPING</a> <a
							href="#" class="primary-btn cart-btn cart-btn-right">
							<span class="icon_loading"></span> Upadate Cart</a>
					</div>
				</div>
				
				
				<div class="col-lg-6">
					<div class="shoping__continue">
						<div class="shoping__discount">
							<h5>Discount Codes</h5>
							<form action="#">
								<input type="text" placeholder="Enter your coupon code">
								<button type="submit" class="site-btn">APPLY COUPON</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="shoping__checkout">
						<h5>Cart Total</h5>
						<ul>
							<li>Subtotal <span>$454.98</span></li>
							<li ><h3 id="total">Total Price:&#8377;  </h3></li>
							
						</ul>
						<a href="./checkout.jsp" class="primary-btn">PROCEED TO CHECKOUT</a>
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
   <script src="js/cart.js"></script>

  
<script type="text/javascript">
function incrementValue(id) {
	  var value = parseInt(document.getElementById("number-" + id).value, 10);
	  value = isNaN(value) ? 1 : value + 1;
	  document.getElementById("number-" + id).value = value;
	  calculateTotalPrice(id);
	}
	function decrementValue(id) {
	  var value = parseInt(document.getElementById("number-" + id).value, 10);
	  value = isNaN(value) || value <= 1 ? 1 : value - 1;
	  document.getElementById("number-" + id).value = value;
	  calculateTotalPrice(id);
	}
	function calculateTotalPrice(id) {
	  var quantity = parseInt(document.getElementById("number-" + id).value, 10);
	  var price = parseFloat(document.getElementById("price-" + id).innerHTML);
	  var totalPrice = quantity * price;
	  document.getElementById("totalPriceCell-" + id).innerHTML = totalPrice.toFixed(2);
	  AllTotalAmount();
	}
	function AllTotalAmount() {
	  total = 0;
	  var totalPriceCells = document.querySelectorAll("[id^='totalPriceCell-']");
	  for (var i = 0; i < totalPriceCells.length; i++) {
	    total += parseFloat(totalPriceCells[i].innerHTML);
	  }
	  document.querySelector("#total").innerHTML = "Total Price: " + total.toFixed(2);
	}
	
   const removeBtns = document.querySelectorAll('.remove-btn');
   removeBtns.forEach(btn => {
    btn.addEventListener('click', function(event) {
    const cartItem = event.target.parentElement.parentElement;
    const productId = cartItem.querySelector("input[id^='number-']").id.split("-")[1];
    removeFromCart(productId);
    cartItem.remove();
  });
});
function removeFromCart(productId) {
  const xhr = new XMLHttpRequest();
  xhr.open('DELETE', `/cart/${productId}`, true);
  xhr.onreadystatechange = function() {
	  if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
	    console.log(`Product with id ${productId} was removed from the cart.`);
	    const totalPrice = xhr.response; // assuming that the response from the server is the updated total price
	    document.querySelector('#total').textContent = `Total Price: \u20B9 ${totalPrice}`;
	  }
	};
  xhr.send();
}
    	
	
</script>


</body>

</html>