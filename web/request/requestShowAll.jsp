<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Request</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Motive</th>
                    <th>Description</th>
                    <th>Priority</th>
                    <th>Room</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requests}" var="a">
                    <tr>
                        <td>${a.getIdRequest()}</td>
                        <td>${a.getMotive()}</td>
                        <td>${a.getDescription()}</td>
                        <td>${a.getPriority()}</td>
                        <td>${a.getIdRoom()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>