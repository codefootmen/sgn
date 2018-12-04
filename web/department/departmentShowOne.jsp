<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Field:</th>
        <td>${department.getField()}</td>
    </tr>
    <tr>
        <th>Description:</th>
        <td>${department.getDescription()}</td>
    </tr>
    <tr>
        <th>Campus:</th>
        <td>${department.getCampus().getName()}</td>
    </tr>
    <tr>
        <th>Institute:</th>
        <td>${department.getInstitute().getName()}</td>
    </tr>
    <tr>
        <th>Professor:</th>
        <td>${department.getProfessor().getFirstName()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>
