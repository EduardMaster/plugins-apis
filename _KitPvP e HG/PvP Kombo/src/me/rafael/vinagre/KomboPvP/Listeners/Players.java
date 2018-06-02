package me.rafael.vinagre.KomboPvP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Player.Spigot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

import me.rafael.vinagre.KomboPvP.Main;

public class Players
  implements Listener
{
  public static Main plugin;
  int online = Bukkit.getOnlinePlayers().length;
  @EventHandler
  public void tp(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    Location l = p.getWorld().getSpawnLocation();
    p.teleport(l);
  }
  
  @EventHandler
  public void aologin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("");
    p.sendMessage(""); 
    p.sendMessage("");p.sendMessage("");p.sendMessage("");p.sendMessage("");p.sendMessage("");p.sendMessage("");p.sendMessage("");
    p.sendMessage("");
    p.sendMessage("§1§l=§2§l=§3§l=§4§l=§5§l=§6§l=§7§l=§8§l=§9§l=§a§l=§b§l=§c§l=§d§l=§e§l=§f§l=§1§l=§2§l=§3§l=§4§l=§5§l=§6§l=§7§l=§8§l=§9§l=§a§l=§b§l=§c§l=§d§l=§e§l=§f§l=");
    
    p.sendMessage("    §c\u27a1 §6Bem-Vindo!");
    p.sendMessage("    §c\u27a1 §cVocê esta conectado no server: " +  (Main.getPlugin().getConfig().getString("NomeServer").replace("&", "§")));
    p.sendMessage("    §c\u27a1 §aPlayers Online: §2" + online + "§7/§c" + Bukkit.getMaxPlayers());;
    p.sendMessage("    §c\u27a1 §2Para reportar um hack use /report");   
    p.sendMessage("    §c\u27a1 §eDigite §c/pl §epara ver quem fez o plugin");  
    p.sendMessage("    §c\u27a1 §bTenha um bom jogo: §6§l " + p.getName());
    p.sendMessage("§1§l=§2§l=§3§l=§4§l=§5§l=§6§l=§7§l=§8§l=§9§l=§a§l=§b§l=§c§l=§d§l=§e§l=§f§l=§1§l=§2§l=§3§l=§4§l=§5§l=§6§l=§7§l=§8§l=§9§l=§a§l=§b§l=§c§l=§d§l=§e§l=§f§l=");
    
    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
    p.setPlayerListName("§7" + p.getName());
  }
  
  @EventHandler
  public void place(BlockPlaceEvent e)
  {
    if (e.getBlock().getTypeId() == 272) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 272) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 260) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 154) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 401) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 261) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 373) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 264) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 122) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 345) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 331) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 377) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 347) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 271) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 275) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 19) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 160) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 288) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 381) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 13) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 420) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 77) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 369) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 390) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 346) {
      e.setCancelled(true);
    }
    if (e.getBlock().getTypeId() == 290) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onDropItem(PlayerDropItemEvent e)
  {
    if (e.getItemDrop().getItemStack().getTypeId() == 272) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 260) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 154) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 401) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 261) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 373) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 264) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 122) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 345) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 331) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 377) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 347) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 271) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 275) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 19) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 160) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 288) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 381) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 13) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 420) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 77) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 369) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 390) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 346) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 290) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void inte1(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType() == Material.CHEST) && (
    		(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a» Kits «"))) && (	
      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
      (e.getAction() == Action.LEFT_CLICK_AIR) || 
      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
      p.chat("/kits");
    }
  
    if ((p.getItemInHand().getType() == Material.PAPER) && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
      (e.getAction() == Action.LEFT_CLICK_AIR) || 
      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
      p.chat("/warps");
    }
    if ((p.getItemInHand().getType() == Material.IRON_INGOT) && (
    	      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
    	      (e.getAction() == Action.LEFT_CLICK_AIR) || 
    	      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
    	      p.chat("/extra");
    	    }
    if ((p.getItemInHand().getType() == Material.NAME_TAG) && (
  	      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
  	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
  	      (e.getAction() == Action.LEFT_CLICK_AIR) || 
  	      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
  	      p.chat("/testclick");
  	    }
    if ((p.getItemInHand().getType() == Material.CLAY_BRICK) && (
    	      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
    	      (e.getAction() == Action.LEFT_CLICK_AIR) || 
    	      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
    	      p.chat("/info2");
    	    }
    if ((p.getItemInHand().getType() == Material.EMERALD) && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
      (e.getAction() == Action.LEFT_CLICK_AIR) || 
      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
      p.chat("/loja");
    }
  }
  
  @EventHandler
  public void onR(PlayerRespawnEvent e)
  {
    Player p = e.getPlayer();
  }
  
  @EventHandler
  public void respawnar(final PlayerDeathEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    new BukkitRunnable()
    {
      public void run()
      {
        e.getEntity().spigot().respawn();
      }
    }.runTask(Main.getPlugin());
  }
  
  @EventHandler
  public void hunger(FoodLevelChangeEvent event)
  {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void aodropar(PlayerPickupItemEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void rain(WeatherChangeEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onHit(EntityDamageByEntityEvent event)
  {
    if (((event.getEntity() instanceof Player)) && ((event.getDamager() instanceof Player)))
    {
      Player p = (Player)event.getDamager();
      ItemStack[] armor = p.getInventory().getArmorContents();
      p.getItemInHand().setDurability((short)-p.getItemInHand().getType().getMaxDurability());
      if (armor.length > 0) {
        for (int i = 0; i < armor.length; i++) {
          armor[i].setDurability((short)-armor[i].getType().getMaxDurability());
        }
      }
    }
  }
  
  @EventHandler
  public void death(PlayerDeathEvent e)
  {
    e.setDeathMessage(null);
  }
  
  @EventHandler
  public void aoDropar(PlayerDropItemEvent e)
  {
    if (e.getItemDrop().getItemStack().getTypeId() == 267) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 268) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 19) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 352) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 347) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 370) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 272) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 276) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 283) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 261) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 280) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 334) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 401) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 399) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 369) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 54) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 288) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 332) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 346) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 76) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 275) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 282) {
        e.setCancelled(false);
      }
    if (e.getItemDrop().getItemStack().getTypeId() == 281) {
        e.setCancelled(false);
      }
    if (e.getItemDrop().getItemStack().getTypeId() == 90) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 420) {
      e.setCancelled(true);
    }
    if (e.getItemDrop().getItemStack().getTypeId() == 160) {
      e.setCancelled(true);
    }
  }


@EventHandler(priority=EventPriority.NORMAL)
public void onColorandChangeChat(PlayerChatEvent e)
{
  Player p = e.getPlayer();
  if ((e.getMessage().equalsIgnoreCase("server lixo")) || (e.getMessage().equalsIgnoreCase("servidor lixo"))) {
    e.setMessage("Amei esse servidor é o melhor do mundo <3");
  }
  if ((e.getMessage().equalsIgnoreCase("servidor bosta")) || (e.getMessage().equalsIgnoreCase("servidor merda"))) {
    e.setMessage("Amei esse servidor é o melhor do mundo <3");
  }
  if ((e.getMessage().equalsIgnoreCase("server bosta")) || (e.getMessage().equalsIgnoreCase("server de merda"))) {
	    e.setMessage("Amei esse servidor é o melhor do mundo <3");
	  }
  if ((e.getMessage().equalsIgnoreCase("fdp")) || (e.getMessage().equalsIgnoreCase("Filho da puta"))) {
    e.setMessage("Delicia");
  }
  if ((e.getMessage().equalsIgnoreCase("server li.xo")) || (e.getMessage().equalsIgnoreCase("sv li.xo"))) {
	    e.setMessage("Amei esse servidor é o melhor do mundo <3");
	  }
  if ((e.getMessage().contains("lixo")) || (e.getMessage().contains("seu lixo"))) {
    e.setMessage("Seu lindo quero você >3");
  }
  if (e.getMessage().equalsIgnoreCase("sou hack")) {
    e.setMessage("Sou Um Lixo E Uso Hack Me Bani");
  }
  if (e.getMessage().equalsIgnoreCase("plugin da net")) {
	    e.setMessage("Plugin foda");
	  }
  if (e.getMessage().equalsIgnoreCase("plugin decompilado")) {
	    e.setMessage("Plugin foda");
	  }
  if (e.getMessage().equalsIgnoreCase("dec")) {
	    e.setMessage("Dev");
	  }
  
  if (e.getMessage().equalsIgnoreCase("sv lixo")) {
	    e.setMessage("Server foda");
	  }
}
}

