<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Periods</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Start</th>
                    <th>End</th>
                    <th>dayOfTheWeek</th>
                    <th>Room</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${period.getIdPeriod()}</td>
                        <td>${period.getStart()}</td>
                        <td>${period.getEnd()}</td>
                        <td>${period.getDayOfTheWeek()}</td>
                        <td>${period.getIdRoom()}</td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>