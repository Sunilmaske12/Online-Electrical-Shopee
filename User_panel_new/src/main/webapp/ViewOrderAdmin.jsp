<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.codeo.shop.Dao.MyOrderDao"%>
<%@page import="com.codeo.shop.entity.Order"%>
<%@page import="com.codeo.shop.entity.Customer"%>
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

		<%@include file="Asidebar.jsp"%>
		<%@include file="Navbar.jsp"%>

		<div class="main-panel">
			<div class="main-content">
				<div class="content-wrapper">

					<div class="mb-3">
						<a class="btn btn-raised gradient-crystal-clear white"><i
							aria-hidden="true"></i> ALL ORDERS </a>
					</div>
					

<%
MyOrderDao mod=new MyOrderDao();
List<Order> orderlist = mod.getAllOrderList();
%>
					<section id="shopping-cart">
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-body">
										<div style="margin:40px;" class="card-block">
											<table style="margin-top: 50px;" class="table table-responsive-md text-center ">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>ORDER DATE</th>
														<th>CUSTOMER NAME</th>
														<th>DETAILS</th>
														<th>STATUS</th>
													</tr>
												</thead>
												<% int i=0;
												for(Order order:orderlist){
					                       			Date date=order.getDate();
														i++; %>
												<tr>
													<td><%=i %> <% if(order.getseen().equals("No")){%> <span style="color:red; font-size:80%;">(new)</span><%} %></td>
													<td><%=order.getDate()%></td>
													<%List<Customer> C_Address_details = mod.getAddressDetailByID(order.getAddressId());
						if(C_Address_details.size()==0){%>
						<td> Null </td>
						<%}
						for(Customer custo:C_Address_details){
							
							%>
							<td><%=custo.getC_name() %></td><%} %>
													<td><a href="OrderDetailsAdmin.jsp?orderId=<%=order.getOrderId()%>&addressId=<%=order.getAddressId() %>" type="button" style="color:white; font-family:Serif; background: blue;" class="btn btn-primary btn-sm">DATAILS</a></td>
												    
												   <%if(order.getStatus().equals("Approved")){%>
												    <td><div  class="btn-group">
															<a style="background: #00FF00;"  class="btn btn-primary">Approved</a>
															</div>
													</td>
													  
												  <%  } else if(order.getStatus().equals("Rejected")){%>
												   <td><div  class="btn-group">
															<a style="background: red; color:white; cursor:none;" type="button" class="btn btn-primary">Rejected</a>
															
														</div>
													</td>
													   
												  <%  }else{%>
												   <td><div  class="btn-group">
															<button style="background: orange;" type="button" class="btn btn-primary">WAITING</button>
															<button style="background: orange;" type="button"
																class="btn btn-primary dropdown-toggle dropdown-toggle-split"
																data-toggle="dropdown"></button>
															<div class="dropdown-menu">
																<a style="background: #00FF00;" class="dropdown-item" href="Status_Servlet?Action=approve&O_Id=<%=order.getOrderId()%>">APPROVE</a>
																 <a	style="background: red; " class="dropdown-item"  href="Status_Servlet?Action=reject&O_Id=<%=order.getOrderId()%>">REJECT</a>
															</div>
														</div>
													</td>
													   
												   <% } %>
												    
												    
												    

												</tr>

												<%
												}
												%>

											</table>
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