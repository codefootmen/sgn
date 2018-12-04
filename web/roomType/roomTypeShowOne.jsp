<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Name:</th>
        <td>${roomType.getName()}</td>
    </tr>
    <tr>
        <th>Description:</th>
        <td>${roomType.getDescription()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>