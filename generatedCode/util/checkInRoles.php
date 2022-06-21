<?php
include 'rolesConfig.php';

function checkInRoles($roles) {
    $usersRoles=$GLOBALS['usersRoles'];
    $authorized=false;
    foreach($roles as $role){
        if(isset($_SESSION['user']))
        { 
            if(in_array($role,$usersRoles[$_SESSION['user']]))
            {
                $authorized=true;
            }
        }
    }   
    return $authorized;
}