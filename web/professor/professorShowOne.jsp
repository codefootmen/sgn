<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Status</th>
        <th>Honorifcs</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${professor.getIdProfessor()}</td>
        <td>${professor.getFirstName()}</td>
        <td>${professor.getLastName()}</td>
        <td>${professor.getStatus()}</td>
        <td>${professor.getHonorifics()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>
