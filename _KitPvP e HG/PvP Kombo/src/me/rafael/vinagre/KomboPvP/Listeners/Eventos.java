package me.rafael.vinagre.KomboPvP.Listeners;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Item;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import Scoreboard.ScoreDoBasic;
import XP.XpM;
import ca.wacos.nametagedit.NametagAPI;
import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Comandos.Admin;


public class Eventos implements Listener 
{
	public Main plugin;
	public Eventos(Main instance){
		plugin = instance;
	}
	

	    
	
	
	
	@EventHandler
	public void entrar(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		String d = p.getName();
		Main.TirarEfeitos(p);
		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta kits2 = kits.getItemMeta();
		kits2.setDisplayName("§a» Kits «");
		kits.setItemMeta(kits2);
		
		
		
		ItemStack warps = new ItemStack(Material.PAPER);
		ItemMeta warps2 = warps.getItemMeta();
		warps2.setDisplayName("§7» Warps «");
		warps.setItemMeta(warps2);
		
		ItemStack d1 = new ItemStack(Material.GHAST_TEAR);
		ItemMeta d2 = d1.getItemMeta();
		d2.setDisplayName("§1» CoinsDiario «");
		d1.setItemMeta(d2);
		
		ItemStack i1 = new ItemStack(Material.CLAY_BRICK);
		ItemMeta i2 = i1.getItemMeta();
		i2.setDisplayName("§c» Informaçoes «");
		i1.setItemMeta(i2);
		
		ItemStack a1 = new ItemStack(Material.IRON_INGOT);
		ItemMeta a2 = a1.getItemMeta();
		a2.setDisplayName("§6» Extra «");
		a1.setItemMeta(a2);
		
		ItemStack c1 = new ItemStack(Material.NAME_TAG);
		ItemMeta c2 = c1.getItemMeta();
		c2.setDisplayName("§2» Click-Test «");
		c1.setItemMeta(c2);
		
		ItemStack loja = new ItemStack(Material.EMERALD);
		ItemMeta loja2 = loja.getItemMeta();
		loja2.setDisplayName("§a» Loja «");
		loja.setItemMeta(loja2);
		
		
		
		
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.teleport(p.getWorld().getSpawnLocation());
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().setItem(4, kits);
		p.getInventory().setItem(3, warps);
		p.getInventory().setItem(1, i1);
		p.getInventory().setItem(5, loja);
		p.getInventory().setItem(2, a1);
		p.getInventory().setItem(6, c1);
		p.getInventory().setItem(7, d1);
		
		Array.kit.put(p, "Sem Kit");
		NametagAPI.setSuffix(p.getName(), ScoreDoBasic.Rank(p));
		me.rafael.vinagre.KomboPvP.Comandos.Admin.admin.remove(p.getName());
		Main.Deshfire.remove(p.getName());
		Main.antistomper.remove(p.getName());
		Main.Sonic.remove(p.getName());
		Vinagre.Habilidade.removeAbility(p);
		Scoreboard.ScoreDoBasic.iscoriboard(p);
	}

			
	
	@EventHandler
	public void respawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		String d = p.getName();
		Main.TirarEfeitos(p);
		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta kits2 = kits.getItemMeta();
		kits2.setDisplayName("§a» Kits «");
		kits.setItemMeta(kits2);
		
		
		
		ItemStack warps = new ItemStack(Material.PAPER);
		ItemMeta warps2 = warps.getItemMeta();
		warps2.setDisplayName("§7» Warps «");
		warps.setItemMeta(warps2);
		
		ItemStack d1 = new ItemStack(Material.GHAST_TEAR);
		ItemMeta d2 = d1.getItemMeta();
		d2.setDisplayName("§1» CoinsDiario «");
		d1.setItemMeta(d2);
		
		ItemStack i1 = new ItemStack(Material.CLAY_BRICK);
		ItemMeta i2 = i1.getItemMeta();
		i2.setDisplayName("§c» Informaçoes «");
		i1.setItemMeta(i2);
		
		ItemStack c1 = new ItemStack(Material.NAME_TAG);
		ItemMeta c2 = c1.getItemMeta();
		c2.setDisplayName("§2» Click-Test «");
		c1.setItemMeta(c2);
		
		ItemStack a1 = new ItemStack(Material.IRON_INGOT);
		ItemMeta a2 = a1.getItemMeta();
		a2.setDisplayName("§6» Extra «");
		a1.setItemMeta(a2);
		
		ItemStack loja = new ItemStack(Material.EMERALD);
		ItemMeta loja2 = loja.getItemMeta();
		loja2.setDisplayName("§a» Loja «");
		loja.setItemMeta(loja2);
		
		
		Scoreboard.ScoreDoBasic.iscoriboard(p);
		Vinagre.Habilidade.removeAbility(p);
		
		
		
		
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.teleport(p.getWorld().getSpawnLocation());
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().setItem(4, kits);
		p.getInventory().setItem(3, warps);
		p.getInventory().setItem(1, i1);
		p.getInventory().setItem(5, loja);
		p.getInventory().setItem(2, a1);
		p.getInventory().setItem(6, c1);
		p.getInventory().setItem(7, d1);
		Main.Deshfire.remove(p.getName());
		Main.antistomper.remove(p.getName());
		Main.Sonic.remove(p.getName());
		Main.stomper.remove(p.getName());
		
	}
	@EventHandler
	public void sair(PlayerQuitEvent e){
		e.setQuitMessage(null);
		Main.TirarEfeitos(e.getPlayer());
	}
	
	
	
	@EventHandler
	public void fome(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	  public void onDropSword(PlayerDropItemEvent e)
	  {
	    if ((e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD) || ((e.getItemDrop().getItemStack().getType() == Material.SAND) || ((e.getItemDrop().getItemStack().getType() == Material.CLAY_BRICK) || ((e.getItemDrop().getItemStack().getType() == Material.PACKED_ICE) || ((e.getItemDrop().getItemStack().getType() == Material.SAND) || ((e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE) ||((e.getItemDrop().getItemStack().getType() == Material.IRON_INGOT) ||((e.getItemDrop().getItemStack().getType() == Material.BOOK) || ((e.getItemDrop().getItemStack().getType() == Material.SLIME_BALL) || ((e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE) || (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) ||  (e.getItemDrop().getItemStack().getType() == Material.FEATHER) || (e.getItemDrop().getItemStack().getType() == Material.GHAST_TEAR) || (e.getItemDrop().getItemStack().getType() == Material.NAME_TAG) || (e.getItemDrop().getItemStack().getType() == Material.SADDLE) || (e.getItemDrop().getItemStack().getType() == Material.LEATHER) || (e.getItemDrop().getItemStack().getType() == Material.RED_ROSE) || (e.getItemDrop().getItemStack().getType() == Material.WATCH) || (e.getItemDrop().getItemStack().getType() == Material.BEACON) || (e.getItemDrop().getItemStack().getType() == Material.SKULL_ITEM) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND) || (e.getItemDrop().getItemStack().getType() == Material.COMPASS) || (e.getItemDrop().getItemStack().getType() == Material.CARPET) || (e.getItemDrop().getItemStack().getType() == Material.FLINT_AND_STEEL) || (e.getItemDrop().getItemStack().getType() == Material.NETHER_FENCE) || (e.getItemDrop().getItemStack().getType() == Material.PUMPKIN_SEEDS) || (e.getItemDrop().getItemStack().getType() == Material.GOLD_AXE) || (e.getItemDrop().getItemStack().getType() == Material.STONE_AXE) || (e.getItemDrop().getItemStack().getType() == Material.MINECART) || (e.getItemDrop().getItemStack().getType() == Material.TRIPWIRE_HOOK) ||  (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD) ||  (e.getItemDrop().getItemStack().getType() == Material.STICK) ||  (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD) || (e.getItemDrop().getItemStack().getType() == Material.QUARTZ) || (e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE) || (e.getItemDrop().getItemStack().getType() == Material.MILK_BUCKET) || (e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR) || (e.getItemDrop().getItemStack().getType() == Material.APPLE) || (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD) || (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) || (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_TORCH_ON) || (e.getItemDrop().getItemStack().getType() == Material.SADDLE) || (e.getItemDrop().getItemStack().getType() == Material.WOOD_HOE) || (e.getItemDrop().getItemStack().getType() == Material.MONSTER_EGG) || (e.getItemDrop().getItemStack().getType() == Material.BEDROCK) || (e.getItemDrop().getItemStack().getType() == Material.LEASH) || (e.getItemDrop().getItemStack().getType() == Material.REDSTONE) || (e.getItemDrop().getItemStack().getType() == Material.PAPER) || (e.getItemDrop().getItemStack().getType() == Material.STONE_AXE) || (e.getItemDrop().getItemStack().getType() == Material.SNOW_BALL) ||  (e.getItemDrop().getItemStack().getType() == Material.SNOW_BALL) || (e.getItemDrop().getItemStack().getType() == Material.SLIME_BALL) || (e.getItemDrop().getItemStack().getType() == Material.PORTAL) || (e.getItemDrop().getItemStack().getType() == Material.BLAZE_POWDER) || (e.getItemDrop().getItemStack().getType() == Material.POTION) || (e.getItemDrop().getItemStack().getType() == Material.BOW) || (e.getItemDrop().getItemStack().getType() == Material.ARROW) || (e.getItemDrop().getItemStack().getType() == Material.GOLDEN_APPLE) || (e.getItemDrop().getItemStack().getType() == Material.FIREWORK) || (e.getItemDrop().getItemStack().getType() == Material.EMERALD) || (e.getItemDrop().getItemStack().getType() == Material.ENDER_CHEST) ||  (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_BLOCK) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD))))))))))) {
	    		
	      e.setCancelled(true);
	    }
	  }
	
	
	
	
	
	
	@EventHandler
	public void chuva(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		e.setCancelled(false);
	}
	
		
	
	  @EventHandler
	  public void bater(EntityDamageEvent e) {
	    if ((e.getEntity() instanceof Villager))
	      e.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void reparar(PlayerInteractEvent e){
		  Player p = e.getPlayer();
		  if(((Array.used.contains(p.getName())) && (e.getAction() == Action.RIGHT_CLICK_AIR) && (p.getItemInHand().getType() == Material.STONE_SWORD) || (p.getItemInHand().getType() == Material.WOOD_SWORD) || (p.getItemInHand().getType() == Material.IRON_SWORD)|| (p.getItemInHand().getType() == Material.DIAMOND_SWORD))){
		        repairItems1(p.getInventory().getContents(), p);
		        repairItems1(p.getInventory().getArmorContents(), p);
		  }else{
			  return;
		  }
	  }
	  
	  private void repairItems1(ItemStack[] items, Player p){
	    for (ItemStack item : items) {
	      if ((item == null) || (item.getType().isBlock()) || (item.getDurability() == 0))
	        continue;
	      Material material = item.getType();
	      if ((material.isBlock()) || (material.getMaxDurability() < 1))
	        continue;
	      if (item.getDurability() == 0) {
	        p.sendMessage(" §7» §cTodos os itens ja estao reparados !");
	        return;
	      }
	      item.setDurability((short) 0);
	    }
	  }
	  
	  
	  @EventHandler
	  public void villager(PlayerInteractEntityEvent e) {
      if (!(e.getRightClicked() instanceof Villager)){
		return;
      }
	    Player p = e.getPlayer();
	    Villager v = (Villager)e.getRightClicked();
	    if(v.getCustomName().equals("§e§lSopas")){
	      e.setCancelled(true);

		    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		    ItemMeta sopasm = sopa.getItemMeta();
		    sopasm.setDisplayName("§6Sopas");
		    sopa.setItemMeta(sopasm);
	      
		    Inventory inve = Bukkit.getServer().createInventory(p, 36, "§nSopas");

		    inve.setItem(0, sopa);
		    inve.setItem(1, sopa);
		    inve.setItem(2, sopa);
		    inve.setItem(3, sopa);
		    inve.setItem(4, sopa);
		    inve.setItem(5, sopa);
		    inve.setItem(6, sopa);
		    inve.setItem(7, sopa);
		    inve.setItem(8, sopa);
		    inve.setItem(9, sopa);
		    inve.setItem(10, sopa);
		    inve.setItem(11, sopa);
		    inve.setItem(12, sopa);
		    inve.setItem(13, sopa);
		    inve.setItem(14, sopa);
		    inve.setItem(15, sopa);
		    inve.setItem(16, sopa);
		    inve.setItem(17, sopa);
		    inve.setItem(18, sopa);
		    inve.setItem(19, sopa);
		    inve.setItem(20, sopa);
		    inve.setItem(21, sopa);
		    inve.setItem(22, sopa);
		    inve.setItem(23, sopa);
		    inve.setItem(24, sopa);
		    inve.setItem(25, sopa);
		    inve.setItem(26, sopa);
		    inve.setItem(27, sopa);
		    inve.setItem(28, sopa);
		    inve.setItem(29, sopa);
		    inve.setItem(30, sopa);
		    inve.setItem(31, sopa);
		    inve.setItem(32, sopa);
		    inve.setItem(33, sopa);
		    inve.setItem(34, sopa);
		    inve.setItem(35, sopa);
	      p.openInventory(inve);
	      return;
	  }
	    if(v.getCustomName().equals("§6§lRecraft")){
	    	e.setCancelled(true);
	    	ItemStack vermelho = new ItemStack(Material.RED_MUSHROOM,64);
	    	ItemMeta vermelho2 = vermelho.getItemMeta();
	    	vermelho2.setDisplayName("§cCogumelo Vermelho");
	    	vermelho.setItemMeta(vermelho2);
	    	
	    	ItemStack marrom = new ItemStack(Material.BROWN_MUSHROOM,64);
	    	ItemMeta marrom2 = marrom.getItemMeta();
	    	marrom2.setDisplayName("§8Cogumelo Marrom");
	    	marrom.setItemMeta(marrom2);
	    	
	    	ItemStack item = new ItemStack(Material.BOWL,64);
	    	ItemMeta item2 = item.getItemMeta();
	    	item2.setDisplayName("§7Pote");
		    List<String> itemlore = new ArrayList();
		    itemlore.add("§c0.0§4�?�");
		    item2.setLore(itemlore);
		    item.setItemMeta(item2);
		    
		    p.sendMessage("§c§lRECRAFT: §7§lRECRAFT §7recebido !");
		    p.getInventory().setItem(14, vermelho);
		    p.getInventory().setItem(15, marrom);
		    p.getInventory().setItem(13, item);
	    }
	 }
	  
	  
	  
	  public static void status(Player p){
	    	Inventory status = Bukkit.createInventory(p, InventoryType.HOPPER, "§nStatus");
	    	
	    	ItemStack seu = new ItemStack(Material.SLIME_BALL);
	    	ItemMeta seu2 = seu.getItemMeta();
	    	seu2.setDisplayName("§aSeus Status");
	    	seu.setItemMeta(seu2);
	    	
	    	ItemStack top = new ItemStack(Material.DOUBLE_PLANT);
	    	ItemMeta top2 = top.getItemMeta();
	    	top2.setDisplayName("§6Ranking TOP");
	    	top.setItemMeta(top2);
	    	
	    	status.setItem(1, seu);
	    	status.setItem(3, top);
	    	
	    	p.openInventory(status);
	  }
	  
	 
	  
	  @EventHandler
	  public void gerar(SignChangeEvent e){
	    Player p = e.getPlayer();
	    if (!p.hasPermission("kitpvp.admin"))
	    {
	      e.getBlock().breakNaturally();
	      p.sendMessage("§cVoce nao tem permissao.");
	      return;
	    }
	    if (e.getLine(0).equalsIgnoreCase("[Sopas]"))
	    {
	      e.getBlock().breakNaturally();
	      Villager bat = (Villager)e.getBlock().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.VILLAGER);
	      e.getBlock().breakNaturally();
	      bat.setCustomName("§e§lSopas");
	      bat.setCustomNameVisible(true);
	      bat.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, -10));
	      bat.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, -10));
	      bat.setNoDamageTicks(9999);
	      bat.setMaxHealth(9999);
	      bat.setHealth(999);
	    }
	    if (e.getLine(0).equalsIgnoreCase("[Recraft]"))
	    {
	      e.getBlock().breakNaturally();
	      Villager bat = (Villager)e.getBlock().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.VILLAGER);
	      e.getBlock().breakNaturally();
	      bat.setCustomName("§6§lRecraft");
	      bat.setCustomNameVisible(true);
	      bat.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, -10));
	      bat.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, -10));
	      bat.setNoDamageTicks(9999);
	      bat.setMaxHealth(9999);
	      bat.setHealth(999);
	    }
	  }
	  
	  @EventHandler
	  public void comando(PlayerCommandPreprocessEvent e){
		  Player p = e.getPlayer();
		  if(!p.hasPermission("kitpvp.admin")){
		  if((Array.warp.contains(p.getName())) && (!e.getMessage().equals("/spawn")) && (!e.getMessage().equals("/tell"))){
			  e.setCancelled(true);
			  p.sendMessage("§7» §cComando nao permitido nas warps !");
		  }
		  if(e.getMessage().equals("/pl") || e.getMessage().equals("/ver") || e.getMessage().equals("/plugins") || e.getMessage().equals("/help")){
			  e.setCancelled(true);
		  }
		  if(e.getMessage().contains("/me")){
			  e.setCancelled(true);
		  }
		 }
	  }
	  
	  public void lojas(Player p){
		  
		  Inventory loja = Bukkit.createInventory(p, InventoryType.HOPPER, "§nCaixas");
		  
		  ItemStack caixa1 = new ItemStack(Material.CHEST);
		  ItemMeta caixa12 = caixa1.getItemMeta();
		  caixa12.setDisplayName("§fCaixa Normal");
		  List<String> lore1 = new ArrayList();
		  lore1.add(" ");
		  lore1.add("§6§lPreco: §e1000 XP §6| §e100 Coins");
		  lore1.add(" ");
		  lore1.add("§7Clique com o §c§lDIREITO §7para comprar com Coins !");
		  lore1.add(" ");
		  lore1.add("§7Clique com o §c§lESQUERDO §7para comprar com XP !");
		  lore1.add(" ");
		  caixa12.setLore(lore1);
		  caixa1.setItemMeta(caixa12);
		  
		  ItemStack caixa2 = new ItemStack(Material.ENDER_CHEST);
		  ItemMeta caixa22 = caixa2.getItemMeta();
		  caixa22.setDisplayName("§3Caixa Lendaria");
		  List<String> lore2 = new ArrayList();
		  lore2.add(" ");
		  lore2.add("§6§lPreco: §e3000 XP §6| §e300 Coins");
		  lore2.add(" ");
		  lore2.add("§7Clique com o §c§lDIREITO §7para comprar com Coins !");
		  lore2.add(" ");
		  lore2.add("§7Clique com o §c§lESQUERDO §7para comprar com XP !");
		  lore2.add(" ");
		  caixa22.setLore(lore2);
		  caixa2.setItemMeta(caixa22);
		  
		  
		  loja.setItem(1, caixa1);
		  loja.setItem(3, caixa2);
		  
		  p.openInventory(loja);
	  }
	  
	
	 
	  
	  @EventHandler
	  public void cor(SignChangeEvent e){
		  Player p = e.getPlayer();
		  if(!p.hasPermission("kitpvp.admin")){
			  return;
		  }
	      for (int i = 0; i <= 3; i++)
	      {
	        String line = e.getLine(i);
	        
	        line = ChatColor.translateAlternateColorCodes('&', line);
	        e.setLine(i, line);
	      }
	  }
	  
		@EventHandler(priority=EventPriority.NORMAL)
		  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		    if (!e.isCancelled())
		    {
		      Player p = e.getPlayer();
		      String cmd = e.getMessage().split(" ")[0];
		      HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
		      if (topic == null)
		      {
		        p.sendMessage("§7» §cComando nao encontrado !");
		        e.setCancelled(true);
		      }
		    }
		  }
		@EventHandler
		  public void onItemDrop(final ItemSpawnEvent e)
		  {
		    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
		    {
		      public void run()
		      {
		        e.getEntity().remove();
		        e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
		      }
		    }, 50L);
		  }
		
		@EventHandler
		public void bloquear(EntityExplodeEvent e){
			e.setCancelled(true);
		}
		
		  @EventHandler
		  public void entrar(PlayerLoginEvent e){
		    Player p = e.getPlayer();
		    if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL)
		    {
		      if (p.hasPermission("kitpvp.vip")){
		        e.setResult(PlayerLoginEvent.Result.ALLOWED);
		      }else {
		          e.setKickMessage("§c§lOps \n§cServidor cheio, compre VIP e garanta seu SLOT !\n§f" + ((Main.getPlugin().getConfig().getString("Site").replace("&", "§"))));
		      }
		    }
		    else if (e.getResult() == PlayerLoginEvent.Result.KICK_BANNED)
		      e.setKickMessage(("§c§lTENHA UM §4§lBAN §c§lDIA! TCHAU ;-;"));
		  }
		  
}