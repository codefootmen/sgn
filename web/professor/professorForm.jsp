    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:import url="../header.jsp"/>
    <c:import url="../navbar.jsp"/>

    <div class="container">
        <div class="columns">
            <div class="column">
                <h1 class="title has-text-centered">${operation} Professor</h1>
            </div>
        </div>
        <form action="${path}${action}" method="POST">
            <div class="columns">
                <div class="column">
                    <div class="field">
                        <label class="label">First Name</label>
                        <div class="control">
                            <input class="input is-info" type="text" name="firstName" placeholder="First Name" value="${professor.getFirstName()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Last Name</label>
                        <div class="control">
                            <input class="input is-info" type="text" name="lastName" placeholder="Last Name" value="${professor.getLastName()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Email</label>
                        <div class="control">
                            <input class="input is-info" type="email" name="email" placeholder="Email" value="${professor.getEmail()}">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Status</label>
                        <div class="control">
                            <div class="select">
                                <select name="status">
                                    <c:forEach items="${status}" var="stat">
                                        <option value="${stat}" <c:if test="${professor.getStatus() == stat}">selected </c:if>>${stat}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Honorifics</label>
                        <div class="control">
                            <div class="select">
                                <select name="honorifics" >
                                    <c:forEach items="${honorifics}" var="hono">
                                        <option value="${hono}" <c:if test="${professor.getHonorifics() == hono}"> selected </c:if>>${hono}</option>
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