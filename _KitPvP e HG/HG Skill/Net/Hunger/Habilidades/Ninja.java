package Net.Hunger.Habilidades;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Ninja implements Listener {

  public HashMap<Player, Player> a = new HashMap<Player, Player>();
  public HashMap<Player, Long> b = new HashMap<Player, Long>();

  @EventHandler
  public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player)) && ((paramEntityDamageByEntityEvent.getEntity() instanceof Player))) {
      final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
      Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
      if((Habilidade.getAbility(localPlayer1).equalsIgnoreCase("ninja"))) {
        a.put(localPlayer1, localPlayer2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
          public void run() {
            BackPacker.cooldownbk.remove(localPlayer1);
          }
        }, 200L);
      }
    }
  }
  
  @EventHandler
  public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
  if(Main.Partida) {
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
            localPlayer1.sendMessage("§7[§a!§7] Teleportado");
            this.b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
          }
          else
          {
            localPlayer1.sendMessage("§7[§a?§7] O Ultimo player que voce bateu esta muito longe!");
          }
        }
        else {
          localPlayer1.sendMessage("§7[§a?§7] Aguarde §a" + str + " §7segundos para usar novamente ");
        }
      }
    }
  }
 }
}