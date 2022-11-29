function searchProduct() {
	let input = document.getElementById("searchBar").value.toLowerCase();
	let products = document.getElementsByClassName('product');
	for (let i = 0; i < products.length; i++) {
		if (!products[i].getElementsByClassName("card-title")[0].innerHTML.toLowerCase().includes(input)) {
			products[i].classList.add("noSearch");
			products[i].style.visibility = "hidden";
		}
		else {
			products[i].classList.remove("noSearch");
			products[i].style.visibility = "visible";
		}
	}
}

function searchRayon() {
	let input = document.getElementById("searchBar").value.toLowerCase();
	let products = document.getElementsByClassName('rayon');
	for (let i = 0; i < products.length; i++) {
		if (!products[i].querySelector("h6").innerHTML.toLowerCase().includes(input)) {
			products[i].classList.add("noSearch");
			products[i].style.visibility = "hidden";
		}
		else {
			products[i].classList.remove("noSearch");
			products[i].style.visibility = "visible";
		}
	}
}