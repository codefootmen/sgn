    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:import url="../header.jsp"/>
    <c:import url="../navbar.jsp"/>

    <div class="container">
        <div class="columns">
            <div class="column">
                <h1 class="title has-text-centered">New Campus</h1>
            </div>
        </div>
        <form action="${path}${action}" method="POST">
            <div class="columns">
                <div class="column">
                    <div class="field">
                        <label class="label">Name</label>
                        <div class="control">
                            <input class="input is-info" name="name" type="text" placeholder="Text input" value="${campus.getName()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Street</label>
                        <div class="control">
                            <input class="input is-info" name="street" type="text" placeholder="Text input" value="${campus.getStreet()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Number</label>
                        <div class="control">
                            <input class="input is-info" name="number" type="number" placeholder="Number input" value="${campus.getNumber()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">City</label>
                        <div class="control">
                            <input class="input is-info" name="city" type="text" placeholder="Text input" value="${campus.getCity()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">State</label>
                        <div class="control">
                            <input class="input is-info" name="state" type="text" placeholder="Text input" value="${campus.getState()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Telephone</label>
                        <div class="control">
                            <input class="input is-info" name="telephone" type="text" placeholder="Number input" value="${campus.getTelephone()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">ZIP</label>
                        <div class="control">
                            <input class="input is-info" name="zip" type="text" placeholder="Number input" value="${campus.getZip()}">
                        </div>
                    </div>

                    <div class="field is-center">
                        <div class="control">
                            <label class="label is-inline-block">Institute</label>
                            <div class="select is-inline-block">
                                <select name="institute">
                                    <c:forEach items="${institutes}" var="inst">
                                        <option value="${inst.getIdInstitute()}" <c:if test="${inst.getIdInstitute() == campus.getIdInstitute()}"> selected</c:if>> ${inst.getName()}</option>
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
    </div>
    <c:import url="../footer.jsp"/>
    </body>
    </html>