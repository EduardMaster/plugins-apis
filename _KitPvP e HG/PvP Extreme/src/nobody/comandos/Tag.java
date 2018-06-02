package nobody.comandos;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import ca.wacos.nametagedit.NametagAPI;

public class Tag
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("tag"))
    {
      Player p = (Player)sender;
      if (args.length == 0)
      {
        p.sendMessage("§c§lTags -> §f§lNORMAL §dULTIMATE §aLight §e§lSpro §6Premium §b§lYT §3§lYT+ §d§lTRIAL §3§lBUILDER §5§lMOD §c§lADMIN §4§lDONO §4§l§oAJD ");
        return true;
      }
      if (args[0].equalsIgnoreCase("Normal"))
      {
        if (p.hasPermission("tag.normal"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §f§lNormal");
          NametagAPI.setPrefix(p.getName(), "§7");
          p.setDisplayName("§7" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§7" + p.getName() + ChatColor.WHITE);
          
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      if (args[0].equalsIgnoreCase("evento"))
      {
        if (p.hasPermission("tag.evento"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §f§lEvento");
          NametagAPI.setPrefix(p.getName(), "§b§lEVENTO §b");
          p.setDisplayName("§2§lE§e§lV§0§lE§1§lN§4§lT§b§lO §2" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§2" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      
      else if (args[0].equalsIgnoreCase("pro"))
      {
        if (p.hasPermission("tag.pro"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §d§lULTIMATE");
          NametagAPI.setPrefix(p.getName(), "§d§lULTIMATE §d");
          p.setDisplayName("§d§lULTIMATE §d" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§d" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("Dono"))
      {
        if (p.hasPermission("tag.dono"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §4§lDONO");
          NametagAPI.setPrefix(p.getName(), "§4§lDONO §4");
          p.setDisplayName("§4§l§oDONO §4" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§4§o" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("light"))
      {
        if (p.hasPermission("tag.light"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §9§lLIGHT");
          NametagAPI.setPrefix(p.getName(), "§a§lLIGHT §a");
          p.setDisplayName("§a§lLIGHT §a" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§a" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("admin"))
      {
        if (p.hasPermission("tag.admin"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §c§lADMIN");
          NametagAPI.setPrefix(p.getName(), "§c§lADMIN §c");
          p.setDisplayName("§c§lADMIN §c" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§c" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("mod"))
      {
        if (p.hasPermission("tag.mod"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §5§lMOD");
          NametagAPI.setPrefix(p.getName(), "§5§lMOD §5");
          p.setDisplayName("§5§lMOD §5" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§5" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("trial"))
      {
        if (p.hasPermission("tag.trial"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §5§lTRIAL");
          NametagAPI.setPrefix(p.getName(), "§5§lTRIAL §5");
          p.setDisplayName("§5§lTRIAL §5" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§5" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("premium"))
      {
        if (p.hasPermission("tag.premium"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §6Premium");
          NametagAPI.setPrefix(p.getName(), "§6§lPREMIUM §6");
          p.setDisplayName("§6§lPREMIUM §6" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§6" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("builder"))
      {
        if (p.hasPermission("tag.builder"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §3§lBUILDER");
          NametagAPI.setPrefix(p.getName(), "§3§lBUILDER §3");
          p.setDisplayName("§3§lBUILDER §3" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§3" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("coder"))
      {
        if (p.hasPermission("tag.coder"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §3§lCODER");
          NametagAPI.setPrefix(p.getName(), "§3§lDEV §3");
          p.setDisplayName("§3§lCODER §3" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§3" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("yt"))
      {
        if (p.hasPermission("tag.youtuber"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §b§lYT");
          NametagAPI.setPrefix(p.getName(), "§b§lYOUTUBER §b");
          p.setDisplayName("§b§lYOUTUBER §b" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§b" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("yt+"))
      {
        if (p.hasPermission("tag.yt+"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §3§l§oYT+");
          
          p.setDisplayName("§3§lYT+ §3" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§3§o" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVocê não possui esta tag!");
        }
      }
      else if (args[0].equalsIgnoreCase("AJD")) {
        if (p.hasPermission("tag.AJD"))
        {
          p.sendMessage("§7[§6§l!§7] Você alterou sua tag para §4§lAJD");
          NametagAPI.setPrefix(p.getName(), "§2§lAJD §2");
          p.setDisplayName("§2§lAJD §2" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§2§o" + p.getName() + ChatColor.WHITE);
        }
        else
        {
          p.sendMessage("§cVoce não possui esta tag!");
        }
      }
      return false;
    }
    return false;
  }
}
