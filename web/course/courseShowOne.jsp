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
                    <tr>
                        <td>${course.getIdCourse()}</td>
                        <td>${course.getSemester()}</td>
                        <td>${course.getYear()}</td>
                        <td>${course.getIdSubject()}</td>
                        <td>${course.getIdProgram()}</td>
                        <td>${course.getIdDepartment()}</td>
                        <td>${course.getIdCampus()}</td>
                        <td>${course.getIdInstitute()}</td>
                        <td>${course.getIdPeriod()}</td>
                        <td>${course.getIdProfessor()}</td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
</div>
</body>
</html>