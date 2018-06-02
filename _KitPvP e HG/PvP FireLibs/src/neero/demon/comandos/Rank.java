package neero.demon.comandos;

import neero.demon.eventos.Ranks;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rank implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(label.equalsIgnoreCase("ranks")){
		Player p = (Player) sender;
		p.playSound(p.getLocation(), Sound.BLAZE_HIT, 10.0F, 10.0F);
		p.sendMessage("§4§lRANKS:");
		p.sendMessage("§f§lUNRANKED: §70 §6§LKILLS");
		p.sendMessage("§f§lNOOB: §750 §6§LKILLS");
		p.sendMessage("§f§lPRIMARY: §7200 §6§LKILLS");
		p.sendMessage("§e§lINTERMEDIARY: §7600 §6§LKILLS");
		p.sendMessage("§e§lADVANCED: §7800 §6§LKILLS");
		p.sendMessage("§e§lEXPERT: §71000 §6§LKILLS");
		p.sendMessage("§6§lBRONZE: §71200 §6§LKILLS");
		p.sendMessage("§6§lGOLD: §71400 §6§LKILLS");
		p.sendMessage("§c§lDIAMOND: §71600 §6§LKILLS");
		p.sendMessage("§c§lKING: §71800 §6§LKILLS");
		p.sendMessage("§4§lLEGENDARY: §72000 §6§LKILLS");
		p.sendMessage("");
		p.sendMessage("§7§lSEU RANK: " + Ranks.getRank(p));
		}
		return false;
	}
}
