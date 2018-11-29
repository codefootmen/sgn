<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<form action="${path}${action}" method="post">
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Day</label>
                <div class="control">
                    <input class="input is-info" name="day" type="text" placeholder="MM-DD-YYYY"
                           value="${meeting.getDay()}">
                </div>
            </div>
            <div class="field">
                <label class="label">Time</label>
                <div class="control">
                    <input class="input is-info" name="time" type="text" placeholder="Text input"
                           value="${meeting.getTime()}">
                </div>
            </div>
            <div class="field">
                <label class="label">Agenda</label>
                <div class="control">
                    <input class="input is-info" name="agenda" type="text" placeholder="Text input"
                           value="${meeting.getAgenda()}">
                </div>
            </div>
            <div class="field">
                <label class="label">Minutes</label>
                <div class="control">
                    <input class="input is-info" name="minutes" type="text" placeholder="Text input"
                           value="${meeting.getMinutes()}">
                </div>
            </div>
            <div class="field">
                <div class="columns">
                    <div class="field is-inline-block column">
                        <label class="label">Department</label>
                        <div class="control">
                            <div class="select">
                                <select name="idDepartment">
                                    <c:forEach items="${departments}" var="dept">
                                        <option value="${dept.getIdDepartment()}" <c:if
                                                test="${meeting.getIdDepartment() == dept.getIdDepartment()}"> selected </c:if> >${dept.getField()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-inline-block column">
                        <label class="label">Campus</label>
                        <div class="control">
                            <div class="select">
                                <select name="idCampus">
                                    <c:forEach items="${campi}" var="cam">
                                        <option value="${cam.getIdCampus()}"
                                                <c:if test="${meeting.getIdCampus() == cam.getIdCampus()}">selected </c:if> >${cam.getName()}</option>
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
                                        <option value="${inst.getIdInstitute()}" <c:if
                                                test="${meeting.getIdInstitute() == inst.getIdInstitute()}"> selected </c:if> >${inst.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="field is-grouped">
                <div class="control">
                    <button class="button is-link" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </div>
</form>
<c:import url="../footer.jsp"/>
