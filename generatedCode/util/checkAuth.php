<?php
function checkAuth() {
    if(isset( $_SESSION['user']))
        return true;
    else 
        return false;
}