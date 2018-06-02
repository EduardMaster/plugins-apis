package nobody.eventos;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;


public class Chat implements Listener{
	
	  @EventHandler
	  public void onPlayerChatRank1(AsyncPlayerChatEvent e)
	  {
		  
	    Player p = e.getPlayer();
	    e.setFormat("§7[§f-§7] §7" + p.getDisplayName() + " §e» " + "§f" + "%2$s");
	  //First
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 100) {
	    	e.setFormat("§7[§f=§7] §7" + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	    	//Noob
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 200) {
	      e.setFormat("§7[§f=§7] §7" + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //primary
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 300) {
	      e.setFormat("§7[§e☱§7] §7" + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //intermed
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 400) {
	      e.setFormat("§7[§e☳§7]§7 " + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //advance
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 500) {
	      e.setFormat("§7[§e☷§7]§7 " + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //expert
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 600) {
	      e.setFormat("§7[§6✶§7]§7 " + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //bronze
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 700) {
	      e.setFormat("§7[§6✷§7]§7 " + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //silver
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 800) {
	      e.setFormat("§7[§6✸§7]§7 " + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //gold
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 900) {
	      e.setFormat("§7[§c✹§7]§7 " + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //diamond
	    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 1000) {
		      e.setFormat("§7[§c✫§7]§7 " + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
		      //king
		    }
	    if (((Integer)MoneyRank.getKills(p)).intValue() >= 1100) {
	      e.setFormat("§7[§4✪§7]§7 " + p.getDisplayName() + " §e» " + ChatColor.WHITE + "%2$s");
	      //legendary
	    }
	  }
	  
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
	  {
	    if (!event.isCancelled())
	    {
	      Player player = event.getPlayer();
	      String cmd = event.getMessage().split(" ")[0];
	      HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
	      if (topic == null)
	      {
	        player.sendMessage("§eExtreme§fKits » §fComando Inexistente!");
	        player.playSound(player.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
	        event.setCancelled(true);
	      }
	    }
	  }
}