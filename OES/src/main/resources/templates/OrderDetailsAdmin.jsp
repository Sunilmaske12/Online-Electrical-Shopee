<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@page import="com.codeo.shop.Dao.MyOrderDao"%>
<%@page import="com.codeo.shop.entity.Order"%>
<%@page import="com.codeo.shop.entity.Customer"%>
<%@page import="com.codeo.shop.Dao.NotificationDao"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<!--   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Apex admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, Apex admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Admin | Banner</title>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">


<%@include file="component/AllCssFIles.jsp"%>
</head>

<body data-col="2-columns" class=" 2-columns ">

	<div class="wrapper nav-collapsed menu-collapsed">
					
<%	String orderId=request.getParameter("orderId");
	String addressId=request.getParameter("addressId");
	NotificationDao.seenOrderById(orderId);
	MyOrderDao mod = new MyOrderDao();
	List<Customer> addressDetail = mod.getAddressDetailByID(addressId);
	List<Order> orderDetail = mod.getOrderDetails(orderId);
	%>
	
		<%@include file="Asidebar.jsp"%>
		<%@include file="Navbar.jsp"%>

		<div class="main-panel">
			<div class="main-content">
				<div class="content-wrapper">

					<div class="mb-3">
						<a class="btn btn-raised gradient-crystal-clear white"><i
							aria-hidden="true"></i>ORDERS DETAILS</a>
					</div>
				<section id="shopping-cart">
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-body">
										<div  style="text-align:center; ;" class="card-block">
											
										<div style="border:1px solid black; max-width: 30%; margin-left:40%; padding: 20px; margin-top:50px; text-all" class="row">
						
								
									<h4 >Shipping Address</h4>
									<hr size="8" width="100%" color="red">
									<%
									for (Customer c : addressDetail) {
									%>
									<div class="row checkout-address-row">
										
										<div class="col-md-11 col-10">

											<div>
												Mr/Mrs
												<%=c.getC_name()%>
												(<%=c.getC_mobno()%>)
											</div>
											<hr size="8" width="90%" color="red">
											
											<%=c.getC_adderess()%>
											,	<%=c.getC_landmark() + " " + c.getC_city() + " " + c.getC_pincode()%>
											

										</div>
									</div>
									
									<%
									}
									%>


									
								</div>
							
							
		<div style="padding-top: 30px;"  class="container">
			<table style="text-align:center" class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">No.</th>
						<th>ITEM</th>
						<th>PRICE</th>
						<th>QUANTIRY</th>
						<th>TOTAL PRICE</th>
												
					</tr>
				</thead>
				<tbody>
					<%
					int charges=0;
					int T_Price=0;
					for(Order order:orderDetail){%>
					<tr>
						<td scope="row"></td>
						<td><%=order.getProductName() %></td>
						<td><%= order.getProductPrice()%></td>
						<td><%= order.getProductQuantity() %></td>
						<%int price=order.getProductPrice()*order.getProductQuantity();
						 T_Price=T_Price+price;%>
						<td><%= price%></td>
						
					</tr>
					<%}if(T_Price<999){
						charges=100;
					} %>
						<tr>
							<td></td>
							<td style="font-weight:bold; color:red;" colspan=4>TOTAL AMOUNT  : <%= T_Price %> + <%=charges %><span style="color:black"> (shipping charges)  =   </span>  RS. <%=T_Price+charges %></td>
						</tr>				
				</tbody>
			</table>
			

		</div>
											
										</div>
									</div>
								</div>
							</div>
						</div>
						
					</section>
				</div>
			</div>
		</div>
	</div>

	<script src="app-assets/vendors/js/core/jquery-3.2.1.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/core/popper.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/core/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/perfect-scrollbar.jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/prism.min.js" type="text/javascript"></script>
	<script src="app-assets/vendors/js/jquery.matchHeight-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/screenfull.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pace/pace.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/datatable/datatables.min.js"
		type="text/javascript"></script>
	<script src="app-assets/js/app-sidebar.js" type="text/javascript"></script>
	<script src="app-assets/js/notification-sidebar.js"
		type="text/javascript"></script>
	<script src="app-assets/js/customizer.js" type="text/javascript"></script>
	<!-- END APEX JS-->
	<!-- BEGIN PAGE LEVEL JS-->
	<script src="app-assets/js/data-tables/datatable-basic.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
</body>
</html>