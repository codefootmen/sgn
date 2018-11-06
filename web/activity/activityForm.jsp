<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Activity</h1>
        </div>
    </div>
    <form action="${path}${action}" method="POST">
        <div class="columns">
            <div class="column">
                <div class="field">
                    <label class="label">Name</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="name" placeholder="Text input"
                               value="${activity.getName()}">
                    </div>
                </div>
                <div class="field">
                    <label class="label">Area</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="area" placeholder="Text input"
                               value="${activity.getArea()}">
                    </div>
                </div>
                <div class="columns">
                    <div class="field is-inline-block column">
                        <label class="label">Activity Type</label>
                        <div class="control">
                            <div class="select">
                                <select name="activityType">
                                    <c:forEach items="${activityTypes}" var="acTy">
                                        <option value="${acTy}"
                                                <c:if test="${activity.getActivityType() == acTy}"> selected </c:if>> ${acTy}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-inline-block column">
                        <label class="label">Professor</label>
                        <div class="control">
                            <div class="select">
                                <select name="professor">
                                    <c:forEach items="${professors}" var="prof">
                                        <option value="${prof.getIdProfessor()}" <c:if
                                                test="${activity.getIdProfessor() == prof.getIdProfessor()}"> selected </c:if>> ${prof.getFirstName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-inline-block column">
                        <label class="label">Department</label>
                        <div class="control">
                            <div class="select">
                                <select name="department">
                                    <c:forEach items="${departments}" var="depart">
                                        <option value="${depart.getIdDepartment()}" <c:if
                                                test="${activity.getIdDepartment() == depart.getIdDepartment()}"> selected </c:if>> ${depart.getField()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-inline-block column">
                        <label class="label">Campus</label>
                        <div class="control">
                            <div class="select">
                                <select name="campus">
                                    <c:forEach items="${campi}" var="camp">
                                        <option value="${camp.getIdCampus()}" <c:if
                                                test="${activity.getIdCampus() == camp.getIdCampus()}"> selected </c:if>> ${camp.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-inline-block column">
                        <label class="label">Institute</label>
                        <div class="control">
                            <div class="select">
                                <select name="institute">
                                    <c:forEach items="${institutes}" var="inst">
                                        <option value="${inst.getIdInstitute()}" <c:if
                                                test="${activity.getIdInstitute() == inst.getIdInstitute()}"> selected </c:if>> ${inst.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-inline-block column">
                        <label class="label">Program</label>
                        <div class="control">
                            <div class="select">
                                <select name="program">
                                    <c:forEach items="${programs}" var="prog">
                                        <option value="${prog.getIdProgram()}" <c:if
                                                test="${activity.getIdProgram() == prog.getIdProgram()}"> selected </c:if>> ${prog.getName()}</option>
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