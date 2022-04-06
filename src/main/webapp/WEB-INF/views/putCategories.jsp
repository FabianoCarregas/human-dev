<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title >Doc</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <form action="/admin/categories/{code}" method="post">
            <div class="mb-3">
                <label class="form-label">Nome</label>
                <input name="name" type="text" class="form-control" value="${ category.name }">
            </div>
            <div class="mb-3">
                <label class="form-label">Codigo</label>
                <input name="code" type="text" class="form-control" value="${ category.code }">
            </div>
            <div class="form-group ">
                <div class="mb-3 form-check div-checkbox">
                    <input type="checkbox" class="form-check-input" name="active" value="${ category.categoryDescription }">
                    <label class="form-check-label" class="form-label">
                        <p class="active-category">Categoria Ativa? </p>
                    </label>
                    <p class="text-muted">
                        Mostre ou deixa de mostrar a categoria na listagem dos alunos, de formações, etc
                    </p>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">Ordem da categoria</label>
                <input name="ordination" type="text" class="form-control" value="${ category.ordination }">
            </div>
            <div class="form-group">
                <label>Guia de estudos</label>
                <textarea class="form-control" name="studyGuide" rows="6" value="${ category.studyGuide }"></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Caminho do ícone</label>
                <input name="icon" type="text" class="form-control" value="${ category.icon }">
            </div>
            <div class="mb-3">
                <label class="form-label">cor</label>
                <input name="hexaColor" type="text" class="form-control" value="${ category.hexaColor }">
            </div>
            <div class="mb-3">
                <label class="form-label">Descrição</label>
                <input name="categoryDescription" type="text" class="form-control" ${ category.categoryDescription }>
            </div>
            <div class="mb-3" style="margin-top:30px">
            <button type="submit" class="btn btn-primary" style="margin-bottom:30px">Submit</button>
            </div>
        </form>
    </div>
</body>
</html>