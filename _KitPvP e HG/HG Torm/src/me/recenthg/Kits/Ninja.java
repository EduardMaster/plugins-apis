package me.recenthg.Kits;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;


public class Ninja implements Listener {

  public HashMap<Player, Player> a = new HashMap<Player, Player>();
  public HashMap<Player, Long> b = new HashMap<Player, Long>();
  public static HashMap<String, Long> cooldownbk = new HashMap<String, Long>();

  @EventHandler
  public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player)) && ((paramEntityDamageByEntityEvent.getEntity() instanceof Player))) {
      final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
      Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
      if((Habilidade.getAbility(localPlayer1).equalsIgnoreCase("ninja"))) {
        a.put(localPlayer1, localPlayer2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
          public void run() {
         cooldownbk.remove(localPlayer1);
          }
        }, 200L);
      }
    }
  }
  
  @EventHandler
  public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
  if(Main.estados == Estado.ANDAMENTO) {
    Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
    if ((paramPlayerToggleSneakEvent.isSneaking()) && ((Habilidade.getAbility(localPlayer1).equalsIgnoreCase("ninja")) && (this.a.containsKey(localPlayer1))))
    {
      Player localPlayer2 = (Player)this.a.get(localPlayer1);
      if ((localPlayer2 != null) && (!localPlayer2.isDead()))
      {
        String str = null;
        if (this.b.get(localPlayer1) != null)
        {
          long l = ((Long)this.b.get(localPlayer1)).longValue() - System.currentTimeMillis();
          DecimalFormat localDecimalFormat = new DecimalFormat("##");
          int i = (int)l / 1000;
          str = localDecimalFormat.format(i);
        }
        if ((this.b.get(localPlayer1) == null) || (((Long)this.b.get(localPlayer1)).longValue() < System.currentTimeMillis()))
        {
          if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 50.0D)
          {
            localPlayer1.teleport(localPlayer2.getLocation());
            localPlayer1.sendMessage("§a● §7Teleportado");
            this.b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
          }
          else
          {
            localPlayer1.sendMessage("§a● §7O Ultimo player que voce bateu esta muito longe");
          }
        }
        else {
          localPlayer1.sendMessage("§a● §7Aguarde §a" + str + " §7segundos para usar novamente");
        }
      }
    }
  }
 }
}