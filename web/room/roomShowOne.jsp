<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Number:</th>
        <td>${room.getNumber()}</td>
    </tr>
    <tr>
        <th>Quantity of Seats:</th>
        <td>${room.getQuantityOfSeats()}</td>
    </tr>
    <tr>
        <th>Room Type:</th>
        <td>${room.getRoomType().getName()}</td>
    </tr>
    <tr>
        <th>Building:</th>
        <td>${room.getBuilding().getName()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>