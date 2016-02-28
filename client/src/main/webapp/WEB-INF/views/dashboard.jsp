<%@ include file="/WEB-INF/views/includes.jsp"%>

<body class="body-custom">

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <div class="panel panel-default">
            <div class="panel-heading">
                Pie Chart - Atributos Core
            </div>
            <div id="container" class="panel-body">
                <div class="table-responsive">
                    <br/>
                    <canvas id="chart" width="600" height="600"></canvas>
                    <table id="chartData" class="table table-striped table-bordered table-hover">
                        <tr>
                            <th>Atributos</th>
                            <th>Valores</th>
                        </tr>
                        <tr style="color: #800080" >
                            <td>Velocidad de CPU</td>
                            <td>${cpuResult}</td>
                        </tr>
                        <tr style="color: #008080">
                            <td>Tiempo de lectura en Memoria</td>
                            <td>${lecturaMemoriaResult}</td>
                        </tr>
                        <tr style="color: #ED5713">
                            <td>Tiempo de escritura en Memoria</td>
                            <td>${escrituraMemoriaResult}</td>
                        </tr>
                        <tr style="color: #804000">
                            <td>Tiempo de escritura en Disco</td>
                            <td>${escrituraDiscoResult}</td>
                        </tr>
                        <tr style="color: #004080">
                            <td>Tiempo de lectura en Disco</td>
                            <td>${lecturaDiscoResult}</td>
                        </tr>
                        <tr style="color: #408000">
                            <td>Latencia</td>
                            <td>${latencyResult}</td>
                        </tr>
                        <tr style="color: #800000">
                            <td>Ancho de Banda</td>
                            <td>${bandwithResult}</td>
                        </tr>
                        <tr style="color: #4C4C4C">
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

    <div id="footer-sec">
        &copy; 2016 Prototipo | Design By : <a href="http://www.binarytheme.com/" target="_blank">Juan Calvopiña Morillo</a>
    </div>

<!-- /. FOOTER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<script src="<c:url value="/resources/js/js-snazzy-chart-pie.js"/>"></script>
