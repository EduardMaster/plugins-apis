<?php
/*
*
*More options will come to this later like game search and sorts
*
*/

$per_page = 20;
$p    = mysql_real_escape_string(addslashes($_GET['p']));
$game    = mysql_real_escape_string(addslashes($_GET['game']));
$sort     = mysql_real_escape_string(addslashes($_GET['sort']));
$mode = $_GET['mode'];
if(trim($sort) == "")
	$sort = 'total_points';
if($mode == "raw"){
	$per_page = 1000000000000000;
}
if(trim($game) == ""){
	$sql = 'SELECT * FROM '.$dbprefix.'gamestats LIMIT '.($p*$per_page).','.$per_page;
}
else{
		$sql = 'SELECT * FROM '.$dbprefix.'gamestats WHERE gameno = '.$game;
}
$result = mysql_query($sql);
echo '<table id="ldr_table"><tr class="lb_tb_hd" align="center"><td>Game #</td><td>Arena ID</td><td>Players #</td><td>Winner</td><td>Players</td><td>Time</td></tr>';
$index = ($p * $per_page)+1;
while($row = mysql_fetch_array($result)){
	$gameno = (($gameno == 1)?0:$row['gameno']);
	$sql2 = 'SELECT player FROM '.$dbprefix.'playerstats WHERE gameno = '.$gameno;
	echo mysql_error();
	$result2 = mysql_query($sql2);
	$player = '';
	while($row2 = mysql_fetch_array($result2)){
		$player = $player. ' <a href="index.php?page=player&player='.$row2['player'].'">'.$row2['player'].'</a> ';
	}
	echo '<tr class="ldr_alt',($index%2) + 1,'">';
	echo '<td>'.$row['gameno'].'</td>';
	echo '<td>'.$row['arenaid'].'</td>';
	echo '<td>'.$row['players'].'</td>';
	echo '<td>'.$row['winner'].'</td>';
	echo '<td>'.$player.'</td>';
		$hours = round($row['time']/ (1000*60*60),0);
	$min = round(($row['time']% (1000*60*60)) / (1000*60),0); 
	$sec = round((($row['time']% (1000*60*60)) % (1000*60)) / 1000,0);
	

	echo '<td>',$hours,':',(($min<10)?'0':''),$min,':',(($sec<10)?'0':''),$sec,'</td>';
	echo '</tr>';

	$index++;
}
echo '</table>';
echo '</table>';
echo '<table id="prev_next" align="center"><tr>';
if($p != 0 )
	echo '<td><a href="index.php?page=gamehistory&p=',$p-1,'">Previous</a></td>';
	echo '<td><a href="index.php?page=gamehistory&p=',$p+1,'">Next</a></td></td></table>';
?>