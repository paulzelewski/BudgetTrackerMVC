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
      <div class="row">
        <div class="col">
        	<h1>Welcome <sec:authentication property="principal.username"/>!</h1>        	
        	<p>You can create simple transactions that represents your incomes and expanses using add transaction button below or clicking Transactions on the navigation bar above.</p>
            <p>To assign transaction to a budget, create a budget, then navigate to Budgets.</p>
  			
  		</div>
  		<div class="col">
  			<h1>Account balance:</h1>
  			<h1 class="my-3"><sec:authentication property="principal.user.account.accountBalance"/></h1>        	
            
  		</div>
  	  </div>
  	  <div class="row">
  	    <div class="col-auto">
  	    	<h2>Recently created budgets</h2>
  			<a class="btn btn-primary btn-sm" role="button" href="/budget"><i class="far fa-plus-square"></i> create budget</a>
  			<p>${noBudgets}</p>
  			<table class="table">
  			<c:forEach items="${userBudgets}" var="budget">
  		      <tr>
  		       <td>${budget.budgetName}</td>
  		       <td>${budget.budgetAmount}</td>
  		       <td>${budget.budgetStartDate}</td>
  		       <td>${budget.budgetEndDate}</td>
  		       <td>
  		       <form:form method="get" id="bp-${budget.budgetId}" action="/budget/${budget.budgetId}"></form:form>
  		       <button class="btn btn-sm btn-outline-success" type="submit" form="bp-${budget.budgetId}">
  		       <i class="far fa-edit"></i>
  		       </button>
  		       </td>
  		       <td>
  		       <form:form method="delete" id="bd-${budget.budgetId}" action="/budget/${budget.budgetId}"></form:form>
  		       <button class="btn btn-sm btn-outline-danger" type="submit" onclick="return ConfirmDelete()" form="bd-${budget.budgetId}">
  		       <i class="far fa-trash-alt"></i>
  		       </button>
  		       </td>
  		     </tr>
  		    </c:forEach> 
  		    </table> 		    
  		</div>
  		<div class="col-auto">
  		  <h2>Recently created transactions</h2>
  		  <a class="btn btn-primary btn-sm" role="button" href="/transaction" ><i class="far fa-plus-square"></i> add transaction</a>
  		  <p>${noTransactions}</p>
  		  <table class="table">
  		    <c:forEach items="${userTransactions}" var="transaction">
  		     <tr>
  		       <td class="align-middle">${transaction.transactionDate}</td>
  		       <td class="align-middle">${transaction.note}</td>
  		       <td class="align-middle">${transaction.transactionAmount}</td>
  		       <td>
  		       <form:form method="get" id="tp-${transaction.transactionId}" action="/transaction/${transaction.transactionId}"></form:form>
  		       <button class="btn btn-sm btn-outline-success" type="submit" form="tp-${transaction.transactionId}">
  		       <i class="far fa-edit"></i>
  		       </button>
  		       </td>
  		       <td>
  		       <form:form method="delete" id="td-${transaction.transactionId}" action="/transaction/${transaction.transactionId}"></form:form>
  		       <button class="btn btn-sm btn-outline-danger" type="submit" onclick="return ConfirmDelete()" form="td-${transaction.transactionId}">
  		       <i class="far fa-trash-alt"></i>
  		       </button>  		       
  		       </td>
  		     </tr>
  		    </c:forEach>
  		  </table>
        </div>
      </div>
    </div>
  </main>

  <!-- Footer & Scripts -->
  <%@ include file="/WEB-INF/view/parts/footer.jsp" %>
  <script type="text/javascript" src="/js/my-js.js"></script>  
</body>
</html>
