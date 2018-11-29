<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Street</th>
        <th>Number</th>
        <th>City</th>
        <th>State</th>
        <th>Telephone</th>
        <th>ZIP</th>
        <th>Institution</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${campus.getIdCampus()}</td>
        <td>${campus.getName()}</td>
        <td>${campus.getStreet()}</td>
        <td>${campus.getNumber()}</td>
        <td>${campus.getCity()}</td>
        <td>${campus.getState()}</td>
        <td>${campus.getTelephone()}</td>
        <td>${campus.getZip()}</td>
        <td>${campus.getIdInstitute()}</td>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>
