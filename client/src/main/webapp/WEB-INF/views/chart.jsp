<%@ include file="/WEB-INF/views/includes.jsp"%>

<body class="body-custom">

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa fa-pie-chart fa-fw"></i> Gráfico de Atributos Core
            </div>
            <div id="container" class="panel-body">
                    <br/>
                    <canvas id="chart" width="600" height="500"></canvas>
                    <table id="chartData" class="table table-striped table-bordered table-hover">
                        <tr>
                            <th>Atributos</th>
                            <th>Tiempo</th>
                        </tr>
                        <tr style="color: #800080" >
                            <td title="Medición de la Velocidad de la CPU">Velocidad de CPU</td>
                            <td title="Tiempo de respuesta promedio (5 peticiones) al buscar números primos a partir de una semilla">${cpuResult}</td>
                        </tr>
                        <tr style="color: #008080">
                            <td title="Medición de la velocidad de Lectura en Memoria">Lectura en Memoria</td>
                            <td title="Tardó ${lecturaMemoriaResult} segundos en leer de Memoria 5 MB">
                            ${lecturaMemoriaResult}</td>
                        </tr>
                        <tr style="color: #ED5713">
                            <td title="Medición de la velocidad de Escritura en Memoria">Escritura en Memoria</td>
                            <td title="Tardó ${escrituraMemoriaResult} segundos en escribir en Memoria 5 MB">
                            ${escrituraMemoriaResult}</td>
                        </tr>
                        <tr style="color: #004080">
                            <td title="Medición de la velocidad de Lectura en el Disco Duro">Lectura en Disco</td>
                            <td title="Tardó ${lecturaDiscoResult} segundos en leer del Disco Duro 5 MB">
                            ${lecturaDiscoResult}</td>
                        </tr>
                        <tr style="color: #804000">
                            <td title="Medición de la velocidad de Escritura en el Disco Duro">Escritura en Disco</td>
                            <td title="Tardó ${escrituraDiscoResult} segundos en escribir en el Disco Duro 5 MB">
                            ${escrituraDiscoResult}</td>
                        </tr>
                        <tr style="color: #408000">
                            <td title="Medición del tiempo de respuesta del servidor de www.google.com">Latencia</td>
                            <td title="Tiempo de respuesta promedio (5 peticiones) en hacer ping al servidor">${latencyResult}</td>
                        </tr>
                        <tr style="color: #800000">
                            <td title="Medición de la velocidad de descargar">Ancho de Banda</td>
                            <td title="Tardó ${bandwithResult} segundos en descargar 2 MB">
                            ${bandwithResult}</td>
                        </tr>
                        <tr style="color: #4C4C4C">
                            <td title="Medición de Instrucciones por Minuto">Procesamiento</td>
                            <td title="Tardó ${instruccionesMinResult} segundos en procesar fragmentos de código">
                            ${instruccionesMinResult}
                            </td>
                        </tr>
                    </table>
                    <table id="chartDesc" class="table table-striped table-bordered table-hover">
                        <tr>
                            <th>Medida</th>
                        </tr>
                        <tr style="color: #800080" >
                            <td title="Medición de la Velocidad de la CPU">[seg].</td>
                        </tr>
                        <tr style="color: #008080">
                            <td title="Tiempo de respuesta de la velocidad de Lectura en Memoria de 5 MB">
                            5 MB / [seg].</td>
                        </tr>
                        <tr style="color: #ED5713">
                            <td title="Tiempo de respuesta de la velocidad de Escritura en Memoria de 5 MB">
                            5 MB / [seg].</td>
                        </tr>
                        <tr style="color: #004080">
                            <td title="Tiempo de respuesta de la velocidad de Lectura en Disco de 5 MB">
                            5 MB / [seg].</td>
                        </tr>
                        <tr style="color: #804000">
                            <td title="Tiempo de respuesta de la velocidad de Escritura en Disco de 5 MB">
                            5 MB / [seg].</td>
                        </tr>
                        <tr style="color: #408000">
                            <td title="Tardó ${latencyResult} segundos la ejecución de 5 'ping' a www.google.com">
                            [seg].</td>
                        </tr>
                        <tr style="color: #800000">
                            <td title="Tiempo de respuesta de la velocidad de descargar 2 MB">
                            2 MB / [seg].</td>
                        </tr>
                        <tr style="color: #4C4C4C">
                            <td title="Tiempo de respuesta de Procesamiento">
                            [seg]</td>
                        </tr>
                    </table>

                    <ul class="timeline">
                        <li class="timeline-inverted">
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4 class="timeline-title">Descripción:</h4>
                                </div>
                                <div class="timeline-body">
                                    <p>El resultado obtenido representa la cantidad de tiempo que tardó en ejecutar cada atributo. La sumatoria de los resultados es el 100%, la gráfica muestra por cada atributo, el tiempo en segundos y el porcentaje que equivale sobre el total.</p>
                                </div>
                            </div>
                        </li>
                    </ul>
    
                    <div class="wideBox" style="display: none;">
                        <p>&copy; Elated.com | <a href="http://www.elated.com/articles/snazzy-animated-pie-chart-html5-jquery/">Back to Tutorial</a></p>
                        <p style="font-size: .8em"><a rel="license" href="http://creativecommons.org/licenses/by/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by/3.0/88x31.png" /></a><br />This <span xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://purl.org/dc/dcmitype/Text" rel="dc:type">work</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://www.elated.com/" property="cc:attributionName" rel="cc:attributionURL">http://www.elated.com/</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 Unported License</a>.</p>
                    </div>
    
            </div>
        </div>

    </c:if>

<!-- /. FOOTER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<script src="<c:url value="/resources/js/js-snazzy-chart-pie.js"/>"></script>
