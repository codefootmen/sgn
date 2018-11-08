    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:import url="../header.jsp"/>
    <c:import url="../navbar.jsp"/>

    <div class="container">
        <div class="columns">
            <div class="column">
                <h1 class="title has-text-centered">${operation} Period</h1>
            </div>
        </div>
        <div class="columns">
            <div class="column">

                <div class="field">
                    <label class="label">Start</label>
                    <div class="control">
                        <input class="input is-info" type="text" placeholder="DD-MM-YYYY">
                    </div>
                </div>

                <div class="field">
                    <label class="label">End</label>
                    <div class="control">
                        <input class="input is-info" type="text" placeholder="DD-MM-YYYY">
                    </div>
                </div>

                <div class="field is-inline-block">
                    <label class="label">Room</label>
                    <div class="control">
                        <div class="select">
                            <select>
                                <c:forEach items="${rooms}" var="room">
                                    <option value="${room.getIdRoom()}" <c:if test="${period.getIdRooms == room.getIdRoom}"> selected </c:if>${room.getNumber()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Day of the week</label>
                    <div class="is-inline-block">
                        <div class="select">
                            <select>
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