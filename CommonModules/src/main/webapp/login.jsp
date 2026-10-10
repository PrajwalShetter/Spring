<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>

<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.1/axios.min.js"></script>

    <title>Registration</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
        }

        .container {
            width: 450px;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
        }

        .field {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .gender {
            display: flex;
            gap: 20px;
        }

        .gender label {
            font-weight: normal;
            display: inline;
        }

        .error {
            color: red;
            font-size: 13px;
            margin-top: 5px;
        }

        .register-btn {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 5px;
            background-color: #222;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        .register-btn:hover {
            background-color: #00bcd4;
        }
    </style>

</head>
<body>
<jsp:include page="navbar.jsp" />

${success}
${failure}
<div class="container">

    <h2>Login Form</h2>

    <form action="login" method="post" onsubmit ="setDateAndTime(); return validateForm()">

        <!-- Phone -->
    <!--    <div class="field">

            <label>Phone</label>

            <input type="text" id="phone" name="phone" onchange="checkPhoneNumberIsExist()" >

            <div id="phoneError" class="error"></div>

        </div> -->


        <!-- Email -->
        <div class="field">

            <label>Email</label>

            <input type="text" id="email" name="email" >

            <div id="emailError" class="error"></div>

        </div>

        <!-- Password -->
        <div class="field">

            <label>Password</label>

            <input type="password"
                   id="password"
                   name="password">

            <div id="passwordError" class="error"></div>

        </div>

        <div>
            <input type="hidden" id="dateAndTime" name="dateAndTime">
        </div>

         <button type="submit" class="register-btn">
            Login
        </button>

    </form>

    <div class="field">
        <a href="signup">Create an Account</a>
    </div>
</div>
<jsp:include page="footer.jsp" />


<script>
    async function checkPhoneNumberIsExist(){
        let contactNumber = document.getElementById("phone").value;
        // var response = await fetch("http://localhost:8080/CommonModules/checkContactNumber?phone="+contactNumber);
        // // .then((response)=>console.log(response)).catch((response)=>console.log(response));
        // var data = await response.text();
        // console.log(data);

        var response = await axios("http://localhost:8080/CommonModules/checkContactNumber?phone="+contactNumber);
        var data = response.data;

        if(data === "The Number is Exist"){
            document.getElementById("phoneError").innerHTML= data;
        }
        else{
            document.getElementById("phoneError").innerHTML= "";
        }

    }

    async function checkEmailIsExist(){

        let emailId = document.getElementById("email").value;
        var response = await axios("http://localhost:8080/CommonModules/checkEmail?email="+emailId);
        var data = response.data;

        if(data === "The Email is Exist"){
            document.getElementById("emailError").innerHTML= data;
        }
        else{
            document.getElementById("emailError").innerHTML= "";
        }

    }

   function validateForm() {

       let valid = true;

       // Get values using DOM
       let name = document.getElementById("name").value.trim();
       let phone = document.getElementById("phone").value.trim();
       let email = document.getElementById("email").value.trim();
       let gender = document.getElementById("gender").value;
       let password = document.getElementById("password").value;
       let confirmPassword = document.getElementById("confirmPassword").value;


       // ---------------- NAME ----------------

       if (name === "") {
           document.getElementById("nameError").innerHTML =  "Name is required";
           valid = false;
       } else if (name.length <= 3) {
           document.getElementById("nameError").innerHTML = "Name should contain more than 3 characters";
           valid = false;
       } else if (!/^[A-Za-z ]+$/.test(name)) {
           document.getElementById("nameError").innerHTML = "Name should contain only letters";
           valid = false;
       } else {
           document.getElementById("nameError").innerHTML = "";
       }


       // ---------------- PHONE ----------------

       if (phone === "") {

           document.getElementById("phoneError").innerHTML =
               "Phone number is required";

           valid = false;

       } else if (!/^[6-9][0-9]{9}$/.test(phone)) {

           document.getElementById("phoneError").innerHTML =
               "Enter a valid Indian 10 digit mobile number";

           valid = false;

       } else {

           document.getElementById("phoneError").innerHTML = "";

       }


       // ---------------- EMAIL ----------------

       if (email === "") {

           document.getElementById("emailError").innerHTML =
               "Email is required";

           valid = false;

       } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {

           document.getElementById("emailError").innerHTML =
               "Enter a valid email address";

           valid = false;

       } else {

           document.getElementById("emailError").innerHTML = "";

       }


       // ---------------- GENDER ----------------

       if (gender === "") {

           document.getElementById("genderError").innerHTML =
               "Please select your gender";

           valid = false;

       } else {

           document.getElementById("genderError").innerHTML = "";

       }


       // ---------------- PASSWORD ----------------

       if (password === "") {

           document.getElementById("passwordError").innerHTML =
               "Password is required";

           valid = false;

       } else if (password.length < 8) {

           document.getElementById("passwordError").innerHTML =
               "Password must contain at least 8 characters";

           valid = false;

       } else if (!/[A-Z]/.test(password)) {

           document.getElementById("passwordError").innerHTML =
               "Password must contain at least 1 uppercase letter";

           valid = false;

       } else if (!/[!@#$%^&*(),.?":{}|<>_\-+=/\\[\];'`~]/.test(password)) {

           document.getElementById("passwordError").innerHTML =
               "Password must contain at least 1 symbol";

           valid = false;

       } else {

           document.getElementById("passwordError").innerHTML = "";

       }


       // ---------------- CONFIRM PASSWORD ----------------
       if (confirmPassword === "") {
           document.getElementById("confirmPasswordError").innerHTML =
               "Confirm password is required";
           valid = false;
       } else if (password !== confirmPassword) {
           document.getElementById("confirmPasswordError").innerHTML =
               "Passwords do not match";
           valid = false;
       } else {
           document.getElementById("confirmPasswordError").innerHTML = "";

       }
       return valid;
   }

   function setDateAndTime(){
   let now = new Date();

   let formatedDateTime =
   now.getFullYear()+"-"+
   String(now.getMonth()+1).padStart(2,'0')+"-"+
   String(now.getDay()).padStart(2,'0')+"T"+
   String(now.getHours()).padStart(2,'0')+":"+
   String(now.getMinutes()).padStart(2,'0')+":"+
   String(now.getSeconds()).padStart(2,'0');

   document.getElementById("dateAndTime").value=formatedDateTime;

   }



</script>

</body>
</html>
