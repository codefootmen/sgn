<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>
<c:import url="../navbar.jsp"/>
<div class="container">
    <div class="columns">
        <div class="column">
            <h1 class="title has-text-centered">Campi</h1>
        </div>
    </div>
    <div class="columns">
        <div class="column">

            <table class="table box diplay-table margin-auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Street</th>
                    <th>Number</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Telephone</th>
                    <th>ZIP</th>
                    <th>Institute</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${campi}" var="a">
                    <tr>
                        <td><a href="${path}/campi/${a.getIdCampus()}">${a.getIdCampus()}</a></td>
                        <td>${a.getName()}</td>
                        <td>${a.getStreet()}</td>
                        <td>${a.getNumber()}</td>
                        <td>${a.getCity()}</td>
                        <td>${a.getState()}</td>
                        <td>${a.getTelephone()}</td>
                        <td>${a.getZip()}</td>
                        <td>${a.getIdInstitute()}</td>
                        <td>
                            <a href="/campi/${a.getIdCampus()}/edit">
                                <span class="icon">
                                    <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                                    <path fill="#000000"
                                          d="M5,3C3.89,3 3,3.89 3,5V19A2,2 0 0,0 5,21H19A2,2 0 0,0 21,19V12H19V19H5V5H12V3H5M17.78,4C17.61,4 17.43,4.07 17.3,4.2L16.08,5.41L18.58,7.91L19.8,6.7C20.06,6.44 20.06,6 19.8,5.75L18.25,4.2C18.12,4.07 17.95,4 17.78,4M15.37,6.12L8,13.5V16H10.5L17.87,8.62L15.37,6.12Z"/>
                                    </svg>
                                </span>
                            </a>
                        </td>
                        <td>
                            <form action="/campi/${a.getIdCampus()}" method="POST">
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


        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>