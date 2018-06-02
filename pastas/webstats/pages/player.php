

<?php
error_reporting(0);
//require_once( '../db_con.php' );



$per_page = 30;
$p    = mysql_real_escape_string(addslashes($_GET['p']));
$player = mysql_real_escape_string(addslashes($_GET['player']));


if($player != ""){


//couldn't get this to work so we have to resort to less efficient loops for now
//$sql_rank = '(SELECT count(*) as rank, sum (points) as tpoints from '.$dbprefix.'playerstats GROUP BY player where tpoints  < (SELECT sum(points) as tpoints from '.$dbprefix."playerstats GROUP BY player WHERE player = '$player'))";
 
$sql_rank = 'SELECT player, sum(points) as total_points FROM '.$dbprefix.'playerstats GROUP BY player ORDER BY total_points desc';

$sql_data = 'SELECT  sum(points) as tpoints, sum(kills) as tkills ,sum(death) as tdeaths,sum(time) as ttime, sum(points) as tpoints, sum(position = 1) as wins, sum(position) as tpos, count(*) as tgames FROM '.$dbprefix."playerstats  WHERE player = '$player'";


$result_rank = mysql_query($sql_rank);
$result_data = mysql_query($sql_data);
$data = mysql_fetch_array($result_data);


$rank = 1;
$finished = false;
$max = 5000;

while($rank<=$max AND $row=mysql_fetch_array($result_rank)){
	if($row['player'] == $player){
		$finished = true;
		break;
	}
	$rank++;
}
echo '<center>';
echo '<table style="font-size: 25px; " align="center"><tr><td><img src="pages/skin_gen.php?player='.$player.'"></td><td>';
echo '<table style="font-size: 25px; " align="center"><tr><td><span style="text-decoration:underline; font-size: 30px;">'."$player</td><td></tr><table style='font-size: 25px; ' align='center'><tr><td>";
echo "<tr><td>Rank:</td><td> $rank</td></tr>";
echo '<tr><td>Points:</td><td>'. $data['tpoints'].'</td></tr>';
echo '<tr><td>Games:</td><td>'. $data['tgames'].'</td></tr>';
echo '<tr><td>Wins:</td><td>'. $data['wins'].'</td></tr>';
echo '<tr><td>Avg Finish:</td><td>'. round($data['tpos']/$data['tgames'],2).'</td></tr>';
echo '<tr><td>W/L:</td><td>'.  (round($data['wins']/$data['tgames'],2)*100).'%</td></tr>';
echo '<tr><td>K/D:</td><td>'.  round($data['tkills']/$data['tdeaths'],2).'</td></tr>';
echo '<tr><td>Kills:</td><td>'. $data['tkills'].'</td></tr>';
echo '<tr><td>Deaths:</td><td>'. $data['tdeaths'].'</td></tr>';
echo '<tr><td>Time: </td><td>';
$hours = round($data['ttime']/ (1000*60*60),0);
$min = round(($data['ttime']% (1000*60*60)) / (1000*60),0);
$sec = round((($data['ttime']% (1000*60*60)) % (1000*60)) / 1000,0);

echo $hours,':',$min,':',(($sec<10)?'0':''),$sec,'</td></tr>';
echo "</table></td></tr></table></td></tr></table>";


echo '<center><table id="ldr_table"><tr class="pl_tb_hd" align="center"><td>Game</td><td>GameID</td><td>Arena ID</td><td>Position</td><td>Points</td><td>Kills</td><td>Killed</td><td>Time Ingame</td></tr>';

$sql = "SELECT * FROM $dbprefix"."playerstats  WHERE `player` = '$player' ORDER BY gameno ASC
LIMIT ".($p*$per_page).','.$per_page;
$result = mysql_query($sql);
echo mysql_error();
$index = ($p * $per_page)+1;
while($row = mysql_fetch_array($result)){

	echo '<tr class="ldr_alt',($index%2) + 1,'"><td>',$index,'</td>';

	echo '<td>',$row['gameno'],'</td>';
	echo '<td>',$row['arenaid'],'</td>';
	echo '<td>',$row['position'],'</td>';
	echo '<td>',$row['points'],'</td>';
	echo '<td>',$row['kills'],'</td>';
	echo '<td width="150">',str_replace(':',' ',$row['killed']),'</td>';
	$hours = round($row['ttime']/ (1000*60*60),0);
	$min = round(($row['time']% (1000*60*60)) / (1000*60),0);
	$sec = round((($row['time']% (1000*60*60)) % (1000*60)) / 1000,0);
	

	echo '<td>',$hours,':',$min,':',(($sec<10)?'0':''),$sec,'</td>';
	
	$index++;
}

echo '</table>';
echo '<table id="prev_next" align="center"><tr>';

if($p != 0 )
	echo '<td><a href="index.php?page=player&player=',$player,'&p=',$p-1,'">Previous</a></td>';
	echo '<td><a href="index.php?page=player&player=',$player,'&p=',$p+1,'">Next</a></td></td></table>';
	
}
else{
echo '<center style="margin-top:10px;"><form onSubmit="return false;">
<input style="width:230px; height: 25px; margin-bottom: 5px;background: #bbb; border: 1px solid #fff; border-radius: 3px;" id="searchInput" type="text" value="Search for a player" onkeyup="search(this.value)" onclick="this.value=\'\'">
</form>';

echo '<div id="livesearch"></div>';
}
?> 

