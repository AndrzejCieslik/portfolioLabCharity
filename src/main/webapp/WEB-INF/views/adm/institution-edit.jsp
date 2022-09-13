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
<%--<sec:authorize access="hasRole('ADMIN')">--%>

    <li>
        <div <%--class="btn btn--small btn--without-border"--%>>Write the beginning letters of Institution Name
        </div>
    </li>
    <form action="/institution" method="get">
           <label>Institution Name letters</label>
        <label>
            <input name="n" type="text" >
        </label>
        <button type="submit">submit</button>
    </form>

    <c:forEach items="${institutionList}" var="i">
        <tr>
            <td><${i.id}</td>
            <td>${i.name}</td>
            <td>${i.description}</td>
            <a href="<c:url value="/institution/edit/${i.id}"/>">edit</a>
        </tr>
        <br>
    </c:forEach>


<%--</sec:authorize>--%>
<%@ include file="../footer.jsp" %>
</body>
</html>