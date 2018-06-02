package Pedrao.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Pedrao.Main;

public class Tag
  implements Listener, CommandExecutor
{
  public Tag(Main main) {
	}

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("tag")))
    {
      Player p = (Player)sender;
      if (args.length == 0)
      {
        if (p.hasPermission("*"))
        {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §bc§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7,§9§lBUILDER§7,§d§lTRIAL§7,§5§lMOD§7,§c§lADM§7,§2§lSUBDONO§7,§4§lDONO§7,§A§lDEV§7.");
          return true;
        }
        if (p.hasPermission("tag.membro")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7.");
        }
        if (p.hasPermission("tag.vip")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7.");
        }
        if (p.hasPermission("tag.mvp")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7.");
        }
        if (p.hasPermission("tag.pro")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7.");
        }
        if (p.hasPermission("tag.tk")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK.");
        }
        if (p.hasPermission("tag.youtuber")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7.");
        }
        if (p.hasPermission("tag.builder")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7,§9§lBUILDER§7.");
        }
        if (p.hasPermission("tag.trial")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7,§9§lBUILDER§7,§d§lTRIAL§7.");
        }
        if (p.hasPermission("tag.mod")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7,§9§lBUILDER§7,§d§lTRIAL§7,§5§lMOD§7.");
        }
        if (p.hasPermission("tag.admin")) {
          p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7,§9§lBUILDER§7,§d§lTRIAL§7,§5§lMOD§7,§c§lADM§7.");
        }
        if (p.hasPermission("tag.subdono")) {
            p.sendMessage(Main.prefix + "§b»§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7,§9§lBUILDER§7,§d§lTRIAL§7,§5§lMOD§7,§c§lADM§7,§2§lSUBDONO§7.");
          }
        if (p.hasPermission("tag.dono")) {
          p.sendMessage(Main.prefix + "§bc§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7,§9§lBUILDER§7,§d§lTRIAL§7,§5§lMOD§7,§c§lADM§7,§4§lDONO§7.");
        }
        if (p.hasPermission("tag.DEV")) {
            p.sendMessage(Main.prefix + "§bc§7 Suas Tags: §7§lMEMBRO§7,§a§lVIP§7,§9§lMVP§7,§6§lPRO§7,§a§lTK,§b§YOUTUBER§7,§9§lBUILDER§7,§d§lTRIAL§7,§5§lMOD§7,§c§lADM§7,§2§lSUBDONO§7,§4§lDONO§7,§a§lDEV§7.");
          }
        return false;
      }
      if (args[0].equalsIgnoreCase("membro"))
      {
        if (p.hasPermission("tag.membro"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §7§lMEMBRO");
          p.setDisplayName("§7§lMEMBRO " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§7" + getShortStr(p.getName()) + ChatColor.WHITE);
          
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("vip"))
      {
        if (p.hasPermission("tag.vip"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §a§lVIP");
          p.setDisplayName("§a§lVIP§a " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§a" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("mvp"))
      {
        if (p.hasPermission("tag.mvp"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §9§lMVP");
          p.setDisplayName("§9§lMVP§9 " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§9" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("pro"))
      {
        if (p.hasPermission("tag.pro"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §6§lPRO");
          p.setDisplayName("§6§lPRO§6 " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§6" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("tk"))
      {
        if (p.hasPermission("tag.tk"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §a§lTK");
          p.setDisplayName("§a§lTK§a " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§a" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("youtuber"))
      {
        if (p.hasPermission("tag.youtuber"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §b§lYOUTUBER");
          p.setDisplayName("§b§lYOUTUBER§b " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§b" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("builder"))
      {
        if (p.hasPermission("tag.builder"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §9§lBUILDER");
          p.setDisplayName("§9§lBUILDER §9" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§9" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("trial"))
      {
        if (p.hasPermission("tag.trial"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §d§lTRIAL");
          p.setDisplayName("§d§lTRIAL §d" + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§d" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("mod"))
      {
        if (p.hasPermission("tag.mod"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §5§lMOD");
          p.setDisplayName("§5§lMOD§5 " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§5" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("admin"))
      {
        if (p.hasPermission("tag.admin"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §c§lADMIN");
          p.setDisplayName("§c§lADMIN§c " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§c" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("dono"))
      {
        if (p.hasPermission("tag.dono"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §4§lDONO");
          p.setDisplayName("§4§lDONO§4 " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§4" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("subdono"))
      {
        if (p.hasPermission("tag.subdono"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §1§lSUBDONO");
          p.setDisplayName("§1§lSubDONO§1 " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§1" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
      if (args[0].equalsIgnoreCase("dev"))
      {
        if (p.hasPermission("tag.dev"))
        {
          p.sendMessage(Main.prefix + "§7Utilizando Tag » §2§lDEV");
          p.setDisplayName("§a§lDEV§A " + p.getName() + ChatColor.WHITE);
          p.setPlayerListName("§a" + getShortStr(p.getName()) + ChatColor.WHITE);
          return true;
        }
        p.sendMessage(Main.prefix + Main.semperm);
      }
    }
    return false;
  }
  
  public static String getShortStr(String s)
  {
    if (s.length() == 16)
    {
      String shorts = s.substring(0, s.length() - 6);
      return shorts;
    }
    if (s.length() == 15)
    {
      String shorts = s.substring(0, s.length() - 5);
      return shorts;
    }
    if (s.length() == 14)
    {
      String shorts = s.substring(0, s.length() - 4);
      return shorts;
    }
    if (s.length() == 13)
    {
      String shorts = s.substring(0, s.length() - 4);
      return shorts;
    }
    if (s.length() == 12)
    {
      String shorts = s.substring(0, s.length() - 2);
      return shorts;
    }
    if (s.length() == 11)
    {
      String shorts = s.substring(0, s.length() - 1);
      return shorts;
    }
    return s;
  }
  
  @EventHandler
  public void aoEntrar(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    p.setDisplayName("§7§lMEMBRO " + p.getName() + ChatColor.WHITE);
    p.setPlayerListName("§7" + getShortStr(p.getName()) + ChatColor.WHITE);
  }
}
