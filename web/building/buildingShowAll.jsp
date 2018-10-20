<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Buildings</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Quantity of bathdrooms</th>
                    <th>Elevator</th>
                    <th>Accessibility</th>
                    <th>Campus</th>
                    <th>Institute</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${buildings}" var="a">
                    <tr>
                        <td>${a.getIdBuilding()}</td>
                        <td>${a.getName()}</td>
                        <td>${a.getQuantityOfBathrooms()}</td>
                        <td>${a.getElevator()}</td>
                        <td>${a.getAccessibility()}</td>
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