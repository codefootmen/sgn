<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Subject</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

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
                    <th>Institution</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${subjects}" var="a">
                    <tr>
                        <td>${a.getIdSubject()}</td>
                        <td>${a.getName()}</td>
                        <td>${a.getQuantityOfCredits()}</td>
                        <td>${a.getIdRoomType()}</td>
                        <td>${a.getIdProgram()}</td>
                        <td>${a.getIdDepartment()}</td>
                        <td>${a.getIdCampus()}</td>
                        <td>${a.getIdInstitution()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>