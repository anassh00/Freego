function get(sel) {
	return document.querySelector(sel);
}

function searchRayon() {
	let input = document.getElementById("searchBar").value.toLowerCase();
	let productsTmp = document.getElementsByClassName('productTitle');
	for (let i = 0; i < productsTmp.length; i++) {
		const productContainer = productsTmp[i].parentElement.parentElement.parentElement;
		if (!productsTmp[i].innerHTML.toLowerCase().includes(input)) {
			productContainer.classList.add("noSearch");
		}
		else {
			productContainer.classList.remove("noSearch");
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

function fDisplayUnderMenu(id) {
	const underMenu = document.querySelector(id);
	if (underMenu.style.display == 'none') {
		underMenu.style.display = 'block';
	}
	else {
		underMenu.style.display = 'none';
	}
}

function fChoixCateg(item) {
	const categChoisie = item.querySelector("span").innerHTML;
	if(categChoisie.toString() == "Produits laitiers") {
		document.querySelector("#modalContainer").style.display = 'block';
	}
	sessionStorage.setItem("currentRayon", item.id.split("categNum")[1]);
	document.querySelector("#categorie").innerHTML = "Catégorie : " + item.querySelector("div").innerHTML;
	document.querySelector("#categSelect").style.display = 'none';
}

function fChoixEtat(item) {
	document.querySelector("#etat").innerHTML = "Etat : " + item.querySelector("div").innerHTML;
	document.querySelector("#etatSelect").style.display = 'none';
}

function fDebutChargement() {
	$("#ecranChargement").load("ecranChargement.html");
	$("#ecranChargement").fadeIn();
}

function fFinChargement() {
	get(".allContent").style.visibility = "visible";
	$("#ecranChargement").fadeOut();
}

function fDistance(lat1, lat2, lon1, lon2) {
	// The math module contains a function
	// named toRadians which converts from
	// degrees to radians.
	lon1 =  lon1 * Math.PI / 180;
	lon2 = lon2 * Math.PI / 180;
	lat1 = lat1 * Math.PI / 180;
	lat2 = lat2 * Math.PI / 180;

	// Haversine formula
	let dlon = lon2 - lon1;
	let dlat = lat2 - lat1;
	let a = Math.pow(Math.sin(dlat / 2), 2)
		+ Math.cos(lat1) * Math.cos(lat2)
		* Math.pow(Math.sin(dlon / 2),2);

	let c = 2 * Math.asin(Math.sqrt(a));

	// Radius of earth in kilometers. Use 3956
	// for miles
	let r = 6371;

	// calculate the result
	return Math.round(c * r * 100) / 100;
}