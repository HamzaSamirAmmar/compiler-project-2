<?php
    session_start();
?>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"my posts"</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<body>
<?php $_SESSION['welcome']='welcome to this page';
 ?>
<?php $name = $_SESSION['name'];
 ?>
<div class ='alert alert-info' style= "font-size:20px; color: #ffffff ;   "><?php echo $_SESSION['welcome']  ; ?></div>
<a href= 'login.php'>
<div class ='btn btn-success' type ='submit' style= "font-size:15px; color: #ffffff ;  margin-left: 120px; margin-top: 20px; margin-bottom: 50px; ">go back</div>
</a>
<table class="table">
<tr>
<th><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">ID</div>
</th>
<th><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">title</div>
</th>
<th><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">created_at</div>
</th>
</tr>
<tr>
<td><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">1</div>
</td>
<td><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">hello my posts</div>
</td>
<td><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">2022-06-25 11:00:00</div>
</td>
</tr>
<tr>
<td><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">2</div>
</td>
<td><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">good news</div>
</td>
<td><div style= "font-size:20px; color: #050000 ;  margin-left: 120px; margin-top: 20px; ">2022-06-25 16:00:00</div>
</td>
</tr>
</table>
<?php
include 'util/checkAuth.php';
if(checkAuth()){?>
<?php 
                echo "i am logged in"
         ?>
<?php  } else { ?>
<?php 
                echo "i am not logged in"
         ?>
<?php } ?>
<?php
include 'util/checkInRoles.php';
if(checkInRoles( [ 'admin' ]  )){?>
<div class ='alert alert-success' style= "font-size:20px; color: #ffffff ;   ">i am an admin</div>
<?php  } else { ?>
<div class ='alert alert-danger' style= "font-size:20px; color: #ffffff ;   ">i am not an admin</div>
<?php } ?>
</body>
</html>