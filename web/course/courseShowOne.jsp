<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <tr>
        <th>Semester:</th>
        <td>
                <c:if test="${course.getSemester() == false}">
                    First
                </c:if>
                <c:if test="${Course.getSemester() == true}">
                    Second
                </c:if>
        </td>
    </tr>
    <tr>
        <th>Year:</th>
        <td>${course.getYear()}</td>
    </tr>
    <tr>
        <th>Subject:</th>
        <td>${course.getSubject().getName()}</td>
    </tr>
    <tr>
        <th>Program:</th>
        <td>${course.getProgram().getName()}</td>
    </tr>
    <tr>
        <th>Department:</th>
        <td>${course.getDepartment().getField()}</td>
    </tr>
    <tr>
        <th>Campus:</th>
        <td>${course.getCampus().getName()}</td>
    </tr>
    <tr>
        <th>Institute:</th>
        <td>${course.getInstitute().getName()}</td>
    </tr>
    <tr>
        <th>Professor:</th>
        <td>${course.getProfessor().getFirstName()}</td>
    </tr>

</table>
<c:import url="../footer.jsp"/>