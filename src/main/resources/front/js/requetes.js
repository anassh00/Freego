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
    // To-DO : ajout du token dynamiquement
    const settings = {
        "url": "http://localhost:8080/api/product/save?category_id="+categoryId,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmbG9yaWFuIiwiaWF0IjoxNjcwMTY2MDM3LCJlbWFpbCI6ImZsb3JpYW4tN0BnbWFpbC5jb20iLCJ1c2VybmFtZSI6ImZsb3JpYW4iLCJyb2xlIjpbIlJPTEVfVVNFUiJdLCJleHAiOjE2NzAyNTI0Mzd9.YJJ7X5o4Q8-ZugqwOjnBvpdT1vkhGqI6XZ8-SB3JKk9JyAIfRn1Sd_-tXcfd7osENFMBczx7VMTSJn1bcJYW9Q",
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
    // To-DO : ajout du token dynamiquement
    const settings = {
        "url": "http://localhost:8080/api/product/getProduct?id="+productId,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmbG9yaWFuIiwiaWF0IjoxNjcwMTY2MDM3LCJlbWFpbCI6ImZsb3JpYW4tN0BnbWFpbC5jb20iLCJ1c2VybmFtZSI6ImZsb3JpYW4iLCJyb2xlIjpbIlJPTEVfVVNFUiJdLCJleHAiOjE2NzAyNTI0Mzd9.YJJ7X5o4Q8-ZugqwOjnBvpdT1vkhGqI6XZ8-SB3JKk9JyAIfRn1Sd_-tXcfd7osENFMBczx7VMTSJn1bcJYW9Q",
        },
    };

    $.ajax(settings).done(function (response) {
       console.log(response);
    });
}

function getAllProduct(){
    // To-DO : ajout du token dynamiquement
    const settings = {
        "url": "http://localhost:8080/api/product/listProduct",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmbG9yaWFuIiwiaWF0IjoxNjcwMTY2MDM3LCJlbWFpbCI6ImZsb3JpYW4tN0BnbWFpbC5jb20iLCJ1c2VybmFtZSI6ImZsb3JpYW4iLCJyb2xlIjpbIlJPTEVfVVNFUiJdLCJleHAiOjE2NzAyNTI0Mzd9.YJJ7X5o4Q8-ZugqwOjnBvpdT1vkhGqI6XZ8-SB3JKk9JyAIfRn1Sd_-tXcfd7osENFMBczx7VMTSJn1bcJYW9Q",
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