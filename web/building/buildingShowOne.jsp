<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Name:</th>
        <td>${building.getName()}</td>
    </tr>
    <tr>
        <th>Quantity of bathdrooms:</th>
        <td>${building.getQuantityOfBathrooms()}</td>
    </tr>
    <tr>
        <th>Elevator:</th>
        <td>${building.getElevator()}</td>
    </tr>
    <tr>
        <th>Accessibility:</th>
        <td>${building.getAccessibility()}</td>
    </tr>
    <tr>
        <th>Campus:</th>
        <td>${building.getCampus().getName()}</td>
    </tr>
    <tr>
        <th>Institute:</th>
        <td>${building.getInstitute().getName()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>