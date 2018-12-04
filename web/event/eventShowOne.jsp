<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Name:</th>
        <td>${event.getName()}</td>
    </tr>
    <tr>
        <th>Date:</th>
        <td>${event.getDate()}</td>
    </tr>
    <tr>
        <th>Professor:</th>
        <td>${event.getProfessor().getFirstName()}</td>
    </tr>
    <tr>
        <th>Room:</th>
        <td>${event.getRoom().getNumber()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>
