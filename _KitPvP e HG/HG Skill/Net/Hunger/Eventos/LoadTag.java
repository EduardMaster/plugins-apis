package Net.Hunger.Eventos;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoadTag implements Listener {
	  
	  public static String getShortStr(String name) {
	  if (name.length() == 16) {
	  String shorts = name.substring(0, name.length() - 5);
	  return shorts;
	  }
	  
	  if (name.length() == 15) {
	  String shorts = name.substring(0, name.length() - 4);
	  return shorts;
	  }
	  return name;
	  }
	  
	  @EventHandler(priority = EventPriority.MONITOR)
	  public void Buycraft(PlayerInteractEvent e) {
	  Player p = e.getPlayer();
	  if(Net.Hunger.Main.PreGame) {
	  if ((p.getItemInHand().getType() == Material.EMERALD) && ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
	  p.chat("/buy");
	  }
	  }
	  }
	  
	  public static String getMod(String name) {
	  if (name.length() == 16) {
	  String shorts = name.substring(0, name.length() - 4);
	  return shorts;
	  }
	  if (name.length() == 15) {
	  String shorts = name.substring(0, name.length() - 3);
	  return shorts; 
	  }
	  if (name.length() == 14) {
	  String shorts = name.substring(0, name.length() - 2);
	  return shorts;
	  }
	  if (name.length() == 13) {
	  String shorts = name.substring(0, name.length() - 1); 
	  return shorts;
	  }
	  return name; 
	  }
	  
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void NomeNoTab(PlayerJoinEvent e) {
	  Player p = e.getPlayer();
	  String name = p.getName();
	  if (name.length() + 4 >= 16) {
	  name = name.substring(0, name.length() - 4);
	  }
	  if ((p.hasPermission("*"))) {
	  p.setPlayerListName("§4" + getMod(p.getName()));
	  p.setDisplayName("§4§lDono §4" + getShortStr(p.getName()));
	  return;
	  }
	  if(p.hasPermission("tag.pro")) {
	  p.setPlayerListName("§6" + getMod(p.getName()));
	  p.setDisplayName("§6§lPRO §6" + getShortStr(p.getName()));
	  return;
	  }
	  if(p.hasPermission("tag.coder")) {
	  p.setPlayerListName("§3" + getMod(p.getName()));
	  p.setDisplayName("§3§lDEV §3" + getShortStr(p.getName()));
	  return;
	  }
	  if (p.hasPermission("tag.normal")) {
	  p.setPlayerListName(ChatColor.RESET + getMod(p.getName()));
	  p.setDisplayName(ChatColor.RESET + getShortStr(p.getName()));
	  return;
	  }
	  if (p.hasPermission("tag.mvp")) {
	  p.setPlayerListName("§9" + getMod(p.getName()));
	  p.setDisplayName("§9§lMVP §9" + getShortStr(p.getName()));
	  return;
	  }
	  if (p.hasPermission("tag.vip")) {
	  p.setPlayerListName("§a" + getMod(p.getName()));
	  p.setDisplayName("§a§lVIP §a" + getShortStr(p.getName()));
	  return;
	  }
	  if (p.hasPermission("tag.admin")) {
	  p.setPlayerListName("§c" + getMod(p.getName()));
	  p.setDisplayName("§c§lADM §c" + getShortStr(p.getName()));
	  return;
	  }
	  if (p.hasPermission("tag.youtuber")) {
	  p.setPlayerListName("§b" + getMod(p.getName()));
	  p.setDisplayName("§b§lYT §b" + getShortStr(p.getName()));
	  return;
	  }
	  if (p.hasPermission("tag.trial")) {
	  p.setPlayerListName("§d" + getMod(p.getName()));
	  p.setDisplayName("§d§lTRIAL §d" + getShortStr(p.getName()));
	  return;
	  }
	  if (p.hasPermission("tag.mod")) {
	  p.setPlayerListName("§5" + getMod(p.getName()));
	  p.setDisplayName("§5§lMOD §5" + getShortStr(p.getName()));
	  return;
	  }
	  }
}