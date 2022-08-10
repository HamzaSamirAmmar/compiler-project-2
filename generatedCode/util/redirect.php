<?php 
function redirect($targetPageId){
header("Location:".$targetPageId.'.php');
exit;
}