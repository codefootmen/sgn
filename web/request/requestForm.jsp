<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Request</h1>
        </div>
    </div>
    <form action="${path}${action}" method="POST">
        <div class="columns">
            <div class="column">
                <div class="field">
                    <label class="label">Motive</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="motive" placeholder="Text input"
                               value="${request.getMotive()}">
                    </div>
                </div>
                <div class="field">
                    <label class="label">Description</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="description" placeholder="Text input"
                               value="${request.getDescription()}">
                    </div>
                </div>
                <div class="columns">
                    <div class="field is-inline-block column">
                        <label class="label">Room</label>
                        <div class="control">
                            <div class="select">
                                <select name="room">
                                    <c:forEach items="${rooms}" var="room">
                                        <option value="${room.getIdRoom()}"
                                                <c:if test="${request.getIdRoom() == room.getIdRoom()}"> selected </c:if>> ${room.getNumber()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Priority</label>
                        <div class="control">
                            <div class="select">
                                <select name="priority">
                                    <c:forEach items="${priorities}" var="priority">
                                        <option value="${priority}" <c:if test="${request.getPriority() == priority}">selected </c:if>>${priority}</option>
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