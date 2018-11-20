<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "header.jsp" %>
<%@ include file = "navbar.jsp"%>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">SGN - Home</h1>
            <form action="/authentication/" METHOD="POST">
                <label>Name
                    <input name="login" type="text">
                </label>
                <label>Password
                    <input name="password" type="password">
                </label>
                <input type="submit">
            </form>
        </div>
    </div>
</div>

<%@ include file = "footer.jsp"%>
</body>
</html>