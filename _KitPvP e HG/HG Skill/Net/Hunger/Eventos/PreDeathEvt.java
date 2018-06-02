package Net.Hunger.Eventos;

import java.util.Random;

import net.minecraft.server.v1_7_R4.EnumClientCommand;
import net.minecraft.server.v1_7_R4.PacketPlayInClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.EspectadoresManager;
import Net.Hunger.Manager.Habilidade;

public class PreDeathEvt
  implements Listener
{
	
  @EventHandler
  public void onRespawnRenove(PlayerDeathEvent e)
  {
    final Player p = e.getEntity();
    if (p.isDead()) {
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
          ((CraftPlayer)p).getHandle().playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
        }
      }, 15L);
    }
  }
  
  @EventHandler
  public void onDeathCheck(PlayerDeathEvent e) {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
      public void run() {
      ChecarVitoria.verificaWin();
      }
    }, 35L);
  }
  
  @EventHandler
  public void Respawn(PlayerRespawnEvent e)
  {
    final Player p = e.getPlayer();
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
    {
      public void run()
      {
        Bukkit.getServer().getWorld("world");
        Random random = new Random();
        Location teleportLocation = null;
        int x = random.nextInt(350) + 1;
        int y = 150;
        int z = random.nextInt(350) + 1;
        boolean isOnLand = false;
        while (!isOnLand)
        {
          teleportLocation = new Location(p.getWorld(), x, y, z);
          if (teleportLocation.getBlock().getType() != Material.AIR) {
            isOnLand = true;
          } else {
            y--;
          }
        }
        p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1.0D, teleportLocation.getZ()));
        p.setHealth(20.0D);
        p.setFoodLevel(20);
        p.setSaturation(75);
        p.setNoDamageTicks(160);
        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 3));
      }
    }, 10L);
  }
  
  @EventHandler
  public void onRespawn(PlayerDeathEvent e) {
    final Player p = e.getEntity();
    if ((p.hasPermission("HungerGames.Respawn")) && (Main.Andamento <= 300)) {
      ChecarVitoria.verificaWin();
      p.setGameMode(GameMode.SURVIVAL);
      p.getInventory().clear();
      p.getInventory().addItem(new ItemStack(Material.COMPASS));
    } else if(p.hasPermission("HungerGames.c.admin") && (Main.Andamento >= 300)) {
    Main.Watch.remove(p.getName());
    Main.Jogadores.remove(p.getName());
    Habilidade.removeAbility(p);
    p.chat("/admin");
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
    public void run() {
    p.getInventory().clear();
    }
    },5L);
    }
    else if ((Main.Andamento >= 300) && (p.hasPermission("HungerGames.c.Watch"))) {
      Main.Watch.add(p.getName());
      EspectadoresManager.DamageMobs.add(p);
      Main.Jogadores.remove(p.getName());
      
      p.getInventory().clear();
      
      p.sendMessage("§7[§a!§7] §aVocê morreu!");
      p.sendMessage("§7[§a!§7] Agora você esta no modo §aEspectador");
      p.sendMessage("§7[§a!§7] Use o comando §a/ir§7 para se teleportar!");
      p.setGameMode(GameMode.CREATIVE);

      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
      public void run() {
      
  	  ItemStack kit = new ItemStack(Material.SLIME_BALL);
  	  ItemMeta rkit = kit.getItemMeta();
  	  rkit.setDisplayName("§aMenu De Transporte.");
  	  kit.setItemMeta(rkit);
  	  p.getInventory().setItem(4, kit);
      
      }
      },5L);
      ChecarVitoria.verificaWin();
      Habilidade.removeAbility(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
      public void run() {
      for (Player hids : Bukkit.getOnlinePlayers()) {
      hids.hidePlayer(p);
      p.setAllowFlight(true);
      p.setFlying(true);
      }
      }
     },5L);
    }
    else
    {
      p.kickPlayer("§a" + p.getName() + " §7Morreu!\n" + "§7Tente novamente em outro servidor!\n" + "§7Visite §a" + Main.site);
      Main.mortos.add(p.getName());
      Main.Jogadores.remove(p.getName());
      ChecarVitoria.verificaWin();
    }
  }
}
