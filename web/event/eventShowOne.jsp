<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
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
    <tr>
        <td>${event.getIdEvent()}</td>
        <td>${event.getName()}</td>
        <td>${event.getDate()}</td>
        <td>${event.getIdPeriod()}</td>
        <td>${event.getIdProfessor()}</td>
        <td>${event.getIdRoom()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>
