<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
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


        </div>
    </div>
</div>
</body>
</html>