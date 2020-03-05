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
      	    <div class="col-auto">
      	    
  	    	<h2>Budgets</h2>
  			<a class="btn btn-primary btn-sm" role="button" href="/budget"><i class="far fa-plus-square"></i> create budget</a>
  			<c:choose>
  		    <c:when test="${noBudgets!=null}">
  		      <p>${noBudgets}</p>
  		    </c:when>
  		    <c:otherwise>
  		      <input class="form-control" id="sortBudgets" type="text" placeholder="Search.." onclick="sortTable('sortBudgets','budgetsTable');">
  		      <br>
  		    </c:otherwise>
  		    </c:choose>
  			<table class="table" id="budgetsTable">
  			<c:forEach items="${userBudgets}" var="budget">
  		      <tr>
  		       <td><input type="radio" name="budgetId" value="${budget.budgetId}"></td>
  		       <td class="align-middle">${budget.budgetName}</td>
  		       <td class="align-middle">${budget.budgetAmount}</td>
  		       <td class="align-middle">${budget.budgetUsedAmount}</td>
  		       <td class="align-middle">${((budget.budgetUsedAmount < 0 ? -budget.budgetUsedAmount : budget.budgetUsedAmount) / budget.budgetAmount*100)} %</td>
  		       <td class="align-middle">${budget.budgetStartDate}</td>
  		       <td class="align-middle">${budget.budgetEndDate}</td>
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
  		  <h2>Transactions without assigned budget</h2>
  		  <a class="btn btn-primary btn-sm" role="button" href="/transaction" ><i class="far fa-plus-square"></i> add transaction</a>
  		  <button class="btn btn-primary btn-sm" onclick="post('/budgets/assignTransactions','budgetId','transactionIds[]');"><i class="far fa-plus-square"></i> assign to budget</button>
  		  <c:choose>
  		    <c:when test="${noTransactions!=null}">
  		      <p>${noTransactions}</p>
  		    </c:when>
  		    <c:otherwise>
  		      <input class="form-control" id="sortTransactions" type="text" placeholder="Search.." onclick="sortTable('sortTransactions','transactionsTable');">
  		      <br>
  		    </c:otherwise>
  		  </c:choose>
  		  <table class="table" id="transactionsTable">
  		    <c:forEach items="${userTransactions}" var="transaction">
  		     <tr>
  		       <td><input type="checkbox" name="transactionIds[]" value="${transaction.transactionId}"></td>
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
  <script type="text/javascript" src="/js/budgets.js"></script>
  <script type="text/javascript" src="/js/my-jquery.js"></script>
</body>
</html>