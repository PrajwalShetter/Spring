
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

    <title>My Profile</title>
</head>

<body class="bg-light">

<%@ include file="userNavbar.jsp" %>

<div class="container py-5">

    <div class="text-center mb-4">
        <h2 class="fw-bold">My Profile</h2>
        <p class="text-muted">View your personal information</p>
    </div>

    <div class="card border-0 shadow-sm rounded-4 mx-auto"
         style="max-width: 650px;">

        <div class="card-header bg-primary text-white text-center py-4">

            <c:choose>
                <c:when test="${not empty profile.profilePic}">
                    <img src="profile-picture"
                         alt="Profile Picture"
                         class="rounded-circle border border-3 border-white mb-3"
                         style="width: 110px; height: 110px; object-fit: cover;">
                </c:when>

                <c:otherwise>
                    <div class="rounded-circle bg-white text-primary
                                d-flex align-items-center justify-content-center
                                mx-auto mb-3 fw-bold"
                         style="width: 110px; height: 110px; font-size: 36px;">
                        ${empty profile.name ? 'U' : profile.name.substring(0,1)}
                    </div>
                </c:otherwise>
            </c:choose>

            <h4 class="mb-1">
                <c:out value="${profile.name}" />
            </h4>

            <p class="mb-0">User Profile</p>
        </div>

        <div class="card-body p-4">

            <c:if test="${not empty success}">
                <div class="alert alert-success">
                    <c:out value="${success}" />
                </div>
            </c:if>

            <c:if test="${not empty failure}">
                <div class="alert alert-danger">
                    <c:out value="${failure}" />
                </div>
            </c:if>

            <div class="row py-3 border-bottom">
                <div class="col-sm-4 text-secondary fw-semibold">Full Name</div>
                <div class="col-sm-8"><c:out value="${profile.name}" /></div>
            </div>

            <div class="row py-3 border-bottom">
                <div class="col-sm-4 text-secondary fw-semibold">Email Address</div>
                <div class="col-sm-8"><c:out value="${profile.email}" /></div>
            </div>

            <div class="row py-3 border-bottom">
                <div class="col-sm-4 text-secondary fw-semibold">Phone Number</div>
                <div class="col-sm-8"><c:out value="${profile.phone}" /></div>
            </div>

            <div class="row py-3 border-bottom">
                <div class="col-sm-4 text-secondary fw-semibold">Gender</div>
                <div class="col-sm-8"><c:out value="${profile.gender}" /></div>
            </div>

            <div class="row py-3">
                <div class="col-sm-4 text-secondary fw-semibold">Account Status</div>
                <div class="col-sm-8">
                    <span class="badge bg-success">Active</span>
                </div>
            </div>

            <!-- Upload Profile Picture -->
            <form action="${pageContext.request.contextPath}/user/uploadProfilePic"
                  method="post"
                  enctype="multipart/form-data"
                  class="border-top pt-4 mt-2">

                <label for="profilePicFile" class="form-label fw-semibold">
                    Upload Profile Picture
                </label>

                <input type="file"
                       class="form-control mb-3"
                       id="profilePicFile"
                       name="profilePicFile"
                       accept="image/jpeg,image/png,image/webp"
                       onchange="validateProfilePic()"
                       required>
                 <div id="uploadError" class="text-danger small"></div>

                 <c:if test="${not empty picUpload}">
                     <div class="text-success small mb-2">
                         ${picUpload}
                     </div>
                 </c:if>

                 <c:if test="${not empty picNotUpload}">
                     <div class="text-danger small mb-2">
                         ${picNotUpload}
                     </div>
                 </c:if>

                <button type="submit" class="btn btn-outline-primary w-100">
                    Upload Picture
                </button>
            </form>

            <div class="text-center mt-3">
                <a href="${pageContext.request.contextPath}/user/editProfile"
                   class="btn btn-primary px-5">
                    Edit Profile
                </a>
            </div>

        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>

<script>
    function validateProfilePic() {

        let fileInput = document.getElementById("profilePicFile");
        let uploadError = document.getElementById("uploadError");
        let file = fileInput.files[0];

        uploadError.innerHTML = "";

        if (!file) {
            return;
        }

        let allowedTypes = ["image/jpeg", "image/png", "image/webp"];

        if (!allowedTypes.includes(file.type)) {
            uploadError.innerHTML =
                "Only JPG, PNG, and WEBP images are allowed.";
            fileInput.value = "";
            return;
        }

        if (file.size > 5 * 1024 * 1024) {
            uploadError.innerHTML =
                "Image size must be 5 MB or less.";
            fileInput.value = "";
            return;
        }
    }
</script>
</html>
