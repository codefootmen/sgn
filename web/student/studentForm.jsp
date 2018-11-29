<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Student</h1>
        </div>
    </div>
    <form action="${path}${action}" method="POST">
        <div class="columns">
            <div class="column">
                <div class="field">
                    <label class="label">First Name</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="firstName" placeholder="Text input"
                               value="${student.getFirstName()}">
                    </div>
                </div>
                <div class="field">
                    <label class="label">Last Name</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="lastName" placeholder="Text input"
                               value="${student.getLastName()}">
                    </div>
                </div>
                <div class="field">
                    <label class="label">Email</label>
                    <div class="control">
                        <input class="input is-info" type="text" name="email" placeholder="Text input"
                               value="${student.getEmail()}">
                    </div>
                </div>
                <div class="columns">
                    <div class="field is-inline-block column">
                        <label class="label">Activity</label>
                        <div class="control">
                            <div class="select">
                                <select name="activity">
                                    <c:forEach items="${activities}" var="activity">
                                        <option value="${activity.getIdActivity()}"
                                                <c:if test="${activity.getIdActivity() == student.getIdActivity()}"> selected </c:if>> ${activity.getName()}
                                        </option>
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