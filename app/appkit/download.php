<?php
include("../config/connection.php");
include("../config/table.php");


	$a = mysql_query ("select * from ".Tstudy_material);

	while ($b = mysql_fetch_array($a))
	{
		$c[] = array (
				"sm_userid"=> $b['sm_userid'],
				"sm_type"=>	$b['sm_type'],
				"sm_file"=>	$b['sm_file'],
				"sm_category"=>	$b['sm_category'],
				"sm_course_id"=>$b['sm_course_id'],
				"sm_branch_id"=>	$b['sm_branch_id'],
				"sm_year_id"=>	$b['sm_year_id'],
				"sm_semester_id"=>	$b['sm_semester_id'],
				"sm_subject_id"=>	$b['sm_subject_id'],
				"sm_datetime"=>	$b['sm_datetime']
		);
	}
	echo '{"'.Tstudy_material.'"'.":";
	echo json_encode ($c);
	echo "}";


?>