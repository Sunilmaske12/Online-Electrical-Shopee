<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@page import="com.codeo.shop.entity.User"%>
<%@page import="com.codeo.shop.Dao.UserDaoImpl"%>
<%@page import="com.codeo.shop.Dao.CustomerDao"%>

<%@page import="java.util.Map"%>

<%@page import="com.codeo.shop.controller.CountData"%>
<%
HttpSession session1 = request.getSession();
String user2 = (String) session1.getAttribute("usertype");

if (user2 == null) {

	session.setAttribute("message", "You are not logged in, Logged in first as a admin");
	response.sendRedirect("loginfrom.jsp");
	return;
} else if (user2.equals("Normal User")) {
	session.setAttribute("message", "You are not Admin, Logged in first as a admin");
	response.sendRedirect("loginfrom.jsp");
	return;
}

Map<String, Long> m = UserDaoImpl.total_user();
String UserCount = String.valueOf(m.get("Total_User"));

int TotalOrderCount= CustomerDao.getTotalOrderCount();
int TotalSales= CustomerDao.getTotalSales();
double total_earning = TotalSales*0.2;
int TotalEarning=(int)total_earning;
%>



<!DOCTYPE html>
<html lang="en" class="loading">

<!-- Mirrored from pixinvent.com/apex-angular-4-bootstrap-admin-template/html-demo-2/ by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 13 Apr 2018 07:11:20 GMT -->
<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Apex admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, Apex admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Dashboard</title>
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
	href="app-assets/vendors/css/chartist.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.css">


<style type="text/css">
.adminprofile {
	
}
</style>

</head>

<body data-col="2-columns" class=" 2-columns ">

	<div class="wrapper nav-collapsed menu-collapsed">

		<%@include file="Asidebar.jsp"%>

		<%@include file="Navbar.jsp"%>




		<div class="main-panel">
			<div class="main-content">
				<div class="content-wrapper">
					<!--Statistics cards Starts-->
					<div class="row">
						<div class="col-xl-3 col-lg-6 col-md-6 col-12">
							<div class="card gradient-blackberry">
								<div  onclick="location.href='UserList.jsp';" style="cursor:pointer;" class="card-body">
									<div class="card-block pt-2 pb-0">
										<div class="media">
											<div class="media-body white text-left">
												<h3 class="font-large-1 mb-0"><%=UserCount%></h3>
												<span>Total Users</span>
											</div>
											<div class="media-right white text-right">
												<i class="icon-pie-chart font-large-1"></i>
											</div>
										</div>
									</div>
									<div id="Widget-line-chart"
										class="height-75 WidgetlineChart WidgetlineChartshadow mb-2">
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-6 col-md-6 col-12">
							<div class="card gradient-ibiza-sunset">
								<div  onclick="location.href='ViewOrderAdmin.jsp';" style="cursor:pointer;" class="card-body">
									<div class="card-block pt-2 pb-0">
										<div class="media">
											<div class="media-body white text-left">
												<h3 class="font-large-1 mb-0"><%=TotalOrderCount %></h3>
												<span>Total Order</span>
											</div>
											<div class="media-right white text-right">
												<i class="icon-bulb font-large-1"></i>
											</div>
										</div>
									</div>
									<div id="Widget-line-chart1"
										class="height-75 WidgetlineChart WidgetlineChartshadow mb-2">
									</div>

								</div>
							</div>
						</div>

						<div class="col-xl-3 col-lg-6 col-md-6 col-12">
							<div class="card gradient-green-tea">
								<div class="card-body">
									<div class="card-block pt-2 pb-0">
										<div class="media">
											<div class="media-body white text-left">
												<h3 class="font-large-1 mb-0"><i class="fa fa-rupee"> </i><%=TotalSales %></h3>
												<span>Total Sales</span>
											</div>
											<div class="media-right white text-right">
												<i class="icon-graph font-large-1"></i>
											</div>
										</div>
									</div>
									<div id="Widget-line-chart2"
										class="height-75 WidgetlineChart WidgetlineChartshadow mb-2">
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-6 col-md-6 col-12">
							<div class="card gradient-pomegranate">
								<div class="card-body">
									<div class="card-block pt-2 pb-0">
										<div class="media">
											<div class="media-body white text-left">
												<h3 class="font-large-1 mb-0"><i class="fa fa-rupee"></i><%=TotalEarning %></h3>
												<span>Total Earning</span>
											</div>
											<div class="media-right white text-right">
												<i class="icon-wallet font-large-1"></i>
											</div>
										</div>
									</div>
									<div id="Widget-line-chart3"
										class="height-75 WidgetlineChart WidgetlineChartshadow mb-2">
									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-sm-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">PRODUCTS SALES</h4>
								</div>
								<div class="card-body">
									<div class="card-block">
										<div class="chart-info mb-3 ml-3">
											<span
												class="gradient-blackberry d-inline-block rounded-circle mr-1"
												style="width: 15px; height: 15px;"></span> Sales <span
												class="gradient-mint d-inline-block rounded-circle mr-1 ml-2"
												style="width: 15px; height: 15px;"></span> Visits
										</div>
										<div id="line-area" class="height-350 lineArea"></div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="row match-height">
						<div class="col-xl-4 col-lg-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Statistics</h4>
								</div>
								<div class="card-body">

									<p class="font-medium-2 text-muted text-center">Hobbies</p>
									<div id="bar-chart" class="height-250 BarChartShadow BarChart">
									</div>

									<div class="card-block">
										<div class="row">
											<div class="col text-center">
												<span
													class="gradient-pomegranate d-block rounded-circle mx-auto mb-2"
													style="width: 10px; height: 10px;"></span> <span
													class="font-large-1 d-block mb-2">48</span> <span>Sport</span>
											</div>
											<div class="col text-center">
												<span
													class="gradient-green-tea d-block rounded-circle mx-auto mb-2"
													style="width: 10px; height: 10px;"></span> <span
													class="font-large-1 d-block mb-2">9</span> <span>Music</span>
											</div>
											<div class="col text-center">
												<span
													class="gradient-blackberry d-block rounded-circle mx-auto mb-2"
													style="width: 10px; height: 10px;"></span> <span
													class="font-large-1 d-block mb-2">26</span> <span>Travel</span>
											</div>
											<div class="col text-center">
												<span
													class="gradient-ibiza-sunset d-block rounded-circle mx-auto mb-2"
													style="width: 10px; height: 10px;"></span> <span
													class="font-large-1 d-block mb-2">17</span> <span>News</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-4 col-lg-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title mb-0">Developers & Admins</h4>

								</div>
								<div class="card-body">
									<div class="card-block">
										<div class="media mb-1">
											<a> <img alt="96x96"
												class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"
												src="app-assets/img/portrait/small/avatar-s-12.png">
											</a>
											<div class="media-body">
												<h4 class="font-medium-1 mt-1 mb-0">Payal</h4>
												<p class="text-muted font-small-3">Team Leader</p>
											</div>
											<div class="mt-1">
												<div
													class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
													<input type="checkbox" class="custom-control-input" checked
														id="customcheckbox1"> <label
														class="custom-control-label" for="customcheckbox1"></label>
												</div>

											</div>
										</div>
										<div class="media mb-1">
											<a> <img alt="96x96"
												class="media-object d-flex mr-3 bg-danger height-50 rounded-circle"
												src="app-assets/img/portrait/small/avatar-s-6.png">
											</a>
											<div class="media-body">
												<h4 class="font-medium-1 mt-1 mb-0">Pallavi</h4>
												<p class="text-muted font-small-3">HTML Developer</p>
											</div>
											<div class="mt-1">
												<div
													class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
													<input type="checkbox" class="custom-control-input"
														id="customcheckbox2"> <label
														class="custom-control-label" for="customcheckbox2"></label>
												</div>

											</div>
										</div>
										<div class="media mb-1">
											<a> <img alt="96x96"
												class="media-object d-flex mr-3 bg-success height-50 rounded-circle"
												src="app-assets/img/portrait/small/avatar-s-18.png">
											</a>
											<div class="media-body">
												<h4 class="font-medium-1 mt-1 mb-0">Rashmi</h4>
												<p class="text-muted font-small-3">Designer</p>
											</div>
											<div class="mt-1">
												<div
													class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
													<input type="checkbox" class="custom-control-input"
														id="customcheckbox3"> <label
														class="custom-control-label" for="customcheckbox3"></label>
												</div>

											</div>
										</div>
										<div class="media mb-1">
											<a> <img alt="96x96"
												class="media-object d-flex mr-3 bg-warning height-50 rounded-circle"
												src="app-assets/img/portrait/small/avatar-s-11.png">
											</a>
											<div class="media-body">
												<h4 class="font-medium-1 mt-1 mb-0">Sunil</h4>
												<p class="text-muted font-small-3">Database Devloper</p>
											</div>
											<div class="mt-1">
												<div
													class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
													<input type="checkbox" class="custom-control-input" checked
														id="customcheckbox4"> <label
														class="custom-control-label" for="customcheckbox4"></label>
												</div>

											</div>
										</div>
										<div class="media mb-1">
											<a> <img alt="96x96"
												class="media-object d-flex mr-3 bg-info height-50 rounded-circle"
												src="app-assets/img/portrait/small/avatar-s-3.png">
											</a>
											<div class="media-body">
												<h4 class="font-medium-1 mt-1 mb-0">Sanjay</h4>
												<p class="text-muted font-small-3">Shop Owner</p>
											</div>
											<div class="mt-1">
												<div
													class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
													<input type="checkbox" class="custom-control-input"
														id="customcheckbox5"> <label
														class="custom-control-label" for="customcheckbox5"></label>
												</div>

											</div>
										</div>


									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-4 col-lg-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Project Stats</h4>
								</div>
								<div class="card-body">

									<p class="font-medium-2 text-muted text-center">Project
										Tasks</p>
									<div id="donut-dashboard-chart" class="height-250 donut">
									</div>

									<div class="card-block">
										<div class="row mb-3">
											<div class="col">
												<span class="mb-1 text-muted d-block">23% - Started</span>
												<div class="progress" style="height: 5px;">
													<div class="progress-bar bg-success" role="progressbar"
														style="width: 23%;" aria-valuenow="23" aria-valuemin="0"
														aria-valuemax="100"></div>
												</div>
											</div>
											<div class="col">
												<span class="mb-1 text-muted d-block">14% - In
													Progress</span>
												<div class="progress" style="height: 5px;">
													<div class="progress-bar bg-amber" role="progressbar"
														style="width: 14%;" aria-valuenow="14" aria-valuemin="0"
														aria-valuemax="100"></div>
												</div>
											</div>
										</div>
										<div class="row mb-2">
											<div class="col">
												<span class="mb-1 text-muted d-block">35% - Remaining</span>
												<div class="progress" style="height: 5px;">
													<div class="progress-bar bg-deep-purple bg-lighten-1"
														role="progressbar" style="width: 35%;" aria-valuenow="35"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
											<div class="col">
												<span class="mb-1 text-muted d-block">28% - Done</span>
												<div class="progress" style="height: 5px;">
													<div class="progress-bar bg-blue" role="progressbar"
														style="width: 28%;" aria-valuenow="28" aria-valuemin="0"
														aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<footer class="footer footer-static footer-light">
				<p class="clearfix text-muted text-sm-center px-2">
					<span>Copyright &copy; 2018 <a
						href="https://themeforest.net/user/pixinvent/portfolio?ref=pixinvent"
						id="pixinventLink" target="_blank"
						class="text-bold-800 primary darken-2">PIXINVENT </a>, All rights
						reserved.
					</span>
				</p>
			</footer>

		</div>
	</div>

	<!-- END Notification Sidebar-->
	<!-- Theme customizer Starts-->
	<div
		class="customizer border-left-blue-grey border-left-lighten-4 d-none d-sm-none d-md-block">
		<a class="customizer-close"><i class="ft-x font-medium-3"></i></a><a
			id="customizer-toggle-icon" class="customizer-toggle bg-danger"><i
			class="ft-settings font-medium-4 fa fa-spin white align-middle"></i></a>
		<div data-ps-id="df6a5ce4-a175-9172-4402-dabd98fc9c0a"
			class="customizer-content p-3 ps-container ps-theme-dark">
			<h4 class="text-uppercase mb-0 text-bold-400">Theme Customizer</h4>
			<p>Customize & Preview in Real Time</p>
			<hr>
			<!-- Sidebar Options Starts-->
			<h6 class="text-center text-bold-500 mb-3 text-uppercase">Sidebar
				Color Options</h6>
			<div class="cz-bg-color">
				<div class="row p-1">
					<div class="col">
						<span style="width: 20px; height: 20px;"
							data-bg-color="pomegranate"
							class="gradient-pomegranate d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="king-yna"
							class="gradient-king-yna d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;"
							data-bg-color="ibiza-sunset"
							class="gradient-ibiza-sunset d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="flickr"
							class="gradient-flickr d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;"
							data-bg-color="purple-bliss"
							class="gradient-purple-bliss d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;"
							data-bg-color="man-of-steel"
							class="gradient-man-of-steel d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;"
							data-bg-color="purple-love"
							class="gradient-purple-love d-block rounded-circle"></span>
					</div>
				</div>
				<div class="row p-1">
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="black"
							class="bg-black d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="white"
							class="bg-grey d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="primary"
							class="bg-primary d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="success"
							class="bg-success d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="warning"
							class="bg-warning d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="info"
							class="bg-info d-block rounded-circle"></span>
					</div>
					<div class="col">
						<span style="width: 20px; height: 20px;" data-bg-color="danger"
							class="bg-danger d-block rounded-circle"></span>
					</div>
				</div>
			</div>

			<hr>

			<h6 class="text-center text-bold-500 mb-3 text-uppercase">Sidebar
				Bg Image</h6>
			<div class="cz-bg-image row">
				<div class="col mb-3">
					<img src="app-assets/img/sidebar-bg/01.jpg" width="90"
						class="rounded">
				</div>
				<div class="col mb-3">
					<img src="app-assets/img/sidebar-bg/02.jpg" width="90"
						class="rounded">
				</div>
				<div class="col mb-3">
					<img src="app-assets/img/sidebar-bg/03.jpg" width="90"
						class="rounded">
				</div>
				<div class="col mb-3">
					<img src="app-assets/img/sidebar-bg/04.jpg" width="90"
						class="rounded">
				</div>
				<div class="col mb-3">
					<img src="app-assets/img/sidebar-bg/05.jpg" width="90"
						class="rounded">
				</div>
				<div class="col mb-3">
					<img src="app-assets/img/sidebar-bg/06.jpg" width="90"
						class="rounded">
				</div>
			</div>

			<hr>

			<div class="togglebutton">
				<div class="switch">
					<span>Sidebar Bg Image</span>
					<div class="float-right">
						<div class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
							<input id="sidebar-bg-img" type="checkbox" checked=""
								class="custom-control-input cz-bg-image-display"> <label
								for="sidebar-bg-img" class="custom-control-label"></label>
						</div>
					</div>
				</div>
			</div>

			<hr>

			<div class="togglebutton">
				<div class="switch">
					<span>Compact Menu</span>
					<div class="float-right">
						<div class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
							<input id="cz-compact-menu" type="checkbox"
								class="custom-control-input cz-compact-menu"> <label
								for="cz-compact-menu" class="custom-control-label"></label>
						</div>
					</div>
				</div>
			</div>

			<hr>

			<div>
				<label for="cz-sidebar-width">Sidebar Width</label> <select
					id="cz-sidebar-width"
					class="custom-select cz-sidebar-width float-right">
					<option value="small">Small</option>
					<option value="medium">Medium</option>
					<option value="large">Large</option>
				</select>
			</div>


			<!--  modal start -->

			<!-- Modal -->
			<div class="modal fade" id="welcomeModal" tabindex="-1" role="dialog"
				aria-labelledby="welcomeModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="welcomeModalLabel">Welcome</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">

							<p>
								Hello
								<%=session.getAttribute("username")%>, welcome to your
								homepage.
							</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>

			<script>
				$(document).ready(function() {
					$('#welcomeModal').modal('show');
				});
			</script>


			<!--  modal end  -->



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

	<script src="app-assets/vendors/js/chartist.min.js"
		type="text/javascript"></script>

	<script src="app-assets/js/app-sidebar.js" type="text/javascript"></script>
	<script src="app-assets/js/notification-sidebar.js"
		type="text/javascript"></script>
	<script src="app-assets/js/customizer.js" type="text/javascript"></script>

	<script src="app-assets/js/dashboard1.js" type="text/javascript"></script>

</body>

<!-- Mirrored from pixinvent.com/apex-angular-4-bootstrap-admin-template/html-demo-2/ by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 13 Apr 2018 07:11:55 GMT -->
</html>