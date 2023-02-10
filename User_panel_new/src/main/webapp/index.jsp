

<%

	 HttpSession session1=request.getSession();
String user_name=(String)session1.getAttribute("UserName");
String user_email=(String)session1.getAttribute("UserEmail");
	//String user=(String)session1.getAttribute("usertype");
	//String user_email=(String)session1.getAttribute("email");
	//System.out.println("======================"+user_name+"===================="+ user_email +"==============================");
	//String user_name=(String)session1.getAttribute("UserName");
	//if(user==null){
	//	
	//	session.setAttribute("message", "You are not logged in, Logged in first as a admin");
	//	response.sendRedirect("loginfrom.jsp");
	//	return;
	//}
	//else if(user.equals("Admin")){
	//	session.setAttribute("message", "You are not Normal User, Logged in first as a User");
	//	response.sendRedirect("loginfrom.jsp");
	//	return;
	//}
	
	//else if(user.equals("Normal User")){
		
		
	//}
	
	//else{
	//	session.setAttribute("message", "Invalid User");
	//	response.sendRedirect("loginfrom.jsp");
	//	return;
	//}
	
	%>


<!DOCTYPE html>
<html lang="zxx">
<%@page import="java.util.*"%>
<%@page import="com.codeo.shop.entity.Product"%>
<%@page import="com.codeo.shop.entity.Category"%>
<%@page import="com.codeo.shop.Dao.CategoryDao"%>
<%@page import="com.codeo.shop.Dao.ProductDaoImp"%>
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Online Electrical Shopee</title>

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
</head>

<body>
 
 <!--  modal start            <h1>Welcome User <%= request.getAttribute("username") %></h1>
		
  -->

 <!-- Modal -->
<div class="modal fade" id="welcomeModal" tabindex="-1" role="dialog" aria-labelledby="welcomeModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="welcomeModalLabel">Welcome</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
        <p>Hello <%= session.getAttribute("username") %>, welcome to your homepage.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
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
 
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<jsp:include page="header.jsp" />
	<!--  for product and category  -->

	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all"
							style="background-color: #87CEEB">
							<i class="fa fa-bars"></i> <span><a
								href="index.jsp?category=all" style="color: white">All
									Categories </a> </span>
						</div>
						<ul>
							<%    
            //out.println(cat);
    		         CategoryDao categorydao = new CategoryDao(); 
                     List<Category> clist = categorydao.getCategoryList();
                     ProductDaoImp productdao = new ProductDaoImp();
           //  List<Product> prodlist= productdao.getAllProducts();
                 %>
							<%  for(Category c : clist) {  %>
							<li><a href="index.jsp?category=<%= c.getId() %>"
								onMouseOver="this.style.color='red'"
								onMouseOut="this.style.color='black'"> <%= c.getCat_title() %>
							</a></li>
							<%  }  %>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<input type="text" placeholder="What do yo u need?">
								<button type="submit" class="site-btn"
									style="background-color: #87CEEB">SEARCH</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<img  alt="icon" src="img/hero/icon.png"> 
							</div>
							<div class="hero__search__phone__text">
								<h5>WELCOME <%if(user_name!=null){%>  </h5>
								<h4 class=" font-weight-bold" style="color: green"> <%=user_name.toUpperCase() %> </h4>
								<%} %>
							</div>
						</div>
					</div>
					<div class="hero__item set-bg" data-setbg="img/hero/banner.jpg">
						<div class="hero__text">
							<span>Electrical Appliances</span>
							<h2>
								Online <br />Electrical Shopee
							</h2>
							<p>Free Pickup and Delivery Available</p>
							<a href="#" class="primary-btn" style="background-color: #87CEEB">SHOP
								NOW</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<%  //working here start

                     String cat = request.getParameter("category");

                           List<Product> prodlist = null;
                            
                       if(cat==null||cat.trim().equals("all"))
                        {
                       prodlist = productdao.getAllProducts();
                        }
                      else {
                       	  
                          int id =Integer.parseInt(cat.trim());
                          prodlist = productdao.getAllProductsById(id);
                    }   //working here end 

     %>

	<!--   Featured Section Begin -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Featured Product</h2>
					</div>
					<div class="featured__controls">
						<ul>
							<%  for(Category c : clist) { %>

							<li><a href="index.jsp?category=<%=c.getId() %>"
								onMouseOver="this.style.color='red'"
								onMouseOut="this.style.color='black'"><%= c.getCat_title() %>
							</a></li>

							<%  }  %>
						</ul>
					</div>
				</div>
			</div>

			<div class="row featured__filter">
				<%   
                    // List<Product> list = productdao.getAllProducts();
                     for(Product product:prodlist)
                    {   //System.out.println(product.getProd_description()); %>
				<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
					<div class="featured__item">
						<div class="featured__item__pic set-bg"
							data-setbg="img/latest-product/<%=product.getProd_imageName() %>"
							style="background-image: url(&quot;img/latest-product/<%=product.getProd_imageName() %>&quot;);">

							<ul class="featured__item__pic__hover">
								<li><a href="#"><i class="fa fa-heart"></i></a></li>
								<li><a href="#"><i class="fa fa-retweet"></i></a></li>
							</ul>
						</div>

						<div class="featured__item__text">
							<h5>
								<a href="Product-details.jsp?product=<%=product.getId() %>"
									style="color: black"><%=product.getProd_name() %></a>
							</h5>
							<!--   <h6><%=product.getProd_description() %></h6> -->
							<!--  <h5> <span>&#8377; </span><%=product.getProd_price() %> </h5> <br> -->
							<button type="button" class="btn btn-light">
								<h5>
									&#8377;<%=product.getPriceAfterDiscount() %>/- <span
										style="font-size: 15px; font-style: italic; text-decoration: line-through; color: red">
										<%=product.getProd_price() %> ,<%=product.getProd_discount() %>
										off
									</span>
								</h5>
							</button>

							<a href="#" class="primary-btn" style="background-color: #87CEEB" onclick="add_to_cart(<%=product.getId()%>,<%=product.getProd_name() %>,<%=product.getPriceAfterDiscount()%>,<%=product.getProd_imageName() %>)" onMouseOver="this.style.backgroundColor='#808080'"
								onMouseOut="this.style.backgroundColor='#87CEEB'">
								 <i class="fa fa-shopping-cart"></i>ADD TO CARD </a>
						</div>
					</div>
				</div>

				<%  } %>

			</div>

		</div>
	</section>
	<!-- Featured Section End -->

	<!-- Categories Section Begin -->
	<section class="categories">
		<div class="container">
			<div class="row">
				<div class="categories__slider owl-carousel">
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="img/categories/cat.1.jpg">
							<h5>
								<a href="#">Mixer Grinder</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="img/categories/cat.2.jpg">
							<h5>
								<a href="#">Switches</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="img/categories/cat.3.jpg">
							<h5>
								<a href="#">Fan</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="img/categories/cat.4.jpg">
							<h5>
								<a href="#">Light</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="img/categories/cat.5.jpg">
							<h5>
								<a href="#">Press</a>
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Categories Section End -->
	<br>
	<br>
	<br>

	<!-- Banner Begin -->
	<div class="banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="img/banner/home.jpg" alt="">
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="img/banner/lighthome.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner End -->

	<!-- Blog Section Begin -->
	<section class="from-blog spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title from-blog__title">
						<h2>From The Blog</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="img/banner/beaty.jpg" alt="">
						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#"> Beautify your place, with its grace </a>
							</h5>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="img/banner/livingroom.jpg" alt="">
						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#">Beautify your place, with its grace </a>
							</h5>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="img/banner/lighthome.jpg" alt="">
						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#"> Beautify your place, with its grace </a>
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Blog Section End -->
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

</body>

</html>