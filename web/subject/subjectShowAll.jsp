<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
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
                    <th>Institute</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${subjects}" var="a">
                    <tr>
                        <td><a href="${path}/subjects/${a.getIdSubject()}">${a.getIdSubject()}</a></td>
                        <td>${a.getName()}</td>
                        <td>${a.getQuantityOfCredits()}</td>
                        <td>${a.getIdRoomType()}</td>
                        <td>${a.getIdProgram()}</td>
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
<c:import url="../footer.jsp"/>
</body>
</html>