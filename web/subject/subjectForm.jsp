<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<form action="${path}${action}" method="POST">
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                    <input class="input is-info" type="text" name="name" placeholder="Text input"
                           value="${subject.getName()}">
                </div>
            </div>
            <div class="field">
                <label class="label">Quantity of Credits</label>
                <div class="control">
                    <input class="input is-info" type="number" min="1" name="quantityOfCredits" placeholder="Text input"
                           value="${subject.getQuantityOfCredits()}">
                </div>
            </div>
            <div class="columns">
                <div class="field is-inline-block column">
                    <label class="label">Room Type</label>
                    <div class="control">
                        <div class="select">
                            <select name="idRoomType">
                                <c:forEach items="${roomTypes}" var="roomType">
                                    <option value="${roomType.getIdRoomType()}"
                                            <c:if test="${subject.getRoomType().getName() == roomType.getName()}"> selected </c:if>> ${roomType.getName()}
                                    </option>
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
                                <c:forEach items="${programs}" var="pro">
                                    <option value="${pro.getIdProgram()}" <c:if
                                            test="${subject.getProgram().getIdProgram() == pro.getIdProgram()}"> selected </c:if>>
                                            ${pro.getName()}</option>
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
                                    <option value="${depart.getIdDepartment()}" <c:if
                                            test="${subject.getIdDepartment() == depart.getIdDepartment()}"> selected </c:if>> ${depart.getField()}</option>
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
                                    <option value="${camp.getIdCampus()}" <c:if
                                            test="${subject.getIdCampus() == camp.getIdCampus()}"> selected </c:if>> ${camp.getName()}</option>
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
                                            test="${subject.getIdInstitute() == inst.getIdInstitute()}"> selected </c:if>> ${inst.getName()}</option>
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
<c:import url="../footer.jsp"/>