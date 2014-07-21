<?php
include("../config/connection.php");
include("../config/table.php");
if($_REQUEST['sm_file'] != "")
{
if($_REQUEST['sm_type'] == "pic"){
$d= "select * from ".Tstudy_material." where sm_file = '".$_REQUEST['sm_file']."'";
$exe=mysql_query($d);
$e=mysql_num_rows($exe);}
if($e==0 || $_REQUEST['sm_type'] != "pic"){
//$rand=rand(2,10000000);
//$d=$rand.$_REQUEST['sm_file'];
$a = mysql_query ("insert into ".Tstudy_material." set
		        sm_userid='".$_REQUEST['sm_userid']."',
				sm_type='".$_REQUEST['sm_type']."',
				sm_file='".$_REQUEST['sm_file']."',
				sm_category='".$_REQUEST['sm_category']."', 
				sm_course_id='".$_REQUEST['sm_course_id']."',
				sm_branch_id='".$_REQUEST['sm_branch_id']."',
				sm_year_id='".$_REQUEST['sm_year_id']."',
				sm_semester_id='".$_REQUEST['sm_semester_id']."',
				sm_subject_id='".$_REQUEST['sm_subject_id']."',
				sm_datetime=now()
				");
				
		$c = 'success';
		 echo '{"'.Tstudy_material.'"'.":";
		echo json_encode ($c);
		echo "}";
		}
		else {
	$re = 'failed';
	echo json_encode ($re);
}
}

?>