var CHANGE_URL = "http://localhost:8080/changeCategoryStatus?id=";

function statusChange(categoryId) {
    const request = new XMLHttpRequest();
    request.open("POST", CHANGE_URL + categoryId);
    request.onload = function () {
        const category = document.querySelector('#active-' + categoryId);
        category.textContent = category.textContent === 'true' ? 'false' : 'true';
    }
    request.send();
}