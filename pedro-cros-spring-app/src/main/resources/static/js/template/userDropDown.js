// $(function () {
document.addEventListener("DOMContentLoaded", function() {
    const button = document.querySelector("#btnUserDropDown");
    const dropdown = document.querySelector(".dropdown");

    button.addEventListener("click", () => {
        dropdown.classList.toggle("is-open");
    });

})