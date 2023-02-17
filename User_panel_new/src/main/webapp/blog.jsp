<!DOCTYPE html>
<html lang="zxx">


<%@page import="java.util.*"%>
<%@page import="com.codeo.shop.entity.Blog"%>
<%@page import="com.codeo.shop.entity.Category"%>
<%@page import="com.codeo.shop.Dao.CategoryDao"%>
<%@page import="com.codeo.shop.Dao.ProductDaoImp"%>
<%@page import="com.codeo.shop.dbutil.ConnectionProvider"%>


<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Online Electrical Shopee</title>

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
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>


	<jsp:include page="header.jsp" />

	<!-- Hero Section Begin -->
	<section class="hero hero-normal">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>All departments</span>
						</div>
						<ul>
							<li><a href="#">Fresh Meat</a></li>
							<li><a href="#">Vegetables</a></li>
							<li><a href="#">Fruit & Nut Gifts</a></li>
							<li><a href="#">Fresh Berries</a></li>
							<li><a href="#">Ocean Foods</a></li>
							<li><a href="#">Butter & Eggs</a></li>
							<li><a href="#">Fastfood</a></li>
							<li><a href="#">Fresh Onion</a></li>
							<li><a href="#">Papayaya & Crisps</a></li>
							<li><a href="#">Oatmeal</a></li>
							<li><a href="#">Fresh Bananas</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<div class="hero__search__categories">
									All Categories <span class="arrow_carrot-down"></span>
								</div>
								<input type="text" placeholder="What do yo u need?">
								<button type="submit" class="site-btn">SEARCH</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-phone"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>+65 11.188.888</h5>
								<span>support 24/7 time</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg" data-setbg="img/Name-bg.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Blog</h2>
						<div class="breadcrumb__option">
							<a href="./index.jsp">Home</a> <span>Blog</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Blog Section Begin -->
	<section class="blog spad">
		<div class="container">
			
				
					<div class="row">
					
						<%
						ProductDaoImp productdao = new ProductDaoImp();

						List<Blog> bloglist = productdao.getAllBlogs();
						for (Blog blog : bloglist) {
							String blod_detail = blog.getBlog_description();
							String[] str = blod_detail.split(" ");
							String res = "";
							for (int i = 1; i <= 20; i++) {
								res = res + str[i] + " ";
							}
						%>

						<div class="col-md-4">
						
							<div style="left-padding: 20px;" class="blog__item">
								<div class="blog__item__pic">
									<img src="img/blog/<%=blog.getBlog_name()%>" alt="">
								</div>
								<div class="blog__item__text">
									<ul>
										<li><i class="fa fa-calendar-o"></i> dec 4,2022</li>
										<li><i class="fa fa-comment-o"></i> 5</li>
									</ul>
									<h5>
										<a href="#"><%=blog.getBlog_title()%></a>
									</h5>
									<p><%=res%>......
									</p>
									<a href="blog-details.jsp?blog=<%=blog.getB_id()%>"
									
										class="blog__btn">READ MORE <span class="arrow_right"></span></a>
								</div>
							</div>
						</div>

						<%
						}
						%>


					
				</div>
			
		</div>
	</section>
	<!-- Blog Section End -->


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
								<li><i class="fa fa-calendar-o"></i> dec 4,2022</li>
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



</body>

</html>