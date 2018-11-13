<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Program</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                    <input class="input is-info" type="text" placeholder="Name">
                </div>
            </div>

            <div class="field">
                <label class="label">Department</label>
                <div class="control">
                    <div class="select">
                        <select>
                            <c:forEach items="${department}" var="dep">
                                <option value="${department}" <c:if test="${program.getIdDepartment == dep.getIdDepartment}">selected </c:if>${dep}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="field">
                <label class="label">Academic Level</label>
                <div class="control">
                    <div class="select">
                        <select>
                            <c:forEach items="${academiclevel}" var="acad">
                                <option value="${acad}" <c:if test="${program.getIdAcademicLevel == acad.getIdAcademicLevel}">selected </c:if>${acad}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="field">
                <label class="label">Campus</label>
                <div class="control">
                    <div class="select">
                        <select>
                            <c:forEach items="${campus}" var="campi">
                                <option value="${campi}" <c:if test="${program.getIdCampus == campi.getIdCampus}">selected </c:if>${campi}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="field">
                <label class="label">Institute</label>
                <div class="control">
                    <div class="select">
                        <select>
                            <c:forEach items="${institute}" var="inst">
                                <option value="${inst}" <c:if test="${program.getIdInstitute == inst.getIdInstitute}">selected </c:if>${inst}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="field is-grouped">
                <div class="control">
                    <button class="button is-link">Submit</button>
                </div>
                <div class="control">
                    <button class="button is-text">Cancel</button>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>