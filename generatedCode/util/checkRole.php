<?php
include 'rolesConfig.php';

function checkRole($role) {
    $usersRoles=$GLOBALS['usersRoles'];
    $authorized=false;
    if(in_array($role,$usersRoles[$_SESSION['user']]))
    {
        $authorized=true;
    }
    return $authorized;
}