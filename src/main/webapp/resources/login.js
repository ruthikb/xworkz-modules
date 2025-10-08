async function emailValidation() {

      const email = document.getElementById("email").value;
      const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      var button = document.getElementById("Register");

      if (email.includes('@')) {
        const a = await axios("http://localhost:8090/Model-pet-shop/getEmail?email=" + email);
        console.log(a.data);
        if (!regex.test(email)) {
          document.getElementById("emailError").innerText = "Invalid email format";
          button.disabled = true;
        } else if (a.data == "Email is used") {
          document.getElementById("emailError").innerText = "";
          button.disabled = false;
        } else{
         document.getElementById("emailError").innerText = "email doesn't exist";
                  button.disabled = true;
         }
      }
      else {
      console.log("in else");
        const b = await axios("http://localhost:8090/Model-pet-shop/getPhone?phone=" + email);
        console.log(b.data);

        if (email.length != 10){
           document.getElementById("emailError").textContent = "Phone number must be 10 digits.";
          button.disabled = true;
        }
        else if (b.data == "phone is used") {
          document.getElementById("emailError").textContent = "";
          button.disabled = false;
        }
        else{
        document.getElementById("emailError").textContent = "contact no doesn't exist";
                  button.disabled = true;
        }
      }
   }