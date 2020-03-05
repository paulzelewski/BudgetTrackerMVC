<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
<head>

  <%@ include file="/WEB-INF/view/parts/head.jsp" %>

</head>
<body class="d-flex flex-column h-100">
  <!-- Nav Bar -->
  <%@ include file="/WEB-INF/view/parts/header.jsp" %>
  
  <main role="main" class="flex-shrink-0">
    <div class="jumbotron">
      <div class="container">
        <h1 class="display-3">Welcome to Budget Tracker!</h1>
        <p>This web app project allows you to organize your finances and keep track of when, where, and how the money goes.</p>
      </div>
    </div>
    <div class="card container">
      <div class="card-body p-1">
      <div class="row">
        <div class="col-md-4">
          <h2>Budget</h2>
          <p>The budget allows transactions to be grouped into one category. When creating a new budget, you'll need to add a name, start and date, and an amount that should not be exceeded.</p>
        </div>
        <div class="col-md-4">
          <h2>Transaction</h2>
          <p>The transaction is a representation of your income or expanse. When you create a new transaction, you have to assign a date, amount of money, positive for income, negative for expanse, and a short description.</p>
        </div>
        <div class="col-md-4">
          <h2>Technology</h2>
          <p>Utilized:</p>
          <ul>
            <li>Java
            <li>HTML/CSS
            <li>JSP
            <li>JavaScript
            <li>Spring Boot
            <li>Spring MVC
            <li>Spring Data JPA
            <li>Spring Security
            <li>Hibernate ORM            
            <li>MySQL
            <li>Bootstrap
            <li>Font Awesome
          </ul>
        </div>
       </div>
      </div>     
   
    </div>
  </main>

  <!-- Footer & Scripts -->
  <%@ include file="/WEB-INF/view/parts/footer.jsp" %>
</body>
</html>