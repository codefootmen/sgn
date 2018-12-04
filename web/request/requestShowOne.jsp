<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Motive:</th>
        <td>${request.getMotive()}</td>
    </tr>
    <tr>
        <th>Description:</th>
        <td>${request.getDescription()}</td>
    </tr>
    <tr>
        <th>Priority:</th>
        <td>${request.getPriority()}</td>
    </tr>
    <tr>
        <th>Room:   </th>
        <td>${request.getRoom().getNumber()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>