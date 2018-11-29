<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<form action="${path}${action}" method="POST">
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                    <input class="input is-info" name="name" type="text" placeholder="Text input"
                           value="${event.getName()}">
                </div>
            </div>

            <div class="field">
                <label class="label">Date</label>
                <div class="control">
                    <input class="input is-info" name="date" type="text" placeholder="MM-DD-YYYY"
                           value="${event.getDate()}">
                </div>
            </div>

            <div class="field">
                <div class="columns">

                    <div class="field is-inline-block column">
                        <label class="label">Period</label>
                        <div class="control">
                            <div class="select">
                                <select name="idPeriod">
                                    <c:forEach items="${periods}" var="period">
                                        <option value="${period.getIdPeriod()}" <c:if
                                                test="${event.getIdPeriod() == period.getIdPeriod()}"> selected </c:if> >${period.getStart()} </option>
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
                                        <option value="${prof.getIdProfessor()}" <c:if
                                                test="${event.getIdProfessor() == prof.getIdProfessor()}"> selected </c:if> >${prof.getFirstName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="field is-inline-block column">
                        <label class="label">Room</label>
                        <div class="control">
                            <div class="select">
                                <select name="idRoom">
                                    <c:forEach items="${rooms}" var="room">
                                        <option value="${room.getIdRoom()}" <c:if
                                                test="${event.getIdRoom() == room.getIdRoom()}"> selected </c:if> >${room.getNumber()}</option>
                                    </c:forEach>
                                </select>
                            </div>
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
