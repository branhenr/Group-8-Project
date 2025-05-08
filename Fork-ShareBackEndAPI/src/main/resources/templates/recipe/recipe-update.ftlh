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

<!-- start of update form -->

<h3>Update details of Recipe</h3>
<div class="container">
    <form id="update-recipe" action="/recipes/update/${recipe.recipeId}" method="post">
        <div class = "form-group">
            <label for = "name" > name</label>
            <input type = "text" id ="name" name = "name" value="${recipe.name}" placeholder="Name" class = "form-control">
        </div>


        <div class = "form-group">
            <label for = "prepTime" > Preparation Time</label>
            <input type = "number" id ="prepTime" name = "prepTime" value="${recipe.prepTime}" placeholder="prepTime" class = "form-control">
        </div>


        <div class = "form-group">
            <label for = "description" > description</label>
            <input type = "text" id ="description" name = "description" value="${recipe.description}" placeholder="description" class = "form-control">
        </div>

        <div class = "form-group">
            <label for = "ingredients" > ingredients</label>
            <input type = "text" id ="ingredients" name = "ingredients" value="${recipe.ingredients}" placeholder="ingredients" class = "form-control">
        </div>

        <div class = "form-group">
            <label for = "instructions" > instructions</label>
            <input type = "text" id ="instructions" name = "instructions" value="${recipe.instructions}" placeholder="instructions" class = "form-control">
        </div>


        <div class = "form-group">
            <label for = "diet" > diet</label>
            <input type = "text" id ="diet" name = "diet" value="${recipe.diet}" placeholder="diet" class = "form-control">
        </div>

        <div class = "form-group">
            <label for = "chef" > chef</label>
            <input type = "text" id ="chef" name = "chef" value="${recipe.chef.chefId}" readonly placeholder="chef" class = "form-control">
        </div>

        <button type="submit" class="btn btn-primary btn-block"> Update </button>

    </form>
</div>

<!-- End of update form -->

</body>

</html>