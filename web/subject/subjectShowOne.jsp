<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Subject</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Quantity of Credits</th>
                    <th>Room Type</th>
                    <th>Program</th>
                    <th>Department</th>
                    <th>Campus</th>
                    <th>Institute</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${subject.getIdSubject()}</td>
                        <td>${subject.getName()}</td>
                        <td>${subject.getQuantityOfCredits()}</td>
                        <td>${subject.getIdRoomType()}</td>
                        <td>${subject.getIdProgram()}</td>
                        <td>${subject.getIdDepartment()}</td>
                        <td>${subject.getIdCampus()}</td>
                        <td>${subject.getIdInstitute()}</td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>