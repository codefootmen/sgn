    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:import url="../header.jsp"/>
    <c:import url="../navbar.jsp"/>

    <div class="container">
        <div class="columns">
            <div class="column">
                <h1 class="title has-text-centered">New Course</h1>
            </div>
        </div>
        <div class="columns">
            <div class="column">
                <div class="field is-inline-block">
                    <label class="label">Semester</label>
                    <div class="control">
                        <div class="select">
                            <select>
                                    <option value="0">1</option>
                                    <option value="1">2</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Year</label>
                    <div class="control">
                        <input class="input is-info" type="Number" min="1900" max="2100" value="2018">
                    </div>
                </div>

                <div class="columns">
                    <div class="field is-inline-block column">
                        <label class="label">Activity Type</label>
                        <div class="control">
                            <div class="select">
                                <select>
                                    <c:forEach items="${subjects}" var="subj">
                                        <option value="${subj.getIdSubject()}">${subj.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="field is-inline-block column">
                        <label class="label">Program</label>
                        <div class="control">
                            <div class="select">
                                <select>
                                    <c:forEach items="${programs}" var="prog">
                                        <option value="${prog.getIdProgram()}">${prog.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="field is-inline-block column">
                        <label class="label">Department</label>
                        <div class="control">
                            <div class="select">
                                <select>
                                    <c:forEach items="${departments}" var="depart">
                                        <option value="${depart.getIdDepartment()}">${depart.getField()}</option>
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
                        <label class="label">Period</label>
                        <div class="control">
                            <div class="select">
                                <select>
                                    <c:forEach items="${periods}" var="per">
                                        <option value="${per.getIdPeriod()}">${per.getStart()} - ${per.getEnd()}</option>
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