<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>First Name:</th>
        <td>${professor.getFirstName()}</td>
    </tr>
    <tr>
        <th>Last Name:</th>
        <td>${professor.getLastName()}</td>
    </tr>
    <tr>
        <th>Email:</th>
        <td>${professor.getEmail()}</td>
    </tr>
    <tr>
        <th>Status:</th>
        <td>${professor.getStatus()}</td>
    </tr>
    <tr>
        <th>Honorifcs:</th>
        <td>${professor.getHonorifics()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>
