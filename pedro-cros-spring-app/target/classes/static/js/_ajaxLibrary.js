function ajaxRequest(url, method, data, successCallback, errorCallback) {
    $.ajax({
        url: url,
        type: method,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function(response) {
            if (successCallback) {
                successCallback(response);
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            if (errorCallback) {
                errorCallback(jqXHR, textStatus, errorThrown);
            }
        }
    });
}

/*
// Definir la URL del endpoint
var url = "http://localhost:8080/auth/signup";

// Definir los datos que se enviarán en el cuerpo de la petición
var data = {
    "username": "admin",
    "email": "admin@admin.es",
    "role": ["ADMIN"],
    "password": "admin"
};

// Realizar la petición AJAX
$.ajax({
    url: url, // URL del endpoint
    type: "POST", // Método HTTP
    data: JSON.stringify(data), // Datos en formato JSON
    contentType: "application/json", // Tipo de contenido
    dataType: "json", // Tipo de datos esperados de la respuesta
    success: function(response) {
        // Función que se ejecuta si la petición es exitosa
        console.log(response);
    },
    error: function(jqXHR, textStatus, errorThrown) {
        // Función que se ejecuta si ocurre un error en la petición
        console.error('Error:', textStatus, errorThrown);
    }
});
 */