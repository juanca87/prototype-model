<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Responsive Bootstrap Advance Admin Template</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="resources/css/bootstrap.css" rel="stylesheet" />
    <link href="resources/css/styles.css" rel="stylesheet" type="text/css">
    <!-- FONTAWESOME STYLES-->
    <link href="resources/css/font-awesome.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>

<body style="background-color: #E2E2E2;" onload='document.loginForm.username.focus();'>

    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <img src="resources/img/logo-invoice.png" />
            </div>
        </div>

        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div id="login-box" class="panel-body">
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>

                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>

                <form name='loginForm'
                    action="<c:url value='j_spring_security_check' />"
                    method='POST' role="form">
                    <hr />
                    <h5>Enter Details to Login</h5>
                       <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-tag"></i>
                        </span>
                        <input type="text" class="form-control" name='username' placeholder="Your Username " />
                    </div>

                    <div class="form-group input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-lock"  ></i>
                        </span>
                        <input type="password" name='password' class="form-control"  placeholder="Your Password" />
                    </div>

                     <input name="submit" class="btn btn-primary" type="submit" value="Login Now"/>
                    <hr />
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>

        </div>

    </div>

</body>
</html>
