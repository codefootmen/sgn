<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
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
                    <input class="input is-info" name="site" type="text" placeholder="https://www.sgn.edu.br"
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
<c:import url="../footer.jsp"/>
