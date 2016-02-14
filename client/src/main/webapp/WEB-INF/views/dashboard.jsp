<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome!</title>

        <!-- BOOTSTRAP STYLES-->
        <link href="resources/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="resources/css/font-awesome.css" rel="stylesheet" />
        <!--CUSTOM BASIC STYLES-->
        <link href="resources/css/basic.css" rel="stylesheet" />
        <!--CUSTOM MAIN STYLES-->
        <link href="resources/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- JQGRID STYLES-->
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/ui.jqgrid-bootstarp.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/ui.jqgrid.css" />
        <!-- JQUERY STYLES-->
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/jquery.ui.base.css"/>
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/jquery-ui.css"/>
        <!-- PIE CHART STYLES-->
        <link rel="stylesheet" type="text/css" href="resources/css/style-snazzy-chart-pie.css">
    </head>
<body>

    <c:url value="/j_spring_security_logout" var="logoutUrl" />

    <!-- csrt for log out-->
    <form action="${logoutUrl}" method="post" id="logoutForm">
      <input type="hidden" 
        name="${_csrf.parameterName}"
        value="${_csrf.token}" />
    </form>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>

    <div class="wideBox">
        <h1>Custom Snazzy</h1>
    </div>

    <h1><b>Title:</b> ${title}</h1>
    <h3><b>Message:</b> ${message}</h3>
    
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>

        <table id="datagrid"><tr><td /></tr></table>
        <div id="navGrid">99</div>

        <br/>

        <div class="panel panel-default" style="min-width: 865px">
            <div class="panel-heading">
                Pie Chart - Atributos Core
            </div>
            <div id="container" class="panel-body">
                <div class="table-responsive">
                    <br/>
                    <canvas id="chart" width="600" height="500"></canvas>
                    <table id="chartData" class="table table-striped table-bordered table-hover">
                        <tr>
                            <th>Atributos</th>
                            <th>Valores</th>
                        </tr>
                        <tr style="color: #C71585" >
                            <td>Velocidad de CPU</td>
                            <td>${cpuResult}</td>
                        </tr>
                        <tr style="color: #ED9C13">
                            <td>Tiempo de lectura en Memoria</td>
                            <td>${lecturaMemoriaResult}</td>
                        </tr>
                        <tr style="color: #ED5713">
                            <td>Tiempo de escritura en Memoria</td>
                            <td>${escrituraMemoriaResult}</td>
                        </tr>
                        <tr style="color: #057249">
                            <td>Tiempo de lectura en Disco</td>
                            <td>${lecturaDiscoResult}</td>
                        </tr>
                        <tr style="color: #00FFFF">
                            <td>Tiempo de escritura en Disco</td>
                            <td>${escrituraDiscoResult}</td>
                        </tr>
                        <tr style="color: #FFDEAD">
                            <td>Ancho de Banda</td>
                            <td>${bandwithResult}</td>
                        </tr>
                        <tr style="color: #ADFF2F">
                            <td>Latencia</td>
                            <td>${latencyResult}</td>
                        </tr>
                        <tr style="color: #194E9C">
                            <td>Instrucciones por minuto</td>
                            <td>${instruccionesMinResult}</td>
                        </tr>
                    </table>
                </div>
    
                <div class="wideBox" style="display: none;">
                    <p>&copy; Elated.com | <a href="http://www.elated.com/articles/snazzy-animated-pie-chart-html5-jquery/">Back to Tutorial</a></p>
                    <p style="font-size: .8em"><a rel="license" href="http://creativecommons.org/licenses/by/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by/3.0/88x31.png" /></a><br />This <span xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://purl.org/dc/dcmitype/Text" rel="dc:type">work</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://www.elated.com/" property="cc:attributionName" rel="cc:attributionURL">http://www.elated.com/</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 Unported License</a>.</p>
                </div>
    
            </div>
        </div>

    </c:if>

    <input type="button" value="Get and parse JSON" class="btn btn-primary" onclick="javascript:ver()"/>
    <span id="results">
    
    </span>


    <div id="footer-sec">
        &copy; 2016 Prototipo | Design By : <a href="http://www.binarytheme.com/" target="_blank">Juan Calvopiña Morillo</a>
    </div>
    <!-- /. FOOTER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="resources/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="resources/js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="resources/js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="resources/js/custom.js"></script>
    <!-- jQuery & jQGrid -->
    <script src="/prototype-model-client/resources/js/lib/jquery.min.js" type="text/javascript"></script>
    <script src="/prototype-model-client/resources/js/lib/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script src="/prototype-model-client/resources/js/lib/i18n/grid.locale-en.js" type="text/javascript"></script>

    <script src="/prototype-model-client/resources/js/app/home.js" type="text/javascript"></script> 
    <script src="/prototype-model-client/resources/js/js-snazzy-chart-pie.js" type="text/javascript"></script>
    <script src="/prototype-model-client/resources/js/js-prototype-app.js" type="text/javascript"></script>

</body>
</html>