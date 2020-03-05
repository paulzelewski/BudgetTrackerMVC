<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="card container">
    
    <div class="row justify-content-center">
        <div class="col-auto">
        	<h1>Your personal details</h1>
        	
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-auto">
        	<p>Account creation date:</p>
        	<p>Name:</p>
        	<p>Email:</p>
        </div>
        <div class="col-auto">
        <p><sec:authentication property="principal.user.account.accountCreationDate"/></p>
        <p><sec:authentication property="principal.user.userName"/></p>
        <p><sec:authentication property="principal.user.userEmail"/></p>
        </div>
    </div>
    
    </div>
  </main>

  <!-- Footer & Scripts -->
  <%@ include file="/WEB-INF/view/parts/footer.jsp" %>
  <script type="text/javascript" src="/js/my-js.js"></script>  
</body>
</html>