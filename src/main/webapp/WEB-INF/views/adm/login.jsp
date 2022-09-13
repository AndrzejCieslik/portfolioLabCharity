<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="../resources/css/style.css"/>"/>
</head>
<body>
<%@ include file="../header.jsp"%>
<form method="post">
    <div class="mb-3">
        <label class="form-label" for="username"> User Name:</label>
        <input class="form-control" id="username" type="text" name="username"/>
    </div>

    <div class="mb-3">
        <label class="form-label" for="password"> Password:</label>
        <input class="form-control" id="password" type="password" name="password"/>
    </div>

    <c:if test = "${error}">
    <p class="error">Nieprawidłowy login lub hasło<p>
    </c:if>

    <div class="mb-3">
        <button class="btn btn-primary" type="submit" value="Sign In">Sign in</button>
    </div>

    <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
</form>
<%@ include file="../footer.jsp"%>
</body>
</html>
