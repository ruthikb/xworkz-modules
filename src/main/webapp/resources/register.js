      function updateDateTime() {
          document.getElementById("dateTime").textContent = new Date().toLocaleString();
        }
        setInterval(updateDateTime, 1000);
        updateDateTime();

        function firstNameValidation() {
          const firstName = document.getElementById("firstName").value;
    console.log(firstName);
          const regex = /^[A-Za-z]+$/;
          var firstNameError= document.getElementById("Register");
          if (!regex.test(firstName) || firstName.length < 2 || firstName.length > 13) {
            document.getElementById("firstNameError").textContent = "First name must be between 2 and 13 characters and contain only letters.";
            firstNameError.disabled=true;
           } else {
            document.getElementById("firstNameError").textContent = "";
            firstNameError.disabled=false;
          }
        }

        function lastNameValidation() {
          const lastName = document.getElementById("lastName").value;
          const regex = /^[A-Za-z]+$/;
          var lastNameError= document.getElementById("Register");
          if (!regex.test(lastName) || lastName.length < 2 || lastName.length > 13) {
            document.getElementById("lastNameError").textContent = "Last name must be between 2 and 13 characters and contain only letters.";
            lastNameError.disabled=true;

          } else {
            document.getElementById("lastNameError").textContent = "";
            lastNameError.disabled=false;
            // return true;
          }
        }
        async function emailValidation() {
          const email = document.getElementById("email").value;
          const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
          var emailError= document.getElementById("Register");
            const a=await axios("http://localhost:8090/Model-pet-shop/getEmail?email="+email);
               console.log(a.data);

          if (!regex.test(email) ) {
            document.getElementById("emailError").textContent = "Invalid email format.";
            emailError.disabled=true;
          } else if(a.data=="Email is used"){
            document.getElementById("emailError").textContent = "Email is exists";
            emailError.disabled=false;
          }
        }

        async function phoneValidation() {
          const phone = document.getElementById("phone").value;
          var phoneError= document.getElementById("Register");
          const b=await axios("http://localhost:8090/Model-pet-shop/getPhone?phone="+phone);
          console.log(b.data);

          if (phone.length!=10)
          {
            document.getElementById("phoneError").textContent = "Phone number must be 10 digits.";
            phoneError.disabled=true;
          }
          else if(b.data=="phone is used"){
            document.getElementById("phoneError").textContent = "phone number exist";
            phoneError.disabled=false;
          }
        }

        function dobValidation() {
          const dob = document.getElementById("dob").value;
          var dobError= document.getElementById("Register");
          if (!dob) {
            document.getElementById("dobError").textContent = "Date of Birth is required.";
          dobError.disabled=true;
          } else {
            document.getElementById("dobError").textContent = "";
            dobError.disabled=false;
          }
        }

        function genderValidation() {
          const gender = document.querySelector('input[name="gender"]:checked');
          var genderError= document.getElementById("Register");
          if (!gender) {
            document.getElementById("genderError").textContent = "Gender is required.";
            genderError.disabled=true;
          } else {
            document.getElementById("genderError").textContent = "";
            genderError.disabled=false;
          }
        }

        function countryValidation() {
          const country = document.getElementById("country").value;
          var countryError= document.getElementById("Register");
          if (!country) {
            document.getElementById("countryError").textContent = "Country is required.";
            countryError.disabled=true;
          } else {
            document.getElementById("countryError").textContent = "";
            countryError.disabled=false;
          }
        }

        function stateValidation() {
          const state = document.getElementById("state").value;
          var stateError= document.getElementById("Register");
          if (!state) {
            document.getElementById("stateError").textContent = "State is required.";
            stateError.disabled=true;
          } else {
            document.getElementById("stateError").textContent = "";
            stateError.disabled=false;
          }
        }

        function cityValidation() {
          const city = document.getElementById("city").value;
          var cityError= document.getElementById("Register");
          if (!city) {
            document.getElementById("cityError").textContent = "City is required.";
            cityError.disabled=true;
          } else {
            document.getElementById("cityError").textContent = "";
            cityError.disabled=false;
          }
        }

        function pincodeValidation() {
          const pincode = document.getElementById("pincode").value;
          var pincodeError= document.getElementById("Register");
          const regex = /^\d{6}$/;
          if (!regex.test(pincode)) {
            document.getElementById("pincodeError").textContent = "Pincode must be 6 digits.";
            pincodeError.disabled=true;
          } else {
            document.getElementById("pincodeError").textContent = "";
            pincodeError.disabled=false;
          }
        }

        function passwordValidation() {
          const password = document.getElementById("password").value;
          var passwordError= document.getElementById("Register");
          if (password.length < 6) {
            document.getElementById("passwordError").textContent = "Password must be at least 6 characters.";
            passwordError.disabled=true;
          } else {
            document.getElementById("passwordError").textContent = "";
            passwordError.disabled=false;
          }
        }

        function confirmPasswordValidation() {
          const password = document.getElementById("password").value;
          var confirmPasswordError= document.getElementById("Register");
          const confirmPassword = document.getElementById("confirmPassword").value;
          if (password !== confirmPassword) {
            document.getElementById("confirmPasswordError").textContent = "Passwords do not match.";
            confirmPasswordError.disabled=true;
          } else {
            document.getElementById("confirmPasswordError").textContent = "";
            confirmPasswordError.disabled=false;
          }
        }