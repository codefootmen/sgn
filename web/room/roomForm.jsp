<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Room</h1>
        </div>
    </div>
    <form action="${path}${action}" method="POST">
        <div class="columns">
            <div class="column">
                <div class="field">
                    <label class="label">Number</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="number" placeholder="Text input"
                               value="${room.getNumber()}">
                    </div>
                </div>
                <div class="field">
                    <label class="label">Quantity of Seats</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="quantityOfSeats" placeholder="Text input"
                               value="${room.getQuantityOfSeats()}">
                    </div>
                </div>

                <div class="columns">
                    <div class="field is-inline-block column">
                        <label class="label">Room Type</label>
                        <div class="control">
                            <div class="select">
                                <select name="roomType">
                                    <c:forEach items="${roomTypes}" var="roomType">
                                        <option value="${roomType.getIdRoomType()}"
                                                <c:if test="${room.getIdRoomType() == roomType.getIdRoomType()}"> selected </c:if>> ${roomType.getName()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-inline-block column">
                        <label class="label">Building</label>
                        <div class="control">
                            <div class="select">
                                <select name="building">
                                    <c:forEach items="${buildings}" var="building">
                                        <option value="${building.getIdBuilding()}" <c:if
                                                test="${room.getIdBuilding() == building.getIdBuilding()}"> selected </c:if>>
                                                ${building.getName()}</option>
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
        </div>
    </form>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>