function add_to_cart(id,prod_name,prod_price,prod_imageName)
{
	let cart= localStorage.getItem("cart");
	if(cart==null)
	{
		//no cart yet 
		let products=[];
		let product={id:id,prod_name:prod_name,prod_price:prod_price,prod_imageName:prod_imageName}
		
		products.push(product);
		localStorage.setItem("cart",JSON.stringify(products));
		console.log("product is added for first time ")
	}
	else
	{
		//cart is already present 
		let pcart=JSON.parse(cart);
		
		let oldProduct=pcart.find((item)=>item.id=id)
		
		if(oldProduct)
		{ //we have to increase the quantity 
			oldProduct.productQuantity=oldProduct.productQuantity+1
			pcart.map((item)=>{
				
				if(item.id==oldProduct.id)
				{
					item.productQuantity=oldProduct.productQuantity;
				}
			})
			localStorage.setItem("cart",JSON.stringify(pcart))
			console.log("product quantity is incresed ")
		}
		else
		{ // we have to add the product
		let product={id:id,prod_name:prod_name,prod_price:prod_price,prod_imageName:prod_imageName}
		pcart.push(product)
		localStorage.setItem("cart",JSON.stringify(pcart))	
		console.log("product is added")
		}
	}
	
}