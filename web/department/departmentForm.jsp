<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Department</h1>
        </div>
    </div>
    <form action="${path}${action}" method="POST">
        <div class="columns">
            <div class="column">
                <div class="field">
                    <label class="label">Field</label>
                    <div class="control">
                        <input class="input is-info" name="field" type="text" placeholder="Text input" value="${department.getField()}">
                    </div>
                </div>
            </div>
        </div>

        <div class="field">
            <label class="label">Description</label>
            <div class="control">
                <input class="input is-info" name="description" type="text" placeholder="Text input" value="${department.getDescription()}">
            </div>
        </div>

            <div class="columns">
                <div class="field is-inline-block column">
                    <label class="label">Campus</label>
                    <div class="control">
                        <div class="select">
                            <select name="idCampus">
                                <c:forEach items="${campi}" var="campus">
                                    <option value="${campus.getIdCampus()}" <c:if test="${department.getIdCampus() == campus.getIdCampus()}"> selected </c:if> >${campus.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>


                <div class="field is-inline-block column">
                    <label class="label">Institute</label>
                    <div class="control">
                        <div class="select">
                            <select name="idInstitute">
                                <c:forEach items="${institutes}" var="inst">
                                    <option value="${inst.getIdInstitute()}" <c:if test="${department.getIdInstitute() == inst.getIdInstitute()}"> selected </c:if> >${inst.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field is-inline-block column">
                    <label class="label">Professor</label>
                    <div class="control">
                        <div class="select">
                            <select name="idProfessor">
                                <c:forEach items="${professors}" var="prof">
                                    <option value="${prof.getIdProfessor()}" <c:if test="${department.getIdProfessor() == prof.getIdProfessor()}"> selected </c:if> >${prof.getFirstName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>


            </div>

            <div class="field is-grouped">
                <div class="control">
                    <button type="submit" class="button is-link">Submit</button>
                </div>
                <div class="control">
                    <button type="reset" class="button is-text">Cancel</button>
                </div>
            </div>
        </div>
    </form>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>