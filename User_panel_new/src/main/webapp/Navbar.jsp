
<%
HttpSession session3 = request.getSession();
String admin_name = (String) session3.getAttribute("UserName");
int admin_id = (int) session3.getAttribute("userid");
%>
<%@page import="com.codeo.shop.Dao.NotificationDao"%>
<html>
<head>

</head>
<body data-col="2-columns" class=" 2-columns ">
	<jsp:include page="CommonModal.jsp" />


	<!-- Navbar (Header) Starts-->
	<nav class="navbar navbar-expand-lg navbar-light bg-faded">
		<div class="container-fluid">
			<div class="navbar-header">

				<%
				if (admin_name != null) {
				%>
				<h3 style="color: red;" class="font-weight-bold">
					Welcome :
					<%=admin_name%>
				</h3>
				<%
				}
				%>
				<button type="button" data-toggle="collapse"
					class="navbar-toggle d-lg-none float-left">

					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="navbar-container">
				<div id="navbarSupportedContent" class="collapse navbar-collapse">
					<ul class="navbar-nav">

						<li class="dropdown nav-item"><a id="dropdownBasic3" href="#"
							data-toggle="dropdown"
							class="nav-link position-relative dropdown-toggle"><i
								class="ft-flag font-medium-3 blue-grey darken-4"></i><span
								class="selected-language d-none"></span></a>
							<div class="dropdown-menu dropdown-menu-right">
								<a href="javascript:;" class="dropdown-item py-1"> <img
									src="app-assets/img/flags/us.png" class="langimg" /><span>
										English</span></a><a href="javascript:;" class="dropdown-item py-1"><img
									src="app-assets/img/flags/es.png" class="langimg" /><span>
										Spanish</span></a><a href="javascript:;" class="dropdown-item py-1"><img
									src="app-assets/img/flags/br.png" class="langimg" /><span>
										Portuguese</span></a><a href="javascript:;" class="dropdown-item"><img
									src="app-assets/img/flags/de.png" class="langimg" /><span>
										French</span></a>
							</div></li>

						<%
						int newUser = NotificationDao.getNewUser();
						int newOrder = NotificationDao.getNewOrder();
						int newQuery = NotificationDao.getNewQuery();
						int notification = 0;
						if (newUser != 0) {
							notification += 1;
						}
						if (newOrder != 0) {
							notification += 1;
						}
						if (newQuery != 0) {
							notification += 1;
						}
						%>
						<li class="dropdown nav-item"><a id="dropdownBasic2" href="#"
							data-toggle="dropdown"
							class="nav-link position-relative dropdown-toggle"><i
								class="ft-bell font-medium-3 blue-grey darken-4"></i><span
								class="notification badge badge-pill badge-danger"><%=notification%></span>
						</a>
							<div
								class="notification-dropdown dropdown-menu dropdown-menu-right">
								<div class="noti-list">
									<a href="ViewOrderAdmin.jsp"
										class="dropdown-item noti-container py-3 border-bottom border-bottom-blue-grey border-bottom-lighten-4"><i
										class="ft-bell info float-left d-block font-large-1 mt-1 mr-2"></i><span
										class="noti-wrapper"><span
											class="noti-title line-height-1 d-block text-bold-400 info"><%if(newOrder!=0){ %><span
												style="color: #8B0000; font-size: 150%;"><%=newOrder%></span><%} else{%>No Any <%} %>
												New Order Received</span><span class="noti-text"> Click Here, To See All New Orders.</span></span>
									</a>
									<a href="UserList.jsp"
										class="dropdown-item noti-container py-3 border-bottom border-bottom-blue-grey border-bottom-lighten-4"><i
										class="ft-bell warning float-left d-block font-large-1 mt-1 mr-2"></i><span
										class="noti-wrapper"><span
											class="noti-title line-height-1 d-block text-bold-400 warning"><%if(newUser!=0){ %><span
												style="color: #8B0000; font-size: 150%;"><%=newUser%></span><%} else{%>No Any <%} %>
												New User Registered</span><span class="noti-text"> Click Here, To See All New User.</span></span></a>
									<a href="support.jsp" class="dropdown-item noti-container py-3 border-bottom border-bottom-blue-grey border-bottom-lighten-4"><i
										class="ft-bell danger float-left d-block font-large-1 mt-1 mr-2"></i><span
										class="noti-wrapper"><span
											class="noti-title line-height-1 d-block text-bold-400 danger"><%if(newQuery!=0){ %><span
												style="color: #8B0000; font-size: 150%;"><%=newQuery%></span><%} else{%>No Any <%} %>
												New Query Received</span><span class="noti-text"> Click Here, To See All New Query.</span></span></a> 
									
								</div>
								<%if(notification!=0){ %><a
									class="noti-footer primary text-center d-block border-top border-top-blue-grey border-top-lighten-4 text-bold-400 py-1">Read
									All Notifications</a><%} else{ %>
									<a class="noti-footer primary text-center d-block border-top border-top-blue-grey border-top-lighten-4 text-bold-400 py-1">No
									Any Notifications</a>
									<%} %>
							</div></li>
						<%
						if (admin_name != null) {
						%>




						<li class="dropdown nav-item"><a id="dropdownBasic3" href="#"
							data-toggle="dropdown"
							class="nav-link position-relative dropdown-toggle"> <i
								class="ft-user font-medium-3 blue-grey darken-4"></i>
						</a>
							<div aria-labelledby="dropdownBasic3"
								class="dropdown-menu dropdown-menu-right">
								<a href="javascript:;" class="dropdown-item py-1"> <span><%=admin_name%>
										(Admin Manager)</span></a> <a href="javascript:;"
									class="dropdown-item py-1"><span>AID: <%=admin_id%></span></a>
								<div class="dropdown-divider"></div>
								<a href="javascript:;" class="dropdown-item py-1"><i
									class="ft-edit mr-2"></i><span data-toggle="modal"
									data-target="#AdminProfile">Edit Profile</span></a> <a
									href="loginfrom.jsp;" class="dropdown-item"><i
									class="ft-power mr-2"></i><span>Logout</span></a>
							</div></li>
						<%
						}
						%>

					</ul>
				</div>
			</div>
		</div>
	</nav>


</body>

</html>