<?php
include("../config/connection.php");
include("../config/table.php");
if($_REQUEST['userid'] != "")
{
	$a = mysql_query ("select * from ".Tstudy_users." where user_email_id = '".$_REQUEST['userid']."' and user_password = '".$_REQUEST['upass']."'");
	
	while ($b = mysql_fetch_array($a))
	{
		$c[] = array (
				"name"=> $b['user_name']	
		);
	}
	 echo '{"'.Tstudy_users.'"'.":";
	echo json_encode ($c);
	echo "}";

}
else {
	$re = null;
	echo json_encode ($re);
}
?>