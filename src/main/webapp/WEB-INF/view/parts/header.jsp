
<header class="mb-auto">
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
<div class="container">
  <a href="/" class="navbar-brand">
    <i class="fas fa-money-bill-wave">Budget Tracker</i>
  </a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarCollapse">
   <div class="navbar-nav">
     <a href="/" class="nav-item nav-link ${activateHome}">Home</a>
     <sec:authorize access="isAuthenticated()">
      <a href="/account" class="nav-item nav-link ${activateAccount}">Account</a>
      <a href="/budgets" class="nav-item nav-link ${activateBudgets}">Budgets</a>
      <a href="/transactions" class="nav-item nav-link ${activateTransactions}">Transactions</a>
    </sec:authorize>
   </div>
   <div class="navbar-nav ml-auto">
     <sec:authorize access="!isAuthenticated()">
       <a href="/login" class="nav-item nav-link ${activateLogin}">Log in <i class="fas fa-sign-in-alt"></i></a>
       <a href="/register" class="nav-item nav-link ${activateSignon}">Sign on <i class="fas fa-user-plus"></i></a>
     </sec:authorize>
     <sec:authorize access="isAuthenticated()">
       <a href="/personal" class="nav-item nav-link ${activatePersonal}">Personal <i class="far fa-user"></i> </a>
       <form action="/logout">
         <input type="submit" class="btn btn-secondary" value="Log out">
       </form>
     </sec:authorize>
   </div>
  </div>
</div>
</nav>
</header>