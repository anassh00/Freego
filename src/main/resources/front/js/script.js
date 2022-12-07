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
	item.querySelector("div").querySelector("span").setAttribute("id", item.id);
	document.querySelector("#categorie").innerHTML = "Catégorie : " + item.querySelector("div").innerHTML;
	document.querySelector("#categSelect").style.display = 'none';
}

function fChoixEtat(item) {
	const etatChoisi = item.querySelector("span").innerHTML;
	document.querySelector("#etat").innerHTML = "Etat : " + item.querySelector("div").innerHTML;
	document.querySelector("#etatSelect").style.display = 'none';
}

function fFinChargement() {
	document.querySelector(".allContent").style.visibility = "visible";
	$("#ecranChargement").fadeOut();
}