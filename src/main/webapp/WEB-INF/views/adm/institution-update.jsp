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
<%@ include file="../header.jsp" %><%--@elvariable id="institut" type="pl.coderslab.charity.model.Institution"--%>
<form:form modelAttribute="institut" cssClass="some-class" action="/institution/edit">
    <table>
        <tr>
            <th>Institution name</th>
            <th>Institution description</th>
        </tr>
        <tr>
            <td>
                <form:hidden path="id"/>
            </td>
            <td>
                <form:input path="name" placeholder="name"/>
            </td>
            <td>
                <form:input path="description" placeholder="description"/>
            </td>
        </tr>
    </table>
    <button type="submit">submit</button>
</form:form>
<%@ include file="../footer.jsp" %>
</body>
</html>