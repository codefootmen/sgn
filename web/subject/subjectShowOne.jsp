<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Name:</th>
        <td>${subject.getName()}</td>
    </tr>
    <tr>
        <th>Quantity of Credits:</th>
        <td>${subject.getQuantityOfCredits()}</td>
    </tr>
    <tr>
        <th>Room Type:</th>
        <td>${subject.getRoomType().getName()}</td>
    </tr>
    <tr>
        <th>Program:</th>
        <td>${subject.getProgram().getName()}</td>
    </tr>
    <tr>
        <th>Department:</th>
        <td>${subject.getDepartment().getField()}</td>
    </tr>
    <tr>
        <th>Campus:</th>
        <td>${subject.getCampus().getName()}</td>
    </tr>
    <tr>
        <th>Institute:</th>
        <td>${subject.getInstitute().getName()}</td>
    </tr>

</table>
<c:import url="../footer.jsp"/>
