<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header.jsp"/>
<section class="hero is-info welcome is-small">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
                Hello, <%= session.getAttribute("access_level") %>
            </h1>
            <h2 class="subtitle">
                I hope you are having a great day!
            </h2>
        </div>
    </div>
</section>
<section class="info-tiles">
    <div class="tile is-ancestor has-text-centered">
        <div class="tile is-parent">
            <article class="tile is-child box" >
                <a href="/professors/">
                    <p class="title">${ numberOfProfessors }</p>
                    <p class="subtitle">Professors</p>
                </a>
            </article>

        </div>
        <div class="tile is-parent">
            <article class="tile is-child box">
                <a href="/students/">
                    <p class="title">${ numberOfStudents }</p>
                    <p class="subtitle">Students</p>
                </a>
            </article>
        </div>
        <div class="tile is-parent">
            <article class="tile is-child box">
                <a href="/events/">
                    <p class="title">${ numberOfEvents }</p>
                    <p class="subtitle">Events</p>
                </a>
            </article>
        </div>
        <div class="tile is-parent">
            <article class="tile is-child box">
                <a href="/courses/">
                    <p class="title">${ numberOfCourses }</p>
                    <p class="subtitle">Courses</p>
                </a>
            </article>
        </div>
    </div>
</section>
<div class="columns">
    <div class="column is-6">
        <div class="card events-card">
            <header class="card-header">
                <p class="card-header-title">
                    Events
                </p>
                <a href="#" class="card-header-icon" aria-label="more options">
                  <span class="icon">
                    <i class="fa fa-angle-down" aria-hidden="true"></i>
                  </span>
                </a>
            </header>
            <div class="card-table">
                <div class="content">
                    <table class="table is-fullwidth is-striped">
                        <tbody>
                        <c:forEach items="${events}" var="e">
                            <tr>
                                <td width="5%"><i class="fa fa-bell-o"></i></td>
                                <td>${e.getName()}</td>
                                <td><a class="button is-small is-primary" href="/events/${e.getIdEvent()}">${e.getDate()}</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <footer class="card-footer">
                <a href="/events/" class="card-footer-item">View All</a>
            </footer>
        </div>
    </div>

    <div class="column is-6">
        <div class="card events-card">
            <header class="card-header">
                <p class="card-header-title">
                    Activities
                </p>
                <a href="#" class="card-header-icon" aria-label="more options">
                  <span class="icon">
                    <i class="fa fa-angle-down" aria-hidden="true"></i>
                  </span>
                </a>
            </header>
            <div class="card-table">
                <div class="content">
                    <table class="table is-fullwidth is-striped">
                        <tbody>
                        <c:forEach items="${activities}" var="a">
                            <tr>
                                <td width="5%"><i class="fa fa-bell-o"></i></td>
                                <td>${a.getName()}</td>
                                <td><a class="button is-small is-primary" href="/activities/${a.getIdActivity()}">${a.getActivityType()}</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <footer class="card-footer">
                <a href="/activities/" class="card-footer-item">View All</a>
            </footer>
        </div>
    </div>
</div>
<c:import url="/footer.jsp"/>