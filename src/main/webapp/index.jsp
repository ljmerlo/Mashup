<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-trainTo-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Trainz - Check your next Connection and the Weather</title>

  <!-- Bootstrap core CSS -->
  <link href="resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="resources/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Plugin CSS -->
  <link href="resources/bootstrap/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="resources/bootstrap/css/freelancer.min.css" rel="stylesheet">

  <!-- Favicon - not working on MacOS -->
  <link rel="icon" type="image/png" sizes="32x32" href="resources/bootstrap/img/favicons/favicon.png">

</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
  <div class="container">
    <a class="navbar-brand js-scroll-trigger" href="#page-top">Trainz</a>
    <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      Menu
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item mx-0 mx-lg-1">
          <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#trains">Trains</a>
        </li>
        <c:if test="${not empty requestScope.TrainConnections}">
        <li class="nav-item mx-0 mx-lg-1">
          <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#results">Results</a>
        </li>
        </c:if>
        <c:if test="${requestScope.showHistory}">
        <li class="nav-item mx-0 mx-lg-1">
          <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#history">Weather History</a>
        </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>

<!-- Header -->
<header class="masthead bg-primary text-white text-center">
  <div class="container">
    <img class="img-fluid mb-5 d-block mx-auto" src="resources/bootstrap/img/profile.png" alt="">
    <h1 class="text-uppercase mb-0">Trainz</h1>
    <hr class="star-light">
    <h2 class="font-weight-light mb-0">An API project by Lenny Merlo</h2>
  </div>
</header>

<!-- Train Section -->
<section id="trains">
  <div class="container">
    <h2 class="text-center text-uppercase text-secondary mb-0">Search for your perfect connection</h2>
    <hr class="star-dark mb-5">
    <div class="row">
      <div class="col-lg-8 mx-auto">
        <!-- TrainTo configure the contact form email address, go trainTo mail/contact_me.php and update the email address in the PHP file on line 19. -->
        <!-- The form should work on most web servers, but if the form is not working you may need trainTo configure your web server differently. -->
        <form action="trainServlet" method="post" name="sentMessage" id="contactForm" novalidate="novalidate">
          <div class="control-group">
            <div class="form-group floating-label-form-group controls mb-0 pb-2">
              <label>From</label>
              <input class="form-control" name="trainFrom" type="text" placeholder="From" required="required" data-validation-required-message="Please enter where you want trainTo leave.">
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls mb-0 pb-2">
              <label>To</label>
              <input class="form-control" name="trainTo" type="text" placeholder="To" required="required" data-validation-required-message="Please enter where you want trainTo go.">
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <br>
          <div id="success"></div>
          <div class="form-group">
            <input type="submit" class="btn btn-primary btn-xl" value="Submit" />
          </div>
        </form>
      </div>
    </div>
  </div>
</section>

<c:if test="${not empty requestScope.TrainConnections}">

<!-- Connections Section -->
<section class="bg-primary text-white mb-0" id="results">
  <div class="container">
    <h2 class="text-center text-uppercase text-white">Connections</h2>
    <hr class="star-light mb-5">
      <div class="control-group">
        <div class="form-group floating-label-form-group controls mb-0 pb-2">
          <table class="table table-hover">
            <thead>
            <tr>
              <th scope="col">From</th>
              <th scope="col">Departs</th>
              <th scope="col">Depart Weather</th>
              <th scope="col">To</th>
              <th scope="col">Arrives</th>
              <th scope="col">Arrival Weather</th>
              <th scope="col">Travel Time</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.TrainConnections}" var="connection">
              <tr>
                <td>${connection.trainFrom.name}</td>
                <td>${connection.trainFrom.departure_time}</td>
                <td>${connection.trainFrom.weather.description}</td>
                <td>${connection.trainTo.name}</td>
                <td>${connection.trainTo.arrival_time}</td>
                <td>${connection.trainTo.weather.description}</td>
                <td>${connection.difference}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    <br>
    <form action="weatherServlet" method="post" name="sentMessage" novalidate="novalidate">
      <label class="sr-only">From</label>
      <input class="sr-only" name="locationA" type="text" value="${requestScope.locationA}">
      <label class="sr-only">To</label>
      <input class="sr-only" name="locationB" type="text" value="${requestScope.locationB}">
      <button type="submit" class="btn btn-info">Weather History</button>
    </form>
  </div>
</section>

</c:if>

<c:if test="${requestScope.showHistory}">

  <section class="bg-primary text-white mb-0" id="history">
    <div class="container">
      <h2 class="text-center text-uppercase text-white">Weather history for both locations</h2>
        <hr class="star-light mb-5">
          <div class="row">
            <div class="col-lg-4 ml-auto">
              <c:if test="${requestScope.showWeatherA}">
                <table class="table table-hover">
                  <thead>
                  <tr>
                    <th scope="col">Location</th>
                    <th scope="col">Weather</th>
                    <th scope="col">Description</th>
                    <th scope="col">Date</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${requestScope.weatherA}" var="historyA">
                    <tr>
                      <td>${historyA.name}</td>
                      <td>${historyA.main}</td>
                      <td>${historyA.description}</td>
                      <td>${historyA.date}</td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </c:if>
              <c:if test="${not requestScope.showWeatherA}">
                <p>No weatherdata available for this location.</p>
              </c:if>
            </div>
            <div class="col-lg-4 mr-auto">
              <c:if test="${requestScope.showWeatherB}">
              <table class="table table-hover">
                <thead>
                <tr>
                  <th scope="col">Location</th>
                  <th scope="col">Weather</th>
                  <th scope="col">Description</th>
                  <th scope="col">Date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.weatherB}" var="historyB">
                  <tr>
                    <td>${historyB.name}</td>
                    <td>${historyB.main}</td>
                    <td>${historyB.description}</td>
                    <td>${historyB.date}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
              </c:if>
              <c:if test="${not requestScope.showWeatherB}">
                <p>No weatherdata available for this location.</p>
              </c:if>
            </div>
          </div>
        <br>
    </div>
  </section>

</c:if>

<!-- Footer -->
<footer class="footer text-center">
  <div class="container">
    <div class="row">
      <div class="col-md-4 mb-5 mb-lg-0">
        <h4 class="text-uppercase mb-4">Developer</h4>
        <p class="lead mb-0">Lenny Merlo, Rüti</p>
      </div>
      <div class="col-md-4 mb-5 mb-lg-0">
        <h4 class="text-uppercase mb-4">Around the Web</h4>
        <ul class="list-inline mb-0">
          <li class="list-inline-item">
            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
              <i class="fab fa-fw fa-facebook-f"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
              <i class="fab fa-fw fa-google-plus-g"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
              <i class="fab fa-fw fa-twitter"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
              <i class="fab fa-fw fa-linkedin-in"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
              <i class="fab fa-fw fa-dribbble"></i>
            </a>
          </li>
        </ul>
      </div>
      <div class="col-md-4">
        <h4 class="text-uppercase mb-4">About Me</h4>
        <p class="lead mb-0">Application Developer in the 3rd year.</p>
      </div>
    </div>
  </div>
</footer>

<div class="copyright py-4 text-center text-white">
  <div class="container">
    <small>Copyright &copy; Trainz 2019</small>
  </div>
</div>

<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
<div class="scroll-trainTo-top d-lg-none position-fixed ">
  <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
    <i class="fa fa-chevron-up"></i>
  </a>
</div>

<!-- Bootstrap core JavaScript -->
<script src="resources/bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="resources/bootstrap/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="resources/bootstrap/js/jqBootstrapValidation.js"></script>
<script src="resources/bootstrap/js/contact_me.js"></script>

<!-- Custom scripts for this template -->
<script src="resources/bootstrap/js/freelancer.min.js"></script>

</body>

</html>