<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>All Applicants</title>

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
            width: 95%;
            max-width: 1400px;
            margin: auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.10);
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 25px;
        }

        .header h1 {
            margin: 0;
            color: #2c3e50;
        }

        .header p {
            margin: 6px 0 0;
            color: #777;
        }

        .register-btn {
            padding: 11px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .register-btn:hover {
            background-color: #2980b9;
        }

        .table-container {
            width: 100%;
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            min-width: 1100px;
        }

        th {
            background-color: #2c3e50;
            color: white;
            padding: 13px;
            text-align: left;
            white-space: nowrap;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #eeeeee;
            color: #444;
            white-space: nowrap;
        }

        tr:hover {
            background-color: #f8f9fa;
        }

        .view-btn {
            display: inline-block;
            padding: 7px 14px;
            background-color: #27ae60;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 13px;
        }

        .view-btn:hover {
            background-color: #219150;
        }

        .no-data {
            text-align: center;
            padding: 40px;
            color: #777;
            font-size: 17px;
        }

        .count {
            margin-bottom: 15px;
            color: #555;
        }

    </style>

</head>

<body>

<div class="container">

    <div class="header">

        <div>
            <h1>All Applicants</h1>
            <p>Registered job seekers</p>
        </div>

        <a href="JobSeekerRegistrationForm.jsp" class="register-btn">
            Add Applicant
        </a>

    </div>


    <div class="count">
        Total Applicants:
        <strong>${applicants.size()}</strong>
    </div>


    <c:choose>

        <c:when test="${not empty applicants}">

            <div class="table-container">

                <table>

                    <thead>

                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>Qualification</th>
                        <th>University</th>
                        <th>Experience</th>
                        <th>Job Role</th>
                        <th>Location</th>
                        <th>Employment Type</th>
                        <th>Action</th>
                    </tr>

                    </thead>

                    <tbody>

                    <c:forEach var="applicant" items="${applicants}">

                        <tr>

                            <td>${applicant.id}</td>

                            <td>${applicant.firstName}</td>

                            <td>${applicant.lastName}</td>

                            <td>${applicant.email}</td>

                            <td>${applicant.mobileNumber}</td>

                            <td>${applicant.highestQualification}</td>

                            <td>${applicant.university}</td>

                            <td>${applicant.yearsOfExperience} years</td>

                            <td>${applicant.preferredJobRole}</td>

                            <td>${applicant.preferredLocation}</td>

                            <td>${applicant.employmentType}</td>

                            <td>
                                <a href="viewApplicant?id=${applicant.id}" class="view-btn">
                                    View
                                </a>
                            </td>

                        </tr>

                    </c:forEach>

                    </tbody>

                </table>

            </div>

        </c:when>


        <c:otherwise>

            <div class="no-data">
                No applicants found.
            </div>

        </c:otherwise>

    </c:choose>

</div>

</body>
</html>