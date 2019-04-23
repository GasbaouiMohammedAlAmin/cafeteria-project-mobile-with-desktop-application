<?php
error_reporting(0);
require "config.php";

$command_msg= $_POST["command_msg"];
$total_price = $_POST["total_price"];
$n_table= $_POST["n_table"];


if(isset($command_msg)){

$sql = "INSERT INTO commands(command_msg,total_price,n_table)
 VALUES ('".$command_msg."','".$total_price."','".$n_table."');";
if(!mysqli_query($con, $sql)){
	echo '{"message":"Unable to save the data to the database."}';
} 
else {$json['ok'] =  "ok";echo json_encode($json);}
}

?>