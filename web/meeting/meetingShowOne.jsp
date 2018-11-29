<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
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
<c:import url="../footer.jsp"/>
