<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
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
                    <tr>
                        <td>${building.getIdBuilding()}</td>
                        <td>${building.getName()}</td>
                        <td>${building.getQuantityOfBathrooms()}</td>
                        <td>${building.getElevator()}</td>
                        <td>${building.getAccessibility()}</td>
                        <td>${building.getIdCampus()}</td>
                        <td>${building.getIdInstitute()}</td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>