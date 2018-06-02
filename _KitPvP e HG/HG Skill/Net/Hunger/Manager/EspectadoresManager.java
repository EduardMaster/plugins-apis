package Net.Hunger.Manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDAdmin;
import Net.Hunger.Comandos.CMDListener;
import Net.Hunger.Comandos.CMDMiniArena;

@SuppressWarnings("deprecation")
public class EspectadoresManager implements Listener {

	  public static ArrayList<Player> DamageMobs = new ArrayList<Player>(); 
	
	  @EventHandler
	  public void onBreak(BlockBreakEvent e) {
	    Player p = (Player)e.getPlayer();
	      if(Main.Watch.contains(p.getName())) {
	       e.setCancelled(true);
	        return;
	     }
	  }
	  
	  @EventHandler
	  public void DamageMobs(EntityDamageByEntityEvent e) {
	  if(!(e.getDamager() instanceof Player)) {
	     return;
	      }
	       Player p = (Player)e.getDamager();
	       if ((DamageMobs.contains(p)) && ((e.getEntity() instanceof Entity))) {
	         e.setCancelled(true);
	      }
	  }
	  
	  @EventHandler
	   public void onInteracts(PlayerInteractEvent e) {
		  Player p = e.getPlayer();
		  if(p.getItemInHand().getType() == Material.FLINT_AND_STEEL) {
			  if(Main.Watch.contains(p.getName())) {
				  e.setCancelled(true);
				  return;
			  }
		  }
	  }
	  
	  @EventHandler
	  public void Espectador(PlayerInteractEvent e) {
	  Player p = e.getPlayer();
	  if ((p.getItemInHand().getType() == Material.SLIME_BALL) && (Main.Watch.contains(p.getName())) && ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR))) {
	  Inventory inv = Bukkit.createInventory(p, 54, "§0§nSkillHG - Participantes");
	  for (Player players : Bukkit.getOnlinePlayers()) {
	  if (!players.getName().equals(p.getName())){
	  ItemStack skull = new ItemStack(Material.getMaterial(397));
	  SkullMeta sm = (SkullMeta)skull.getItemMeta();
	  if(!Main.Watch.contains(sm.getOwner()) && (!Main.Jogadores.contains(p.getName()) && (!CMDAdmin.admin.contains(p.getName())))) {
	  skull.setDurability((short)3);
	  sm.hasOwner();
	  sm.setOwner(players.getName());
	  sm.setDisplayName(players.getName());
	  List<String> lore = new ArrayList<String>();
	  final String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(players));
	  lore.add("§7Kit: §e" + KitName);
	  lore.add("§7Kills: §e" + CMDListener.getKs(players));
	  sm.setLore(lore);
	  skull.setItemMeta(sm);  
	  inv.addItem(new ItemStack[] { skull });
	  }
	  }
	  p.openInventory(inv);
	  }
	  }
	  }

	  
	  @EventHandler
	  public void onInteract(PlayerInteractEvent e) {
	  Player p = (Player)e.getPlayer();
	  if(Main.Watch.contains(p.getName())) {
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler
	  public void onPlayerChallenge(InventoryClickEvent evt) {
	  if ((evt.getCurrentItem() != null) && (evt.getCurrentItem().getItemMeta() != null)) {
	  ItemStack item = evt.getCurrentItem();
	  Player p = (Player)evt.getWhoClicked();
	  if (item.getType().equals(Material.SKULL_ITEM)) {
	  evt.setCancelled(true);
	  p.closeInventory();
	  for (Player players : Bukkit.getOnlinePlayers()) {
	  ItemMeta im = item.getItemMeta();
	  if (players.getName().equals(im.getDisplayName())) {
	  p.teleport(players);
	  }
	  }
	  }
	  }
	  }
	  
	  @EventHandler
	  public void onCheck(InventoryClickEvent e) {
	  Player p = (Player) e.getWhoClicked();
	  if(DamageMobs.contains(p.getName())) {
	  e.setCancelled(true);
	  p.sendMessage("§7[§a!§7] Você não pode pegar nada no modo §aEspectador!");
	  }
	  }

	  @EventHandler
	  public void onSummonGhast(CreatureSpawnEvent e) {
	  if(!(e.getCreatureType() == CreatureType.GHAST)) {
	  return;
	  } 
	  if((e.getCreatureType() == CreatureType.GHAST)) {
	  e.setCancelled(true);
	  }
	  }
	  
	  @EventHandler
	  public void onPlace(BlockPlaceEvent e) {
	  Player p = (Player)e.getPlayer();
	  if(Main.Watch.contains(p.getName())) {
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler
	  public void CommandPartida(final PlayerCommandPreprocessEvent event) {
	  Player p = event.getPlayer();
	  if ((Main.Watch.contains(p.getName())) && (event.getMessage().contains("/kit"))) {
	  p.sendMessage("§7[§a!§7] Desculpe mas você não pode pegar um kit como §aEspectador!");
	  event.setCancelled(true);
	  return;
	  }
	  }

	  //@EventHandler
	  //public void onChat(PlayerChatEvent e) {
      //Player p = e.getPlayer();
	  //if(Main.Watch.contains(p.getName())) {
	  //e.setCancelled(true);
	  //p.sendMessage("§7[§a!§7] §aEspectadores não podem falar!");
	  //return;
	  //}
	  //}
	  
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void onEntityTarget(EntityTargetEvent event) {
	  if ((event.getTarget() != null) && (event.getTarget().getType() == EntityType.PLAYER)) {
	  Player player = (Player)event.getTarget();
	  if ((Main.Watch.contains(player.getName())) && (!event.isCancelled())) {
	  EntityType type = event.getEntity().getType();
	  if ((type == EntityType.ENDERMAN) || (type == EntityType.WOLF) || (type == EntityType.PIG_ZOMBIE) || (type == EntityType.BLAZE) || (type == EntityType.CAVE_SPIDER) || (type == EntityType.CREEPER) || (type == EntityType.GHAST) || (type == EntityType.MAGMA_CUBE) || (type == EntityType.SILVERFISH) || (type == EntityType.SKELETON) || (type == EntityType.SLIME) || (type == EntityType.SPIDER) || (type == EntityType.WITCH) || (type == EntityType.WITHER_SKULL) || (type == EntityType.ZOMBIE) || (type == EntityType.IRON_GOLEM) || (type == EntityType.ENDER_DRAGON) || (type == EntityType.WITHER)) {
	  event.setCancelled(true);
	  }
	  }
	  }
	  }

	  @EventHandler
	  public void onFood(FoodLevelChangeEvent e) {
	  Player p = (Player)e.getEntity();
	  if(Main.Watch.contains(p.getName())) {
	  e.setFoodLevel(20);
	  }
	  }
	  
	  @EventHandler()
	  public void EntityDamageMobs(EntityDamageByEntityEvent event){
	  if(!(event.getEntity() instanceof Player)) {
	  return;
	  }
	  Player player = (Player)event.getEntity();
	  if(event.getEntity() instanceof LightningStrike) {
      if(Habilidade.getAbility(player).equalsIgnoreCase("thor")) {
      event.setDamage(0.0D);
      } else {
      event.setDamage(5.0D);
      }
	  }
	  }
	  
      @EventHandler
	  public void CancelarKit(PlayerCommandPreprocessEvent event) {
	  if(Main.Watch.contains(event.getPlayer())) {
	  if (event.getMessage().toLowerCase().startsWith("/kit ")) {
	  event.setCancelled(true);
	  return;
	  }
	  }
	  }
	  
	  @EventHandler
	  public void onPlace(PlayerPickupItemEvent e) {
	  Player p = (Player)e.getPlayer();
	  if(Main.Watch.contains(p.getName())) {
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler(priority = EventPriority.MONITOR)
	  public void OnDamagePlayer(EntityDamageByEntityEvent e) {
      if(e.getEntity() instanceof Player) {
      return;
      }
      if(e.getDamager() instanceof Player) {
      return;
      }
      if(Main.Watch.contains(e.getEntity())) {
      e.setCancelled(true);
      return;
      }
      if(Main.Watch.contains(e.getDamager())) {
      e.setCancelled(true);
      return;
      }
	  }
 	 
	  @EventHandler
	  public void onDrop(PlayerDropItemEvent e) {
	  Player p = e.getPlayer();
	  if(Main.Watch.contains(p.getName())) {
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler
	  public void onDamage(EntityDamageEvent e) {
	  if(!(e.getEntity() instanceof Player)) {
	  return;
	  }
	  Player p = (Player)e.getEntity();
	  if(Main.Watch.contains(p.getName())) {
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler
	  public void onDamagePlayer(EntityDamageByEntityEvent e) {
	  if(!(e.getEntity() instanceof Player)) {
	  return;
	  }
	  if(!(e.getDamager() instanceof Player)) {
	  return;
	  }
      Player Recebeu = (Player)e.getEntity();
      Player Hitou = (Player)e.getDamager();
	  if(Main.Watch.contains(Recebeu.getName())) {
	  e.setCancelled(true);
	  return;
	  }
	  if(Main.Watch.contains(Hitou.getName())) {
	  e.setCancelled(true);
	  return;
	  }
	  }
	  
	  @EventHandler
	  public void onDamage(EntityDamageByEntityEvent e) {
	  if(Main.Watch.contains(e.getEntity())) {
	  e.setCancelled(true);
	  }
	  if(Main.Watch.contains(e.getDamager())) {
	  e.setCancelled(true);
	  }
	  }
	  
	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent event) {
	  Player p = event.getPlayer();
	  for (int i = 0; i < 3; i++) {
	  List<?> entities = p.getNearbyEntities(i, i, i);
	  for (final Object e : entities)
	  if ((((Entity) e).getType().equals(EntityType.PLAYER)) && (Main.Watch.contains(p.getName()))) {
	  if(p.hasPermission("HungerGames.c.Admin")) {
	  return;
	  }
	  if(CMDMiniArena.MiniArena) {
	  return;
	  }
	  if (!((Player)e).isDead()) {
	  p.teleport(p.getLocation().add(0.0D, 2.5D, 0.0D));
	  p.sendMessage("§7[§a!§7] Você não pode se aproximar de §a" + (((Player)e)).getName());
	  p.setAllowFlight(true);
	  p.setFlying(true);
	  return;
	  }
	  }
	 }
    }
}