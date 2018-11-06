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
            <a href="/activities/new" class="button is-info">New</a>
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
                    <th>Edit</th>
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
                        <td>
                            <a href="/activities/${a.getIdActivity()}/edit">
                                <span class="icon">
                                <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                                <path fill="#000000"
                                      d="M5,3C3.89,3 3,3.89 3,5V19A2,2 0 0,0 5,21H19A2,2 0 0,0 21,19V12H19V19H5V5H12V3H5M17.78,4C17.61,4 17.43,4.07 17.3,4.2L16.08,5.41L18.58,7.91L19.8,6.7C20.06,6.44 20.06,6 19.8,5.75L18.25,4.2C18.12,4.07 17.95,4 17.78,4M15.37,6.12L8,13.5V16H10.5L17.87,8.62L15.37,6.12Z"/>
                                </svg>
                                </span>
                            </a>
                        </td>
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