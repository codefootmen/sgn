<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">New Meeting</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Day</label>
                <div class="control">
                    <input class="input is-info" type="text" placeholder="MM-DD-YYYY">
                </div>
            </div>

            <div class="field">
                <label class="label">Time</label>
                <div class="control">
                    <input class="input is-info" type="text" placeholder="Text input">
                </div>
            </div>

            <div class="field">
                <label class="label">Agenda</label>
                <div class="control">
                    <input class="input is-info" type="text" placeholder="Text input">
                </div>
            </div>

            <div class="field">
                <label class="label">Minutes</label>
                <div class="control">
                    <input class="input is-info" type="text" placeholder="Text input">
                </div>
            </div>

            <div class="columns">

                <div class="field is-inline-block column">
                    <label class="label">Department</label>
                    <div class="control">
                        <div class="select">
                            <select>
                                <c:forEach items="${departments}" var="dept">
                                    <option value="${dept.getIdDepartment()}">${dept.getField()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field is-inline-block column">
                    <label class="label">Campus</label>
                    <div class="control">
                        <div class="select">
                            <select>
                                <c:forEach items="${campi}" var="cam">
                                    <option value="${cam.getIdCampus()}">${cam.getName()}</option>
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