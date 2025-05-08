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
            <li class="nav-item">
                <a class="nav-link" href="/users/all">Users</a>
            </li>

            <li class="nav-item active">
                <a class="nav-link" href="/recipes/all">Recipes</a>
            </li>
             <li class="nav-item">
                            <a class="nav-link" href="/users/saveForm">Save Recipes</a>
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

<!-- list of chefs -->
<h1>List of Chefs</h1>

<#list chefList as chef>
<div class="card">
    <div class="card-body">
        <h5 class="card-title">${chef.username}</h5>
        <h6 class="card-subtitle mb-2 text-body-secondary">${chef.email}</h6>
        <p class="card-text">${chef.password}</p>
        <a href="/chefs/${chef.chefId}" class="card-link">View</a>
    </div>
</div>
</#list>

</body>
</html>