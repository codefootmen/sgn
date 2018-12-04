<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">x
    <tr>
        <th>Name:</th>
        <td>${program.getName()}</td>
    </tr>
    <tr>
        <th>Academic Level:</th>
        <td>${program.getAcademicLevel()}</td>
    </tr>
    <tr>
        <th>Department:</th>
        <td>${program.getDepartment().getField()}</td>
    </tr>
    <tr>
        <th>Campus:</th>
        <td>${program.getCampus().getName()}</td>
    </tr>
    <tr>
        <th>Institute:</th>
        <td>${program.getInstitute().getName()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>