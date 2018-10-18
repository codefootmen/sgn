<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Departaments</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Field</th>
                    <th>Description</th>
                    <th>Campus</th>
                    <th>Institution</th>
                    <th>Professor</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${departments}" var="a">
                    <tr>
                        <td>${a.getIdDepartment()}</td>
                        <td>${a.getField()}</td>
                        <td>${a.getDescription()}</td>
                        <td>${a.getIdCampus()}</td>
                        <td>${a.getIdInstitution()}</td>
                        <td>${a.getIdProfessor()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>