<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Name:</th>
        <td>${campus.getName()}</td>
    </tr>
    <tr>
        <th>Street:</th>
        <td>${campus.getStreet()}</td>
    </tr>
    <tr>
        <th>Number:</th>
        <td>${campus.getNumber()}</td>
    </tr>
    <tr>
        <th>City:</th>
        <td>${campus.getCity()}</td>
    </tr>
    <tr>
        <th>State:</th>
        <td>${campus.getState()}</td>
    </tr>
    <tr>
        <th>Telephone:</th>
        <td>${campus.getTelephone()}</td>
    </tr>
    <tr>
        <th>ZIP:</th>
        <td>${campus.getZip()}</td>
    </tr>
    <tr>
        <th>Institute:</th>
        <td>${campus.getInstitute().getName()}</td>
    </tr>

</table>
<c:import url="../footer.jsp"/>
