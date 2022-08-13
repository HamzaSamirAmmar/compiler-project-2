<?php
    session_start();
?>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"submission information"</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<body>
<div style= "font-size:24px; color: #000000 ;  font-weight: bold; line-height: 2; ">result of submission</div>
<div style= "font-size:16px; color: #000000 ;   "><?php echo $_SESSION['user']  ; ?></div>
<div style= "font-size:20px; color: #000000 ;  font-weight: bold; line-height: 1; ">start date of using html:</div>
<div style= "font-size:16px; color: #000000 ;   "><?php echo $_SESSION['HTMLusing']  ; ?></div>
<div style= "font-size:20px; color: #000000 ;  font-weight: bold; line-height: 1; ">browsers used:</div>
<div style= "font-size:16px; color: #000000 ;   "><?php echo $_SESSION['browser1']  ; ?></div>
<div style= "font-size:16px; color: #000000 ;   "><?php echo $_SESSION['browser2']  ; ?></div>
<div style= "font-size:16px; color: #000000 ;   "><?php echo $_SESSION['browser3']  ; ?></div>
<div style= "font-size:16px; color: #000000 ;   "><?php echo $_SESSION['browser4']  ; ?></div>
<div style= "font-size:20px; color: #000000 ;  font-weight: bold; line-height: 1; ">editor used:</div>
<div style= "font-size:16px; color: #000000 ;   "><?php echo $_SESSION['selectIDE']  ; ?></div>
<div style= "font-size:20px; color: #000000 ;  font-weight: bold; line-height: 1; ">laptop used:</div>
<div style= "font-size:16px; color: #000000 ;   "><?php echo $_SESSION['laptopBrand']  ; ?></div>
</body>
</html>