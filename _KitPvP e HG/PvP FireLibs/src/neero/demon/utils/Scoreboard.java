package neero.demon.utils;


import neero.demon.eventos.Dinheiro;
import neero.demon.eventos.KitAPI;
import neero.demon.eventos.Ranks;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Scoreboard
  implements Listener
{
	public static void iscoriboard(Player p)
  
  {
    
    SimpleScoreboard iscori = new SimpleScoreboard("§c§mDECOMPILADO");
    iscori.blankLine();
    iscori.add(" §fKit Primario:§a " + KitAPI.getkit(p));
    iscori.add(" §fKit Secundario:§a " + KitAPI.getkit2(p));
    iscori.blankLine();
    iscori.add(" §fClan:§7 [NENHUM]");
    iscori.add(" §fLiga: " + Ranks.getRank(p));
    iscori.add(" §f“”Coins:§a " + Dinheiro.getMoney(p));
    iscori.blankLine();
    iscori.add(" §7/serverinfo");
    iscori.add(" §7N.E.R.O.D.E.C");
    iscori.blankLine();
    
    iscori.build();
    iscori.send(new Player[] { p });
    
    
    
  }
 
}
