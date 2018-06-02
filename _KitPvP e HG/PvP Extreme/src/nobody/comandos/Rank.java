package nobody.comandos;

import nobody.eventos.Money;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rank implements CommandExecutor {

	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if (cmd.getName().equalsIgnoreCase("rank"))
	    {
	      Player p = (Player)sender;
	      if (args.length == 0)
	      {
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("                                ");
				p.sendMessage("§a§oBem-Vindo a: §3§lSistema de §e§lRanks");
				p.sendMessage("                                ");
				p.sendMessage("§7§l- §fFIRST: 0");
				p.sendMessage("§7§l= §fNOOB: 200");
				p.sendMessage("§7☰ PRIMARY: 400");
				p.sendMessage("§e☱ INTERMEDIARY: 600");
				p.sendMessage("§e☳ ADVANCE: 800");
				p.sendMessage("§e☷ EXPERT: 1000");
				p.sendMessage("§6✶ BRONZE: 1200");
				p.sendMessage("§6✷ SILVER: 1400");
				p.sendMessage("§6✸ GOLD: 1600");
				p.sendMessage("§c✹ DIAMOND: 1800");
				p.sendMessage("§c✫ KING: 2000");
				p.sendMessage("§4✪ LEGENDARY: 2200");
				p.sendMessage("§aSeu XP: " + Money.getMoney(p));
				p.playSound(p.getLocation(), Sound.WOLF_HURT, 1.0F, 1.0F);
	        return true;
	      }
	        }
	      
	    
		return false;
	  }
	    }
