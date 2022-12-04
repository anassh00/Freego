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

function searchUser() {
	let input = document.getElementById("searchBar").value.toLowerCase();
	let messages = document.getElementsByClassName('message');
	for (let i = 0; i < messages.length; i++) {
		if (!messages[i].querySelector("h5").innerHTML.toLowerCase().includes(input)) {
			messages[i].classList.add("noSearch");
			messages[i].style.visibility = "hidden";
		}
		else {
			messages[i].classList.remove("noSearch");
			messages[i].style.visibility = "visible";
		}
	}
}

function fBurgerMenu() {
	const burgerMenu = document.querySelector("#burgerMenu");
	if (burgerMenu.style.display == 'none') {
		burgerMenu.style.display = 'block';
	}
	else {
		burgerMenu.style.display = 'none';
	}
}

function fCategSelect() {
	const categSelect = document.querySelector("#categSelect");
	if (categSelect.style.display == 'none') {
		categSelect.style.display = 'block';
	}
	else {
		categSelect.style.display = 'none';
	}
}

function fEtatSelect() {
	const etatSelect = document.querySelector("#etatSelect");
	if (etatSelect.style.display == 'none') {
		etatSelect.style.display = 'block';
	}
	else {
		etatSelect.style.display = 'none';
	}
}

function fChoixCateg(item) {
	const categChoisie = item.querySelector("span").innerHTML;
	if(categChoisie.toString() == "Produits laitiers") {
		document.querySelector("#modalContainer").style.display = 'block';
	}
	document.querySelector("#categorie").innerHTML = "Catégorie : " + item.querySelector("div").innerHTML;
	document.querySelector("#categSelect").style.display = 'none';
}

function fChoixEtat(item) {
	const etatChoisi = item.querySelector("span").innerHTML;
	document.querySelector("#etat").innerHTML = "Etat : " + item.querySelector("div").innerHTML;
	document.querySelector("#etatSelect").style.display = 'none';
}