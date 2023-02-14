

<%@page import="java.util.*"%>
<%@page import="com.codeo.shop.dbutil.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.my_profile {
	color: red;
	position: center;
}

.table table-user-information {
	-webkit-text-size-adjust: 100%;
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: #333;
	box-sizing: border-box;
	border-spacing: 0;
	border-collapse: collapse;
	background-color: transparent;
	width: 100%;
	max-width: 100%;
	margin-bottom: 0;
}
</style>

</head>
<body>


<% 
HttpSession session2 = request.getSession();
String user_name=(String)session2.getAttribute("UserName");
if(user_name==null){ %>
	<div class="modal" tabindex="-1" id="MyProfile">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">My Profile</h3>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <h4>You are not login, login first.</h4>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <a href="loginfrom.jsp"><button type="button" class="btn btn-primary">Login</button></a>
	         <a  href="RegistrationForm.jsp"><button type="button" class="btn btn-primary">Register</button></a>
	      </div>
	    </div>
	  </div>
	</div>

<%
	return;
}
	%>



	<!-- My Profile modal Start-->


	<!--My Profile Modal -->
	<div class="modal fade" id="MyProfile" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="my_profile" id="exampleModalLabel">My Profile</h3>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div>
						<section style="background-color: #eee;">

							<div class="card mb-4">
								<div >

									<div class="card-body text-center" style="text-align:center;">
										<img
											src="img/hero/icon.png"
											alt="avatar" class="rounded-circle img-fluid"
											style="width: 150px;">
									</div>

									<%
									
									int user_id = (int) session2.getAttribute("userid");
									String select_product = "select * from user_registration where user_id=" + user_id;
									Connection con = ConnectionProvider.getconnection();
									Statement stmt = con.createStatement();
									ResultSet rs = stmt.executeQuery(select_product);

									while (rs.next()) {
										String User_MoNo = String.valueOf(rs.getString("user_mobno"));
									%>
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td><strong> <span
														class="glyphicon glyphicon-asterisk text-primary"></span>
														Full Name
												</strong></td>
												<td class="text-primary">:  <%=rs.getString("user_name")%></td>
											</tr>
											<tr>
												<td><strong> <span
														class="glyphicon glyphicon-asterisk text-primary"></span>
														Contact Details
												</strong></td>
												<td class="text-primary">:<%=User_MoNo%></td>
											</tr>
											<tr>
												<td><strong> <span
														class="glyphicon glyphicon-asterisk text-primary"></span>
														Email Id
												</strong></td>
												<td class="text-primary">:  <%=rs.getString("user_emailid")%></td>
											</tr>
											<tr>
												<td><strong> <span
														class="glyphicon glyphicon-asterisk text-primary"></span>
														Addresss
												</strong></td>
												<td class="text-primary">:  <%=rs.getString("user_adderess")%></td>
											</tr>
										</tbody>
									</table>
									

									

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal" data-toggle="modal" data-bs-dismiss="modal" data-target="#UpdateProfile">Edit Info</button>
									<button id='closeModal' type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
								</div>
								
								<a	href="Productoperation?action=DELETE&id=<%=rs.getString("prod_id")%>">
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- My Profile end -->



	<!--Update Profile Modal -->
	<div class="modal fade" id="UpdateProfile" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="my_profile" id="exampleModalLabel">My Profile</h3>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div>
						<section style="background-color: #eee;">

							<div class="card mb-4">
								<div >

									<div class="card-body text-center" style="text-align:center;">
										<img
											src="img/hero/icon.png"
											alt="avatar" class="rounded-circle img-fluid"
											style="width: 150px;">
									</div>

									
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td><strong> <span
														class="glyphicon glyphicon-asterisk text-primary"></span>
														Full Name
												</strong></td>
												<td class="text-primary">:  <%=rs.getString("user_name")%></td>
											</tr>
											<tr>
												<td><strong> <span
														class="glyphicon glyphicon-asterisk text-primary"></span>
														Contact Details
												</strong></td>
												<td class="text-primary">:<%=User_MoNo%></td>
											</tr>
											<tr>
												<td><strong> <span
														class="glyphicon glyphicon-asterisk text-primary"></span>
														Email Id
												</strong></td>
												<td class="text-primary">:  <%=rs.getString("user_emailid")%></td>
											</tr>
											<tr>
												<td><strong> <span
														class="glyphicon glyphicon-asterisk text-primary"></span>
														Addresss
												</strong></td>
												<td class="text-primary">:  <%=rs.getString("user_adderess")%></td>
											</tr>
										</tbody>
									</table>
									

									<%
									}
									%>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal"  >Cancel</button>
									<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#UpdateProfile">Update
										</button>
								</div>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- My Profile end -->

</body>
</html>