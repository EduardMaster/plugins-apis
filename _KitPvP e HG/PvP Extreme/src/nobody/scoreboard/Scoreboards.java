package nobody.scoreboard;

import nobody.eventos.KitAPI;
import nobody.eventos.Money;
import nobody.main.Main;
import nobody.scoreboard.SimpleScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Scoreboards
  implements Listener
{
	

  @SuppressWarnings("deprecation")
  public static void iscoriboard(Player p)
  
  {
    int Matou = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
    int Morreu = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
    
    SimpleScoreboard iscori = new SimpleScoreboard(("§b§lExtreme§e§lKits"));
    iscori.add("§7     extreme-kits.tk");
    iscori.blankLine();
    iscori.add("  §bMatou: §e" + Matou);
    iscori.add("  §bMorreu: §e" + Morreu);
    iscori.add("  §bKS: §e" + p.getLevel());
    iscori.blankLine();
    iscori.add("  §bKit: §e" + KitAPI.getkit(p));
    iscori.add("  §bXP: §e" + Money.getMoney(p));
    iscori.blankLine();
    iscori.add("  §bJogadores: §e" + Bukkit.getServer().getOnlinePlayers().length + "§f/§f200");
    iscori.blankLine();
    iscori.add("  §7/score");
    iscori.add("§a§lextreme-kits.tk");
    iscori.blankLine();
    
    
    iscori.build();
    iscori.send(new Player[] {p});

  }
}