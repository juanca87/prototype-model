<%@ include file="/WEB-INF/views/includes.jsp"%>

<c:url var="loginPostUrl" value="/j_spring_security_check"/>
<c:url var="logoutUrl" value="/j_spring_security_logout"/>
<c:url var="loginUrl" value="/login"/>
<c:url var="contextUrl" value="/"/>

<html>

<head>
    <title>Amazon EC2</title>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <link rel="stylesheet" href="resources/css/bootstrap.css"/>
    <link rel="stylesheet" href="resources/css/font-awesome.css"/>
    <link rel="stylesheet" href="resources/css/basic.css"/>
    <link rel="stylesheet" href="resources/css/custom.css"/>
    <link rel="stylesheet" href="resources/css/styles.css">
    <link rel="stylesheet" href="resources/css/style-snazzy-chart-pie.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans"/>

    <link rel="stylesheet" media="screen" href="resources/css/ui.jqgrid-bootstarp.css"/>
    <link rel="stylesheet" media="screen" href="resources/css/ui.jqgrid.css"/>
    <link rel="stylesheet" media="screen" href="resources/css/jquery.ui.base.css"/>
    <link rel="stylesheet" media="screen" href="resources/css/jquery-ui.css"/>
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
        <li class="active">${servidor}</li>
    </ol>
</div>

<div id="page-inner">
<%--     <h4>Servidor : ${servidor}</h4> --%>
<%--     <h4>Mensaje : ${mensaje}</h4> --%>

    <div class="row">
        <div class="col-md-12">
            <h3 class="page-head-line">Historial de Ejecuciones</h3>
            <div id="accordion">
              <h3>Mediciones anteriores</h3>
              <div>
                <table id="dataGrid" style="width: 100%"></table>
                <div id="navGrid"></div>
              </div>
            </div>
            <h1 class="page-subhead-line"></h1>
        </div>
    </div>

    <br/>

    <div class="row">
        <div class="col-md-12">
            <h3 class="page-head-line">Nuevas Mediciones</h3>
            <div class="form-group">
                <table style="width:100%">
                  <tr>
                    <td style="width:10%; padding-left: 40px">
                        <label for="url">URL:</label>
                    </td>
                    <td style="width:90%; padding-right: 10px">
                        <input type="text" class="form-control" id="url"
                            placeholder="Ingrese la url del servidor" autocomplete="on">
                    </td>
                    <td style="width:90%; padding-right: 20px">
                        <input type="submit" value="Ejecutar Test" class="btn btn-primary"
                            onclick="javascript:saveResultadoEjecucion()"/>
                    </td>
                  </tr>
                </table>
            </div>
            <h3 class="page-subhead-line"></h3>
        </div>
    </div>

    <div id="waiting" class="centered" style="display: none">
        <p>Please wait...</p>
    </div>

    <div id="dash"></div>
    <div style="display:none;">
        <input id="serverName" type="text" value="${serverName}">
        <input id="hostAddress" type="text" value="${hostAddress}">
    </div>
</div>

</body>

<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.metisMenu.js"/>"></script>

<script src="<c:url value="/resources/js/lib/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.jqGrid.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/i18n/grid.locale-en.js"/>"></script>

<script src="<c:url value="/resources/js/js-prototype-app.js"/>"></script>
<script src="<c:url value="/resources/js/app/tablaResultados.js"/>"></script> 
<script src="<c:url value="/resources/js/app/resultadoEjecucion.js"/>"></script>

</html>