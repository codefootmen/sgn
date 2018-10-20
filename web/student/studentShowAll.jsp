<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Student</h1>
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
                    <th>Activity</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="a">
                    <tr>
                        <td>${a.getIdStudent()}</td>
                        <td>${a.getFirstName()}</td>
                        <td>${a.getLastName()}</td>
                        <td>${a.getIdActivity()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>