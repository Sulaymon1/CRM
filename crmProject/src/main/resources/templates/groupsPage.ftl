<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>DataTables | Gentelella</title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
    <script>
        function init_autocomplete() {

            if( typeof ($.fn.autocomplete) === 'undefined'){ return; }
            console.log('init_autocomplete');

            $.ajax({
                method: 'GET',
                url: '/getLevel',
                dataType: 'json',
                success:function (data) {
                    var countriesArray = $.map(data, function(value, key) {
                        return {
                            value: value,
                            data: key
                        };
                    });
                    $('#autocomplete-custom-append1').autocomplete({
                        lookup: countriesArray
                    });
                }
            });


        // initialize autocomplete with custom appendTo


        };
    </script>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/lessons" class="site_title"><i class="fa fa-paw"></i> <span>Mental Roo!</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="/production/images/img.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>John Doe</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li>
                                <a href="/lessons"><i class="fa fa-book"></i> Lessons </a>
                            </li>
                            <li>
                                <a href="/members"><i class="fa fa-user"></i> Members </a>
                            </li>
                            <li>
                                <a href="/groups"><i class="fa fa-users"></i> Groups </a>
                            </li>
                            <li>
                                <a href="/teachers"><i class="fa fa-mortar-board"></i> Teachers </a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-group"></i> Leads </a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-lock"></i> Access into CRM </a>
                            </li>
                            <li>
                                <a href="/logout"><i class="fa fa-sign-out"></i> Logout </a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="/logout">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <img src="/production/images/img.jpg" alt="">John Doe
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="javascript:;"> Profile</a></li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="badge bg-red pull-right">50%</span>
                                        <span>Settings</span>
                                    </a>
                                </li>
                                <li><a href="javascript:;">Help</a></li>
                                <li><a href="/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                            </ul>
                        </li>

                        <li role="presentation" class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">6</span>
                            </a>
                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                <li>
                                    <a>
                                        <span class="image"><img src="/production/images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="/production/images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="/production/images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="/production/images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <div class="text-center">
                                        <a>
                                            <strong>See All Alerts</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="col-md-12 col-sm-12 col-xs-12" style="padding: 0;">
                    <div class="x_panel">

                        <div class="x_content">
                            <div class="bs-example-popovers">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">
                                    Add new group
                                </button>
                               <#-- <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." data-original-title="" title="">
                                    Top
                                </button>
                                <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
                                    Bottom
                                </button>
                                <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="right" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
                                    Right
                                </button>-->

                            </div>
                            <!-- end pop-over -->

                        </div>
                    </div>
                </div>

                <!--   start  Add button modal-->

                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabel">New member</h4>
                            </div>
                            <form action="/addGroup"  method="post"  id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

                                <div class="modal-body">


                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Name<span class="required">*</span>
                                        </label>
                                        <div class="col-md-3 col-sm-6 col-xs-12 form-group has-feedback">
                                            <input type="text" class="form-control" name="name" id="inputSuccess2" required="required" placeholder="name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Level <span class="required">*</span>
                                        </label>
                                        <div class="col-md-4 col-sm-9 col-xs-12">
                                            <select name="level" class="form-control" required="required">
                                                <option value="INTERMEDIATE">intermediate</option>
                                                <option value="ADVANCED">advanced</option>
                                                <option value="ELEMENTARY">elementary</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Responsible Teacher</label>
                                        <div class="col-md-4 col-sm-6 col-xs-12">
                                            <input id="birthday" class="date-picker form-control col-md-7 col-xs-12" name="responsibleTeacher" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Start date <span class="required">*</span>
                                        </label>
                                        <div class="col-md-3 col-sm-6 col-xs-12 form-group">
                                            <input type="date" class="form-control has-feedback-left" required="required" name="startLessonDate" id="inputSuccess2" placeholder="date">
                                            <span class="fa fa-calendar form-control-feedback left" aria-hidden="true"></span>
                                        </div>
                                        <label class="control-label col-md-2 col-sm-3 col-xs-12" for="first-name">End date
                                        </label>
                                        <div class="col-md-3 col-sm-6 col-xs-12 form-group">
                                            <input type="date" class="form-control has-feedback-left" name="endLessonDate" id="inputSuccess2" placeholder="date">
                                            <span class="fa fa-calendar form-control-feedback left" aria-hidden="true"></span>
                                        </div>
                                    </div>

                                <#if errors??>
                                        ${errors}
                                    </#if>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <!--   end  Add button modal-->

                <div class="clearfix"></div>


                <div class="row">
                    <div>
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_content">
                                    <table id="datatable-checkbox" class="table table-striped table-bordered bulk_action">
                                        <thead>
                                        <tr>
                                            <th>
                                            <th><input type="checkbox" id="check-all" class="flat"></th>
                                            </th>
                                            <th>Name</th>
                                            <th>Start date</th>
                                            <th>End date</th>
                                            <th>Members</th>
                                            <th>Level</th>
                                        </tr>
                                        </thead>


                                        <tbody>

                                        <#if model.groups??>
                                            <#list model.groups as group>
                                            <tr>
                                                <td>
                                                <th><input type="checkbox" id="check-all" class="flat"></th>
                                                </td>
                                                <td>${group.name!}</td>
                                                <td>${group.startLessonDate!}</td>
                                                <td>${group.endLessonDate!}</td>
                                                <td><#--${group.members!}--></td>
                                                <td>${group.level!}</td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        <tr>
                                            <td>
                                            <th><input type="checkbox" id="check-all" class="flat"></th>
                                            </td>
                                            <td>Test name</td>
                                            <td>01.04.2018</td>
                                            <td>23.05.2018</td>
                                            <td>Member1...</td>
                                            <td>02</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /page content -->

                <!-- footer content -->
                <footer>

                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
            </div>
        </div>

        <!-- jQuery -->
        <script src="/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="/vendors/nprogress/nprogress.js"></script>
        <!-- iCheck -->
        <script src="/vendors/iCheck/icheck.min.js"></script>
        <!-- Datatables -->
        <script src="/vendors/parsleyjs/dist/parsley.min.js"></script>
        <script src="/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
        <script src="/vendors/jszip/dist/jszip.min.js"></script>
        <script src="/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="/vendors/pdfmake/build/vfs_fonts.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="/build/js/custom.min.js"></script>

</body>
</html>