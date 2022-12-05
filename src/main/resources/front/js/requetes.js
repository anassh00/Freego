function connexion(pseudo, mdp) {
    const settings = {
        "url": "http://localhost:8080/api/auth/login",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "username": pseudo,
            "password": mdp
        }),
    };

    $.ajax(settings).done(function (response) {
       console.log(response);
    });
}

function inscription(username, mdp, email, phone, first_name, last_name, address, longitude, latitude) {
    const settings = {
        "url": "http://localhost:8080/api/auth/signup",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "username": username,
            "password": mdp,
            "email" : email,
            "phone" : phone,
            "first_name" : first_name,
            "last_name" : last_name,
            "address" : address,
            "longitude" : longitude,
            "latitude" : latitude
        }),
    };

    $.ajax(settings).done(function (response) {
       console.log(response);
    });
}

function saveProduct(desc, name, qte, categoryId) {
    const settings = {
        "url": "http://localhost:8080/api/product/save?category_id="+categoryId,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
        "data": JSON.stringify({
            "description": desc,
            "name": name,
            "quantity_stock" : qte,
        }),
    };

    $.ajax(settings).done(function (response) {
       console.log(response);
    });
}

function getProductById(productId) {
    const settings = {
        "url": "http://localhost:8080/api/product/getProduct?id="+productId,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };

    $.ajax(settings).done(function (response) {
       console.log(response);
    });
}

function getAllProduct(){
    const settings = {
        "url": "http://localhost:8080/api/product/listProduct",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };

    $.ajax(settings).done(function (response) {
       console.log(response);
    });    
}

function getUserById() {
    return {
        "url": "http://localhost:8080/api/user/getUser?id=" + sessionStorage.getItem("userID"),
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
    };
}
