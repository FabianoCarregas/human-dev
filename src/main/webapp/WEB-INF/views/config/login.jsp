<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:template>
<section class="auth">
    <section class="login">
        <h1 class="login__title">Já estuda com a gente?</h1>
        <p class="login__subtitle">Faça seu login e boas aulas!</p>
        <form class="login__form" action="/login" method="POST">
            <label for="login-email">E-mail</label>
            <input type="email" name="username"  id="login-email" autofocus>
            <label for="login-password">Senha</label>
            <input type="password" name="password" id="login-password" autocomplete="off">
            <button class="login__button" type="submit">Entrar</button>
        </form>
    </section>
    <section class="signup">
        <h2 class="signup__title">Ainda não estuda com a gente?</h2>
        <p class="signup__text">São mais de mil cursos nas seguintes áreas</p>
        <ul class="categories">
            <c:forEach items="${ categories }" var="category">
                <li class="category-card">
                    <a href="/category/${category.code}" class="category-card__link" href="/front-end">
                            <span class="category-card__icon">
                                <img src=${category.icon}>
                            </span>
                        <h3 class="category-card__title">${category.name}</h3>
                        <p class="category-card__details">
                            <c:forEach begin="0" end="2" varStatus="loop" items="${category.getSubcategories()}" var="subcategory">
                                ${subcategory.name}<c:if test="${!loop.last}">, </c:if>
                            </c:forEach>
                            <c:if test="${category.getSubcategories().size() > 3}">
                                e mais...
                            </c:if>
                        </p>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </section>
</section>
</templates:template>