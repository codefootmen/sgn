<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<form action="${path}${action}" method="post">
    <div class="columns">
        <div class="column">

            <div class="field">
                <label class="label">Start</label>
                <div class="control">
                    <input class="input is-info" name="start" type="text" placeholder="DD-MM-YYYY"
                           value="${period.getStart()}">
                </div>
            </div>

            <div class="field">
                <label class="label">End</label>
                <div class="control">
                    <input class="input is-info" name="end" type="text" placeholder="DD-MM-YYYY"
                           value="${period.getEnd()}">
                </div>
            </div>

            <div class="field is-inline-block">
                <label class="label">Room</label>
                <div class="control">
                    <div class="select">
                        <select name="idRoom">
                            <c:forEach items="${rooms}" var="room">
                                <option value="${room.getIdRoom()}" <c:if
                                        test="${period.getRoom().getIdRoom() == room.getIdRoom()}"> selected </c:if> >${room.getNumber()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="field">
                <label class="label">Day of the week</label>
                <div class="is-inline-block">
                    <div class="select">
                        <select name="dayOfTheWeek">
                            <option value="monday">Monday</option>
                            <option value="tuesday">Tuesday</option>
                            <option value="wednesday">Wednesday</option>
                            <option value="thursday">Thursday</option>
                            <option value="friday">Friday</option>
                            <option value="saturday">Saturday</option>
                            <option value="sunday">Sunday</option>
                        </select>
                    </div>
                </div>

            </div>

            <div class="field is-grouped">
                <div class="control">
                    <button class="button is-link" type="submit">Submit</button>
                </div>
                <div class="control">
                    <button class="button is-text" type="reset">Cancel</button>
                </div>
            </div>
        </div>
    </div>
</form>
<c:import url="../footer.jsp"/>
