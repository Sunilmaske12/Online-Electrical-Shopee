//================== Cart started=============================

function add_to_cart(pid, pname, pprice, pimagename)
{
	let cart=localStorage.getItem("cart");
	
	//no products in cart
	if(cart==null){
			let Product =[];
			let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: pprice, pImageName:pimagename}
			Product.push(product);
			localStorage.setItem("cart", JSON.stringify(Product));	
			showToast("Product is added to cart")
	}
	
	//already some products in cart
	else{
		let pcart=JSON.parse(cart);
		
		let oldProduct= pcart.find((item)=> item.productId==pid)
		
		
		if(oldProduct){
			//if cart have old product then just increase quantity
			oldProduct.productQuantity = oldProduct.productQuantity+1
			pcart.map((item) =>{
				if(item.productId == oldProduct.productId){
					item.productQuantity = oldProduct.productQuantity;
				}
			})
			localStorage.setItem("cart", JSON.stringify(pcart));
			showToast("product quantity is increases")
		}
		
		
		else{
			//we get new product then add it into a cart
			let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: pprice,  pImageName:pimagename}
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart));
    		showToast("product  is added")
		}
	}
	updateCart();
	
}


//update cart
function updateCart(){
	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);
	if(cart == null || cart.length == 0){
		console.log("cart is empty")
		$(".cartItem").html("0");
		$(".totalOrder").html("00.00");
		$(".totalPrice").html("00.00");
		$(".charges").html("00.00");
		$("#product").html("00.00");
		
		$(".shoping_cart_body").html("<h1>Cart Does Not Have Any Items</h1>");
	}else{
		$("#product").html(` ${cart.length}`);
		console.log(cart.length)
		$(".cartItem").html(` ${cart.length}`);
		 $('#cartlegth').val(`${cart.length}`);
	
		let table=`
		
		<table>
							<thead>
								<tr>
									<th class="shoping__product">Products</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
									<th>Remove</th>
									
								</tr>
							</thead>
							`;
							let totalPrice=0;
							cart.map((item)=>{
								table+=`
								
								<tbody>
								<tr>
									<td class="shoping__cart__item"><img
										src="img/latest-product/${item.pImageName}"
										alt="product_image" style="height: 80px">
										<h5> ${item.productName}</h5></td>
									
									<td class="shoping__cart__price"> ${item.productPrice}</td>


									<td><input type="button"onclick='decrementQuantity(${item.productId})' value="-"/>
									
									 <input name="quantity" value="${item.productQuantity}" maxlength="2" max="10"
										size="1" /> 
										<input type="button" onclick='incrementQuantity(${item.productId})' value="+"/></td>
									<td class="shoping__cart__total">${item.productQuantity * item.productPrice} </td>

									<td><button class="remove-btn" onclick='deleteItemCart(${item.productId})'>Remove</button></td>

									
								</tr>
							</tbody> `
							
						totalPrice = totalPrice + item.productPrice*item.productQuantity;
							})
							
							
		table= table+`</table>	`
		$(".shoping_cart_body").html(table);
		if(totalPrice>999){
			$(".charges").html("Rs.00.00");
			$(".totalPrice").html(`Rs. ${totalPrice}`);
		}else{
			$(".charges").html("Rs.100");
			$(".totalPrice").html(`Rs. ${totalPrice+ 100} `);
		}
		
		$(".totalOrder").html(`Rs. ${totalPrice}`);
		
		 $('#totalPrice').val(`${totalPrice}`);
			
		let checkout=`
			
					<table>
							<thead>
								<tr class="checkout__order__products"><th>Products</th>
									<th>Quantity</th>
									<th>Price</th>
								<tr>
							</thead>
						`;
						var i=0;
					cart.map((item)=>{ 
						i+=1;
				checkout+=`
						<tbody>
								<tr>
									<td>${i} . ${item.productName}</td>
									<td> ${item.productQuantity}</td>
									<td> ${item.productPrice * item.productQuantity}</td>
								</tr>
						</tbody>
						`
						
			})
			checkout+=`</table>`
		
		$(".check").html(checkout);
		
		
	}
	
	
	//=============making orders=================
							var i=0;
								cart.map((item)=>{
								
								i+=1
								 $('#productIdO'+i).val(`${item.productId}`);
								  $('#productNameO'+i).val(`${item.productName}`);
								   $('#productQuantityO'+i).val(`${item.productQuantity}`);
								    $('#productPriceO'+i).val(`${item.productPrice}`);
								 
							
											
							
							})
							
		
	//===============================
	
	
	}
	
	
	//delete item from cart
	function deleteItemCart(pid){
	let cart=JSON.parse(localStorage.getItem("cart"));
	
	let newcart=cart.filter((item) => item.productId !=pid)
	
	localStorage.setItem('cart', JSON.stringify(newcart))
	updateCart();
	}
	
	
	
	
	
	//increment quantity in cart
	function incrementQuantity(pid){
	
	let cart=JSON.parse(localStorage.getItem("cart"));
	
	let oldProduct=cart.find((item) => item.productId ==pid)
	oldProduct.productQuantity=oldProduct.productQuantity+1
	
	cart.map((item) =>{
				if(item.productId == oldProduct.productId){
					item.productQuantity = oldProduct.productQuantity;
				}
			})
	
	localStorage.setItem("cart", JSON.stringify(cart));
			console.log("product quantity is increases")
	updateCart();
	}
	
	
	//decrement quantity in cart
	function decrementQuantity(pid){
	
	let cart=JSON.parse(localStorage.getItem("cart"));
	
	let oldProduct=cart.find((item) => item.productId ==pid)
	if(oldProduct.productQuantity>1){
	oldProduct.productQuantity=oldProduct.productQuantity-1
	
	cart.map((item) =>{
				if(item.productId == oldProduct.productId){
					item.productQuantity = oldProduct.productQuantity;
					
				}
			})
			console.log("product quantity is decreases")
			localStorage.setItem("cart", JSON.stringify(cart));
			updateCart();
			}
	}
	
	
	//clear cart
	function clearCart(){
	localStorage.clear();
	updateCart();
	}
	
	
	
		
	//cart update function calling
	$(document).ready(function(){
		updateCart()
	})
	
	//================== Cart end=============================
	
	
//==================Product Added message==================
function showToast(content){
	$("#toast").addClass("display");
		setTimeout( ()=>{
			$("#toast").removeClass("display");
			},2000)	
			
	$("#toast").html(content);
}




















	
	