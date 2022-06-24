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
<form action= "c1".php method="get" ><div class="form-check">
<input class="form-check-input" type="checkbox" name= "Default checkbox" value=<?php echo 3.0 ?> id ="Default checkbox">
<label class="form-check-label" for= "Default checkbox">flexCheckDefault</label>
</div>
<label for= "start date">start</label>

<input type="date" id ="start date"name= "start date" value=<?php echo 22.0-7.0-2018.0 ?> >
<ol>
<li><a href= 'www.google.com'>
<div style= "font-size:30px; color: #050000 ;   ">hello</div>
</a>
</li>
<li><img src= "https://cdn.pixabay.com/photo/2015/09/16/08/55/online-942408_960_720.jpg" width= 50 height= 50>
</li>
</ol>
<label for= "myField">enter your name</label>
<input type= "text"id= "myField" name= "myField" value= " theValue">
<ol>
</ol>
<select name= "select your favorite" id= "select your favorite" multiple>
<option value= <?php echo 'algo' ?> >book</option>
<option value= <?php echo 'wimpy' ?> >story</option>
</select>
<div class="form-check">
<input class="form-check-input" type="radio" name= newRadio id =newRadio>
<label class="form-check-label" for= newRadio>book1</label>
</div>
<div class="form-check">
<input class="form-check-input" type="radio" name= newRadio id =newRadio>
<label class="form-check-label" for= newRadio>story1</label>
</div>
<button type ='submit' class= "btn btn-primary" formaction= "/compiler_tests/c1.php" >submit</button>
</form>
<?php $_SESSION['x']=3.0 ?>
<?php $_SESSION['v']=$_SESSION['x'] ?>
<?php $_SESSION['g']='this is a string' ?>
<table class="table">
<tr>
<th><div style= "font-size:20px; color: #050000 ;   ">name</div>
</th>
<th><div style= "font-size:20px; color: #050000 ;   ">pic</div>
</th>
</tr>
<tr>
<td><div style= "font-size:20px; color: #050000 ;   ">rama</div>
</td>
<td><img src= "https://cdn.pixabay.com/photo/2015/09/16/08/55/online-942408_960_720.jpg" width= 50 height= 50>
</td>
</tr>
<tr>
</tr>
</table>
</body>
</html>