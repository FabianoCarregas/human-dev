$('.change-status').click(function (){
    const element = $(this);
    const id = element.data('categoryId');
    $.post('/admin/categories/changeStatusCourse/' + id, function (){
        $('.active' + id).html('Inativa');
        element.remove();
    });
})

$('.change-subcategoryStatus').click(function (){
    const element = $(this);
    const id = element.data('subcategoryId');
    $.post('/admin/subcategories/changeStatusSubcategory/' + id, function (){
        $('.active' + id).html('Inativa');
        element.remove();
    });
})
