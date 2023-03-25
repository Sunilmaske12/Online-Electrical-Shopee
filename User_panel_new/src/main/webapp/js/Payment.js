//=============Payment Started=============


function onlinePayment(){
	console.log("working started");
	let orderId=$("#orderId").val();
	let amount1=$("#totalPricePay").val();
	console.log("==============");
	console.log(amount1);
	console.log(orderId);
	let options={
		key:"rzp_test_7TxMC9UB8XmbM0",
		amount:"900",
		currency:"INR",
		name:"ONLINE ELECTRICAL SHOPEE",
		description:"Payment",
		image:"img/N_logo.jpg",
		order_id:orderId,
		
		prefill: {
			name:"",
			email:"",
			contact:"",
		},
		notes:{
			address:"shdjsk",
		},
		theme:{
			color:"red",
		},
	};

	let rzp=new Razorpay(options);
	rzp.open();
}











