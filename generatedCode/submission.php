<?php 
include 'util/checkValid.php';
include 'util/checkRole.php';
include 'util/checkAuth.php';
include 'util/redirect.php';
session_start();
$_SESSION['user']=$_POST['user'];
$_SESSION['HTMLusing']=$_POST['HTMLusing'];
$_SESSION['browser1']=$_POST['browser1'];
$_SESSION['browser2']=$_POST['browser2'];
$_SESSION['browser3']=$_POST['browser3'];
$_SESSION['browser4']=$_POST['browser4'];
$_SESSION['selectIDE']=$_POST['selectIDE'];
$_SESSION['laptopBrand']=$_POST['laptopBrand'];
redirect("information");
