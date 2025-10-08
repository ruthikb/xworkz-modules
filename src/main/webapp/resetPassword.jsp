<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login </title>
  <link rel="icon" href="https://www.x-workz.in/Logo.png">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style> 
body{
    background-color: #f8f9fa;
    font-family: Arial, sans-serif;
    padding-top: 50px;
}
    form {
        max-width: 400px;
        margin: 100px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    .btn.btn-lg.btn-primary.btn-block{
        text-align: center;
        margin-top: 20px;
    }

</style>


<body class="bg-light">

  <header class="bg-dark text-white py-3 fixed-top" >
    <div class="container-fluid d-flex align-items-center justify-content-between">
      <img src="https://www.x-workz.in/Logo.png" alt="Logo" height="50">
      <h1 class="m-0 text-center flex-grow-1">PET SHOP</h1>
      <a href="loginUser" class="btn btn-warning text-dark">login </a>
      
    </div>
  </header>
  <form action ="resetPassword" method="post">
    <h1 class="h3 mb-3 font-weight-normal">Reset Password</h1>
  <input class="form-control form-control-lg" type="email" name="email" placeholder="Enter email" aria-label=".form-control-lg example" value="${email}">
    <br>
    <label for="inputPassword" class="sr-only">New Password</label>
<input class="form-control" type="password" name="newPassword" placeholder="Enter new password" aria-label="default input example" required>
    <br>
<label for="inputPassword" class="sr-only">Re-enter Password</label>
<input class="form-control form-control-sm" type="password" name="confirmPassword" placeholder="Re-enter new password" aria-label=".form-control-sm example" required>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Reset Password</button>
    
</form>
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
