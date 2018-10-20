<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Institutions</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Logo</th>
                    <th>Site</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>${institute.getIdInstitute()}</th>
                        <th>${institute.getName()}</th>
                        <th><img src="${institute.getLogo()}"></th>
                        <th>${institute.getSite()}</th>
                    </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>