<%--
  Created by IntelliJ IDEA.
  User: Марианна
  Date: 16.04.2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Importer</title>
</head>
<body>
<form action="importer" method="post" enctype="application/x-www-form-urlencoded">
    <p>
        <label>
            name:
            <input type="text" name="importerName" value="${form.importerName}">
        </label>
    </p>
    <p>
        <label>
            inn:
            <input type="text" name="inn" value="${form.inn}">
        </label>
    </p>
    <p>
        <label>
            postalCode:
            <input type="text" name="postalCode" value="${form.postalCode}">
        </label>
    </p>
    <p>
        <label>
            country:
            <input type="text" name="country" value="${form.country}">
        </label>
    </p>
    <p>
        <label>
            city:
            <input type="text" name="city" value="${form.city}">
        </label>
    </p>
    <p>
        <label>
            streetHouse:
            <input type="text" name="streetHouse" value="${form.streetHouse}">
        </label>
    </p>
    <p>
        <label>
            HeadFIO:
            <input type="text" name="HeadFIO" value="${form.HeadFIO}">
        </label>
    </p>
    <p>
        <label>
            AccountantFIO:
            <input type="text" name="AccountantFIO" value="${form.AccountantFIO}">
        </label>
    </p>
    <p>
        <input type="submit" value="Create">
    </p>
</form>
</body>
</html>
