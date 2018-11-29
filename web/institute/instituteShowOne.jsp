<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Site</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>${institute.getIdInstitute()}</th>
        <th>${institute.getName()}</th>
        <th>${institute.getSite()}</th>
    </tr>
    </tbody>
</table>
<c:import url="../footer.jsp"/>
