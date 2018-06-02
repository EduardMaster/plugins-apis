
<?php
error_reporting(0);
include ( '../db_con.php' );
$player = mysql_real_escape_string(addslashes($_GET['player']));

if(strlen($player) < 2){
	return;
}

$sql = 'SELECT player,sum(kills) as tkills ,sum(death) as tdeath,sum(time) as ttime, sum(points) as total_points , sum(position) as tpos, sum(position = 1) as wins, count(*) as tgames FROM '.$dbprefix.'playerstats WHERE player LIKE \'%'.$player.'%\' GROUP BY player ORDER BY total_points desc LIMIT 500';

$result = mysql_query($sql);
echo mysql_error();
$index = ($p * $per_page)+1;
echo '<center><table id="ldr_table"><tr class="lb_tb_hd" align="center"><td>Position</td><td>Player</td><td>Points</td><td>Wins</td><td>Avg Finish</td><td>Kills</td><td>Deaths</td><td>K/D</td><td>Games Played</td><td>Time Ingame</td></tr>';
while($row = mysql_fetch_array($result)){

	

	echo '<tr class="ldr_alt',($index%2) + 1,'"><td>',getRank($row['player']),'</td>';

	echo '<td><a href="index.php?page=player&player=',$row['player'],'">',$row['player'],'</a></td>';
	echo '<td>',$row['total_points'], '</td>';
	echo '<td>',$row['wins'],'</td>';
	echo '<td>',round($row['tpos'] / $row['tgames'], 2),'</td>';
	echo '<td>',$row['tkills'],'</td>';
	echo '<td>',$row['tdeath'],'</td>';
	echo '<td>',round($row['tkills']/$row['tdeath'], 2),'</td>';
	echo '<td>',$row['tgames'],'</td>';
	$hours = round($row['ttime']/ (1000*60*60),0);
	$min = round(($row['ttime']% (1000*60*60)) / (1000*60),0);
	$sec = round((($row['ttime']% (1000*60*60)) % (1000*60)) / 1000,0);
	

	echo '<td>',$hours,':',$min,':',(($sec<10)?'0':''),$sec,'</td>';
	echo '</tr>';

	$index++;

}
echo '</table>';
return;

function getRank($rank_search){
include ( '../db_con.php' );

$sql_rank = 'SELECT player, sum(points) as total_points FROM '.$dbprefix.'playerstats GROUP BY player ORDER BY total_points desc';

$result_rank = mysql_query($sql_rank);
echo mysql_error();

$rank = 1;
$finished = false;
$max = 5000;

while($rank<=$max AND $row=mysql_fetch_array($result_rank)){
	if($row['player'] == $rank_search){
		$finished = true;
		break;
	}
	$rank++;
}
return $rank;
}

?>