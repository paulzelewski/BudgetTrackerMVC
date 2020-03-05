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
  		  <h1>Transactions history</h1>
  		  <a class="btn btn-primary btn-sm" role="button" href="/transaction" ><i class="far fa-plus-square"></i> add transaction</a>
  		  <c:choose>
  		    <c:when test="${noTransactions!=null}">
  		      <p>${noTransactions}</p>
  		    </c:when>
  		    <c:otherwise>
  		      <input class="form-control" id="sortTable" type="text" placeholder="Search.." onclick="sortTable('sortTable','myTable');">
  		      <br>
  		    </c:otherwise>
  		  </c:choose>
  		  
  		  <table class="table" id="myTable">
  		    <c:forEach items="${userTransactions}" var="transaction">
  		     <tr>
  		       <td class="align-middle">${transaction.transactionDate}</td>
  		       <td class="align-middle">${transaction.note}</td>
  		       <td class="align-middle">${transaction.transactionAmount}</td>
  		       <td class="align-middle">${transaction.budget.budgetName}</td>
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
  <script type="text/javascript" src="/js/my-jquery.js"></script>
</body>
</html>