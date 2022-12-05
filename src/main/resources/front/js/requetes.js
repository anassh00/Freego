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

function addProduct(nom, description) {
    return {
        "url": "http://localhost:8080/api/product/save",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "name": nom,
            "description": description
        }),
    };
}

function getProductsByCategory(id_category){
    var settings = {
        "url": "http://localhost:8080/api/product/getProductsByCategory?id="+id_category,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({}),
      };
      
      $.ajax(settings).done(function (response) {
        console.log(response);
      });
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
    var settings = {
        "url": "http://localhost:8080/api/message/getDiscussion?idReceiver="+idReceiver,
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

function sendMessage(idReceiver, message){
    var settings = {
        "url": "http://localhost:8080/api/message/saveMessage",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
        "data": JSON.stringify({"userReceiverId": idReceiver,"text": message}),
      };
      
      $.ajax(settings).done(function (response) {
        console.log(response);
      });
}

function getDiscussionContactList(){
    var settings = {
        "url": "http://localhost:8080/api/message/getListOfContact",
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