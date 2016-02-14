<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome!</title>
        
        <link rel="stylesheet" type="text/css" href="resources/css/style-snazzy-chart-pie.css">
        
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/ui.jqgrid-bootstarp.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/ui.jqgrid.css" />
        
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/jquery.ui.base.css"/>
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/jquery-ui.css"/>
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/ui.jqgrid.css"/>
    
        <script src="/example/resources/js/lib/jquery.min.js" type="text/javascript"></script>
        <script src="/example/resources/js/lib/home.js" type="text/javascript"></script> 
        <script src="/example/resources/js/lib/i18n/grid.locale-en.js" type="text/javascript"></script>
        <script src="/example/resources/js/lib/jquery.jqGrid.min.js" type="text/javascript"></script>
        
        <script type="text/javascript" src="/example/resources/js/js-snazzy-chart-pie.js"></script>

    </head>
<body>
    <h1><b>Title:</b> ${title}</h1>
    <h3><b>Message:</b> ${message}</h3>
    
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>

        <table id="datagrid"><tr><td /></tr></table>
        <div id="navGrid"></div>
        <input id="approveMessageBtn" type="button" value="Approve Message" />

<div id="container">

  <div class="wideBox">
    <h1>Custom Snazzy</h1>
  </div>

  <canvas id="chart" width="600" height="500"></canvas>

  <table id="chartData">

    <tr>
      <th>Widget</th><th>Sales ($)</th>
     </tr>

    <tr style="color: #0DA068">
      <td>SuperWidget</td><td>1862.12</td>
    </tr>

    <tr style="color: #194E9C">
      <td>MegaWidget</td><td>1316.00</td>
    </tr>

    <tr style="color: #ED9C13">
      <td>HyperWidget</td><td>712.49</td>
    </tr>

    <tr style="color: #ED5713">
      <td>WonderWidget</td><td>3236.27</td>
    </tr>

    <tr style="color: #057249">
      <td>MicroWidget</td><td>6122.06</td>
    </tr>

    <tr style="color: #5F91DC">
      <td>NanoWidget</td><td>128.11</td>
    </tr>

    <tr style="color: #F88E5D">
      <td>LovelyWidget</td><td>245.55</td>
    </tr>




    <tr style="color: #FFFFFF">
      <td>Demo1</td><td>500</td>
     </tr>

    <tr style="color: #F88E5D">
      <td>Demo2</td><td>100.12</td>
    </tr>

    <tr style="color: #194E9C">
      <td>Demo3</td><td>200.12</td>
    </tr>

    <tr style="color: #ED9C13">
      <td>Demo4</td><td>300.12</td>
    </tr>
  </table>

  <div class="wideBox">
    <p>&copy; Elated.com | <a href="http://www.elated.com/articles/snazzy-animated-pie-chart-html5-jquery/">Back to Tutorial</a></p>
    <p style="font-size: .8em"><a rel="license" href="http://creativecommons.org/licenses/by/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by/3.0/88x31.png" /></a><br />This <span xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://purl.org/dc/dcmitype/Text" rel="dc:type">work</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://www.elated.com/" property="cc:attributionName" rel="cc:attributionURL">http://www.elated.com/</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 Unported License</a>.</p>
  </div>

</div>


        <br/><br/>
        <a href="login">Login</a> |
        <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
    </c:if>
</body>
</html>