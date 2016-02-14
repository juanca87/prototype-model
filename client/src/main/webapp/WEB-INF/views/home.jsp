<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
    <h1>Title : ${title}</h1>
    <h1>Message : ${message}</h1>

    <c:url value="/j_spring_security_logout" var="logoutUrl" />

    <!-- csrt for log out-->
    <form action="${logoutUrl}" method="post" id="logoutForm">
      <input type="hidden" 
        name="${_csrf.parameterName}"
        value="${_csrf.token}" />
    </form>

<!--     <form action="/prototype-model-client/dashboard" method="get"> -->
        <input type="submit" value="Ejecutar Test" onclick="javascript:saveResultadoEjecucion()"/>
<!--     </form> -->

    <div id="waiting" class="centered" style="display: none">
        <p>Please wait...</p>
    </div>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>

    <div id="dash"></div>
</body>
    <script src="/prototype-model-client/resources/js/app/resultadoEjecucion.js" type="text/javascript"></script>
    <script src="/prototype-model-client/resources/js/js-prototype-app.js" type="text/javascript" ></script>
    <script src="/prototype-model-client/resources/js/lib/jquery.min.js" type="text/javascript"></script>
    <script src="/prototype-model-client/resources/js/lib/jquery.min.js" type="text/javascript"></script>
</html>