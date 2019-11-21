<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="theme-color" content="#e54c2a">
    <!-- Favicon -->
    <link type="image/x-icon" rel="shortcut icon" href="favicon.png">
    <title>STEAM - Restaurant and Drinks Responsive HTML5 Template</title>
    <meta name="description"
          content="STEAM - Restaurant, food and Drinks HTML5 website template is Modern, Clean and Professional site template. Prefect for RESTAURANT, Bakery, Cafe, Bar, Catering, food business and for personal chef portfolio website.">

    <!-- Bootstrap stylesheet -->
    <link href="https://www.spheretheme.com/html/steam/assets/libs/bootstrap-4.0.0-dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- icofont -->
    <link href="./css/icofont.css" rel="stylesheet" type="text/css">
    <!-- crousel css -->
    <link href="https://www.spheretheme.com/html/steam/assets/libs/owlcarousel2/assets/owl.carousel.min.css"
          rel="stylesheet" type="text/css">
    <!-- Animated Headlines css -->
    <link href="https://www.spheretheme.com/html/steam/assets/libs/animated-headlines/animated-headlines.css"
          rel="stylesheet" type="text/css">
    <!-- mb.YTPlayer css -->
    <link href="https://www.spheretheme.com/html/steam/assets/libs/mb.YTPlayer/css/jquery.mb.YTPlayer.min.css"
          rel="stylesheet" type="text/css">
    <!-- Switch Style css -->
    <link href="https://www.spheretheme.com/html/steam/assets/switch-style/switch-style.css" rel="stylesheet"
          type="text/css">
    <!-- Theme Stylesheet -->
    <link href="https://www.spheretheme.com/html/steam/assets/css/style.css" rel="stylesheet" type="text/css">
	<link href="css/custom.css" rel="stylesheet" type="text/css">
</head>

<body class="header-0 wide-layout"><a href="#" class="bottom-top" style="display: block;"><i
        class="icofont icofont-bubble-up"></i></a>
<div class="wrapper">
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a
            href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

    <!-- Loader Start -->
    <div class="loader" style="display: none">
        <div class="loader-inner">
            <h4>Cooking in progress..</h4>
            <div id="cooking">
                <div class="bubble"></div>
                <div class="bubble"></div>
                <div class="bubble"></div>
                <div class="bubble"></div>
                <div class="bubble"></div>
                <div id="area">
                    <div id="sides">
                        <div id="pan"></div>
                        <div id="handle"></div>
                    </div>
                    <div id="pancake">
                        <div id="pastry"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Loader End -->

  <!--  Header Start  -->
    <header>
        <!--Top Header End -->

        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <!-- Logo Start  -->
                    <div id="logo">
                        <!-- <a href="index.html"><img id="logo_img" class="img-fluid" src="./img/logo.png" alt="logo" title="logo"></a> -->
                    </div>
                    <!-- Logo End  -->
                </div>

                <div class="col-md-7 col-sm-6 col-xs-12 paddleft">
                    <!-- Main Menu Start  -->
                    <div id="menu">
                        <nav class="navbar navbar-expand-md">
                            <div class="navbar-header">
                                <span class="menutext d-block d-md-none">Menu</span>
                                <button data-target=".navbar-ex1-collapse" data-toggle="collapse" class="btn btn-navbar navbar-toggler" type="button">
                                    <i class="icofont icofont-navigation-menu"></i>
                                </button>
                            </div>
                            <div class="collapse navbar-collapse navbar-ex1-collapse padd0">
                                <ul class="nav navbar-nav">
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}">HOME</a>
                                    </li>
                                    <li class="nav-item"><a href="${pageContext.request.contextPath}/about2.jsp">about us</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                    <!-- Main Menu End -->
                </div>
                <div class="col-md-2 col-sm-12 col-xs-12 button-top paddleft">
                    <a class="btn-primary btn" href="${pageContext.request.contextPath}/#mainFilter" id="placeYourOrder">Book Your Meal</a>
                </div>
            </div>
        </div>
    </header>
    <!-- Header End   -->

    <div class="bread-crumb">
        <div class="container">
            <div class="matter" style="width: 50vw; color: white;">
                <div class="cd-headline clip">
                    <h4>LOVES <span class="cd-words-wrapper" style="width: 81.743px; overflow: hidden;">
                                <b class="is-visible">HEALTHY</b>
                                <b class="is-hidden">QUALITY</b>
                                <b class="is-hidden">TESTY</b>
                            </span>FOOD</h4>
                </div>
            </div>
        </div>
    </div>
    <!-- Food Menu Start -->

</div>
<!-- Food Menu End -->
<div class="about">
    <div class="container">
        <div class="row">
            <!-- Title Content Start -->
            <div class="col-sm-12 col-md-12 col-lg-6 col-xs-12 commontop text-left">
                <h4>about our restaurant food &amp; drinkes</h4>

                <p>Vegetarian dishes are sometimes associated with complicated ingredients and techniques, but our
                    online food ordering system is
                    here to introduce vegetarian meals. Totally veggie-friendly, and flavor packed orders come in at the
                    door. </p>
                <p class="des">The following vegatarian meals that will make anyone want to go meatless:</p>
                <ul>
                    <li><strong>Paleo foods</strong> include seeds, nuts, fruits and veggies, along with healthy fats
                        and oils. Avoid processed foods, grains and sugar.
                    </li>
                    <li><strong>The ketogenic diet</strong> is low in carbs and moderate in protein.
                    </li>
                    <li><strong>Vegans</strong> can reach ketosis by relying on high-fat, plant-based products
                        like coconut oil, avocados, seeds and nuts.
                    </li>
                    <li><strong>Freestyle</strong> menu option that customer can choose various types of healthy foods
                        from our
                        menu. A gluten-free diet is that excludes the protein gluten.
                    </li>
                    <li><strong>Gluten</strong> is found in grains such as wheat, barley and a cross between
                        wheat and rye called triticale.
                    </li>
                </ul>
            </div>
            <!-- Title Content End -->
            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://www.spheretheme.com/html/steam/assets/images/about/1.png" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://www.spheretheme.com/html/steam/assets/images/about/2.png" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://www.spheretheme.com/html/steam/assets/images/about/3.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev" style="background-color: #b7bebe;">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next" style="background-color: #b7bebe;">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>

<!-- Footer Start -->
<footer>

    <div class="footer-bottom">
        <div class="container">
            <div class="row powered">
                <div class="col-md-12 col-sm-12 text-center order-md-1">
                    <p>WAP - Web Application Programming Aug, 2019</p>
                </div>

            </div>
        </div>
    </div>
</footer>
<!-- Footer End  -->

</div>

<!-- jquery -->
<script src="./js/jquery.min.js"></script>
<!-- jquery Validate -->
<script src="https://www.spheretheme.com/html/steam/assets/libs/jquery-validation/jquery.validate.min.js"></script>
<!-- popper js -->
<script src="https://www.spheretheme.com/html/steam/assets/libs/popper/popper.min.js"></script>
<!-- bootstrap js -->
<script src="https://www.spheretheme.com/html/steam/assets/libs/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
<!-- owlcarousel js -->
<script src="https://www.spheretheme.com/html/steam/assets/libs/owlcarousel2/owl.carousel.min.js"></script>
<!--inview js code-->
<script src="https://www.spheretheme.com/html/steam/assets/libs/jquery.inview/jquery.inview.min.js"></script>
<!--CountTo js code-->
<script src="https://www.spheretheme.com/html/steam/assets/libs/jquery.countTo/jquery.countTo.js"></script>
<!-- Animated Headlines js code-->
<script src="https://www.spheretheme.com/html/steam/assets/libs/animated-headlines/animated-headlines.js"></script>
<!-- mb.YTPlayer js code-->
<script src="https://www.spheretheme.com/html/steam/assets/libs/mb.YTPlayer/jquery.mb.YTPlayer.min.js"></script>
<!-- Switch Style js -->
<script src="./js/switch-style.js"></script>
<!--internal js-->
<script src="https://www.spheretheme.com/html/steam/assets/js/internal.js"></script>


</body>

</html>
