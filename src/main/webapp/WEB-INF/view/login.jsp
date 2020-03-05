<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.web.context.request.SessionScope"%>
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
        <h1>Login page</h1>
    	<form action="login" method="post">
    	
    	  <% if(session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null) { %>
    	  <div class="alert alert-danger">
    	    ${SPRING_SECURITY_LAST_EXCEPTION.message}
    	  </div>
    	  <% }
    	  if(request.getParameter("logout") != null) { %>
    	  <div class="alert alert-info">
    	    Log out successful.
    	  </div>
    	  <% }
    	  if(request.getParameter("registered") != null) { %>
    	  <div class="alert alert-info">
    	    Account created successfully! Please log in.
    	  </div>
    	  <% } %>
      	  <div class="form-group">      	
     	    <label for="username">E-mail: </label><input id="username" type="email" name="username" class="form-control" autofocus="autofocus" placeholder="E-mail" required>
      	  </div>
      	  <div class="form-group"> 
      	  <label for="password">Password: </label><input type="password" id="password" name="password" class="form-control" placeholder="Password" required>      
     	  </div>
     	  <div class="form-group">
     	    <div class="row">
       		  <div class="col-sm-6 col-sm-offset-3">
      	  		<input type="submit" name="login-submit" id="login-submit" class="form-control btn btn-primary" value="Log in">
      	  	  </div>
      	  	</div>
      	  </div>
      	  <div class="form-group">
            <span>New user? <a href="/register">Register here</a></span>
       	  </div>
    </form>
    </div>
    </div>
    </div>
  </div>
  </main>

  <!-- Footer & Scripts -->
  <%@ include file="/WEB-INF/view/parts/footer.jsp" %>
</body>
</html>