<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="icon" href="https://www.x-workz.in/Logo.png">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<style>
  body{
    padding-top: 172px;
    padding-bottom: 40px;
    background-image: url('https://images.squarespace-cdn.com/content/v1/6696db1842323f535605c334/5d7d21fe-e1d7-460e-9d0f-642e2535c843/image_67528961.jpg?format=2500w');
    background-size: cover;
    background-position: center;
  }
  form {
    max-width: 330px;
    padding: 15px;
    margin: auto;
    box-shadow: 0 6px 18px rgba(0, 0, 0, 0.25);
    background: rgb(255, 255, 255, 0.9);
    border-radius: 27px;
    line-height: 50px;
   font-weight: bold;
  }

  .form-floating {
    max-width: 330px;
    padding: 8px;
    margin: auto;
  }

  .form-floating input[type="email"],
  [type="password"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
  }

  .form-floating.w-100.m-auto {
    margin: auto;
    max-width: 400px;
    box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
    border-radius: 30px;
    line-height: 50px;
  }

  .form-floating h1 {
    font-size: 24px;
    font-weight: bolder;
    margin-bottom: 20px;
    text-align: center;
    color: #0a0a0a;
  }

  .btn btn-lg btn-primary btn-block {
    width: 100%;
    height: 50px;
    font-size: 18px;
    font-weight: bold;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .checkbox mb-3 {
    margin-top: 20px;
    text-align: center;
  }

  .btn btn-lg btn-primary btn-block {
    width: 100%;
    height: 50px;
    font-size: 18px;
    font-weight: bold;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
</style>
<body>
  <header class="bg-dark text-white py-3 fixed-top">
    <div class="container-fluid d-flex align-items-center justify-content-between">
      <img src="https://www.x-workz.in/Logo.png" alt="Logo" height="50">
      <h1 class="m-0 text-center flex-grow-1">PET SHOP</h1>
      <a href="index" class="btn btn-warning text-dark">Home</a>
    </div>
  </header>
  <form action="loginUser" method="post" class="form-floating w-100 m-auto">
      <h1>Login</h1>
    <div class="form-floating mb-3">
      <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email" value="${email}"
        onchange="emailValidation() ">
      <span id="emailError" class="text-danger"></span>
      <label for="floatingInput">Email address</label>
    </div>
    <div class="form-floating">
    <span>${nullError}</span>
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" >
      <label for="floatingPassword">Password</label>
      <a href="forgetPassword">forgetPassword? change password</a>
    </div>
    <center>
      <div class="checkbox mb-3">
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="Register">Sign in</button>
      </div>
    </center>
  </form>
  <footer class="bg-dark text-white py-2  text-center fixed-bottom">
    <p class="mb-0">&copy; 2025, All Rights Reserved</p>
    <span id="dateTime" class="position-absolute bottom-0 end-0 me-3 mb-1 fw-bold"></span>
  </footer>
  <script>
    function updateDateTime() {
      document.getElementById("dateTime").textContent = new Date().toLocaleString();
    }
    setInterval(updateDateTime, 1000);
    updateDateTime();
  </script>

  <script src="resources/login.js"></script>

</body>

</html>