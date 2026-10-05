<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>Applicant Details</title>

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
            margin-bottom: 18px;
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

        .label {
            font-size: 13px;
            color: #777;
            margin-bottom: 5px;
        }

        .value {
            font-size: 15px;
            color: #333;
            min-height: 20px;
            word-break: break-word;
        }

        .address {
            line-height: 1.5;
        }

        .actions {
            text-align: center;
            margin-top: 35px;
            padding-top: 25px;
            border-top: 1px solid #eeeeee;
        }

        .btn {
            display: inline-block;
            padding: 11px 25px;
            margin: 0 5px;
            border-radius: 5px;
            text-decoration: none;
            color: white;
            font-size: 14px;
        }

        .edit {
            background-color: #3498db;
        }

        .edit:hover {
            background-color: #2980b9;
        }

        .delete {
            background-color: #e74c3c;
        }

        .delete:hover {
            background-color: #c0392b;
        }

        .back {
            background-color: #7f8c8d;
        }

        .back:hover {
            background-color: #636e72;
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
                gap: 12px;
            }

        }

    </style>

</head>

<body>

<div class="container">

    <div class="header">

        <h1>Applicant Details</h1>

        <p>Complete applicant information</p>

    </div>


    <!-- Personal Information -->

    <div class="section">

        <div class="section-title">Personal Information</div>

        <div class="row">

            <div class="field">
                <div class="label">Applicant ID</div>
                <div class="value">${applicant.id}</div>
            </div>

            <div class="field">
                <div class="label">First Name</div>
                <div class="value">${applicant.firstName}</div>
            </div>

            <div class="field">
                <div class="label">Last Name</div>
                <div class="value">${applicant.lastName}</div>
            </div>

        </div>

        <div class="row">

            <div class="field">
                <div class="label">Date of Birth</div>
                <div class="value">${applicant.dateOfBirth}</div>
            </div>

            <div class="field">
                <div class="label">Gender</div>
                <div class="value">${applicant.gender}</div>
            </div>

        </div>

    </div>


    <!-- Contact Information -->

    <div class="section">

        <div class="section-title">Contact Information</div>

        <div class="row">

            <div class="field">
                <div class="label">Email</div>
                <div class="value">${applicant.email}</div>
            </div>

            <div class="field">
                <div class="label">Mobile Number</div>
                <div class="value">${applicant.mobileNumber}</div>
            </div>

            <div class="field">
                <div class="label">Alternate Mobile Number</div>
                <div class="value">${applicant.alternateMobileNumber}</div>
            </div>

        </div>

        <div class="row">

            <div class="field">
                <div class="label">City</div>
                <div class="value">${applicant.city}</div>
            </div>

            <div class="field">
                <div class="label">State</div>
                <div class="value">${applicant.state}</div>
            </div>

            <div class="field">
                <div class="label">Country</div>
                <div class="value">${applicant.country}</div>
            </div>

            <div class="field">
                <div class="label">Pincode</div>
                <div class="value">${applicant.pincode}</div>
            </div>

        </div>

        <div class="row">

            <div class="field">
                <div class="label">Address</div>
                <div class="value address">${applicant.address}</div>
            </div>

        </div>

    </div>


    <!-- Education -->

    <div class="section">

        <div class="section-title">Education Details</div>

        <div class="row">

            <div class="field">
                <div class="label">Highest Qualification</div>
                <div class="value">${applicant.highestQualification}</div>
            </div>

            <div class="field">
                <div class="label">Specialization</div>
                <div class="value">${applicant.specialization}</div>
            </div>

            <div class="field">
                <div class="label">University</div>
                <div class="value">${applicant.university}</div>
            </div>

        </div>

        <div class="row">

            <div class="field">
                <div class="label">Graduation Year</div>
                <div class="value">${applicant.graduationYear}</div>
            </div>

            <div class="field">
                <div class="label">CGPA</div>
                <div class="value">${applicant.cgpa}</div>
            </div>

        </div>

    </div>


    <!-- Experience -->

    <div class="section">

        <div class="section-title">Experience Details</div>

        <div class="row">

            <div class="field">
                <div class="label">Experience Level</div>
                <div class="value">${applicant.experienceLevel}</div>
            </div>

            <div class="field">
                <div class="label">Years of Experience</div>
                <div class="value">${applicant.yearsOfExperience}</div>
            </div>

            <div class="field">
                <div class="label">Current Company</div>
                <div class="value">${applicant.currentCompany}</div>
            </div>

        </div>

        <div class="row">

            <div class="field">
                <div class="label">Current Job Title</div>
                <div class="value">${applicant.currentJobTitle}</div>
            </div>

        </div>

    </div>


    <!-- Skills & Profiles -->

    <div class="section">

        <div class="section-title">Skills & Professional Profiles</div>

        <div class="row">

            <div class="field">
                <div class="label">Skills</div>
                <div class="value">${applicant.skills}</div>
            </div>

        </div>

        <div class="row">

            <div class="field">
                <div class="label">LinkedIn Profile</div>
                <div class="value">${applicant.linkedInProfile}</div>
            </div>

            <div class="field">
                <div class="label">GitHub Profile</div>
                <div class="value">${applicant.githubProfile}</div>
            </div>

            <div class="field">
                <div class="label">Portfolio URL</div>
                <div class="value">${applicant.portfolioUrl}</div>
            </div>

        </div>

    </div>


    <!-- Job Preferences -->

    <div class="section">

        <div class="section-title">Job Preferences</div>

        <div class="row">

            <div class="field">
                <div class="label">Preferred Job Role</div>
                <div class="value">${applicant.preferredJobRole}</div>
            </div>

            <div class="field">
                <div class="label">Preferred Location</div>
                <div class="value">${applicant.preferredLocation}</div>
            </div>

            <div class="field">
                <div class="label">Employment Type</div>
                <div class="value">${applicant.employmentType}</div>
            </div>

        </div>

        <div class="row">

            <div class="field">
                <div class="label">Expected Salary</div>
                <div class="value">${applicant.expectedSalary}</div>
            </div>

            <div class="field">
                <div class="label">Notice Period</div>
                <div class="value">${applicant.noticePeriod}</div>
            </div>

        </div>

    </div>


    <!-- Account -->

    <div class="section">

        <div class="section-title">Account Details</div>

        <div class="row">

            <div class="field">
                <div class="label">Username</div>
                <div class="value">${applicant.username}</div>
            </div>

            <div class="field">
                <div class="label">Password</div>
                <div class="value">********</div>
            </div>

            <div class="field">
                <div class="label">Confirm Password</div>
                <div class="value">********</div>
            </div>

        </div>

    </div>


    <!-- Actions -->

    <div class="actions">

        <a href="editApplicant?id=${applicant.id}" class="btn edit">
            Edit
        </a>

        <a href="deleteApplicant?id=${applicant.id}" class="btn delete">
            Delete
        </a>

        <a href="viewAllApplicants" class="btn back">
            Back
        </a>

    </div>

</div>

</body>
</html>