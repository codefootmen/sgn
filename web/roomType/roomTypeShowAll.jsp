<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Room Type</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${roomTypes}" var="a">
                    <tr>
                        <td><a href="${path}/roomTypes/${a.getIdRoomType()}">${a.getIdRoomType()}</a></td>
                        <td>${a.getName()}</td>
                        <td>${a.getDescription()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>