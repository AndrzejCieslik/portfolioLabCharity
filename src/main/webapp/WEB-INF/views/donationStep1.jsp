<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            <%--@elvariable id="donationFillings" type="pl.coderslab.charity.service.DonationFilling"--%>
            <form:form action="/donation" modelAttribute="donationFillings" method="post">
                <table>
                    <tr>
                        <td><form:label path="donationName">Wybierz kategorię przedmiotów które chcesz podarować!</form:label></td>
                    </tr>
                    <tr>
                        <td> <form:checkboxes path="donationName" items="${categoryNames}" delimiter=" || "/></td>
                    </tr>
                    <tr>
                        <td>Wybierz instytucję którą chesz obdarować</td>
                    </tr>
                    <tr>
                        <td> <form:checkboxes path="institutionName" items="${institutionNames}" delimiter=" || "/></td>
                    </tr>

                    <tr>
                        <td><form:label path="donationQuantity">podaj ilość worków</form:label></td>
                        <td><form:input path="donationQuantity"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="">podaj adres wysyłki</form:label></td>
                        <td><form:input path="donationStreet" placeholder="Street"/></td>
                        <td><form:input path="donationCity" placeholder="City"/></td>
                        <td><form:input path="donationZipCode" placeholder="ZipCode"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="donationPickUpDate">podaj datę wysyłki</form:label></td>
                        <td><form:input path="donationPickUpDate" placeholder="yyyy-MM-dd"/></td>
                        <td><form:input path="donationPickUpTime" placeholder="hh:mm"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="donationPickUpComment">write the comments</form:label></td>
                        <td><form:input path="donationPickUpComment" placeholder="comment"/></td>
                    </tr>

                    <button type="submit">submit</button>
                </table>
            </form:form>
        </h1>
    </div>
</div>

<%--</form:form>--%>


<%@ include file="footer.jsp" %>
</body>
</html>
