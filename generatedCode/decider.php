<?php 
include 'util/checkValid.php';
include 'util/checkRole.php';
include 'util/checkAuth.php';
include 'util/redirect.php';
session_start();
$x = 3.0;
for ($i = 0.0;
$i<3.0;$i++) {
$x++;

}if ($x>3.0&&$_SESSION['variable']>3.0) {
redirect("result");

}