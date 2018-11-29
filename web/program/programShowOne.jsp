<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Academic Level</th>
        <th>Department</th>
        <th>Campus</th>
        <th>Institute</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${program.getIdProgram()}</td>
        <td>${program.getName()}</td>
        <td>${program.getAcademicLevel()}</td>
        <td>${program.getIdDepartment()}</td>
        <td>${program.getIdCampus()}</td>
        <td>${program.getIdInstitute()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>