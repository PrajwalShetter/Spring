```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Institute Sign Up</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
        }

        .container {
            width: 420px;
            margin: 50px auto;
            padding: 30px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 7px;
            color: #444;
            font-weight: bold;
        }

        input,
        textarea {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        textarea {
            height: 80px;
            resize: none;
        }

        input:focus,
        textarea:focus {
            outline: none;
            border-color: #007bff;
        }

        .license {
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .license input {
            width: auto;
        }

        .signup-btn {
            width: 100%;
            padding: 11px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        .signup-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Institute Sign Up</h2>

    <form action="signup" method="post">

        <div class="form-group">
            <label for="instituteName">Institute Name</label>
            <input type="text"
                   id="instituteName"
                   name="instituteName"
                   placeholder="Enter institute name"
                   required>
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <textarea id="address"
                      name="address"
                      placeholder="Enter institute address"
                      required></textarea>
        </div>

        <div class="form-group">
            <label>Licence Status</label>

            <div class="license">
                <input type="checkbox"
                       id="isLicenced"
                       name="isLicenced"
                       value="true">

                <label for="isLicenced">Institute is licensed</label>
            </div>
        </div>

        <div class="form-group">
            <label for="contactNumber">Contact Number</label>
            <input type="tel"
                   id="contactNumber"
                   name="contactNumber"
                   placeholder="Enter contact number"
                   required>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email"
                   id="email"
                   name="email"
                   placeholder="Enter email address"
                   required>
        </div>

        <button type="submit" class="signup-btn">
            Sign Up
        </button>

    </form>

</div>

</body>
</html>
```
