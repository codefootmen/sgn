<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>First Name:</th>
        <td>${student.getFirstName()}</td>
    </tr>
    <tr>
        <th>Last Name:</th>
        <td>${student.getLastName()}</td>
    </tr>
    <tr>
        <th>Activity:</th>
        <td>${student.getActivity().getName()}</td>
    </tr>
</table>
<c:import url="../footer.jsp"/>
