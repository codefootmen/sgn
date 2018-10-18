<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Meetings</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Day</th>
                    <th>Time</th>
                    <th>Agenda</th>
                    <th>Minutes</th>
                    <th>Department</th>
                    <th>Campus</th>
                    <th>Institution</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${meetings}" var="a">
                    <tr>
                        <td>${a.getIdMeeting()}</td>
                        <td>${a.getDay()}</td>
                        <td>${a.getTime()}</td>
                        <td>${a.getAgenda()}</td>
                        <td>${a.getMinutes()}</td>
                        <td>${a.getIdDepartment()}</td>
                        <td>${a.getIdCampus()}</td>
                        <td>${a.getIdInstitution()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>