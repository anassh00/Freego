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

function saveProduct(desc, name, etat, categoryId) {
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
            "quantity_stock" : 1,
            "etat": etat,
        }),
    };

    $.ajax(settings).done(function (response) {
       console.log(response);
    });
}

function getProductById(productId) {
    return {
        "url": "http://localhost:8080/api/product/getProduct?id="+productId,
        "method": "GET",
        "timeout": 0,
        "async": false,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };
}

function getProductsByUserId(userId){
    return {
        "url": "http://localhost:8080/api/product/getProductsByUserId?id="+userId,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
          "Content-Type": "application/json"
        },
      };
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

function getUserById(id) {
    return {
        "url": "http://localhost:8080/api/user/getUser?id=" + id,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
    };
}

function getAllUsers() {
    return {
        "url": "http://localhost:8080/api/user/listUser",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
    };
}

function addProduct(categoryId, etat, nom, description) {
    return {
        "url": "http://localhost:8080/api/product/save?category_id=" + categoryId,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "etat": etat,
            "name": nom,
            "description": description
        }),
    };
}

function getAllCategory(){
    return {
        "url": "http://localhost:8080/api/category/listCategory",
        "method": "GET",
        "timeout": 0,
        "headers": {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + sessionStorage.getItem("userToken")
        },
      };
}

function getProductsByCategory(id_category){
    return {
        "url": "http://localhost:8080/api/product/getProductsByCategory?id="+id_category,
        "method": "GET",
        "timeout": 0,
        "async": false,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
      };
}

function updateUserInfo(id_user,phone,first_name,last_name,biographie,address,longitude,latitude){
    // NB : si un attribut est envoyé comme null le backend va garder l'ancienne valeur enregistrée sur la base
    var settings = {
        "url": "http://localhost:8080/api/user/update?id="+id_user,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"phone": phone, "first_name": first_name, "last_name": last_name, "biographie": biographie,"address": address,"longitude": longitude,"latitude": latitude}),
      };
      
      $.ajax(settings).done(function (response) {
        console.log(response);
      });
}

function getDiscussion(idReceiver){
    return {
        "url": "http://localhost:8080/api/message/getDiscussion?idReceiver="+idReceiver,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
      };
}

function sendMessage(idReceiver, message){
    return {
        "url": "http://localhost:8080/api/message/saveMessage",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
        "data": JSON.stringify({"userReceiverId": idReceiver,"text": message}),
      };
}

function getDiscussionContactList(){
    return {
        "url": "http://localhost:8080/api/message/getListOfContact",
        "method": "GET",
        "timeout": 0,
        "headers": {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
      };
}

function getCategoryById(id) {
    return {
        "url": "http://localhost:8080/api/category/getCategory?id=" + id,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };
}