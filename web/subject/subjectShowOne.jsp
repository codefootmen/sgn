<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Quantity of Credits</th>
        <th>Room Type</th>
        <th>Program</th>
        <th>Department</th>
        <th>Campus</th>
        <th>Institute</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${subject.getIdSubject()}</td>
        <td>${subject.getName()}</td>
        <td>${subject.getQuantityOfCredits()}</td>
        <td>${subject.getIdRoomType()}</td>
        <td>${subject.getIdProgram()}</td>
        <td>${subject.getIdDepartment()}</td>
        <td>${subject.getIdCampus()}</td>
        <td>${subject.getIdInstitute()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>
