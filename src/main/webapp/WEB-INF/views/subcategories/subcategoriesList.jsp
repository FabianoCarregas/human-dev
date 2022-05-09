<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:template-lists>
<div class="row">
    <h3>${category.name}</h3>
    <h1>Subcategorias</h1>
</div>
<div class="row">
    <a class="btn btn-primary" role="button" href="/admin/subcategories/new">
        Nova subcategoria
    </a>
</div>
<div class="row" >
<table class="table table-bordered table-responsive">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Código</th>
            <th>Status</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ subcategories }" var="subcategoria">
            <tr>
                <td>${subcategoria.name}</td>
                <td>${subcategoria.code}</td>
                <td class="active${subcategoria.id}" >${subcategoria.active == true ? "Ativa" : "Inativa"} </td>
                <td class="text-center">
                    <c:if test="${subcategoria.active}">
                        <button class="btn btn-default change-subcategoryStatus" data-subcategory-id="${subcategoria.id}">
                            Desativar
                        </button>
                    </c:if >
                </td>
                <td class="text-center">
                    <a role="button" href="/admin/courses/${ category.code }/${ subcategoria.code }">
                        Courses
                    </a>
                <td class="text-center">
                    <a class="btn btn-default" role="button" href="/admin/subcategories/${category.code}/${subcategoria.code}">
                        Editar
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</templates:template-lists>