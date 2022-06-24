<?php
include 'usersConfig.php';

function checkValid($userName,$password) {
    global $users;
    $valid=false;
    if($users[$userName]==$password)
        $valid=1;
    $_SESSION['user']=$userName;
    return $valid;
}