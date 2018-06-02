package br.com.alpha.Comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import br.com.alpha.MCAlpha;
 
public class Skit implements Listener, CommandExecutor {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, ItemStack[]> kits = new HashMap();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, ItemStack[]> armor = new HashMap();

	public boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} 
		catch (NumberFormatException localNumberFormatException) {
		}
		return false;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {

			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("Skit")) && ((p.hasPermission("stell.skit")) || (p.isOp()))) {
			if (args.length == 0) {
				p.sendMessage("§b-Como Criar um Kit-");
				p.sendMessage("§41º §8- §7§oMonte seu Inventario da maneira como quer que os Players Recebam!");
				p.sendMessage("§42º §8- §7§oDigite /Skit Criar [Nome]");
				p.sendMessage(" ");
				p.sendMessage("§b-Como Aplicar um Kit-");
				p.sendMessage("§41º §8- §7§oDigite /Skit Aplicar [Nome] [Raio]");
				p.sendMessage("§42º §8- §7§oO Nome deve ser do Kit criado anteriormente!");
				return true;
			}
			if (args[0].equalsIgnoreCase("Criar")) {
				if (args.length == 1) {
					p.sendMessage("§b-Como Criar um Kit-");
					p.sendMessage("§41º §8- §7§oMonte seu Inventario da maneira como quer que os Players Recebam!");
					p.sendMessage("§42º §8- §7§oDigite /Skit Criar [Nome]");
					return true;
				}
				String name = args[1];
				this.kits.put(name, p.getInventory().getContents());
				this.armor.put(name, p.getInventory().getArmorContents());
				p.sendMessage(ChatColor.GREEN + "Kit " + args[1] + " criado com sucesso!");
				return true;
			}
			if (args[0].equalsIgnoreCase("Aplicar")) {
				if (args.length <= 2) {
					p.sendMessage("§b-Como Aplicar um Kit-");
					p.sendMessage("§41º §8- §7§oDigite /Skit Aplicar [Nome] [Raio]");
					p.sendMessage("§42º §8- §7§oO Nome deve ser do Kit criado anteriormente!");
					return true;
				}
				String name = args[1];
				if ((!this.kits.containsKey(name)) && (!this.armor.containsKey(name))) {
					p.sendMessage(ChatColor.RED + "Kit " + name + " nao encontrado!");
					return true;
				}
				if (isInt(args[2])) {
					int numero = Integer.parseInt(args[2]);
					for (Entity ent : p.getNearbyEntities(numero, numero, numero)) {
						if ((ent instanceof Player)) {
							Player plr = (Player) ent;
							plr.getInventory().setArmorContents((ItemStack[]) this.armor.get(name));
							plr.getInventory().setContents((ItemStack[]) this.kits.get(name));
						}
					}
					Bukkit.getServer().broadcastMessage(MCAlpha.Logo + " §c§oO Kit " + "§3" + name + "§c§o" + " Aplicado para Players em um Raio de " + "§3" + numero + "§c§o" + " Blocos");
					return true;
				}
				return true;
			}
		}
		return true;
	}
}
