<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Number</th>
        <th>Quantity of Seats</th>
        <th>Room Type</th>
        <th>Building</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${room.getIdRoom()}</td>
        <td>${room.getNumber()}</td>
        <td>${room.getQuantityOfSeats()}</td>
        <td>${room.getIdRoomType()}</td>
        <td>${room.getIdBuilding()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>