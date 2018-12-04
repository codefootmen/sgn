<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<table class="table box diplay-table margin-auto">
    <thead>
    <tr>
        <th>Name</th>
        <th>Quantity of bathdrooms</th>
        <th>Elevator</th>
        <th>Accessibility</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${buildings}" var="a">
        <tr>
            <td><a href="${path}/buildings/${a.getIdBuilding()}">${a.getName()}</a></td>
            <td>${a.getQuantityOfBathrooms()}</td>
            <td>${a.getElevator()}</td>
            <td>${a.getAccessibility()}</td>
            <td>
                <a href="/buildings/${a.getIdBuilding()}/edit">
                    <span class="icon">
                        <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                        <path fill="#000000"
                              d="M5,3C3.89,3 3,3.89 3,5V19A2,2 0 0,0 5,21H19A2,2 0 0,0 21,19V12H19V19H5V5H12V3H5M17.78,4C17.61,4 17.43,4.07 17.3,4.2L16.08,5.41L18.58,7.91L19.8,6.7C20.06,6.44 20.06,6 19.8,5.75L18.25,4.2C18.12,4.07 17.95,4 17.78,4M15.37,6.12L8,13.5V16H10.5L17.87,8.62L15.37,6.12Z"/>
                        </svg>
                    </span>
                </a>
            </td>
            <td>
                <form action="/buildings/${a.getIdBuilding()}" method="POST">
                    <button type="submit" class="no-button-style">
                        <span class="icon">
                            <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                                <path fill="#000000"
                                      d="M9,3V4H4V6H5V19A2,2 0 0,0 7,21H17A2,2 0 0,0 19,19V6H20V4H15V3H9M7,6H17V19H7V6M9,8V17H11V8H9M13,8V17H15V8H13Z"/>
                            </svg>
                        </span>
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:import url="../footer.jsp"/>
