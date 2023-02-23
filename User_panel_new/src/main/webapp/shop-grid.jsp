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
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/CommonScript.js"></script>
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<jsp:include page="header.jsp" />

	<%     //out.println(cat);
    		             CategoryDao categorydao = new CategoryDao(); 
                         List<Category> clist = categorydao.getCategoryList();
                            
                            ProductDaoImp productdao = new ProductDaoImp();
                          //  List<Product> prodlist= productdao.getAllProducts();
        %>

	

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg" data-setbg="img/Name-bg.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Online Electrical Shopee</h2>
						<div class="breadcrumb__option">
							<a href="./index.jsp">Home</a> <span>Shop</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

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

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							 <span><a style="color: white">ALLCATEGORIES </a> </span><br>
						</div>
							<ul>

								
								<li><a href="shop-grid.jsp"
									onMouseOver="this.style.color='red'"
									onMouseOut="this.style.color='green'">All CATEGORIES 
								</a></li>
								

							

								<%  for(Category c : clist) {  %>
								<li><a href="shop-grid.jsp?category=<%=c.getId()%>"
									onMouseOver="this.style.color='red'"
									onMouseOut="this.style.color='green'"> <%= c.getCat_title().toUpperCase() %>
								</a></li>
								<%  }  %>

							</ul>
						</div>
						<div class="sidebar__item">
							<h4>Price</h4>
							<div class="price-range-wrap">
								<div
									class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
									data-min="10" data-max="540">
									<div class="ui-slider-range ui-corner-all ui-widget-header"></div>
									<span tabindex="0"
										class="ui-slider-handle ui-corner-all ui-state-default"></span>
									<span tabindex="0"
										class="ui-slider-handle ui-corner-all ui-state-default"></span>
								</div>
								<div class="range-slider">
									<div class="price-input">
										<input type="text" id="minamount"> <input type="text"
											id="maxamount">
									</div>
								</div>
							</div>
						</div>

						<div class="sidebar__item sidebar__item__color--option">
							<h4>Colors</h4>
							<div class="sidebar__item__color sidebar__item__color--white">
								<label for="white"> White <input type="radio" id="white">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--gray">
								<label for="gray"> Gray <input type="radio" id="gray">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--red">
								<label for="red"> Red <input type="radio" id="red">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--black">
								<label for="black"> Black <input type="radio" id="black">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--blue">
								<label for="blue"> Blue <input type="radio" id="blue">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--green">
								<label for="green"> Green <input type="radio" id="green">
								</label>
							</div>
						</div>
						<div class="sidebar__item">
							<h4>Popular Size</h4>
							<div class="sidebar__item__size">
								<label for="large"> Large <input type="radio" id="large">
								</label>
							</div>
							<div class="sidebar__item__size">
								<label for="medium"> Medium <input type="radio"
									id="medium">
								</label>
							</div>
							<div class="sidebar__item__size">
								<label for="small"> Small <input type="radio" id="small">
								</label>
							</div>
							<div class="sidebar__item__size">
								<label for="tiny"> Tiny <input type="radio" id="tiny">
								</label>
							</div>
						</div>
						
						 
						<div class="sidebar__item">
						
							<div class="latest-product__text">
							
							</div>
						</div> 
					</div>
				

      

				<div class="col-lg-9 col-md-7">
					<div class="product__discount">
						<div class="row">
							<%  for(Product product :prodlist)  {  %>

							<div class="col-lg-4 col-md-6 col-sm-6">
							<div style="border: 1px solid grey; " class="mt-5">
								<div class="product__item m-4">
									<div class="featured__item__pic set-bg"
										style="background-image: url(&quot;img/latest-product/<%=product.getProd_imageName() %>&quot;);">
										<img style="max-height: 200px; height:auto; " class="center" src="img/latest-product/<%=product.getProd_imageName() %>">
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
											<li><a href="#"><i class="fa fa-retweet"></i></a></li>
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>

									<div class="product__item__text">
										<h5>
											<a href="Product-details.jsp?product=<%=product.getId() %>"
												style="color: black"><%=product.getProd_name() %> </a>
										</h5>
										<!--    <h5> <span>&#8377; </span><%=product.getProd_price() %> </h5> <br>  -->
										<button type="button" class="btn btn-light">
											<h5>
												&#8377;<%=product.getPriceAfterDiscount() %>/- <span
													style="font-size: 15px; font-style: italic; text-decoration: line-through; color: red">
													<%=product.getProd_price() %> , <%=product.getProd_discount() %>
													%off
												</span>
											</h5>
										</button>


										<button  class="primary-btn"
											
											onMouseOver="this.style.backgroundColor='#808080'"
											onMouseOut="this.style.backgroundColor='red'" 
											onclick="add_to_cart(<%=product.getId()%>, '<%=product.getProd_name()%>', <%=product.getPriceAfterDiscount()%>, '<%=product.getProd_imageName() %>')"> <i
											class="fa fa-shopping-cart"></i>ADD TO CARD</button>
											 <div > <a href="shoping-cart.jsp" class="btn btn-warning btn-sm mt-1">  View CART </a></div>
								

									</div>
								</div>
								</div>
							</div>
							<%  } %>
						</div>
					</div>

					<div class="product__pagination">
						<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#"><i
							class="fa fa-long-arrow-right"></i></a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Section End -->
	
	
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