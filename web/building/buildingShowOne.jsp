<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Quantity of bathdrooms</th>
        <th>Elevator</th>
        <th>Accessibility</th>
        <th>Campus</th>
        <th>Institute</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${building.getIdBuilding()}</td>
        <td>${building.getName()}</td>
        <td>${building.getQuantityOfBathrooms()}</td>
        <td>${building.getElevator()}</td>
        <td>${building.getAccessibility()}</td>
        <td>${building.getIdCampus()}</td>
        <td>${building.getIdInstitute()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>