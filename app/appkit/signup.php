<?php
include("../config/connection.php");
include("../config/table.php");
$d= "select * from ".Tstudy_users." where user_email_id = '".$_REQUEST['userid']."'";
$exe=mysql_query($d);
$e=mysql_num_rows($exe);
if($e==0){
	$a = mysql_query ("insert into ".Tstudy_users." set
		        user_name='".$_REQUEST['username']."',
				user_email_id='".$_REQUEST['userid']."',
				user_password='".$_REQUEST['password']."',
				user_pic='".$_REQUEST['pic']."', 
				user_state='".$_REQUEST['state']."',
				user_city='".$_REQUEST['city']."',
				user_college='".$_REQUEST['college']."',
				user_mobile_no='".$_REQUEST['phone']."',
				user_country='".$_REQUEST['country']."',
				user_course='".$_REQUEST['course']."',
				user_branch='".$_REQUEST['branch']."',
				user_year='".$_REQUEST['year']."',
				user_semester='".$_REQUEST['semester']."'
				");
	

		$c = 'signup successful';
		 echo '{"'.Tstudy_users.'"'.":";
		echo json_encode ($c);
		echo "}";
}
else {
	$re = 'signup failed';
	echo json_encode ($re);
}
?>