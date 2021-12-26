<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>DMS-KIT</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta content="" name="description">
    <meta content="" name="author">
    <!-- App favicon -->
    <link rel="shortcut icon" href="images/favicon.ico">

    <!-- App css -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/icons.css" rel="stylesheet" type="text/css">
    <link href="css/metismenu.min.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body class="account-body">
    <!-- Log In page -->
    <div class="row vh-100">
        <div class="col-lg-9 p-0 d-flex justify-content-center">
            <div class="accountbg d-flex align-items-center">
                <div class="account-title text-white text-center"><img src="${pageContext.request.contextPath}/images/karvy-logo-sm.png" alt="" class="thumb-sm">
                    <h4 class="mt-3">Welcome to Java World with Vikash</h4>
                    <div class="border w-25 mx-auto border-primary"></div>
                    <h1 class="">Let's Get Started</h1>
                    <!-- <p class="font-14 mt-3">Don't have an account ? <a href="" class="text-primary">Sign up</a></p> -->
                </div>
            </div>
        </div>
        
        <div class="col-lg-3 pr-0">
            <div class="card mb-0 shadow-none">
                <div class="card-body">
                    <div class="px-3">
                        <div class="media">
                            <a href="login" class="logo logo-admin"><img src="${pageContext.request.contextPath}/images/karvy-logo.png" height="55" alt="logo" class="my-3"></a>

                        </div>
                        
                        <form class="needs-validation-user-login" id="user-login-form" novalidate>
                            <div class="media-body ml-4 text-center">
                                <h4 class="mt-0 mb-1">Please Login</h4>
                                <p class="text-muted mb-4">Sign in to continue</p>
                            </div>
                           
                            <div class="form-group">
                                <label for="username">Email ID</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend"><span class="input-group-text" id="basic-addon1"><i class="mdi mdi-account-outline font-16"></i></span></div>
                                    <input type="text" class="form-control" id="userName" name="j_username" placeholder="Enter email ID" required>
                                      <div class="invalid-feedback">Please enter Email-id</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="userpassword">Password</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend"><span class="input-group-text" id="basic-addon2"><i class="mdi mdi-key font-16"></i></span></div>
                                    <input type="password" class="form-control" id="password" name="j_password" placeholder="Enter password" required>
                                      <div class="invalid-feedback">Please enter password</div>
                                </div>
                            </div>
                            
                            <div class="form-group row mt-4">
                                <!-- <div class="col-sm-6">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" id="customControlInline">
                                        <label class="custom-control-label" for="customControlInline">Remember me</label>
                                    </div>
                                </div> -->
                               <!--  <div class="col-sm-12 text-right"><a href="forgot-password" class="text-muted font-13"><i class="mdi mdi-lock"></i> Forgot your password?</a></div> -->
                            </div>
                            <div class="form-group mb-0 row">
                                <div class="col-12 mt-2">
                                    <button class="btn btn-primary btn-block waves-effect waves-light" type="submit">Log In <i class="fas fa-sign-in-alt ml-1"></i></button>
                                </div>
                            </div>
                            
                        </form>
                    </div>
                    </div>
            </div>
        </div>
    </div>
    <!-- End Log In page -->
    <!-- jQuery  -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/metisMenu.min.js"></script>
    <script src="js/waves.min.js"></script>
    <script src="js/jquery.slimscroll.min.js"></script>

    <script src="js/jquery.dashboard.init.js"></script>
    <!-- App js -->
    <script src="js/app.js"></script>
     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    	<script type="text/Javascript" src="${pageContext.request.contextPath}/configJs/configVariables.js"></script>
      <%-- <script type="text/Javascript" src="${pageContext.request.contextPath}/configJs/configFunction.js"></script> --%>
	 <script type="text/Javascript" src="${pageContext.request.contextPath}/ajaxJs/configAjax.js"></script>
   <script type="text/Javascript" src="${pageContext.request.contextPath}/functionJs/loginFunction.js"></script>
   
</body>


</html>