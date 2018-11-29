<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
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
    <tr>
        <td>${request.getIdRequest()}</td>
        <td>${request.getMotive()}</td>
        <td>${request.getDescription()}</td>
        <td>${request.getPriority()}</td>
        <td>${request.getIdRoom()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>