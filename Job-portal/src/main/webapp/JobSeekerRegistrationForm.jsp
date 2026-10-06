<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Seeker Registration</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 30px;
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
        }

        .container {
            width: 90%;
            max-width: 1100px;
            margin: auto;
            background-color: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.10);
        }

        .header {
            text-align: center;
            margin-bottom: 30px;
        }

        .header h1 {
            margin: 0;
            color: #2c3e50;
        }

        .header p {
            color: #777;
            margin-top: 8px;
        }

        .section {
            margin-top: 28px;
        }

        .section-title {
            color: #2c3e50;
            font-size: 19px;
            font-weight: bold;
            padding-bottom: 8px;
            margin-bottom: 20px;
            border-bottom: 2px solid #e5e5e5;
        }

        .row {
            display: flex;
            gap: 20px;
            margin-bottom: 18px;
        }

        .field {
            flex: 1;
        }

        .field.full {
            width: 100%;
        }

        label {
            display: block;
            margin-bottom: 7px;
            color: #444;
            font-weight: bold;
        }

        input,
        select,
        textarea {
            width: 100%;
            padding: 11px 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            outline: none;
        }

        input:focus,
        select:focus,
        textarea:focus {
            border-color: #3498db;
        }

        textarea {
            height: 90px;
            resize: vertical;
        }

        .gender {
            display: flex;
            align-items: center;
            gap: 25px;
            padding-top: 10px;
        }

        .gender label {
            display: flex;
            align-items: center;
            gap: 6px;
            font-weight: normal;
            margin: 0;
        }

        .gender input {
            width: auto;
        }

        .buttons {
            text-align: center;
            margin-top: 30px;
        }

        button {
            padding: 12px 30px;
            border: none;
            border-radius: 5px;
            font-size: 15px;
            cursor: pointer;
            margin: 0 5px;
        }

        .reset {
            background-color: #95a5a6;
            color: white;
        }

        .reset:hover {
            background-color: #7f8c8d;
        }

        .submit {
            background-color: #3498db;
            color: white;
        }

        .submit:hover {
            background-color: #2980b9;
        }

        @media (max-width: 700px) {
            body {
                padding: 15px;
            }

            .container {
                width: 100%;
                padding: 20px;
            }

            .row {
                flex-direction: column;
                gap: 0;
            }
        }
    </style>
</head>

<body>

<div class="container">

    <div class="header">
        <h1>Job Seeker Registration</h1>
        <p>Create your profile and find your next career opportunity</p>
    </div>

    <form action="registerJobSeeker" method="post" enctype="multipart/form-data">

        <!-- Personal Information -->

        <div class="section">

            <div class="section-title">Personal Information</div>

            <div class="row">

                <div class="field">
                    <label>First Name</label>
                    <input type="text" name="firstName" placeholder="Enter first name" required>
                </div>

                <div class="field">
                    <label>Last Name</label>
                    <input type="text" name="lastName" placeholder="Enter last name" required>
                </div>

                <div class="field">
                    <label>Date of Birth</label>
                    <input type="date" name="dateOfBirth">
                </div>

            </div>

            <div class="row">

                <div class="field">
                    <label>Gender</label>

                    <div class="gender">
                        <label><input type="radio" name="gender" value="MALE"> Male</label>
                        <label><input type="radio" name="gender" value="FEMALE"> Female</label>
                        <label><input type="radio" name="gender" value="OTHER"> Other</label>
                    </div>

                </div>

            </div>

        </div>


        <!-- Contact Information -->

        <div class="section">

            <div class="section-title">Contact Information</div>

            <div class="row">

                <div class="field">
                    <label>Email</label>
                    <input type="email" name="email" placeholder="Enter email" required>
                </div>

                <div class="field">
                    <label>Mobile Number</label>
                    <input type="number" name="mobileNumber" placeholder="Enter mobile number" required>
                </div>

                <div class="field">
                    <label>Alternate Mobile Number</label>
                    <input type="text" name="alternateMobileNumber" placeholder="Enter alternate number">
                </div>

            </div>

            <div class="row">

                <div class="field">
                    <label>City</label>
                    <input type="text" name="city" placeholder="Enter city">
                </div>

                <div class="field">
                    <label>State</label>
                    <input type="text" name="state" placeholder="Enter state">
                </div>

                <div class="field">
                    <label>Country</label>
                    <input type="text" name="country" placeholder="Enter country">
                </div>

                <div class="field">
                    <label>Pincode</label>
                    <input type="text" name="pincode" placeholder="Enter pincode">
                </div>

            </div>

            <div class="row">

                <div class="field full">
                    <label>Address</label>
                    <input type="text" name="address" placeholder="Enter complete address"></input>
                </div>

            </div>

        </div>


        <!-- Education -->

        <div class="section">

            <div class="section-title">Education Details</div>

            <div class="row">

                <div class="field">
                    <label>Highest Qualification</label>

                    <select name="highestQualification">
                        <option value="">Select Qualification</option>
                        <option value="10TH">10th</option>
                        <option value="12TH">12th</option>
                        <option value="DIPLOMA">Diploma</option>
                        <option value="BCA">BCA</option>
                        <option value="BTECH">B.Tech</option>
                        <option value="BE">BE</option>
                        <option value="BSC">B.Sc</option>
                        <option value="MCA">MCA</option>
                        <option value="MTECH">M.Tech</option>
                        <option value="MSC">M.Sc</option>
                        <option value="MBA">MBA</option>
                        <option value="OTHER">Other</option>
                    </select>

                </div>

                <div class="field">
                    <label>Specialization</label>
                    <input type="text" name="specialization" placeholder="Enter specialization">
                </div>

                <div class="field">
                    <label>University</label>
                    <input type="text" name="university" placeholder="Enter university">
                </div>

            </div>

            <div class="row">

                <div class="field">
                    <label>Graduation Year</label>
                    <input type="number" name="graduationYear" placeholder="e.g. 2026">
                </div>

                <div class="field">
                    <label>CGPA</label>
                    <input type="number" name="cgpa" step="0.01" placeholder="e.g. 8.50">
                </div>

            </div>

        </div>


        <!-- Experience -->

        <div class="section">

            <div class="section-title">Experience Details</div>

            <div class="row">

                <div class="field">
                    <label>Experience Level</label>

                    <select name="experienceLevel">
                        <option value="">Select Experience Level</option>
                        <option value="FRESHER">Fresher</option>
                        <option value="ENTRY_LEVEL">Entry Level</option>
                        <option value="MID_LEVEL">Mid Level</option>
                        <option value="SENIOR_LEVEL">Senior Level</option>
                    </select>

                </div>

                <div class="field">
                    <label>Years of Experience</label>
                    <input type="number" name="yearsOfExperience" min="0" placeholder="e.g. 2">
                </div>

                <div class="field">
                    <label>Current Company</label>
                    <input type="text" name="currentCompany" placeholder="Enter company">
                </div>

            </div>

            <div class="row">

                <div class="field">
                    <label>Current Job Title</label>
                    <input type="text" name="currentJobTitle" placeholder="e.g. Software Developer">
                </div>

            </div>

        </div>


        <!-- Skills & Profiles -->

        <div class="section">

            <div class="section-title">Skills & Professional Profiles</div>

            <div class="row">

                <div class="field full">
                    <label>Skills</label>
                    <textarea name="skills" placeholder="e.g. Java, SQL, Spring, HTML, CSS"></textarea>
                </div>

            </div>

            <div class="row">

                <div class="field">
                    <label>LinkedIn Profile</label>
                    <input type="url" name="linkedInProfile" placeholder="LinkedIn profile URL">
                </div>

                <div class="field">
                    <label>GitHub Profile</label>
                    <input type="url" name="githubProfile" placeholder="GitHub profile URL">
                </div>

                <div class="field">
                    <label>Portfolio URL</label>
                    <input type="url" name="portfolioUrl" placeholder="Portfolio URL">
                </div>

                <div class="field">
                    <label>Resume</label>
                    <input type="file" name="resume" accept=".pdf">
                </div>

            </div>

        </div>


        <!-- Job Preferences -->

        <div class="section">

            <div class="section-title">Job Preferences</div>

            <div class="row">

                <div class="field">
                    <label>Preferred Job Role</label>
                    <input type="text" name="preferredJobRole" placeholder="e.g. Java Developer">
                </div>

                <div class="field">
                    <label>Preferred Location</label>
                    <input type="text" name="preferredLocation" placeholder="e.g. Bangalore">
                </div>

                <div class="field">
                    <label>Employment Type</label>

                    <select name="employmentType">
                        <option value="">Select Employment Type</option>
                        <option value="FULL_TIME">Full Time</option>
                        <option value="PART_TIME">Part Time</option>
                        <option value="INTERNSHIP">Internship</option>
                        <option value="CONTRACT">Contract</option>
                        <option value="REMOTE">Remote</option>
                    </select>

                </div>

            </div>

            <div class="row">

                <div class="field">
                    <label>Expected Salary</label>
                    <input type="number" name="expectedSalary" placeholder="Expected annual salary">
                </div>

                <div class="field">
                    <label>Notice Period</label>

                    <select name="noticePeriod">
                        <option value="">Select Notice Period</option>
                        <option value="IMMEDIATE">Immediate</option>
                        <option value="15_DAYS">15 Days</option>
                        <option value="30_DAYS">30 Days</option>
                        <option value="60_DAYS">60 Days</option>
                        <option value="90_DAYS">90 Days</option>
                    </select>

                </div>

            </div>

        </div>


        <!-- Account -->

        <div class="section">

            <div class="section-title">Account Details</div>

            <div class="row">

                <div class="field">
                    <label>Username</label>
                    <input type="text" name="username" placeholder="Create username" required>
                </div>

                <div class="field">
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Create password" required>
                </div>

                <div class="field">
                    <label>Confirm Password</label>
                    <input type="password" name="confirmPassword" placeholder="Confirm password" required>
                </div>

            </div>

        </div>


        <!-- Buttons -->

        <div class="buttons">

            <button type="reset" class="reset">Reset</button>

            <button type="submit" class="submit">Register</button>

        </div>

    </form>

</div>

</body>
</html>