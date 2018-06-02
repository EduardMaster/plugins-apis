<?php
$dbhost='localhost'; // Host name
$dbuser='root'; // Mysql username
$dbpass=''; // Mysql password
$dbname='survivalgames'; // Database name
$dbprefix = 'sg_'; //Table Prefix








$con = mysql_connect($dbhost,$dbuser,$dbpass);

mysql_select_db($dbname);
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }
?>