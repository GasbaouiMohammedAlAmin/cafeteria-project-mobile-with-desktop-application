<?php
error_reporting(0);
require "config.php";

//------------------------------------
$query1 = "SELECT * FROM `products`";

$id=" ";
$designation="";
$price=" ";
$description=" ";



		$result= mysqli_query($con,$query1);
if(mysqli_num_rows($result)>0){
              while($re=mysqli_fetch_array($result)){


$id=$id. $re[0].'*';

$designation=$designation. $re[1].'*';
$price=$price.$re[2].'*';
$description=$description. $re[3].'*';

                             }
$json['id'] =  $id;
		
$json['designation'] =  $designation;
		
$json['price'] =  $price;
		
$json['description'] =  $description;
	echo json_encode($json);	

/*
echo $id."</br>";
echo $designation."</br>";

echo $price."</br>";

echo $description."</br>";*/
}else{  $json['error'] =  "no response";echo json_encode($json);

}



?>