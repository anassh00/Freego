const urlBack = "http://hanass@polymnie.univ-lyon2.fr:8080/api/"

function connexion(pseudo, mdp) {
    return {
        "url": urlBack + "auth/login",
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
}

function inscription(first_name, last_name, username, latitude, longitude, mdp, entity_name) {
    return {
        "url": urlBack + "auth/signup",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "first_name": first_name,
            "last_name": last_name,
            "username": username,
            "latitude": latitude,
            "longitude": longitude,
            "password": mdp,
            "entity_name": entity_name,
            "roles": ["user"]
        }),
    };
}

function getProductById(productId) {
    return {
        "url": urlBack + "product/getProduct?id=" + productId,
        "method": "GET",
        "timeout": 0,
        "async": false,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };
}

function getProductsByUserId(userId) {
    const settings = {
        "url": urlBack + "product/getProductsByUserId?id=" + userId,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
    };
    return createPromise(settings);
}

function getAllProduct() {
    return {
        "url": urlBack + "product/listProduct",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };
}

function getUserById(id) {
    const settings = {
        "url": urlBack + "user/getUser?id=" + id,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
    };
    return createPromise(settings);
}

function getAllUsers() {
    const settings = {
        "url": urlBack + "user/listUser",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
    };
    return createPromise(settings);
}

function addProduct(categoryId, etat, nom, description, image1, image2, image3) {
    return {
        "url": urlBack + "product/save?category_id=" + categoryId,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "etat": etat,
            "name": nom,
            "description": description,
            "entity_name": image1,
            "entity_name_1": image2,
            "entity_name_2": image3,
            "quantity_stock": 1
        }),
    };
}

function getAllCategory() {
    const settings = {
        "url": urlBack + "category/listCategory",
        "method": "GET",
        "timeout": 0,
        "async": false,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken")
        },
    };
    return createPromise(settings);
}

function getProductsByCategory(id_category) {
    const settings = {
        "url": urlBack + "product/getProductsByCategory?id=" + id_category,
        "method": "GET",
        "timeout": 0,
        "async": false,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
    };
    return createPromise(settings);
}

function updateUserInfo(id_user, pseudo, first_name, last_name, biographie, latitude, longitude, password, entity_name) {
    // NB : si un attribut est envoyé comme null le backend va garder l'ancienne valeur enregistrée sur la base
    return {
        "url": urlBack + "user/update?id=" + id_user,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "username": pseudo,
            "first_name": first_name,
            "last_name": last_name,
            "email": "",
            "phone": "",
            "biographie": biographie,
            "latitude": latitude,
            "longitude": longitude,
            "password": password,
            "entity_name": entity_name
        }),
    };
}

function getDiscussion(idReceiver) {
    return {
        "url": urlBack + "message/getDiscussion?idReceiver=" + idReceiver,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };
}

function sendMessage(idReceiver, message) {
    return {
        "url": urlBack + "message/saveMessage",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
        "data": JSON.stringify({ "userReceiverId": idReceiver, "text": message }),
    };
}

function getDiscussionContactList() {
    return {
        "url": urlBack + "message/getListOfContact",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };
}

function reserveProduct(productId) {
    return {
        "url": urlBack + "order/save",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken")
        },
        "data": JSON.stringify({ "address": "address", "productList": [{ "productId": productId, "quantity": 1 }] }),
    };
}

function getCategoryById(id) {
    const settings = {
        "url": urlBack + "category/getCategory?id=" + id,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
        },
    };
    return createPromise(settings);
}

function getUserImage(userId) {
    const settings = {
        "url": urlBack + "get/image/user/" + userId,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken")
        },
    };
    return createPromise(settings);
}


function getUserProduct(productId) {
    var settings = {
        "url": urlBack + "get/image/product/" + productId,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken")
        },
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}

function saveImage(formData) {
    return {
        "url": urlBack + "upload/image",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken")
        },
        "processData": false,
        "mimeType": "multipart/form-data",
        "contentType": false,
        "data": formData
    };
}

function updateProduct(idProduct, categoryId, name, description, etat, image1, image2, image3) {
    return {
        "url": "http://localhost:8080/api/product/update?id=" + idProduct + "&category_id=" + categoryId,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "name": name,
            "description": description,
            "etat": etat,
            "quantity_stock": 1,
            "entity_name": image1,
            "entity_name_1": image2,
            "entity_name_2": image3,
        }),
    };
}

function getProductImages(productId) {
    const settings = {
        "url": urlBack + "get/image/product/" + productId,
        "method": "GET",
        "timeout": 0,
        "async": false,
        "headers": {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + sessionStorage.getItem("userToken")
        },
    };
    return createPromise(settings);
}

function deleteProduct(idProduct, categoryId) {
    return {
        "url": "http://localhost:8080/api/product/update?id=" + idProduct + "&category_id=" + categoryId,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Bearer " + sessionStorage.getItem("userToken"),
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "quantity_stock": 0
        }),
    };
}

function createPromise(settings) {
    return new Promise(function (resolve, reject) {
        const reqAjax = $.ajax(settings)
        reqAjax.done(function (data) {
            resolve(data);
        });
        reqAjax.fail(function (error) {
            reject(error);
        });
    });
}