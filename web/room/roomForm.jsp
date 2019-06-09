<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<form action="${path}${action}" method="POST">
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Number</label>
                <div class="control">
                    <input class="input is-info" type="number" name="number" min="0" placeholder="Number of the room"
                           value="${room.getNumber()}">
                </div>
            </div>
            <div class="field">
                <label class="label">Quantity of Seats</label>
                <div class="control">
                    <input class="input is-info" type="number" name="quantityOfSeats" min="0" placeholder="Number of seats"
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
                                            <c:if test="${room.getRoomType().getIdRoomType() == roomType.getIdRoomType()}"> selected </c:if>> ${roomType.getName()}
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
                                            test="${room.getBuilding().getIdBuilding() == building.getIdBuilding()}"> selected </c:if>>
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
<c:import url="../footer.jsp"/>
