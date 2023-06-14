<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
</head>
<body>
<form:form modelAttribute="user"
           action="${pageContext.request.contextPath}/login" method="POST">


    <div>
        <h1>Đăng nhập</h1>
    </div>
    <div class="form-outline mb-4">
        <label class="form-label">Users name</label>
        <form:input type="text"
                   class="form-control form-control-lg" path="ten"/>
        <form:errors path="ten" class="error"></form:errors>
    </div>

    <!-- Password input -->
    <div class="form-outline mb-4">
        <label class="form-label">Password</label>
        <form:input type="password"
                   class="form-control form-control-lg" path="pass"/>
        <form:errors path="pass" class="error"></form:errors>
    </div>
    <div class="form-outline mb-4"
         style="font-size: 15px; color: red"><p>${logic==1?"Username or password incorrect":""}</p>
    </div>

    <!-- Checkbox -->
<%--    <div class="form-check d-flex justify-content-center mb-4">--%>
<%--        <form:checkbox path="rememberMe" cssClass="form-check-input me-2" id="form2Example33"/>--%>
<%--        <label class="form-check-label" for="form2Example33">--%>
<%--            Remember me--%>
<%--        </label>--%>

<%--    </div>--%>
    <a href="/forgot-password">
        <div class="text-center">
            <label>
                <p>Forgot password ?</p>
            </label>
        </div>
    </a>

    <!-- Submit button -->
    <div class="indent">
        <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
        <a href="/register">
            <button type="button" class="btn btn-primary btn-lg">Sign in</button>
        </a>
        <a href="/index">
            <button type="button" class="btn btn-light">EXIT</button>
        </a>
    </div>
</form:form>
</body>
</html>