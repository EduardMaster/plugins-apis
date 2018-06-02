package me.recenthg.Manager;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.recenthg.Main;
import me.recenthg.Utils.Estado;

public class PreDeathEvt
  implements Listener
{
  public static final String kick = null;


public static ArrayList<String> Respawn = new ArrayList<String>();
  @SuppressWarnings("unused")
private Player localPlayer;

  @EventHandler(priority=EventPriority.HIGHEST)
  public void onRespawnRenove(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (p.isDead())
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
        }
      }
      , 15L);
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void DamageMobs(PlayerDeathEvent e) {
    if (!(e.getEntity() instanceof LivingEntity)) {
      return;
    }
    if (Main.estados == Estado.INICIANDO);
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void onDeathCheck(PlayerDeathEvent e)
  {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
    {
      public void run()
      {
      }
    }
    , 35L);
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void Respawn(PlayerRespawnEvent e) {
    final Player p = e.getPlayer();
    if (Main.estados == Estado.ANDAMENTO)
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
        public void run() {
          Bukkit.getServer().getWorld("world");

          Location teleportLocation = null;
          int x = new Random().nextInt(5) + 30;
          int y = new Random().nextInt(5) + 90;
          int z = new Random().nextInt(5) + 30;
          boolean isOnLand = false;
          while (!isOnLand) {
            teleportLocation = new Location(p.getWorld(), x, y, z);
            if (teleportLocation.getBlock().getType() != Material.AIR)
              isOnLand = true;
            else {
              y--;
            }
          }
          
          p.setHealth(20.0D);
          p.setFoodLevel(20);
          p.setSaturation(75.0F);
          p.setNoDamageTicks(160);
          p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 3));
          p.getInventory().clear();
          p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
          DarItemDoKit.CheckKits(p);
          p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 4.0F, 4.0F);
        }
      }
      , 10L);
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void onRespawn(PlayerDeathEvent e) {
    if (Main.estados == Estado.INICIANDO) {
      return;
    }

    if (Main.estados == Estado.ANDAMENTO) {
      final Player p = e.getEntity();
      if ((p.hasPermission("Torm.Respawn")) && (Main.TimerAndamento <= 300)) {
        Win.verificaWin();
        p.setGameMode(GameMode.SURVIVAL);
        p.getInventory().clear();
        Respawn.add(p.getName());

        Bukkit.getServer().getWorld("world");
        Random random = new Random();
        Location teleportLocation = null;
        int x = random.nextInt(350) + 1;
        int y = 150;
        int z = random.nextInt(350) + 1;
        boolean isOnLand = false;
        while (!isOnLand) {
          teleportLocation = new Location(p.getWorld(), x, y, z);
          if (teleportLocation.getBlock().getType() != Material.AIR)
            isOnLand = true;
          else
            y--;
        }
      }
      else if ((Main.TimerAndamento >= 300) && (p.hasPermission("Torm.Espectar"))) {
        Main.Watch.add(p.getName());
        Espectadores.DamageMobs.add(p);
        Main.Jogadores.remove(p.getName());

        p.getInventory().clear();

        p.setGameMode(GameMode.SURVIVAL);

        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
          public void run() {
            ItemStack kit = new ItemStack(Material.CHEST);
            ItemMeta rkit = kit.getItemMeta();
            rkit.setDisplayName("§7Teleporte");
            kit.setItemMeta(rkit);
            p.getInventory().setItem(0, kit);
          }
        }
        , 5L);
        Win.verificaWin();
        Habilidade.removeAbility(p);
        p.chat("/admin");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          @SuppressWarnings("deprecation")
		public void run()
          {
            Player[] arrayOfPlayer;
            int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
            for (int i = 0; i < j; i++) {
              Player hids = arrayOfPlayer[i];

              hids.hidePlayer(p);
              p.setAllowFlight(true);
              p.setFlying(true);
            }
          }
        }
        , 5L);
      } else {
        p.kickPlayer("§e§lTorm§f§lHG§e§lTorm§f§lHG\n§cVoce morreu lutando contra " + p.getKiller().getName() + " (§7"+Habilidade.getAbility(p.getKiller())+"§c) Utilizando §e§l " + MensagenDeMorrer.NomeDosItens(p.getKiller().getItemInHand()));
        p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 4.0F, 4.0F);
        p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
        Main.mortos.add(p.getName());
        Main.Jogadores.remove(p.getName());
      }
    }
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void Morrer(PlayerDeathEvent e) {
    if (Main.estados == Estado.ANDAMENTO) {
      Player p = e.getEntity();
      if ((p.getKiller() instanceof Player))
          this.localPlayer = p.getKiller();
    }
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void Morrer2(PlayerDeathEvent e) {
    if (Main.estados == Estado.ANDAMENTO)
      this.localPlayer = e.getEntity();
  }

  @SuppressWarnings("unused")
@EventHandler(priority=EventPriority.HIGHEST)
  public void Morrera2(PlayerDeathEvent e)
  {
    if (Main.estados == Estado.INICIANDO) {
      Player p = e.getEntity();
      e.setDeathMessage(null);
    }
  }
}