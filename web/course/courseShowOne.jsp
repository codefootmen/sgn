<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
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
<c:import url="../footer.jsp"/>