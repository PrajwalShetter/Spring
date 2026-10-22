
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>User Home</title>

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

    <jsp:include page="userNavbar.jsp" />

    <main class="container py-5">
        <div class="p-5 mb-4 bg-white rounded-3 shadow-sm">
            <h1 class="display-6 fw-bold">Welcome to Your Dashboard!</h1>

            <p class="col-md-8 fs-5 text-secondary">
                Welcome back. You can access your profile and manage
                your account using the options available here.
            </p>

            <a class="btn btn-dark"
               href="profile">
                View My Profile
            </a>
        </div>

        <div class="row g-4">
            <div class="col-md-6">
                <div class="card h-100 shadow-sm border-0">
                    <div class="card-body">
                        <h5 class="card-title">My Profile</h5>
                        <p class="card-text">
                            View your personal information.
                        </p>
                        <a href="profile"
                           class="btn btn-outline-dark">
                            View Profile
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card h-100 shadow-sm border-0">
                    <div class="card-body">
                        <h5 class="card-title">Account</h5>
                        <p class="card-text">
                            Manage your account and sign out securely.
                        </p>
                        <a href="logout"
                           class="btn btn-outline-dark">
                            Logout
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <jsp:include page="../common/footer.jsp" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
