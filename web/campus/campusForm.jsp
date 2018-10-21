    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:import url="../header.jsp"/>
    <c:import url="../navbar.jsp"/>

    <div class="container">
        <div class="columns">
            <div class="column">
                <h1 class="title has-text-centered">New Campus</h1>
            </div>
        </div>
        <div class="columns">
            <div class="column">
                <div class="field">
                    <label class="label">Name</label>
                    <div class="control">
                        <input class="input is-info" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Street</label>
                    <div class="control">
                        <input class="input is-info" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Number</label>
                    <div class="control">
                        <input class="input is-info" type="number" placeholder="Number input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">City</label>
                    <div class="control">
                        <input class="input is-info" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">State</label>
                    <div class="control">
                        <input class="input is-info" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Telephone</label>
                    <div class="control">
                        <input class="input is-info" type="number" placeholder="Number input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">ZIP</label>
                    <div class="control">
                        <input class="input is-info" type="number" placeholder="Number input">
                    </div>
                </div>

                <div class="field is-center">
                    <div class="control">
                        <label class="label is-inline-block">Institute</label>
                        <div class="select is-inline-block">
                            <select>
                                <c:forEach items="${institutes}" var="inst">
                                    <option value="${inst.getIdInstitute()}">${inst.getName()}</option>
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