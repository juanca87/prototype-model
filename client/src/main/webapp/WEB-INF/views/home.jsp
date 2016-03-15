<%@ include file="/WEB-INF/views/includes.jsp"%>

<c:url var="loginPostUrl" value="/j_spring_security_check"/>
<c:url var="logoutUrl" value="/j_spring_security_logout"/>
<c:url var="loginUrl" value="/login"/>
<c:url var="contextUrl" value="/"/>

<html>

<head>
    <title>Home</title>
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
                            <li id="home" class="active"><a href="${contextUrl}home">Home</a></li>
                            <li id="amazonEC2"><a href="${contextUrl}amazon">Amazon EC2</a></li>
                            <li id="googleAppEngine"><a href="${contextUrl}google">Google App Engine</a></li>
                            <li id="heroku"><a href="${contextUrl}heroku">Heroku</a></li>
                        </ul>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="${logoutUrl}">
                                    <i class="fa fa-user fa-1.5x"></i>Logout
                                </a>
                            </li>
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
</ol>

<div class="row">
    <div class="col-md-12">
        <h1 class="page-head-line">${title}</h1>
        <h1 class="page-subhead-line">${message}</h1>
    </div>
</div>

<div>

<!-- /. CLOUDS  -->
    <div class="row">
        <!-- AMAZON -->
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-yellow">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <!-- <i class="fa fa-shopping-cart fa-5x"></i> -->
                            <img src="resources/img/cloudsLogos/amazonEC2_bn.png" alt="Amazon EC2"
                                style="width: 70 px; height: 70;" class="img-u image-responsive" />
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">Nube:</div>
                            <div>Amazon EC2</div>
                        </div>
                    </div>
                </div>
                <a href="${contextUrl}amazon">
                    <div class="panel-footer">
                        <span class="pull-left">Ver Detalles</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <!-- GOOGLE -->
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <!-- <i class="fa fa-comments fa-5x"></i> -->
                            <img src="resources/img/cloudsLogos/googleAppEngine_bn.png" alt="Google App Engine"
                                style="width: 70 px; height: 70;" class="img-u image-responsive" />
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">Nube:</div>
                            <div>Google App Engine</div>
                        </div>
                    </div>
                </div>
                <a href="${contextUrl}google">
                    <div class="panel-footer">
                        <span class="pull-left">Ver Detalles</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <!-- HEROKU -->
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-purple">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <!-- <i class="fa fa-support fa-5x"></i> -->
                            <img src="resources/img/cloudsLogos/heroku_bn.png" alt="Heroku"
                                style="width: 70 px; height: 70;" class="img-u image-responsive" />
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">Nube:</div>
                            <div>Heroku</div>
                        </div>
                    </div>
                </div>
                <a href="${contextUrl}heroku">
                    <div class="panel-footer">
                        <span class="pull-left">Ver Detalles</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <!-- COMPARACION -->
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-tasks fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">Nube:</div>
                            <div>Comparaciones</div>
                        </div>
                    </div>
                </div>
                <a href="#">
                    <div class="panel-footer">
                        <span class="pull-left">Ver Detalles</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">

            <div id="reviews" class="carousel slide" data-ride="carousel">

                <div class="carousel-inner">
                    <div class="item active">

                        <div class="col-md-10 col-md-offset-1">

                            <h4><i class="fa fa-quote-left"></i>Modelo de evaluacion con metricas de atributos de calidad. <i class="fa fa-quote-right"></i></h4>
                            <div class="user-img pull-right">
                                <img src="resources/img/methodologyLogos/iso.png" alt="" class="img-u image-responsive" />
                            </div>
                            <h5 class="pull-right"><strong class="c-black">ISO 25000</strong></h5>
                        </div>
                    </div>
                    <div class="item">
                        <div class="col-md-10 col-md-offset-1">

                            <h4><i class="fa fa-quote-left"></i>Model de evaluacion en base atributos tomados de ITIL <i class="fa fa-quote-right"></i></h4>
                            <div class="user-img pull-right">
                                <img src="resources/img/methodologyLogos/itil.png" alt="" class="img-u image-responsive" />
                            </div>
                            <h5 class="pull-right"><strong class="c-black">ITIL</strong></h5>
                        </div>

                    </div>
                    <div class="item">
                        <div class="col-md-10 col-md-offset-1">

                            <h4><i class="fa fa-quote-left"></i>Aplicacion del metodo IQMC para el desarrollo del modelo. <i class="fa fa-quote-right"></i></h4>
                            <div class="user-img pull-right">
                                <img src="resources/img/methodologyLogos/iqmc.png" alt="" class="img-u image-responsive" />
                            </div>
                            <h5 class="pull-right"><strong class="c-black">IQMC</strong></h5>
                        </div>
                    </div>
                </div>
                <!--INDICATORS-->
                <ol class="carousel-indicators">
                    <li data-target="#reviews" data-slide-to="0" class="active"></li>
                    <li data-target="#reviews" data-slide-to="1"></li>
                    <li data-target="#reviews" data-slide-to="2"></li>
                </ol>
                <!--PREVIUS-NEXT BUTTONS-->

            </div>

        </div>

    </div>

    <br/>

    <div class="col-lg-4">
        <div class="panel panel-default">
            <div class="panel-heading">
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
            <!-- /.panel-body -->
        </div>
    </div>
    
    <!-- AREA CHART -->
    <div class="col-lg-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> Area Chart Example
                <div class="pull-right">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                            Actions
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="#">Action</a>
                            </li>
                            <li><a href="#">Another action</a>
                            </li>
                            <li><a href="#">Something else here</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div id="morris-area-chart"></div>
            </div>
            <!-- /.panel-body -->
        </div>
    </div>

    <div style="display:none;">
        <input id="hostAddress" type="text" value="${hostAddress}">
    </div>

</div>

</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/app/morris-data.js"/>" type="text/javascript"></script>

</html>