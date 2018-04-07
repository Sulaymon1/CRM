<#-- @ftlvariable name="errorMessage" type="String" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>CRM Demirel! | </title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form method="post" action="/login">
                    <h1>Login Form</h1>
                    <div>
                        <input type="text" class="form-control" name="email" placeholder="Username" required="" />
                    </div>
                    <div>
                        <input type="password" class="form-control" name="password" placeholder="Password" required="" />
                    </div>
                        <#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>

                        <ul class="parsley-errors-list filled" id="parsley-id-9">
                            <li class="parsley-required">The email or password you have entered is invalid, try again.</li>
                        </ul>
                    </#if>
                    <div>
                        <input type="submit" class="btn btn-default submit" style="margin-left: 0;" value="Login">
                        <a class="reset_pass" href="#">Lost your password?</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">New to site?
                            <a href="#signup" class="to_register"> Create Account </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />


                    </div>
                </form>
            </section>
        </div>

        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form action="/createUser" method="post">
                    <h1>Create Account</h1>
                   <#-- <div>
                        <input type="text" class="form-control" placeholder="Username" required="" />
                    </div>-->
                    <div>
                        <input type="email" name="email" class="form-control" placeholder="Email" required="" />
                    </div>
                    <div>
                        <input type="password" name="hashPassword" class="form-control" placeholder="Password" required="" />
                    </div>
                <#if errors??>
                    <ul class="parsley-errors-list filled" id="parsley-id-9">
                        <li class="parsley-required">${errors}</li>
                    </ul>
                </#if>
                    <div>
                        <input type="submit" class="btn btn-default submit" style="margin-left: 0;" value="Register">
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Already a member ?
                            <a href="#signin" class="to_register"> Log in </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />


                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>
