<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Activity</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${student.getIdStudent()}</td>
        <td>${student.getFirstName()}</td>
        <td>${student.getLastName()}</td>
        <td>${student.getIdActivity()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>
