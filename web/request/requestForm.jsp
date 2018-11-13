<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Request</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Motive</label>
                <div class="control">
                    <input class="input is-info textarea" type="textarea" placeholder="Motive">
                </div>
            </div>

            <div class="field">
                <label class="label">Description</label>
                <div class="control">
                    <input class="input is-info textarea" type="textarea" placeholder="Motive">
                </div>
            </div>


            <div class="field">
                <label class="label">Priority</label>
                <div class="control">
                    <div class="select">
                        <select>
                            <c:forEach items="${priority}" var="prio">
                                <option value="${priority}" <c:if test="${request.getPriority == prio.getPriority}">selected </c:if>${prio}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="field">
                <label class="label">Room</label>
                <div class="control">
                    <div class="select">
                        <select>
                            <c:forEach items="${room}" var="room">
                                <option value="${room}" <c:if test="${request.getIdRoom == room.getIdRoom}">selected </c:if>${room}</option>
                            </c:forEach>
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