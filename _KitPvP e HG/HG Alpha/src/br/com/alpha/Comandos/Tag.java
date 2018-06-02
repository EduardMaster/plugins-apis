package br.com.alpha.Comandos;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Tag implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (a.equalsIgnoreCase("tag")) {
			if (args.length == 0) {
				if (p.hasPermission("tag.dono")) {
					p.sendMessage(
							"§7Suas tags: §7Default §7| §a§lBeta §7| §bYoutuber  §7| §3YoutuberPLUS  §7| §aBasic §7| §9Master §7| §6Supremo §7| §dTrial §7| §5Mod §7| §5§lModPlus §7| §cAdmin §7| §4§lAdmin+ §7| §4§lDev §7| §4§l§oDono");
				} else if (p.hasPermission("tag.admin")) {
					p.sendMessage(
							"§7Suas tags: §7Default §7| §a§lBeta §7| §bYoutuber  §7| §b§lYoutuberPLUS  §7| §aBasic §7| §9Master §7| §6Supremo §7| §dTrial §7| §5Mod §7| §5§lModPlus §7| §cAdmin");
				} else if (p.hasPermission("tag.youtuber")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §bYoutuber");
				} else if (p.hasPermission("tag.youtuberplus")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §3YoutuberPLUS");
				} else if (p.hasPermission("tag.admin+")) {
					p.sendMessage(
							"§7Suas tags: §fDefault §7| §aBasic §7| §9Master §7| §6Supremo §7| §5Mod §7| §5§lModPlus §7| §cAdmin §7| §cAdmin+");
				} else if (p.hasPermission("tag.modplus")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §5§lModPlus");
				} else if (p.hasPermission("tag.mod")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §5Mod");
				} else if (p.hasPermission("tag.master")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §aBasic §7| §9Master");
				} else if (p.hasPermission("tag.supremo")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §aBasic §7| §9Master §7| §6Supremo");
				} else if (p.hasPermission("tag.basic")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §aBasic");
				} else if (p.hasPermission("tag.trial")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §dTrialMod");
				} else if (p.hasPermission("tag.beta")) {
					p.sendMessage("§7Suas tags: §fDefault §7| §a§lBeta");
				} else {
					p.sendMessage("§7Suas tags: §fDefault");
				}
				return true;

			}

			if (args[0].equalsIgnoreCase("default")) {

				p.setDisplayName("§7" + p.getName());
				p.setPlayerListName("§7" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §7Default");

			}
			if (args[0].equalsIgnoreCase("dev")) {
				if (!p.hasPermission("tag.dev")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§4§l§o<DEV> §4§o§l" + p.getName());
				p.setPlayerListName("§4§l§o" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §4§lDEVELOPER");

			}
			if (args[0].equalsIgnoreCase("youtuberplus")) {
				if (!p.hasPermission("tag.youtuberplus")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§3" + p.getName());
				p.setPlayerListName("§3" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §3§lYOUTUBERPLUS");

			}
			if (args[0].equalsIgnoreCase("youtuber")) {
				if (!p.hasPermission("tag.youtuber")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§b" + p.getName());
				p.setPlayerListName("§b" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §b§lYOUTUBER");

			}
			if (args[0].equalsIgnoreCase("master")) {
				if (!p.hasPermission("tag.master")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§9" + p.getName());
				p.setPlayerListName("§9" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §9§lMASTER");

			}
			if (args[0].equalsIgnoreCase("supremo")) {
				if (!p.hasPermission("tag.supremo")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§6" + p.getName());
				p.setPlayerListName("§6" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §6§lSUPREMO");

			}
			if (args[0].equalsIgnoreCase("basic")) {
				if (!p.hasPermission("tag.basic")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§a" + p.getName());
				p.setPlayerListName("§a" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §a§lBASIC");

			}
			if (args[0].equalsIgnoreCase("beta")) {
				if (!p.hasPermission("tag.beta")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName(ChatColor.RESET + p.getName());
				p.setDisplayName("§2§l" + p.getName());
				p.setPlayerListName("§2" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §2§lBeta");

			}
			if (args[0].equalsIgnoreCase("trial")) {
				if (!p.hasPermission("tag.trial")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§d" + p.getName());
				p.setPlayerListName("§d" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §d§lTRIAL");

			}
			if (args[0].equalsIgnoreCase("mod")) {
				if (!p.hasPermission("tag.mod")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§5" + p.getName());
				p.setPlayerListName("§5" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §5§lMod");

			}
			if (args[0].equalsIgnoreCase("modplus")) {
				if (!p.hasPermission("tag.modplus")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§5§l" + p.getName());
				p.setPlayerListName("§5§l" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §5§lModPlus");

			}
			if (args[0].equalsIgnoreCase("adminplus")) {
				if (!p.hasPermission("tag.admin+")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§4§l§o<ADMIN+> §4§l§o" + p.getName());
				p.setPlayerListName("§4§l§o" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §c§lADMIN+");

			}
			if (args[0].equalsIgnoreCase("admin")) {
				if (!p.hasPermission("tag.admin")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§c" + p.getName());
				p.setPlayerListName("§c" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §c§lADMIN");

			}
			if (args[0].equalsIgnoreCase("dono")) {
				if (!p.hasPermission("tag.dono")) {
					p.sendMessage("Sem permissão!");
					return true;
				}

				p.setDisplayName("§4§l§o<DONO> §4§l§o" + p.getName());
				p.setPlayerListName("§4§l§o" + p.getName());
				p.sendMessage("§aVocê alterou sua tag para: §4§lDONO");

			}
		}
		return false;
	}

}

