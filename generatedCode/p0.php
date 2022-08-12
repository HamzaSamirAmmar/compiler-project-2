<?php
    session_start();
?>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"Login Form Design"</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<body>
<img style ='  background-position: center;
                                  background-repeat: no-repeat;
                                  background-size: cover;
                                  pointer-events: none; position: absolute; width: 100%; height: 100%; z-index: -1;'  src= "https://i.pinimg.com/736x/5c/2b/29/5c2b2971110912a5de3afc97f25e909b--black-and-white-wallpaper.jpg" width= 50 height= 50>

<div style= "font-size:30px; color: #ffffff ;  position: relative; font-size:30px ;  text-align: center; font-weight: bold; line-height: 2; padding-top: 200px; padding-left: 450px; padding-right: 450px;
                                        background-image: linear-gradient(to bottom, rgba(140, 140, 140, 1) 0%, rgba(0, 0, 0, 1) 100%), linear-gradient(to bottom, rgba(0, 0, 0, 1) 0%, rgba(0, 0, 0, 1) 100%);
                                        background-clip: content-box; ">Login</div>

<form action= "c1.php" method="post"  style ='text-align: center; padding-left: 450px; padding-right: 450px;
                             background-image: linear-gradient(to bottom, rgba(0, 0, 0, 1) 0%, rgba(0,0,0,1) 100%), linear-gradient(to bottom, rgba(0,0,0,1) 0%, rgba(0,0,0,1) 100%);
                             background-clip: content-box;' ><label for= "user"></label>
<input type= "text" style =' opacity: 0.5;' id= "user" name= "user" placeholder= " enter your name">
<ol>
</ol>
<label for= "password"></label>
<input type= "text" style =' opacity: 0.5;' id= "password" name= "password" placeholder= " enter your password">
<ol>
</ol>
<button type ='submit' class= "btn btn-primary" >submit</button>
<ol>
</ol>
<div style= "font-size:11px; color: #ffffff ;   ">not yet a member?  </div>
<a href= 'registerPage.php'>
<div style= "font-size:12px; color: #ffffff ;   ">register</div>
</a>
</form>

</body>
</html>