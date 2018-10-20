<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
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
                    <th>Institute</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${meeting.getIdMeeting()}</td>
                        <td>${meeting.getDay()}</td>
                        <td>${meeting.getTime()}</td>
                        <td>${meeting.getAgenda()}</td>
                        <td>${meeting.getMinutes()}</td>
                        <td>${meeting.getIdDepartment()}</td>
                        <td>${meeting.getIdCampus()}</td>
                        <td>${meeting.getIdInstitute()}</td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>