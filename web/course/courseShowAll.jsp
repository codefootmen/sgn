<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Courses</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Semester</th>
                    <th>Year</th>
                    <th>Subject</th>
                    <th>Program</th>
                    <th>Department</th>
                    <th>Campus</th>
                    <th>Institute</th>
                    <th>Period</th>
                    <th>Professor</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${courses}" var="a">
                    <tr>
                        <td>${a.getIdCourse()}</td>
                        <td>${a.getSemester()}</td>
                        <td>${a.getYear()}</td>
                        <td>${a.getIdSubject()}</td>
                        <td>${a.getIdProgram()}</td>
                        <td>${a.getIdDepartment()}</td>
                        <td>${a.getIdCampus()}</td>
                        <td>${a.getIdInstitute()}</td>
                        <td>${a.getIdPeriod()}</td>
                        <td>${a.getIdProfessor()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>