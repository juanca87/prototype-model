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
    <link rel="stylesheet" href="resources/css/timeline.css">
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
                            <li id="amazonEC2" class="active"><a href="${contextUrl}amazon">Amazon EC2</a></li>
                            <li id="googleAppEngine"><a href="${contextUrl}google">Google Cloud Engine</a></li>
                            <li id="heroku"><a href="${contextUrl}heroku">Heroku</a></li>
                            <li id="comparacion"><a href="${contextUrl}comparacion">Comparación</a></li>
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
                <div id="accordion" class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-table fa-fw"></i> Mediciones anteriores
                    </div>
                    <div class="panel-body" style="border-style:solid; color: #F5F5F5; border-width: 1px;">
                        <table>
                            <tr>
                                <td>
                                    <table id="dataGrid" style="font-family: 'Open Sans', sans-serif;"></table>
                                    <div id="navGrid"></div>
                                </td>
                                <td style="width: 2.5%;">
                                    <br/>
                                </td>
                                <td>
                                    <div class="table-bordered">
                                        <table class="table" style="font-size: small;">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Abreviación</th>
                                                    <th>Descripcion</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>CPU</td>
                                                    <td>CPU</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>LM</td>
                                                    <td>Lectura en Memoria</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>EM</td>
                                                    <td>Escritura en Memoria</td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>LD</td>
                                                    <td>Lesctura en Disco</td>
                                                </tr>
                                                <tr>
                                                    <td>5</td>
                                                    <td>ED</td>
                                                    <td>Escritura en Disco</td>
                                                </tr>
                                                <tr>
                                                    <td>6</td>
                                                    <td>AB</td>
                                                    <td>Ancho de Banda</td>
                                                </tr>
                                                <tr>
                                                    <td>7</td>
                                                    <td>L</td>
                                                    <td>Latencia</td>
                                                </tr>
                                                <tr>
                                                    <td>8</td>
                                                    <td>P</td>
                                                    <td>Procesamiento</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            <h3 class="page-subhead-line"></h3>
        </div>
    </div>

    <br/>

    <div class="row">
        <div class="col-md-12">
            <h3 class="page-head-line">Características del Servidor</h3>
                <div class="form-group">
                    <table style="width:100%">
                      <tr>
                        <td style="width:10%; padding-left: 40px">
                            <label for="url">URL:</label>
                        </td>
                        <td style="width:90%; padding-right: 10px">
                            <input type="text" class="form-control" id="urlCaracteristicas" autofocus
                                placeholder="Ingrese la url del servidor" autocomplete="on">
                        </td>
                        <td style="width:90%; padding-right: 20px">
                            <input type="submit" value="Recuperar" class="btn btn-primary"
                                onclick="javascript:recuperarCaracteristicas()"/>
                        </td>
                      </tr>
                    </table>
                </div>
                <div id="caracteristica" class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-info-circle fa-fw"></i> Info - Amazon EC2 [IaaS - Infrastructure as a Service]
                        <div class="pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                    Acciones
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu">
                                    <li><a href="javascript:mostrarInfo();">Mostrar</a></li>
                                    <li><a href="javascript:ocultarInfo();">Ocultar</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div id="valCaracteristica" class="panel-body" align="center"
                        style="border-style:solid; color: #F5F5F5; border-width: 1px;">
                        <table>
                            <tr>
                                <td>
                                    <div class="table-bordered" align="center">
                                        <label style="font-size: small;">Características Reales</label>
                                        <table class="table" style="font-size: small;">
                                            <thead>
                                                <tr class="active">
                                                    <th>#</th>
                                                    <th width="150px;">Atributo</th>
                                                    <th width="200px;">Valor</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Sistema Operativo</td>
                                                    <td><span id="soVal"></span></td>
                                                </tr>
                                                <tr class="active">
                                                    <td>2</td>
                                                    <td>Arquitectura</td>
                                                    <td><span id="aVal"></span></td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Version</td>
                                                    <td><span id="vVal"></span></td>
                                                </tr>
                                                <tr class="active">
                                                    <td>4</td>
                                                    <td>CPU</td>
                                                    <td><span id="cpuVal"></span></td>
                                                </tr>
                                                <tr>
                                                    <td>5</td>
                                                    <td>Capacidad en Disco</td>
                                                    <td><span id="tdVal"></span></td>
                                                </tr>
                                                <tr class="active">
                                                    <td>6</td>
                                                    <td>Capacidad en RAM</td>
                                                    <td><span id="trVal"></span></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                                <td>
                                    <div class="table-bordered" align="center">
                                        <label style="font-size: small;">Características Ofrecidas</label>
                                        <table class="table" style="font-size: small;">
                                            <thead>
                                                <tr class="active">
                                                    <th>#</th>
                                                    <th width="150px;">Atributo</th>
                                                    <th width="200px;">Valor</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Sistema Operativo</td>
                                                    <td>Linux</td>
                                                </tr>
                                                <tr class="active">
                                                    <td>2</td>
                                                    <td>Arquitectura</td>
                                                    <td>amd64</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Version</td>
                                                    <td>4.1.17-22.30.amzn1.x86_64</td>
                                                </tr>
                                                <tr class="active">
                                                    <td>4</td>
                                                    <td>CPU</td>
                                                    <td>1</td>
                                                </tr>
                                                <tr>
                                                    <td>5</td>
                                                    <td>Capacidad en Disco</td>
                                                    <td>8 GB</td>
                                                </tr>
                                                <tr class="active">
                                                    <td>6</td>
                                                    <td>Capacidad en RAM</td>
                                                    <td>1 GB</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            <h3 class="page-subhead-line"></h3>
        </div>
    </div>

    <br/>

    <div class="row">
        <div class="col-md-12">
            <h3 class="page-head-line">Obtener Nueva Medición</h3>
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
                        <input type="submit" value="Ejecutar" class="btn btn-primary"
                            onclick="javascript:saveResultadoEjecucion()"/>
                    </td>
                  </tr>
                </table>
            </div>
            <h3 class="page-subhead-line"></h3>
        </div>
    </div>

    <div style="display:none;">
        <input id="serverName" type="text" value="${serverName}">
        <input id="hostAddress" type="text" value="${hostAddress}">
    </div>

    <div id="waiting" class="centered" style="display: none">
        <p>Please wait...</p>
    </div>

    <div id="pieChart"></div>

</div>

<div id="footer-sec">
    &copy; 2016 Prototipo | Design By : <a href="mailto:juan.calvopina@gmail.com?Subject=Prototype-Model-Project" target="_top" target="_blank">Juan Calvopiña Morillo</a>
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
<script src="<c:url value="/resources/js/app/recuperarCaracteristicas.js"/>"></script>

</html>