<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Program</h1>
        </div>
    </div>
    <form action="${path}${action}" method="post">
        <div class="columns">
            <div class="column">
                <div class="field">
                    <label class="label">Name</label>
                    <div class="control">
                        <input class="input is-info" name="name" type="text" placeholder="Name" value="${program.getName()}">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Department</label>
                    <div class="control">
                        <div class="select">
                            <select name="idDepartment">
                                <c:forEach items="${departments}" var="dep">
                                    <option value="${dep.getIdDepartment()}"
                                            <c:if test="${program.getIdDepartment() == dep.getIdDepartment()}">selected </c:if> >${dep.getField()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Academic Level</label>
                    <div class="control">
                        <div class="select">
                            <select name="academicLevel">
                                <c:forEach items="${levels}" var="acad">
                                    <option value="${acad}"
                                            <c:if test="${program.getAcademicLevel() == acad}">selected </c:if> >${acad}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Campus</label>
                    <div class="control">
                        <div class="select">
                            <select name="idCampus">
                                <c:forEach items="${campi}" var="campus">
                                    <option value="${campus.getIdCampus()}"
                                            <c:if test="${program.getIdCampus() == campus.getIdCampus()}">selected </c:if> >${campus.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Institute</label>
                    <div class="control">
                        <div class="select">
                            <select name="idInstitute">
                                <c:forEach items="${institutes}" var="inst">
                                    <option value="${inst.getIdInstitute()}"
                                            <c:if test="${program.getIdInstitute() == inst.getIdInstitute()}">selected </c:if> >${inst.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field is-grouped">
                    <div class="control">
                        <button class="button is-link" type="submit">Submit</button>
                    </div>
                    <div class="control">
                        <button class="button is-text" type="reset">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>