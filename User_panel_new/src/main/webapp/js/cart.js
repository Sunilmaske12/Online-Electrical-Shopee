function incrementValue(id) {
	  var value = parseInt(document.getElementById("number-" + id).value, 10);
	  value = isNaN(value) ? 1 : value + 1;
	  document.getElementById("number-" + id).value = value;
	  calculateTotalPrice(id);
	}

	function decrementValue(id) {
	  var value = parseInt(document.getElementById("number-" + id).value, 10);
	  value = isNaN(value) || value <= 1 ? 1 : value - 1;
	  document.getElementById("number-" + id).value = value;
	  calculateTotalPrice(id);
	}

	function calculateTotalPrice(id) {
	  var quantity = parseInt(document.getElementById("number-" + id).value, 10);
	  var price = parseFloat(document.getElementById("price-" + id).innerHTML);
	  var totalPrice = quantity * price;
	  document.getElementById("totalPriceCell-" + id).innerHTML = totalPrice.toFixed(2);
	  AllTotalAmount();
	}

	function AllTotalAmount() {
	  total = 0;
	  var totalPriceCells = document.querySelectorAll("[id^='totalPriceCell-']");
	  for (var i = 0; i < totalPriceCells.length; i++) {
	    total += parseFloat(totalPriceCells[i].innerHTML);
	  }
	  document.querySelector("#total").innerHTML = "Total Price: " + total.toFixed(2);
	}
	
   const removeBtns = document.querySelectorAll('.remove-btn');

   removeBtns.forEach(btn => {
    btn.addEventListener('click', function(event) {
    const cartItem = event.target.parentElement.parentElement;
    const productId = cartItem.querySelector("input[id^='number-']").id.split("-")[1];
    removeFromCart(productId);
    cartItem.remove();
  });
});

function removeFromCart(productId) {
  const xhr = new XMLHttpRequest();
  xhr.open('DELETE', `/cart/${productId}`, true);
  xhr.onreadystatechange = function() {
	  if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
	    console.log(`Product with id ${productId} was removed from the cart.`);
	    const totalPrice = xhr.response; // assuming that the response from the server is the updated total price
	    document.querySelector('#total').textContent = `Total Price: \u20B9 ${totalPrice}`;
	  }
	};

  xhr.send();
}
