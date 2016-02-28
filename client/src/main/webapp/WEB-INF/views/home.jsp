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
                            <li><a id="logout" href="${logoutUrl}">Logout</a></li>
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

    <!-- /. CLOUDS  -->
    <div class="row">
        <div class="col-md-4">
            <div class="main-box mb-amazonEC2">
                <a href="${contextUrl}heroku">
                    <img src="resources/img/cloudsLogos/amazonEC2.png" alt="Amazon EC2"
                        style="width: 50 px; height: 50;" class="img-u image-responsive" />
                <h5 style="color: orange;">Amazon EC2</h5>
                </a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="main-box mb-googleAppEngine">
                <a href="${contextUrl}google">
                    <img src="resources/img/cloudsLogos/googleAppEngine.png" alt="Google App Engine"
                        style="width: 50 px; height: 50;" class="img-u image-responsive" />
                <h5 style="color: #0080ff;">Google App Engine</h5>
                </a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="main-box mb-heroku">
                <a href="${contextUrl}heroku">
                    <img src="resources/img/cloudsLogos/heroku.png" alt="Heroku"
                        style="width: 50 px; height: 50;" class="img-u image-responsive" />
                <h5 style="color: #8000ff;">Heroku</h5>
                </a>
            </div>
        </div>
    </div>

</div>

</body>

<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>

</html>