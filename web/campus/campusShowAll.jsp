<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Campi</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Street</th>
                    <th>Number</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Telephone</th>
                    <th>ZIP</th>
                    <th>Institution</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${campi}" var="a">
                    <tr>
                        <td>${a.getIdCampus()}</td>
                        <td>${a.getName()}</td>
                        <td>${a.getStreet()}</td>
                        <td>${a.getNumber()}</td>
                        <td>${a.getCity()}</td>
                        <td>${a.getState()}</td>
                        <td>${a.getTelephone()}</td>
                        <td>${a.getZip()}</td>
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