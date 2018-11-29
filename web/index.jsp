    <%-- Created by IntelliJ IDEA. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SGN</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
        <!-- Bulma Version 0.7.2-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css"/>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>

    <body>
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
            <div class="column is-9">



        <div class="hero-body">
            <div class="container has-text-centered">
                <div class="column is-6 is-offset-3">
                    <h1 class="title">
                        Let's Start!
                    </h1>
                    <form action="/authentication" method="POST">
                        <div class="field">
                            <p class="control">
                                <input class="input" name="login" type="text" placeholder="User">
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <input class="input" name="password" type="password" placeholder="Password">
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <button type="submit" class="button is-success is-large">
                                    Login
                                </button>
                                <p class="has-text-right">
                                    <a href="#">Forgot your password? Click here.</a>
                                </p>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>




  <%@ include file = "footer.jsp"%>
  </body>
</html>