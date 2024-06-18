$(function () {

    uploadAgreements()

    $('#createAgreement').on('click', function () {

        throwCreateAgreementModal()
    })

    $('#agreementsList').off('click').on('click', 'div.agreement', function () {

        selectAgreement($(this))
    })

})