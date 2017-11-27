<%@ include file="includes.jsp"%>

<c:url var="loginPostUrl" value="/login"/>
<c:url var="logoutUrl" value="/logout"/>
<c:url var="loginUrl" value="/login"/>
<c:url var="contextUrl" value="/"/>

<!DOCTYPE html>

<head>
    <title>Login</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" media="screen" href="resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="resources/css/styleLogin.css"/>
</head>

<body>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <jsp:forward page="home.jsp"></jsp:forward>
</c:if>

<div class="container-fluid">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="col-md-12">
                <div class="navbar-collapse collapse" id="additional-nav">
                    <sec:authorize access="isAnonymous()">
                        <ul class="nav navbar-nav">
                            <li class="active" id="loginMenu"><a href="${loginUrl}">Prototype Model</a></li>
                        </ul>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <ul class="nav navbar-nav">
                            <li><a id="applicationTitleMenu">Prototype Model</a></li>
                        </ul>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a id="logoutMenu" href="${logoutUrl}">Logout</a></li>
                        </ul>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </nav>

</div>
<div class="background-image"></div>
<div class="cont">
    <br/>
    <div class="col-md-12 popup-msg">
        <c:if test="${!logout && !errors}">
            <div class="alert alert-success alert-dismissable" align="center">
                <button type="button" class="close" data-dismiss="alert"></button>
                Ingrese sus credenciales.
            </div>
        </c:if>

        <c:if test="${logout}">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                Sesión cerrada exitosamente!.
            </div>
        </c:if>

        <c:if test="${errors}">
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                Las credenciales ingresadas son incorrectas!
            </div>
        </c:if>
    </div>
    <br/>
        <div class="login__logo"></div>
        <br/>
        <div class="login__padlock"></div>
        <div class="login__form">
            <form role="form" class="form-horizontal" action="${loginPostUrl}" method="POST">
                <div class="login__row">
                    <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                        <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                    </svg>
                    <input type="text" id="username" name="username" class="login__input name" pattern="\w+"
                       placeholder="Ingrese su nombre de usuario" autocomplete="off" autofocus>
                </div>
                <div class="login__row">
                    <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                        <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                    </svg>
                    <input id="password" name='password' type="password" class="login__input pass"
                       placeholder="Ingrese su contraseña" autocomplete="off">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <br/><br/>
                <button type="submit" id="login" class="btn btn-success login__submit">Iniciar Sesión</button>
            </form>
        </div>
    </div>

</body>

<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>

</html>