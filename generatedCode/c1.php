<?php 
include 'util/checkValid.php';
include 'util/checkRole.php';
include 'util/checkAuth.php';
include 'util/redirect.php';
session_start();
$name = $_POST['user'];
$password = $_POST['password'];
$s = checkValid($name , $password );;
if($s) {
redirect("posts");

}else {
redirect("registerPage");

}