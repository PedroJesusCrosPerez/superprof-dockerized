function throwCreateAgreementModal() {

    Swal.fire({
        title: '¡Crea tu anuncio!',
        html: `
            <form id="formCreateAgreement" style="
            
                display: grid;
                grid-template-columns: 1fr 1fr;
                grid-template-rows: 1.2em;
                row-gap: 1.2em;
            ">
                <label for="subject">Asignatura:</label>
                <select id="slctSubjects" name="slctSubjects">
                    <option value="0" selected disabled>Selecciona una asignatura</option>
                </select>
                
                <label for="text">Título:</label>
                <input type="text" id="title" name="title">
                
                <label for="text">Lugar:</label>
                <div id="divPlaces" style="
                    display: grid;
                    grid-template-columns: 1fr 1fr;
                    grid-template-rows: 1.2em;
                    row-gap: 1.2em;
                ">
                    <input type="checkbox" id="place_online" name="place_online">
                    <label for="place_online">Online</label>
                    <input type="checkbox" id="place_inperson" name="place_inperson">                
                    <label for="place_inperson">Presencial</label>                
                </div>
                
                <label for="text">Idiomas:</label>
                <div>
                    <div id="selectedLanguages" style="
                        display: grid;
                        grid-template-columns: 1fr;
                        grid-template-rows: 1.2em;
                        row-gap: .8em;
                    "></div>
                    <select id="slctLanguages" name="slctLanguages">
                        <option value="0">Selecciona un idioma</option>
                    </select>
                </div>
                
                <label for="text">Descripción:</label>
                <input type="text" id="description" name="description">
                
                <label for="text">Sobre mi:</label>
                <input type="text" id="aboutMe" name="aboutMe">
                
                <div name="rate" style="
                    grid-column: 1 / 3;
                    display: ;
                ">
                    <div class="row">
                        <label for="text">Oferta:</label>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <input type="text" id="rate" name="rate" size="2">
                            <label for="rate">€/hora</label>                
                        </div>
                        <div class="col-12">
                            <div id="addPackBtn">
                                <p>Añadir</p>
                            </div>
                        </div>
                        <div class="col-12">
                            <div id="packs"></div>
                        </div>
                    <div>
                </div>
            </form>
        `,
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'CREAR',
        cancelButtonColor: '#d33',
        cancelButtonText: 'CANCELAR',
        didOpen: () => {

            initAgreementForm()
        },
        focusConfirm: false,
        preConfirm: () => {

            const form = Swal.getPopup().querySelector('#formCreateAgreement');

            // Languages
            const idsLanguages = [];
            $('#selectedLanguages .language').each(function() {
                idsLanguages.push($(this).data('idlanguage'));
            });

            // Place
            let places = [];
            if ($('#place_online').is(':checked')) {
                places.push('ONLINE');
            }
            if ($('#place_inperson').is(':checked')) {
                places.push('IN_PERSON');
            }


            const data = {
                // idSubject: form['slctSubjects'].value,
                title: form['title'].value,
                description: form['description'].value,
                aboutMe: form['aboutMe'].value,

                idsSubjects: [form['slctSubjects'].value],
                places: places,
                idsLanguages: idsLanguages,
                rate: {
                    pricePerHour: form['rate'].value,
                    packs: collectPacksData()
                }
            };

            const errors = [];
            // Validar los campos del formulario
            for (let key in data) {

                if (data[key] === '') {
                    errors.push(key);
                    const inputElement = form[key];
                    $(inputElement).addClass('error');
                    setTimeout(() => {
                        $(inputElement).removeClass('error');
                    }, 2200);
                    Swal.showValidationMessage(`Por favor, completa el campo ${key}`);
                }

                if (key === 'idsSubjects') {
                    if (data[key].length === 0 || data[key] === null || data[key] === undefined) {
                        errors.push(key);
                        $('#slctSubjects').addClass('error');
                        setTimeout(() => {
                            $('#slctSubjects').removeClass('error');
                        }, 2200);
                        Swal.showValidationMessage('Por favor, selecciona una asignatura');
                    }
                }

                if (key === 'rate') {
                    if (data[key].pricePerHour === '' || data[key] === null) {
                        errors.push(key);
                        $('#rate').addClass('error');
                        setTimeout(() => {
                            $('#rate').removeClass('error');
                        }, 2200);
                        Swal.showValidationMessage('Por favor, introduce el campo precio por hora');
                    }
                    if (data[key].packs.length === 0) {
                        errors.push(key);
                        $('#packs').addClass('error');
                        setTimeout(() => {
                            $('#packs').removeClass('error');
                        }, 2200);
                        Swal.showValidationMessage('Por favor, introduce al menos un pack');
                    }
                }

                if (key === 'places') {
                    if (data[key].length === 0 || data[key] === null) {
                        errors.push(key);
                        $('#divPlaces').addClass('error');
                        setTimeout(() => {
                            $('#divPlaces').removeClass('error');
                        }, 2200);
                        Swal.showValidationMessage('Por favor, selecciona al menos un lugar');
                    }
                }
            }

            if (errors.length > 0) {
                return false;
            }

            ajaxRequest("/agreements", "POST", data, function (response) {
                console.log(response);
                uploadAgreements();
                launchSuccessModal('¡Enhorabuena!', 'Tu anuncio se ha creado con éxito.');
            }, function (jqXHR, textStatus, errorThrown) {
                console.error('Error:', textStatus, errorThrown);
                launchErrorModal('¡Error!', 'Ha ocurrido un error al crear tu anuncio, lo sentimos vuelva a intentarlo más tarde.');
            });

            return true;
        }
    }).then((result) => {
        // if (result.isConfirmed) {
        //     console.log(result.value)
        // }
        console.log(result)
    })
}


function initAgreementForm() {

    initSubjects();
    initLanguages();
    initRate();
}

function initSubjects() {

    uploadSubjects();
}

function initLanguages() {

    uploadLanguages();
}

function initRate() {

    $('#addPackBtn').on('click', function () {
        $('#packs').append(`
            <div class="pack">
                <input type="number" name="packHours" size="3" max="999" maxlength="3" min="0">
                <span>horas</span>
                <input type="number" name="packPrice" size="3" max="999" maxlength="3" min="0">
                <span>€</span>
                <div class="remove-pack">Eliminar</div>
            </div>
        `);
    });
    $('#packs').append(`
            <div class="pack">
                <input type="number" name="packHours" size="3" max="999" maxlength="3" min="0">
                <span>horas</span>
                <input type="number" name="packPrice" size="3" max="999" maxlength="3" min="0">
                <span>€</span>
                <div class="remove-pack">Eliminar</div>
            </div>
        `);

    $('#packs').on('click', '.remove-pack', function () {
        $(this).parent().remove();
    });

}

function uploadSubjects() {

    ajaxRequest("/subjects", "GET", null, function (response) {
        const subjects = response;
        const selectedSubjects = $('#slctSubjects');
        subjects.forEach(function (subject) {
            selectedSubjects.append(
                $('<option>',{
                    value: subject.idSubject,
                    text: subject.name
                })
            )
        });

    }, function (jqXHR, textStatus, errorThrown) {
        console.error('Error:', textStatus, errorThrown);
    });
}

function uploadLanguages() {

    ajaxRequest("/languages", "GET", null, function (response) {
        const languages = response;
        const selectedLanguages = $('#slctLanguages');
        languages.forEach(function (language) {
            selectedLanguages.append(
                $('<option>',{
                    value: language.idLanguage,
                    text: language.name
                })
            )
        });


    }, function (jqXHR, textStatus, errorThrown) {
        console.error('Error:', textStatus, errorThrown);
    });

    $('#slctLanguages').on("change", function () {
        var selectedOption = $(this).find('option:selected');
        var language = selectedOption.text();
        var value = selectedOption.val();

        if (value == 0) {
            return;
        }

        // Crear un nuevo elemento en el div #selectedLanguages
        $('#selectedLanguages').append('<span class="language" data-idLanguage="' + value + '">' + language + '<button class="remove-language">Eliminar</button></span>');
        // $('#selectedLanguages').append('<div class="language" data-idLanguage="' + value + '"><p>' + language + '</p><button class="remove-language">Eliminar</button></div>');

        // Eliminar el idioma seleccionado del select
        selectedOption.remove();
    });

    $('#selectedLanguages').on('click', '.remove-language', function () {
        var languageElement = $(this).parent();
        var language = languageElement.text().replace(' Eliminar', '');
        language = language.slice(0, -8);
        var value = languageElement.attr('data-idlanguage');

        // Mover el idioma de vuelta al select
        $('#slctLanguages').append('<option value="' + value + '">' + language + '</option>');

        // Eliminar el elemento del div #selectedLanguages
        languageElement.remove();
    });
}

function collectPacksData() {
    const packsData = [];

    $('#packs .pack').each(function(index) {
        const packHours = $(this).find('input[name="packHours"]').val();
        const packPrice = $(this).find('input[name="packPrice"]').val();

        // Validar que ambos campos tengan valores antes de agregar al array
        if (packHours !== '' && packPrice !== '') {
            packsData.push({
                hours: packHours,
                price: packPrice
            });
        }
    });

    return packsData;
}

