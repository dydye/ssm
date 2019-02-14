<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/common.jsp" %>
<html>
<head>

    <!-- Font Awesome CSS -->
    <link href="${contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/resources/css/animate.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>

    <title>首页</title>
</head>
<body>
<!-- Start Main Body Section -->
<div class="mainbody-section text-center">
    <div class="container">
        <div class="row">

            <div class="col-md-3">

                <div class="menu-item blue">
                    <a href="${contextPath}/ftp/index" target="_blank" data-toggle="modal">
                        <i class="fa fa-magic"></i>
                        <p>FTP</p>
                    </a>
                </div>

                <div class="menu-item green">
                    <a href="#portfolio-modal" data-toggle="modal">
                        <i class="fa fa-file-photo-o"></i>
                        <p>Portfolio</p>
                    </a>
                </div>

                <div class="menu-item light-red">
                    <a href="#about-modal" data-toggle="modal">
                        <i class="fa fa-user"></i>
                        <p>About Us</p>
                    </a>
                </div>

            </div>

            <div class="col-md-6">

                <!-- Start Carousel Section -->
                <div class="home-slider">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"
                         style="padding-bottom: 30px;">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="${contextPath}/resources/images/index-01.JPG" class="img-responsive" alt="">
                            </div>
                            <div class="item">
                                <img src="${contextPath}/resources/images/index-02.JPG" class="img-responsive" alt="">
                            </div>
                            <div class="item">
                                <img src="${contextPath}/resources/images/index-03.JPG" class="img-responsive" alt="">
                            </div>

                        </div>

                    </div>
                </div>
                <!-- Start Carousel Section -->

                <div class="row">
                    <div class="col-md-6">
                        <div class="menu-item color responsive">
                            <a href="#service-modal" data-toggle="modal">
                                <i class="fa fa-area-chart"></i>
                                <p>Services</p>
                            </a>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="menu-item light-orange responsive-2">
                            <a href="#team-modal" data-toggle="modal">
                                <i class="fa fa-users"></i>
                                <p>Team</p>
                            </a>
                        </div>
                    </div>

                </div>

            </div>

            <div class="col-md-3">

                <div class="menu-item light-red">
                    <a href="#contact-modal" data-toggle="modal">
                        <i class="fa fa-envelope-o"></i>
                        <p>Contact</p>
                    </a>
                </div>

                <div class="menu-item color">
                    <a href="#testimonial-modal" data-toggle="modal">
                        <i class="fa fa-comment-o"></i>
                        <p>Testimonial</p>
                    </a>
                </div>

                <div class="menu-item blue">
                    <a href="#news-modal" data-toggle="modal">
                        <i class="fa fa-mortar-board"></i>
                        <p>Latest News</p>
                    </a>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- End Main Body Section -->

<!-- Start Copyright Section -->
<div class="copyright text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div>欢迎光临本网站，目前仅FTP可用，其他仅展示</div>
            </div>
        </div>
    </div>
</div>
<!-- End Copyright Section -->
</body>
</html>
