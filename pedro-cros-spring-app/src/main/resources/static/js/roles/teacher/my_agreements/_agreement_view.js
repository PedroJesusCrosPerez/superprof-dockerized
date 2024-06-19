function selectAgreement(agreementDivSelected) {

    $('#agreementsList > div.agreement').removeClass('selected')
    agreementDivSelected.addClass('selected')

    const pSubjectsNames = $('p[name="subjectsNames"]')
    const h3Title = $('h3[name="title"]')
    const pPlaces = $('p[name="places"]')
    const pDescription = $('p[name="description"]')
    const pAboutMe = $('p[name="aboutMe"]')
    // Rate
    const spanRatePricePerHour = $('span[name="pricePerHour"]')
    const divListPacks = $('#listPacks')

    let agreement = agreementDivSelected.data()

    // Subjects name
    let str = agreement.subjects_name;
    let formattedSubjectName =  str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();

    console.log(agreement) // TODO DEBUG
    pSubjectsNames.text(formattedSubjectName)
    h3Title.text(agreement.title)
    pPlaces.text(agreement.places)
    pDescription.text(agreement.description)
    pAboutMe.text(agreement.about_me)
    spanRatePricePerHour.text(agreement.rate_priceperhour)

    // Places
    const placesList = $('#placesList');
    placesList.find('div').addClass('disabled');

    // Ensure agreement.places is an array
    let places
    if (agreement.places.includes(",")) {
        places = agreement.places.split(",");
    } else {
        places = [agreement.places];
    }

    places.forEach(place => {
        if (place.toUpperCase() === "ONLINE") {
            placesList.find('div.disabled[name="place_online"]').removeClass('disabled')
        }
        if (place.toUpperCase() === "IN_PERSON") {
            placesList.find('div.disabled[name="place_in_person"]').removeClass('disabled')
        }
    });

    // Languages
    const languagesList = $('div[name="languagesList"]');
    let languageTemplate = languagesList.find('.text-wrapper').first();

    // Ensure agreement.languages is an array
    let languages = Array.isArray(agreement.languages_name) ? agreement.languages_name : [agreement.languages_name];

    if (languages.length > 0) {
        languagesList.empty();
        languages.forEach(language => {
            let languageDiv = languageTemplate.clone(true);
            languageDiv.find('p[name="languages"]').text(language.name);
            languagesList.append(languageDiv);
        });
    } else {
        languagesList.find('p[name="languages"]').text(agreement.languages);
    }

    // Packs
    let packs = Array.isArray(agreement.rate_packs) ? agreement.rate_packs : [agreement.rate_packs];
    if (packs.length > 0) {
        divListPacks.empty();
        packs.forEach(pack => {
            let packDiv = $(`
                <p data-v-fbd665c="" class="pack" data-id="${pack.idPack}">${pack.hours}: ${pack.price} €</p>
            `);
            divListPacks.append(packDiv);
        });
    }
        //

}
