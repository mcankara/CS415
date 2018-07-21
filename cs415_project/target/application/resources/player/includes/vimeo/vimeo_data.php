<?php

require_once("vimeo_api.php");

if(IsNullOrEmpty($vimeo_key) || IsNullOrEmpty($vimeo_secret) || IsNullOrEmpty($vimeo_token)) exit("PHP Vimeo access information missing!");

function IsNullOrEmpty($v){
	return (!isset($v) || trim($v)==='');
}

$type = $_REQUEST['type'];
$page = isset($_REQUEST['page']) ? $_REQUEST['page'] : null;
$perPage = isset($_REQUEST['perPage']) ? $_REQUEST['perPage'] : null;
$path = isset($_REQUEST['path']) ? $_REQUEST['path'] : null;
$user = isset($_REQUEST['user']) ? $_REQUEST['user'] : null;
$sort = isset($_REQUEST['sort']) ? $_REQUEST['sort'] : 'date';
$sortDirection = isset($_REQUEST['sortDirection']) ? $_REQUEST['sortDirection'] : 'asc';



require("autoload.php");
use Vimeo\Vimeo;
$vimeo = new Vimeo($vimeo_key, $vimeo_secret, $vimeo_token);



if($type == 'next_page'){//resume

	$result = $vimeo->request($path);

}else{

	if($type == 'vimeo_channel'){

		//Get a list of videos in a Channel - https://developer.vimeo.com/api/playground/channels/{channel_id}/videos
		$result = $vimeo->request("/channels/$path/videos", array(
														'page'=> $page,
														'per_page' => $perPage,
														'fields' => 'uri,name,description,duration,width,height,privacy,pictures.sizes',
														'sort' => $sort,
														'direction' => $sortDirection,								
														'filter' => 'embeddable',
														'filter_embeddable' => 'true'
														));

	}else if($type == 'vimeo_group'){														
													
		//Get a list of videos in a Group - https://developer.vimeo.com/api/playground/groups/{group_id}/videos
		$result = $vimeo->request("/groups/$path/videos", array(
														'page'=> $page,
														'per_page' => $perPage,
														'fields' => 'uri,name,description,duration,width,height,privacy,pictures.sizes',
														'sort' => $sort,
														'direction' => $sortDirection,						
														'filter' => 'embeddable',
														'filter_embeddable' => 'true'
														));
		
	}else if($type == 'vimeo_user_album'){	
		
		//Get the list of videos in an Album - https://developer.vimeo.com/api/playground/users/{user_id}/albums/{album_id}/videos
		$result = $vimeo->request("/users/$user/albums/$path/videos", array(
														'page'=> $page,
														'per_page' => $perPage,
														'fields' => 'uri,name,description,duration,width,height,privacy,pictures.sizes',
														'sort' => $sort,
														'direction' => $sortDirection,							
														'filter' => 'embeddable',
														'filter_embeddable' => 'true'
														));
										
	}else if($type == 'vimeo_video_query'){	
													
		//Search for videos - https://developer.vimeo.com/api/playground/videos
		$result = $vimeo->request("/videos", array(
														'page'=> $page,
														'per_page' => $perPage,
														'fields' => 'uri,name,description,duration,width,height,privacy,pictures.sizes',
														'sort' => $sort,
														'direction' => $sortDirection,										
														'query' => $path
														));
														
	}else if($type == 'vimeo_single'){	

		//Get a video - https://developer.vimeo.com/api/playground/videos/{video_id}
		$result = $vimeo->request("/videos/$path", array(
														'fields' => 'uri,name,description,duration,width,height,privacy,pictures.sizes'
														));
	}

}

echo json_encode($result);


?>