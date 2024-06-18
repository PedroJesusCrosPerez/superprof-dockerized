$(function () {
    console.log("home.js: Javascript works!!!")

    $('#btnSearchSubject').on('click', function () {

        seachSubjectByName($('#inputSearchSubject').val())
    })

    let modal = $('#connect-modal div.common-modal')
    let modalHideContent = $('#connect-modal div.connect')
    let btnCrossModal = $('#crossModal')
    let loader = $('#connect-modal div.v-loader')

    let aSignUp = $('#aSignUp')
    let signUpForm = $('div.popin-content.signup')

    let aSignIn = $('#aSignIn')
    let signInForm = $('div.popin-content.signin')


    aSignUp.on("click", function (event) {

        event.preventDefault()

        modal.addClass("visible")
        signUpForm.addClass("visible")

        resetModal()
    })

    aSignIn.on("click", function (event) {

        event.preventDefault()

        modal.addClass("visible")
        signInForm.addClass("visible")

        resetModal()
    })

    btnCrossModal.on("click", function () {

        modalHideContent.addClass("loading hide-content")
        modal.removeClass("visible")
        loader.addClass("visible")

        signUpForm.removeClass("visible")
        signInForm.removeClass("visible")

        btnCrossModal.addClass("hide-content")
    })

    function resetModal() {

        setTimeout(function() {

            modalHideContent.removeClass("loading hide-content")
            loader.removeClass("visible")
            btnCrossModal.addClass("visible")
        }, 1200);
    }
})

function seachSubjectByName(name) {

    window.location.href = `/subject/search?name=${name}`
}