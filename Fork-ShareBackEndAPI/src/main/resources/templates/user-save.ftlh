 <!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <title>Save Recipes</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" href="/css/style.css">
 </head>
 <body>

 <!-- Title -->
 <header class="text-center p-3">
     <h1>Fork and Share</h1>
 </header>

 <!-- Navbar -->
 <nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #414b3b;">
     <a class="navbar-brand" href="/home">Home</a>
     <div class="collapse navbar-collapse">
         <ul class="navbar-nav mr-auto">
             <li class="nav-item"><a class="nav-link" href="/chefs/all">Chefs</a></li>
             <li class="nav-item"><a class="nav-link" href="/users/all">Users</a></li>
             <li class="nav-item"><a class="nav-link" href="/recipes/all">Recipes</a></li>
             <li class="nav-item"><a class="nav-link" href="/users/saveForm">Save Recipes</a></li>
         </ul>
     </div>
 </nav>

 <!-- Recipe Cards -->
 <div class="container text-center">
     <div class="row">
         <#list recipeList as recipe>
             <div class="col-sm-4 mb-4">
                 <div class="card">
                     <img class="card-img-top" src="/images/default.jpg" alt="${recipe.name}">
                     <div class="card-body">
                         <h5 class="card-title">${recipe.name}</h5>
                         <p class="card-text">Prep Time: ${recipe.prepTime}</p>

                         <form action="/users/save-recipe" method="post">
                             <input type="hidden" name="recipeId" value="${recipe.recipeId}">
                             <div class="form-group">
                                 <label for="userId-${recipe.recipeId}">Select User</label>
                                 <select name="userId" class="form-control" id="userId-${recipe.recipeId}">
                                     <#list userList as user>
                                         <option value="${user.userID}">${user.username}</option>
                                     </#list>
                                 </select>
                             </div>
                             <button type="submit" class="btn btn-outline-primary btn-sm mt-2">Save</button>
                         </form>
                     </div>
                 </div>
             </div>
         </#list>
     </div>
 </div>
 </body>
 </html>