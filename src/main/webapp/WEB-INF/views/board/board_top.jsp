<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <title>Shop Homepage - Start Bootstrap Template</title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="../../../resources/assets/favicon.ico"/>
  <!-- Bootstrap icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="../../../resources/css/product/styles.css" rel="stylesheet"/>
  <link href="../../../resources/css/board/style.css" rel="stylesheet"/>
  <!--
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  -->

  <script>
    function check() {
      if (f.title.value==""){
        alert("제목을 입력해주세요.")
        f.title.focus()
        return false
      }
      if (f.content.value==""){
        alert("내용을 입력해주세요.")
        f.content.focus()
        return false
      }
      return true
    }
  </script>
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="/">Rental Car</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
            class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>
        <c:if test="${empty loginMember}">
          <li class="nav-item"><a class="nav-link" href="login.do">로그인</a></li>
        </c:if>
        <c:if test="${not empty loginMember}">
          <li class="nav-item"><a class="nav-link" href="logout.do">로그아웃</a></li>
        </c:if>

        <li class="nav-item"><a class="nav-link" href="board.do">Board</a></li>

        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
             data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#!">All Products</a></li>
            <li>
              <hr class="dropdown-divider"/>
            </li>
            <li><a class="dropdown-item" href="#!">Popular Items</a></li>
            <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
          </ul>
        </li>
      </ul>
      <form class="d-flex">
        <button class="btn btn-outline-dark" type="submit">
          <i class="bi-cart-fill me-1"></i>
          Cart
          <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
        </button>
      </form>

    </div>
  </div>
</nav>
<!-- Header-->
<header class="bg-dark py-5">
  <div class="container px-4 px-lg-5 my-5">
    <div class="text-center text-white">
      <h1 class="display-4 fw-bolder">게시판</h1>
      <p class="lead fw-normal text-white-50 mb-0">With Rental Car Bulletin Board </p>
    </div>
  </div>
</header>
