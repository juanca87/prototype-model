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

    <link rel="stylesheet" media="screen" href="resources/css/ui.jqgrid-bootstarp.css"/>
    <link rel="stylesheet" media="screen" href="resources/css/ui.jqgrid.css"/>
    <link rel="stylesheet" media="screen" href="resources/css/jquery.ui.base.css"/>
    <link rel="stylesheet" media="screen" href="resources/css/jquery-ui.css"/>
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
            <h3 class="page-head-line">Comparación de Resultados</h3>
            <div id="accordion" class="panel panel-default">
                <div class="panel-heading">
                    Tabla Comparativa
                </div>
                <div class="panel-body" align="center" style="border-style:solid; color: #F5F5F5; border-width: 1px;">
                    <table id="comparacionGrid" style="font-family: 'Open Sans', sans-serif;"></table>
                </div>
            </div>

            <div>
                <!-- DONUT CHART -->
                <div class="col-lg-4">
                    <div class="panel panel-default" style="margin-left: -15px; margin-bottom: -83px; height: 512px; border-bottom-right-radius: 0px;">
                        <div class="panel-heading" style="border-top-right-radius: 0px;">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Gráfico por Atributo
                        </div>
                        <br/>
                        <div class="form-group">
                            <label class="col-xs-3 control-label">Atributos</label>
                            <div class="col-xs-8 selectContainer">
                                <select id="combobox" class="form-control">
                                    <option value="0">Seleccione...</option>
                                    <option value="1">CPU</option>
                                    <option value="2">Lectura en Memoria</option>
                                    <option value="3">Escritura en Memoria</option>
                                    <option value="4">Lectura en Disco</option>
                                    <option value="5">Escritura en Disco</option>
                                    <option value="6">Ancho de banda</option>
                                    <option value="7">Latencia</option>
                                    <option value="8">Procesamiento</option>
                                </select>
                            </div>
                        </div>
                        <br/><br/>
                        <div id="morris-donut-chart"></div>
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
                        <br/>
                        <!-- LEYENDA -->
                        <div align="center">
                            <table>
                                <tr>
                                    <td>
                                        <div class="list-group-item" style="margin-left: 400px; width: 150;">
                                            <div id="leyenda-amazon">
                                                <span style="margin-left: 30px">Amazon</span>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="list-group-item" style="margin-left: 10px; width: 150;">
                                            <div id="leyenda-google">
                                                <span style="margin-left: 30px">Google</span>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="list-group-item" style="margin-left: 10px; width: 150;">
                                            <div id="leyenda-heroku">
                                                <span style="margin-left: 30px">Heroku</span>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
        </div>

            <h3 class="page-subhead-line"></h3>

    </div>

    <div style="display:none;">
        <input id="hostAddress" type="text" value="${hostAddress}">
    </div>

</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>

<script src="<c:url value="/resources/js/lib/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.jqGrid.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/i18n/grid.locale-en.js"/>"></script>

<script src="<c:url value="/resources/js/app/morris-bar-data.js"/>"></script>
<script src="<c:url value="/resources/js/app/morris-donut-data.js"/>"></script>
<script src="<c:url value="/resources/js/app/tablaComparativa.js"/>"></script>

</html>