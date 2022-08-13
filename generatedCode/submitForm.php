<?php
    session_start();
?>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"submission about HTML"</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<body>
<img style ='  background-position: center;
                 background-repeat: no-repeat;
                 background-size: cover;
                 pointer-events: none; position: absolute; width: 100%; height: 100%; z-index: -1;'  src= "https://i.pinimg.com/originals/7a/0d/e2/7a0de2c425b99bd0f4490e1480fa89e5.jpg" width= 100 height= 100>

<div style= "font-size:30px; color: #e9967a ;  position: relative; font-size:30px ;  text-align: center; font-weight: bold; line-height: 2; padding-top: 50px; padding-left: 450px; padding-right: 450px;
                                        background-image: linear-gradient(to bottom, rgba(140, 140, 140, 1) 0%, rgba(0, 0, 0, 1) 100%), linear-gradient(to bottom, rgba(0, 0, 0, 1) 0%, rgba(0, 0, 0, 1) 100%);
                                        background-clip: content-box; ">YOUR OPINION...</div>

<form action= "submission.php" method="post"  style ='text-align: center; padding-left: 450px; padding-right: 450px;
                             background-image: linear-gradient(to bottom, rgba(3, 0, 0, 1) 0%, rgba(50,0,0,1) 100%), linear-gradient(to bottom, rgba(3,0,0,1) 0%, rgba(3,0,0,1) 100%);
                             background-clip: content-box;' ><label for= "user"></label>
<input type= "text" style =' opacity: 0.5;' id= "user" name= "user" placeholder= " enter your name">
<ol>
</ol>
<label   style= "color: white;"  for= "HTMLusing">start using HTML at: </label>
<input type="date" id ="HTMLusing"name= "HTMLusing" value=<?php echo '2018-07-22' ?>  >
<div style= "font-size:16px; color: #ffffff ;   ">browsers you use: </div>
<div class="form-check">
<input class="form-check-input" type="checkbox" name= "browser1" value=<?php echo 'chrome' ?> id ="browser1">
<label   style= "color: white;"  class="form-check-label" for= "browser1">chrome</label>
</div>
<div class="form-check">
<input class="form-check-input" type="checkbox" name= "browser2" value=<?php echo 'edge' ?> id ="browser2">
<label   style= "color: white;"  class="form-check-label" for= "browser2">edge</label>
</div>
<div class="form-check">
<input class="form-check-input" type="checkbox" name= "browser3" value=<?php echo 'firefox' ?> id ="browser3">
<label   style= "color: white;"  class="form-check-label" for= "browser3">firefox</label>
</div>
<div class="form-check">
<input class="form-check-input" type="checkbox" name= "browser4" value=<?php echo 'opera' ?> id ="browser4">
<label   style= "color: white;"  class="form-check-label" for= "browser4">opera</label>
</div>
<div style= "font-size:16px; color: #ffffff ;   ">editor you use: </div>
<select name= "selectIDE" id= "selectIDE" multiple>
<option value= <?php echo 'vsCode' ?> >vs code</option>
<option value= <?php echo 'sublime' ?> >sublime</option>
<option value= <?php echo 'notepad' ?> >notepad</option>
<option value= <?php echo 'Brackets' ?> >Brackets</option>
<option value= <?php echo 'other' ?> >Other</option>
</select>
<div style= "font-size:16px; color: #ffffff ;   ">your laptop brand: </div>
<div class="form-check">
<input class="form-check-input" type="radio" name= laptopBrand id =laptopBrand value=ASUS>
<label class="form-check-label"   style= "color: white;" for= laptopBrand>ASUS</label>
</div>
<div class="form-check">
<input class="form-check-input" type="radio" name= laptopBrand id =laptopBrand value=Lenovo>
<label class="form-check-label"   style= "color: white;"  style= "color: white;" for= laptopBrand>Lenovo</label>
</div>
<div class="form-check">
<input class="form-check-input" type="radio" name= laptopBrand id =laptopBrand value=HP>
<label class="form-check-label"   style= "color: white;"  style= "color: white;"  style= "color: white;" for= laptopBrand>HP</label>
</div>
<div class="form-check">
<input class="form-check-input" type="radio" name= laptopBrand id =laptopBrand value=Other>
<label class="form-check-label"   style= "color: white;"  style= "color: white;"  style= "color: white;"  style= "color: white;" for= laptopBrand>Other</label>
</div>
<button type ='submit' class= "btn btn-primary" onclick= "console.log('button clicked')" >submit</button>
</form>

</body>
</html>