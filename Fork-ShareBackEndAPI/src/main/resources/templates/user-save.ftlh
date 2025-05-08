<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Save Recipes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
<header class="text-center p-3">
    <h1>Fork and Share</h1>
</header>

<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #414b3b;">
    <a class="navbar-brand" href="/home">Home</a>
    <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="/chefs/all">Chefs</a></li>
            <li class="nav-item"><a class="nav-link" href="/users/all">Users</a></li>
            <li class="nav-item"><a class="nav-link" href="/recipes/all">Recipes</a></li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <h3 class="mb-4">Save a Recipe for a User</h3>

    <#list recipeList as recipe>
        <div class="card mb-3">
            <div class="card-body">
                <h5 class="card-title">${recipe.name}</h5>
                <p class="card-text">${recipe.description}</p>

                <form action="/users/save-recipe" method="post" class="form-inline">
                    <input type="hidden" name="recipeId" value="${recipe.recipeID}">

                    <div class="form-group mr-2">
                        <label for="user-${recipe.recipeID}" class="mr-2">Select User:</label>
                        <select name="userId" id="user-${recipe.recipeID}" class="form-control">
                            <option selected disabled>Choose...</option>
                            <#list userList as user>
                                <option value="${user.userID}">${user.username}</option>
                            </#list>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </#list>
</div>

</body>
</html>