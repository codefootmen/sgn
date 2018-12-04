<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Day:</th>
        <td>${meeting.getDay()}</td>
    </tr>
    <tr>
        <th>Time:</th>
        <td>${meeting.getTime()}</td>
    </tr>
    <tr>
        <th>Agenda:</th>
        <td>${meeting.getAgenda()}</td>
    </tr>
    <tr>
        <th>Minutes:</th>
        <td>${meeting.getMinutes()}</td>
    </tr>
    <tr>
        <th>Department:</th>
        <td>${meeting.getDepartment().getField()}</td>
    </tr>
    <tr>
        <th>Campus:</th>
        <td>${meeting.getCampus().getName()}</td>
    </tr>
    <tr>
        <th>Institute:</th>
        <td>${meeting.getInstitute().getName()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>
