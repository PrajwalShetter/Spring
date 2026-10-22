
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<%@ include file="userNavbar.jsp" %>

<div class="container py-5">
    <div class="text-center mb-4">
        <h2 class="fw-bold">Edit Profile</h2>
        <p class="text-muted">Update your personal information</p>
    </div>

    <div class="card border-0 shadow-sm rounded-4 mx-auto"
         style="max-width: 650px;">

        <div class="card-body p-4 p-md-5">

            <c:if test="${not empty failure}">
                <div class="text-danger small mb-3">
                    <c:out value="${failure}"/>
                </div>
            </c:if>

            <!-- PHOTO FORM -->
            <form action="uploadProfilePic"
                  method="post"
                  enctype="multipart/form-data"
                  id="photoForm">

                <div class="text-center mb-4">
                    <label for="profilePicFile"
                           class="d-inline-block position-relative"
                           style="cursor: pointer;"
                           title="Click to change profile photo">

                        <c:choose>
                            <c:when test="${not empty user.profilePic}">
                                <img src="${pageContext.request.contextPath}/profile-picture"
                                     alt="Profile Picture"
                                     class="rounded-circle border shadow-sm"
                                     style="width: 120px; height: 120px; object-fit: cover;">
                            </c:when>

                            <c:otherwise>
                                <div class="rounded-circle bg-primary text-white
                                            d-flex align-items-center justify-content-center
                                            border shadow-sm fw-bold"
                                     style="width: 120px; height: 120px; font-size: 36px;">
                                    <c:out value="${empty user.name ? 'U' : user.name.substring(0,1)}"/>
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <span class="position-absolute bottom-0 end-0
                                     badge rounded-pill bg-primary p-2">
                            Edit
                        </span>
                    </label>

                    <input type="hidden" name="id" value="${user.id}">

                    <input type="file"
                           id="profilePicFile"
                           name="profilePicFile"
                           accept="image/jpeg,image/png,image/webp"
                           class="d-none">

                    <div class="form-text mt-2">
                        Click your photo to change it (JPG, PNG, WEBP; max 5 MB)
                    </div>

                    <div id="uploadError" class="text-danger small mt-2"></div>

                    <c:if test="${not empty picUpload}">
                        <div class="text-success small mt-2">
                            <c:out value="${picUpload}"/>
                        </div>
                    </c:if>

                    <c:if test="${not empty picNotUpload}">
                        <div class="text-danger small mt-2">
                            <c:out value="${picNotUpload}"/>
                        </div>
                    </c:if>
                </div>
            </form>

            <hr class="mb-4">

            <!-- PROFILE DETAILS FORM -->
            <form action="${pageContext.request.contextPath}/user/updateProfile"
                  method="post"
                  id="profileForm">

                <input type="hidden" name="id" value="${user.id}">

                <div class="mb-3">
                    <label for="name" class="form-label fw-semibold">
                        Full Name
                    </label>
                    <input type="text"
                           class="form-control"
                           id="name"
                           name="name"
                           value="<c:out value='${user.name}'/>"
                           required>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label fw-semibold">
                        Email Address
                    </label>
                    <input type="email"
                           class="form-control"
                           id="email"
                           name="email"
                           value="<c:out value='${user.email}'/>"
                           readonly>
                </div>

                <div class="mb-3">
                    <label for="phone" class="form-label fw-semibold">
                        Phone Number
                    </label>
                    <input type="tel"
                           class="form-control"
                           id="phone"
                           name="phone"
                           value="<c:out value='${user.phone}'/>"
                           pattern="[6-9][0-9]{9}"
                           maxlength="10"
                           required>
                </div>

                <div class="mb-4">
                    <label for="gender" class="form-label fw-semibold">
                        Gender
                    </label>
                    <select class="form-select" id="gender" name="gender" required>
                        <option value="">Select Gender</option>
                        <option value="MALE" ${user.gender == 'MALE' ? 'selected' : ''}>Male</option>
                        <option value="FEMALE" ${user.gender == 'FEMALE' ? 'selected' : ''}>Female</option>
                        <option value="OTHER" ${user.gender == 'OTHER' ? 'selected' : ''}>Other</option>
                    </select>
                </div>

                <div class="d-flex flex-column flex-sm-row gap-2">
                    <button type="submit" class="btn btn-success flex-fill">
                        Save Changes
                    </button>

                    <a href="${pageContext.request.contextPath}/user/profile"
                       class="btn btn-outline-secondary flex-fill">
                        Back to Profile
                    </a>
                </div>
            </form>

        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<script>
    const profilePicFile = document.getElementById("profilePicFile");
    const uploadError = document.getElementById("uploadError");

    profilePicFile.addEventListener("change", function () {
        uploadError.textContent = "";

        const file = this.files[0];

        if (!file) {
            return;
        }

        const allowedTypes = ["image/jpeg", "image/png", "image/webp"];

        if (!allowedTypes.includes(file.type)) {
            uploadError.textContent =
                "Only JPG, PNG, and WEBP images are allowed.";
            this.value = "";
            return;
        }

        if (file.size > 5 * 1024 * 1024) {
            uploadError.textContent =
                "Image size must be 5 MB or less.";
            this.value = "";
            return;
        }

        document.getElementById("photoForm").requestSubmit();
    });
</script>

</body>
</html>
