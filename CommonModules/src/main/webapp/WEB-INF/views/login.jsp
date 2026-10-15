<%@ page isELIgnored="false" %>

    <!DOCTYPE html>
    <html>

    <head>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.1/axios.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet">

        <title>Login</title>

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

        <div class="container">

            <h2>Login Form</h2>

            <form action="login" method="post" onsubmit="setDateAndTime()">

                <!-- Phone -->
                <!--    <div class="field">

            <label>Phone</label>

            <input type="text" id="phone" name="phone" onchange="checkPhoneNumberIsExist()" >

            <div id="phoneError" class="error"></div>

        </div> -->


                <!-- Email -->
                <div class="field">

                    <label>Email</label>

                    <input type="text" id="email" name="email" onchange="checkEmailIsExist()">

                    <div id="emailError" class="error"></div>

                </div>

                <!-- Password -->
                <div class="field">

                    <label>Password</label>

                    <input type="password" id="password" name="password" onchange="checkPassword()" >

                    <div id="passwordError" class="error"></div>

                </div>

                <div>
                    <input type="hidden" id="dateAndTime" name="dateAndTime">
                </div>

                <button type="submit" class="register-btn" id="loginBtn" disabled>
                    Login
                </button>

            </form>

            <div class="field">
                <a href="signup">Create an Account</a>
            </div>

            <div class="field">
                            <a href="reset">Reset Password</a>
                        </div>
        </div>
        <jsp:include page="common/footer.jsp" />


        <script>
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
                let loginBtnField = document.getElementById("loginBtn");
                 loginBtnField.disabled=true;

                if (emailId != null) {
                    var response = await axios("http://localhost:8080/CommonModules/checkEmail?email=" + emailId);
                    var data = response.data;

                    if (data === "The Email is Exist") {
                        document.getElementById("emailError").innerHTML = "";
                         loginBtnField.disabled=false;
                    
                    }
                    else {
                        document.getElementById("emailError").innerHTML = "The email not found";
                    }
                }
                else {
                    document.getElementById("emailError").innerHTML = "Email is required";
                }


            }

            async function checkPassword() {

                let emailId = document.getElementById("email").value;
                let password = document.getElementById("password").value;
               

                var response = await axios(
                    "http://localhost:8080/CommonModules/checkPassword?email="
                    + emailId + "&password=" + password
                );

                var data = response.data;
                console.log("Password API response:", data);

                 if(data === "Account_Blocked"){
                    window.location.href="reset";
                    return ;
                 }
                if (data === "Password Matched") {
                    document.getElementById("passwordError").innerHTML = "";
                }
                else {
                    document.getElementById("passwordError").innerHTML = data;
                }
            }

            function setDateAndTime() {
                let now = new Date();

                let formatedDateTime =
                    now.getFullYear() + "-" +
                    String(now.getMonth() + 1).padStart(2, '0') + "-" +
                    String(now.getDate()).padStart(2, '0') + "T" +
                    String(now.getHours()).padStart(2, '0') + ":" +
                    String(now.getMinutes()).padStart(2, '0') + ":" +
                    String(now.getSeconds()).padStart(2, '0');

                document.getElementById("dateAndTime").value = formatedDateTime;

            }

            var success = "${success}";
            var failure = "${failure}";

            if (success) {
                alert(success);
            }

            if (failure) {
                alert(failure);
            }

        </script>

    </body>

    </html>