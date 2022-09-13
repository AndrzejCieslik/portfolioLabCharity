<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card mt-3 p-3">
        <h1>Zarejestruj się</h1>
        <%--@elvariable id="user" type="pl.coderslab.charity.model.User"--%>
        <form:form modelAttribute="user" method="post">
            <div class="mb-3">
                <label class="form-label" for="username">User Name:</label>
                <form:input path="username" placeholder="Set Your username" cssClass="form-control"/>
                <form:errors path="username" cssClass="error"/>
            </div>

            <div class="mb-3">
                <label class="form-label" for="password">Password:</label>
                <form:input path="password" placeholder="Set Your password" cssClass="form-control"/>
                <form:errors path="password" cssClass="error"/>
            </div>

           <button class="btn btn-primary" type="submit">Submit register</button>
        </form:form>
    </div>
</body>
</html>