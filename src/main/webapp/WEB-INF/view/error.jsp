<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="h-100">
<head>

  <%@ include file="/WEB-INF/view/parts/head.jsp" %>

</head>
<body class="d-flex flex-column h-100">
  <!-- Nav Bar -->
  <%@ include file="/WEB-INF/view/parts/header.jsp" %>
  
  <main role="main" class="flex-shrink-0 my-auto">
    <div class="card container text-danger">
    <div class="card-body p-1">
      <div class="row justify-content-center">
        <div class="col-auto justify-content-center">
        	<h1>Error..</h1><br>
            <p>Page does not exist or something went wrong, sorry..</p>
        </div>
      </div>
      </div>
    </div>
  </main>

  <!-- Footer & Scripts -->
  <%@ include file="/WEB-INF/view/parts/footer.jsp" %>
</body>
</html>
