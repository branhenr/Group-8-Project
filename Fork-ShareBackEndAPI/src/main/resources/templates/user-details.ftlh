<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<!-- Website title -->
<header class="text-center p-3">
    <h1>Fork and Share</h1>
</header>


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




<!-- Edit profile and top section -->
<div class="container mt-4">
    <div class="text-center">
        <h2 class="username">@${user.username}</h2>
        <img src="/images/homechefavi.jpg" class="profile-pic" alt="User profile picture">
        <p class="about-me">Food lover | Recipe Explorer | Home Chef</p>
        <a href="/users/update/${user.userID}" class="btn btn-outline-success">Edit Profile</a>
    </div>

    <hr>

<!-- UI for user to edit profile -->
<ul class="nav justify-content-end">
    <li class="nav-item">
        <a href="/users/update/${user.userID}" class="btn btn-outline-success my-2 my-sm-0" role="button" aria-pressed="true">Edit Profile</a>
    </li>
    <li class="nav-item mx-2">
        <a href="/recipes/createForm" class="btn btn-outline-success my-2 my-sm-0" role="button" aria-pressed="true">Post</a>
    </li>
    <li class="nav-item">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Filters
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Food Type</a>
                <a class="dropdown-item" href="#">Rating</a>
                <a class="dropdown-item" href="#">Newest</a>
            </div>
        </div>
    </li>
    <li class="nav-item">
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </li>
</ul>

<!-- End of UI for editing profile -->



<!-- Saved Recipes -->
<div class="card-deck m-4">
    <#if user.savedRecipes?has_content>
        <#list user.savedRecipes as recipe>
            <div class="card">
                <img class="card-img-top" src="${recipe.imageUrl}" alt="${recipe.title}">
                <div class="card-body">
                    <h5 class="card-title"><a href="/recipes/${recipe.recipeID}">${recipe.title}</a></h5>
                    <p class="card-text">${recipe.description}</p>
                    <p class="text-right">
                        <a href="/users/${user.userID}/unsave-recipe/${recipe.recipeID}" class="btn btn-sm btn-outline-danger">Unsave</a>
                    </p>
                </div>
            </div>
        </#list>
    <#else>
        <p class="text-muted">No saved recipes yet.</p>
    </#if>
</div>

</body>
</html>


