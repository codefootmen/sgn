<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Program</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

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
                <c:forEach items="${programs}" var="a">
                    <tr>
                        <td>${a.getIdProgram()}</td>
                        <td>${a.getName()}</td>
                        <td>${a.getAcademicLevel()}</td>
                        <td>${a.getIdDepartment()}</td>
                        <td>${a.getIdCampus()}</td>
                        <td>${a.getIdInstitute()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>