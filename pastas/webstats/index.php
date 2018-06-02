<?php require_once( 'db_con.php' ); error_reporting(0); ?>
<html>
<head>
<title>SG: Stats</title>

<style>
@import url(style.css);
</style>
<script type="text/javascript">
function search(str)
{

if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("livesearch").innerHTML=xmlhttp.responseText;
    }
  }

xmlhttp.open("GET","pages/search.php?player="+str,true);
xmlhttp.send();
}
</script>
</head>
<body>
<div id="page">
	<div id="wrap">
		<div id="header">
			<div id="topbar">
				<ul>
					<li>
						<a href="http://mc-sg.org/forum">Home</a>
					</li>
					<li>
						<a href="index.php?page=player">Search Players</a>
					</li>
					<li>
						<a href="index.php?page=leaderboard">Leader Board</a>
					</li>
					<li>
						<a href="index.php?page=gamehistory">Game History</a>
					</li>

			</div>
		</div>
		<div id="main">
			<div id="page-title">
			
			</div>
			<div id="main-content">
				<?php include (!isset($_GET['page'])?'pages/home.php' : 'pages/'.$_GET['page'].'.php'); ?>
			</div>
		</div>
		<div id="footer">
		<?php
			$sql  = 'SELECT count(*) as tplayed, sum(time) as ttime, sum(points) as tpoints, count(DISTINCT player) as tplayers FROM '.$dbprefix.'playerstats';
			$sql2 = 'SELECT count(*) as games FROM '.$dbprefix.'gamestats';
	
			$result = mysql_fetch_array(mysql_query($sql));
			$result2 = mysql_fetch_array(mysql_query($sql2));
			echo mysql_error();
			echo '<center>'.number_format($result2['games']).' games have been played by '.number_format($result['tplayers']).' players who have played '.number_format($result['tplayed']).' times for a total of ';
			
			$day = round($result['ttime']/ 86400000,2);
			echo $day . ' days in playing time and a total of '.number_format($result['tpoints']). ' points';
		?>
			
		
		
		
		</div>		
	</div>
</div>
</body>
</html>
			