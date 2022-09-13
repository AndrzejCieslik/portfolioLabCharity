<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<%@ include file="../header.jsp" %>
<li><a href="institution-edit" class="btn btn--small btn--without-border">Edit Institution</a></li>
<sec:authorize access="hasRole('ADMIN')">


    <%--@elvariable id="institution" type="pl.coderslab.charity.model.Institution"--%>
    <form:form modelAttribute="institution" method="post">
        <h2>Add Institution</h2>
        <h3>
            <div>
                <label class="form-label">Institution Name</label>
                <form:input path="name"/>
                <form:errors path="name" cssClass="error"/>
            </div>
        </h3>
        <h3>
            <div>
                <label class="form-label">Institution Description</label>
                <form:input path="description"/>
                <form:errors path="description" cssClass="error"/>
            </div>
        </h3>


        <button type="submit">submit</button>
    </form:form>


</sec:authorize>
<%@ include file="../footer.jsp" %>
</body>
</html>