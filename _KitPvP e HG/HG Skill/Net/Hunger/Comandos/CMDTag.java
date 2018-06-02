package Net.Hunger.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class CMDTag implements CommandExecutor {
  
  @EventHandler
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tag")) {
    if(args.length == 0) {
      if(p.hasPermission("*")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal, §aVip, §9Mvp, §6Pro, §bYoutuber, §3Dev, §dTrialMod, §5Mod, §cAdmin, §4Dono§7)");
       return true;  
      } else if(p.hasPermission("Tag.Admin")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal, §aVip, §9Mvp, §6Pro, §bYoutuber, §dTrialMod, §5Mod, §cAdmin§7)");
       return true;  
      } else if(p.hasPermission("Tag.Mod")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal, §aVip, §9Mvp, §6Pro, §bYoutuber, §dTrialMod, §5Mod§7)");
       return true;  
      } else if(p.hasPermission("Tag.TrialMod")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal, §aVip, §9Mvp, §6Pro, §bYoutuber, §dTrialMod§7)");
       return true;  
      } else if(p.hasPermission("Tag.Youtuber")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal, §aVip, §9Mvp, §6Pro, §bYoutuber§7)");
       return true;  
      } else if(p.hasPermission("Tag.Pro")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal, §aVip, §9Mvp, §6Pro§7)");
       return true;  
      } else if(p.hasPermission("Tag.Mvp")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal, §aVip, §9Mvp§7)");
       return true;  
      } else if(p.hasPermission("Tag.Vip")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal, §aVip§7)");  
       return true;
      } else if(p.hasPermission("Tag.Normal")) {
       p.sendMessage("§7[§a?§7] §aSuas tags: §7(§fNormal§7)");  
       return true;
      }
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("dono")) && (p.hasPermission("tag.dono")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§4" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§4§lDono §4" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("admin")) && (p.hasPermission("tag.admin")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§c" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§c§lADM §c" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("mod")) && (p.hasPermission("tag.mod")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§5" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§5§lMOD §5" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("dev")) && (p.hasPermission("tag.coder")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§3" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§3§lDEV §3" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("trialmod")) && (p.hasPermission("tag.trialmod")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§d" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§d§lTRIAL §d" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("youtuber")) && (p.hasPermission("tag.youtuber")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§b" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§b§lYT §b" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("pro")) && (p.hasPermission("tag.pro")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§6" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§6§lPRO §6" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("mvp")) && (p.hasPermission("tag.mvp")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§9" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§9§lMVP §9" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("vip")) && (p.hasPermission("tag.vip")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName("§a" + CMDListener.getMod(p.getName()));
      p.setDisplayName("§a§lVIP §a" + p.getName());
    }
    if ((args[0].toLowerCase().equalsIgnoreCase("normal")) && (p.hasPermission("tag.normal")))
    {
      p.sendMessage("§7[§a!§7] " + ChatColor.GRAY + "Parabens! sua tag foi alterada!");
      p.setPlayerListName(ChatColor.RESET + CMDListener.getMod(p.getName()));
      p.setDisplayName(ChatColor.RESET + p.getName());
    }
    return true;
  }
	return true;
 }
}