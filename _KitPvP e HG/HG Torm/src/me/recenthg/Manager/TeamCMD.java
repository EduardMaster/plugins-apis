
package me.recenthg.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.recenthg.Main;

public class TeamCMD
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
              Player p = (Player)sender;
                if (label.equalsIgnoreCase("clan")) {
                    if (args.length == 0) {
                        p.sendMessage(Main.Menssagems + "Use /clan help para saber mais sobre clans!");
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("chat")) {
                        Team.in.add(p.getName());
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("chat")) {
                        if (Team.getClan(p) != "Nenhum") {
                            p.sendMessage(Main.Menssagems + "Voce ja tem nenhuma clan!");
                        } else {
                            Team.chat.add(p);
                            p.sendMessage((Object)ChatColor.GREEN + "Voce entrou no chat da Clan " + Team.args);
                        }
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("create")) {
                        if (args.length != 2) {
                            p.sendMessage(Main.Menssagems + "/clan create <nome>");
                            return true;
                        }
                        Team.times.add(args[1]);
                        Team.enterTime(p, args[1]);
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("leave")) {
                        Team.removeTime(p);
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("join")) {
                        if (args.length != 2) {
                            p.sendMessage(Main.Menssagems + "/clan join <nome>");
                            return true;
                        }
                        Player t = Bukkit.getPlayer(args[1]);
                        String clan = args[1];
                        if (Team.getClan(p) == "Nenhum") {
                        	p.sendMessage("§aAguarde...");
                        	t.sendMessage("§b§l» §7" + p.getName() + " que ser de sua clan !");
                        	t.sendMessage("§a§l» §aUtilize /clan aceitar para aceitar");
                        	t.sendMessage("§a§l» §aUtilize /clan cancelar para cancelar a solicitacao");
                        	if (args[1].equalsIgnoreCase("aceitar")) {
                        		if (Team.getClan(t) == args[1]) {
                        			Team.enterTime(p, clan);
                        		} 
                        	} else if (args[1].equalsIgnoreCase("cancelar")) {
                        		if (Team.getClan(t) == args[1]) {
                        			p.sendMessage("§cVoce nao foi aceito.");
                        		}
                        	}
                        } else {
                        	p.sendMessage("§cVoce ja e de uma clan !");
                        }
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("help")) {
                        p.sendMessage((Object)ChatColor.GREEN + "Use /clan create [nomedateam] para criar um time!");
                        p.sendMessage((Object)ChatColor.GREEN + "Use /clan join [nomedateam] para entrar em um time!");
                        p.sendMessage((Object)ChatColor.GREEN + "Use /clan leave para sair de um time!");
                        p.sendMessage((Object)ChatColor.GREEN + "Use /clan chat para entrar no chat do time!");
                    }
                }
        }
        
        return false;
    }
}

