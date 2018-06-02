<?php
//require_once( '../db_con.php' );

$per_page = 50;
$p    = mysql_real_escape_string(addslashes($_GET['p']));
$sort     = mysql_real_escape_string(addslashes($_GET['sort']));
$mode = $_GET['mode'];
if(trim($sort) == "")
	$sort = 'total_points';
if($mode == "raw"){
	$per_page = 1000000000000000;
}

$sql = 'SELECT `player`,sum(kills) as tkills ,sum(death) as tdeath,sum(time) as ttime, sum(points) as total_points , sum(position) as tpos, sum(position = 1) as wins, count(*) as tgames, sum(position)/count(*) as avgpos,sum(kills)/sum(death) as kd FROM '.$dbprefix.'playerstats GROUP BY player ORDER BY '.$sort.' desc LIMIT '.($p*$per_page).','.$per_page;

//echo $sql;

$result = mysql_query($sql);
echo mysql_error();
echo '<center><table id="ldr_table"><tr class="lb_tb_hd" align="center">
<td>Position</td>
<td><a href="index.php?page=leaderboard&sort=player">Player</a></td>
<td><a href="index.php?page=leaderboard&sort=total_points">Points</a></td
><td><a href="index.php?page=leaderboard&sort=wins">Wins</a></td>
<td><a href="index.php?page=leaderboard&sort=avgpos">Avg Finish</a></td>
<td><a href="index.php?page=leaderboard&sort=tkills">Kills</a></td>
<td><a href="index.php?page=leaderboard&sort=tdeath">Deaths</a></td>
<td><a href="index.php?page=leaderboard&sort=kd">K/D</td>
<td><a href="index.php?page=leaderboard&sort=tgames">Games Played</a></td>
<td><a href="index.php?page=leaderboard&sort=ttime">Time Ingame</a></td></tr>';
$index = ($p * $per_page)+1;
while($row = mysql_fetch_array($result)){



	echo '<tr class="ldr_alt',($index%2) + 1,'"><td>',$index,'</td>';

	echo '<td><a href="index.php?page=player&player=',$row['player'],'">',$row['player'],'</a></td>';
	echo '<td>',$row['total_points'], '</td>';
	echo '<td>',$row['wins'],'</td>';
	echo '<td>',round($row['avgpos'], 2),'</td>';
	echo '<td>',$row['tkills'],'</td>';
	echo '<td>',$row['tdeath'],'</td>';
	echo '<td>',round($row['kd'], 2),'</td>';
	echo '<td>',$row['tgames'],'</td>';
	$hours = round($row['ttime']/ (1000*60*60),0);
	$min = round(($row['ttime']% (1000*60*60)) / (1000*60),0); 
	$sec = round((($row['ttime']% (1000*60*60)) % (1000*60)) / 1000,0);
	

	echo '<td>',$hours,':',(($min<10)?'0':''),$min,':',(($sec<10)?'0':''),$sec,'</td>';
	echo '</tr>';

	$index++;

}
echo '</table>';
echo '<table id="prev_next" align="center"><tr>';
if($p != 0 )
	echo '<td><a href="index.php?page=leaderboard&p=',$p-1,'">Previous</a></td>';
	echo '<td><a href="index.php?page=leaderboard&p=',$p+1,'">Next</a></td></td></table>';

?>
	
