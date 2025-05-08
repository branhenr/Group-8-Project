<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Recipe List</title>

    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>

<!-- Title of website -->
<header class="text-center p-3">
    <h1>Fork and Share</h1>
</header>
<!-- End of title of website -->

<!-- Beginning of navbar -->
<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #414b3b;">
    <a class="navbar-brand" href="/home">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/chefs/all">Chefs</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/recipes/all">Recipes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chefs/createForm">Sign up</a>
            </li>
        </ul>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="search" placeholder="Search ">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>
<!-- End of Navbar -->

<!-- Top header of recipe -->
<strong><a href="chefprof.html" class="text-dark">@username </a></strong>

<!--<form action="/users/${user.userID}/save-recipe/${recipe.recipeID}" method="post" style="display: inline;">-->
<!--    <button type="submit" class="btn btn-light btn-sm">Save recipe</button>-->
<!--</form>-->

<!-- Top header of recipe -->

<h3>${recipe.name}</h3>
</body>

</html>