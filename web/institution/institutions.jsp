<html lang="pt-br">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page pageEncoding="UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bulma.min.css">

    <title>Institutions</title>
</head>
<body>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Institutions</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

                <table class="table box">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Logo</th>
                        <th>Site</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${institutions}" var="a">
                        <tr>
                            <th>${a.getIdInstitution()}</th>
                            <th>${a.getName()}</th>
                            <th>${a.getLogo()}</th>
                            <th>${a.getSite()}</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

        </div>
    </div>
</div>
</body>
</html>