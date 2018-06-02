package me.recenthg.stark.Comandos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.recent.stark.Main;
import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

public class Skit implements CommandExecutor{
	
	List<String> sKIT = new ArrayList<String>();
	HashMap<String, ItemStack> items = new HashMap<String, ItemStack>();
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (!(sender instanceof Player)) {
	      Main.instance.getLogger().info("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
	      return true;
	    }
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("skit")) {
	      if (p.hasPermission("HungerGames.c.skit")) {
	        if (args.length > 0) {
	          if (args[0].equalsIgnoreCase("create")) {
	            if (args.length == 2) {
	              ItemStack[] is = p.getInventory().getContents();
	              ItemStack[] armor = p.getInventory().getArmorContents();
	              if (!Main.skit.containsKey(args[1])) {
	                Main.skit.put(args[1], is);
	                Main.armor.put(args[1], armor);
	                p.sendMessage("§a "+ args[1] + " §7Criado com sucesso");
	                Title.sendTitle(p, "§a! §fSkit Criado §a!");
	                Bukkit.getLogger().info(p.getName() + " Criou o kit " + args[1]);
	                return true;
	              }
	              p.sendMessage("§8\u276e§2§l!§8\u276f §7Este kit ja existe");
	              return true;
	            }
	            p.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /skit create <kit>");
	            return true;
	          }
	          if (args[0].equalsIgnoreCase("apply")) {
	            if (args.length == 2) {
	              if (Main.skit.containsKey(args[1])) {
	                for (Player online : Bukkit.getOnlinePlayers()) {
	                  if ((p != online) && (!Admin.admin.contains(p.getName()))) {
	                    online.sendMessage("§8\u276e§2§l!§8\u276f §7Kit §6" + args[1] + " §7foi aplicado com sucesso");
	                    online.getInventory().setContents((ItemStack[])Main.skit.get(args[1]));
	                    online.getInventory().setArmorContents((ItemStack[])Main.armor.get(args[1]));
	                    Bukkit.getLogger().info(p.getName() + "§7Aplicou o kit para todos jogadores");
	                  }
	                }
	                p.sendMessage("§8\u276e§2§l!§8\u276f §7Kit §6" + args[1] + " §7foi aplicado a todos os players com sucesso");
	                p.getInventory().setContents((ItemStack[])Main.skit.get(args[1]));
	                p.getInventory().setArmorContents((ItemStack[])Main.armor.get(args[1]));
	                return true;
	              }
	              p.sendMessage("§8\u276e§2§l!§8\u276f §7Este kit não existe");
	              return true;
	            }
	            if (args.length == 3) {
	              Player pl = Bukkit.getPlayer(args[2]);
	              if (pl != null) {
	                if (Main.skit.containsKey(args[1])) {
	                  pl.sendMessage("§8\u276e§2§l!§8\u276f §7Kit §6 " + args[1] + " §7foi aplicado com sucesso");
	                  if (pl != p) {
	                    p.sendMessage("§8\u276e§2§l!§8\u276f §7Kit §6 " + args[1] + " §7foi aplicado com sucesso em §a " + pl.getName());
	                  }
	                  pl.getInventory().setContents((ItemStack[])Main.skit.get(args[1]));
	                  pl.getInventory().setArmorContents((ItemStack[])Main.armor.get(args[1]));
	                  return true;
	                }
	                p.sendMessage("§8\u276e§2§l!§8\u276f §7Este kit não existe");
	                return true;
	              }
	            }
	            else {
	              p.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /skit apply <player> | all <kit>");
	              return true;
	            }
	          } else if (args[0].equalsIgnoreCase("remove")) {
	            if (args.length == 2) {
	              if (Main.skit.containsKey(args[1])) {
	                Main.skit.remove(args[1]);
	                Main.armor.remove(args[1]);
	                p.sendMessage("§8\u276e§2§l!§8\u276f §7Kit §6" + args[1] + " §7Removido com sucesso");

	                return true;
	              }
	              p.sendMessage("§8\u276e§2§l!§8\u276f §7Este kit nao existe");
	              return true;
	            }

	            p.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /skit remove <kit>");

	            return true;
	          }
	        }
	        else
	        {
	          p.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /skit §7(§aapply | create | remove§7)");
	          return true;
	        }
	      } else {
	    		p.sendMessage(Strings.semperm);
	        return true;
	      }
	    }
	    return false;
	  }
}