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
                    </div>
                </div>
            `)
        });
    })
}