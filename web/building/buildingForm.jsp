<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<form action="${path}${action}" method="POST">
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                    <input class="input is-info" name="name" type="text" placeholder="Text input"
                           value="${building.getName()}">
                </div>
            </div>
            <div class="field">
                <label class="label">Quantity of bathrooms</label>
                <div class="control">
                    <input class="input is-info" name="quantityOfBathrooms" type="number" placeholder="Number input"
                           value="${building.getQuantityOfBathrooms()}">
                </div>
            </div>
            <div class="field">
                <div class="checkbox">
                    <input class="is-info" name="elevator" id="elevator"
                           type="checkbox" ${building.getElevator() ? "checked" : ""}>
                    <label for="elevator">Elevator(s)</label>
                </div>
            </div>
            <div class="field">
                <div class="checkbox">
                    <input class="is-info" name="accessibility" id="accessibility"
                           type="checkbox" ${building.getAccessibility() ? "checked" : ""}>
                    <label for="accessibility">Accessibility</label>
                </div>
            </div>

            <div class="field is-center">
                <div class="control">
                    <label class="label is-inline-block">Campus</label>
                    <div class="select is-inline-block">
                        <select name="campus">
                            <c:forEach items="${campi}" var="camp">
                                <option value="${camp.getIdCampus()}" <c:if
                                        test="${building.getIdCampus() == camp.getIdCampus()}"> selected </c:if>>${camp.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="field is-center">
                <div class="control">
                    <label class="label is-inline-block">Institute</label>
                    <div class="select is-inline-block">
                        <select name="institute">
                            <c:forEach items="${institutes}" var="inst">
                                <option value="${inst.getIdInstitute()}" <c:if
                                        test="${building.getIdInstitute() == inst.getIdInstitute()}"> selected</c:if>>${inst.getName()}</option>
                            </c:forEach>
                        </select>
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