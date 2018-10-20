<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
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
                    <tr>
                        <td>${campus.getIdCampus()}</td>
                        <td>${campus.getName()}</td>
                        <td>${campus.getStreet()}</td>
                        <td>${campus.getNumber()}</td>
                        <td>${campus.getCity()}</td>
                        <td>${campus.getState()}</td>
                        <td>${campus.getTelephone()}</td>
                        <td>${campus.getZip()}</td>
                        <td>${campus.getIdInstitute()}</td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>