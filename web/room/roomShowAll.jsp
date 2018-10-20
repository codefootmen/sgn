<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Room</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Number</th>
                    <th>Quantity of Seats</th>
                    <th>Room Type</th>
                    <th>Building</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${rooms}" var="a">
                    <tr>
                        <td>${a.getIdRoom()}</td>
                        <td>${a.getNumber()}</td>
                        <td>${a.getQuantityOfSeats()}</td>
                        <td>${a.getIdRoomType()}</td>
                        <td>${a.getIdBuilding()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>