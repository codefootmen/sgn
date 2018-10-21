<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">New Institute</h1>
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
                <label class="label">Web Page</label>
                <div class="control">
                    <input class="input is-info" type="text" placeholder="https://www.sgd.edu.br">
                </div>
            </div>

            <div class="field">
                <div class="file is-boxed is-info has-name">
                    <label class="file-label">
                        <input class="file-input" type="file" name="resume">
                        <span class="file-cta">
                            <span class="file-label">
                              Select File
                            </span>
                        </span>
                    </label>
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