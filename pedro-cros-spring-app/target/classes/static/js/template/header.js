$( function() {

    $('#submitSignUp').click(function() {

        signUp();
    });

    $('#submitSignIn').click(function() {

        signIn();
        /*
        $.ajax({
            url: '/auth/signin',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: $('#signin-form input[name="username"]').val(),
                password: $('#signin-form input[name="password"]').val()
            }),
            success: function(response) {
                console.log(response);

                // window.location.href = "/auth/signin/accepted";
                // window.location.href = "/auth/signin/accepted?token=" + response.token;
                localStorage.setItem('jwtToken', response.token);
                redirect();
            },
            error: function(error) {
                console.log(error);
            }
        });
         */
    });
});


function redirect(roles) {

    let jwtToken = localStorage.getItem('jwtToken'); // Recupera el token JWT del almacenamiento local

    if (!roles) {
        console.error('No roles provided');
        return;
    }

    roles.forEach(role => {

        console.log(role);

        switch (role.toUpperCase()) {
            case 'ROLE_ADMIN':
                window.location.href = '/admin/dashboard';
                break;
            case 'ROLE_TEACHER':
                window.location.href = '/teacher/dashboard';
                break;
            case 'ROLE_USER':
                window.location.href = '/user/dashboard';
                break;
            case 'ROLE_UNASSIGNED':
                window.location.href = '/unassigned/dashboard';
                break;
            default:
                window.location.href = '/auth/signin/accepted?token=' + jwtToken;
                break;
        }
    })


    // $.ajax({
    //     url: '/admin/dashboard',
    //     type: 'GET',
    //     headers: {
    //         'Authorization': 'Bearer ' + jwtToken
    //     },
    //     success: function(data) {
    //         // Maneja la respuesta de la solicitud
    //         console.log(data);
    //     },
    //     error: function(err) {
    //         // Maneja cualquier error que pueda ocurrir
    //         console.error('Error al realizar la solicitud:', err);
    //     }
    // });
}

function signUp() {

    const formData = new FormData();

    const userInput = {
        username: $('#signup-form input[name="username"]').val(),
        email: $('#signup-form input[name="email"]').val(),
        password: $('#signup-form input[name="password"]').val(),
        photo: $('#signup-form input[name="photo"]')[0].files[0].name
    };

    formData.append('signUpRequest', JSON.stringify([userInput]));
    formData.append('photo', $('#signup-form input[name="photo"]')[0].files[0]);

    $.ajax({
        url: '/auth/signup/withphoto',
        type: 'POST',
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        data: formData,
        success: function(response) {
            // redirect(response.roles)
            window.location.href = '/home';
            console.log(response);
        },
        error: function(error) {
            console.log(error);
        }
    });
    window.location.href = '/home';

    // $.ajax({
    //     url: '/auth/signup',
    //     type: 'POST',
    //     contentType: 'application/json',
    //     data: JSON.stringify({
    //         username: $('#signup-form input[name="username"]').val(),
    //         email: $('#signup-form input[name="email"]').val(),
    //         password: $('#signup-form input[name="password"]').val()
    //     }),
    //     success: function(response) {
    //         redirect(response.roles)
    //         console.log(response);
    //     },
    //     error: function(error) {
    //         console.log(error);
    //     }
    // });
}

function signIn() {

        ajaxRequest('/auth/signin', 'POST', {
            username: $('#signin-form input[name="username"]').val(),
            password: $('#signin-form input[name="password"]').val()
        }, function(response) {
            localStorage.setItem('jwtToken', response.token);
            $('#signin-form').submit();
            redirect(response.roles);
        }, function(error) {
            launchErrorModal(' Error ', '¡¡Sus credenciales no son válidas!! Inténtelo de nuevo.');
            console.log(error);
        });
}

function random() {
    let jwtToken = localStorage.getItem('jwtToken');

    $.ajax({
        url: '/admin/dashboard',
        type: 'GET',
        headers: {
            'Authorization': 'Bearer ' + jwtToken
        },
        success: function(data) {
            // Maneja la respuesta de la solicitud
            console.log(data);
        },
        error: function(err) {
            // Maneja cualquier error que pueda ocurrir
            console.error('Error al realizar la solicitud:', err);
        }
    });
}