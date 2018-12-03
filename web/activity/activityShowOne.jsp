<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<table class="table box diplay-table margin-auto">
    <tr>
        <th>Name:</th>
        <td>${activity.getName()}</td>
    </tr>
    <tr>
        <th>Type:</th>
        <td>${activity.getActivityType()}</td>
    </tr>
    <tr>
        <th>Area:</th>
        <td>${activity.getArea()}</td>
    </tr>
    <tr>
        <th>Professor:</th>
        <td>${activity.getProfessor().getFirstName()}</td>
    </tr>
    <tr>
        <th>Department:</th>
        <td>${activity.getDepartment().getField()}</td>
    </tr>

</table>
<c:import url="../footer.jsp"/>