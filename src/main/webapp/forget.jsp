<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ForgetPassword</title>
  <link rel="icon" href="https://www.x-workz.in/Logo.png">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
  body {
    padding-top: 127px;
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
   form h1 {
    font-size: 24px;
    font-weight: bolder;
    margin-bottom: 20px;
    text-align: center;
    color: #db1212;
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
<body class="bg-light">
  <header class="bg-dark text-white py-3 fixed-top" >
    <div class="container-fluid d-flex align-items-center justify-content-between">
      <img src="https://www.x-workz.in/Logo.png" alt="Logo" height="50">
      <h1 class="m-0 text-center flex-grow-1">PET SHOP</h1>
      <a href="loginUser" class="btn btn-warning text-dark">login </a>
      <a href="userRegister" class="btn btn-warning text-dark">User Register</a>
    </div>
  </header>
  <form action="getOtp" method="post">
    <h1>RESET PASSWORD</h1>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label"> Enter the Email </label>
      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" value="${inputEmail}" placeholder="Enter the Email">
    </div>
    <center>
     <button type="submit" class="btn btn-primary">Send OTP</button>
    </center>
    </form>
    <form method="post" action="verifyOtp">
    <div class="mb-3">
      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"name="email" value="${inputEmail}" hidden>
    </div>
    <div class="mb-3">
      <label for="exampleInputPassword1" class="form-label">Enter the OTP</label>
      <input type="number" class="form-control" id="exampleInputPassword1" placeholder="Enter the OTP" name="otp",value="${invalidOtp}">
    </div>
    <center>
     <button type="submit" class="btn btn-primary">Validate OTP</button>
    </center>
  </form >
  <footer class="bg-dark text-white py-2  text-center fixed-bottom" >
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
  </body>
  </html>
