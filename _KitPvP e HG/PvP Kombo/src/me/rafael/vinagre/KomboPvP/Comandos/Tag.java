package me.rafael.vinagre.KomboPvP.Comandos;



	import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
	import org.bukkit.command.CommandExecutor;
	import org.bukkit.command.CommandSender;
	import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Scoreboard.ScoreDoBasic;
import ca.wacos.nametagedit.NametagAPI;
import me.rafael.vinagre.KomboPvP.Listeners.TagLinda;

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
	        p.sendMessage(ChatColor.GREEN + "§7[Tags§7]-> " + "§fMembro §a* §aWinner §a* §aTK §a* §2Vip §a* §9Mvp §a* §6Pro §a* §eDivulgador §a* §2§nDzn §a* §eSemiYoutuber §a* §bYoutuber §a* §1Youtuber+ §a* §9Builder §a* §8Ajudante §a* §dTrialMod §a* §5Mod §a* §cAdmin §4§oSubDona §a* §4§oSubDono §a* §4§oDona §3Dev §a* §4§oDono");
	        return false;
	      }
	      if (args[0].equalsIgnoreCase("membro"))
	      {
	        if (p.hasPermission("tag.membro"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §7 Membro");
	          p.setDisplayName("§7§lMEMBRO§7 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§7" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§7");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      if (args[0].equalsIgnoreCase("divulgador"))
	      {
	        if (p.hasPermission("tag.divulgador"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §3 Divulgador");
	          p.setDisplayName("§e§lDIV§e " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§e" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§e[DIV] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      if (args[0].equalsIgnoreCase("winner"))
	      {
	        if (p.hasPermission("tag.winner"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §a Winner");
	          p.setDisplayName("§a§lWINNER§a " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§a" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§a[WINNER] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      if (args[0].equalsIgnoreCase("dzn"))
	      {
	        if (p.hasPermission("tag.dzn"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §2§o Designer");
	          p.setDisplayName("§2§lDZN§2 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§2§o" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§2[DZN] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("Vip"))
	      {
	        if (p.hasPermission("tag.Vip"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §2 Vip");
	          p.setDisplayName("§2§lVIP§2 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§2" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§2[VIP] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("subdona"))
	      {
	        if (p.hasPermission("tag.subdona"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §4 SubDona");
	          p.setDisplayName("§4§lSUBDONA§4 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§4" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§4[SUBDONA] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("subdono"))
	      {
	        if (p.hasPermission("tag.subdono"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §4 SubDono");
	          p.setDisplayName("§4§lSUBDONO§4 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§4" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§4[SUBDONO] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("Builder"))
	      {
	        if (p.hasPermission("tag.builder"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §9 Builder");
	          p.setDisplayName("§9§lBUILDER§9 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§9§o" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§9[BUILDER] ");
	          		
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("tk"))
	      {
	        if (p.hasPermission("tag.tk"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §a TK");
	          p.setDisplayName("§a§lTK§a " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§a§o" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§a[TK] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("pro"))
	      {
	        if (p.hasPermission("tag.pro"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §6 Pro");
	          p.setDisplayName("§6§lPRO§6 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§6" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§6[PRO] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("dev"))
	      {
	        if (p.hasPermission("tag.dev"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §9 Dev");
	          p.sendMessage(ChatColor.AQUA + "Quem fez o plugin foi o §azEnderX5_");
	          p.setDisplayName("§3§lDEV§3 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§3" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§3[DEV] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	  
	      else if (args[0].equalsIgnoreCase("youtuber"))
	      {
	        if (p.hasPermission("tag.youtuber"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §b Youtuber");
	          p.setDisplayName("§b§lYOUTUBER§b " + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§b[YT] ");
	          p.setPlayerListName("§b" + p.getName() + ChatColor.WHITE);
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("youtuber+"))
	      {
	        if (p.hasPermission("tag.youtuber+"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §1 Youtuber+");
	          p.setDisplayName("§1§lYOUTUBER+ §1" + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§1" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§1[YT+] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("trial"))
	      {
	      p.sendMessage(ChatColor.DARK_RED + "Use /tag trialmod");
	      }
	      else if (args[0].equalsIgnoreCase("semipro"))
	      {
	      p.sendMessage(ChatColor.DARK_RED + "Use /tag semiyoutuber");
	      }
	      else if (args[0].equalsIgnoreCase("coder"))
	      {
	      p.sendMessage(ChatColor.DARK_RED + "Use /tag dev");
	      }
	      else if (args[0].equalsIgnoreCase("trialmod"))
	      {
	        if (p.hasPermission("tag.trialmod"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §d TrialMod");
	          p.setDisplayName("§d§lTRIALMOD§d " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§d" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§d[TRIALMOD] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("mod"))
	      {
	        if (p.hasPermission("tag.mod"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §5 Mod");
	          p.setDisplayName("§5§lMOD§5 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§5" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§5[MOD] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("mvp"))
	      {
	        if (p.hasPermission("tag.mvp"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §9 Mvp");
	          p.setDisplayName("§9§lMVP§9 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§9" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§9[MVP] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("semiyoutuber"))
	      {
	        if (p.hasPermission("tag.semiyoutuber"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §e SemiYoutuber");
	          p.setDisplayName("§e§lSEMIYOUTUBER§e " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§e§o" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§e[SEMIYT] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("semiyt"))
	      {
	        if (p.hasPermission("tag.semiyoutuber"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §e SemiYoutuber");
	          p.setDisplayName("§e§lSEMIYT§e " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§e§o" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§e[SEMIYT] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      else if (args[0].equalsIgnoreCase("dona"))
	      {
	        if (p.hasPermission("tag.dona"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §e Dona");
	          p.setDisplayName("§4§lDONA§4 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§4" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§4[DONA] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	     
	      else if (args[0].equalsIgnoreCase("admin"))
	      {
	        if (p.hasPermission("tag.admin"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §c Admin");
	          p.setDisplayName("§c§lADMIN§c " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§c" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§c[ADM] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	    
	      else if (args[0].equalsIgnoreCase("ajudante")) {
	        if (p.hasPermission("tag.ajudante"))
	        {
	          p.sendMessage(ChatColor.AQUA + "Tag Alterada Para: §9 Ajudante");
	          p.setDisplayName("§9§lAJUDANTE§9 " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§9§o" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§9[AJD] ");
	        }
	        else
	        {
	          p.sendMessage(ChatColor.RED + "Voce nao tem essa Tag");
	        }
	      }
	      if (args[0].equalsIgnoreCase("dono"))
	      {
	        if (p.hasPermission("*"))
	        {
	          p.sendMessage(ChatColor.GRAY + "Utilizando Tag : " + ChatColor.DARK_RED + "Dono");
	          p.setDisplayName("§4§l§oDONO§4§o " + p.getName() + ChatColor.WHITE);
	          p.setPlayerListName("§4§o" + p.getName() + ChatColor.WHITE);
	          NametagAPI.setPrefix(p.getName(), "§4[DONO] ");
	          return true;
	        }
	        p.sendMessage(ChatColor.RED + "Voce nao tem permissao !");
	      }
	    }
	    return false;
	  
	  }
	  @EventHandler
	  public void aoEntrar(PlayerJoinEvent e)
	  {
	    Player p = e.getPlayer();
	    p.setDisplayName("§7§lMEMBRO§7 " + p.getName() + ChatColor.WHITE);
	    p.setPlayerListName("§7" + getShortStr(p.getName()) + ChatColor.WHITE);
	    NametagAPI.setPrefix(p.getName(), "§7");
	  }
	

	  
	  public static String getShortStr(String s)
	  {
	    if (s.length() == 25)
	    {
	      String shorts = s.substring(0, s.length() - 0);
	      return shorts;
	    }
	    if (s.length() == 24)
	    {
	      String shorts = s.substring(0, s.length() - 0);
	      return shorts;
	    }
	    if (s.length() == 23)
	    {
	      String shorts = s.substring(0, s.length() - 0);
	      return shorts;
	    }
	    if (s.length() == 22)
	    {
	      String shorts = s.substring(0, s.length() - 0);
	      return shorts;
	    }
	    if (s.length() == 21)
	    {
	      String shorts = s.substring(0, s.length() - 0);
	      return shorts;
	    }
	    if (s.length() == 20)
	    {
	      String shorts = s.substring(0, s.length() - 0);
	      return shorts;
	    }
	    return s;
	  }
	}
