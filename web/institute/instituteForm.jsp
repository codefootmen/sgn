<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">${operation} Institute</h1>
        </div>
    </div>
    <form action="${path}${action}" method="POST">
        <div class="columns">
            <div class="column">
                <div class="field">
                    <label class="label">Name</label>
                    <div class="control">
                        <input class="input is-info" name="name" type="text" placeholder="Text input"
                               value="${institute.getName()}">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Web Page</label>
                    <div class="control">
                        <input class="input is-info" type="text" placeholder="https://www.sgd.edu.br"
                               value="${institute.getSite()}">
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
    </form>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>