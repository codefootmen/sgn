<%--
  Created by IntelliJ IDEA.
  User: toshio
  Date: 09/10/18
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Find Building</title>
</head>
<body>

    <div class="container">
        <div class="columns">
            <div class="column">
                <h1>Find Building</h1>
            </div>
            <div class="column">
                <table>
                    <th> Code </th>
                    <th> Name </th>
                    <th colspan="2"> Actions </th>

                    <c:forEach items="${building}" var="building">
                        <tr>
                            <td><c:out value="${building.idBuilding}"/></td>
                            <td><c:out value="${building.name} />"</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
