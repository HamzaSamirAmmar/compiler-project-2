<?php 
function redirct($targetPageId){
header("Location:".$targetPageId.'.php');
exit;
}