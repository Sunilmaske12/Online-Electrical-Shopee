<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="com.codeo.shop.dbutil.ConnectionProvider"%>
<%@page import="com.codeo.shop.entity.Product" %>
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
<title>Basic DataTables - Apex responsive bootstrap 4 admin
	template</title>
<link rel="apple-touch-icon" sizes="60x60"
	href="app-assets/img/ico/apple-icon-60.html">
<link rel="apple-touch-icon" sizes="76x76"
	href="app-assets/img/ico/apple-icon-76.html">
<link rel="apple-touch-icon" sizes="120x120"
	href="app-assets/img/ico/apple-icon-120.html">
<link rel="apple-touch-icon" sizes="152x152"
	href="app-assets/img/ico/apple-icon-152.html">
<link rel="shortcut icon" type="image/x-icon"
	href="app-assets/img/ico/favicon.ico">
<link rel="shortcut icon" type="image/png"
	href="app-assets/img/ico/favicon-32.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<link
	href="https://fonts.googleapis.com/css?family=Rubik:300,400,500,700,900|Montserrat:300,400,500,600,700,800,900"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/simple-line-icons/style.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/perfect-scrollbar.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/prism.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/datatables.min.css">
<!-- END VENDOR CSS-->
<!-- BEGIN APEX CSS-->
<link rel="stylesheet" type="text/css" href="app-assets/css/app.css">
</head>

<body data-col="2-columns" class=" 2-columns ">

	<div class="wrapper nav-collapsed menu-collapsed">

		<%@include file="Asidebar.jsp"%>
        <%@include file="Navbar.jsp"%>

		<div class="main-panel">
			<div class="main-content">
				<div class="content-wrapper">

					<div class="mb-3">
						<a href="Add-product.jsp"
							class="btn btn-raised gradient-crystal-clear white"><i
							class="fa fa-plus " aria-hidden="true"></i> Add Product </a>
					</div>
                    <section id="shopping-cart">
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-header">
										<h4 class="card-title">Product List</h4>
									</div>
									<div class="card-body">
										<div class="card-block">
											<table class="table table-responsive-md text-center">
												<thead>
													<tr>
														<th>Sr<br>No
														</th>
														<th>Product Name</th>
														<th>Description</th>
														<th>Price</th>
														<th>Discount</th>
														<th>Quantity</th>
														<th>Image</th>
														<th>Action</th>
                                                   </tr>
												</thead>
												<%
                            String id = request.getParameter("id");
                         String select_product ="select * from product_operation ";
                        Connection con = ConnectionProvider.getconnection();
                           Statement stmt = con.createStatement();
                          ResultSet rs = stmt.executeQuery(select_product);
                           
                          while(rs.next())
                         {                 
                        	        %>
											<td><%= rs.getInt("prod_id") %></td>
													<td><%= rs.getString("prod_name") %></td>
													<td><%= rs.getString("prod_description") %></td>
													<td><%= rs.getString("prod_price") %></td>
													<td><%=rs.getString("prod_discount") %></td>
													<td><%= rs.getString("prod_quantity") %></td>
													<td><%= rs.getString("prod_imageName") %></td>
                                                   
												 <td><a	href="Productoperation?action=DELETE&id=<%=rs.getString("prod_id")%>"><i
															class="ft-trash font-medium-3 red"></i> </a>|| <a
														href="Productoperation?action=EDIT&id=<%=rs.getString("prod_id")%>">
															EDIT<i class="ft-edit orange"></i>
													</a></td>
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