<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Field</th>
        <th>Description</th>
        <th>Campus</th>
        <th>Institute</th>
        <th>Professor</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${department.getIdDepartment()}</td>
        <td>${department.getField()}</td>
        <td>${department.getDescription()}</td>
        <td>${department.getIdCampus()}</td>
        <td>${department.getIdInstitute()}</td>
        <td>${department.getIdProfessor()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>
