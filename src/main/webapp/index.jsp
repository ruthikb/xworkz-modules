<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login </title>
  <link rel="icon" href="https://www.x-workz.in/Logo.png">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

  <header class="bg-dark text-white py-3 fixed-top" >
    <div class="container-fluid d-flex align-items-center justify-content-between">
      <img src="https://www.x-workz.in/Logo.png" alt="Logo" height="50">
      <h1 class="m-0 text-center flex-grow-1">PET SHOP</h1>
      <a href="loginUser" class="btn btn-warning text-dark">login </a>
      <a href="userRegister" class="btn btn-warning text-dark">User Register</a>
    </div>
  </header>
  <main class="d-flex justify-content-center align-items-center text-white"
    style="background: url('https://images.squarespace-cdn.com/content/v1/6696db1842323f535605c334/5d7d21fe-e1d7-460e-9d0f-642e2535c843/image_67528961.jpg?format=2500w') no-repeat center center/cover; height: 635px;">


  </main>

  <div class="container px-4 py-5" id="featured-3">
    <h2 class="pb-2 border-bottom">Columns with icons</h2>
    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
      <div class="feature col">
        <div
          class="feature-icon d-inline-flex align-items-center justify-content-center text-bg-primary bg-gradient fs-2 mb-3">
          <svg class="bi" width="1em" height="1em" aria-hidden="true">
            <use xlink:href="#collection"></use>
          </svg> </div>
        <h3 class="fs-2 text-body-emphasis">Featured title</h3>
        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and
          probably just keep going until we run out of words.</p> <a href="#" class="icon-link">
          Call to action
          <svg class="bi" aria-hidden="true">
            <use xlink:href="#chevron-right"></use>
          </svg> </a>
      </div>
      <div class="feature col">
        <div
          class="feature-icon d-inline-flex align-items-center justify-content-center text-bg-primary bg-gradient fs-2 mb-3">
          <svg class="bi" width="1em" height="1em" aria-hidden="true">
            <use xlink:href="#people-circle"></use>
          </svg> </div>
        <h3 class="fs-2 text-body-emphasis">Featured title</h3>
        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and
          probably just keep going until we run out of words.</p> <a href="#" class="icon-link">
          Call to action
          <svg class="bi" aria-hidden="true">
            <use xlink:href="#chevron-right"></use>
          </svg> </a>
      </div>
      <div class="feature col">
        <div
          class="feature-icon d-inline-flex align-items-center justify-content-center text-bg-primary bg-gradient fs-2 mb-3">
          <svg class="bi" width="1em" height="1em" aria-hidden="true">
            <use xlink:href="#toggles2"></use>
          </svg> </div>
        <h3 class="fs-2 text-body-emphasis">Featured title</h3>
        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and
          probably just keep going until we run out of words.</p> <a href="#" class="icon-link">
          Call to action
          <svg class="bi" aria-hidden="true">
            <use xlink:href="#chevron-right"></use>
          </svg> </a>
      </div>
    </div>
  </div>

  <footer class="bg-dark text-white py-2  text-center fixed-bottom" >
    <p class="mb-0">&copy; 2025, All Rights Reserved</p>
    <!-- Date/Time fixed to bottom right -->
    <span id="dateTime" class="position-absolute bottom-0 end-0 me-3 mb-1 fw-bold"></span>
  </footer>

  <script>
    function updateDateTime() {
      document.getElementById("dateTime").textContent = new Date().toLocaleString();
    }
    setInterval(updateDateTime, 1000);
    updateDateTime();
  </script>

</body>

</html>
