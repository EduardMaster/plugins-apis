package XP;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.rafael.vinagre.KomboPvP.Main;

@SuppressWarnings("unused")
public class XpM
{
  public static MyConfig PlayerMoney;
  public static int defaultmoney = 0;
  
  public static void loadMoneyManager()
  {
    PlayerMoney = me.rafael.vinagre.KomboPvP.Main.manager.getNewConfig("XP.yml");
  }
  
  public static int getPlayerMoney(Player p)
  {
    return PlayerMoney.getInt(p.getUniqueId().toString());
  }
  
  public static void addMoney(Player p, int add)
  {
    PlayerMoney.set(p.getUniqueId().toString(), Integer.valueOf(getPlayerMoney(p) + add));
    PlayerMoney.saveConfig();
  }
  
  public static void removeMoney(Player p, int remove)
  {
    PlayerMoney.set(p.getUniqueId().toString(), Integer.valueOf(getPlayerMoney(p) - remove));
    PlayerMoney.saveConfig();
  }

public static void removeMoney(CommandSender p, int remove) {
	// TODO Auto-generated method stub
	
}

public static int getPlayerMoney(CommandSender p) {
	// TODO Auto-generated method stub
	return 0;
}
}
