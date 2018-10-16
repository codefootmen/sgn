<html lang="pt-br">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page pageEncoding="UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bulma.min.css">

    <title>Campi</title>
</head>
<body>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Campi</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Street</th>
                    <th>Number</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Telefone</th>
                    <th>ZIP</th>
                    <th>Institution</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${campi}" var="a">
                    <tr>
                        <td>${a.getIdCampus()}</td>
                        <td>${a.getName()}</td>
                        <td>${a.getStreet()}</td>
                        <td>${a.getNumber()}</td>
                        <td>${a.getCity()}</td>
                        <td>${a.getState()}</td>
                        <td>${a.getTelephone()}</td>
                        <td>${a.getZip()}</td>
                        <td>${a.getInstitution}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>