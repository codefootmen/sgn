<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Activity Type</th>
        <th>Area</th>
        <th>Professor</th>
        <th>Department</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${activity.getIdActivity()}</td>
        <td>${activity.getName()}</td>
        <td>${activity.getActivityType()}</td>
        <td>${activity.getArea()}</td>
        <td>${activity.getIdProfessor()}</td>
        <td>${activity.getIdDepartment()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>