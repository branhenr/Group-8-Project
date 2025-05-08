<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Chef List</title>

    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<!-- Title of website -->
<body>
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
            <li class="nav-item">
                <a class="nav-link" href="/users/all">Users</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/recipes/all">Recipes </a>
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

<!-- Top part of chef profile -->
<div class="row">
    <div class="col"><img src="/images/chef.avif" class="profile-pic" alt="chef">
        <p class="username">@${chef.username} <br> Chef|Experience|Specialty </p> <br>
    </div>
    <div class="col"><p class="chef-name">${chef.username}</p></div>
    <div class="col"></div>
</div>

<hr width="100%" color="black" size="1">
<!-- End part of chef Profile -->

<!-- UI for chef to edit profile -->
<ul class="nav justify-content-end">
    <li class="nav-item dropdown">
        <a aria-expanded="false" class="btn btn-outline-success my-2 my-sm-0" class="nav-link dropdown-toggle"
           data-bs-toggle="dropdown"
           href="#" role="button">Edit Profile</a>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/chefs/update/${chefId}">Update Information</a></li>
            <li><a class="dropdown-item" href="/chefs/delete/${chefId}">Delete Account</a></li>
        </ul>
    </li>

    <li class="nav-item">
        <a href="/recipes/createForm" class="btn btn-outline-success my-2 my-sm-0" role="button" aria-pressed="true">Post</a>
    </li>

    <li class="nav-item">
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </li>
</ul>

<!-- End of UI for editing profile -->

<!-- Recipes for chef -->
<div class="container text-center">
    <#list chefRecipesList as recipe>
    <div class="col-sm-4">
        <div class="card" style="width: 18rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${recipe.name}</h5>
                <p class="card-text">${recipe.description}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Diet: ${recipe.diet}</li>
                <li class="list-group-item">Preparation Time: ${recipe.prepTime}</li>
                <li class="list-group-item">A third item</li>
            </ul>
            <div class="card-body">
                <a class="btn btn-danger" href="/recipes/delete/${recipe.recipeId}" role="button">Delete</a>
                <a class="btn btn-outline-success" href="/recipes/update/${recipe.recipeId}" class="card-link">Edit</a>
            </div>
        </div>
    </div>
</#list>
</div>


<!-- End of recipes for chef -->

</body>
</html>