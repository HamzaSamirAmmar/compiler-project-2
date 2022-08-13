<?php 
include 'util/checkValid.php';
include 'util/checkRole.php';
include 'util/checkAuth.php';
include 'util/redirect.php';
session_start();
$name = $_POST['user'];
$password = $_POST['password'];
$valid = checkValid($name , $password );;
$isAdmin = checkRole('admin');
if ($isAdmin&&$valid) {
redirect("adminDashboard");

}else {
if (!$valid) {
redirect("registerPage");

}else {
redirect("intruder");

}
}