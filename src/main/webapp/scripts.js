function statusChange(categoryId) {
    const request = new XMLHttpRequest();
    request.open('POST', '/changeCategoryStatus?id=' + categoryId);
    request.onload = function() {
        const category = document.querySelector('#active-' + categoryId);
        category.textContent = category.textContent === 'true' ? 'false' : 'true';
    }
    request.send();
}