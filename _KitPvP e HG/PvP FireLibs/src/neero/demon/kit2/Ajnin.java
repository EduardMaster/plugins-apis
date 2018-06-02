package neero.demon.kit2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class Ajnin implements Listener, CommandExecutor{
	  public static HashMap<Player, Player> a = new HashMap();
	  public static HashMap<Player, Long> b = new HashMap();
	  public static List<Player> cooldownbk = new ArrayList<Player>();

@EventHandler
public void a1(EntityDamageByEntityEvent paramEntityDamageByEntityEvent)
{
  if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player)) && ((paramEntityDamageByEntityEvent.getEntity() instanceof Player)))
  {
    final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
    Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
    if        (KitAPI.getkit2(localPlayer1) == "Ajnin") 
    {
      a.put(localPlayer1, localPlayer2);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          cooldownbk.remove(localPlayer1);
        }
      }, 200L);
    }
  }
}

/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 43 */     Player jogador = (Player)sender;
/* 44 */     if (label.equalsIgnoreCase("ajnin2")) {
/* 45 */       if (jogador.hasPermission("kit2.ajnin"))
/*    */       {
/* 4/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 49 */           jogador.sendMessage("§c§l§oVoce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 53 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 58 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*    */       }
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public void giveKit(Player p)
/*    */   {
/* 69 */     p.sendMessage(ChatColor.GREEN + "Voce escolheu Ajnin Secundário! Pegue outro kit!");
			KitAPI.setKit2(p, "Ajnin");
			Scoreboard.iscoriboard(p);
/*    */   }
/*    */   

@EventHandler
public void a1(PlayerToggleSneakEvent paramPlayerToggleSneakEvent)
{
  Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
  if ((paramPlayerToggleSneakEvent.isSneaking()) &&  (KitAPI.getkit2(localPlayer1) == "Ajnin") && (a.containsKey(localPlayer1)))
  {
    Player localPlayer2 = (Player)a.get(localPlayer1);
    if ((localPlayer2 != null) && (!localPlayer2.isDead()))
    {
      String str = null;
      if (b.get(localPlayer1) != null)
      {
        long l = ((Long)b.get(localPlayer1)).longValue() - System.currentTimeMillis();
        DecimalFormat localDecimalFormat = new DecimalFormat("##");
        int i = (int)l / 1000;
        str = localDecimalFormat.format(i);
      }
      if ((b.get(localPlayer1) == null) || (((Long)b.get(localPlayer1)).longValue() < System.currentTimeMillis()))
      {
        if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D)
        {
          localPlayer2.teleport(localPlayer1.getLocation());
          localPlayer1.sendMessage("§7» §aTeleportado");
          b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
        }
      }
      else {
        localPlayer1.sendMessage("§7» §aVoce esta em cooldown de §6" + str + " §asegundos");
      }
    }
  }
}
}
