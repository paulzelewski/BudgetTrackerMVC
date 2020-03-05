<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html class="h-100">
<head>
  
  <%@ include file="/WEB-INF/view/parts/head.jsp" %>

  <sec:authorize access="!isAuthenticated()">
    <% response.sendRedirect("/login"); %>
  </sec:authorize>
  
</head>
<body class="d-flex flex-column h-100">
  <!-- Nav Bar -->
  <%@ include file="/WEB-INF/view/parts/header.jsp" %>
  
  <main role="main" class="flex-shrink-0">
	<div class="container">
		  <div class="row">
      <div class="card col-md-6 col-md-offset-3">
        <h1>Budget</h1>
        <form:form action="${action}" modelAttribute="budgetDto" method="post">
          <spring:bind path="budgetName">
          <div class="form-group">
            <label for="budgetName">Budget name: </label>
            <form:input type="text" id="budgetName" path="budgetName" class="form-control ${status.error ? 'is-invalid' : ''}" autofocus="autofocus" placeholder="Budget name, min 2, max 32" required="required" />
            <form:errors path="budgetName" cssClass="text-danger" />
            <span id="budgetName.errors" class="text-danger"></span>
          </div>
          </spring:bind>
          <spring:bind path="budgetAmount">
          <div class="form-group">
            <label for="budgetAmount">Budget amount: </label>
            <form:input type="number" id="budgetAmount" path="budgetAmount" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="e.g. 9.99 or 9,99" step="0.01" onclick="select()"  required="required" />
            <form:errors path="budgetAmount" cssClass="text-danger" />
            <span id="budgetAmount.errors" class="text-danger"></span>
          </div>
          </spring:bind>
          <spring:bind path="budgetStartDate">
          <div class="form-group">
            <label for="budgetStartDate">Budget start date: </label>
            <form:input id="budgetStartDate" type="date" path="budgetStartDate" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="YYYY-MM-DD" required="required" />
            <form:errors path="budgetStartDate" cssClass="text-danger" />
            <span id="budgetStartDate.errors" class="text-danger"></span>
          </div>
          </spring:bind>
		  <spring:bind path="budgetEndDate">
          <div class="form-group">
            <label for="budgetEndDate">Budget end date: </label>
            <form:input id="budgetEndDate" type="date" path="budgetEndDate" class="form-control ${status.error ? 'is-invalid' : ''}" autofocus="autofocus" placeholder="YYYY-MM-DD" required="required" />
            <form:errors path="budgetEndDate" cssClass="text-danger" />
            <span id="budgetEndDate.errors" class="text-danger"></span>
          </div>
          </spring:bind>
          
<%--      
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
          </spring:bind> --%>
          <div class="form-group">
            <input type="submit" class="btn btn-success"  value="Save budget"  />            
          </div>
  		</form:form>    
      </div>        
    </div>    
	
	
	</div>
  </main>

  <!-- Footer & Scripts -->
  <%@ include file="/WEB-INF/view/parts/footer.jsp" %>
</body>
</html>