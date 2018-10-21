<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">New Department</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Field</label>
                <div class="control">
                    <input class="input is-info" type="text" placeholder="Text input">
                </div>
            </div>

            <div class="field">
                <label class="label">Description</label>
                <div class="control">
                    <input class="input is-info" type="text" placeholder="Text input">
                </div>
            </div>

            <div class="columns">

                <div class="field is-inline-block column">
                    <label class="label">Campus</label>
                    <div class="control">
                        <div class="select">
                            <select>
                                <c:forEach items="${campi}" var="camp">
                                    <option value="${camp.getIdCampus()}">${camp.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field is-inline-block column">
                    <label class="label">Institute</label>
                    <div class="control">
                        <div class="select">
                            <select>
                                <c:forEach items="${institutes}" var="inst">
                                    <option value="${inst.getIdInstitute()}">${inst.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field is-inline-block column">
                    <label class="label">Professor</label>
                    <div class="control">
                        <div class="select">
                            <select>
                                <c:forEach items="${professors}" var="prof">
                                    <option value="${prof.getIdProfessor()}">${prof.getFirstName()}</option>
                                </c:forEach>
                            </select>
                        </div>
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