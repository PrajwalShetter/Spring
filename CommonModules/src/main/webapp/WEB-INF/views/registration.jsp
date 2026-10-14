<%@ page isELIgnored="false" %>

    <!DOCTYPE html>
    <html>

    <head>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.1/axios.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet">

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
                box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
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

            <h2>Registration Form</h2>

            <form action="register" method="post" onsubmit="return validateForm()">

                <!-- Name -->
                <div class="field">

                    <label>Name</label>

                    <input type="text" id="name" name="name" onchange="validateName()">

                    <div id="nameError" class="error"></div>

                </div>


                <!-- Phone -->
                <div class="field">

                    <label>Phone</label>

                    <input type="text" id="phone" name="phone" maxlength="10" oninput="validatePhone()"
                        onchange="validateAndCheckPhone()">

                    <div id="phoneError" class="error"></div>

                </div>


                <!-- Email -->
                <div class="field">

                    <label>Email</label>

                    <input type="text" id="email" name="email" onchange="checkEmailIsExist()" oninput="validateEmail()">

                    <div id="emailError" class="error"></div>

                </div>


                <!-- Gender -->
                <div class="field">


                    <label for="gender">Gender</label>

                    <select id="gender" name="gender" onchange="validateGender()">
                        <option value="">-- Select Gender --</option>
                        <option value="MALE">Male</option>
                        <option value="FEMALE">Female</option>
                        <option value="OTHER">Other</option>
                    </select>

                    <div id="genderError" class="error"></div>
                </div>


                <!-- Password -->
                <div class="field">

                    <label>Password</label>

                    <input type="password" id="password" name="password" onchange="validatePassword()">

                    <div id="passwordError" class="error"></div>

                </div>


                <!-- Confirm Password -->
                <div class="field">

                    <label>Confirm Password</label>

                    <input type="password" id="confirmPassword" name="confirmPassword"
                        onchange="validateConfirmPassword()">

                    <div id="confirmPasswordError" class="error"></div>

                </div>

                <button type="submit" class="register-btn" id="RegisterBtn" >
                    Register
                </button>

            </form>

            <div class="field">
                <a href="login">I have already an Account</a>
            </div>

        </div>
        <jsp:include page="common/footer.jsp" />

        <script>

            async function validateAndCheckPhone() {
                if (validatePhone()) {
                    await checkPhoneNumberIsExist();
                }
            }
            async function checkPhoneNumberIsExist() {
                let contactNumber = document.getElementById("phone").value;
                // var response = await fetch("http://localhost:8080/CommonModules/checkContactNumber?phone="+contactNumber);
                // // .then((response)=>console.log(response)).catch((response)=>console.log(response));
                // var data = await response.text();
                // console.log(data);

                var response = await axios("http://localhost:8080/CommonModules/checkContactNumber?phone=" + contactNumber);
                var data = response.data;

                if (data === "The Number is Exist") {
                    document.getElementById("phoneError").innerHTML = data;
                }
                else {
                    document.getElementById("phoneError").innerHTML = "";
                }

            }

            async function checkEmailIsExist() {

                let emailId = document.getElementById("email").value;
                var response = await axios("http://localhost:8080/CommonModules/checkEmail?email=" + emailId);
                var data = response.data;

                if (data === "The Email is Exist") {
                    document.getElementById("emailError").innerHTML = data;
                }
                else {
                    document.getElementById("emailError").innerHTML = "";
                }

            }

            // Get values using DOM

            function validateName() {
                let name = document.getElementById("name").value.trim();

                if (name === "") {
                    document.getElementById("nameError").innerHTML = "Name is required";
                    return false;
                } else if (name.length <= 3) {
                    document.getElementById("nameError").innerHTML =
                        "Name should contain more than 3 characters";
                    return false;
                } else if (!/^[A-Za-z ]+$/.test(name)) {
                    document.getElementById("nameError").innerHTML =
                        "Name should contain only letters";
                    return false;
                } else {
                    document.getElementById("nameError").innerHTML = "";
                    return true;
                }
            }

            function validatePhone() {
                let phone = document.getElementById("phone").value.trim();

                if (phone === "") {
                    document.getElementById("phoneError").innerHTML =
                        "Phone number is required";
                    return false;
                } else if (!/^[6-9][0-9]{9}$/.test(phone)) {
                    document.getElementById("phoneError").innerHTML =
                        "Enter a valid Indian 10 digit mobile number";
                    return false;
                } else {
                    document.getElementById("phoneError").innerHTML = "";
                    return true;
                }
            }

            function validateEmail() {
                let email = document.getElementById("email").value.trim();

                if (email === "") {
                    document.getElementById("emailError").innerHTML =
                        "Email is required";
                    return false;
                } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
                    document.getElementById("emailError").innerHTML =
                        "Enter a valid email address";
                    return false;
                } else {
                    document.getElementById("emailError").innerHTML = "";
                    return true;
                }
            }

            function validateGender() {
                let gender = document.getElementById("gender").value;

                if (gender === "") {
                    document.getElementById("genderError").innerHTML =
                        "Please select your gender";
                    return false;
                } else {
                    document.getElementById("genderError").innerHTML = "";
                    return true;
                }
            }

            function validatePassword() {
                let password = document.getElementById("password").value;

                if (password === "") {
                    document.getElementById("passwordError").innerHTML =
                        "Password is required";
                    return false;
                } else if (password.length < 8) {
                    document.getElementById("passwordError").innerHTML =
                        "Password must contain at least 8 characters";
                    return false;
                } else if (!/[A-Z]/.test(password)) {
                    document.getElementById("passwordError").innerHTML =
                        "Password must contain at least 1 uppercase letter";
                    return false;
                } else if (!/[!@#$%^&*(),.?":{}|<>_\-+=\[\];'`~\\/]/.test(password)) {
                    document.getElementById("passwordError").innerHTML =
                        "Password must contain at least 1 symbol";
                    return false;
                } else {
                    document.getElementById("passwordError").innerHTML = "";
                    return true;
                }
            }

            function validateConfirmPassword() {
                let password = document.getElementById("password").value;
                let confirmPassword = document.getElementById("confirmPassword").value;

                if (confirmPassword === "") {
                    document.getElementById("confirmPasswordError").innerHTML =
                        "Confirm password is required";
                    return false;
                } else if (password !== confirmPassword) {
                    document.getElementById("confirmPasswordError").innerHTML =
                        "Passwords do not match";
                    return false;
                } else {
                    document.getElementById("confirmPasswordError").innerHTML = "";
                    return true;
                }
            }

            function validateForm() {

                let isNameValid = validateName();
                let isPhoneValid = validatePhone();
                let isEmailValid = validateEmail();
                let isGenderValid = validateGender();
                let isPasswordValid = validatePassword();
                let isConfirmPasswordValid = validateConfirmPassword();

               return isNameValid &&
                    isPhoneValid &&
                    isEmailValid &&
                    isGenderValid &&
                    isPasswordValid &&
                    isConfirmPasswordValid;

                    
            }
        </script>
    </body>

    </html>