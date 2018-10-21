<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Activities</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Activity Type</th>
                    <th>Area</th>
                    <th>Professor</th>
                    <th>Department</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${activities}" var="a">
                    <tr>
                        <td><a href="${path}/activities/${a.getIdActivity()}">${a.getIdActivity()}</a></td>
                        <td>${a.getName()}</td>
                        <td>${a.getActivityType()}</td>
                        <td>${a.getArea()}</td>
                        <td>${a.getIdProfessor()}</td>
                        <td>${a.getIdDepartment()}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>