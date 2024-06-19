function enableUpdate() {


    // Events
    $('#edit-subject-name').on('click', function () {

        console.log($(this).find('p[name="subjectsNames"]').text());
        updateInputText("subject", $('#edit-subject-name p[name="subjectsNames"]').text());

    })
    $('#edit-title').on('click', function () {

        console.log($(this).find('*[name="title"]').text());
        updateInputText("title", $(this).find('*[name="title"]').text());

    })

}

function updateInputText(requestField, value)  {

    Swal.fire({
        title: '¡Actualiza '+requestField+'!',
        html: `
            <form id="formPatchFields" name="formPatchFields" style="
            
                display: grid;
                grid-template-columns: 1fr 1fr;
                grid-template-rows: 1.2em;
                row-gap: 1.2em;
            ">
                <label for="field">${requestField}:</label>
                <input type="text" name="field" placeholder="${value}">
            </form>
        `,
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'ACTUALIZAR',
        cancelButtonColor: '#d33',
        cancelButtonText: 'CANCELAR',
        didOpen: () => {
            const form = Swal.getPopup().querySelector('#formPatchFields');
            form['field'].value = value;
            console.log(form['field'].value);
        },
        focusConfirm: false,
        preConfirm: () => {
            const form = Swal.getPopup().querySelector('#formPatchFields');
            const field = form['field'].value;
            console.log(field);
            if (!field) {
                Swal.showValidationMessage('Por favor, completa el campo');
            }

            return value;
        }
    }).then((result) => {

        console.log(requestField)
        const currentAgreement = getCurrentAgreement();
        if (result.isConfirmed && (currentAgreement !== false)) {
            let fieldToSend = requestField;
            let requestValue = result.value;

            const data = {};
            data[fieldToSend] = requestValue;

            ajaxRequest(`/agreements/${currentAgreement}`, 'PATCH', JSON.stringify(data), function (response) {
                launchSuccessModal("¡¡Actualización completada!!", field + " se ha actualizado con éxito ==> " + result.value);
            }, function (response) {
                launchErrorModal("Error", "No se ha podido actualizar el campo " + fieldToSend);
            });
        }

/*
        var data = {};
        data[field] = value;

        // Enviar la solicitud POST
        $.ajax({
            url: '/agreements/1',
            type: 'PATCH',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(response) {
                console.log('Éxito:', response);
            },
            error: function(error) {
                console.log('Error:', error);
            }
        });
    */
    });
}



function getCurrentAgreement() {
    const selectedAgreement = $('#agreementsList .card-ad-wrapper.selected');

    if (selectedAgreement.length) {
        return selectedAgreement.data('idagreement');
    } else {
        console.log('No se ha seleccionado ningún acuerdo.');
        return false;
    }
}