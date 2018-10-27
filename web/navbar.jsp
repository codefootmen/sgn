<nav class="navbar is-info is-fixed-top">
    <div class="container">
        <div class="navbar-brand">
            <a class="navbar-item" href="${path}/" style="font-weight:bold;">
                SGN
            </a>
            <span class="navbar-burger burger" data-target="navMenu">
            <span></span>
            <span></span>
            <span></span>
          </span>
        </div>
        <div id="navMenu" class="navbar-menu">
            <div class="navbar-start">

                <div class="navbar-item is-hoverable">
                    <a class="navbar-link" href="${path}/">
                        Pages
                    </a>
                    <div class="navbar-dropdown is-boxed">
                        <a class="navbar-item" href="${path}/activities/">
                            Activities
                        </a>
                        <a class="navbar-item" href="${path}/buildings/">
                            Buildings
                        </a>
                        <a class="navbar-item" href="${path}/campi/">
                            Campi
                        </a>
                        <a class="navbar-item" href="${path}/courses/">
                            Courses
                        </a>
                        <a class="navbar-item" href="${path}/departments/">
                            Departments
                        </a>
                        <a class="navbar-item" href="${path}/events/">
                            Events
                        </a>
                        <a class="navbar-item" href="${path}/institutes/">
                            Institutes
                        </a>
                        <a class="navbar-item" href="${path}/meetings/">
                            Meetings
                        </a>
                        <a class="navbar-item" href="${path}/periods/">
                            Periods
                        </a>
                        <a class="navbar-item" href="${path}/professors/">
                            Professors
                        </a>
                        <a class="navbar-item" href="${path}/programs/">
                            Programs
                        </a>
                        <a class="navbar-item" href="${path}/requests/">
                            Requests
                        </a>
                        <a class="navbar-item" href="${path}/rooms/">
                            Rooms
                        </a>
                        <a class="navbar-item" href="${path}/roomTypes/">
                            Room Types
                        </a>
                        <a class="navbar-item" href="${path}/students/">
                            Students
                        </a>
                        <a class="navbar-item" href="${path}/subjects/">
                            Subjecs
                        </a>
                        <hr class="navbar-divider">
                        <a class="navbar-item is-active" href="">
                            V1.0.0
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
<script type="text/javascript">
    (function() {
        var burger = document.querySelector('.burger');
        var nav = document.querySelector('#'+burger.dataset.target);
        burger.addEventListener('click', function(){
            burger.classList.toggle('is-active');
            nav.classList.toggle('is-active');
        });
    })();
</script>