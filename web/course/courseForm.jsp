    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:import url="../header.jsp"/>
    <c:import url="../navbar.jsp"/>

    <div class="container">
        <div class="columns">
            <div class="column">
                <h1 class="title has-text-centered">${operation} Course</h1>
            </div>
        </div>
        <form action="${path}${action}" method="POST">
            <div class="columns">
                <div class="column">
                    <div class="field is-inline-block">
                        <label class="label">Semester</label>
                        <div class="control">
                            <div class="select">
                                <select name="semester">
                                        <option value="0">1</option>
                                        <option value="1">2</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Year</label>
                        <div class="control">
                            <input class="input is-info" name="year" type="Number" min="1900" max="2100" value="${course.getYear()}">
                        </div>
                    </div>

                    <div class="columns">
                        <div class="field is-inline-block column">
                            <label class="label">Subject</label>
                            <div class="control">
                                <div class="select">
                                    <select name="idSubject">
                                        <c:forEach items="${subjects}" var="subj">
                                        <option value="${subj.getIdSubject()}" <c:if test="${course.getIdSubject() == subj.getIdSubject()}"> selected </c:if> >${subj.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field is-inline-block column">
                            <label class="label">Program</label>
                            <div class="control">
                                <div class="select">
                                    <select name="idProgram">
                                        <c:forEach items="${programs}" var="prog">
                                            <option value="${prog.getIdProgram()}" <c:if test="${course.getIdProgram() == prog.getIdProgram()}"> selected </c:if> > ${prog.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field is-inline-block column">
                            <label class="label">Department</label>
                            <div class="control">
                                <div class="select">
                                    <select name="idDepartment">
                                        <c:forEach items="${departments}" var="depart">
                                            <option value="${depart.getIdDepartment()}" <c:if test="${course.getIdDepartment() == depart.getIdDepartment()}"> selected </c:if>>${depart.getField()}</option>
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
                                        <c:forEach items="${campi}" var="camp">
                                            <option value="${camp.getIdCampus()}" <c:if test="${course.getIdCampus() == camp.getIdCampus()}"> selected </c:if> > ${camp.getName()}</option>
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
                                            <option value="${inst.getIdInstitute()}"<c:if test="${course.getIdInstitute() == inst.getIdInstitute()}"> selected </c:if>>${inst.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field is-inline-block column">
                            <label class="label">Period</label>
                            <div class="control">
                                <div class="select">
                                    <select name="idPeriod">
                                        <c:forEach items="${periods}" var="per">
                                            <option value="${per.getIdPeriod()}" <c:if test="${course.getIdPeriod() == per.getIdPeriod()}"> selected </c:if>>${per.getStart()} - ${per.getEnd()}</option>
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
                                        <option value="${prof.getIdProfessor()}" <c:if test="${course.getIdProfessor() == prof.getIdProfessor()}"> selected </c:if>>${prof.getFirstName()}</option>
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
            </div>
        </form>
    </div>
    <c:import url="../footer.jsp"/>
    </body>
    </html>