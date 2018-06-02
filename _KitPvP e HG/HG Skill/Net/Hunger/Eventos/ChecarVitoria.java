package Net.Hunger.Eventos;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDAdmin;
import Net.Hunger.Comandos.CMDListener;
import Net.Hunger.Feast.FeastManager;
import Net.Hunger.Manager.BarAPI;
import Utils.API;

@SuppressWarnings("deprecation")
public class ChecarVitoria implements Listener {

	  @EventHandler
	  public void onRegen(EntityRegainHealthEvent event) {
	  final LivingEntity entity = (LivingEntity)event.getEntity();
	  int lvl = 0;
	  Collection<PotionEffect> Effects = entity.getActivePotionEffects();
	  for (PotionEffect effect : Effects) {
	  if ((effect.getType().getName() == "REGENERATION") || (effect.getType().getName() == "HEAL")) {
	  lvl = effect.getAmplifier() + 1;
	  break;
	  }
	  }
	  if ((event.getRegainReason() == EntityRegainHealthEvent.RegainReason.MAGIC_REGEN) && (event.getAmount() == 1.0D) && (lvl > 0)) {
	  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  if (entity.getMaxHealth() >= entity.getHealth() + 1.0D) {
	  entity.setHealth(entity.getHealth() + 1.0D);
	  }
	  }
	  }, 50L / (lvl * 2));
	  } else if ((event.getRegainReason() == EntityRegainHealthEvent.RegainReason.MAGIC) && (event.getAmount() > 1.0D) && (lvl > 0)) {
	  event.setAmount(event.getAmount() * 1.5D);
	  }
	  }
	  
	  @EventHandler
	  public void onBlockSpread(BlockSpreadEvent event) {
		event.setCancelled(true);
		return;
	  }
	  
	  public static boolean ProtecaoFeast;
	  
	  @EventHandler
	  public void onBreakFeast(BlockBreakEvent e) {
	  Player p = (Player)e.getPlayer();
	  if(e.getBlock().getType() == Material.getMaterial(159)) {
      if(ProtecaoFeast) {
	  e.setCancelled(true);
	  p.sendMessage("§7[§a!§7] Você não pode quebrar blocos do §aFeast!");
      return;
	  } else {
	  return;
	  }
	  }
	  }
	  
	  private Map<String, Long> timeout = new HashMap<String, Long>();
	  
	  @EventHandler
	  public void onChat(AsyncPlayerChatEvent e) {
	  Player p = e.getPlayer();
	  if ((timeout.containsKey(p.getName())) && 
	  (((Long)timeout.get(p.getName())).longValue() > System.currentTimeMillis())) {
	  if(p.hasPermission("HungerGames.c.admin")) {
	  return;
	  }
	  p.sendMessage("§7[§a!§7] Você deve falar devagar!");
	  e.setCancelled(true);
	  return;
	  }
	  timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 3000L));
	  }
	  
	  @EventHandler
	  public void onChat(PlayerChatEvent e) {
	  Player p = e.getPlayer();
	  if(e.getMessage().toLowerCase().endsWith("%")) {
	  p.sendMessage("§7[§a?§7] Você não pode escrever isso! =)");
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler
	  public void onAdm(PlayerPickupItemEvent e) {
	  if(CMDAdmin.admin.contains(e.getPlayer())) {
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
      public static void autobroadcastMessages() {
	  final String[] messages = { 
	  "§7[§aANUNCIO§7] §7Alteramos nosso §aTerrainControl§7 para sua melhor §aJogabilidade!", 
	  "§7[§aANUNCIO§7] §7Você tem algum problema a reportar? §aSkillNetwork!",
	  "§7[§aANUNCIO§7] §7Nossa network de servidores §aHG§7 vai de §a01.skill-hg.com §7a§a 07.skill-hg.com",
	  "§7[§aANUNCIO§7] §7Temos um §aTwitter! §7siga-nos §aSkillNetwork" };
	  Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
	  public void run() {
	  Bukkit.broadcastMessage((String)Arrays.asList(messages).get(new Random().nextInt(messages.length)));
	  } 
	  }, 0L, 2500L);
	  }
      
	  @EventHandler
	  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
	  if (event.getMessage().toLowerCase().startsWith("/me")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/bukkit:me")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/bukkit:?")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/bukkit:ver")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/bukkit:versions")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/bukkit:version")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/ver")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/?")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/plugins")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/whispher")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/bukkit:ver")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/bukkit:plugins")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/bukkit:pl")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/pl")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/version")) {
	  event.setCancelled(true);
	  return;
	  }
	  if (event.getMessage().toLowerCase().startsWith("/versions")) {
	  event.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void onPlayerInteract(PlayerInteractEvent event) {
	  Player p = event.getPlayer();
	  ItemStack item = event.getItem();
	  if (((event.getAction() == Action.RIGHT_CLICK_AIR) || 
	  (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	  (item != null) && 
	  (item.getType() == Material.MUSHROOM_SOUP) && (
	  (p.getHealth() < 20.0D) || (p.getFoodLevel() < 20))) {
	  int restores = 7;
	  event.setCancelled(true);
	  if (p.getHealth() < 20.0D) {
	  if (p.getHealth() + restores <= 20.0D) {
	  p.setHealth(p.getHealth() + restores);
	  } else {
	  p.setHealth(20.0D);
	  }
	  } else if (p.getFoodLevel() < 20) {
	  if (p.getFoodLevel() + restores <= 20) {
	  p.setFoodLevel(p.getFoodLevel() + restores);
	  p.setSaturation(75.0F);
	  p.setExhaustion(0);
	  } else {
	  p.setFoodLevel(20);
	  p.setSaturation(75.0F);
	  p.setExhaustion(0);
	  }
	  }
	  if (item.getAmount() > 1) {
	  p.setItemInHand(new ItemStack(Material.BOWL));
	  } else {
	  item = new ItemStack(Material.BOWL);
	  }
	  p.setItemInHand(item);
	  }
	  }
	  
	  @EventHandler
	  public void onSpecRank(AsyncPlayerChatEvent e) {
	  Player p = e.getPlayer();
	  if(Main.Watch.contains(p.getName())) {
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler
	  public void onPlayersChat(AsyncPlayerChatEvent e) {
	  Player p = e.getPlayer();
	  if (p.getName().length() < 50) {
	  if (p.hasPermission("HungerGames.c.Admin")) {
	  e.setFormat(p.getDisplayName() + " §a» " + ChatColor.RESET + e.getMessage().replaceAll("&", "§"));
	  } else {
	  e.setFormat(p.getDisplayName() + " §a» " + ChatColor.RESET + e.getMessage());
	  }
	  }
	  }
	
	  @EventHandler(priority = EventPriority.MONITOR)
	  public void onQuit(PlayerQuitEvent e) {
	  if(Main.Partida) {
	  if (Main.Jogadores.size() == 0) {
	  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  Bukkit.shutdown();
	  Main.Jogadores.clear();
	  }
	  },250L);
	  }
	  }
	  }
	  
	  public static void spawnRandomFirework(Location loc) {
	  Firework fw = (Firework)loc.getWorld().spawnEntity(loc, 
	  EntityType.FIREWORK);
	  FireworkMeta fwm = fw.getFireworkMeta();
	  Random r = new Random();  
	  int rt = r.nextInt(4) + 1;
	  FireworkEffect.Type type = FireworkEffect.Type.BALL;
	  if (rt == 1) {
	  type = FireworkEffect.Type.BALL;
	  }
	  if (rt == 2) {
	  type = FireworkEffect.Type.BALL_LARGE;
	  }
	  if (rt == 3) {
	  type = FireworkEffect.Type.BURST;
	  }
	  if (rt == 4) {
	  type = FireworkEffect.Type.CREEPER;
	  }
	  if (rt == 5) {
	  type = FireworkEffect.Type.STAR;
	  } 
	  Color c1 = Color.RED;
	  Color c2 = Color.YELLOW;
	  Color c3 = Color.ORANGE; 
	  FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withColor(c2).withFade(c3).with(type).trail(r.nextBoolean()).build();
	  fwm.addEffect(effect);  
	  int rp = r.nextInt(2) + 1;
	  fwm.setPower(rp); 
	  fw.setFireworkMeta(fwm);
	  }
	 
	  public static void onVerific() {
	  if(Main.Finalizando) {
	  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  Bukkit.shutdown();
	  }
	  },600L);
	  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  onVerific();
	  }
	  },650L);
	  }
	  }
	  
	  public static String NEW_WINNER = "";
	  
	  @EventHandler
	  public void onMap(MapInitializeEvent event) {
	  if (NEW_WINNER == "") {
	  MapView m = event.getMap();
	  for (MapRenderer r : m.getRenderers()) {
	  m.removeRenderer(r);
	  }
	  return;
	  }
	  MapView m = event.getMap();
	  for (MapRenderer r : m.getRenderers()) {
	  m.removeRenderer(r);
	  } m.addRenderer(new MapRenderer() {
	  public void render(MapView view, MapCanvas canvas, Player p) {
	  int i = 0;
	  int name = p.getName().length();
	  if (name == 16) {
	  i = 22;
	  } if (name == 15) {
	  i = 25;
	  } if (name == 14) {
	  i = 28;
	  } if (name == 13) {
	  i = 30;
	  } if (name == 12) {
	  i = 33;
	  } if (name == 11) {
	  i = 36;
	  } if (name == 10) {
	  i = 38;
	  } if (name == 9) {
	  i = 41;
	  } if (name == 8) {
	  i = 44;
	  } if (name == 7) {
	  i = 46;
	  } if (name == 6) {
	  i = 49;
	  } if (name == 5) {
	  i = 52;
	  } if (name == 4) {
	  i = 54;
	  } if (name == 3) {
	  i = 57;
	  } if (name == 2) {
	  i = 60;
	  } if (name == 1) {
	  i = 62;
	  }
	  String parabens = "Parabens";
	  canvas.drawText(38, 6, MinecraftFont.Font, 
	  parabens + ",");
	  canvas.drawText(-5, 15, MinecraftFont.Font, 
	  "   voce venceu no Skill HG");
	  canvas.drawText(i, 24, MinecraftFont.Font, p.getName());
	  canvas.drawImage(14, 40, new ImageIcon(Main.instance
	  .getDataFolder().getPath() + "/Cake.png").getImage());
	  }
	  });
	  }
	  
	  @EventHandler(priority=EventPriority.MONITOR)
	  public void NerfSwords(EntityDamageByEntityEvent event)
	  {
	    if ((event.getDamager() instanceof Player))
	    {
	      Player player = (Player)event.getDamager();
	      if (event.getDamage() > 1.0D) {
	        event.setDamage(event.getDamage() - 1.0D);
	      }
	      if ((event.getDamager() instanceof Player))
	      {
	        if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
	        {
	          int NewDamage = (int)(event.getDamage() * 1.5D) - (int)event.getDamage();
	          if (event.getDamage() > 1.0D) {
	            event.setDamage(event.getDamage() - NewDamage);
	          }
	        }
	        if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
	          for (PotionEffect Effect : player.getActivePotionEffects()) {
	            if (Effect.getType().equals(PotionEffectType.INCREASE_DAMAGE))
	            {
	              double Division = (Effect.getAmplifier() + 2) * 1.3D + 1.0D;
	              int NewDamage;
	              if (event.getDamage() / Division <= 1.0D) {
	                NewDamage = (Effect.getAmplifier() + 2) * 3 + 3;
	              } else {
	                NewDamage = (int)(event.getDamage() / Division);
	              }
	              event.setDamage(NewDamage);
	              break;
	            }
	          }
	        }
	        if (player.getItemInHand().getType() == Material.AIR) {
	          event.setDamage(0.5D);
	        }
	        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
	          event.setDamage(2.0D);
	        }
	        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
	          event.setDamage(3.0D);
	        }
	        if (player.getItemInHand().getType() == Material.GOLD_SWORD) {
	          event.setDamage(4.0D);
	        }
	        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
	          event.setDamage(4.0D);
	        }
	        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
	          event.setDamage(5.0D);
	        }
	        if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
	          for (PotionEffect Effect : player.getActivePotionEffects()) {
	            if ((Effect.getType().equals(PotionEffectType.INCREASE_DAMAGE)) && 
	              (player.getItemInHand() != null) && (player.getItemInHand().getType().name().contains("SWORD")))
	            {
	              Random r = new Random();
	              if (r.nextInt(3) == 0)
	              {
	                event.setDamage(event.getDamage() + 2.0D);
	                break;
	              }
	              event.setDamage(event.getDamage() + 1.5D);
	            }
	          }
	        }
	        if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
	        {
	          if (player.getItemInHand().getType() == Material.AIR) {
	            event.setDamage(0.5D);
	          }
	          if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
	            event.setDamage(event.getDamage() + 1.0D);
	          }
	          if (player.getItemInHand().getType() == Material.STONE_SWORD) {
	            event.setDamage(event.getDamage() + 1.0D);
	          }
	          if (player.getItemInHand().getType() == Material.GOLD_SWORD) {
	            event.setDamage(event.getDamage() + 1.5D);
	          }
	          if (player.getItemInHand().getType() == Material.IRON_SWORD) {
	            event.setDamage(event.getDamage() + 1.0D);
	          }
	          if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
	            event.setDamage(event.getDamage() + 1.0D);
	          }
	        }
	      }
	    }
	  }
	  
	  public static void verificaWin() {
	  if (Main.Partida) {
	  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  if (Main.Jogadores.size() == 1) {
	  for (String s : Main.Jogadores) {
	  final Player pl1 = Bukkit.getPlayer(s);
	  pl1.playSound(pl1.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	  Location pLoc = pl1.getLocation();
	  BarAPI.setName(pl1, "§7[§a!§7] §c§l" + pl1.getName() + " §f§lVENCEU PARABENS! §7[§a!§7]", 400L);
	  final Location winnerLoc = new Location(pl1.getWorld(), pLoc.getBlockX(), 110.0D, pLoc.getBlockZ());
	  for (int i = 0; i < 1; i++) {
	  for (int x = -3; x < 3; x++) {
	  for (int z = -3; z < 3; z++) {
	  Block b = winnerLoc.clone().add(x, -2.0D, z).getBlock();
	  Block b2 = winnerLoc.clone().add(x, -1.0D, z).getBlock();
	  b.setType(Material.GLASS);
	  b2.setType(Material.CAKE_BLOCK);
	  pl1.teleport(winnerLoc);
	  }
	  Main.Finalizando = true;
	  ChecarVitoria.spawnRandomFirework(winnerLoc);
	  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  ChecarVitoria.spawnRandomFirework(winnerLoc);
	  }
	  }, 120L);
	  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  ChecarVitoria.spawnRandomFirework(winnerLoc);
	  }
	  }, 180L);
	  }
	  }
	  Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
	  public void run() {
	  Bukkit.broadcastMessage("§7[§a!§7] §a" + pl1.getName() + "§f Venceu!");
	  }
	  }, 2L, 120L);
	  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  if (pl1.isOnline()) {
	  for (Player p : Bukkit.getOnlinePlayers()) {
	  p.kickPlayer("§a" + pl1.getName() + " §7Conseguiu §a" + CMDListener.getKs(pl1) + "§7 Kills" + "\n" + "§7Servidor reiniciando!\n" + "§7Visite §a" + Main.site);
	  API.addWin(pl1);
	  }
	  Bukkit.shutdown();
	  }
	  }
	  }, 250L);
	  }
	  } else if (Main.Jogadores.size() == 0) {
	  Bukkit.shutdown();
	 }
	}
   }, 25L);
  }
 }
}