class FormHandler {

    static readForm() {
        const form = $('#formCreateAgreement');
        const places = [];
        if ($('#place_online').is(':checked')) {
            places.push('ONLINE');
        }
        if ($('#place_inperson').is(':checked')) {
            places.push('IN_PERSON');
        }

        const idsLanguages = [];
        $('#selectedLanguages .language').each(function() {
            idsLanguages.push($(this).data('idlanguage'));
        });

        return {
            idSubject: form.find('#slctSubjects').val(),
            title: form.find('#title').val(),
            places: places,
            idsLanguages: idsLanguages,
            description: form.find('#description').val(),
            aboutMe: form.find('#aboutMe').val(),
            rate: {
                rate: form.find('#rate').val()
            }
        };
    }

    static resetForm() {
        const form = $('#formCreateAgreement');
        form.find('#slctSubjects').val('0');
        form.find('#title').val('');
        form.find('#place_online').prop('checked', false);
        form.find('#place_inperson').prop('checked', false);
        form.find('#selectedLanguages .language').remove();
        form.find('#description').val('');
        form.find('#aboutMe').val('');
        form.find('#rate').val('');
    }
}