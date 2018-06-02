package me.rafael.vinagre.KomboPvP.Listeners;



	import java.util.ArrayList;
	import org.bukkit.Bukkit;
	import org.bukkit.Server;
	import org.bukkit.entity.Player;

	public class Vanish
	{
	  public static ArrayList<Player> vanished = new ArrayList();
	  
	  public static void makeVanished(Player p)
	  {
	    Player[] arrayOfPlayer;
	    int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
	    for (int i = 0; i < j; i++)
	    {
	      Player player = arrayOfPlayer[i];
	      if (!player.getName().equals(p.getName())) {
	        player.hidePlayer(p);
	      }
	    }
	    if (!vanished.contains(p)) {
	      vanished.add(p);
	    }
	  }
	  
	  public static boolean isVanished(Player p)
	  {
	    return vanished.contains(p);
	  }
	  
	  public static void updateVanished()
	  {
	    Player[] arrayOfPlayer;
	    int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
	    for (int i = 0; i < j; i++)
	    {
	      Player p = arrayOfPlayer[i];
	      if (isVanished(p)) {
	        makeVanished(p);
	      } else {
	        makeVisible(p);
	      }
	    }
	  }
	  
	  public static void makeVisible(Player p)
	  {
	    Player[] arrayOfPlayer;
	    int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
	    for (int i = 0; i < j; i++)
	    {
	      Player player = arrayOfPlayer[i];
	      player.showPlayer(p);
	    }
	    if (vanished.contains(p)) {
	      vanished.remove(p);
	    }
	  }
	}
