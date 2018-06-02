package Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Main.Main;
import Utils.KitAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Gladiator
  implements Listener
{
  public static ArrayList<String> gladgladiator = new ArrayList<>();
  public boolean generateGLASS = true;
  public HashMap<String, Location> oldl = new HashMap<>();
  public static HashMap<String, String> lutando = new HashMap<>();
  public HashMap<Integer, ArrayList<Location>> blocks = new HashMap<>();
  public HashMap<Player, Location> localizacao = new HashMap<>();
  public HashMap<Location, Block> bloco = new HashMap<>();
  public HashMap<Integer, String[]> players = new HashMap<>();
  public HashMap<String, Integer> tasks = new HashMap<>();
  int nextID = 0;
  public int id1;
  public int id2;
  
  @EventHandler
  public void OnGladiatorKit(PlayerInteractEntityEvent event)
  {
    final Player p = event.getPlayer();
    if ((event.getRightClicked() instanceof Player))
    {
      final Player r = (Player)event.getRightClicked();
      if ((p.getItemInHand().getType() == Material.IRON_FENCE) && (KitAPI.getKit(p) == "Gladiator"))
      {
        Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 70, p.getLocation().getBlockZ());
        this.localizacao.put(p, loc);
        this.localizacao.put(r, loc);
        Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX() + 8, p.getLocation().getBlockY() + 73, p.getLocation().getBlockZ() + 8);
        Location loc3 = new Location(p.getWorld(), p.getLocation().getBlockX() - 8, p.getLocation().getBlockY() + 73, p.getLocation().getBlockZ() - 8);
        if ((lutando.containsKey(p.getName())) || (lutando.containsKey(r.getName())))
        {
          event.setCancelled(true);
          p.sendMessage(ChatColor.RED + "§c§lFly§7§lTrue§a: §7Voce ja esta em combate!");
          return;
        }
        Integer currentID = Integer.valueOf(this.nextID);
        this.nextID += 1;
        ArrayList<String> list = new ArrayList<>();
        list.add(p.getName());
        list.add(r.getName());
        this.players.put(currentID, (String[])list.toArray(new String[1]));
        this.oldl.put(p.getName(), p.getLocation());
        this.oldl.put(r.getName(), r.getLocation());
        if (this.generateGLASS)
        {
          List<Location> cuboid = new ArrayList<>();
          cuboid.clear();
          int bZ;
          for (int bX = -10; bX <= 10; bX++) {
            for (bZ = -10; bZ <= 10; bZ++) {
              for (int bY = -1; bY <= 10; bY++)
              {
                Block b = loc.clone().add(bX, bY, bZ).getBlock();
                if (!b.isEmpty())
                {
                  event.setCancelled(true);
                  p.sendMessage(ChatColor.RED + "§c§lFly§7§lTrue§a: §7 Voce nao pode criar sua arena aqui");
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
          }
          for (Location loc1 : cuboid)
          {
            loc1.getBlock().setType(Material.GLASS);
            this.bloco.put(loc1, loc1.getBlock());
          }
          loc2.setYaw(135.0F);
          p.teleport(loc2);
          loc3.setYaw(-45.0F);
          r.teleport(loc3);
          p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
          r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
          p.sendMessage(ChatColor.GREEN + "§c§lFly§7§lTrue§a: §7 Voce desafiou um jogador! Voce tem 5 segundos de invencibilidade!");
          p.sendMessage(ChatColor.AQUA + "§c§lFly§7§lTrue§a: §7 Caso nao tenha nenhum vencedor depois de 4 minutos, voce voltara ao seu local de origem!");
          r.sendMessage(ChatColor.RED + "§c§lFly§7§lTrue§a: §7 Voce foi desafiado! Voce tem 5 segundos de invencibilidade!");
          r.sendMessage(ChatColor.AQUA + "§c§lFly§7§lTrue§a: §7 Caso nao tenha nenhum vencedor depois de 4 minutos, voce voltara ao seu local de origem!");
          lutando.put(p.getName(), r.getName());
          lutando.put(r.getName(), p.getName());
          gladgladiator.add(p.getName());
          gladgladiator.add(r.getName());
          this.id2 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
          {
            public void run()
            {
              if ((Gladiator.lutando.containsKey(p.getName())) && (((String)Gladiator.lutando.get(p.getName())).equalsIgnoreCase(r.getName())) && (Gladiator.lutando.containsKey(r.getName())) && (((String)Gladiator.lutando.get(r.getName())).equalsIgnoreCase(p.getName())))
              {
                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
                r.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
              }
            }
          }, 2400L);
          this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
          {
            public void run()
            {
              if ((Gladiator.lutando.containsKey(p.getName())) && (((String)Gladiator.lutando.get(p.getName())).equalsIgnoreCase(r.getName())) && (Gladiator.lutando.containsKey(r.getName())) && (((String)Gladiator.lutando.get(r.getName())).equalsIgnoreCase(p.getName())))
              {
                Gladiator.lutando.remove(p.getName());
                Gladiator.lutando.remove(r.getName());
                gladgladiator.remove(p.getName());
                gladgladiator.remove(r.getName());
                p.teleport((Location)Gladiator.this.oldl.get(p.getName()));
                r.teleport((Location)Gladiator.this.oldl.get(r.getName()));
                Gladiator.this.oldl.remove(p.getName());
                Gladiator.this.oldl.remove(r.getName());
                p.sendMessage(ChatColor.RED + "§c§lFly§7§lTrue§a: §7 Nao houve nenhum vencedor, voce foi teleportado para o seu lugar de origem!");
                r.sendMessage(ChatColor.RED + "§c§lFly§7§lTrue§a: §7 Nao houve nenhum vencedor, voce foi teleportado para o seu lugar de origem!");
                Location loc = (Location)Gladiator.this.localizacao.get(p);
                List<Location> cuboid = new ArrayList<>();
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
                }
                for (Location loc1 : cuboid)
                {
                  loc1.getBlock().setType(Material.AIR);
                  ((Block)Gladiator.this.bloco.get(loc1)).setType(Material.AIR);
                }
              }
            }
          }, 4800L);
        }
      }
    }
  }
  
  @EventHandler
  public void onPlayerInteractGlad(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType() == Material.IRON_FENCE) && (KitAPI.getKit(p) == "Gladiator"))
    {
      e.setCancelled(true);
      p.updateInventory();
      return;
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onDrop(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType() == Material.IRON_FENCE) && (KitAPI.getKit(p) == "Gladiator"))
    {
      e.setCancelled(true);
      p.updateInventory();
      p.sendMessage("§c§lFly§7§lTrue§a: §7 §cVoce nao pode dropar este item!");
      return;
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlyaerInteract(final PlayerInteractEvent e)
  {
    if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && (e.getClickedBlock().getType() == Material.GLASS) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (lutando.containsKey(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getClickedBlock().setType(Material.BEDROCK);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          if (Gladiator.lutando.containsKey(e.getPlayer().getName())) {
            e.getClickedBlock().setType(Material.GLASS);
          }
        }
      }, 30L);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onBlockBreak(final BlockBreakEvent e)
  {
    if ((e.getBlock().getType() == Material.GLASS) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (lutando.containsKey(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getBlock().setType(Material.BEDROCK);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          if ((e.getPlayer().getGameMode() != GameMode.CREATIVE) && (Gladiator.lutando.containsKey(e.getPlayer().getName()))) {
            e.getBlock().setType(Material.GLASS);
          }
        }
      }, 30L);
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerLeft(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (lutando.containsKey(p.getName()))
    {
      Player t = Bukkit.getServer().getPlayer((String)lutando.get(p.getName()));
      lutando.remove(t.getName());
      lutando.remove(p.getName());
      gladgladiator.remove(p.getName());
      gladgladiator.remove(t.getName());
      Location old = (Location)this.oldl.get(t.getName());
      t.teleport(old);
      t.sendMessage(ChatColor.RED + "O jogador " + p.getName() + " deslogou-se!");
      Bukkit.getScheduler().cancelTask(this.id1);
      Bukkit.getScheduler().cancelTask(this.id2);
      t.removePotionEffect(PotionEffectType.WITHER);
      Location loc = (Location)this.localizacao.get(p);
      List<Location> cuboid = new ArrayList<>();
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
      }
      for (Location loc1 : cuboid)
      {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc1)).setType(Material.AIR);
      }
      for (Location loc1 : cuboid)
      {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc1)).setType(Material.AIR);
      }
      for (Location loc1 : cuboid)
      {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc1)).setType(Material.AIR);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onDeathGladiator(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (lutando.containsKey(p.getName()))
    {
      Player k = Bukkit.getServer().getPlayer((String)lutando.get(p.getName()));
      Location old = (Location)this.oldl.get(p.getName());
      k.teleport(old);
      k.sendMessage(ChatColor.GREEN + "§c§lFly§7§lTrue§a: §7 Voce ganhou a batalha contra " + p.getName() + ChatColor.GREEN + "!");
      Bukkit.getScheduler().cancelTask(this.id1);
      Bukkit.getScheduler().cancelTask(this.id2);
      k.removePotionEffect(PotionEffectType.WITHER);
      k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
      lutando.remove(k.getName());
      lutando.remove(p.getName());
      gladgladiator.remove(p.getName());
      gladgladiator.remove(k.getName());
      Location loc = (Location)this.localizacao.get(p);
      List<Location> cuboid = new ArrayList<>();
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
      }
      for (Location loc1 : cuboid)
      {
        loc1.getBlock().setType(Material.AIR);
        if (this.bloco.containsKey(loc1)) {
          ((Block)this.bloco.get(loc1)).setType(Material.AIR);
        }
      }
      return;
    }
  }
}
