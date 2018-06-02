package Net.Hunger.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Eventos.DropItem;
import Net.Hunger.Manager.Habilidade;

public class Gladiator implements Listener {

  public static boolean generateGlass = true;
  public static HashMap<String, Location> oldl = new HashMap<String, Location>();
  public static HashMap<String, String> fighting = new HashMap<String, String>();
  public static HashMap<Integer, ArrayList<Location>> blocks = new HashMap<Integer, ArrayList<Location>>();
  public static HashMap<Player, Location> localizacao = new HashMap<Player, Location>();
  public static HashMap<Location, Block> bloco = new HashMap<Location, Block>();
  public static HashMap<Integer, String[]> players = new HashMap<Integer, String[]>();
  public static HashMap<String, Integer> tasks = new HashMap<String, Integer>();
  public static int nextID = 0;
  public static int id1;
  public static int id2;
  
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlace(BlockPlaceEvent e) {
	Player p = (Player)e.getPlayer();
    if(Habilidade.getAbility(p).equalsIgnoreCase("gladiator")) {
	if ((e.getItemInHand().getType() == Material.IRON_FENCE)) {
    e.setCancelled(true);
	}
	}
	}
	
  
  @EventHandler
  public void OnGladiatorKit(PlayerInteractEntityEvent event) {
    final Player p = event.getPlayer();
    if (!(event.getRightClicked() instanceof Player)) {
    return;
    }
    if(Main.Partida) {
    final Player r = (Player)event.getRightClicked();
    if ((p.getItemInHand().getType() == Material.IRON_FENCE) && ((Habilidade.getAbility(p).equalsIgnoreCase("gladiator")))) {
      event.setCancelled(true);
      Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 70, p.getLocation().getBlockZ());
      localizacao.put(p, loc);
      localizacao.put(r, loc);
      Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX() + 8, p.getLocation().getBlockY() + 73, p.getLocation().getBlockZ() + 8);
      Location loc3 = new Location(p.getWorld(), p.getLocation().getBlockX() - 8, p.getLocation().getBlockY() + 73, p.getLocation().getBlockZ() - 8);
      if ((fighting.containsKey(p.getName())) || (fighting.containsKey(r.getName()))) {
      event.setCancelled(true);
      p.sendMessage("§7[§a?§7] Você ja esta em uma arena Gladiator!");
      return;
      }
      Integer currentID = Integer.valueOf(nextID);
      nextID += 1;
      ArrayList<String> list = new ArrayList<String>();
      list.add(p.getName());
      list.add(r.getName());
      players.put(currentID, (String[])list.toArray(new String[1]));
      oldl.put(p.getName(), p.getLocation());
      oldl.put(r.getName(), r.getLocation());
      if (generateGlass) {
      List<Location> cuboid = new ArrayList<Location>();
      cuboid.clear();
      int bZ;
      for (int bX = -10; bX <= 10; bX++) {
      for (bZ = -10; bZ <= 10; bZ++) {
      for (int bY = -1; bY <= 10; bY++) {
      Block b = loc.clone().add(bX, bY, bZ).getBlock();
      if (!b.isEmpty()) {
      event.setCancelled(true);
      p.sendMessage("§7[§a?§7] Você não pode gerar sua arena emcima de blocos!");
      return;
      }
      if (bY == 10) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      } else if (bY == -1) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      }
      }
      }
      } for (Location loc1 : cuboid) {
      loc1.getBlock().setType(Material.GLASS);
      bloco.put(loc1, loc1.getBlock());
      }
      loc2.setYaw(135.0F);
      p.teleport(loc2);
      loc3.setYaw(-45.0F);
      r.teleport(loc3);
      p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
      r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
      p.sendMessage("§7[§a!§7] Voce desafiou um jogador! Voce tem 5 segundos de invencibilidade!");
      p.sendMessage("§7[§a!§7] Caso nao tenha nenhum vencedor depois de 4 minutos, voces serao teleportados!");
      r.sendMessage("§7[§a!§7] Voce foi desafiado! Voce tem 5 segundos de invencibilidade!");
      r.sendMessage("§7[§a!§7] Caso nao tenha nenhum vencedor depois de 4 minutos, voces serao teleportados!");
      fighting.put(p.getName(), r.getName());
      fighting.put(r.getName(), p.getName());
      id2 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
      public void run() {
      if ((Gladiator.fighting.containsKey(p.getName())) && (((String)Gladiator.fighting.get(p.getName())).equalsIgnoreCase(r.getName())) && (Gladiator.fighting.containsKey(r.getName())) && (((String)Gladiator.fighting.get(r.getName())).equalsIgnoreCase(p.getName()))) {
      p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
      r.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
      }
      }
      }, 2400L);
      id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
      public void run() {
      if ((Gladiator.fighting.containsKey(p.getName())) && (((String)Gladiator.fighting.get(p.getName())).equalsIgnoreCase(r.getName())) && (Gladiator.fighting.containsKey(r.getName())) && (((String)Gladiator.fighting.get(r.getName())).equalsIgnoreCase(p.getName()))) {
      Gladiator.fighting.remove(p.getName());
      Gladiator.fighting.remove(r.getName());
      p.teleport((Location)Gladiator.oldl.get(p.getName()));
      r.teleport((Location)Gladiator.oldl.get(r.getName()));
      Gladiator.oldl.remove(p.getName());
      Gladiator.oldl.remove(r.getName());
      p.sendMessage("§7[§a?§7] Nao houve nenhum vencedor, voce foi teleportado ao lugar anterior");
      r.sendMessage("§7[§a?§7] Nao houve nenhum vencedor, voce foi teleportado ao lugar anterior");
      Location loc = (Location)Gladiator.localizacao.get(p);
      List<Location> cuboid = new ArrayList<Location>();
      int bZ;
      for (int bX = -10; bX <= 10; bX++) {
      for (bZ = -10; bZ <= 10; bZ++) {
      for (int bY = -1; bY <= 10; bY++) {
      if (bY == 10) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      } else if (bY == -1) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      }
      }
      }
      } for (Location loc1 : cuboid) {
      loc1.getBlock().setType(Material.AIR);
      ((Block)Gladiator.bloco.get(loc1)).setType(Material.AIR);
      }
      }
      }
      }, 4800L);
      }
    }
   }
  }
  @SuppressWarnings("deprecation")
  @EventHandler
  public void onPlayerInteractGlad(PlayerInteractEvent e) {
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType() == Material.IRON_FENCE) && ((Habilidade.getAbility(p).equalsIgnoreCase("gladiator")))) {
  e.setCancelled(true);
  p.updateInventory();
  return;
  }
  }

  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlyaerInteract(final PlayerInteractEvent e) {
  if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && (e.getClickedBlock().getType() == Material.GLASS) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (fighting.containsKey(e.getPlayer().getName()))) {
   e.setCancelled(true);
   e.getClickedBlock().setType(Material.BEDROCK);
   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
    public void run() {
     if (Gladiator.fighting.containsKey(e.getPlayer().getName())) {
      e.getClickedBlock().setType(Material.GLASS);
      }
     }
    },100L);
   }
  }
  @SuppressWarnings("deprecation")
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlayerLeft(PlayerQuitEvent e) {
   Player p = e.getPlayer();
    if (fighting.containsKey(p.getName())) {
      Player t = Bukkit.getServer().getPlayer((String)fighting.get(p.getName()));
      fighting.remove(t.getName());
      fighting.remove(p.getName());
      Location old = (Location)oldl.get(t.getName());
      t.teleport(old);
      t.sendMessage("§7[§a!§7] O jogador §a" + p.getName() + "§7 deslogou");
      Bukkit.getScheduler().cancelTask(id1);
      Bukkit.getScheduler().cancelTask(id2);
      t.removePotionEffect(PotionEffectType.WITHER);
      Location loc = (Location)localizacao.get(p);
      List<Location> cuboid = new ArrayList<Location>();
      int bZ;
      for (int bX = -10; bX <= 10; bX++) {
      for (bZ = -10; bZ <= 10; bZ++) {
      for (int bY = -1; bY <= 10; bY++) {
      if (bY == 10) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      } else if (bY == -1) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      }
      }
      }
      } for (Location loc1 : cuboid) {
      loc1.getBlock().setType(Material.AIR);
      ((Block)bloco.get(loc1)).setType(Material.AIR);
      } for (Location loc1 : cuboid) {
      loc1.getBlock().setType(Material.AIR);
      ((Block)bloco.get(loc1)).setType(Material.AIR);
      } for (Location loc1 : cuboid) {
      loc1.getBlock().setType(Material.AIR);
      ((Block)bloco.get(loc1)).setType(Material.AIR);
      }
     }
    }
    
   @SuppressWarnings("deprecation")
   @EventHandler(priority=EventPriority.HIGHEST)
   public void onDeathGladiator(PlayerDeathEvent e) {
    Player p = e.getEntity();
    if (fighting.containsKey(p.getName())) {
      Player k = Bukkit.getServer().getPlayer((String)fighting.get(p.getName()));
      Location old = (Location)oldl.get(p.getName());
      k.teleport(old);
      p.getInventory().clear();
      k.sendMessage("§7[§a!§7] Voce Ganhou a batalha contra §a" + p.getName());
      Bukkit.getScheduler().cancelTask(id1);
      Bukkit.getScheduler().cancelTask(id2);
      k.removePotionEffect(PotionEffectType.WITHER);
      k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
      fighting.remove(k.getName());
      fighting.remove(p.getName());
      Location loc = (Location)localizacao.get(p);
      List<Location> cuboid = new ArrayList<Location>();
      cuboid.clear();
      int bZ;
      for (int bX = -10; bX <= 10; bX++) {
      for (bZ = -10; bZ <= 10; bZ++) {
      for (int bY = -1; bY <= 10; bY++) {
      if (bY == 10) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      } else if (bY == -1) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
      cuboid.add(loc.clone().add(bX, bY, bZ));
      }
      }
      }
      } for (Location loc1 : cuboid) {
      loc1.getBlock().setType(Material.AIR);
      ((Block)bloco.get(loc1)).setType(Material.AIR);
      }
      return;
    }
  }
}