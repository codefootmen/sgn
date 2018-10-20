<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Events</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Period</th>
                    <th>Professor</th>
                    <th>Room</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${events}" var="a">
                    <tr>
                        <td>${a.getIdEvent()}</td>
                        <td>${a.getName()}</td>
                        <td>${a.getDate()}</td>
                        <td>${a.getIdPeriod()}</td>
                        <td>${a.getIdProfessor()}</td>
                        <td>${a.getIdRoom()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>