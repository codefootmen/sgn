<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/header.jsp"/>
<!-- START NAV -->
<nav class="navbar is-white">
    <div class="container">
        <div class="navbar-brand">
            <a class="navbar-item brand-text" href="../">
                SGN
            </a>
        </div>
    </div>
</nav>
<!-- END NAV -->
<div class="container">
    <div class="columns">
        <div class="column is-3 ">
            <c:import url="/sidebar.jsp"/>
        </div>
        <div class="column is-9">
            <section class="hero is-info welcome is-small">
                <div class="hero-body">
                    <div class="container">
                        <h1 class="title">
                            Hello, Admin.
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
                        <article class="tile is-child box">
                            <p class="title">${ numberOfProfessors }</p>
                            <p class="subtitle">Professors</p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">${ numberOfStudents }</p>
                            <p class="subtitle">Students</p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">${ numberOfEvents }</p>
                            <p class="subtitle">Events</p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">${ numberOfCourses }</p>
                            <p class="subtitle">Courses</p>
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
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    <tr>
                                        <td width="5%"><i class="fa fa-bell-o"></i></td>
                                        <td>Lorum ipsum dolem aire</td>
                                        <td><a class="button is-small is-primary" href="#">Action</a></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <footer class="card-footer">
                            <a href="#" class="card-footer-item">View All</a>
                        </footer>
                    </div>
                </div>
                <div class="column is-6">
                    <div class="card">
                        <header class="card-header">
                            <p class="card-header-title">
                                Inventory Search
                            </p>
                            <a href="#" class="card-header-icon" aria-label="more options">
                  <span class="icon">
                    <i class="fa fa-angle-down" aria-hidden="true"></i>
                  </span>
                            </a>
                        </header>
                        <div class="card-content">
                            <div class="content">
                                <div class="control has-icons-left has-icons-right">
                                    <input class="input is-large" type="text" placeholder="">
                                    <span class="icon is-medium is-left">
                      <i class="fa fa-search"></i>
                    </span>
                                    <span class="icon is-medium is-right">
                      <i class="fa fa-check"></i>
                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <header class="card-header">
                            <p class="card-header-title">
                                User Search
                            </p>
                            <a href="#" class="card-header-icon" aria-label="more options">
                  <span class="icon">
                    <i class="fa fa-angle-down" aria-hidden="true"></i>
                  </span>
                            </a>
                        </header>
                        <div class="card-content">
                            <div class="content">
                                <div class="control has-icons-left has-icons-right">
                                    <input class="input is-large" type="text" placeholder="">
                                    <span class="icon is-medium is-left">
                      <i class="fa fa-search"></i>
                    </span>
                                    <span class="icon is-medium is-right">
                      <i class="fa fa-check"></i>
                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script async type="text/javascript" src="../js/bulma.js"></script>
</body>

</html>
