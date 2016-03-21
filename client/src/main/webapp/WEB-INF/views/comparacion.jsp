<%@ include file="/WEB-INF/views/includes.jsp"%>

<c:url var="loginPostUrl" value="/j_spring_security_check"/>
<c:url var="logoutUrl" value="/j_spring_security_logout"/>
<c:url var="loginUrl" value="/login"/>
<c:url var="contextUrl" value="/"/>

<html>

<head>
    <title>Comparación</title>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <link rel="stylesheet" href="resources/css/bootstrap.css"/>
    <link rel="stylesheet" href="resources/css/font-awesome.css"/>
    <link rel="stylesheet" href="resources/css/basic.css"/>
    <link rel="stylesheet" href="resources/css/custom.css"/>
    <link rel="stylesheet" href="resources/css/styles.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/prettify/r224/prettify.min.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans"/>
</head>

<body class="body-custom">
<div class="container-fluid">

    <!-- BARRA DE NAVEGACION -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="col-md-12">
                <div class="navbar-collapse collapse" id="additional-nav">
                    <sec:authorize access="isAnonymous()">
                        <ul class="nav navbar-nav">
                            <li class="active" id="login"><a href="${loginUrl}">Login</a></li>
                        </ul>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <ul class="nav navbar-nav">
                            <li id="home"><a href="${contextUrl}home">Home</a></li>
                            <li id="amazonEC2"><a href="${contextUrl}amazon">Amazon EC2</a></li>
                            <li id="googleAppEngine"><a href="${contextUrl}google">Google App Engine</a></li>
                            <li id="heroku"><a href="${contextUrl}heroku">Heroku</a></li>
                            <li id="comparacion" class="active"><a href="${contextUrl}comparacion">Comparación</a></li>
                        </ul>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a class="dropdown-toggle" href="${logoutUrl}"><i class="fa fa-user fa-1.5x"></i>Logout</a></li>
                        </ul>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </nav>

</div>

<!-- RUTA ACTUAL -->
<ol class="breadcrumb">
    <li class="active">Home</li>
    <li class="active">${pagina}</li>
</ol>

    <div class="row">
        <div class="col-md-12">
            <h3 class="page-head-line">Historial de Ejecuciones</h3>
                <div id="accordion" class="panel panel-default">
                    <div class="panel-heading">
                        Mediciones anteriores
                    </div>
                </div>
            <h3 class="page-subhead-line"></h3>
        </div>
    </div>

    <div>
        <!-- NOTIFICATIONS -->
        <div class="col-lg-4">
            <div class="panel panel-default" style="margin-left: -15px; margin-bottom: -16px; border-bottom-right-radius: 0px;">
                <div class="panel-heading" style="border-top-right-radius: 0px;">
                    <i class="fa fa-bell fa-fw"></i> Panel de Notificaciones
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <a href="#" class="list-group-item">
                            <i class="fa fa-tasks fa-fw"></i> Última ejecución Amazon:  
                            <span class="pull-right text-muted small"><em>${fechaAmazon}</em>
                            </span>
                        </a>
                        <a href="#" class="list-group-item">
                            <i class="fa fa-tasks fa-fw"></i> Última ejecución Google:  
                            <span class="pull-right text-muted small"><em>${fechaGoogle}</em>
                            </span>
                        </a>
                        <a href="#" class="list-group-item">
                            <i class="fa fa-tasks fa-fw"></i> Última ejecución Heroku:  
                            <span class="pull-right text-muted small"><em>${fechaHeroku}</em>
                            </span>
                        </a>
                    </div>
                </div>
                <!-- LEYENDA -->
                <div class="panel-heading" style="border-top-right-radius: 0px;">
                    <i class="fa th-large fa-fw"></i> Leyenda
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <div class="list-group-item">
                            <div id="leyenda-amazon">
                                <span style="margin-left: 30px">Amazon EC2</span>
                            </div>
                        </div>
                        <div class="list-group-item">
                            <div id="leyenda-google">
                                <span style="margin-left: 30px">Google App Engine</span>
                            </div>
                        </div>
                        <div class="list-group-item">
                            <div id="leyenda-heroku">
                                <span style="margin-left: 30px">Heroku</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- BAR CHART -->
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> Gráfico de Atributos vs Tiempo (seg).
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-8">
                        <br/>
                        <div id="morris-bar-chart"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div style="display:none;">
        <input id="hostAddress" type="text" value="${hostAddress}">
    </div>

</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/app/morris-bar-data.js"/>" type="text/javascript"></script>

</html>