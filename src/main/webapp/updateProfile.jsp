<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login </title>
  <link rel="icon" href="https://www.x-workz.in/Logo.png">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<style>
  body {
    padding-top: 80px;
    padding-bottom: 40px;
     background-image: url('https://images.squarespace-cdn.com/content/v1/6696db1842323f535605c334/5d7d21fe-e1d7-460e-9d0f-642e2535c843/image_67528961.jpg?format=2500w');
    background-size: cover;
    background-position: center;
  }
  form{
    max-width: 400px;
    padding: 15px;
    margin: auto;
    box-shadow: 0 6px 18px rgba(0, 0, 0, 0.25);
    background: rgb(255, 255, 255, 0.9);
    border-radius: 27px;
    line-height: 50px;
   font-weight: bold;
  }
  .form-signin {
    max-width: 330px;
    padding: 15px;
    margin: auto;
  }
  /* .form-signin .form-floating:focus-within {
    z-index: 2;
  } */

  .form-signin input[type="text"],
  [type="email"],[type="tel"],[type="date"],[type="radio"],[type="number"],[type="password"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
    /* border: 10px solid #ced4da; */
  }
  .form-signin.w-100.m-auto {
    margin: auto;
     max-width: 566px;

    box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
    border-radius: 5px;
    line-height: 50px;

  }
  .form-signin h1 {
    font-size: 24px;
    font-weight:bolder;
    margin-bottom: 20px;
    text-align: center;
    color: #0a0a0a;
  }

  </style>


<body class="bg-light">

      <header class="bg-dark text-white py-3 fixed-top">
        <div class="container-fluid d-flex align-items-center justify-content-between">
          <img src="https://www.x-workz.in/Logo.png" alt="Logo" height="50">
          <h1 class="m-0 text-center flex-grow-1">PET SHOP</h1>
          <a href="index" class="btn btn-warning text-dark">Home</a>
        </div>
      </header>
  <main class="form-signin w-100 m-auto">

   <form action="updateUserProfile" method="post"  enctype="multipart/form-data">

    <img src="getProfile/${dto.fileName}">
     <label>First name</label>
       <span class="text-danger">*</span>
    <input type="number" class="form-control" id="id" name="id" placeholder="id" value="${dto.id}" hidden>
   <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" value="${dto.firstName}" onchange="firstNameValidation()" >
      <span id="firstNameError" class="text-danger"></span>
      <label>Last name</label>
      <span class="text-danger">*</span>
      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name"value="${dto.lastName}" onchange="lastNameValidation()" >
      <span id="lastNameError" class="text-danger"></span>
      <label>Email address</label>
      <span class="text-danger">*</span>
      <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com"value="${dto.email}" onchange="emailValidation()" required>
      <span id="emailError" class="text-danger"></span>
      <label>phone number</label>
      <span class="text-danger">*</span>
      <input type="tel" class="form-control" id="phone" name="phone" placeholder="1234567890"  value="${dto.phone}"onchange="phoneValidation()" required>
      <span id="phoneError" class="text-danger"></span>
      <label>Date of Birth</label>
      <span class="text-danger">*</span>
      <input type="date" class="form-control" id="dob" name="dob" value="${dto.dob}" onchange="dobValidation()"  required>
      <span id="dobError" class="text-danger"></span>

      <label> gender </label>
      <span class="text-danger">*</span>
      <span id="genderError" class="text-danger"></span>
      <input type="text" class="form-check-input" id="genderMale" name="gender"  value="${dto.gender}" onchange="genderValidation()" required> Male

      <span id="dobError" class="text-danger"></span>
      <br>
      <label>Country</label>
      <span class="text-danger">*</span>
      <input type="text" class="form-control" id="country" name="country" placeholder="Country" value="${dto.country}" onchange="countryValidation()" required>
      <span id="countryError" class="text-danger"></span>
      <label>State</label>
      <span class="text-danger">*</span>
      <input type="text" class="form-control" id="state" name="state" placeholder="State" value="${dto.state}" onchange="stateValidation()" required>
      <span id="stateError" class="text-danger"></span>
      <label>City</label>
      <span class="text-danger">*</span>
      <input type="text" class="form-control" id="city" name="city" placeholder="City" value="${dto.city}" onchange="cityValidation()" required>
      <span id="cityError" class="text-danger"></span>
      <label>pincode</label>
      <span class="text-danger">*</span>
      <input type="number" class="form-control" id="pincode" name="pincode" placeholder="Pincode" value="${dto.pincode}" onchange="pincodeValidation()" required>
      <span id="pincodeError" class="text-danger"></span>


      <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="${dto.password}" onchange="passwordValidation()" hidden>
      <span id="passwordError" class="text-danger"></span>
      <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" value="${dto.password}" onchange="confirmPasswordValidation()" hidden>
      <input type="file" name="fileUpload" accept="image/*">
      <span id="confirmPasswordError" class="text-danger"></span>
      <br>
      <button class="w-100 btn btn-lg btn-primary" type="submit" id="Register">Register</button>
    </form>
</main>
  <footer class="bg-dark text-white py-2  text-center fixed-bottom">
    <p class="mb-0">&copy; 2025, All Rights Reserved</p>

    <span id="dateTime" class="position-absolute bottom-0 end-0 me-3 mb-1 fw-bold"></span>
  </footer>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="resources/register.js"></script>
</body>
</html>