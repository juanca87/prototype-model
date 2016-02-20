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

    <!-- BOOTSTRAP STYLES-->
    <link href="resources/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="resources/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM BASIC STYLES-->
    <link href="resources/css/basic.css" rel="stylesheet" />
    <!-- CUSTOM MAIN STYLES-->
    <link href="resources/css/custom.css" rel="stylesheet" />
    <!-- CUSTOM STYLES -->
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css">
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>

<body class="body-custom">
<div class="container-fluid">
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
                            <li id="amazonEC2"><a href="${contextUrl}amazonEC2">Amazon EC2</a></li>
                            <li id="googleAppEngine"><a href="${contextUrl}gooleAppEngine">Google App Engine</a></li>
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

    <ol class="breadcrumb">
        <li class="active">Home</li>
    </ol>
</div>

<div id="page-inner">
    <h1>Title : ${title}</h1>
    <h1>Message : ${message}</h1>

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-head-line">DASHBOARD</h1>
            <h1 class="page-subhead-line">This is dummy text , you can replace it with your original text. </h1>
        </div>
    </div>
    <!-- /. CLOUDS  -->
    <div class="row">
        <div class="col-md-4">
            <div class="main-box mb-amazonEC2">
                <a href="#">
                    <img src="resources/img/cloudsLogos/amazonEC2.png" alt="Amazon EC2"
                        style="width: 50 px; height: 50;" class="img-u image-responsive" />
                    <h5 style="color: orange;">Amazon EC2</h5>
                </a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="main-box mb-googleAppEngine">
                <a href="#">
                    <img src="resources/img/cloudsLogos/googleAppEngine.png" alt="Google App Engine"
                        style="width: 50 px; height: 50;" class="img-u image-responsive" />
                    <h5 style="color: #0080ff;">Google App Engine</h5>
                </a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="main-box mb-heroku">
                <a href="#">
                    <img src="resources/img/cloudsLogos/heroku.png" alt="Heroku"
                        style="width: 50 px; height: 50;" class="img-u image-responsive" />
                    <h5 style="color: #8000ff;">Heroku</h5>
                </a>
            </div>
        </div>
    </div>

    <!-- / . CAROUSEL -->
    <div class="row">
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12">

                    <div id="reviews" class="carousel slide" data-ride="carousel">

                        <div class="carousel-inner">
                            <div class="item active">

                                <div class="col-md-10 col-md-offset-1">

                                    <h4><i class="fa fa-quote-left"></i>Modelo de evaluacion con metricas de atributos de calidad. <i class="fa fa-quote-right"></i></h4>
                                    <div class="user-img pull-right">
                                        <img src="resources/img/user.gif" alt="" class="img-u image-responsive" />
                                    </div>
                                    <h5 class="pull-right"><strong class="c-black">ISO 25000</strong></h5>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col-md-10 col-md-offset-1">

                                    <h4><i class="fa fa-quote-left"></i>Model de evaluacion en base atributos tomados de ITIL <i class="fa fa-quote-right"></i></h4>
                                    <div class="user-img pull-right">
                                        <img src="resources/img/user.png" alt="" class="img-u image-responsive" />
                                    </div>
                                    <h5 class="pull-right"><strong class="c-black">ITIL</strong></h5>
                                </div>

                            </div>
                            <div class="item">
                                <div class="col-md-10 col-md-offset-1">

                                    <h4><i class="fa fa-quote-left"></i>Aplicacion del metodo IQMC para el desarrollo del modelo. <i class="fa fa-quote-right"></i></h4>
                                    <div class="user-img pull-right">
                                        <img src="resources/img/user.gif" alt="" class="img-u image-responsive" />
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
            <!-- /. ROW  -->
            <hr />

            <div class="panel panel-default">

                <div id="carousel-example" class="carousel slide" data-ride="carousel" style="border: 5px solid #000;">

                    <div class="carousel-inner">
                        <div class="item active">

                            <img src="resources/img/slideshow/1.jpg" alt="" />

                        </div>
                        <div class="item">
                            <img src="resources/img/slideshow/2.jpg" alt="" />

                        </div>
                        <div class="item">
                            <img src="resources/img/slideshow/3.jpg" alt="" />

                        </div>
                    </div>
                    <!--INDICATORS-->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example" data-slide-to="1"></li>
                        <li data-target="#carousel-example" data-slide-to="2"></li>
                    </ol>
                    <!--PREVIUS-NEXT BUTTONS-->
                    <a class="left carousel-control" href="#carousel-example" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <input type="submit" value="Ejecutar Test" class="btn btn-primary" onclick="javascript:saveResultadoEjecucion()"/>

    <div id="waiting" class="centered" style="display: none">
        <p>Please wait...</p>
    </div>

    <div id="dash"></div>
</div>

</body>

<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/app/resultadoEjecucion.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/js-prototype-app.js"/>" type="text/javascript" ></script>

</html>