<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Institutes</h1>
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
                <c:forEach items="${institutes}" var="a">
                    <tr>
                        <th>${a.getIdInstitute()}</th>
                        <th>${a.getName()}</th>
                        <th>${a.getLogo()}</th>
                        <th>${a.getSite()}</th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>