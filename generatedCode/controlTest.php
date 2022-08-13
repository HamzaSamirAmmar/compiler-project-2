<?php
    session_start();
?>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"control"</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<body>
<?php $condition = true;
 ?>
<?php if($condition) : ?>
<div class ='alert alert-success' style= "font-size:20px; color: #ffffee ;   ">passed test</div>
<?php else : ?>
<div class ='alert alert-danger' style= "font-size:20px; color: #ffffee ;   ">did not pass test</div>

<?php endif; ?><?php $times = 3.0;
 ?>
<?php for($i = 0.0;
$i<$times;$i++) : ?>
<div class ='alert alert-info' style= "font-size:20px; color: #ffffee ;   ">repeated</div>

<?php endfor; ?><?php $name = 'Peter Pan';
 ?>
<?php switch ($name): ?>
<?php case 'Peter Pan': ?>
<div class ='alert alert-info' style= "font-size:20px; color: #ffffee ;   ">name is Peter Pan</div>

<?php break; ?><?php case 'Mr. Hook': ?>
<div class ='alert alert-info' style= "font-size:20px; color: #ffffee ;   ">name is Mr. Hook</div>

<?php break; ?>
<?php endswitch; ?><?php $_SESSION['variable']=4.0;
 ?>
<a href= "decider.php">
<div class ='btn btn-primary' style= "font-size:20px; color: #ffffee ;   ">run</div>
</a>
</body>
</html>