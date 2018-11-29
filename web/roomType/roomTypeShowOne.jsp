<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${roomType.getIdRoomType()}</td>
        <td>${roomType.getName()}</td>
        <td>${roomType.getDescription()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>