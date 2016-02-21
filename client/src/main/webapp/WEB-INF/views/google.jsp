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
                            <li id="home"><a href="${contextUrl}home">Home</a></li>
                            <li id="amazonEC2"><a href="${contextUrl}amazon">Amazon EC2</a></li>
                            <li id="googleAppEngine" class="active"><a href="${contextUrl}google">Google App Engine</a></li>
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
        <li class="active">Google App Engine</li>
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