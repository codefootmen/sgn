<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Professor</h1>
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
                    <th>Status</th>
                    <th>Honorifcs</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${professor.getIdProfessor()}</td>
                        <td>${professor.getFirstName()}</td>
                        <td>${professor.getLastName()}</td>
                        <td>${professor.getStatus()}</td>
                        <td>${professor.getHonorifics()}</td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>