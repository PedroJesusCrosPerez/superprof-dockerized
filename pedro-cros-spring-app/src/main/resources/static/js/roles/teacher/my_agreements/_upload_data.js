function uploadAgreements() {

    $('#agreementsList').children().not(':first').remove();

    ajaxRequest("/agreements?outerType=full", "GET", null, function (response) {
        const agreements = response;
        const targetDiv = $('#agreementsList');
        agreements.forEach(function (agreement, index) {

            let status = "En línea";
            // let places = agreement.places.map(place => place).join(',');
            // let languages = agreement.languages.map(language => language.name).join(',');
            // let selectedClass = index === 0 ? 'selected' : ''; // Add 'selected' class to the first agreement

            console.log()
            console.log()
            console.log()

            console.log(agreement)
            console.log(agreement.subjects.map(subject => subject.idSubject).join(','))
            console.log(agreement.subjects.map(subject => subject.name).join(','))
            console.log(agreement.places.map(place => place).join(','))
            console.log(agreement.languages.map(language => language.idLanguage).join(','))
            console.log(agreement.languages.map(language => language.name).join(','))

            console.log()
            console.log()
            console.log()

            targetDiv.append(`
                <div data-v-5ab58b40="" class="card-ad-wrapper active agreement"
                    data-idAgreement="${agreement.idAgreement}"
                    data-title="${agreement.title}"
                    data-description="${agreement.description}"
                    data-about_me="${agreement.aboutMe}"
                    data-isactive="${agreement.isActive}"
                    
                    data-subjects_ids="${agreement.subjects.map(subject => subject.idSubject).join(',')}"
                    data-subjects_name="${agreement.subjects.map(subject => subject.name).join(',')}"
                    data-places="${agreement.places.map(place => place).join(',')}"
                    data-languages_ids="${agreement.languages.map(language => language.idLanguage).join(',')}"
                    data-languages_name="${agreement.languages.map(language => language.name).join(',')}"
                    
                    data-rate_priceperhour="${agreement.rate.pricePerHour}"
                    data-rate_packs='${JSON.stringify(agreement.rate.packs)}'
                >
                    <div data-v-5ab58b40="" class="infos-wrapper">
                        <div data-v-5ab58b40="" class="avatar-wrapper">
                            <!--
                            <img data-v-5ab58b40="" src="https://c.superprof.com/i/a/30308655/13803574/300/20240313080839/titulo-prueba.jpg" alt="avatar" class="avatar">
                            -->
                            <span data-v-5ab58b40="" class="icon-circle selected active"></span>
                        </div>
                        <div data-v-5ab58b40="" class="subject-status-wrapper">
                            <p data-v-5ab58b40="">${agreement.title}</p>
                            <div data-v-5ab58b40="" class="status-ad active">
                                <p data-v-5ab58b40="" data-label="ad_u_list_ad_page_ads_online">${status}</p>
                            </div>
                        </div>
                        <button id="btnDeleteAgreement">Eliminar</button>
                    </div>
                </div>
            `)
        });

        // Add click event to each agreement
        $('.agreement').on('click', function () {
            const agreement = $(this);
            const idAgreement = agreement.data('idagreement');
            const title = agreement.data('title');
            const description = agreement.data('description');
            const aboutMe = agreement.data('about_me');
            const isActive = agreement.data('isactive');
            const subjectsIds = agreement.data('subjects_ids');
            const subjectsName = agreement.data('subjects_name');
            const places = agreement.data('places');
            const languagesIds = agreement.data('languages_ids');
            const languagesName = agreement.data('languages_name');
            const ratePricePerHour = agreement.data('rate_priceperhour');
            const ratePacks = agreement.data('rate_packs');

            console.log()
            console.log()
            console.log()

            console.log(idAgreement)
            console.log(title)
            console.log(description)
            console.log(aboutMe)
            console.log(isActive)
            console.log(subjectsIds)
            console.log(subjectsName)
            console.log(places)
            console.log(languagesIds)
            console.log(languagesName)
            console.log(ratePricePerHour)
            console.log(ratePacks)

            console.log()
            console.log()
            console.log()

            // Fill the form with the agreement data
            $('#idAgreement').val(idAgreement);
            $('#title').val(title);
            $('#description').val(description);
            $('#aboutMe').val(aboutMe);
            $('#isActive').val(isActive);
            $('#subjectsIds').val(subjectsIds);
            $('#subjectsName').val(subjectsName);
            $('#places').val(places);
            $('#languagesIds').val(languagesIds);
            $('#languagesName').val(languagesName);
            $('#ratePricePerHour').val(ratePricePerHour);
            $('#ratePacks').val(ratePacks);

            // Show the form
            $('#agreementForm').show();
        });

        $('#btnDeleteAgreement').on('click', function () {
            const agreement = $(this).closest('.agreement');
            const idAgreement = agreement.data('idagreement');
            console.log(idAgreement);
            launchConfirmModal(function () {
                ajaxRequest(`/agreements/${idAgreement}`, 'DELETE', null, function (response) {
                    console.log(response);
                    uploadAgreements();
                    launchSuccessModal("¡¡Borrado correctamente!!", "El acuerdo se ha eliminado con éxito");
                });
            })
        });

    })
}