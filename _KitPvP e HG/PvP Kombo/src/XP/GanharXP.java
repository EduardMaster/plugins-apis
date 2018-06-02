package XP;

import org.bukkit.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


import me.rafael.vinagre.KomboPvP.Listeners.KillsDeathsMoney;


public class GanharXP
  implements Listener
{
	/*     */ @EventHandler
	/*     */ public void onKill(PlayerDeathEvent e)
	/*     */ {
		/* 386 */ Player p = e.getEntity();
		/* 391 */ if ((p.getKiller() instanceof Player))
		/*     */ {
			/* 393 */ Player k = p.getKiller();
			/* 397 */ 
			XpM.removeMoney(p, 10);
			p.sendMessage(ChatColor.RED + "§4§lMORTE §7Voce Morreu Para: " + ChatColor.DARK_RED
					+ ChatColor.ITALIC + k.getName());
			Scoreboard.ScoreDoBasic.iscoriboard(k);
			KillsDeathsMoney.addDeaths(p, 1);
			KillsDeathsMoney.addKill(k, 1);
            
			/* 398 */ 
			XpM.addMoney(k, 50);
			k.sendMessage(ChatColor.RED + "§4§lKILL §7Voce Matou : " + ChatColor.DARK_GREEN
					+ ChatColor.ITALIC + p.getName()); 

			 
				
			Scoreboard.ScoreDoBasic.iscoriboard(k);
			Scoreboard.ScoreDoBasic.iscoriboard(p);
			/*     */ }
		/*     */ }
}