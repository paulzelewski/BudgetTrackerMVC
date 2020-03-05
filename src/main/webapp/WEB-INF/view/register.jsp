<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html class="h-100">
<head>

  <%@ include file="/WEB-INF/view/parts/head.jsp" %>
  
  <sec:authorize access="isAuthenticated()">
      <% response.sendRedirect("/account"); %>
  </sec:authorize>

</head>
<body class="d-flex flex-column h-100">
  <!-- Nav Bar -->
  <%@ include file="/WEB-INF/view/parts/header.jsp" %>
  
  <main role="main" class="flex-shrink-0">
        <div class="card container">
        <div class="card-body p-1">
    <div class="row justify-content-center">
      <div class="col-md-6 col-md-offset-3">
        <h1>Registration</h1>
        <form:form action="register" modelAttribute="userRegistrationDto" method="post">
          <spring:bind path="userName">
          <div class="form-group">
            <label for="username">Name: </label>
            <form:input id="username" type="text" path="userName" class="form-control ${status.error ? 'is-invalid' : ''}" autofocus="autofocus" placeholder="min 2, max 16" required="required" />
            <form:errors path="userName" cssClass="text-danger" />
            <span id="userName.errors" class="text-danger"></span>
          </div>
          </spring:bind>
          <spring:bind path="userEmail">
          <div class="form-group">
            <label for="email">E-mail: </label>
            <form:input type="email" id="email" path="userEmail" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="E-mail" required="required" />
            <form:errors path="userEmail" cssClass="text-danger" />
            <span id="userEmail.errors" class="text-danger"></span>
          </div>
          </spring:bind>
          <spring:bind path="userConfirmEmail">
          <div class="form-group">
            <label for="emailconfirm">Confirm e-mail: </label>
            <form:input type="email" id="emailconfirm" path="userConfirmEmail" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="E-mail" required="required" />
            <form:errors path="userConfirmEmail" cssClass="text-danger" />
            <span id="userConfirmEmail.errors" class="text-danger"></span>
          </div>
          </spring:bind>
          <spring:bind path="userPassword">
          <div class="form-group">
            <label for="password">Password: </label>
            <form:input type="password" id="password" path="userPassword" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="min 8, max 32" required="required" />
            <form:errors path="userPassword" cssClass="text-danger" />
            <span id="userPassword.errors" class="text-danger"></span>
          </div>
          </spring:bind>
          <spring:bind path="userConfirmPassword">
          <div class="form-group">
            <label for="passconfirm">Confirm password: </label>
            <form:input type="password" id="passconfirm" path="userConfirmPassword" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="min 8, max 32" required="required" />
            <form:errors path="userConfirmPassword" cssClass="text-danger" />
            <span id="userConfirmPassword.errors" class="text-danger"></span>
          </div>
          </spring:bind>
          <spring:bind path="terms">
          <div class="form-group">
            <div class="form-check">
              <form:checkbox class="form-check-input ${status.error ? 'is-invalid' : ''}" id="termscheckbox" path="terms" required="required" />
              <label for="termscheckbox" class="control-label"> I agree with the <a href="#">terms and conditions</a> for Registration.</label>
              <form:errors path="terms" cssClass="text-danger" />
              <p id="terms.errors" class="text-danger"></p>
            </div>
          </div>
          </spring:bind>
          <div class="form-group">
            <input type="submit" class="btn btn-success"  value="Sign on"  />
            <span>Already registered? <a href="/login">Login here</a></span>
          </div>
  		</form:form>    
      </div>        
    </div>
    </div>     
  </div>
  </main>

  <!-- Footer & Scripts -->
  <%@ include file="/WEB-INF/view/parts/footer.jsp" %>
</body>
</html>