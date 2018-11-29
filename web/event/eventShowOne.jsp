<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Events</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Period</th>
                    <th>Professor</th>
                    <th>Room</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${event.getIdEvent()}</td>
                        <td>${event.getName()}</td>
                        <td>${event.getDate()}</td>
                        <td>${event.getIdPeriod()}</td>
                        <td>${event.getIdProfessor()}</td>
                        <td>${event.getIdRoom()}</td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>