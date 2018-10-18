<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Professor</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Status</th>
                    <th>Honorifcs</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${professors}" var="a">
                    <tr>
                        <td>${a.getIdProfessor()}</td>
                        <td>${a.getFirstName()}</td>
                        <td>${a.getLastName()}</td>
                        <td>${a.getStatus()}</td>
                        <td>${a.getHonorifics()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>